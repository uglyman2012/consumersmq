package com.cp.consumersmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class ConsumersmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumersmqApplication.class, args);
    }

}
