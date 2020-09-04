package com.itheima.domain;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/12 17:04
 *
 ****/
public class Account {
    private Integer id;
    private Double money;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", uid=" + uid +
                '}';
    }
}
