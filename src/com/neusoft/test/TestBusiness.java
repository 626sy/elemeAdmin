package com.neusoft.test;

import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.Impl.BusinessViewImpl;

import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/7 15:01
 */
public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        List<Business> list = businessDao.listBusiness("饺子", "null");
        for(Business l:list){
            System.out.println(l.getBusinessId()+l.getStartPrice());
        }



    }
}
