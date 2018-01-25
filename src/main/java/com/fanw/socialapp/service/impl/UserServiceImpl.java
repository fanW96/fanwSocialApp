package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.UserMapper;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginByMail(User user) {
        return userMapper.selectByMail(user);
    }

    @Override
    public User loginByPhone(User user) {
        return userMapper.selectByPhone(user);
    }

    @Override
    public int uploadHeadById(User user) {

        return userMapper.uploadHeadById(user);
    }

    @Override
    public int registerUserByMail(User user) {
        return userMapper.insertByMail(user);
    }

    @Override
    public int registerUserByPhone(User user) {
        return userMapper.insertByPhone(user);
    }

    @Override
    public int login_updateStatusById(User user) {
        return userMapper.updateStatusById(user);
    }

    @Override
    public int signOut_updateStatusById(User user) {
        return userMapper.updateStatusById(user);
    }
}
