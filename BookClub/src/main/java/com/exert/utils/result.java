package com.exert.utils;

public class result {
    private int code;         //状态码
    private String msg;       //消息
    private String data;      //数据对象

    public result(){
        super();
    }

    public result(int code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

    public result(int code, String msg, String data){
        super();
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"meta\":{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                "}, \"data\":" + data +
                '}';
    }

}
