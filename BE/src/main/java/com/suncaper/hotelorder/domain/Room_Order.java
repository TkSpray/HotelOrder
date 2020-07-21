package com.suncaper.hotelorder.domain;

import java.util.Date;

public class Room_Order {
    private Integer oId;

    private String gId;

    private String rId;

    private Date pIntime;

    private Date inTime;

    private Date pOuttime;

    private Date outTime;

    private Integer money;

    private Integer deposit;

    private String oState;

    private String remarks;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId == null ? null : gId.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public Date getpIntime() {
        return pIntime;
    }

    public void setpIntime(Date pIntime) {
        this.pIntime = pIntime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getpOuttime() {
        return pOuttime;
    }

    public void setpOuttime(Date pOuttime) {
        this.pOuttime = pOuttime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState == null ? null : oState.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}