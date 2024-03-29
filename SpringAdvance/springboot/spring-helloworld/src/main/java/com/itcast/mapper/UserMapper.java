package com.itcast.mapper;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @description:
 * @author: isquz
 * @time: 2022/4/12
 */

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from springboot_user")
    public List<User> findAllUser();

}
