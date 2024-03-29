package com.itcast.mybatis.pojo;

/**
 * @ClassName Category
 * @description:
 * @author: isquz
 * @time: 2021/8/2 1:26
 */
public class Category {
    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category(){};

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname=" + cname + "}\n";
    }
}
