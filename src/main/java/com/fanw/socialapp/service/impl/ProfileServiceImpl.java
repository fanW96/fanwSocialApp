package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.ProfileMapper;
import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public int createProfleByUserId(User user) {
        return profileMapper.insertProfileByUserId(user);
    }

    @Override
    public Profile showProFileByUserId(User user) {
        return profileMapper.selectProfileByUserId(user);
    }

    @Override
    public int updateProfileById(Profile profile) {
        return profileMapper.updateProfileById(profile);
    }
}
