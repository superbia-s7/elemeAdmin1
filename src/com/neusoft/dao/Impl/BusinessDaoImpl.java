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
    public int update(Integer id, Integer score) {
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
}
