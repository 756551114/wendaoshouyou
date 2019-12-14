package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45608_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C45607_0 implements GameHandler {



    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "effect_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.texiao;
        vo_61677_0.count = chara.texiao.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);


        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 32) {
                PackModification packModification = GameData.that.basePackModificationService.findOneByStr(chara.backpack.get(i).goodsInfo.str);
                Vo_61677_0 vo_61677_12 = new Vo_61677_0();
                vo_61677_12.store_type = "effect_store";
                vo_61677_12.npcID = 0;
                vo_61677_12.count = 1;
                vo_61677_12.isGoon = 0;
                vo_61677_12.pos = packModification.getPosition();
                GameObjectChar.send(new M61677_01(), vo_61677_12);
            }

        }


        Vo_45608_0 vo_45608_0 = new Vo_45608_0();
        vo_45608_0.count = 13;
        vo_45608_0.name0 = "浪漫玫瑰";
        vo_45608_0.goods_price0 = 0;
        vo_45608_0.name1 = "星汉灿烂·永久";
        vo_45608_0.goods_price1 = 10888;
        vo_45608_0.name2 = "风花雪月·永久";
        vo_45608_0.goods_price2 = 10888;
        vo_45608_0.name3 = "轻羽飞扬·永久";
        vo_45608_0.goods_price3 = 8888;
        vo_45608_0.name4 = "繁花盛开·永久";
        vo_45608_0.goods_price4 = 6888;
        vo_45608_0.name5 = "踏雪无痕·永久";
        vo_45608_0.goods_price5 = 8888;
        vo_45608_0.name6 = "雨过天晴·永久";
        vo_45608_0.goods_price6 = 8888;
        vo_45608_0.name7 = "翩翩起舞";
        vo_45608_0.goods_price7 = 20888;
        vo_45608_0.name8 = "蝶影翩翩·永久";
        vo_45608_0.goods_price8 = 6888;
        vo_45608_0.name9 = "多彩泡泡";
        vo_45608_0.goods_price9 = 20888;
        vo_45608_0.name10 = "步步生莲·永久";
        vo_45608_0.goods_price10 = 6888;
        vo_45608_0.name11 = "星影特效";
        vo_45608_0.goods_price11 = 20888;
        vo_45608_0.name12 = "鸾凤宝玉";
        vo_45608_0.goods_price12 = 20888;
        vo_45608_0.count1 = 0;
        GameObjectChar.send(new M45608_0(), vo_45608_0);

        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "fasion_effect_view";
        GameObjectChar.send(new M41505_0(), vo_41505_0);

        Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
        GameObjectChar.send(new M65529_0(), vo_65529_0);

    }

    @Override
    public int cmd() {
        return 45607;
    }
}