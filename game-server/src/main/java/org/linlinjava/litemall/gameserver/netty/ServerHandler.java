package org.linlinjava.litemall.gameserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("serverHandler")
@ChannelHandler.Sharable
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
    public static final AttributeKey<GameObjectChar> akey = AttributeKey.newInstance("session");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        final Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        if (attr == null) {
            return;
        }
        final GameObjectChar session = attr.get();
        if (session == null || session.chara == null) {
            return;
        }
        GameObjectCharMng.remove(session);

    }

    @Autowired
    private List<GameHandler> gameHandlers;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        GameObjectChar session = null;
        if (attr != null && attr.get() != null) {
            session = attr.get();
            GameObjectChar.GAMEOBJECTCHAR_THREAD_LOCAL.set(session);
        }
        ByteBuf buff = (ByteBuf) msg;
        GameReadTool.readInt(buff);
        GameReadTool.readShort(buff);
        int cmd = GameReadTool.readShort(buff);
        for (GameHandler waitLine : gameHandlers) {
            if (cmd == waitLine.cmd()) {
                if (session != null) {
                    if (session.lock()) {
                        try {
                            waitLine.process(ctx, buff);
                            break;
                        } finally {
                            session.unlock();
                        }
                    }
                } else {
                    waitLine.process(ctx, buff);
                    break;
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (!cause.toString().contains("java.io.IOException")) {
            log.error("exceptionCaught", cause);
        }
        ctx.close();
    }
}
