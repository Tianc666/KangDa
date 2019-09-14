package com.ssm.entity;

import java.util.Date;

public class Excel {
    public int id;
    public String salmedicinename;
    public String salamount;
    public String salprice;
    public Date saldate;
    public String salname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalmedicinename() {
        return salmedicinename;
    }

    public void setSalmedicinename(String salmedicinename) {
        this.salmedicinename = salmedicinename;
    }

    public String getSalamount() {
        return salamount;
    }

    public void setSalamount(String salamount) {
        this.salamount = salamount;
    }

    public String getSalprice() {
        return salprice;
    }

    public void setSalprice(String salprice) {
        this.salprice = salprice;
    }

    public Date getSaldate() {
        return saldate;
    }

    public void setSaldate(Date saldate) {
        this.saldate = saldate;
    }

    public String getSalname() {
        return salname;
    }

    public void setSalname(String salname) {
        this.salname = salname;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "id=" + id +
                ", salmedicinename='" + salmedicinename + '\'' +
                ", salamount='" + salamount + '\'' +
                ", salprice='" + salprice + '\'' +
                ", saldate=" + saldate +
                ", salname='" + salname + '\'' +
                '}';
    }
}
