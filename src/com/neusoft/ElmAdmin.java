package com.neusoft;

import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewEmpl;

import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/7 11:30
 */
public class ElmAdmin {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t饿了么控制台后台管理系统 V1.0\t\t\t\t");
        System.out.println("-----------------------------------------------");
        Scanner input = new Scanner(System.in);
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();

        if (admin != null) {
            System.out.println("请选择服务，1、商家管理，2、食品管理");
            int s = input.nextInt();
            if(s==1){
                work();
            }else if (s==2){
                food();
            }

        }
        else {
            System.out.println("用户名或密码错误,请重新输入");
            adminView.login();

        }
    }

    public static void work() {
        Scanner input = new Scanner(System.in);
        BusinessViewImpl businessView = new BusinessViewImpl();
        int menu = 0;

        while (menu != 5) {

            // 创建一个菜单
            System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
            System.out.println("请选择行相应的菜单编号");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("1.所有商家列表");
                    businessView.listBusinessAll();
                    break;
                case 2:
                    System.out.println("2.搜索商家");
                    businessView.listBusinessBySearch();
                    break;
                case 3:
                    System.out.println("3.新建商家");
                    businessView.saveBusiness();
                    break;
                case 4:
                    System.out.println("4.删除商家");
//                        businessView.deleteBusiness();
                    businessView.removeBusiness1();
                    break;

                case 5:
                    System.out.println("========= 欢迎下次光临饿了么系统 =========");
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }

        }

    }
    public static void food(){
        Scanner sc = new Scanner(System.in);
        FoodViewEmpl foodViewEmpl = new FoodViewEmpl();
        System.out.println("请输入操作方式");
        int i = sc.nextInt();
        switch (i){
            case 1:
                System.out.println("食物查询");
                foodViewEmpl.find();
                break;
            case 2:
                System.out.println("添加食物");
                foodViewEmpl.insert();
                break;
            case 3:
                System.out.println("修改食物信息");
                break;
            case 4:
                System.out.println("删除食物");
                break;
            case 5:
                System.out.println("显示所有食物");
                break;
            case 6:
                System.out.println("退出");
                break;
            default:
                System.out.println("没有该选项");
                break;


        }


    }
}
