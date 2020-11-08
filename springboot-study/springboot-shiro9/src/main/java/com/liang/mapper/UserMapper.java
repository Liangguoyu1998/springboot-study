package com.liang.mapper;

import com.liang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-04 2020/11/4
 */
@Repository
@Mapper
public interface UserMapper {
    public User queryUserByName(String name);

}
