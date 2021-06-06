package com.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TradingEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradingEurekaApplication.class, args);
    }

}
