package com.suncaper.hotelorder.domain;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private String guestid;

    private String name;

    private String phone;

    private String roomid;

    private Integer roomtype;

    private Date ordertime;

    private Date preintime;

    private Date intime;

    private Date preouttime;

    private Date outtime;

    private Integer total;

    private Integer price;

    private Boolean overtime;

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

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
}