package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.Guest;
import com.suncaper.hotelorder.domain.GuestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestMapper {
    long countByExample(GuestExample example);

    int deleteByExample(GuestExample example);

    int deleteByPrimaryKey(String gId);

    int insert(Guest record);

    int insertSelective(Guest record);

    List<Guest> selectByExampleWithBLOBs(GuestExample example);

    List<Guest> selectByExample(GuestExample example);

    Guest selectByPrimaryKey(String gId);

    int updateByExampleSelective(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByExampleWithBLOBs(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByExample(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByPrimaryKeySelective(Guest record);

    int updateByPrimaryKeyWithBLOBs(Guest record);

    int updateByPrimaryKey(Guest record);
}