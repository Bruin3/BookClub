package com.exert.dao;

import com.exert.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {

    //查询全部书籍
    List<Books> queryAllBooks();

    //添加书籍
    int addBook(Books book);

    //删除用户
    int deleteBookByBookId(int bookId);

    //更新用户
    int updateBook(Books book);

    //通过bookName模糊查询书籍
    List<Books> queryBooksByBookName(String bookName);

    //通过bookId和bookName查询book
    List<Books> queryBookByBookNameAndBookId(@Param("bookName")String bookName, @Param("bookId")int bookId);

    //通过bookId查询img
    String queryImgByBookId(int bookId);

    //通过bookName查询
    Books queryBookByBookName(String bookName);

    //通过bookId更新img
    int updateImgByBookId(@Param("bookId") int bookId, @Param("img") String img);

    //通过bookId查询book
    Books queryBookByBookId(int bookId);

    //通过bookName查询bookId
    int queryBookIdByBookName(String bookName);
}
