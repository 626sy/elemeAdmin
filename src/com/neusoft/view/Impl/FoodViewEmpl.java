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
    /*查询食品*/
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
    /* 添加信息*/
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
    /*更改信息*/
    @Override
    public void update() {
        System.out.println("请输入修改的id");
        int id = sc.nextInt();
        System.out.println("请输入修改的名字");
        String name = sc.next();
        Food food = new Food();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        int update = foodDao.update(id, name);
        if (update>0){
            System.out.println("信息修改成功");
        }else {
            System.out.println("信息修改失败");
        }
    }
    /*删除信息*/
    @Override
    public void delete() {
        System.out.println("请输入删除信息的id");
        int id = sc.nextInt();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        int delete = foodDao.delete(id);
        if (delete>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }
}
