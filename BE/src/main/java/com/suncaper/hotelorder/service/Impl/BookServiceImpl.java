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

        //2、修改房间状态
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRIdEqualTo(room_order.getrId());
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        Room room = rooms.get(0);
        room.setState("已出租");
        roomMapper.updateByExampleSelective(room, roomExample);

        //3、该房间类型数量-1
        Room_typeExample room_typeExample = new Room_typeExample();
        room_typeExample.createCriteria().andTIdEqualTo(room.gettId());
        List<Room_type> room_types = room_typeMapper.selectByExample(room_typeExample);
        //从数据库找到相应的数据信息
        Room_type room_type = room_types.get(0);
        int x= room_type.getSurplus() - 1 ;
        room_type.setSurplus(x);
        //修改
        room_typeMapper.updateByExampleSelective(room_type, room_typeExample);

    }
}
