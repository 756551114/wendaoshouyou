package com.cool.wendao.data;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cool.wendao.*.dao")
public class DataApplication {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DataApplication.class, args);
        synchronized (lock) {
            lock.wait();
        }
    }


}
