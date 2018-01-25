package com.fanw.socialapp.mapper;

import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface EssayMapper {
    List<Essay> selectAllEssays();
    List<Essay> selectOneUserEssays(User user);
    int insertOneEssay(Essay essay);
    int deleteOneEssayById(Essay essay);
    int increaseThumbs(Essay essay);
    int decreaseThumbs(Essay essay);
    Essay selectOneEssayById(Essay essay);
}
