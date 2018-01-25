package com.fanw.socialapp.service;

import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface EssayService {
    List<Essay> showAllEssays();
    List<Essay> showOneUserEssays(User user);
    int createOneEssay(Essay essay);
    int deleteOneEssayById(Essay essay);
    int giveThumb(Essay essay);
    int cancelThumb(Essay essay);
    Essay showOneEssayById(Essay essay);
}
