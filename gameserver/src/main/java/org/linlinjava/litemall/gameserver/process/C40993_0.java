package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40995_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M40995_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class C40993_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int amount = GameReadTool.readInt(buff);

        int choice = GameReadTool.readByte(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        chara.balance = chara.balance - amount;
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

        int prize = prize();
        int money = 0;
        if (choice == prize) {
            money = amount * 60;
        } else if (choice / 10 == prize / 10) {
            money = amount * 12;
        } else if (choice % 10 == prize % 10) {
            money = amount * 5;
        }
        chara.wuxingBalance += money;
        if (chara.wuxingBalance < 0) {
            chara.wuxingBalance = 200000000;
        }
        Vo_40995_0 vo_40995_1 = new Vo_40995_0();
        vo_40995_1.flag = 1;
        vo_40995_1.money = money;
        vo_40995_1.surlus = String.valueOf(chara.wuxingBalance);
        vo_40995_1.overflow = "0";
        vo_40995_1.amount = amount;
        vo_40995_1.choice = choice;
        vo_40995_1.prize = prize;
        vo_40995_1.leftCount = 77;
        GameObjectChar.send(new M40995_0(), vo_40995_1);

        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = "你花费了" + amount + "文钱#n进行五行竞猜。";
        vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectChar.send(new M20480_0(), vo_20480_0);

    }

    @Override
    public int cmd() {
        return 40993;
    }

    public static int prize() {
        Random random = new Random();
        int i = random.nextInt(5) + 1;
        int i1 = random.nextInt(12) + 1;
        return i1 * 10 + i;
    }



}