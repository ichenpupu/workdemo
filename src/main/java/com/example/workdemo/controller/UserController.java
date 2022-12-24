package com.example.workdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workdemo.entity.Sys_User;
import com.example.workdemo.mapper.UserMapper;
import com.example.workdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    public UserService userService;


    @GetMapping
    public List<Sys_User> findAll(){
        return userService.list();
//        List <Sys_User> all =  userMapper.findAll();
//        return all;
    }

    @PostMapping
    public boolean save(@RequestBody Sys_User sys_user){
        return userService.saveUser(sys_user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) { // [1,2,3]
        return userService.removeByIds(ids);
    }

//    分页查询 - mybatis-plus
    @GetMapping("/page")
    public IPage<Sys_User> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(defaultValue = "") String username,
                                        @RequestParam(defaultValue = "") String email,
                                        @RequestParam(defaultValue = "") String address){
        IPage<Sys_User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Sys_User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if (!"".equals(email)){
            queryWrapper.like("email",email);
        }
        if (!"".equals(address)) {
            queryWrapper.or().like("address", address);
        }
        queryWrapper.orderByDesc("id");
        return userService.page(page, queryWrapper);
    }
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                   @RequestParam Integer pageSize,
//                                   @RequestParam String username){
//        pageNum = (pageNum - 1) * pageSize;
//        username = "%" + username + "%";
//        List<Sys_User> data = userMapper.selectPage(pageNum, pageSize, username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", data);
//        res.put("total", total);
//        return res;
//    }

}
