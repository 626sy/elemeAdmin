package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/7 14:52
 */
public class BusinessDaoImpl implements BusinessDao {
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;
    /*罗列*/
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        ArrayList<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            sql.append("and businessName like '%").append(businessName).append("%'");

        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了地址
            sql.append("and businessAddress like '%").append(businessAddress).append("%'");

        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getString("deliveryPrice"));
                list.add(business);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }

        return list;
    }
    /*
    * 查询
    */
    @Override
    public List<Business> searchBusiness(String businessName, String businessAddress) {
        ArrayList<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            System.out.println("请输入商家名称关键字");
            sql.append("and businessName like '%").append(businessName).append("%'");
        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了地址
            System.out.println("请输入商家地址关键字");
            sql.append("and businessAddress like '%").append(businessAddress).append("%'");
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();

            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getString("deliveryPrice"));
                list.add(business);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return list;
    }


    /*添加*/
    @Override
    public int saveBusiness(String businessName) {
        int businessId = 0;
        // 附带一个初始密码
        String sql = new String("insert into business(businessName, password) values(?,'1234')");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            // 可以在prepare Statement中设置返回自增长的列
            pstmt.setString(1,businessName);
//            pstmt.setInt(2,password);
            pstmt.executeUpdate();
            // 获取返回自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                businessId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }

        return businessId ;
    }


    /*删除*/
    @Override
    public int deleBusiness(Integer id) {

        String sql = new String("delete from business where businessId = ?");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return id;
    }
    @Override
    public int removeBusiness(int id){
        int count = 0;
        String sql = "delete from business where businessId = ?";
        Business business = new Business();
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            count = pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return count;
    }

}
