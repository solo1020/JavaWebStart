package com.itcast.domain;

import java.util.List;

/**
 * @ClassName ValueObject
 * @description: 用来包装
 * @author: isquz
 * @time: 2021/11/29 21:38
 */
public class ValueObject {
    private List<MybatisUser> userList;

    public List<MybatisUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MybatisUser> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "userList=" + userList +
                '}';
    }
}
