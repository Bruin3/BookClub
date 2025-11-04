package com.exert.dao;

import com.exert.pojo.ManageMenu;

import java.util.List;

public interface ManageMenuMapper {

    //通过fatherId查询ManageMenu
    List<ManageMenu> queryManageMenuByFatherId(int fatherId);

}
