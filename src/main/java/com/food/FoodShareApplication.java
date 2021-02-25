package com.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.food.dao"})
public class FoodShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodShareApplication.class, args);
    }

}
