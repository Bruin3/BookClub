package com.exert.controller;

import com.exert.pojo.Params;
import com.exert.service.BookParamService;
import com.exert.service.ParamService;
import com.exert.utils.paramsPage;
import com.exert.utils.result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/param")
public class ParamController {

    //controller 调 service 层
    @Autowired
    private ParamService paramService;

    @Autowired
    private BookParamService bookParamService;

    //返回params
    @RequestMapping("/findAllParams")
    @ResponseBody
    public String findAllParams() throws JsonProcessingException {
        List<Params> list;
        result r = new result();
        list = paramService.queryAllParams();
        ObjectMapper mapper = new ObjectMapper();
        r.setData(mapper.writeValueAsString(list));
        r.setCode(200);
        r.setMsg("返回参数");
        return r.toString();
    }

    //返回params
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam String query, @RequestParam int pagenum, @RequestParam int pagesize) throws JsonProcessingException {
        List<Params> list;
        if (query == null){
            list = paramService.queryAllParams();
        }else {
            list = paramService.queryParamByName(query);
        }
        ObjectMapper mapper = new ObjectMapper();
        result r = new result();
        paramsPage pp = new paramsPage();
        List<Params> rlist = new ArrayList<>();
        int index = 0;
        for(Params param : list){
            if (index / pagesize == pagenum - 1){
                rlist.add(param);
            }
            index++;
        }
        pp.setPagenum(pagenum);
        pp.setTotal(list.size());
        pp.setParams(rlist);
        r.setCode(200);
        r.setMsg("返回参数");
        r.setData(mapper.writeValueAsString(pp));
        return r.toString();
    }

    //更新params
    @RequestMapping (value="/edit", method= RequestMethod.PUT)
    @ResponseBody
    public String edit(@RequestBody Map<String, String> map){
        result r = new result();
        if (paramService.judgeParamByParamId(map.get("param"), Integer.parseInt(map.get("paramId")))){
            r.setCode(400);
            r.setMsg("该参数已存在！");
            return r.toString();
        }
        Params param = new Params(Integer.parseInt(map.get("paramId")),map.get("param"));
        paramService.updateParam(param);
        r.setCode(200);
        r.setMsg("修改成功");
        return r.toString();
    }

    //添加参数
    @RequestMapping ("/save")
    @ResponseBody
    public String save(@RequestBody Map<String, String> map) throws JsonProcessingException {
        result r = new result();
        ObjectMapper mapper = new ObjectMapper();
        String datajson = mapper.writeValueAsString(map);
        if (paramService.judgeParam(map.get("param"))){
            r.setCode(400);
            r.setMsg("该参数已存在！");
            return r.toString();
        }
        Params param = new Params(0,map.get("param"));
        paramService.addParam(param);
        r.setCode(200);
        r.setMsg("添加成功！");
        return r.toString();
    }

    //删除用户
    @RequestMapping ("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, String> map){
        int id = Integer.parseInt(map.get("paramId"));
        System.out.println(id);
        result r = new result();
        paramService.deleteParamByParamId(id);
        bookParamService.deleteBookParamByParamId(id);
        r.setCode(200);
        r.setMsg("删除成功");
        return r.toString();
    }

}
