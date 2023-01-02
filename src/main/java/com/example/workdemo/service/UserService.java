package com.example.workdemo.service;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdemo.controller.dto.UserDto;
import com.example.workdemo.entity.Sys_User;
import com.example.workdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, Sys_User> {
    private static final Log LOG = Log.get();

    public boolean saveUser(Sys_User sys_user) {
        return saveOrUpdate(sys_user);
//        if (sys_user.getId() == null){
//            return save(sys_user);
//        }
//        else{
//            return updateById(sys_user);
//        }
    }

    public boolean login(UserDto userDto) {
        QueryWrapper<Sys_User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        // 处理异常情况
        try {
            Sys_User one = getOne(queryWrapper);
            return one != null;
        } catch (Exception e) {
            LOG.error(e);
            return false;
        }
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

