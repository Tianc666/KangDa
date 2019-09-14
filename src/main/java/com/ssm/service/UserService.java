package com.ssm.service;

import com.ssm.entity.Salesmessage;
import com.ssm.entity.User;
import com.ssm.entity.UserExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    List<User> SelectUser(UserExample userExample);
    int InsertUser(User user);

}
