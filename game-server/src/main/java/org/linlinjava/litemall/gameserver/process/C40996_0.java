package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40995_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M40995_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C40996_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = "你获得了" + chara.wuxingBalance + "文钱#n。";
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);

        Vo_40964_0 vo_40964_0 = new Vo_40964_0();
        vo_40964_0.type = 3;
        vo_40964_0.name = "金钱";
        vo_40964_0.param = String.valueOf(chara.wuxingBalance);
        vo_40964_0.rightNow = 0;
        GameObjectChar.send(new M40964_0(), vo_40964_0);
        chara.balance = chara.balance + chara.wuxingBalance;
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);
        chara.wuxingBalance = 0;

        Vo_40995_0 vo_40995_1 = new Vo_40995_0();
        vo_40995_1.flag = 0;
        vo_40995_1.money = 0;
        vo_40995_1.surlus = String.valueOf(chara.wuxingBalance);
        vo_40995_1.overflow = "0";
        vo_40995_1.amount = 0;
        vo_40995_1.choice = 0;
        vo_40995_1.prize = 0;
        vo_40995_1.leftCount = 77;
        GameObjectChar.send(new M40995_0(), vo_40995_1);


    }

    @Override
    public int cmd() {
        return 40996;
    }
}