package com.itheima.domain;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 17:22
 *
 ****/
public class IdCard {

    //身份证号
    private String number;
    //身份证地址
    private String address;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
