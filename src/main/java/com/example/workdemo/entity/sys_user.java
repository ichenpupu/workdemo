package com.example.workdemo.entity;

import lombok.Data;

@Data
public class sys_user {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;


}
