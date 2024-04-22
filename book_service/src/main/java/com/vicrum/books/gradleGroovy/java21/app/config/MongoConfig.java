package com.vicrum.books.gradleGroovy.java21.app.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.net.URI;
import java.util.List;

@Configuration
public class MongoConfig {


    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Bean
    public MongoClient mongoClient() {
        URI uri = URI.create(mongoUri.substring(mongoUri.indexOf("//") + 2));
        String host = uri.getScheme();
        int port = uri.getPort() != -1 ? uri.getPort() : 27017;
        MongoClientSettings settings = MongoClientSettings
                .builder()
                .applyToClusterSettings(builder -> builder.hosts(List.of(new ServerAddress(host,port))))
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), "image_books");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public GridFsTemplate gridFsTemplate() {
        return new GridFsTemplate(mongoDbFactory(), mongoTemplate().getConverter());
    }
}

