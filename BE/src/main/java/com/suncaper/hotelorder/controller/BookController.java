package com.suncaper.hotelorder.controller;

import com.suncaper.hotelorder.domain.Guest;
import com.suncaper.hotelorder.domain.Room;
import com.suncaper.hotelorder.domain.Room_Order;
import com.suncaper.hotelorder.domain.Room_type;
import com.suncaper.hotelorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 酒店预定持久层
 *      预实现功能：
 *          1、能够写入来客信息
 *          2、选择房型，展示出可选择房间
 *          3、根据“客人信息、房间信息、预计入住、退房时间”生成预定订单
 *          4、选择展示所有预定订单
 *          5、操作预定订单，来入住（修改state变成订单），退订
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    Guest guest;

    /**
     * 第一步：当客人预定时，需要填写客人信息。
     * 前端传来一个Guest的对象，通过对象变量存储
     * 当实现了预定后，才客人信息存入数据库
     *
     * @param guest
     * @return
     */
    @RequestMapping("/guessInformation/commit")
    public String guess_information(Guest guest){
        this.guest = guest;
//        bookService.addGuest(guest);
        System.out.println("客人信息登录成功！");
        //进入客房选择界面
        return "/selectRoom";
    }

    /**
     * 选择房间类型
     * 传来房间类型编号
     * 查询数据库：
     *      需要多表查询，并返回数据JSON类型
     * @param typeId
     */
    @RequestMapping("/selectRoom/select")
    @ResponseBody
    public List<Room_type> selectRoom(String typeId){
        return  bookService.selectAllRoom(typeId);
    }

    /**
     * 预定时，前端传来参数有
     *          1、房间编号
     *          2、预计入住时间
     *          3、预计退房时间
     *
     *预定操作过后，需修改的表
     *          客人表：登录客人信息
     *          房间表：对应房间状态写为出租
     *          房间类型表：房间的剩余量减一
     *          订单表信息写入
     * @return
     */
    @RequestMapping("/book")
    public String book(String r_id, Date pintime, Date pouttime){
        //1、客人表：登录客人信息
        bookService.addGuest(guest);
        Room_Order room_order = new Room_Order();
        room_order.setpIntime(pintime);
        room_order.setpOuttime(pouttime);
        room_order.setrId(r_id);
        room_order.setgId(guest.getgId());
        //指定订单为预定单
        room_order.setoState("已预定");
        bookService.book(room_order);
        //确定一个返回标准
        return "";
    }



}
