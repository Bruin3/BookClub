package com.exert.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {

    private int msgId;
    private String msg;
    private int msgUserId;
    private String msgUserName;
    private Date msgTime;
}
