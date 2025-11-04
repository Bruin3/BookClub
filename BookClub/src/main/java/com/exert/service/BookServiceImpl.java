package com.exert.service;

import com.exert.dao.BooksMapper;
import com.exert.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    //service调dao层：组合Dao
    @Autowired
    private BooksMapper booksMapper;

    //查询全部书籍
    public List<Books> queryAllBooks(){
        return booksMapper.queryAllBooks();
    }

    //添加书籍
    public int addBook(Books book){
        return booksMapper.addBook(book);
    }

    //删除用户
    public int deleteBookByBookId(int bookId){
        return booksMapper.deleteBookByBookId(bookId);
    }

    //更新用户
    public int updateBook(Books book){
        return booksMapper.updateBook(book);
    }

    //通过bookName模糊查询书籍
    public List<Books> queryBooksByBookName(String bookName){
        return booksMapper.queryBooksByBookName(bookName);
    }

    //通过bookId判断bookName是否存在
    public boolean judgeBookNameByBookId(String bookName, int bookId){
        List<Books> book = booksMapper.queryBookByBookNameAndBookId(bookName, bookId);
        if (ObjectUtils.isEmpty(book)){
            return false;
        }
        return true;
    }

    //通过bookId查询img
    public String queryImgByBookId(int bookId){
        return booksMapper.queryImgByBookId(bookId);
    }

    //判断BookName是否存在
    public boolean judgeBookName(String bookName){
        Books book = booksMapper.queryBookByBookName(bookName);
        if (ObjectUtils.isEmpty(book)){
            return false;
        }
        return true;
    }

    //通过bookId更新img
    public int updateImgByBookId(int bookId, String img){
        return booksMapper.updateImgByBookId(bookId, img);
    }

    //通过bookName查询
    public Books queryBookByBookName(String bookName){
        return booksMapper.queryBookByBookName(bookName);
    }

    //通过bookId查询book
    public Books queryBookByBookId(int bookId){
        return booksMapper.queryBookByBookId(bookId);
    }

    //通过bookName查询bookId
    public int queryBookIdByBookName(String bookName){
        return booksMapper.queryBookIdByBookName(bookName);
    }
}
