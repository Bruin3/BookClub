package com.exert.dao;

import com.exert.pojo.Params;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParamsMapper {

    //查询全部参数
    List<Params> queryAllParams();

    //根据paramId返回param
    String queryParamByParamId(int paramId);

    //通过name模糊查询param
    List<Params> queryParamByName(String name);

    //通过param和paramId查询
    List<Params> queryParamsByParamAndParamId(@Param("param") String param, @Param("paramId") int paramId);

    //更新参数
    int updateParam(Params param);

    //添加参数
    int addParam (Params param);

    //删除参数
    int deleteParamByParamId (int paramId);

    //查询param
    Params queryParamByParam (String param);
}
