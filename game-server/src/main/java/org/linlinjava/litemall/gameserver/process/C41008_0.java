package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41009_0;
import org.linlinjava.litemall.gameserver.data.write.M41009_0;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C41008_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Vo_41009_0 vo_41009_0 = new Vo_41009_0();
        vo_41009_0.server_time = (int) (System.currentTimeMillis()/1000);
        vo_41009_0.time_zone = 8;
        GameObjectChar.send(new M41009_0(), vo_41009_0);
    }

    @Override
    public int cmd() {
        return 41008;
    }
}