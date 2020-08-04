package com.suncaper.hotelorder;

import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.domain.OrdersExample;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * 测试
 */
//@SpringBootTest
class HotelorderApplicationTests {
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    RoomMapper roomMapper;
    /**
     * test1:
     * 插入9个房间信息
     * 插入9个模拟订单列表
     * 作为订单列表导出到前端的功能测试的备用数据
     * 只在test2前运行一次
     * 请保证数据库中已导入hotelOrder.sql文件
     * 且Room表和Orders表为空
     */
    @Test
    void test1() {
        for (int i = 0;i<9;i++){
            Room room = new Room();
            room.setRoomid("10"+i);
            room.setFloor(1);
            room.setArea("100");
            room.setRoomtype(1);
            room.setPrice(100);
            room.setIncludebrk(true);
            room.setNumberofpeople(1);
            room.setStatus(1);
            roomMapper.insert(room);
        }
        for (int i = 0;i<9;i++){
            Orders orders = new Orders();
          //  orders.setOrderid(i);
            orders.setGuestid("aaa"+i);
            orders.setOrderstate(1);
            orders.setRoomid("10"+i);
            orders.setRoomtype(0);
            ordersMapper.insert(orders);
        }
    }
    @Test
    void test2(){
        OrdersExample ordersExample= new OrdersExample();
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        System.out.println(orders.size());
    }
}
