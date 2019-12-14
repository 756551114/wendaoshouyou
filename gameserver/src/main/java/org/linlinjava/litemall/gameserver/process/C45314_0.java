package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45315_0;
import org.linlinjava.litemall.gameserver.data.write.M45315_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C45314_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_45315_0 vo_45315_0 = new Vo_45315_0();
        vo_45315_0.id = chara.chongwuchanzhanId;
        GameObjectChar.send(new M45315_0(), vo_45315_0);


    }

    @Override
    public int cmd() {
        return 45314;
    }
}