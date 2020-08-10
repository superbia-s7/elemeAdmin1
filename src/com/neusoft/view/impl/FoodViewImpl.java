package com.neusoft.view.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.sql.SQLException;
import java.util.List;

public class FoodViewImpl implements FoodView {

    @Override
    public List<Food> selectFood(Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        return foodDao.selectFood(businessId);
    }

    @Override
    public int insertFood(String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        return foodDao.insertFood(foodName, foodExplain, foodPrice, businessId);
    }

    @Override
    public int updateFood(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        return foodDao.updateFood(foodId, foodName, foodExplain, foodPrice, businessId);
    }

    @Override
    public int deleteFood(Integer foodId, Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        return foodDao.deleteFood(foodId, businessId);
    }

}
