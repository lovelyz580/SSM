package com.springboot.controller;
import com.springboot.entity.Xdininghall;
import com.springboot.service.XdininghallService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.code.vo.Result;
import com.code.vo.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *
 * Created by Lovelyz on 2019/05/11.
 */
@Controller
@RequestMapping("/xdininghall/")
public class XdininghallController {

    @Autowired
    XdininghallService xdininghallService;

    @RequestMapping("selectAll")
    @ResponseBody
    public Result<List<Xdininghall>> selectAll(){
        return Result.success(xdininghallService.selectAll());
    }

    @RequestMapping("select")
    @ResponseBody
    public Result<Xdininghall> selectByPrimaryKey(Integer iid){
        return Result.success(xdininghallService.selectByPrimaryKey(iid));
    }

    @RequestMapping("selectByCondition")
    @ResponseBody
    public Result<List<Xdininghall>> selectByCondition(Xdininghall record){
        return Result.success(xdininghallService.selectByCondition(record));
    }

    @RequestMapping("count")
    @ResponseBody
    public Result<Integer> count(Xdininghall record){
        return Result.success(xdininghallService.count(record));
    }

    @RequestMapping("insert")
    @ResponseBody
    public Result<Integer> insertSelective(Xdininghall record){
        return Result.success(xdininghallService.insertSelective(record));
    }

    @RequestMapping("update")
    @ResponseBody
    public Result<Integer> updateByPrimaryKeySelective(Xdininghall record){
        return Result.success(xdininghallService.updateByPrimaryKeySelective(record));
    }

    @RequestMapping("selectByPage")
    @ResponseBody
    public Result<Page<List<Xdininghall>>> selectByPage(Page<Xdininghall> page){
        List<Xdininghall> list = null;
        page = page.sequentialDisplayCalculate(xdininghallService.count(page.getObj()));
        if (page.getTotalCount() > 0) {
            list = xdininghallService.selectByPage(page);
        }
        Page<List<Xdininghall>> result = new Page<List<Xdininghall>>(page, list);
        return Result.success(result);
    }

    @RequestMapping("deleteByCondition")
    @ResponseBody
    public Result<Integer> deleteByCondition(Xdininghall record){
        return Result.success(xdininghallService.deleteByCondition(record));
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result<Integer> deleteByPrimaryKey(Integer iid){
        return Result.success(xdininghallService.deleteByPrimaryKey(iid));
    }

}
