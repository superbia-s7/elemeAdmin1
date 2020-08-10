package com.neusoft.view.impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/7 11:35
 */
public class AdminViewImpl implements AdminView {
    private  Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入管理员的用户名：");
        String adminName = input.next();
        System.out.println("请输入管理员的密码：");
        String password = input.next();
        AdminDao dao = new AdminDaoImpl();
//        Admin admin = dao.getAdminByNameByPass(adminName, password);
//        return admin;
        return dao.getAdminByNameByPass(adminName, password);
    }

    @Override
    public List<Business> listBusiness() {
        BusinessDao businessDao = new BusinessDaoImpl();
        return businessDao.findAll();
    }

    @Override
    public List<Business> selectBusiess(String businessName,String businessAddress) {
        BusinessDao businessDao = new BusinessDaoImpl();
        return businessDao.select(businessName,businessAddress);
    }

    @Override
    public int deleteBussiness(Integer id) {
        BusinessDao businessDao = new BusinessDaoImpl();


        return businessDao.remove(id);
    }

    @Override
    public int insterBussiness(String name) {
        BusinessDao businessDao = new BusinessDaoImpl();
        return businessDao.insert(name);
    }
}
