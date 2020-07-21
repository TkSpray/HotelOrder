package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.Room_Order;
import com.suncaper.hotelorder.domain.Room_OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Room_OrderMapper {
    long countByExample(Room_OrderExample example);

    int deleteByExample(Room_OrderExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(Room_Order record);

    int insertSelective(Room_Order record);

    List<Room_Order> selectByExampleWithBLOBs(Room_OrderExample example);

    List<Room_Order> selectByExample(Room_OrderExample example);

    Room_Order selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") Room_Order record, @Param("example") Room_OrderExample example);

    int updateByExampleWithBLOBs(@Param("record") Room_Order record, @Param("example") Room_OrderExample example);

    int updateByExample(@Param("record") Room_Order record, @Param("example") Room_OrderExample example);

    int updateByPrimaryKeySelective(Room_Order record);

    int updateByPrimaryKeyWithBLOBs(Room_Order record);

    int updateByPrimaryKey(Room_Order record);
}