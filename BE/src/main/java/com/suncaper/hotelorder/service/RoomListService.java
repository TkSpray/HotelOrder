package com.suncaper.hotelorder.service;

import com.suncaper.hotelorder.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomListService {
    List<Room> findRoomList();
}
