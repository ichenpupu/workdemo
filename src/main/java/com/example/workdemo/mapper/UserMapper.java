package com.example.workdemo.mapper;

import com.example.workdemo.entity.sys_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * from sys_user")
    List<sys_user> findAll();
}
