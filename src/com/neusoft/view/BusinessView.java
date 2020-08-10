package com.neusoft.view;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessView {
    public void listBusinessAll();
    //  按关键字查询商家信息
    public void listBusinessBySearch();
    // 新建商家信息
    public void saveBusiness();
    //  删除商家信息1
    public void deleteBusiness();
    //  删除商家信息2
    public void removeBusiness1();

    // 添加商家登录的方法
    public Business login();
    // 修改商家信息
    public void update(Integer businessId);
//    显示商家信息
    public void showBusinessById(Integer businessId);
    // 更新密码
    public void updateBusinessByPassword(Integer businessId);
}
