package com.springboot.service;

import com.springboot.entity.Xdininghall;
import com.springboot.dao.XdininghallMapper;
import com.code.vo.Page;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.ibatis.annotations.Param;

/**
 *
 * Created by Lovelyz on 2019/05/11.
 */
@Service
public class XdininghallService {

	@Autowired
    private XdininghallMapper xdininghallMapper;
    
    public int deleteByPrimaryKey(Integer iid){
        return xdininghallMapper.deleteByPrimaryKey(iid);
    }

    public int insert(Xdininghall record){
        return xdininghallMapper.insert(record);
    }

    public int insertSelective(Xdininghall record){
        return xdininghallMapper.insertSelective(record);
    }

    public Xdininghall selectByPrimaryKey(Integer iid){
        return xdininghallMapper.selectByPrimaryKey(iid);
    }

    public int updateByPrimaryKeySelective(Xdininghall record){
        return xdininghallMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Xdininghall record){
        return xdininghallMapper.updateByPrimaryKey(record);
    }

    public List<Xdininghall> selectByCondition(Xdininghall record){
        return xdininghallMapper.selectByCondition(record);
    }

    public List<Xdininghall> selectAll(){
        return xdininghallMapper.selectAll();
    }

    public List<Xdininghall> selectByPage(Page<Xdininghall> page){
        return xdininghallMapper.selectByPage(page);
    }

    public Integer count(Xdininghall record){
        return xdininghallMapper.count(record);
    }

    public int deleteByCondition(Xdininghall record){
        return xdininghallMapper.deleteByCondition(record);
    }

}
