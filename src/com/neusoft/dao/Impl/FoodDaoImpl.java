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
    /*查询信息*/
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
    /*添加信息*/
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
    /*更改信息*/
    @Override
    public int update(Integer id,String name) {
        int count = 0;
        String sql = new String("update food set foodName = ? where foodid=? ");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return count;
    }
    /*删除信息*/
    @Override
    public int delete(Integer id) {
        int count = 0;
        String sql = new String("delete from food where foodId = ?");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return count;
    }
//------------------------------------------------------------------------------------------
    @Override
    public List<Food> finaAll(Integer businessId) {

        Food food = null;
        ArrayList<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                food = new Food();
                food.setBusinessId(rs.getInt("businessId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getBigDecimal("foodPrice"));
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
    public Food getFoodById(Integer foodId) {
        return null;
    }

    @Override
    public int saveFood(Food food) {
        return 0;
    }

    @Override
    public int updateFood(Food food) {
        return 0;
    }

    @Override
    public int deleteFood(Integer foodId) {
        return 0;
    }

}
