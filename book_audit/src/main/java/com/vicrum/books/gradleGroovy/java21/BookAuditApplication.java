package com.vicrum.books.gradleGroovy.java21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableMongoRepositories(basePackages = "com.vicrum.books.gradleGroovy.java21.repository")
public class BookAuditApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookAuditApplication.class,args);
    }
}
