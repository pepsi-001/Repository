package com;

import com.itheima.jdbc.PeopleDaoImpl;
import com.itheima.jdbc.UserDaoImpl;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 17:57
 *
 ****/
public class MainThreadLocal {

    public static void main(String[] args) {
        PeopleDaoImpl peopleDao = new PeopleDaoImpl();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    long id = Thread.currentThread().getId();
                    System.out.println(id+"设置的数据是9");
                    peopleDao.setConnection(9);
                    Thread.sleep(5000);
                    System.out.println(id+"取出的数据是："+peopleDao.getConnection());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    long id = Thread.currentThread().getId();
                    System.out.println(id+"设置的数据是29");
                    peopleDao.setConnection(29);
                    System.out.println(id+"取出的值是:"+peopleDao.getConnection());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
