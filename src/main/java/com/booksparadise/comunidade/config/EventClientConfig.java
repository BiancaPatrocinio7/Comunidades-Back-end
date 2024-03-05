package com.booksparadise.comunidade.config;

import feign.Contract;
import feign.Retryer;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventClientConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(2000, 6000, 0);
    }

    @Bean
    public Contract contract() {
        return new SpringMvcContract();
    }
}
