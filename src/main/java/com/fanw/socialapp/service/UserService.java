package com.fanw.socialapp.service;

import com.fanw.socialapp.model.User;

public interface UserService {
    User loginByMail(User user);
    User loginByPhone(User user);
    int uploadHeadById(User user);
    int registerUserByMail(User user);
    int login_updateStatusById(User user);
    int signOut_updateStatusById(User user);
}
