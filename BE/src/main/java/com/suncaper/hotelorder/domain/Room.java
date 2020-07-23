package com.suncaper.hotelorder.domain;

public class Room {
    private String roomid;

    private Integer roomtype;

    private Integer price;

    private Integer numberofpeople;

    private Integer floor;

    private String area;

    private String includebrk;

    private Integer status;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(Integer numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getIncludebrk() {
        return includebrk;
    }

    public void setIncludebrk(String includebrk) {
        this.includebrk = includebrk == null ? null : includebrk.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}