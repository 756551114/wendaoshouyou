package org.linlinjava.litemall.gameserver;

import org.linlinjava.litemall.gameserver.netty.NettyStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApplicationNetty  {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationNetty.class, args);
        NettyStart bean = run.getBean(NettyStart.class);
        bean.run();
    }




}