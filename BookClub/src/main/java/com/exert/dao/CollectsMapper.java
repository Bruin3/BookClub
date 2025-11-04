package com.exert.dao;

import com.exert.pojo.Collects;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectsMapper {

    //根据userId返回该用户的搜藏
    List<Collects> queryCollectsByUserId(int userId);

    //根据bookId返回搜藏
    List<Collects> queryCollectsByBookId(int bookId);

    //删除用户的书籍
    int deleteCollectByUserIdAndBookId(@Param("userId") int userId, @Param("bookId") int bookId);

    //添加用户的书籍
    int addCollect(Collects collects);

}
