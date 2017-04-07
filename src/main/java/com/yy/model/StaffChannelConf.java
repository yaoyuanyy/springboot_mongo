package com.yy.model;

/**
 * Created by skyler on 2017/4/7.
 */
public class StaffChannelConf {

    private String channelId;//频道id
    private int top;//置顶;0:置顶 1:不置顶
    private int newMsgRemind;//#新消息提醒; 0:提醒 1:不提醒

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getNewMsgRemind() {
        return newMsgRemind;
    }

    public void setNewMsgRemind(int newMsgRemind) {
        this.newMsgRemind = newMsgRemind;
    }
}
