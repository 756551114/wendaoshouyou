package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.log4j.Log4j2;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4275_0;
import org.linlinjava.litemall.gameserver.data.write.M4275_0;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class C4274_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int current_time = GameReadTool.readInt(buff);
        log.info("---current_time------------------------>" + current_time);

        int peer_time = GameReadTool.readInt(buff);
        log.info("---peer_time------------------------>" + peer_time);


        Vo_4275_0 vo_4275_0 = new Vo_4275_0();
        vo_4275_0.a = peer_time + 10000 + FightManager.RANDOM.nextInt(500);

        final GameObjectChar session = GameObjectChar.getGameObjectChar();

        final long time = System.currentTimeMillis();

        //超时踢下线
        if (time - session.heartEcho < 3000) {
            ctx.disconnect();
        }


        session.heartEcho = System.currentTimeMillis();

        final ByteBuf write = new M4275_0().write(vo_4275_0);
        ctx.writeAndFlush(write);
    }

    @Override
    public int cmd() {
        return 4274;
    }
}