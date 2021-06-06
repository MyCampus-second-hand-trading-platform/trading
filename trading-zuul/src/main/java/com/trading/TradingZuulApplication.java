package com.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TradingZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradingZuulApplication.class, args);
    }

}
