package com.itheima.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 17:12
 *
 ****/
public class User {

    private String name;
    private Integer age;
    //Date类型
    /*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private Date birthday;

    //一对一映射关系
    private IdCard idCard;

    //一对多映射
    private List<Mobile> mobiles;

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", idCard=" + idCard +
                ", mobiles=" + mobiles +
                '}';
    }


}
