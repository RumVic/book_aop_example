package com.vicrum.books.gradleGroovy.java21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookAuditApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookAuditApplication.class,args);
    }
}
