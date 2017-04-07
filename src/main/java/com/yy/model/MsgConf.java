package com.yy.model;

import java.io.Serializable;

/**
 * Created by skyler on 2017/4/7.
 */
public class MsgConf implements Serializable {

    private int newMsgRemind;// #新消息提醒; 0:提醒 1:不提醒
    private int receiveCommonMsg;// #接收普通消息; 0:接收 1:不接收

    public int getNewMsgRemind() {
        return newMsgRemind;
    }

    public void setNewMsgRemind(int newMsgRemind) {
        this.newMsgRemind = newMsgRemind;
    }

    public int getReceiveCommonMsg() {
        return receiveCommonMsg;
    }

    public void setReceiveCommonMsg(int receiveCommonMsg) {
        this.receiveCommonMsg = receiveCommonMsg;
    }
}
