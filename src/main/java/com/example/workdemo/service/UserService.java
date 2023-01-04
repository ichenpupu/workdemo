package com.example.workdemo.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workdemo.common.Constants;
import com.example.workdemo.controller.dto.UserDto;
import com.example.workdemo.entity.Sys_User;
import com.example.workdemo.exception.ServiceException;
import com.example.workdemo.mapper.UserMapper;
import com.example.workdemo.utils.TokenUtils;
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

    public UserDto login(UserDto userDto) {
        Sys_User one = getUserInfo(userDto);
        if (one != null) {
            BeanUtil.copyProperties(one, userDto, true);
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDto.setToken(token);
            return userDto;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }



    private Sys_User getUserInfo(UserDto userDto) {
        QueryWrapper<Sys_User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        Sys_User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }


    public Sys_User register(UserDto userDto) {
        Sys_User one = getUserInfo(userDto);
        if (one == null) {
            one = new Sys_User();
            BeanUtil.copyProperties(userDto, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }
}

