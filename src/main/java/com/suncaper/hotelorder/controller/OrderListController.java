package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderListController {

    @Autowired
    OrderListService orderListService;

    @RequestMapping("/page/order_list")
    @ResponseBody
    public  Object orderList(){
        System.out.println(orderListService.findOrderList());
        return Result.success(orderListService.findOrderList());
    }



}
