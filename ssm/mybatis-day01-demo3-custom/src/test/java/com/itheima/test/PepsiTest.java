package com.itheima.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * author: Hsheng
 * date: 2020/8/28 14:35
 * description: TODO
 * version: 1.02
 */
public class PepsiTest {
    @Test
    public void testList() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","hello");
        map.put("2","hello2");
        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
    }
}
