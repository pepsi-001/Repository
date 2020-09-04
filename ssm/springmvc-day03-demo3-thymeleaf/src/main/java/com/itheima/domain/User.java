package com.itheima.domain;

import java.io.Serializable;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 18:24
 *
 ****/
public class User implements Serializable {

    private String name;

    private String address;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
