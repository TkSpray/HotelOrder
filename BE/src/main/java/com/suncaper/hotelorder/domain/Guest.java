package com.suncaper.hotelorder.domain;

public class Guest {
    private String gId;

    private String gName;

    private String gGender;

    private String phone;

    private String remarks;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId == null ? null : gId.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgGender() {
        return gGender;
    }

    public void setgGender(String gGender) {
        this.gGender = gGender == null ? null : gGender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}