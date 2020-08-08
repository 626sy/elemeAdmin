package com.neusoft.view.Impl;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitorUtils;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/7 15:18
 */
public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);
    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家地址\t商家名称\t商家介绍\t起送费\t配送费");
        for(Business b:list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessName()
                                +"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }

    }

    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";

        System.out.println("是否输入需要输入商家名称关键字（y/n）");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入商家关键词");
            businessName = input.next();
        }

        System.out.println("是否输入需要输入商家地址关键字（y/n）");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入地址关键词");
            businessAddress = input.next();
        }
        BusinessDaoImpl Dao1 = new BusinessDaoImpl();
        List<Business> list = Dao1.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家地址\t商家名称\t商家介绍\t起送费\t配送费");
        for(Business b:list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessName()
                    +"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }


    }


    // 保存
    @Override
    public void saveBusiness() {
        System.out.println("请输入商家名字：");
        String businessName = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        if (businessId>0){
            System.out.println("新建商家成功，商家编号为"+businessId);
        }
        else {
            System.out.println("新建商家失败");
        }

    }

    @Override
    public void deleteBusiness() {

        System.out.println("请输入商家编号：");
        int id = input.nextInt();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessId = dao.deleBusiness(id);
        System.out.println("确定要删除吗（y/n)");
        String p = input.next();
        if (p.equals("y")){
            if (businessId>0){
                System.out.println("删除成功"+businessId);
            }
            else {
                System.out.println("删除失败");
            }
        }
    }


    @Override
    public void removeBusiness1(){
        System.out.println("请输入商家编号：");
        int id = input.nextInt();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int i = dao.removeBusiness(id);
        System.out.println("确定要删除吗（y/n)");
        String p = input.next();
        if (p.equals("y")){
            if (i==1){
                System.out.println("删除成功"+i);
            }
            else {
                System.out.println("删除失败");
            }
        }
    }




}
