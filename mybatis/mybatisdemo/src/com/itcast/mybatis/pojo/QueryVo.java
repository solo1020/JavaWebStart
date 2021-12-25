package com.itcast.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName QueryVo
 * @description:
 * @author: isquz
 * @time: 2021/10/6 13:12
 */
public class QueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Category category;

    // 商品pid集合
    List<String> pidList;
    String[] pids;

    public List<String> getPidList() {
        return pidList;
    }

    public void setPidList(List<String> pidList) {
        this.pidList = pidList;
    }

    public String[] getPids() {
        return pids;
    }

    public void setPids(String[] pids) {
        this.pids = pids;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }


}
