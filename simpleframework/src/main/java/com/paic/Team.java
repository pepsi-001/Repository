package com.paic;

import java.util.List;

public class Team {

    /**
     * status : 0
     * msg : 操作成功
     * data : {"a":"1"}
     * datalist : [{"a":"1"},{"B":"2"}]
     */

    private int status;
    private String msg;
    private DataBean data;
    private List<DatalistBean> datalist;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<DatalistBean> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<DatalistBean> datalist) {
        this.datalist = datalist;
    }

    public static class DataBean {
        /**
         * a : 1
         */

        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    public static class DatalistBean {
        /**
         * a : 1
         * B : 2
         */

        private String a;
        private String B;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return B;
        }

        public void setB(String B) {
            this.B = B;
        }
    }
}
