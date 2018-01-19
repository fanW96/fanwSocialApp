package com.fanw.socialapp.mapper;

import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.Relation;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface RelationMapper {
    int selectFansCount(User user);
    int selectUpsCount(User user);
    int insertRelation(Relation relation);
    int deleteRelation(Relation relation);
    List<Relation> selectAllFans(User user);
}
