package com.vicrum.books_gradleKotlin_java21.logging;

import com.vicrum.books_gradleKotlin_java21.cash.CachingAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class AppAOPConfig {
    @Bean
    public Logger logger() {
        return   LoggerFactory.getLogger(this.getClass());
    }
    @Bean
    public CachingAspect cachingAspect() {
        return new CachingAspect();
    }
}
