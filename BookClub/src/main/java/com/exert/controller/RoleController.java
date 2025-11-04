package com.exert.controller;

import com.exert.pojo.Roles;
import com.exert.service.RoleService;
import com.exert.service.UserService;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    //controller 调 service 层
    @Autowired
    private RoleService roleService;

    //返回所有roles
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() throws JsonProcessingException {
        List<Roles> list;
        ObjectMapper mapper = new ObjectMapper();
        list = roleService.queryAllRoles();
        result r = new result();
        r.setCode(200);
        r.setMsg("返回roles");
        r.setData(mapper.writeValueAsString(list));
        return r.toString();
    }
}
