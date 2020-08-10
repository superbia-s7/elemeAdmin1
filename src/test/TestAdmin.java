package test;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.impl.AdminViewImpl;

import java.util.List;
import java.util.Scanner;

public class TestAdmin {
    public static void main(String[] args) {
////        AdminDao adminDao = new AdminDaoImpl();
//        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
        BusinessDao businessDao=new BusinessDaoImpl();
////        List<Business> list =businessDao.select("饺子","沈阳");
////        for (Business b:list
////             ) {
////            System.out.println(b);
////        }
        String name = "adsadasas";
        int a = businessDao.insert(name);
        if(a!=0){
            System.out.println("添加成功，ID为："+a);
        }else {
            System.out.println("添加失败");
        }
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
    }
}
