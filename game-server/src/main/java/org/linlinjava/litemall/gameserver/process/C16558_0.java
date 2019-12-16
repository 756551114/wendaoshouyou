package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16429_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16431_0;
import org.linlinjava.litemall.gameserver.data.write.M16431_0;
import org.linlinjava.litemall.gameserver.data.write.M16429_0;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C16558_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int map_id = GameReadTool.readInt(buff);

        int x = GameReadTool.readShort(buff);

        int y = GameReadTool.readShort(buff);

        int dir = GameReadTool.readShort(buff);



        GameObjectChar.getGameObjectChar().chara.x = x;
        GameObjectChar.getGameObjectChar().chara.y = y;

        //广播回移动的消息
        Vo_16429_0 vo_16429_0 = new Vo_16429_0();
        vo_16429_0.id = id;
        vo_16429_0.x = x;
        vo_16429_0.y = y;
        vo_16429_0.map_id = map_id;
        GameObjectChar.getGameObjectChar().gameMap.send(new M16429_0(), vo_16429_0);
        //广播回移动的消息
        Vo_16431_0 vo_16431_0 = new Vo_16431_0();
        vo_16431_0.id = id;
        vo_16431_0.x = x;
        vo_16431_0.y = y;
        GameObjectChar.getGameObjectChar().gameMap.send(new M16431_0(), vo_16431_0);
    }

    @Override
    public int cmd() {
        return 16558;
    }
}