package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.EssayMapper;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.EssayService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "essayService")
public class EssayServiceImpl implements EssayService{

    @Autowired
    private EssayMapper essayMapper;


    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<Essay> showAllEssays(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return essayMapper.selectAllEssays();
    }

    @Override
    public List<Essay> showOneUserEssays(int pageNum, int pageSize,User user) {
        PageHelper.startPage(pageNum, pageSize);
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
