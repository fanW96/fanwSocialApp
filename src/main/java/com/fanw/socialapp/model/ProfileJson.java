package com.fanw.socialapp.model;

public class ProfileJson {
    private int code;
    private String msg;
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ProfileJson(int code, String msg, Profile profile) {
        this.code = code;
        this.msg = msg;
        this.profile = profile;
    }

    public ProfileJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
