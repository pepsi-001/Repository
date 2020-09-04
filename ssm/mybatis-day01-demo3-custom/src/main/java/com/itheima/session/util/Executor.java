package com.itheima.session.util;

import com.itheima.session.mapper.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 5:53
 *
 ****/
public class Executor {

    /***
     * 集合查询
     * @param conn
     * @param mapper
     * @param <E>
     * @return
     */
    public static <E> List<E> list(Connection conn, Mapper mapper) {
        //执行查询
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        try {
            //获取PreparedStatment
            stm = conn.prepareStatement(mapper.getSql());

            //执行查询
            resultSet = stm.executeQuery();

            //调用Converter实现转换
            List<E> list = Converter.list(resultSet, Class.forName(mapper.getResultType()));

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}