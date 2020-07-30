package com.suncaper.hotelorder.controller;


import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.mapper.RoomMapper;
import com.suncaper.hotelorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Date;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    RoomMapper roomMapper;

    @GetMapping("/book")
    @ResponseBody
    public Object book(Orders orders){
        if(orders.getGuestid() == null || orders.getGuestid()==""
            || orders.getName()== null || orders.getName() ==""
            || orders.getPhone()==null || orders.getPhone() =="")
            return Result.myJSONResult(-1,"请确认客人信息填写正确");
        else if(orders.getRoomid() == null || orders.getRoomid() =="")
            return Result.myJSONResult(-1,"选择房间");
        if(roomMapper.selectByPrimaryKey(orders.getRoomid())== null)
            return Result.myJSONResult(-1,"房间不存在");

        Boolean isSuccess = bookService.book(orders);
        if(isSuccess)
            return Result.myJSONResult(0,"预订成功");
        return Result.myJSONResult(-1,"预订失败,房间已经被预订或出租");
    }

    /**
     * 订单由预订转变为入住
     *      1、修改订单状态、加入入住时间、金额
     *      2、修改房间状态
     *
     * @param orders
     * @return
     */
    @RequestMapping("/book_to_order")
    @ResponseBody
    public Object bookToorder(Orders orders){
        Boolean isSuccess = bookService.bookToorder(orders);
        if(isSuccess)
            return Result.myJSONResult(0, "入住成功");
        return Result.myJSONResult(-1, "入住失败");
    }

    /**
     * 预定订单取消
     *      1、修改订单状态
     *      2、修改房间状态
     *
     * @param orderid
     * @return
     */
    @RequestMapping("/cancelbook")
    @ResponseBody
    public Object canclebook(int orderid){
//        if(orderid == null || orderid == "")
//            return Result.myJSONResult(-1, "请选择订单");
        Boolean isSuccess = bookService.canclebook(orderid);
        if(isSuccess)
            return Result.myJSONResult(0,"取消预订成功");
        return Result.myJSONResult(-1,"取消预订失败");
    }

    @RequestMapping("/checkout")
    @ResponseBody
    public Object checkout(@RequestParam("orderid") int orderid, @RequestParam("outtime")Date outtime, @RequestParam("overtime") boolean overtime){
        Boolean isSuccess = bookService.checkout(orderid, outtime, overtime);
        if(isSuccess)
            return Result.myJSONResult(0,"退房成功");
        return Result.myJSONResult(-1,"退房失败");
    }
}
