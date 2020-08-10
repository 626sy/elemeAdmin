package com.neusoft.view;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodView {
    /*查找信息*/
    public void find();
    /*添加信息*/
    public void insert();
    /*更改信息*/
    public void update();
    /*删除信息*/
    public void delete();
    //==========================================================
    public void showFoodList(Integer businessId);
    public void saveFood(Integer businessId);
    public void updateFood(Integer businessId);
    public void removeFood(Integer businessId);
}
