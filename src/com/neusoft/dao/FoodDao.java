package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> findall(Integer id);
    public int insert();
    public int update();
    public int delete();
}
