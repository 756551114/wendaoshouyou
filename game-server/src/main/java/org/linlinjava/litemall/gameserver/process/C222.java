package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.write.M61663;
import org.linlinjava.litemall.gameserver.game.GameCore;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C222 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        GameObjectChar.send(new M61663(), GameCore.that.getGameLineAll());
    }
    @Override
    public int cmd() {
        return 222;
    }
}