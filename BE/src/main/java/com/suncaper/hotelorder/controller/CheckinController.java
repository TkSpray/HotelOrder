package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class CheckinController {
    @Autowired
    CheckinService checkService;


    @RequestMapping("/check_in")
    public void Checkin(Orders order){
        if(checkService.CheckIn(order) == true){
            System.out.println("入住成功");
        }else {
            System.out.println("入住失败！");
        }
    }
}