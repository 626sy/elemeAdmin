package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    // 显示所有商家列表  可选输入商家businessName和businessAddress
    public List<Business> listBusiness(String businessName,String businessAddress);
    // 搜索商家
    public List<Business> searchBusiness(String businessName,String businessAddress);
    // 保存
    public int saveBusiness(String businessName);
    // 删除
    public int deleBusiness(Integer id);

}
