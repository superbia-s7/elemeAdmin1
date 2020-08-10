package com.neusoft;

import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.impl.BusinessViewImpl;
import com.neusoft.view.impl.FoodViewImpl;

import java.util.List;
import java.util.Scanner;

public class ElmBussiness {
    public static void main(String[] args) {
        work();
    }

    public static void work() {
        Scanner input = new Scanner(System.in);
        String businessAddress = null;
        String businessName = null;
        String businessExplain = null;
        Double starPrice = 0.0;
        Double deliveryPrice = 0.0;
        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用商家登录
        System.out.println("请输入商家编号：");
        Integer businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login(businessId, password);

        if (business != null) {
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu != 5) {

                // 创建一个菜单
                System.out.println("========= 一级菜单1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu) {
                    case 1:
                        Business b = businessView.SearchBusiness(businessId);
                        System.out.println("商家编号：" + b.getBusinessId());
                        System.out.println("商家名称：" + b.getBusinessName());
                        System.out.println("商家地址：" + b.getBusinessAddress());
                        System.out.println("商家介绍：" + b.getBusinessExplain());
                        System.out.println("起送费：" + b.getStarPrice());
                        System.out.println("配送费：" + b.getDeliveryPrice());

                        break;
                    case 2:
                        Business b1 = businessView.SearchBusiness(businessId);
                        System.out.println("商家编号：" + b1.getBusinessId());
                        System.out.println("商家名称：" + b1.getBusinessName());
                        System.out.println("商家地址：" + b1.getBusinessAddress());
                        System.out.println("商家介绍：" + b1.getBusinessExplain());
                        System.out.println("起送费：" + b1.getStarPrice());
                        System.out.println("配送费：" + b1.getDeliveryPrice());

                        System.out.println("是否要修改商家名称 y/n");
                        String qd3 = input.next();
                        if (qd3.equals("y")) {
                            System.out.println("请输入新的商家名称");
                            businessName = input.next();
                        } else {
                            businessName = b1.getBusinessName();
                        }

                        System.out.println("是否要修改商家地址 y/n");
                        qd3 = input.next();
                        if (qd3.equals("y")) {
                            System.out.println("请输入新的商家地址");
                            businessAddress = input.next();
                        } else {
                            businessAddress = b1.getBusinessAddress();
                        }
                        System.out.println("是否要修改商家介绍 y/n");
                        qd3 = input.next();
                        if (qd3.equals("y")) {
                            System.out.println("请输入新的商家介绍");
                            businessExplain = input.next();
                        } else {
                            businessExplain = b1.getBusinessExplain();
                        }
                        System.out.println("是否要修改起送费 y/n");
                        qd3 = input.next();
                        if (qd3.equals("y")) {
                            System.out.println("请输入新的起送费");
                            starPrice = input.nextDouble();
                        } else {
                            starPrice = b1.getStarPrice();
                        }
                        System.out.println("是否要修改配送费 y/n");
                        qd3 = input.next();
                        if (qd3.equals("y")) {
                            System.out.println("请输入新的配送费");
                            deliveryPrice = input.nextDouble();
                        } else {

                            deliveryPrice = b1.getDeliveryPrice();
                        }
                        int num = businessView.updateBusiness(businessId, businessName, businessAddress, businessExplain, starPrice, deliveryPrice);
                        if (num != 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                        break;
                    case 3:
                        boolean a=true;
                        while (a){
                        System.out.println("请输入旧密码");
                        String Opassword = input.next();
                        System.out.println("请输入新密码");
                        String Npassword=input.next();
                        System.out.println("请再次输入新密码");
                        String DNpassword=input.next();
                        if(Npassword.equals(DNpassword)){
                           int n = businessView.upPassword(Npassword,businessId);
                           if (n!=0) {
                               System.out.println("密码修改成功");
                           }else {
                               System.out.println("密码修改失败");
                           }
                            a=false;
                        }else {
                            System.out.println("两次密码不一致");
                        }
                        }
                        break;
                    case 4:
                        int menu2 = 0;
                        FoodView foodView = new FoodViewImpl();
                        while (menu2 != 5) {

                            // 创建一个菜单
                            System.out.println("========= 二级菜单1.查看商品信息=2.添加商品=3.修改商品信息=4.删除商品=5.退出系统 =========");
                            System.out.println("请选择相应的菜单编号");
                            menu2 = input.nextInt();
                            switch (menu2) {
                                case 1:
                                    List<Food> list = foodView.selectFood(businessId);
                                    for (Food f : list
                                    ) {
                                        System.out.println(f.toString());
                                    }
                                    break;
                                case 2:
                                    String tj = "y";
                                    String foodName = null;
                                    String foodExplain = null;
                                    Double foodPrice = 0.0;
                                    String pd = "n";
                                    while (tj.equals("y")) {
                                        System.out.println("请输入要添加的信息");
                                        System.out.println("是否添加食品名称y/n");
                                        pd = input.next();

                                        if (pd.equals("y")) {
                                            System.out.println("请输入要添加的内容");
                                            foodName = input.next();
                                        } else {
                                            foodName = null;
                                        }
                                        System.out.println("是否添加食品简介y/n");
                                        pd = input.next();
                                        if (pd.equals("y")) {
                                            System.out.println("请输入要添加的内容");
                                            foodExplain = input.next();
                                        } else {
                                            foodExplain = null;
                                        }
                                        System.out.println("是否添加食品价格y/n");
                                        pd = input.next();
                                        if (pd.equals("y")) {
                                            System.out.println("请输入要添加的内容");
                                            foodPrice = input.nextDouble();
                                        } else {
                                            foodPrice = 0.0;
                                        }
                                        num = foodView.insertFood(foodName, foodExplain, foodPrice, businessId);
                                        if (num != 0) {
                                            System.out.println("添加成功");
                                        } else {
                                            System.out.println("添加失败");
                                        }

                                        System.out.println("是否继续添加y/n");
                                        tj = input.next();

                                    }
                                    break;
                                case 3:
                                    String foodName1 = null;
                                    String foodExplain1 = null;
                                    Double foodPrice1 = 0.0;
                                    String pd1 = "n";
                                    Food food = new Food();

                                    System.out.println("请输入要修改商品的ID");
                                    int foodId = input.nextInt();
                                    System.out.println("是否修改食品名称y/n");
                                    pd1 = input.next();
                                    if (pd1.equals("y")) {
                                        System.out.println("请输入要修改的内容");
                                        foodName1 = input.next();
                                    } else {
                                        foodExplain1 = food.getFoodName();
                                    }
                                    System.out.println("是否修改食品简介y/n");
                                    pd1 = input.next();
                                    if (pd1.equals("y")) {
                                        System.out.println("请输入要修改的内容");
                                        foodExplain1 = input.next();
                                    } else {
                                        foodExplain1 = food.getFoodExplain();
                                    }
                                    System.out.println("是否修改食品价格y/n");
                                    pd1 = input.next();
                                    if (pd1.equals("y")) {
                                        System.out.println("请输入要修改的内容");
                                        foodPrice1 = input.nextDouble();
                                    } else {
                                        foodPrice1 = food.getFoodPrice();
                                    }
                                    num = foodView.updateFood(foodId, foodName1, foodExplain1, foodPrice1, businessId);
                                    if (num != 0) {
                                        System.out.println("修改成功");
                                    } else {
                                        System.out.println("修改失败");
                                    }

                                    System.out.println("是否继续添加y/n");
                                    tj = input.next();


                                    break;
                                case 4:
                                    System.out.println("请输入要删除的商品的ID");
                                    int foodId1 = input.nextInt();
                                    int num1 = foodView.deleteFood(foodId1, businessId);
                                    if (num1 != 0) {
                                        System.out.println("删除成功");
                                    } else {
                                        System.out.println("删除失败");
                                    }
                                    break;
                                case 5:
                                    System.out.println("返回前一菜单");
                                    break;
                                default:
                                    System.out.println("没有这个菜单项");
                                    break;
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


        } else {
            System.out.println("账号或密码有误请重新输入");
        }

    }
}
