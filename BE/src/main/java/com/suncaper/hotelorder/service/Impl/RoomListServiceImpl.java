package com.suncaper.hotelorder.service.Impl;


import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.domain.RoomExample;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.service.RoomListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 返回所有房间列表
 * 以供前端查询
 */
@Service
public class RoomListServiceImpl implements RoomListService {
    @Autowired
    private RoomMapper roomMapper;

    public List<Room> findRoomList()
    {
        RoomExample roomExample = new RoomExample();
        List<Room> room = roomMapper.selectByExample(roomExample);
        return room;
    }
}
