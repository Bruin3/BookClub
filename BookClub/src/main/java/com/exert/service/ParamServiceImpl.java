package com.exert.service;

import com.exert.dao.ParamsMapper;
import com.exert.pojo.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ParamServiceImpl implements ParamService {

    //service调dao层：组合Dao
    @Autowired
    private ParamsMapper paramsMapper;

    //查询全部参数
    public List<Params> queryAllParams(){
        return paramsMapper.queryAllParams();
    }

    //根据paramId返回param
    public String queryParamByParamId(int paramId){
        return paramsMapper.queryParamByParamId(paramId);
    }

    //通过name模糊查询param
    public List<Params> queryParamByName(String name){
        return paramsMapper.queryParamByName(name);
    }

    //通过paramId判断param是否存在
    public boolean judgeParamByParamId(String param, int paramId){
        List<Params> params = paramsMapper.queryParamsByParamAndParamId(param, paramId);
        if (ObjectUtils.isEmpty(params)){
            return false;
        }
        return true;
    }

    //更新参数
    public int updateParam(Params param){
        return paramsMapper.updateParam(param);
    }

    //添加参数
    public int addParam (Params param){
        return paramsMapper.addParam(param);
    }

    //删除参数
    public int deleteParamByParamId (int paramId){
        return paramsMapper.deleteParamByParamId(paramId);
    }

    //通过param判断是否存在
    public boolean judgeParam(String param){
        Params params = paramsMapper.queryParamByParam(param);
        if (ObjectUtils.isEmpty(params)){
            return false;
        }
        return true;
    }

    //通过param返回param
    public Params queryParamByParam (String param){
        return paramsMapper.queryParamByParam(param);
    }
}
