package com.fanw.socialapp.model;

import java.util.List;

public class RelationJson {
    private int code;
    private String msg;
    private List<Relation> relationList;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }

    public RelationJson(int code, String msg, List<Relation> relationList) {
        this.code = code;
        this.msg = msg;
        this.relationList = relationList;
    }

    public RelationJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RelationJson(int code, String msg, int count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
    }
}
