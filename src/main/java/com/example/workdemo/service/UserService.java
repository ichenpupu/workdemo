package com.example.workdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdemo.entity.Sys_User;
import com.example.workdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, Sys_User> {
    public boolean saveUser(Sys_User sys_user) {
        return saveOrUpdate(sys_user);
//        if (sys_user.getId() == null){
//            return save(sys_user);
//        }
//        else{
//            return updateById(sys_user);
//        }
    }
//    @Autowired
//    private UserMapper userMapper;

//    public int save(Sys_User sys_user){
//        if (sys_user.getId() == null){
//            userMapper.insert(sys_user);
//        }
//        else{
//            userMapper.update(sys_user);
//        }
//        return 1;
//    }


}

