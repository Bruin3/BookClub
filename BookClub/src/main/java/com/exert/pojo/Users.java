package com.exert.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String sex;
    private int admin;
    private String motto;
    private String avatar;
}
