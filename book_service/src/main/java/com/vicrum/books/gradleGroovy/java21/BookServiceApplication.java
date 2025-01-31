package com.vicrum.books.gradleGroovy.java21;

import com.vicrum.books.gradleGroovy.java21.kstream.KafkaStream;
import com.vicrum.books.gradleGroovy.java21.service.KafkaServiceProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
@EnableJpaRepositories(basePackages = "com.vicrum.books.gradleGroovy.java21.repository.api.postgres")
@EnableMongoRepositories(basePackages = "com.vicrum.books.gradleGroovy.java21.repository.api.mongo")
public class BookServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);

		KafkaServiceProducer kafkaServiceProducer = new KafkaServiceProducer();
		KafkaStream kafkaStream = new KafkaStream(kafkaServiceProducer);
		new Thread(kafkaStream).start();

	}
}
