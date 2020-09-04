package com.itheima.service.impl;

import com.itheima.service.SaleService;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 16:07
 *
 ****/
public class SaleServiceImpl  implements SaleService {


    /**
     * 销售
     * @param money
     */
    @Override
    public void saleProduct(float money) {
        System.out.println("空调卖了"+money+"钱！");
    }

    /***
     * 售后
     * @param money
     */
    @Override
    public void afterService(float money) {
        System.out.println("维修收费"+money+"钱！");
    }
}
