package com.exert.controller;

import com.exert.pojo.Msg;
import com.exert.service.MsgService;
import com.exert.service.UserService;
import com.exert.utils.msgPage;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @Autowired
    private UserService userService;

    //返回所有books
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize) throws JsonProcessingException {
        List<Msg> list;
        if (query == null){
            list = msgService.queryAllMsg();
        }else {
            list = msgService.queryMsgByMsgUserName(query);
        }
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        msgPage mp = new msgPage();
        List<Msg> rlist = new ArrayList<>();
        int index = 0;
        for(Msg msg : list){
            if (index / pagesize == pagenum - 1){
                rlist.add(msg);
            }
            index++;
        }
        mp.setPagenum(pagenum);
        mp.setTotal(list.size());
        mp.setMsg(rlist);
        r.setCode(200);
        r.setMsg("返回消息");
        r.setData(mapper.writeValueAsString(mp));
        return r.toString();
    }

    //更新消息
    @RequestMapping (value="/edit", method= RequestMethod.PUT)
    @ResponseBody
    public String edit(@RequestBody Map<String, String> map){
        result r = new result();
        Msg msg = new Msg(Integer.parseInt(map.get("msgId")),map.get("msg"),Integer.parseInt(map.get("msgUserId")),userService.queryNameByUserId(Integer.parseInt(map.get("msgUserId"))),new Date());
        msgService.updateMsg(msg);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //添加消息
    @RequestMapping ("/save")
    @ResponseBody
    public String save(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        String datajson = mapper.writeValueAsString(map);
        Msg msg = new Msg(0,map.get("msg"),Integer.parseInt(map.get("msgUserId")),userService.queryNameByUserId(Integer.parseInt(map.get("msgUserId"))),new Date());
        msgService.addMsg(msg);
        r.setCode(200);
        r.setMsg("添加成功！");
        return r.toString();
    }

    //删除消息
    @RequestMapping ("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, String> map){
        int id = Integer.parseInt(map.get("msgId"));
        result r = new result();
        msgService.deleteMsgByMsgId(id);
        r.setCode(200);
        r.setMsg("删除成功");
        return r.toString();
    }

}


