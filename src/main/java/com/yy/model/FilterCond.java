package com.yy.model;

import java.io.Serializable;

/**
 * Created by skyler on 2017/4/7.
 */
public class FilterCond implements Serializable {

    private long deptId;

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }
}
