package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Orders;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderListService {
    List<Orders> findOrderList();
}
