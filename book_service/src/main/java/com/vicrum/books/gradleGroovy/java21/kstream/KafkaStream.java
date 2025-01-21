package com.vicrum.books.gradleGroovy.java21.kstream;

import com.vicrum.books.gradleGroovy.java21.service.KafkaServiceProducer;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            writeToKafka();
        }

    }

    public void writeToKafka() {
        String id = RandomString.make(5);
        String msg = RandomString.make(5);
        kafkaServiceProducer.sendForStream(id,msg);
    }
}