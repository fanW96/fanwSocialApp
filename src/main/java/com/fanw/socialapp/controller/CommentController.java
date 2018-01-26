package com.fanw.socialapp.controller;

import com.fanw.socialapp.model.Comment;
import com.fanw.socialapp.model.CommentJson;
import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.CommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*
    * 发表一条新的评论
    * @param comment_content,user.user_id,essay.essay_id
    * */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createOneComment(Comment comment){
        String callback;
        int temp =0;
        temp = commentService.createOneComment(comment);
        if (temp == 1){
            callback = new Gson().toJson(new CommentJson(200,"success"));
        }else {
            callback = new Gson().toJson(new CommentJson(500,"create error,please retry"));
        }
        return callback;
    }

    /*
     * 删除一条评论
     * @param comment_id
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteOneComment(Comment comment){
        String callback;
        int temp =0;
        temp = commentService.deleteOneComment(comment);
        if (temp == 1){
            callback = new Gson().toJson(new CommentJson(200,"success"));
        }else {
            callback = new Gson().toJson(new CommentJson(500,"delete error,please retry"));
        }
        return callback;
    }

    /*
     * 显示一条essay的全部评论
     * @param essay_id
     * */
    @RequestMapping(value = "/showAll",method = RequestMethod.POST)
    public String showOneEssayComments(Essay essay){
        List<Comment> temp = new ArrayList<>();
        String callback;
        temp = commentService.showOneEssayComments(essay);
        if(temp != null){
            callback = new Gson().toJson(new CommentJson(200,"success",temp));
        }else{
            callback = new Gson().toJson(new CommentJson(500,"no comments"));
        }
        return callback;
    }

    /*
     * 显示一个用户发表的全部评论
     * @param user_id
     * */
    @RequestMapping(value = "/showPassed",method = RequestMethod.POST)
    public String showOneUserComments(User user){
        List<Comment> temp = new ArrayList<>();
        String callback;
        temp = commentService.showOneUserComments(user);
        if(temp != null){
            callback = new Gson().toJson(new CommentJson(200,"success",temp));
        }else{
            callback = new Gson().toJson(new CommentJson(500,"no comments"));
        }
        return callback;
    }

    /*
     * 显示一个用户收到的全部评论
     * @param
     * error 没有想到如何解决查询一个user_id对应的收到的评论的评论人的name,head
     * 暂时先只取出相应评论人的id,在单独取出相应的name,head
     * */
    @RequestMapping(value = "/showReceived",method = RequestMethod.POST)
    public String showReceivedComments(User user){
        List<Comment> temp = new ArrayList<>();
        String callback;
        temp = commentService.showReceivedComments(user);
        if(temp != null){
            callback = new Gson().toJson(new CommentJson(200,"success",temp));
        }else{
            callback = new Gson().toJson(new CommentJson(500,"no comments"));
        }
        return callback;
    }
}
