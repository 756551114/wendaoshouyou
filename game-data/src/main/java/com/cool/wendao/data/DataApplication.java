package com.cool.wendao.data;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cool.wendao.data.dao")
public class DataApplication {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DataApplication.class, args);
        synchronized (lock) {
            lock.wait();
        }
    }


}
