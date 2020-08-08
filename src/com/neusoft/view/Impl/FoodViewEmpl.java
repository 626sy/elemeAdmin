package com.neusoft.view.Impl;

import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/8 9:00
 */
public class FoodViewEmpl implements FoodView {
    Scanner sc = new Scanner(System.in);
    @Override
    public void find() {
        System.out.println("请输入要查询的id");
        int id = sc.nextInt();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        List<Food> findall = foodDao.find(id);
        System.out.println("食品id"+"\t"+"食品名字"+"\t"+"食品解释"+"\t"+"食品价格"+"\t"+"商场id");
        for(Food f:findall){
            System.out.println(f.getFoodId()+"\t"+f.getFoodName()+"\t"+f.getFoodExplain()+"\t"+f.getFoodPrice()+"\t"+f.getBusinessId());
        }
    }

    @Override
    public void insert() {
        System.out.println("请输入要添加的食品");
        String name = sc.next();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        int id = foodDao.insert(name);
//        System.out.println(id);
        if (id>0){
            System.out.println("添加成功，编号为"+id);
        }else {
            System.out.println("添加失败");
        }

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
