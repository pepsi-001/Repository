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

    //一个账号属于一个用户
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
