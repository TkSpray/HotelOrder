package com.suncaper.hotelorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HotelorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelorderApplication.class, args);
    }

}
