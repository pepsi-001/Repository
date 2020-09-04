package com.itheima.session.mapper;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 17:29
 *
 ****/
public class Mapper {
    //封装SQL语句
    private String sql;

    //封装返回结果集需要转换的JavaBean类型
    private String resultType;

    public Mapper(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public Mapper() {
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
