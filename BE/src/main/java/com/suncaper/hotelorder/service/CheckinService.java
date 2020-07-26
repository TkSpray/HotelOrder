package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Orders;

public interface CheckinService {
    int room_available(Orders order);

    public boolean orderID_error (Orders order);

    public boolean roomID_error(Orders orders);
}
