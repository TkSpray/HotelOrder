package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Guest;
import com.suncaper.hotelorder.domain.Room_Order;
import com.suncaper.hotelorder.domain.Room_type;

import java.util.List;

/**
 *预定操作业务层接口
 */

public interface BookService {

    List<Room_type> selectAllRoom(String typeId);

    void addGuest(Guest guest);

    void book(Room_Order room_order);
}
