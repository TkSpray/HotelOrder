package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.Room_type;
import com.suncaper.hotelorder.domain.Room_typeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Room_typeMapper {
    long countByExample(Room_typeExample example);

    int deleteByExample(Room_typeExample example);

    int deleteByPrimaryKey(String tId);

    int insert(Room_type record);

    int insertSelective(Room_type record);

    List<Room_type> selectByExampleWithBLOBs(Room_typeExample example);

    List<Room_type> selectByExample(Room_typeExample example);

    Room_type selectByPrimaryKey(String tId);

    int updateByExampleSelective(@Param("record") Room_type record, @Param("example") Room_typeExample example);

    int updateByExampleWithBLOBs(@Param("record") Room_type record, @Param("example") Room_typeExample example);

    int updateByExample(@Param("record") Room_type record, @Param("example") Room_typeExample example);

    int updateByPrimaryKeySelective(Room_type record);

    int updateByPrimaryKeyWithBLOBs(Room_type record);

    int updateByPrimaryKey(Room_type record);
}