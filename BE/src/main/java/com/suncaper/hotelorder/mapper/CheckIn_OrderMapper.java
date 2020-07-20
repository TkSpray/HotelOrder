package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.CheckIn_Order;
import com.suncaper.hotelorder.domain.CheckIn_OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckIn_OrderMapper {
    long countByExample(CheckIn_OrderExample example);

    int deleteByExample(CheckIn_OrderExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(CheckIn_Order record);

    int insertSelective(CheckIn_Order record);

    List<CheckIn_Order> selectByExampleWithBLOBs(CheckIn_OrderExample example);

    List<CheckIn_Order> selectByExample(CheckIn_OrderExample example);

    CheckIn_Order selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") CheckIn_Order record, @Param("example") CheckIn_OrderExample example);

    int updateByExampleWithBLOBs(@Param("record") CheckIn_Order record, @Param("example") CheckIn_OrderExample example);

    int updateByExample(@Param("record") CheckIn_Order record, @Param("example") CheckIn_OrderExample example);

    int updateByPrimaryKeySelective(CheckIn_Order record);

    int updateByPrimaryKeyWithBLOBs(CheckIn_Order record);

    int updateByPrimaryKey(CheckIn_Order record);
}