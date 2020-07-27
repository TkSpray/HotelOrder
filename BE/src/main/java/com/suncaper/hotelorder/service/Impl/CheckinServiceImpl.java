package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int room_available(Orders order){

        Room room = roomMapper.selectByPrimaryKey(order.getRoomid());

        if (room.getStatus()== 1){
            return 1;
        }else if (room.getStatus()== 2){
            return 2;
        }else{
            return 0;
        }

    }

    @Override
    public boolean orderID_error (Orders order){
        Orders orders = ordersMapper.selectByPrimaryKey(order.getOrderid());
        if(orders == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean roomID_error(Orders order){
        Room room = roomMapper.selectByPrimaryKey(order.getRoomid());
        if(room == null){
            return true;
        }
        return false;
    }


}
