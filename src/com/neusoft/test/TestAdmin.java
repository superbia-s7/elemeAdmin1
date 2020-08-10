package com.neusoft.test;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.impl.BusinessViewImpl;
import com.neusoft.view.impl.FoodViewImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestAdmin {
    public static void main(String[] args) throws SQLException {
////        AdminDao adminDao = new AdminDaoImpl();
//        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
//        BusinessDao businessDao=new BusinessDaoImpl();
//////        List<Business> list =businessDao.select("饺子","沈阳");
//////        for (Business b:list
//////             ) {
//////            System.out.println(b);
//////        }
//        String name = "adsadasas";
//        int a = businessDao.insert(name);
//        if(a!=0){
//            System.out.println("添加成功，ID为："+a);
//        }else {
//            System.out.println("添加失败");
//        }
//        Scanner input  =new Scanner(System.in);
//        AdminView adminView = new AdminViewImpl();
//        System.out.println("请输入要删除的商家ID");
//        int i = input.nextInt();
//        System.out.println("是否确定y/n");
//        String qd=input.next();
//        if(qd.equals("y")) {
//            int num = adminView.deleteBussiness(i);
//            if(num!=0){
//                System.out.println("删除成功");
//            }else{
//                System.out.println("删除失败");
//            }
//        }
//        Scanner input = new Scanner(System.in);
//        BusinessView businessView = new BusinessViewImpl();
//        String businessAddress = null;
//        String businessName=null;
//        String businessExplain=null;
//        Double starPrice=0.0;
//        Double deliveryPrice=0.0;
        Integer businessId = 10001;
        Scanner input = new Scanner(System.in);
//        Business b1= businessView.SearchBusiness(businessId);
//        System.out.println("是否要修改商家名称 y/n");
//        String qd3=input.next();
//        if (qd3.equals("y")){
//            businessName=input.next();
//        }else {
//            businessAddress=b1.getBusinessName();
//        }
//
//        System.out.println("是否要修改商家地址 y/n");
//        qd3=input.next();
//        if (qd3.equals("y")){
//            businessAddress=input.next();
//        }else {
//            businessName=b1.getBusinessAddress();
//        }
//        System.out.println("是否要修改商家介绍 y/n");
//        qd3=input.next();
//        if (qd3.equals("y")){
//            businessExplain=input.next();
//        }else {
//            businessExplain=b1.getBusinessExplain();
//        }
//        System.out.println("是否要修改起送费 y/n");
//        qd3=input.next();
//        if (qd3.equals("y")){
//            starPrice=input.nextDouble();
//        }else {
//            starPrice=b1.getStarPrice();
//        }
//        System.out.println("是否要修改配送费 y/n");
//        qd3=input.next();
//        if (qd3.equals("y")){
//            deliveryPrice=input.nextDouble();
//        }else {
//            deliveryPrice=b1.getDeliveryPrice();
//        }
//        int num = businessView.updateBusiness(businessId,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);
//        if(num != 0){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }
        FoodView foodView = new FoodViewImpl();
//        String foodName1 = null;
//        String foodExplain1 = null;
//        Double foodPrice1 = 0.0;
//        String pd1 = "n";
//        int num=0;
//        System.out.println("请输入要修改商品的ID");
//        int foodId = input.nextInt();
//        System.out.println("是否修改食品名称y/n");
//        pd1 = input.next();
//        if (pd1.equals("y")) {
//            System.out.println("请输入要修改的内容");
//            foodName1 = input.next();
//        }
//        System.out.println("是否修改食品简介y/n");
//        pd1= input.next();
//        if (pd1.equals("y")) {
//            System.out.println("请输入要修改的内容");
//            foodExplain1 = input.next();
//        }
//        System.out.println("是否修改食品价格y/n");
//        pd1 = input.next();
//        if (pd1.equals("y")) {
//            System.out.println("请输入要修改的内容");
//            foodPrice1 = input.nextDouble();
//        }
//        num = foodView.updateFood(foodId, foodName1, foodExplain1, foodPrice1, businessId);
//        if (num != 0) {
//            System.out.println("添加成功");
//        } else {
//            System.out.println("添加失败");
//        }
//

        List<Food> list = foodView.selectFood(businessId);
        for (Food f : list
        ) {
            System.out.println(f);
        }
    }
}
