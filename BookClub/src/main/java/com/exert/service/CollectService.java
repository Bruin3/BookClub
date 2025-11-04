package com.exert.service;

import com.exert.pojo.Collects;

import java.util.List;

public interface CollectService {

    //根据userId返回该用户的搜藏
    List<Collects> queryCollectsByUserId(int userId);

    //根据bookId返回搜藏
    List<Collects> queryCollectsByBookId(int bookId);

    //删除用户的书籍
    int deleteCollectByUserIdAndBookId(int userId, int bookId);

    //添加用户的书籍
    int addCollect(Collects collects);
}
