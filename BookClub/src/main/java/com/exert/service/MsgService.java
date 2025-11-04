package com.exert.service;

import com.exert.pojo.Msg;

import java.util.List;

public interface MsgService {

    //查询全部消息
    List<Msg> queryAllMsg();

    //添加消息
    int addMsg(Msg msg);

    //删除消息
    int deleteMsgByMsgId(int msgId);

    //更新消息
    int updateMsg(Msg msg);

    //通过msgUserName模糊查询消息
    List<Msg> queryMsgByMsgUserName(String msgUserName);
}
