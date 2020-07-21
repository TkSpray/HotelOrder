package com.suncaper.hotelorder.mapper.extend;

import com.suncaper.hotelorder.domain.Room_type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Room_typeMapperExtend {

    List<Room_type> selectAllByType(@Param("typeId")String typeId);

}
