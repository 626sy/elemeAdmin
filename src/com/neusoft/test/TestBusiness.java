package com.neusoft.test;

import com.neusoft.dao.Impl.BusinessDaoImpl;

/**
 * @author shihaobo
 * @date 2020/8/7 15:01
 */
public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        businessDao.listBusiness("饺子",null);
    }
}
