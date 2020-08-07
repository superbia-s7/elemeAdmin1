package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    //  显示所有商家
    public List<Business> findAll();
    //  搜索某个商家
    public List<Business> select(String businessName,String businessAddress);
    //  添加某个商家
    public int insert(String businessName);
    //  修改某个商家
    public int update(Integer id ,Integer score);
    //  删除某个商家
    public int remove(Integer id);
}
