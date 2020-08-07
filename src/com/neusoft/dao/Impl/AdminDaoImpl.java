package com.neusoft.dao.Impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.domain.Admin;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;

/**
 * @author Eric Lee
 * @date 2020/8/7 09:48
 */
public class AdminDaoImpl implements AdminDao {
    private  Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;

    // 查询
    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        Admin admin = null;
        String sql = "select * from admin where adminName = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }

        return admin;
    }

    @Override
    public void updateAdmin(Admin admin) {
        int count = 0;
        String sql = "update admin set adminName = ?,password = ? where adminId = ?;";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,rs.getString("adminName"));
//            pstmt.setString(2,rs.getString("password"));
//            pstmt.setInt(3,rs.getInt("adminId"));
            pstmt.setString(1,admin.getAdminName());
            pstmt.setString(2,admin.getPassword());
            pstmt.setInt(3,admin.getAdminId());
            count = pstmt.executeUpdate();
            if (count == 1){
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }

    // 修改
}
