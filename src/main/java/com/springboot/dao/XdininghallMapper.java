package com.springboot.dao;

import com.code.vo.Page;
import com.springboot.entity.Xdininghall;
import java.util.List;

public interface XdininghallMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Xdininghall record);

    int insertSelective(Xdininghall record);

    Xdininghall selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Xdininghall record);

    int updateByPrimaryKey(Xdininghall record);

    List<Xdininghall> selectByCondition(Xdininghall record);

    List<Xdininghall> selectAll();

    List<Xdininghall> selectByPage(Page page);

    Integer count(Xdininghall record);

    int deleteByCondition(Xdininghall record);
}