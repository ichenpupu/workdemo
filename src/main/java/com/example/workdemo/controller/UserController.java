package com.example.workdemo.controller;

import com.example.workdemo.entity.sys_user;
import com.example.workdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @GetMapping("/")
    public List<sys_user> index(){
        List <sys_user> all =  userMapper.findAll();
        return all;
    }
}
