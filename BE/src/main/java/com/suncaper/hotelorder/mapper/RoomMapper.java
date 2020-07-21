package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.domain.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(String rId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExampleWithBLOBs(RoomExample example);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExampleWithBLOBs(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKeyWithBLOBs(Room record);

    int updateByPrimaryKey(Room record);
}