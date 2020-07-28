package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Orders;

import java.text.ParseException;

public interface CheckinService {
    int room_available(Orders order);

    public boolean orderID_error (Orders order);

    public boolean roomID_error(Orders orders);

    public void checkin(Orders order) throws ParseException;
}
