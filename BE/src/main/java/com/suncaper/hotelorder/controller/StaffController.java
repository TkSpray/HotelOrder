package com.suncaper.hotelorder.controller;


import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Staff;
import com.suncaper.hotelorder.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 员工操作持久层功能：
 *      1、能够输入员工号和密码进行登录
 *      2、进入注册界面，进行员工信息登录和密码注册
 */

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;

    /**
     * 前端页面传来数据：员工账号和密码，
     *      通过账号密码在数据库查找匹配，
     *      若找到，则进入操作大厅
     *      没找到或密码错误，则提示错误
     *      code：0-登录成功
     *            -1-账号名错误
     *            1-密码错误
     *
     * @param staff   该实例中含有账号和密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(Staff staff) {
        if(staff.getStaffid() == null || staff.getStaffid() == "")
            return Result.myJSONResult(-1, "请输入账户ID");

        else if (staff.getPassword() == null || staff.getPassword() == "")
            return Result.myJSONResult(-1, "请输入密码");


        Staff staffInDB = staffService.login(staff);
        if (staffInDB == null) {
            return Result.myJSONResult(-1,"账号错误");
        } else {
            if (staffInDB.getPassword().equals(staff.getPassword())) {
                return Result.myJSONResult(0,"登录成功",staffInDB.getName());
            } else {
                return Result.myJSONResult(1,"密码错误");
            }
        }
    }


    /**
     * 前端界面传来用户注册信息封装的Staff对象。
     * 根据该对象，插入到数据库员工信息表
     * 注册成功：
     *   直接前往操作界面，或者登录界面
     * 注册失败
     *   返回到登录界面或者注册界面
     *
     * @param staff
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Object register(Staff staff){
        if(staff.getStaffid() == null || staff.getStaffid() == "")
            return Result.myJSONResult(-1,"账号为空");
        if(staff.getPassword() == null || staff.getPassword() == "" )
            return Result.myJSONResult(-1,"密码为空");
        else if (staff.getPhone() == null || staff.getPhone() == "")
            return Result.myJSONResult(-1, "手机号为空");

        boolean isSucceess = staffService.register(staff);
        if(isSucceess == true ){
            return Result.myJSONResult(0,"注册成功");
        }else{
            return Result.myJSONResult(-1,"注册失败，账号ID已经存在");
        }
    }
}
