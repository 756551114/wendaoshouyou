package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.util.QiangHuaPet;
import org.springframework.stereotype.Service;

/**
 * 一键强化
 */
@Service
public class C40990_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        int no = GameReadTool.readByte(buff);

        int pos = GameReadTool.readByte(buff);

        String para = GameReadTool.readString(buff);

        System.out.println("-----------no--------------------->" + no);
        System.out.println("-----------pos--------------------->" + pos);
        System.out.println("-----------para--------------------->" + para);

        //强化
        if ("mag".equals(para)) {
            QiangHuaPet.mag(no, chara);
        }

    }

    @Override
    public int cmd() {
        return 40990;
    }
}
