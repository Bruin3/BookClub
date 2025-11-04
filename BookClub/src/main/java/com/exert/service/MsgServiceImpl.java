package com.exert.service;

import com.exert.dao.MsgMapper;
import com.exert.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService{

    @Autowired
    private MsgMapper msgMapper;

    //查询全部消息
    public List<Msg> queryAllMsg(){
        return msgMapper.queryAllMsg();
    }

    //添加消息
    public int addMsg(Msg msg){
        return msgMapper.addMsg(msg);
    }

    //删除消息
    public int deleteMsgByMsgId(int msgId){
        return msgMapper.deleteMsgByMsgId(msgId);
    }

    //更新消息
    public int updateMsg(Msg msg){
        return msgMapper.updateMsg(msg);
    }

    //通过msgUserName模糊查询消息
    public List<Msg> queryMsgByMsgUserName(String msgUserName){
        return msgMapper.queryMsgByMsgUserName(msgUserName);
    }
}
