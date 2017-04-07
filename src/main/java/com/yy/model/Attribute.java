package com.yy.model;

import java.io.Serializable;

/**
 * Created by skyler on 2017/4/7.
 */
public class Attribute implements Serializable{

    private int privateOwn;// #私有,公有; 0:私有 1:公有
    private int offical;//  #官方,非官方; 0:官方 1:个人
    private int type;//  #全员,部门,常规; 0:全员 1:部门；2:常规
    private int open;//  #启用,停用; 0:启用 1:停用
    private int gag;//  #禁言,取消禁言; 0:取消禁言 1:禁言

    public int getPrivateOwn() {
        return privateOwn;
    }

    public void setPrivateOwn(int privateOwn) {
        this.privateOwn = privateOwn;
    }

    public int getOffical() {
        return offical;
    }

    public void setOffical(int offical) {
        this.offical = offical;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getGag() {
        return gag;
    }

    public void setGag(int gag) {
        this.gag = gag;
    }
}
