package com.neusoft.dao;

import com.neusoft.domain.Admin;

public interface AdminDao {
    // 查询
    public Admin getAdminByNameByPass(String adminName, String password);
    // 修改
    public void updateAdmin(Admin admin);
}