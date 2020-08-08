package com.neusoft.dao.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Food> find(Integer id) {
        ArrayList<Food> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from food where foodId = ?");

        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            if (id != null){
                pstmt.setInt(1,id);
            }
            rs = pstmt.executeQuery();
            while (rs.next()){
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getBigDecimal("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }


        return list;
    }

    @Override
    public int insert(String foodName) {
        int foodId = 0;
        String sql = new String("insert into food(foodName,foodPrice,businessId) values(?,'15','100002')");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,foodName);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                foodId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return foodId;
    }

    @Override
    public int update(Food food) {
        return 0;
    }

    @Override
    public int delete(Food food) {
        return 0;
    }


}
