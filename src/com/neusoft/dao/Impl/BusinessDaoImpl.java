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
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Business> list = null;
        StringBuffer sql = new StringBuffer("insert into bussiness where 1=1 ");

        if(businessName!=null && !( businessName.equals(""))) {
            sql.append(" and businessName like '%"+businessName+"%' ");
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
        return 0;
    }

    @Override
    public int update(Integer id, Integer score) {
        return 0;
    }

    @Override
    public int remove(Integer id) {
        return 0;
    }
}
