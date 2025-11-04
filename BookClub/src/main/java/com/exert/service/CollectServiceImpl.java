package com.exert.service;

import com.exert.dao.CollectsMapper;
import com.exert.pojo.Collects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    //service调dao层：组合Dao
    @Autowired
    private CollectsMapper collectsMapper;

    //根据userId返回该用户的搜藏
    public List<Collects> queryCollectsByUserId(int userId){
        return collectsMapper.queryCollectsByUserId(userId);
    }

    //根据bookId返回搜藏
    public List<Collects> queryCollectsByBookId(int bookId){
        return  collectsMapper.queryCollectsByBookId(bookId);
    }

    //删除用户的书籍
    public int deleteCollectByUserIdAndBookId(int userId, int bookId){
        return collectsMapper.deleteCollectByUserIdAndBookId(userId, bookId);
    }

    //添加用户的书籍
    public int addCollect(Collects collects){
        return collectsMapper.addCollect(collects);
    }
}
