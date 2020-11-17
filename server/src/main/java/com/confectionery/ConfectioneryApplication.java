package com.confectionery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;


@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
public class ConfectioneryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfectioneryApplication.class, args);
    }

}
