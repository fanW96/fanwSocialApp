package com.fanw.socialapp.mapper;

import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.User;

public interface ProfileMapper {
    int insertProfileByUserId(User user);
    Profile selectProfileByUserId(User user);
    int updateProfileById(Profile profile);
}
