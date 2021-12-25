package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.Category;
import com.itcast.mybatis.pojo.QueryVo;

import java.util.List;

/**
 * @ClassName CategoryMapper
 * @description:
 * @author: isquz
 * @time: 2021/10/1 17:48
 */
public interface CategoryMapper {

    /*
     * 四个原则
     * 接口方法名 与 XXXMapper.xml中的 sql语句的id
     * 返回值类型 与 XXXMapper.xml中的返回值类型一致
     * 方法入参类型 与 XXXMapper.xml中的一致
     * XXXMapper.xml中的命名空间 与 Mapper接口名一致
     */

    public Category findCategoryById(String id);

    public List<Category> findCategoryByQueryVo(QueryVo queryVo);

    public Integer countCategory();
}
