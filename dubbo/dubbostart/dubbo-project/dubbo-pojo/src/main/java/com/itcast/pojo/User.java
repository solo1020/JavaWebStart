package com.itcast.pojo;

import java.io.Serializable;

/**
 * @ClassName User
 * @description:
 * @author: isquz
 * @time: 2022/5/5
 */

// 所有pojo类都需要实现Serializable 接口
public class User implements Serializable {
    private int id;
    private String username;
    private String password;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
