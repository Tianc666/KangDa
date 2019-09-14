package com.ssm.service.impl;

import com.ssm.dao.mapper.UserMapper;
import com.ssm.entity.Salesmessage;
import com.ssm.entity.User;
import com.ssm.entity.UserExample;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> SelectUser(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int InsertUser(User user) {
        return userMapper.insert(user);
    }



}
