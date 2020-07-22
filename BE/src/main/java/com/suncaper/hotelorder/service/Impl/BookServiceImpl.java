package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.*;
import com.suncaper.hotelorder.mapper.GuestMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.mapper.Room_OrderMapper;
import com.suncaper.hotelorder.mapper.Room_typeMapper;
import com.suncaper.hotelorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    GuestMapper guestMapper;

    @Autowired
    Room_typeMapper room_typeMapper;

    @Autowired
    Room_OrderMapper room_orderMapper;

    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<Room_type> selectAllRoom(String typeId) {

        List<Room_type> rooms = room_typeMapper.selectAllByType(typeId);
        return rooms;
    }

    @Override
    public void addGuest(Guest guest) {
        GuestExample guestExample = new GuestExample();
        guestExample.createCriteria().andGIdEqualTo(guest.getgId());
        List<Guest> guests = guestMapper.selectByExample(guestExample);
        if(guests.size()>0){
            System.out.println("客户信息已经登录");
        }else{
        guestMapper.insert(guest);
        }
    }

    /**预定操作过后，需修改的表：
     *          房间表：对应房间状态写为出租
     *          房间类型表：房间的剩余量减一
     *          订单表信息写入
     * @return
     */
    @Override
    public void book(Room_Order room_order) {
        //1.订单表写入数据库
        room_orderMapper.insert(room_order);
        String r_id = room_order.getrId();

        //改变房间记录状态
        changeRoomState(room_order, 0);

    }

    /**
     * 查询所有的预定订单
     * @return
     */
    @Override
    public List<Room_Order> listAllBook() {
        Room_OrderExample room_orderExample = new Room_OrderExample();
        room_orderExample.createCriteria().andOStateEqualTo("已预定");
        List<Room_Order> room_orders = room_orderMapper.selectByExample(room_orderExample);
        return room_orders;
    }

    /**
     * 取消预定订单
     * 取消预定操作有：
     *      预定单从数据库清除；
     *      若对应客人没有订单了，则清除客人信息
     *      房间状况修改
     *      房间剩余量+1
     *
     * @return
     */
    @Override
    public boolean cancel_book(int o_id) {
        String guest_id;
        String room_id;

        //1、找到订单
        Room_OrderExample room_orderExample = new Room_OrderExample();
        room_orderExample.createCriteria().andOIdEqualTo(o_id);
        List<Room_Order> room_orders = room_orderMapper.selectByExample(room_orderExample);
        Room_Order room_order = room_orders.get(0);

        guest_id = room_order.getgId();
        room_id = room_order.getrId();

        //2、订单清除
        room_orderMapper.deleteByPrimaryKey(o_id);

        //3、修改房间状态
        changeRoomState(room_order, 1);

        //4、若客人不再有订单，则清除客人信息
        Room_OrderExample room_orderExample1 = new Room_OrderExample();
        room_orderExample1.createCriteria().andGIdEqualTo(guest_id);
        List<Room_Order> room_orders1 = room_orderMapper.selectByExample(room_orderExample1);
        if(room_orders1.size()>0)           //说明含有该客人身份ID的订单
            return true;
        guestMapper.deleteByPrimaryKey(guest_id);
        return true;
    }

    /**
     * 将预定订单表转换为入住表，只需修改订单状态，和房间状态
     *
     * @param o_id
     * @return
     */
    @Override
    public boolean bookToorder(int o_id) {
        //1、找到订单
        Room_OrderExample room_orderExample = new Room_OrderExample();
        room_orderExample.createCriteria().andOIdEqualTo(o_id);
        List<Room_Order> room_orders = room_orderMapper.selectByExample(room_orderExample);
        Room_Order room_order = room_orders.get(0);
        //2、修改状态
        room_order.setoState("已入住");
        room_orderMapper.updateByExample(room_order,room_orderExample);

        //3、修改房间状态
        changeRoomState(room_order, 2);

        return true;
    }

    /**
     * 根据选择choice改变订单和房间状态
     *      0：预定
     *      1：取消预定
     *      2：预定变为入住
     *
     * @param room_order
     * @param choice
     */
    public void changeRoomState(Room_Order room_order, int choice) {
        //1、修改房间状态
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRIdEqualTo(room_order.getrId());
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        Room room = rooms.get(0);
        if (choice == 0) {
            room.setState("已预定");
        } else if (choice == 1) {
            room.setState("空闲");
        } else {
            room.setState("已入住");
        }
        roomMapper.updateByExampleSelective(room, roomExample);

        //2、修改房间类型数量
        Room_typeExample room_typeExample = new Room_typeExample();
        room_typeExample.createCriteria().andTIdEqualTo(room.gettId());
        List<Room_type> room_types = room_typeMapper.selectByExample(room_typeExample);
        Room_type room_type = room_types.get(0);
        if(choice == 0) {
            int x= room_type.getSurplus() - 1 ;
            room_type.setSurplus(x);
        }
        else if(choice == 1){
            int x= room_type.getSurplus() + 1 ;
            room_type.setSurplus(x);
        }
        //修改
        room_typeMapper.updateByExampleSelective(room_type, room_typeExample);
    }
}
