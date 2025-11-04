package com.exert.controller;

import com.exert.pojo.BookParam;
import com.exert.pojo.Books;
import com.exert.service.BookParamService;
import com.exert.service.BookService;
import com.exert.service.ParamService;
import com.exert.utils.bookParamResult;
import com.exert.utils.bookParamsPage;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookParam")
public class BookParamController {

    //controller 调 service 层
    @Autowired
    private BookParamService bookParamService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ParamService paramService;

    //返回所有books
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize) throws JsonProcessingException {
        List<bookParamResult> bpplist = new ArrayList<>();
        List<Books> blist;
        if (query == null){
            blist = bookService.queryAllBooks();
        }else {
            blist = bookService.queryBooksByBookName(query);
        }
        for(Books book : blist){
            bookParamResult bpr = new bookParamResult();
            List<BookParam> bplist;
            List<String> param = new ArrayList<>();
            bplist = bookParamService.queryParamIdByBookId(book.getBookId());
            for (BookParam bp : bplist){
                param.add(paramService.queryParamByParamId(bp.getParamId()));
            }
            bpr.setBookName(book.getBookName());
            bpr.setParams(param.toString());
            bpplist.add(bpr);
        }
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        bookParamsPage bpp = new bookParamsPage();
        List<bookParamResult> rlist = new ArrayList<>();
        int index = 0;
        for(bookParamResult bpr : bpplist){
            if (index / pagesize == pagenum - 1){
                rlist.add(bpr);
            }
            index++;
        }
        bpp.setPagenum(pagenum);
        bpp.setTotal(bpplist.size());
        bpp.setBpr(rlist);
        r.setCode(200);
        r.setMsg("返回书籍参数");
        r.setData(mapper.writeValueAsString(bpp));
        return r.toString();
    }

    //更新BookParam
    @RequestMapping("/updateBookParam")
    @ResponseBody
    public String updateBookParam(@RequestParam String bookName, @RequestParam String params){
        result r = new result();
        params = params + " ";
        String s = "";
        List<String> p = new ArrayList();
        for(int i=0; i < params.length(); i++){
            if (params.subSequence(i,i+1).equals(" ")){
                p.add(s);
                s = "";
                continue;
            }
            s = s + params.subSequence(i,i+1);
        }
        int bookId = bookService.queryBookByBookName(bookName).getBookId();
        bookParamService.deleteBookParamByBookId(bookId);
        for (String a : p){
            if (a.equals("")){
                continue;
            }
            int paramId = paramService.queryParamByParam(a).getParamId();
            BookParam bp = new BookParam(0, paramId, bookId);
            bookParamService.addBookParam(bp);
        }
        r.setCode(200);
        r.setMsg("更新成功");
        return r.toString();
    }
}
