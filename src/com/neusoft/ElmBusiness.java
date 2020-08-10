package com.neusoft;

import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewEmpl;

import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/10 9:05
 */
public class ElmBusiness {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t饿了么控制台后台管理系统 V1.0\t\t\t\t");
        System.out.println("-----------------------------------------------");

        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();
        if (business != null){
            int menu = 0;
            System.out.println("欢迎来到饿了么系统");
            while (menu!=5){
                System.out.println("========= 一级菜单1.查看商品信息=2.更新商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择行相应的菜单编号");
                menu = input.nextInt();
                switch (menu)
                {
                    case 1:
                        System.out.println("查看商品信息");
                        businessView.showBusinessById(business.getBusinessId());
                        break;
                    case 2:
                        System.out.println("更新商家信息");
                        businessView.update(business.getBusinessId());
                        break;
                    case 3:
                        System.out.println("更新密码");

                        break;
                    case 4:
                        System.out.println("所属商品管理");
                        foodManage(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("退出");
                        break;
                    default:
                        System.out.println("查无此项");
                        break;
                }
            }
        }else {
            System.out.println("用户名或密码错误");
        }


    }
/*===============================businesswork方法========================================*/
/*    public static void businesswork(){
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

    }*/


    private  static  void foodManage(int businessId){
        FoodView foodview = new FoodViewEmpl();
        int menu = 0;
        while (menu!= 5){

            // 创建一个菜单
            System.out.println("========= 二级菜单（美食管理）1.查看食品列表2.新增食品 3.修改食品=4.删除食品=5.返回一级菜单 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();

            switch (menu){
                case 1:
                    foodview.showFoodList(businessId);
                    break;
                case 2:
                    System.out.println("新增食品");

                    break;
                case 3:
                    System.out.println("修改食品");

                    break;
                case 4:
                    System.out.println("删除食品");

                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }

        }

    }
}
