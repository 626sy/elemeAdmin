package com.neusoft.view.Impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;

import java.util.Scanner;

/**
 * @author shihaobo
 * @date 2020/8/7 11:43
 */
public class AdminViewImpl implements AdminView {
    private Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入管理员用户名");
        String adminName = input.next();
        System.out.println("请输入管理员密码");
        String password = input.next();
        AdminDao adminDao = new AdminDaoImpl();
//        Admin adminByNameByPass = adminDao.getAdminByNameByPass(adminName, password);
//        return adminByNameByPass;
        return adminDao.getAdminByNameByPass(adminName, password);
    }
}
