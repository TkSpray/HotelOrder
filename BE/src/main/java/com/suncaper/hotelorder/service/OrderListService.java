package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListService {
    @Autowired
    private OrdersMapper ordersMapper;
    public List<Orders> findOrderList(){
        OrdersExample ordersExample = new OrdersExample();
        List<Orders>orders = ordersMapper.selectByExample(ordersExample);
        return orders;
    }
}
