package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * room类中状态：
 * 房间
 * 0 空闲
 * 1 预订中
 * 2 已入住
 */

public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public boolean CheckIn(Orders order){
        Orders orders = ordersMapper.selectByPrimaryKey(order.getOrderid());
        if(orders != null){
            System.out.println("订单号错误!");
            return false;
        }else {
            Room room = roomMapper.selectByPrimaryKey(order.getRoomid());
            if(room == null){
                System.out.println("房间不存在！");
                return false;
            }else{
                if (room.getStatus()== 1){
                    System.out.println("房间已被预订！");
                    return false;
                }else if (room.getStatus()== 1){
                    System.out.println("房间已入住！");
                    return false;
                }else{
                    return true;
                }
            }
        }
    }


}
