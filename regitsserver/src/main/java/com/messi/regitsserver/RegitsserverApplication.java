package com.messi.regitsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.messi.controller")
/**
 * 服务注册
 */
@EnableDiscoveryClient
public class RegitsserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegitsserverApplication.class, args);
    }

}
