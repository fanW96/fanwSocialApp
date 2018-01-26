package com.fanw.socialapp.mapper;

import com.fanw.socialapp.model.Comment;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface CommentMapper {
    int insertOneComment(Comment comment);
    int deleteOneComment(Comment comment);
    List<Comment> selectOneEssayComments(Essay essay);
    List<Comment> selectOneUserComments(User user);
    List<Comment> selectReceivedComments(User user);
}
