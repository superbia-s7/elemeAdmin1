package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;

public class BusinessViewImpl implements BusinessView {
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

    @Override
    public Business login(Integer businesId,String password) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.getBusinessByNameByPass(businesId,password);
    }

    @Override
    public Business SearchBusiness(Integer businessId) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.searchBusiness(businessId);
    }

    @Override
    public int updateBusiness(Integer businessId,
                              String businessName,
                              String businessAddress,
                              String businessExplain,
                              Double starPrice,
                              Double deliveryPrice) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.update(businessId,
                businessName,
                businessAddress,
                businessExplain,
                starPrice,
               deliveryPrice);
    }

}
