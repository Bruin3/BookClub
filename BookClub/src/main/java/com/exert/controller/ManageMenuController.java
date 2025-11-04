package com.exert.controller;

import com.exert.pojo.ManageMenu;
import com.exert.service.ManageMenuService;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManageMenuController {
    @Autowired
    private ManageMenuService MMService;

    @ResponseBody
    @RequestMapping("/manageMenu")
    public String main() throws JsonProcessingException {
        result r = new result();
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        // 先取无fatherId的menu,mm1一级menu，mm2二级menu
        List<ManageMenu> mm1 = MMService.queryManageMenuByFatherId(0);
        // 再利用for循环给mm1里面的children字段添加相应的二级menu
        for (ManageMenu manageMenu : mm1) {
            List<ManageMenu> mm2 = MMService.queryManageMenuByFatherId(manageMenu.getMenuId());
            manageMenu.setChildren(mm2);
        }
        // 转换成json
        json = mapper.writeValueAsString(mm1);

        r.setCode(200);
        r.setMsg("成功返回menu");
        r.setData(json);
        return r.toString();
    }
}
