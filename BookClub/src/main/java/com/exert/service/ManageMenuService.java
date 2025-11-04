package com.exert.service;

import com.exert.pojo.ManageMenu;
import com.exert.pojo.ManageMenu;

import java.util.List;

public interface ManageMenuService {

    //通过fatherId查询ManageMenu
    List<ManageMenu> queryManageMenuByFatherId(int fatherId);
}
