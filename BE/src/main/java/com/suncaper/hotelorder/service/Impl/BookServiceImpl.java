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

import java.text.SimpleDateFormat;
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

        //找到房间信息
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRoomidEqualTo(orders.getRoomid());
        Room room = roomMapper.selectByPrimaryKey(orders.getRoomid());
        //房间空闲时才能执行
        if(room.getStatus() == 0){
            orders.setRoomtype(room.getRoomtype());
            ordersMapper.insertSelective(orders);
            //修改房间状态，并插入
            room.setStatus(1);
            roomMapper.updateByExampleSelective(room,roomExample);
            return true;
        }

        return false;
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

        if(orders.getRoomid() != null && orders.getRoomid() != "")
        {
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

        else if(orders.getOrderid() != null)
        {
            orders.setOrderstate(1);
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andOrderidEqualTo(orders.getOrderid());


            Orders orders1 = ordersMapper.selectByPrimaryKey(orders.getOrderid());
            Room room = roomMapper.selectByPrimaryKey(orders1.getRoomid());
            room.setStatus(2);
            orders.setRoomid(room.getRoomid());
            ordersMapper.updateByExampleSelective(orders,ordersExample);
            roomMapper.updateByPrimaryKeySelective(room);
            return true;
        }

        return false;
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
        if(orders == null)
            return false;

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
    public boolean checkout(int orderid, Date outtime) {
        //1、修改订单表
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        orders.setOuttime(outtime);

        Date nowtime = new Date();

        if(nowtime.compareTo(orders.getPreouttime()) > 0){          //超时
            orders.setOvertime(true);
        }else{                                                      //未超时
            orders.setOvertime(false);
        }

        orders.setOrderstate(2);
        ordersMapper.updateByPrimaryKeySelective(orders);

        //2、修改房间表
        Room room = roomMapper.selectByPrimaryKey(orders.getRoomid());
        room.setStatus(0);
        roomMapper.updateByPrimaryKeySelective(room);
        return true;
    }

}
