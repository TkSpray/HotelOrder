package com.suncaper.hotelorder.service.Impl;

import com.suncaper.hotelorder.domain.Staff;
import com.suncaper.hotelorder.domain.StaffExample;
import com.suncaper.hotelorder.mapper.StaffMapper;
import com.suncaper.hotelorder.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;


    @Override
    public Staff login(Staff staff) {

        StaffExample staffExample = new StaffExample();
        staffExample.createCriteria().andStaffidEqualTo(staff.getStaffid().trim());
        List<Staff> staff1 = staffMapper.selectByExample(staffExample);
        return(staff1.size()>0?staff1.get(0):null);

    }

    @Override
    public boolean register(Staff staff) {

        Staff staff1 = staffMapper.selectByPrimaryKey(staff.getStaffid());
        if(staff1 != null){
            System.out.println("用户ID已存在,注册失败！");
            return false;
        }else{
            staffMapper.insert(staff);
            return true;
        }
    }
}
