package com.vicrum.books.gradleGroovy.java21.service;

import com.vicrum.books.gradleGroovy.java21.entity.RecordAction;
import com.vicrum.books.gradleGroovy.java21.entity.RecordActionKafka;
import com.vicrum.books.gradleGroovy.java21.repository.MongoKafkaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaServiceConsumer {
    private final MongoKafkaRepo mongoKafkaRepo;

    @Autowired
    public KafkaServiceConsumer(MongoKafkaRepo mongoKafkaRepo) {
        this.mongoKafkaRepo = mongoKafkaRepo;
    }

    @KafkaListener(topics = "BookTopic", groupId = "my-group")
    public void listen(String message) {
        RecordActionKafka recordActionKafka = new RecordActionKafka(UUID.randomUUID(), RecordAction.valueOf(message));
        mongoKafkaRepo.save(recordActionKafka);
    }
}
