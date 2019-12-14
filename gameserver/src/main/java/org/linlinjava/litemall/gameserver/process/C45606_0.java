package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class C45606_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String item_name = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 32) {
                Goods goods = chara.backpack.get(i);
//                chara.shizhuang.remove(goods);
                chara.backpack.remove(chara.backpack.get(i));
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.store_type = "effect_store";
                vo_61677_0.npcID = 0;
                vo_61677_0.list = chara.texiao;
                vo_61677_0.count = chara.texiao.size();
                GameObjectChar.send(new M61677_0(), vo_61677_0);

            }
        }
        PackModification packModification = GameData.that.basePackModificationService.findOneByAlias(item_name);

        chara.texiao_icon = Integer.valueOf(packModification.getFasionType());
        chara.extra_life = chara.extra_life - packModification.getGoodsPrice();
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        Goods goods = new Goods();
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.value = 2097924;
        goods.goodsInfo.quality = "金色";
        goods.goodsInfo.alias = item_name;
        goods.goodsInfo.amount = 17;
        goods.pos = packModification.getPosition();
        goods.goodsInfo.food_num = 0;
        goods.goodsInfo.master = chara.sex;
        goods.goodsInfo.recognize_recognized = 2;
        goods.goodsInfo.type = Integer.valueOf(packModification.getType());
        goods.goodsInfo.total_score = 25;
        goods.goodsInfo.damage_sel_rate = 1842075;
        goods.goodsInfo.str = packModification.getStr();
        goods.goodsInfo.metal = chara.menpai;
        goods.goodsInfo.attrib=0;
        goods.goodsInfo.durability = 8;
        goods.goodsInfo.rebuild_level = 0;
        goods.goodsInfo.auto_fight = "5d65f0216e9552d52c521d59"+packModification.getPosition();
        chara.texiao.add(goods);


        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "effect_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.texiao;
        vo_61677_0.count = chara.texiao.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);

        Vo_61677_0 vo_61677_12 = new Vo_61677_0();
        vo_61677_12.store_type = "effect_store";
        vo_61677_12.npcID = 0;
        vo_61677_12.count = 1;
        vo_61677_12.isGoon = 0;
        vo_61677_12.pos = packModification.getPosition();
        GameObjectChar.send(new M61677_01(), vo_61677_12);

        goods = new Goods();
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.value = 262;
        goods.goodsInfo.quality = "金色";
        goods.goodsInfo.alias = packModification.getStr();
        goods.goodsInfo.amount = 17;
        goods.pos = 32;
        goods.goodsInfo.food_num = 0;
        goods.goodsInfo.merge_rate=0;
        goods.goodsInfo.master = 0;
        goods.goodsInfo.recognize_recognized = 2;
        goods.goodsInfo.type = Integer.valueOf(packModification.getType());
        goods.goodsInfo.total_score = 23;
        goods.goodsInfo.damage_sel_rate = 809382;
        goods.goodsInfo.str = packModification.getStr();
        goods.goodsInfo.metal = 0;
        goods.goodsInfo.durability = 8;
        goods.goodsInfo.attrib=0;
        goods.goodsInfo.rebuild_level = 0;
        goods.goodsInfo.auto_fight = "5d65f0216e9552d52c521d59"+packModification.getPosition();
        chara.backpack.add(goods);
        List<Goods> list = new ArrayList();
        list.add(goods);
        GameObjectChar.send(new M65525_0(), list);


        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);

         vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.send(new M61661_0(), vo_61661_0);

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;
        GameObjectChar.send(new M61671_0(), vo_61671_0);


        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你花费了 " + packModification.getGoodsPrice() + "个金元宝购买了#Y" + item_name + "#n。";
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new M20481_0(), vo_20481_0);


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
        vo_41505_0.type = "equip_fasion";
        GameObjectChar.send(new M41505_0(), vo_41505_0);


    }

    @Override
    public int cmd() {
        return 45606;
    }
}