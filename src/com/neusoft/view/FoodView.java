package com.neusoft.view;

import com.neusoft.domain.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodView {
    public List<Food> selectFood(Integer businessId);

    public int insertFood(String foodName, String foodExplain, Double foodPrice, Integer businessId);

    public int updateFood(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId);

    public int deleteFood(Integer foodId, Integer businessId);
}
