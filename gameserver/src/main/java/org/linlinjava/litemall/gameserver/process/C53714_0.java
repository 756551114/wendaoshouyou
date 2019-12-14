package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53713_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.write.M41505_0;
import org.linlinjava.litemall.gameserver.data.write.M53713_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_01;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C53714_0 implements GameHandler {



    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "follow_pet_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.genchong;
        vo_61677_0.count = chara.genchong.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);


        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 37) {
                PackModification packModification = GameData.that.basePackModificationService.findOneByStr(chara.backpack.get(i).goodsInfo.str);
                Vo_61677_0 vo_61677_12 = new Vo_61677_0();
                vo_61677_12.store_type = "follow_pet_store";
                vo_61677_12.npcID = 0;
                vo_61677_12.count = 1;
                vo_61677_12.isGoon = 0;
                vo_61677_12.pos = packModification.getPosition();
                GameObjectChar.send(new M61677_01(), vo_61677_12);
            }
        }



        Vo_53713_0 vo_53713_0 = new Vo_53713_0();
        vo_53713_0.count = 11;
        vo_53713_0.name0 = "小绯·永久";
        vo_53713_0.goods_price0 = 8888;
        vo_53713_0.name1 = "水精·永久";
        vo_53713_0.goods_price1 = 8888;
        vo_53713_0.name2 = "太小极·永久";
        vo_53713_0.goods_price2 = 28888;
        vo_53713_0.name3 = "火魂·永久";
        vo_53713_0.goods_price3 = 8888;
        vo_53713_0.name4 = "木心·永久";
        vo_53713_0.goods_price4 = 8888;
        vo_53713_0.name5 = "小海龟·永久";
        vo_53713_0.goods_price5 = 8888;
        vo_53713_0.name6 = "泥泥·永久";
        vo_53713_0.goods_price6 = 28888;
        vo_53713_0.name7 = "蓝极公主·永久";
        vo_53713_0.goods_price7 = 18888;
        vo_53713_0.name8 = "土魄·永久";
        vo_53713_0.goods_price8 = 8888;
        vo_53713_0.name9 = "金灵·永久";
        vo_53713_0.goods_price9 = 8888;
        vo_53713_0.name10 = "灯笼宝宝·永久";
        vo_53713_0.goods_price10 = 18888;
        GameObjectChar.send(new M53713_0(), vo_53713_0);



        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "view_follow_pet";
        GameObjectChar.send(new M41505_0(), vo_41505_0);


    }

    @Override
    public int cmd() {
        return 53714;
    }
}