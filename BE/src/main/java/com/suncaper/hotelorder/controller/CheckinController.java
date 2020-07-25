package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class CheckinController {
    @Autowired
    CheckinService checkService;


    @RequestMapping("/check_in")
    @ResponseBody
    public Object Checkin(Orders order){
        if(checkService.CheckIn(order) == true){
            return Result.myJSONResult(0,"入住成功");
        }else {
            return Result.myJSONResult(1,"入住成功");
        }
    }
}
