package com.itheima.domain;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 17:28
 *
 ****/
public class Mobile {

    //手机名字
    private String mobileName;
    //手机价格
    private Float price;

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileName='" + mobileName + '\'' +
                ", price=" + price +
                '}';
    }
}
