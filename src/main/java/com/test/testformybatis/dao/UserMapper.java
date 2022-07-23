package com.test.testformybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.testformybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: L--L
 * @Date: 2022/7/8
 * @Desc:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
