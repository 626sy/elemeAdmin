package com.neusoft.test;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;


public class TestAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
        System.out.println(admin);
        // update
        Admin admin2 = new Admin();
        admin2.setAdminId(2);
        admin2.setAdminName("赵四");
        admin2.setPassword("456789");
        adminDao.updateAdmin(admin2);
    }
}