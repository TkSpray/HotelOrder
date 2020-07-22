package com.suncaper.hotelorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.suncaper.hotelorder.mapper")
public class HotelorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelorderApplication.class, args);
    }

}
