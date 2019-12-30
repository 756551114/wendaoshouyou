package org.linlinjava.litemall.gameserver.netty;

import lombok.extern.log4j.Log4j2;
import org.linlinjava.litemall.gameserver.game.GameCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
@Log4j2
public class NettyStart {

    @Value("${netty.port}")
    private int port;

    @Autowired
    private GameCore gameCore;


    @Autowired
    private NettyServer server;

    public void run()  {
        InetSocketAddress address = new InetSocketAddress("0.0.0.0",port);
        server.start(address);
        gameCore.init(server);
    }
}
