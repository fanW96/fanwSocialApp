package com.fanw.socialapp.service.impl;

import com.fanw.socialapp.mapper.CommentMapper;
import com.fanw.socialapp.model.Comment;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int createOneComment(Comment comment) {
        return commentMapper.insertOneComment(comment);
    }

    @Override
    public int deleteOneComment(Comment comment) {
        return commentMapper.deleteOneComment(comment);
    }

    @Override
    public List<Comment> showOneEssayComments(int pageNum, int pageSize,Essay essay) {
        PageHelper.startPage(pageNum, pageSize);
        return commentMapper.selectOneEssayComments(essay);
    }

    @Override
    public List<Comment> showOneUserComments(int pageNum, int pageSize,User user) {
        PageHelper.startPage(pageNum, pageSize);
        return commentMapper.selectOneUserComments(user);
    }

    @Override
    public List<Comment> showReceivedComments(int pageNum, int pageSize,User user) {
        PageHelper.startPage(pageNum, pageSize);
        return commentMapper.selectReceivedComments(user);
    }
}
