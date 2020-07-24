package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 返回所有订单列表
 * 以供前端查询
 */
@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> findOrderList()
    {
        OrdersExample ordersExample = new OrdersExample();
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        return orders;
    }
}
