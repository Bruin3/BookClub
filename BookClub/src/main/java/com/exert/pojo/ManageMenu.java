package com.exert.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManageMenu {
    private int menuId;
    private String authName;
    private int fatherId;
    private String path;
    private List<ManageMenu> children;
}
