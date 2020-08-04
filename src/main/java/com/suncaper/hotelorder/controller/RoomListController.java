package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.service.RoomListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoomListController {

    @Autowired
    RoomListService roomListService;

    @RequestMapping("/page/room_list")
    @ResponseBody
    public Object roomList(){
        System.out.println(roomListService.findRoomList());
        return Result.success(roomListService.findRoomList());
    }

}
