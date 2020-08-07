package test;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public class TestAdmin {
    public static void main(String[] args) {
//        AdminDao adminDao = new AdminDaoImpl();
//        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
        BusinessDao businessDao=new BusinessDaoImpl();
        List<Business> list =businessDao.select("饺子","沈阳");
        for (Business b:list
             ) {
            System.out.println(b);
        }

    }
}
