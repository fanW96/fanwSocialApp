package com.fanw.socialapp.service;

import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.Relation;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface RelationService {
    int getFansCount(User user);
    int getUpsCount(User user);
    int createFollow(Relation relation);
    int cancelFollow(Relation relation);
    List<Relation> showAllFans(User user);
    List<Relation> showAllUps(User user);
}
