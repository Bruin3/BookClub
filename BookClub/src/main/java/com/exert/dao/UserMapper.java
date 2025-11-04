package com.exert.dao;

import com.exert.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //添加用户
    int addUser(Users user);

    //删除用户
    int deleteUserByUserId(int userId);

    //更新用户
    int updateUser(Users user);

    //查询用户by userId
    Users queryUserByUserId(int userId);

    //查询用户by email
    Users queryUserByEmail(String email);

    //查询全部用户
    List<Users> queryAllUsers();

    //查询普通用户
    List<Users> queryUsersByAdmin(int admin);

    //查询用户通过name和admin
    List<Users> queryUserByNameAndAdmin(@Param("name")String name, @Param("admin")int admin);

    //模糊查询用户by name
    List<Users> queryUsersByName(String name);

    //登陆
    Users login(@Param("email")String email, @Param("password")String password);

    //通过email和userId查询user
    List<Users> queryUserByEmailAndUserId(@Param("email")String email, @Param("userId")int userId);

    //通过userId查询密码
    String queryPasswordByUserId(int userId);

    //通过email查询userId
    int queryUserIdByEmail(String email);

    //通过userId查询avatar
    String queryAvatarByUserId(int userId);

    //插入avatar
    int updateAvatarByUserId(@Param("userId") int userId, @Param("avatar") String avatar);

    //通过userId修改密码
    int updatePasswordByUserId(@Param("userId") int userId, @Param("password") String password);

    //通过userId修改admin
    int updateAdminByUserId(@Param("userId") int userId, @Param("admin") int admin);

    //通过userId查询userName
    String queryNameByUserId(int userId);
}
