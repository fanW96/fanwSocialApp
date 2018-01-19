package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.RelationMapper;
import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.Relation;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "relationService")
public class RelationServiceImpl implements RelationService{

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public int getFansCount(User user) {
        return relationMapper.selectFansCount(user);
    }

    @Override
    public int getUpsCount(User user) {
        return relationMapper.selectUpsCount(user);
    }

    @Override
    public int createFollow(Relation relation) {
        return relationMapper.insertRelation(relation);
    }

    @Override
    public int cancelFollow(Relation relation) {
        return relationMapper.deleteRelation(relation);
    }

    @Override
    public List<Relation> showAllFans(User user) {
        return relationMapper.selectAllFans(user);
    }
}
