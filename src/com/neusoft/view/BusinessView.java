package com.neusoft.view;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessView {   public List<Business> listBusiness();
    public List<Business> selectBusiess(String businessName,String businessAddress);
    public int deleteBussiness(Integer id);
    public int insterBussiness(String name);
    public Business login(Integer businesId,String password);
    public Business SearchBusiness(Integer businessId);
    public int updateBusiness(Integer businessId,
                              String businessName,
                              String businessAddress,
                              String businessExplain,
                              Double starPrice,
                              Double deliveryPrice);
        }
