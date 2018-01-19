package com.fanw.socialapp.model;

public class Relation {
    private int relation_id;
    private User up;
    private User fan;

    @Override
    public String toString() {
        return "Relation{" +
                "relation_id=" + relation_id +
                ", fan=" + fan.toString() +
                '}';
    }

    public int getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }

    public User getUp() {
        return up;
    }

    public void setUp(User up) {
        this.up = up;
    }

    public User getFan() {
        return fan;
    }

    public void setFan(User fan) {
        this.fan = fan;
    }
}
