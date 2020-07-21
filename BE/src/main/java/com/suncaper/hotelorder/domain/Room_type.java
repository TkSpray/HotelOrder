package com.suncaper.hotelorder.domain;

import com.suncaper.hotelorder.domain.extend.Room_typeExtend;

public class Room_type extends Room_typeExtend {
    private String tId;

    private String type;

    private Integer price;

    private Integer total;

    private Integer surplus;

    private String breakfast;

    private Integer cPeople;

    private String area;

    private String remarks;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast == null ? null : breakfast.trim();
    }

    public Integer getcPeople() {
        return cPeople;
    }

    public void setcPeople(Integer cPeople) {
        this.cPeople = cPeople;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}