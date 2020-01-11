package org.linlinjava.litemall.gameserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.log4j.Log4j2;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Qualifier("serverHandler")
@ChannelHandler.Sharable
@Component
@Log4j2
public class ServerHandler extends ChannelInboundHandlerAdapter {
    public static final AttributeKey<GameObjectChar> akey = AttributeKey.newInstance("session");

    Map<Integer,GameHandler> gameHandlers;

    @Autowired
    public ServerHandler(List<GameHandler> gameHandlers){
        this.gameHandlers = new HashMap<>();
        for (GameHandler gameHandler : gameHandlers) {
            this.gameHandlers.put(gameHandler.cmd(),gameHandler);
        }
    }

    /**
     * 黑名单过滤
     *
     * @param ctx
     * @throws Exception
     */
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

        if(cmd != 4274) {
            log.info("封包类型------------------->" + cmd);
        }
        GameHandler waitLine = gameHandlers.get(cmd);
        if(waitLine != null){
            if(cmd != 4274) {
                log.info("waitLine------------------->" + waitLine.getClass().getName());
            }
            if (session != null) {
                if (session.lock()) {
                    try {
                        waitLine.process(ctx, buff);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        session.unlock();
                    }
                }
            } else {
                waitLine.process(ctx, buff);
            }
        }else{
            log.error("封包类型{}没有解析类型------------------->", cmd);
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
