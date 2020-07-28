package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * room类状态：
 * 房间
 * 0 空闲
 * 1 预订中
 * 2 已入住
 */

/**
 * 返回状态：
 * 0 成功
 * 1 失败
 */

@Controller
public class CheckinController {
    @Autowired
    CheckinService checkService;


    @RequestMapping("/check_in")
    @ResponseBody
    public Object Checkin(Orders order){
        if(checkService.orderID_error(order) == true){
            return Result.myJSONResult(1,"订单号错误!");
        }
        if(checkService.roomID_error(order) == true){
            return Result.myJSONResult(1,"房间号不存在！");
        }
        if(checkService.room_available(order) == 0){
            checkService.checkin(order);
            return Result.myJSONResult(0,"入住成功");
        }else if (checkService.room_available(order) == 1){
            return Result.myJSONResult(1,"房间已被预订！");
        }else{
            return Result.myJSONResult(1,"房间有人入住！");
        }
    }
}
