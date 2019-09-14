package com.ssm.entity;

import java.util.Date;

public class Stock {
    private Integer sId;

    private Integer sMedicineid;

    private int sCount;

    private Date sData;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsMedicineid() {
        return sMedicineid;
    }

    public void setsMedicineid(Integer sMedicineid) {
        this.sMedicineid = sMedicineid;
    }

    public int getsCount() {
        return sCount;
    }

    public void setsCount(int sCount) {
        this.sCount = sCount;
    }

    public Date getsData() {
        return sData;
    }

    public void setsData(Date sData) {
        this.sData = sData;
    }
}