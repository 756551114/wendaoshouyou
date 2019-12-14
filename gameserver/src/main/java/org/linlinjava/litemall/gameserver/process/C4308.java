package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.write.M8405;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4308 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        final String lineName = GameReadTool.readString(buff);

        GameObjectChar.send(new M8405(), GameObjectChar.getGameObjectChar().chara.name);
    }
    @Override
    public int cmd() {
        return 4308;
    }
}