package com.itcast.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName MybatisOrder
 * @description:
 * @author: isquz
 * @time: 2021/10/19 22:22
 */
public class MybatisOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer user_id;
    private String number;
    private Date createtime;
    private String note;

    // left join联查对象
    private MybatisUser user;

    @Override
    public String toString() {
        return "MybatisOrder{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MybatisUser getUser() {
        return user;
    }

    public void setUser(MybatisUser user) {
        this.user = user;
    }
}
