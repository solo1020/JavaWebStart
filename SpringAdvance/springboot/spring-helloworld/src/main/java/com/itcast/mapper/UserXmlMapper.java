package com.itcast.mapper;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserXmlMapper
 * @description:
 * @author: isquz
 * @time: 2022/4/14
 */

@Mapper
@Repository
public interface UserXmlMapper {
    public List<User> findAllUser();
}
