package com.exert.service;

import com.exert.dao.RoleMapper;
import com.exert.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    //service调dao层：组合Dao
    @Autowired
    private RoleMapper roleMapper;

    public List<Roles> queryAllRoles(){
        return roleMapper.queryAllRoles();
    }
}
