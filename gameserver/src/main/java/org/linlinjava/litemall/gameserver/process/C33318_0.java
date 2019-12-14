package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.write.M41505_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_01;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;



@Service
public class C33318_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int is_buy = GameReadTool.readByte(buff);

        String item_names = GameReadTool.readString(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;


        PackModification packModification = GameData.that.basePackModificationService.findOneByAlias(item_names);


        chara.extra_life = chara.extra_life - packModification.getGoodsPrice();
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);

        Goods goods = new Goods();
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.value = 2097924;
        goods.goodsInfo.quality = "金色";
        goods.goodsInfo.alias = item_names;
        goods.goodsInfo.amount = 16;
        goods.pos = packModification.getPosition();
        goods.goodsInfo.food_num = 2;
        goods.goodsInfo.master = chara.sex;
        goods.goodsInfo.recognize_recognized = 0;
        goods.goodsInfo.type = Integer.valueOf(packModification.getType());
        goods.goodsInfo.total_score = 25;
        goods.goodsInfo.damage_sel_rate = 1842075;
        goods.goodsInfo.str = packModification.getStr();
        goods.goodsInfo.metal = chara.menpai;
        goods.goodsInfo.durability = 8;
        goods.goodsInfo.rebuild_level = 500;
        goods.goodsInfo.auto_fight = "5d65f0216e9552d52c521d59";
        chara.shizhuang.add(goods);



        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "fasion_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.shizhuang;
        vo_61677_0.count = chara.shizhuang.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);


        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你花费了" + packModification.getGoodsPrice() + "#n个金元宝购买了#Y" + item_names + "#n。";
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectChar.send(new M20481_0(), vo_20481_0);


        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "equip_fasion";
        GameObjectChar.send(new M41505_0(), vo_41505_0);

        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 31) {
                 packModification = GameData.that.basePackModificationService.findOneByStr(chara.backpack.get(i).goodsInfo.str);
                Vo_61677_0 vo_61677_12 = new Vo_61677_0();
                vo_61677_12.store_type = "fasion_store";
                vo_61677_12.npcID = 0;
                vo_61677_12.count = 1;
                vo_61677_12.isGoon = 0;
                vo_61677_12.pos = packModification.getPosition();
                GameObjectChar.send(new M61677_01(), vo_61677_12);
            }

        }


    }

    @Override
    public int cmd() {
        return 33318;
    }
}