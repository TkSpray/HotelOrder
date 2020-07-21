package com.suncaper.hotelorder.controller;


import com.suncaper.hotelorder.domain.Staff;
import com.suncaper.hotelorder.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 员工操作持久层功能：
 *      1、能够输入员工号和密码进行登录
 *      2、进入注册界面，进行员工信息登录和密码注册
 */

@Controller
@RequestMapping("/user")
public class StaffController {

    @Autowired
    StaffService staffService;

    /**
     * 前端页面传来数据：员工账号和密码，
     *      通过账号密码在数据库查找匹配，
     *      若找到，则进入操作大厅
     *      没找到或密码错误，则提示错误
     * @param staff   该实例中含有账号和密码
     * @return
     */
    @RequestMapping("/login")
    public String login(Staff staff) {
        Staff staffInDB = staffService.login(staff);
        if (staffInDB == null) {
            System.out.println("用户名不存在");
        } else {
            if (staffInDB.getPassword().equals(staff.getPassword())) {
                System.out.println("登录成功");
                //登录成功，进入操作选择界面
                return " ";
            } else {
                System.out.println("密码错误");
            }
        }
        //依然在该界面
        return "";
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
    public String register(Staff staff){
        boolean isSucceess = staffService.register(staff);
        if(isSucceess == true ){
            System.out.println("注册成功。");
            //直接前往操作界面，或者登录界面
            return"";
        }else{
            System.out.println("注册失败");
            //返回到登录界面或者注册界面
            return "";
        }
    }
}
