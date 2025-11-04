package com.exert.service;

import com.exert.pojo.Params;

import java.util.List;

public interface ParamService {

    //查询全部参数
    List<Params> queryAllParams();

    //根据paramId返回param
    String queryParamByParamId(int paramId);

    //通过name模糊查询param
    List<Params> queryParamByName(String name);

    //通过paramId判断param是否存在
    boolean judgeParamByParamId(String param, int paramId);

    //更新参数
    int updateParam(Params param);

    //添加参数
    int addParam (Params param);

    //删除参数
    int deleteParamByParamId (int paramId);

    //查询param
    Params queryParamByParam (String param);

    //通过param判断是否存在
    boolean judgeParam(String param);
}
