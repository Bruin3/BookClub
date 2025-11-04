package com.exert.service;

import com.exert.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //添加用户
    int addUser(Users user);

    //删除用户
    int deleteUserByUserId(int userId);

    //更新用户
    int updateUser(Users user);

    //查询用户
    Users queryUserByUserId(int userId);

    //查询全部用户
    List<Users> queryAllUsers();

    //查询普通用户
    List<Users> queryUsersByAdmin(int admin);

    //查询用户通过name和admin
    List<Users> queryUserByNameAndAdmin(String name, int admin);

    //通过name模糊查询用户
    List<Users>  queryUserByName(String name);

    //登陆
    Users login(String email, String password);

    //判断email是否存在
    boolean judgeEmail(String email);

    //通过id判断email是否存在
    boolean judgeEmailByUserId(String email, int userId);

    //通过userId查询密码
    String queryPasswordByUserId(int userId);

    //通过email查询userId
    int queryUserIdByEmail(String email);

    //通过userId查询avatar
    String queryAvatarByUserId(int userId);

    //通过userId插入avatar
    int updateAvatarByUserId(int userId, String avatar);

    //通过userId修改密码
    int updatePasswordByUserId(int userId, String password);

    //通过userId修改admin
    int updateAdminByUserId(int userId, int admin);

    //通过userId查询userName
    String queryNameByUserId(int userId);
}
