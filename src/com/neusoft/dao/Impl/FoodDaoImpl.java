package com.neusoft.dao.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Food> selectFood(Integer businessId) {
        ArrayList<Food> list = null;
        String sql = "select * from business b left join food f on (b.businessId = f.businessId) where f.businessId = ?";

        try {
            conn = JDBCUtils.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            // 封装查询结果
            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            list = new ArrayList<Food>();


            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodExplain(rs.getString(3));
                food.setFoodPrice(rs.getDouble(4));
                food.setBusinessId(rs.getInt(5));

                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public int insertFood(String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        int foodId = 0;

        //String sql = "select * from food where businessId = ?";
        String sql = "insert into food(foodName,foodExplain,foodPrice,businessId)values(?,?,?,?)";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            //pstmt.setInt(1,businessId);
            //System.out.println(pstmt);
            //rs=pstmt.executeQuery();


            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, foodName);
            pstmt.setString(2, foodExplain);
            pstmt.setDouble(3, foodPrice);
            pstmt.setInt(4, businessId);
            pstmt.executeUpdate();

            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                foodId = rs.getInt(1);
            }
            return foodId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
            //rs1.close();
        }
        return 0;
    }

    @Override
    public int updateFood(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        int num = 0;
        //String sql = "select * from food where businessId = ?";
        String sql = "update food set foodName=?,foodExplain=?,foodPrice=? where foodId = ? and businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, foodName);
            pstmt.setString(2, foodExplain);
            pstmt.setDouble(3, foodPrice);
            pstmt.setInt(4, foodId);
            pstmt.setInt(5, businessId);
            System.out.println(pstmt);
            num = pstmt.executeUpdate();

            // 获取自增长的列
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
            //rs1.close();
        }
        return 0;
    }

    @Override
    public int deleteFood(Integer foodId, Integer businessId) {
        int num = 0;
        //String sql = "select * from food where businessId = ?";
        String sql = "delete from food where foodId = ? and businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, foodId);
            pstmt.setInt(2, businessId);
            System.out.println(pstmt);
            num = pstmt.executeUpdate();

            // 获取自增长的列
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
            //rs1.close();
        }
        return 0;
    }


}
