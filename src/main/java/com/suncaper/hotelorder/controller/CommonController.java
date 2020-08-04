package com.suncaper.hotelorder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommonController {
    //通配符
    //  @RequestMapping(value = "/page/{path}",method = RequestMethod.GET)
    @GetMapping("/page/{path}")
    public String gotoPage(@PathVariable("path") String p){
        return p;
    }
}

