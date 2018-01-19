package com.fanw.socialapp.mapper;

import com.fanw.socialapp.model.User;

import java.io.File;

public interface UserMapper {
    User selectByMail(User user);
    User selectByPhone(User user);
    /*update和insert只能使用int作为返回类型，成功的话返回的是1,失败的话返回的是0*/
    int uploadHeadById(User user);
    int insertByMail(User user);
    int updateStatusById(User user);
}
