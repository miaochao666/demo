package com.example.demo.service;

import com.example.demo.domain.entity.User;

import java.util.List;


public interface UserService {

    public List<User> selectAllUser();

    //public User selectUserByName(String name);
}
