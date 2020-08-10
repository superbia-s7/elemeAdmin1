package com.neusoft;


import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.impl.AdminViewImpl;
import com.neusoft.view.impl.BusinessViewImpl;

import java.util.List;
import java.util.Scanner;


public class ElmAdmin {
    public static void main(String[] args) {
        work();
    }
    public static  void  work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用登录方法
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();
        BusinessView businessView = new BusinessViewImpl();
        if (admin!=null){
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu!= 5){

                // 创建一个菜单
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu){
                    case 1:
                        List<Business> list= businessView.listBusiness();

                        for (Business a :list
                             ) {

                            System.out.println(a);
                        }
                        break;
                    case 2:
                        System.out.println("请输入要查询的商家名:");
                        String bname=input.next();
                        System.out.println("请输入要查询的商家地址:");
                        String baddress=input.next();

                        List<Business> list2= businessView.selectBusiess(bname,baddress);

                        for (Business a :list2
                        ) {
                            System.out.println(a);
                        }
                        break;
                    case 3:
                        System.out.println("请输入要添加的商家名");
                        String name=input.next();
                        int a = businessView.insterBussiness(name);
                        System.out.println("是否确定y/n");
                        String qd1=input.next();
                        if (qd1.equals("y")){
                            if(a!=0){
                                System.out.println("添加成功，ID为："+a);
                            }else {
                                System.out.println("添加失败");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("请输入要删除的商家ID");
                        int i = input.nextInt();
                        System.out.println("是否确定y/n");
                        String qd2=input.next();
                        if(qd2.equals("y")) {
                            int num = businessView.deleteBussiness(i);
                            if(num!=0){
                                System.out.println("删除成功");
                            }else{
                                System.out.println("删除失败");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }




        }else {
            System.out.println("账号或密码有误请重新输入");
        }

    }
}