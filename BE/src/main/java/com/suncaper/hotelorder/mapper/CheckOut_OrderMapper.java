package com.suncaper.hotelorder.mapper;

import com.suncaper.hotelorder.domain.CheckOut_Order;
import com.suncaper.hotelorder.domain.CheckOut_OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckOut_OrderMapper {
    long countByExample(CheckOut_OrderExample example);

    int deleteByExample(CheckOut_OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckOut_Order record);

    int insertSelective(CheckOut_Order record);

    List<CheckOut_Order> selectByExampleWithBLOBs(CheckOut_OrderExample example);

    List<CheckOut_Order> selectByExample(CheckOut_OrderExample example);

    CheckOut_Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckOut_Order record, @Param("example") CheckOut_OrderExample example);

    int updateByExampleWithBLOBs(@Param("record") CheckOut_Order record, @Param("example") CheckOut_OrderExample example);

    int updateByExample(@Param("record") CheckOut_Order record, @Param("example") CheckOut_OrderExample example);

    int updateByPrimaryKeySelective(CheckOut_Order record);

    int updateByPrimaryKeyWithBLOBs(CheckOut_Order record);

    int updateByPrimaryKey(CheckOut_Order record);
}