package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    @Override
    public List<Business> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Business> list = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from business;";
            stmt = conn.createStatement();
            // 封装查询结果
            rs = stmt.executeQuery(sql);

            list = new ArrayList<>();


            while (rs.next()) {
                Business business = new Business();

                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                list.add(business);
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

        @Override
    public List<Business> select(String businessName,String businessAddress) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<Business> list = null;
            StringBuffer sql = new StringBuffer("select * from business where 1=1 ");

            if(businessName!=null && !( businessName.equals(""))) {
                sql.append(" and businessName like '%"+businessName+"%' ");
            }
            if(businessAddress!=null && ! (businessAddress.equals(""))){
                sql.append(" and businessAddress like '%"+businessAddress+"%' ");
            }

            try {
                conn = JDBCUtils.getConnection();

                pstmt = conn.prepareStatement(sql.toString());
                // 封装查询结果
                rs = pstmt.executeQuery();

                list = new ArrayList<Business>();


                while (rs.next()) {
                    Business business = new Business();

                    business.setBusinessId(rs.getInt(1));
                    business.setPassword(rs.getString(2));
                    business.setBusinessName(rs.getString(3));
                    business.setBusinessAddress(rs.getString(4));
                    business.setBusinessExplain(rs.getString(5));
                    business.setStarPrice(rs.getDouble(6));
                    business.setDeliveryPrice(rs.getDouble(7));
                    list.add(business);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs,pstmt,conn);
            }
            return list;
    }

    @Override
    public int insert(String businessName) {
        int businessId = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Business> list = null;

        String sql = "insert into business(businessName, password)values(?, '123')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // 可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, businessName);
            pstmt.executeUpdate();
            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                businessId = rs.getInt(1);
            }
            return businessId;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return 0;
    }

    @Override
    public int update(Integer businessId,
                      String businessName,
                      String businessAddress,
                      String businessExplain,
                      Double starPrice,
                      Double deliveryPrice) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String sql = "update business set businessName = ?,businessAddress = ?,businessExplain = ?,starPrice =?,deliveryPrice = ? where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            // 可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, businessName);
            pstmt.setString(2, businessAddress);
            pstmt.setString(3, businessExplain);
            pstmt.setDouble(4, starPrice);
            pstmt.setDouble(5, deliveryPrice);
            pstmt.setInt(6, businessId);
            System.out.println(pstmt);
            int a=pstmt.executeUpdate();


                return a;


        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return 0;
    }

    @Override
    public int remove(Integer id) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Business> list = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from business where businessId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            // 封装查询结果

            int num = pstmt.executeUpdate();

            return num;

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return 0;
    }

    @Override
    public Business getBusinessByNameByPass(Integer businessId, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return business;
    }

    @Override
    public Business searchBusiness(Integer businessId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = new String("select * from business where businessId = ? ");
        Business business = new Business();
        try {
            conn = JDBCUtils.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            // 封装查询结果
            rs = pstmt.executeQuery();




            while (rs.next()) {


                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return business;
    }
}
