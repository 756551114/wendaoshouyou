package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40987_0;
import org.linlinjava.litemall.gameserver.data.write.M40987_0;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C40986_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int petId = GameReadTool.readInt(buff);

        String type = GameReadTool.readString(buff);

        Vo_40987_0 vo_40987_0 = new Vo_40987_0();
        vo_40987_0.petId = petId;
        vo_40987_0.count = 0;
        GameObjectChar.send(new M40987_0(), vo_40987_0);
    }


    @Override
    public int cmd() {
        return 40986;
    }
}