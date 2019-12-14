package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C8318_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int money = GameReadTool.readInt(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        chara.balance -= money;
        if (chara.gender + money > 2000000000) {
            chara.gender = 2000000000;
        } else {
            chara.gender += money;
        }
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "#成功存入#cBA55DC" + money + "#n文钱#n。";
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectChar.send(new M20481_0(), vo_20481_0);
    }

    @Override
    public int cmd() {
        return 8318;
    }
}