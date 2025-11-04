package com.exert.service;

import com.exert.dao.UserMapper;
import com.exert.pojo.Users;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class UserServiceImpl implements UserService{

    //service调dao层：组合Dao
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public int addUser(Users user) {
        return userMapper.addUser(user);
    }

    public int deleteUserByUserId(int userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    public int updateUser(Users user) {
        return userMapper.updateUser(user);
    }

    public Users queryUserByUserId(int userId) {
        return userMapper.queryUserByUserId(userId);
    }

    public List<Users> queryUsersByAdmin(int admin){
        return userMapper.queryUsersByAdmin(admin);
    }

    public List<Users> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    public List<Users> queryUserByNameAndAdmin(String name, int admin){
        return userMapper.queryUserByNameAndAdmin(name,admin);
    }


    public Users login(String email, String password){
        return userMapper.login(email, password);
    }

    public boolean judgeEmail(String email){
        Users user = userMapper.queryUserByEmail(email);
        if (ObjectUtils.isEmpty(user)){
            return false;
        }
        return true;
    }

    public boolean judgeEmailByUserId(String email, int userId){
        List<Users> user = userMapper.queryUserByEmailAndUserId(email, userId);
        if (ObjectUtils.isEmpty(user)){
            return false;
        }
        return true;
    }

    public List<Users>  queryUserByName(String name){
        return userMapper.queryUsersByName(name);
    }

    public String queryPasswordByUserId(int userId){
        return userMapper.queryPasswordByUserId(userId);
    }

    public int queryUserIdByEmail(String email){
        return userMapper.queryUserIdByEmail(email);
    }

    public String queryAvatarByUserId(int userId) {
        return userMapper.queryAvatarByUserId(userId);
    }

    public int updateAvatarByUserId(int userId, String avatar){
        return userMapper.updateAvatarByUserId(userId, avatar);
    }

    public int updatePasswordByUserId(int userId, String password){
        return userMapper.updatePasswordByUserId(userId, password);
    }

    public int updateAdminByUserId(int userId, int admin){
        return userMapper.updateAdminByUserId(userId, admin);
    }
    //通过userId查询userName
    public String queryNameByUserId(int userId){
        return userMapper.queryNameByUserId(userId);
    }
}
