package com.test.testformybatis.controller;

import com.test.testformybatis.dao.UserMapper;
import com.test.testformybatis.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: L--L
 * @Date: 2022/7/8
 * @Desc:
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

//    @RequestMapping("/user/{id}")
    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int account){
        userMapper.deleteById(account);
        return "ok!";
    }

    @PostMapping("/addUser")
    public void addUser(User user){
        userMapper.insert(user);
    }


    @PatchMapping("/updateUser")
    public void update(User user){
        userMapper.updateById(user);
    }
}
