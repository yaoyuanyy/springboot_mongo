package com.yy.model;

import java.io.Serializable;

/**
 * Created by skyler on 2017/4/7.
 */
public class Channel implements Serializable{

    private String id;
    private String name; //名称
    private String desc; //描述
    private long adminId; //管理员id（staffId）
    private long creatorId; //频道创建者id（staffId）
    private long companyId; //频道创建者id（staffId）公司id
    private String notice=""; //公告
    private Attribute attribute; //频道属性
    private FilterCond filterCond; //频道筛选条件
    private long deptId;
    private MsgConf msgConf; //频道消息配置
    private int status; //0:正常 目前物理删
    private long ctime; //创建时间
    private long utime; //更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public FilterCond getFilterCond() {
        return filterCond;
    }

    public void setFilterCond(FilterCond filterCond) {
        this.filterCond = filterCond;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public MsgConf getMsgConf() {
        return msgConf;
    }

    public void setMsgConf(MsgConf msgConf) {
        this.msgConf = msgConf;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public long getUtime() {
        return utime;
    }

    public void setUtime(long utime) {
        this.utime = utime;
    }
}
