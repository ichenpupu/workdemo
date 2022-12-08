package com.example.workdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workdemo.entity.Sys_User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<Sys_User> {
//    @Select("SELECT * from sys_user")
//    List<Sys_User> findAll();
//
//    @Insert("INSERT INTO sys_user (username,password,nickname,email,phone,address) VALUES (#{username}," +
//            "#{password},#{nickname},#{email},#{phone},#{address})")
//    int insert(Sys_User sys_user);
//
//    int update(Sys_User sys_user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like #{username} limit #{pageNum},#{pageSize}")
//    List <Sys_User> selectPage(Integer pageNum, Integer pageSize, String username);
//
//    @Select("select count(*) from sys_user where username like #{username}")
//    Integer selectTotal(String username);
}
