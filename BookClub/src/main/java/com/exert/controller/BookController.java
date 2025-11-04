package com.exert.controller;

import com.exert.pojo.BookParam;
import com.exert.pojo.Books;
import com.exert.pojo.Collects;
import com.exert.service.*;
import com.exert.utils.ImageVO;
import com.exert.utils.booksPage;
import com.exert.utils.booksResult;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller 调 service 层
    @Autowired
    private BookService bookService;
    @Autowired
    private BookParamService bookParamService;
    @Autowired
    private ParamService paramService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private FileService fileService;

    //返回所有books
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize) throws JsonProcessingException {
        List<Books> list;
        if (query == null){
            list = bookService.queryAllBooks();
        }else {
            list = bookService.queryBooksByBookName(query);
        }
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        booksPage bp = new booksPage();
        List<Books> rlist = new ArrayList<>();
        int index = 0;
        for(Books book : list){
            if (index / pagesize == pagenum - 1){
                rlist.add(book);
            }
            index++;
        }
        bp.setPagenum(pagenum);
        bp.setTotal(list.size());
        bp.setBooks(rlist);
        r.setCode(200);
        r.setMsg("返回书籍");
        r.setData(mapper.writeValueAsString(bp));
        return r.toString();
    }

    //返回paramBooks
    @RequestMapping("/getParamBooks")
    @ResponseBody
    public String getParamBooks(@RequestParam int paramId, @RequestParam int userId) throws JsonProcessingException {
        List<booksResult> brlist = new ArrayList<>();
        List<Books> blist = new ArrayList<>();
        if (paramId != 0){
            List<BookParam> bplist = bookParamService.queryBookIdByParamId(paramId);
            for (BookParam bp : bplist){
                blist.add(bookService.queryBookByBookId(bp.getBookId()));
            }
        } else {
            blist = bookService.queryAllBooks();
        }
        System.out.println(blist.toString());
        for (Books b : blist){
            System.out.println(b.toString());
            System.out.println("-----" + b.getBookId());
            List<BookParam> bplist = bookParamService.queryParamIdByBookId(b.getBookId());
            System.out.println("---------");
            StringBuilder params = new StringBuilder("[");
            for (BookParam bp : bplist){
                params.append(paramService.queryParamByParamId(bp.getParamId())).append(",");
            }
            params = new StringBuilder(params.substring(0, params.length() - 1));
            params.append("]");
            int number = collectService.queryCollectsByBookId(b.getBookId()).size();
            List<Collects> clist = collectService.queryCollectsByUserId(userId);
            boolean collect = false;
            for (Collects c : clist){
                if (b.getBookId() == c.getBookId()) {
                    collect = true;
                    break;
                }
            }
            booksResult br = new booksResult(0, b.getImg(), b.getBookName(), b.getAuthor(), b.getPublishYear(), params.toString(), number, collect, b.getSynopsis());
            brlist.add(br);
        }
        //将brlist按照number降序
        brlist.sort((o1, o2) -> o2.getNumber() - o1.getNumber());
        int i = 1;
        for (booksResult br : brlist){
            br.setRank(i++);
        }
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        r.setCode(200);
        r.setMsg("返回书籍");
        r.setData(mapper.writeValueAsString(brlist));
        return r.toString();
    }

    //更新书籍
    @RequestMapping (value="/edit", method= RequestMethod.PUT)
    @ResponseBody
    public String edit(@RequestBody Map<String, String> map){
        result r = new result();
        if (bookService.judgeBookNameByBookId(map.get("bookName"), Integer.parseInt(map.get("bookId")))){
            r.setCode(400);
            r.setMsg("该书名已存在！");
            return r.toString();
        }
        String img = bookService.queryImgByBookId(Integer.parseInt(map.get("bookId")));
        Books book = new Books(Integer.parseInt(map.get("bookId")),map.get("bookName"),map.get("author"),Integer.parseInt(map.get("publishYear")), map.get("synopsis"),img);
        bookService.updateBook(book);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //添加书籍
    @RequestMapping ("/save")
    @ResponseBody
    public String save(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        String datajson = mapper.writeValueAsString(map);
        if (bookService.judgeBookName(map.get("bookName"))){
            r.setCode(400);
            r.setMsg("该书名已存在！");
            return r.toString();
        }
        Books book = new Books(0,map.get("bookName"),map.get("author"),Integer.parseInt(map.get("publishYear")), map.get("synopsis"),"/bookImg/0.jpg");
        bookService.addBook(book);
        r.setCode(200);
        r.setMsg("添加成功！");
        return r.toString();
    }

    //删除用户
    @RequestMapping ("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, String> map){
        int id = Integer.parseInt(map.get("bookId"));
        result r = new result();
        bookService.deleteBookByBookId(id);
        bookParamService.deleteBookParamByBookId(id);
        r.setCode(200);
        r.setMsg("删除成功");
        return r.toString();
    }

    //上传头像
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file, @RequestParam String bookId) throws IOException {
        result r = new result();
        ImageVO img = fileService.uploadBookImg(file);
        System.out.println(img.getUrl());
        bookService.updateImgByBookId(Integer.parseInt(bookId), img.getUrl());
        r.setMsg("上传成功");
        r.setCode(200);
        r.setMsg(img.getUrl());
        return r.toString();
    }

    //通过bookId获取图片
    @RequestMapping("/getBookImg")
    @ResponseBody
    public String getBookImg(@RequestBody Map<String, String> map) throws JsonProcessingException {
        int id = Integer.parseInt(map.get("bookId"));
        ObjectMapper mapper = new ObjectMapper();
        ImageVO img = new ImageVO(0, bookService.queryImgByBookId(id));
        result r = new result();
        r.setData(mapper.writeValueAsString(img));
        r.setCode(200);
        r.setMsg("返回书籍图片url");
        return r.toString();
    }

    //加入书架
    @RequestMapping("/addCollect")
    @ResponseBody
    public String addCollect(@RequestParam int userId, @RequestParam String bookName){
        result r = new result();
        int bookId = bookService.queryBookIdByBookName(bookName);
        Collects collects = new Collects(0, bookId, userId);
        collectService.addCollect(collects);
        r.setCode(200);
        r.setMsg("添加成功");
        return r.toString();
    }

    //根据书名查询书籍
    @RequestMapping("/queryBooks")
    @ResponseBody
    public String queryBooks(@RequestParam int userId, @RequestParam String search) throws JsonProcessingException {
        result r = new result();
        List<booksResult> brlist = new ArrayList<>();
        List<Books> blist = new ArrayList<>();
        blist = bookService.queryBooksByBookName(search);
        for (Books b : blist){
            List<BookParam> bplist = bookParamService.queryParamIdByBookId(b.getBookId());
            StringBuilder params = new StringBuilder("[");
            for (BookParam bp : bplist){
                params.append(paramService.queryParamByParamId(bp.getParamId())).append(",");
            }
            params = new StringBuilder(params.substring(0, params.length() - 1));
            params.append("]");
            int number = collectService.queryCollectsByBookId(b.getBookId()).size();
            List<Collects> clist = collectService.queryCollectsByUserId(userId);
            boolean collect = false;
            for (Collects c : clist){
                if (b.getBookId() == c.getBookId()) {
                    collect = true;
                    break;
                }
            }
            booksResult br = new booksResult(0, b.getImg(), b.getBookName(), b.getAuthor(), b.getPublishYear(), params.toString(), number, collect, b.getSynopsis());
            brlist.add(br);
        }
        ObjectMapper mapper = new ObjectMapper();
        r.setCode(200);
        r.setMsg("查询成功");
        r.setData(mapper.writeValueAsString(brlist));
        return r.toString();
    }
}
