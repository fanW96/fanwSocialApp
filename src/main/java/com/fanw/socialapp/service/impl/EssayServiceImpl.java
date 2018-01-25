package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.EssayMapper;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "essayService")
public class EssayServiceImpl implements EssayService{

    @Autowired
    private EssayMapper essayMapper;

    @Override
    public List<Essay> showAllEssays() {
        return essayMapper.selectAllEssays();
    }

    @Override
    public List<Essay> showOneUserEssays(User user) {
        return essayMapper.selectOneUserEssays(user);
    }

    @Override
    public int createOneEssay(Essay essay) {
        return essayMapper.insertOneEssay(essay);
    }

    @Override
    public int deleteOneEssayById(Essay essay) {
        return essayMapper.deleteOneEssayById(essay);
    }

    @Override
    public int giveThumb(Essay essay) {
        return essayMapper.increaseThumbs(essay);
    }

    @Override
    public int cancelThumb(Essay essay) {
        return essayMapper.decreaseThumbs(essay);
    }

    @Override
    public Essay showOneEssayById(Essay essay) {
        return essayMapper.selectOneEssayById(essay);
    }
}
