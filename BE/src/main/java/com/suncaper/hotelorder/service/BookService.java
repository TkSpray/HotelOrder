package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Orders;

import java.util.Date;

public interface BookService {

    boolean book(Orders orders);

    boolean bookToorder(Orders orders);

    boolean canclebook(int orderid);

    boolean checkout(int orderid, Date outtime);
}
