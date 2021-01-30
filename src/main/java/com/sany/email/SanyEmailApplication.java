package com.sany.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gali
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SanyEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanyEmailApplication.class, args);
    }

}
