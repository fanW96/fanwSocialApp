package com.fanw.socialapp.model;

import java.util.List;

public class Callback {

    private int code;
    private String msg;
    private List<ImageModel> list;

    public Callback(int code, String msg, List<ImageModel> list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
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

    public List<ImageModel> getList() {
        return list;
    }

    public void setList(List<ImageModel> list) {
        this.list = list;
    }
}
