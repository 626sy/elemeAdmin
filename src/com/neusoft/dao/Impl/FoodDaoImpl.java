package com.neusoft.dao.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/7 21:32
 */
public class FoodDaoImpl implements FoodDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<Food> findall(Integer id) {
        String sql = "select * from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
