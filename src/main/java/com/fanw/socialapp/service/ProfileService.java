package com.fanw.socialapp.service;

import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.User;

public interface ProfileService {
    int createProfleByUserId(User user);
    Profile showProFileByUserId(User user);
    int updateProfileById(Profile profile);
}
