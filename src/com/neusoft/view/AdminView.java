package com.neusoft.view;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;


public interface AdminView {
    // 登录
    public Admin login();
    public List<Business> listBusiness();
    public List<Business> selectBusiess(String businessName,String businessAddress);
    public int deleteBussiness(Integer id);
    public int insterBussiness(String name);
}
