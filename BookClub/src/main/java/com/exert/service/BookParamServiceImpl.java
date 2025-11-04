package com.exert.service;

import com.exert.dao.BookParamMapper;
import com.exert.pojo.BookParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookParamServiceImpl implements BookParamService {

    //service调dao层：组合Dao
    @Autowired
    private BookParamMapper bookParamMapper;

    //根据bookId查找相应参数
    public List<BookParam> queryParamIdByBookId(int bookId){
        return bookParamMapper.queryParamIdByBookId(bookId);
    }

    //根据paramId查找相应用户
    public List<BookParam> queryBookIdByParamId(int paramId){
        return bookParamMapper.queryBookIdByParamId(paramId);
    }

    //添加书籍
    public int addBookParam(BookParam bookParam){
        return bookParamMapper.addBookParam(bookParam);
    }

    //删除书籍的所有参数
    public int deleteBookParamByBookId(int bookId){
        return bookParamMapper.deleteBookParamByBookId(bookId);
    }

    //删除参数的所有书籍
    public int deleteBookParamByParamId(int paramId){
        return bookParamMapper.deleteBookParamByParamId(paramId);
    }
}
