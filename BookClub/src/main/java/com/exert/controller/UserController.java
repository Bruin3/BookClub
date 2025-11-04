package com.exert.controller;

import com.exert.pojo.Books;
import com.exert.pojo.Collects;
import com.exert.pojo.Users;
import com.exert.service.BookService;
import com.exert.service.CollectService;
import com.exert.service.FileService;
import com.exert.service.UserService;
import com.exert.utils.ImageVO;
import com.exert.utils.JWTTokenUtil;
import com.exert.utils.result;
import com.exert.utils.usersPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller 调 service 层
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private BookService bookService;

    //有选择的返回用户
    @RequestMapping ("/findAll")
    @ResponseBody
    public String findAll(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize, @RequestParam String admin, @RequestParam String userId) throws JsonProcessingException {
        List<Users> list;
        if (admin.equals("2")){
            if (query == null){
                list = userService.queryAllUsers();
            }else {
                list = userService.queryUserByName(query);
            }
        } else {
            if (query == null){
                list = userService.queryUsersByAdmin(0);
            }else {
                list = userService.queryUserByNameAndAdmin(query, 0);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        usersPage up = new usersPage();
        List<Users> rlist = new ArrayList<>();
        int index = 0;
        for(Users user : list){
            if (index / pagesize == pagenum - 1){
                rlist.add(user);
            }
            index++;
        }
        up.setPagenum(pagenum);
        up.setTotal(list.size());
        up.setUsers(rlist);
        r.setCode(200);
        r.setMsg("返回用户");
        r.setData(mapper.writeValueAsString(up));
        return r.toString();
    };

    //返回所有用户
    @RequestMapping ("/findAllUsers")
    @ResponseBody
    public String findAllUsers(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize) throws JsonProcessingException {
        List<Users> list;
        if (query == null){
            list = userService.queryAllUsers();
        }else {
            list = userService.queryUserByName(query);
        }
        //list移除指定user
        list.removeIf(user -> user.getUserId() == 1);
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        usersPage up = new usersPage();
        List<Users> rlist = new ArrayList<>();
        int index = 0;
        for(Users user : list){
            if (index / pagesize == pagenum - 1){
                rlist.add(user);
            }
            index++;
        }
        up.setPagenum(pagenum);
        up.setTotal(list.size());
        up.setUsers(rlist);
        r.setCode(200);
        r.setMsg("返回用户");
        r.setData(mapper.writeValueAsString(up));
        return r.toString();
    };



    //通过UserId返回用户
    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        Users user = userService.queryUserByUserId(Integer.parseInt(map.get("userId")));
        ObjectMapper mapper = new ObjectMapper();
        r.setData(mapper.writeValueAsString(user));
        r.setCode(200);
        r.setMsg("查找成功");
        return r.toString();
    }

    //登陆
    @RequestMapping ("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        Users user = userService.login(map.get("username"),map.get("password"));
        ObjectMapper mapper = new ObjectMapper();
        String datajson = mapper.writeValueAsString(user);
        if (user == null){
            r.setCode(500);
            r.setMsg("登录失败");
        }
        else {
            r.setCode(200);
            r.setMsg("登陆成功");
            String token = JWTTokenUtil.token(map.get("username"));
            ObjectNode objectNode = (ObjectNode) mapper.readTree(datajson);
            objectNode.put("token", token);
            r.setData(objectNode.toString());
        }
        return r.toString();
    };

    //注册
    @RequestMapping ("/register")
    @ResponseBody
    public String register(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        String datajson = mapper.writeValueAsString(map);
        if (userService.judgeEmail(map.get("email"))){
            r.setCode(400);
            r.setMsg("该邮箱已存在！");
            return r.toString();
        }
        Users user = new Users(0,map.get("email"),map.get("password"),map.get("name"),map.get("sex"),0,map.get("motto"),null);
        userService.addUser(user);
        r.setCode(200);
        r.setMsg("注册成功！");
        return r.toString();
    }

    //更新用户
    @RequestMapping (value="/edit", method=RequestMethod.PUT)
    @ResponseBody
    public String edit(@RequestBody Map<String, String> map){
        result r = new result();
        if (userService.judgeEmailByUserId(map.get("email"), Integer.parseInt(map.get("userId")))){
            r.setCode(400);
            r.setMsg("该邮箱已存在！");
            return r.toString();
        }
        int admin = 0;
        if (map.get("admin").equals("管理员")){
            admin = 1;
        }
        if (map.get("admin").equals("超级管理员")){
            admin = 2;
        }
        String motto = map.get("motto");
        if(motto.substring(0,1).equals("\"") && motto.substring(motto.length() - 1).equals("\"")){
            motto = motto.substring(0,motto.length() - 1);
            motto = motto.substring(1);
        }
        Users user = new Users(Integer.parseInt(map.get("userId")),map.get("email"),map.get("password"),map.get("name"),map.get("sex"),admin,motto,userService.queryPasswordByUserId(Integer.parseInt(map.get("userId"))));
        userService.updateUser(user);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //更新用户（不包括密码）
    @RequestMapping (value="/save", method=RequestMethod.PUT)
    @ResponseBody
    public String save(@RequestBody Map<String, String> map){
        result r = new result();
        if (userService.judgeEmailByUserId(map.get("email"), Integer.parseInt(map.get("userId")))){
            r.setCode(400);
            r.setMsg("该邮箱已存在！");
            return r.toString();
        }
        String password = userService.queryPasswordByUserId(Integer.parseInt(map.get("userId")));
        Users user = new Users(Integer.parseInt(map.get("userId")),map.get("email"),password,map.get("name"),map.get("sex"),0,map.get("motto"),userService.queryAvatarByUserId(Integer.parseInt(map.get("userId"))));
        userService.updateUser(user);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //删除用户
    @RequestMapping ("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, String> map){
        int id = Integer.parseInt(map.get("userId"));
        result r = new result();
        userService.deleteUserByUserId(id);
        r.setCode(200);
        r.setMsg("删除成功");
        return r.toString();
    }

    //上传头像
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file,@RequestParam String userId) throws IOException {
        result r = new result();
        ImageVO img = fileService.uploadAvatar(file);
        userService.updateAvatarByUserId(Integer.parseInt(userId), img.getUrl());
        r.setMsg("上传成功");
        r.setCode(200);
        return r.toString();
    }

    //通过userId获取头像
    @RequestMapping("/getAvatar")
    @ResponseBody
    public String getAvatar(@RequestBody Map<String, String> map) throws JsonProcessingException {
        int id = Integer.parseInt(map.get("userId"));
        ObjectMapper mapper = new ObjectMapper();
        ImageVO img = new ImageVO(0, userService.queryAvatarByUserId(id));
        result r = new result();
        r.setData(mapper.writeValueAsString(img));
        r.setCode(200);
        r.setMsg("返回头像url");
        return r.toString();
    }

    //通过userId修改密码（new,old）
    @RequestMapping("/updatePw")
    @ResponseBody
    public String updatePw(@RequestBody Map<String, String> map){
        result r = new result();
        int id = Integer.parseInt(map.get("userId"));
        String o = map.get("old");
        String n = map.get("new");
        if (!o.equals(userService.queryPasswordByUserId(id))){
            r.setCode(400);
            r.setMsg("密码不正确");
            return r.toString();
        }
        if (o.equals(n)){
            r.setCode(400);
            r.setMsg("新密码不能和旧密码一样");
            return r.toString();
        }
        userService.updatePasswordByUserId(id, n);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //通过userId修改admin
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateAdmin(@RequestBody Map<String, String> map){
        if (map.get("admin").equals("true")){
            userService.updateAdminByUserId(Integer.parseInt(map.get("userId")), 1);
        } else {
            userService.updateAdminByUserId(Integer.parseInt(map.get("userId")), 0);
        }
        result r = new result();
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //通过userId查询书籍
    @RequestMapping("/getUserBooks")
    @ResponseBody
    public String getUserBooks(@RequestBody Map<String, String> map) throws JsonProcessingException {
        int userId = Integer.parseInt(map.get("userId"));
        List<Books> blist = new ArrayList<>();
        List<Collects> clist = collectService.queryCollectsByUserId(userId);
        for (Collects c : clist){
            Books book = bookService.queryBookByBookId(c.getBookId());
            blist.add(book);
        }
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        r.setCode(200);
        r.setMsg("返回" + userId + "用户的书籍");
        r.setData(mapper.writeValueAsString(blist));
        return r.toString();
    }

    //删除user书架中的书
    @RequestMapping("/deleteUserBooks")
    @ResponseBody
    public String deleteUserBooks(@RequestBody Map<String, Object> map) {
        System.out.println(map.get("userId"));
        int userId = Integer.parseInt(map.get("userId").toString());
        List<Integer> books = (List<Integer>)map.get("books");
        for (int bookId : books){
            collectService.deleteCollectByUserIdAndBookId(userId, bookId);
        }
        System.out.println(books);
        result r = new result();
        r.setCode(200);
        r.setMsg("删除成功");
        return r.toString();
    }
}
