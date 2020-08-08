package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> find(Integer id);
    public int insert(String foodName);
    public int update(Integer id,String name);
    public int delete(Integer id);
}
