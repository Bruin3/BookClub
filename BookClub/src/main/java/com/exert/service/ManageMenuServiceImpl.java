package com.exert.service;

import com.exert.dao.ManageMenuMapper;
import com.exert.pojo.ManageMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageMenuServiceImpl implements ManageMenuService{

    @Autowired
    private ManageMenuMapper MMMapper;

    public List<ManageMenu> queryManageMenuByFatherId(int fatherId){
        return MMMapper.queryManageMenuByFatherId(fatherId);
    }
}
