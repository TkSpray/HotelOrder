package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.domain.RoomExample;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    RoomMapper roomMapper;

    /**
     * 订单
     * 0 预订中
     * 1  已入住
     * 2 已完成（这个就是走完正常流程退房之后的）
     * 3 已关闭（预订后取消预订的）
     *
     * 房间
     * 0 空闲
     * 1 预订中
     * 2 已入住
     */

    /**
     * 1、设置预订单的status = 0
     *
     * 2、预订表信息加入数据库
     * 3、修改房间状态
     *
     * @param orders
     */
    @Override
    public boolean book(Orders orders) {
        //设置订单状态并插入
        orders.setOrderstate(0);
        ordersMapper.insertSelective(orders);
        //找到房间信息
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRoomidEqualTo(orders.getRoomid());
        Room room = roomMapper.selectByPrimaryKey(orders.getRoomid());
        //修改房间状态，并插入
        room.setStatus(1);
        roomMapper.updateByExampleSelective(room,roomExample);
        return true;
    }

    /**
     * 订单由预订转变为入住
     *      1、修改订单状态
     *      2、修改房间状态
     *
     * @param orders
     * @return
     */

    @Override
    public boolean bookToorder(Orders orders) {
        //1、由房间号找到订单并修改状态
        //因为ordrs对象里面已经设置了入住、金额信息
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andRoomidEqualTo(orders.getRoomid());
        orders.setOrderstate(1);
        ordersMapper.updateByExampleSelective(orders, ordersExample);

        //2、修改房间状态
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRoomidEqualTo(orders.getRoomid());
        Room room = new Room();
        room.setStatus(2);

        roomMapper.updateByExampleSelective(room,roomExample);

        return true;
    }

    /**
     * 预定订单取消
     *      1、修改订单状态
     *      2、修改房间状态
     *
     * @param orderid
     * @return
     */

    @Override
    public boolean canclebook(int orderid) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderidEqualTo(orderid);

        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        orders.setOrderstate(3);
        //更新订单
        ordersMapper.updateByExampleSelective(orders,ordersExample);
        //更新房间
        Room room = new Room();
        room.setRoomid(orders.getRoomid());
        room.setStatus(0);
        roomMapper.updateByPrimaryKeySelective(room);

        return true;
    }

    /**
     * 退房操作：
     *      1、修改订单状态
     *      2、修改房间状态
     *
     * @param orderid
     * @param outtime
     */
    @Override
    public boolean checkout(int orderid, Date outtime, boolean overtime) {
        //1、修改订单表
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        orders.setOuttime(outtime);
        orders.setOvertime(overtime);
        orders.setOrderstate(2);
        ordersMapper.updateByPrimaryKeySelective(orders);

        //2、修改房间表
        Room room = roomMapper.selectByPrimaryKey(orders.getRoomid());
        room.setStatus(0);
        roomMapper.updateByPrimaryKeySelective(room);
        return true;
    }

}
