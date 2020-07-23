package com.suncaper.hotelorder.domain;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private String guestid;

    private String name;

    private String phone;

    private String roomid;

    private String roomtype;

    private Date ordertime;

    private Date preintime;

    private Date intime;

    private Date preouttime;

    private Date outtime;

    private String total;

    private Integer price;

    private String overtime;

    private Integer orderstate;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getGuestid() {
        return guestid;
    }

    public void setGuestid(String guestid) {
        this.guestid = guestid == null ? null : guestid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getPreintime() {
        return preintime;
    }

    public void setPreintime(Date preintime) {
        this.preintime = preintime;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getPreouttime() {
        return preouttime;
    }

    public void setPreouttime(Date preouttime) {
        this.preouttime = preouttime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime == null ? null : overtime.trim();
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
}