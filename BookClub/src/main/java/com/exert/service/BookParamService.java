package com.exert.service;

import com.exert.pojo.BookParam;

import java.util.List;

public interface BookParamService {

    //根据bookId查找相应参数
    List<BookParam> queryParamIdByBookId(int bookId);

    //根据paramId查找相应用户
    List<BookParam> queryBookIdByParamId(int paramId);

    //添加书籍
    int addBookParam(BookParam bookParam);

    //删除书籍的所有参数
    int deleteBookParamByBookId(int bookId);

    //删除参数的所有书籍
    int deleteBookParamByParamId(int paramId);

}
