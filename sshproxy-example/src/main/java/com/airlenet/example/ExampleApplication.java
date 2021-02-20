package com.airlenet.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication

public class ExampleApplication implements ApplicationRunner {
    public static void main(String args[]) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
