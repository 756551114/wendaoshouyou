package org.linlinjava.litemall.gameserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public interface GameHandler {
    void process(ChannelHandlerContext ctx, ByteBuf buff);
    int  cmd();
}
