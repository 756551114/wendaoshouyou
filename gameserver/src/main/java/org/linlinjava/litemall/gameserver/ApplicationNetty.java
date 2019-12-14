package org.linlinjava.litemall.gameserver;

import org.linlinjava.litemall.gameserver.game.GameCore;
import org.linlinjava.litemall.gameserver.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
@SpringBootApplication
@Component
@Order(value = 1)
public class ApplicationNetty implements ApplicationRunner {

    @Autowired
    private GameCore gameCore;

    public static void main(String[] args) {
        System.out.println("run .... . ... :");
        SpringApplication.run(ApplicationNetty.class, args);
    }
    @Value("${netty.port}")
    private int port;

    @Value("${netty.url}")
    private String url;

    @Autowired
    private NettyServer server;

    private static final Logger log = LoggerFactory.getLogger(ApplicationNetty.class);

    @Override
    public void run(ApplicationArguments args)  {
        InetSocketAddress address = new InetSocketAddress(url,port);
        log.debug("run .... . ... "+url);
        server.start(address);
        gameCore.init(server);
    }
}