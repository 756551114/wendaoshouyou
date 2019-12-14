package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49169_0;
import org.linlinjava.litemall.gameserver.data.write.M49169_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C53448_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_49169_0 vo_49169_0 = new Vo_49169_0();
        vo_49169_0.monthDays = 31;

        vo_49169_0.signDays = chara.signDays;

        vo_49169_0.isCanSgin = chara.isCanSgin;

        vo_49169_0.isCanReplenishSign = 0;
        vo_49169_0.name0 = "超级归元露";
        vo_49169_0.number0 = 1;
        vo_49169_0.name1 = "银元宝";
        vo_49169_0.number1 = 100;
        vo_49169_0.name2 = "超级神兽丹";
        vo_49169_0.number2 = 1;
        vo_49169_0.name3 = "超级晶石";
        vo_49169_0.number3 = 1;
        vo_49169_0.name4 = "宠物强化丹";
        vo_49169_0.number4 = 1;
        vo_49169_0.name5 = "宠风散";
        vo_49169_0.number5 = 1;
        vo_49169_0.name6 = "银元宝";
        vo_49169_0.number6 = 100;
        vo_49169_0.name7 = "超级神兽丹";
        vo_49169_0.number7 = 1;
        vo_49169_0.name8 = "超级晶石";
        vo_49169_0.number8 = 1;
        vo_49169_0.name9 = "点化丹";
        vo_49169_0.number9 = 1;
        vo_49169_0.name10 = "超级归元露";
        vo_49169_0.number10 = 1;
        vo_49169_0.name11 = "银元宝";
        vo_49169_0.number11 = 100;
        vo_49169_0.name12 = "超级神兽丹";
        vo_49169_0.number12 = 1;
        vo_49169_0.name13 = "超级晶石";
        vo_49169_0.number13 = 1;
        vo_49169_0.name14 = "装备共鸣石";
        vo_49169_0.number14 = 1;
        vo_49169_0.name15 = "宠风散";
        vo_49169_0.number15 = 1;
        vo_49169_0.name16 = "银元宝";
        vo_49169_0.number16 = 100;
        vo_49169_0.name17 = "超级神兽丹";
        vo_49169_0.number17 = 1;
        vo_49169_0.name18 = "超级晶石";
        vo_49169_0.number18 = 1;
        vo_49169_0.name19 = "羽化丹";
        vo_49169_0.number19 = 1;
        vo_49169_0.name20 = "超级归元露";
        vo_49169_0.number20 = 1;
        vo_49169_0.name21 = "银元宝";
        vo_49169_0.number21 = 100;
        vo_49169_0.name22 = "超级神兽丹";
        vo_49169_0.number22 = 1;
        vo_49169_0.name23 = "超级晶石";
        vo_49169_0.number23 = 1;
        vo_49169_0.name24 = "神木鼎";
        vo_49169_0.number24 = 1;
        vo_49169_0.name25 = "宠风散";
        vo_49169_0.number25 = 1;
        vo_49169_0.name26 = "银元宝";
        vo_49169_0.number26 = 100;
        vo_49169_0.name27 = "超级神兽丹";
        vo_49169_0.number27 = 1;
        vo_49169_0.name28 = "超级晶石";
        vo_49169_0.number28 = 1;
        vo_49169_0.name29 = "精怪诱饵";
        vo_49169_0.number29 = 1;
        vo_49169_0.name30 = "超级归元露";
        vo_49169_0.number30 = 1;
        GameObjectChar.send(new M49169_0(), vo_49169_0);

    }

    @Override
    public int cmd() {
        return 53448;
    }
}
