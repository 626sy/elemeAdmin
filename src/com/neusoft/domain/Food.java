package com.neusoft.domain;

import java.nio.charset.IllegalCharsetNameException;

/**
 * @author shihaobo
 * @date 2020/8/7 10:43
 */
public class Food {

    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Float foodPrice;
    private Integer BusinessId;
    public Food(){}

    public Food(Integer foodId, String foodName, String foodExplain, Float foodPrice, Integer businessId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        BusinessId = businessId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public Float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBusinessId() {
        return BusinessId;
    }

    public void setBusinessId(Integer businessId) {
        BusinessId = businessId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodExplain='" + foodExplain + '\'' +
                ", foodPrice=" + foodPrice +
                ", BusinessId=" + BusinessId +
                '}';
    }
}
