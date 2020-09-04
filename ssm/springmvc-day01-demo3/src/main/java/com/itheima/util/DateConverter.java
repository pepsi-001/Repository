package com.itheima.util;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 17:48
 *      Converter<String,Date>
 *               String:前台接收的数据是String类型
 *               Date:要转换成Date类型
 ****/
public class DateConverter implements Converter<String,Date> {

    /****
     * 类型转换
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
