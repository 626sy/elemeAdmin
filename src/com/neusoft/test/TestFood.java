package com.neusoft.test;

import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewEmpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/8 9:21
 */
public class TestFood {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入查询的id");
//        int id = scanner.nextInt();

//        FoodDaoImpl foodDao = new FoodDaoImpl();
//        List<Food> i =   foodDao.find(null);
//        for(Food f :i){
//            System.out.println(f.getBusinessId()+f.getFoodName()+f.getFoodExplain()+f.getFoodPrice()+f.getBusinessId());
//        }


        FoodDaoImpl foodDao = new FoodDaoImpl();
        foodDao.insert("sdfsd");
    }
}
