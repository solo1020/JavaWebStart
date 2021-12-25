package com.itcast.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisUser
 * @description:
 * @author: isquz
 * @time: 2021/10/19 22:24
 */
public class MybatisUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    // 一对多 用户对应多个订单
    private List<MybatisOrder> orders;

    @Override
    public String toString() {
        return "MybatisUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }

    public List<MybatisOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<MybatisOrder> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
