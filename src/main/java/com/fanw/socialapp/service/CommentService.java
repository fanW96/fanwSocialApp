package com.fanw.socialapp.service;

import com.fanw.socialapp.model.Comment;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;

import java.util.List;

public interface CommentService {
    int createOneComment(Comment comment);
    int deleteOneComment(Comment comment);
    List<Comment> showOneEssayComments(Essay essay);
    List<Comment> showOneUserComments(User user);
    List<Comment> showReceivedComments(User user);
}
