package com.fanw.socialapp.model;

import java.util.List;

public class CommentJson {
    private int code;
    private String msg;
    private List<Comment> commentList;
    private Comment comment;

    public CommentJson(int code, String msg, List<Comment> commentList) {
        this.code = code;
        this.msg = msg;
        this.commentList = commentList;
    }

    public CommentJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommentJson(int code, String msg, Comment comment) {
        this.code = code;
        this.msg = msg;
        this.comment = comment;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
