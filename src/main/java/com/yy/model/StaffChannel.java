package com.yy.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by skyler on 2017/4/7.
 */
public class StaffChannel implements Serializable {

    private String id;
    private long staffId;
    List<StaffChannelConf> staffChannelConfs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public List<StaffChannelConf> getStaffChannelConfs() {
        return staffChannelConfs;
    }

    public void setStaffChannelConfs(List<StaffChannelConf> staffChannelConfs) {
        this.staffChannelConfs = staffChannelConfs;
    }
}
