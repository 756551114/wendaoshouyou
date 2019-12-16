package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4163_0;
import org.linlinjava.litemall.gameserver.data.write.M4163_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4162_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int pet_status = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        chara.chongwuchanzhanId = id;
        if (pet_status == 0) {
            chara.chongwuchanzhanId = 0;
        }
        Vo_4163_0 vo_4163_0 = new Vo_4163_0();
        vo_4163_0.id = id;
        vo_4163_0.b = pet_status;
        GameObjectChar.send(new M4163_0(), vo_4163_0);
    }

    @Override
    public int cmd() {
        return 4162;
    }
}