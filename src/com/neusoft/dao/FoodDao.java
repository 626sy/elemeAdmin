package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> find(Integer id);
    public int insert(String foodName);
    public int update(Integer id,String name);
    public int delete(Integer id);

    //--------------------------------------------------
    public List<Food> finaAll(Integer businessId);
    public Food getFoodById(Integer foodId);
    public int saveFood(Food food);
    public int updateFood(Food food);
    public int deleteFood(Integer foodId);
}
