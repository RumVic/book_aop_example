package com.vicrum.books.gradleGroovy.java21.kstream;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.vicrum.books.gradleGroovy.java21.service.KafkaServiceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class KafkaStream implements Runnable{

    private KafkaServiceProducer kafkaServiceProducer;

    @Autowired
    public KafkaStream(KafkaServiceProducer kafkaServiceProducer) {
        this.kafkaServiceProducer = kafkaServiceProducer;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            writeToKafka();
        }

    }

    public void writeToKafka() {
        String id = String.valueOf(RandomUtil.getPositiveInt());
        String msg = String.valueOf(RandomUtil.getPositiveInt());
        kafkaServiceProducer.sendForStream(id,msg);
    }
}