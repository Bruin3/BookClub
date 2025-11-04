package com.exert.utils;

import com.exert.pojo.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class usersPage {
    private int pagenum;
    private int total;
    private List<Users> users;
}
