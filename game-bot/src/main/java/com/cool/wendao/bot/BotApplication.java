package com.cool.wendao.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication {
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(BotApplication.class, args);
        synchronized (lock) {
            lock.wait();
        }
    }

}
