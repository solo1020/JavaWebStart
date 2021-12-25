package com.itcast.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Orders
 * @description:
 * @author: isquz
 * @time: 2021/10/8 0:08
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private String oid;
    private Date otime;
    private double total;
    private int state;
    private String address;
    private String name;
    private String tel;
    private String uid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", otime=" + otime +
                ", total=" + total +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
