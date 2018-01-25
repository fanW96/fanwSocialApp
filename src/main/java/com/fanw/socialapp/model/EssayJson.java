package com.fanw.socialapp.model;

import java.util.List;

public class EssayJson {
    private int code;
    private String msg;
    private Essay essay;
    private List<Essay> essayList;

    public EssayJson(int code, String msg, List<Essay> essayList) {
        this.code = code;
        this.msg = msg;
        this.essayList = essayList;
    }

    public EssayJson(int code, String msg, Essay essay) {
        this.code = code;
        this.msg = msg;
        this.essay = essay;
    }

    public EssayJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public List<Essay> getEssayList() {
        return essayList;
    }

    public void setEssayList(List<Essay> essayList) {
        this.essayList = essayList;
    }

    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
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

}
