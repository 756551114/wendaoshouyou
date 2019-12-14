package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45056_0;
import org.linlinjava.litemall.gameserver.data.write.M45056_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C45057_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int type = GameReadTool.readShort(buff);

        String para = GameReadTool.readString(buff);

        final GameObjectChar session = GameObjectChar.getGameObjectChar();


        final Chara chara = GameObjectChar.getGameObjectChar().chara;
        final Vo_45056_0 vo_45056_0 = GameUtil.a45056(chara);
        GameObjectChar.send(new M45056_0(), vo_45056_0);

    }

    @Override
    public int cmd() {
        return 45057;
    }


}