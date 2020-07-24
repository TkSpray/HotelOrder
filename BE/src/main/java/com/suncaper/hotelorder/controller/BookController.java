package com.suncaper.hotelorder.controller;


import com.suncaper.hotelorder.common.utils.Result;
import com.suncaper.hotelorder.domain.Orders;
import com.suncaper.hotelorder.mapper.OrdersMapper;
import com.suncaper.hotelorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.Date;

public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    OrdersMapper ordersMapper;


    @RequestMapping("/book")
    @ResponseBody
    public Object book(@RequestBody Orders orders){
        Boolean isSuccess = bookService.book(orders);
        if(isSuccess)
            return Result.myJSONResult(0,"预定成功");
        return Result.myJSONResult(-1,"预定失败");
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
    public Object bookToorder(@RequestBody Orders orders){
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
    @RequestMapping("/canclebook")
    @ResponseBody
    public Object canclebook(int orderid){
        Boolean isSuccess = bookService.canclebook(orderid);
        if(isSuccess)
            return Result.myJSONResult(0,"取消预订成功");
        return Result.myJSONResult(-1,"取消预订失败");
    }

    @RequestMapping("checkout")
    @ResponseBody
    public Object checkout(@RequestParam("orderid") int orderid, @RequestParam("outtime")Date outtime){
        Boolean isSuccess = bookService.checkout(orderid, outtime);
        if(isSuccess)
            return Result.myJSONResult(0,"退房成功");
        return Result.myJSONResult(-1,"退房失败");
    }
}
