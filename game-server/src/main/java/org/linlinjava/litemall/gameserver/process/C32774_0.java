package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C32774_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int pos = GameReadTool.readShort(buff);

        int type = GameReadTool.readByte(buff);

        String para = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;


    }

    @Override
    public int cmd() {
        return 32774;
    }


}