package com.vicrum.books.gradleGroovy.java21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
@EnableJpaRepositories(basePackages = "com.vicrum.books.gradleGroovy.java21.repository.api.postgres")
@EnableMongoRepositories(basePackages = "com.vicrum.books.gradleGroovy.java21.repository.api.mongo")
public class BooksGradleKotlinJava21Application {
	public static void main(String[] args) {
		SpringApplication.run(BooksGradleKotlinJava21Application.class, args);
	}
}
