package com.vicrum.books.gradleGroovy.java21.app.config;

import java.util.Properties;

public class KafkaConfig {

    public static Properties getStreamConfig(String applicationId, String bootstrapServers) {
        Properties props = new Properties();
        props.put("application.id", applicationId);
        props.put("bootstrap.servers", bootstrapServers);
        // Добавьте другие настройки Kafka Streams здесь по необходимости
        return props;
    }

    public static Properties getProducerConfig(String bootstrapServers) {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        // Добавьте другие настройки для Kafka Producer здесь по необходимости
        return props;
    }

    public static Properties getConsumerConfig(String groupId, String bootstrapServers) {
        Properties props = new Properties();
        props.put("group.id", groupId);
        props.put("bootstrap.servers", bootstrapServers);
        // Добавьте другие настройки для Kafka Consumer здесь по необходимости
        return props;
    }
}
