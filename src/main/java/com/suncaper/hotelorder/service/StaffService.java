package com.suncaper.hotelorder.service;


import com.suncaper.hotelorder.domain.Staff;

/**
 * 业务层：员工操作
 */
public interface StaffService {
    Staff login(Staff staff);

    boolean register(Staff staff);
}
