package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.Staff;
import com.suncaper.hotelorder.domain.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {
    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(String sId);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExampleWithBLOBs(StaffExample example);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExampleWithBLOBs(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}