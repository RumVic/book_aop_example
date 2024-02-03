package com.vicrum.books.gradleGroovy.java21.app.config;

import com.vicrum.books.gradleGroovy.java21.cash.CachingAspect;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    @Bean
    public CachingAspect cachingAspect() {
        return new CachingAspect();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
