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
public class C41490_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String equip_str = GameReadTool.readString(buff);

        PackModification packModification = GameData.that.basePackModificationService.findOneByStr(equip_str);
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        if (packModification.getCategory() == 1) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == 31) {
                    Goods goods = chara.backpack.get(i);
//                chara.shizhuang.remove(goods);
                    chara.backpack.remove(chara.backpack.get(i));
                    Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                    vo_61677_0.store_type = "fasion_store";
                    vo_61677_0.npcID = 0;
                    vo_61677_0.list = chara.shizhuang;
                    vo_61677_0.count = chara.shizhuang.size();
                    GameObjectChar.send(new M61677_0(), vo_61677_0);

                }
            }
            Goods goods = new Goods();
            goods.goodsInfo.owner_id = 1;
            goods.goodsInfo.value = 2097924;
            goods.goodsInfo.quality = "金色";
            goods.goodsInfo.alias = packModification.getAlias();
            goods.goodsInfo.amount = 16;
            goods.pos = 31;
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
            chara.backpack.add(goods);
            List<Goods> list = new ArrayList();
            list.add(goods);
            GameObjectChar.send(new M65525_0(), list);
            chara.special_icon = Integer.valueOf(packModification.getFasionType());
            Vo_61677_0 vo_61677_12 = new Vo_61677_0();
            vo_61677_12.store_type = "fasion_store";
            vo_61677_12.npcID = 0;
            vo_61677_12.count = 1;
            vo_61677_12.isGoon = 0;
            vo_61677_12.pos = packModification.getPosition();
            GameObjectChar.send(new M61677_01(), vo_61677_12);

        }

        if (packModification.getCategory() == 2) {
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
            Goods goods = new Goods();
            goods.goodsInfo.owner_id = 1;
            goods.goodsInfo.value = 262;
            goods.goodsInfo.quality = "金色";
            goods.goodsInfo.alias = packModification.getStr();
            goods.goodsInfo.amount = 17;
            goods.pos = 32;
            goods.goodsInfo.food_num = 0;
            goods.goodsInfo.merge_rate = 0;
            goods.goodsInfo.master = 0;
            goods.goodsInfo.recognize_recognized = 2;
            goods.goodsInfo.type = Integer.valueOf(packModification.getType());
            goods.goodsInfo.total_score = 23;
            goods.goodsInfo.damage_sel_rate = 809382;
            goods.goodsInfo.str = packModification.getStr();
//            goods.goodsInfo.metal = chara.menpai;
            goods.goodsInfo.attrib = 0;
            goods.goodsInfo.durability = 8;
            goods.goodsInfo.rebuild_level = 0;
            goods.goodsInfo.auto_fight = "5d65f0216e9552d52c521d59" + packModification.getType();
            chara.backpack.add(goods);
            List<Goods> list = new ArrayList();
            list.add(goods);
            GameObjectChar.send(new M65525_0(), list);
            GameObjectChar.send(new M65525_0(), chara.backpack);
            Vo_61677_0 vo_61677_12 = new Vo_61677_0();
            vo_61677_12.store_type = "effect_store";
            vo_61677_12.npcID = 0;
            vo_61677_12.count = 1;
            vo_61677_12.isGoon = 0;
            vo_61677_12.pos = packModification.getPosition();
            GameObjectChar.send(new M61677_01(), vo_61677_12);
            chara.texiao_icon = Integer.valueOf(packModification.getFasionType());
        }

        if (packModification.getCategory() == 3) {
            Vo_4197_0 vo_4197_0 = new Vo_4197_0();
            vo_4197_0.id = 0;
            GameObjectChar.getGameObjectChar().gameMap.send(new M4197_0(), vo_4197_0);
            GameObjectChar.getGameObjectChar().gameMap.send(new M12285_1(), chara.genchong_icon);
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == 37) {
                    Goods goods = chara.backpack.get(i);
//                chara.shizhuang.remove(goods);
                    chara.backpack.remove(chara.backpack.get(i));
                    Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                    vo_61677_0.store_type = "follow_pet_store";
                    vo_61677_0.npcID = 0;
                    vo_61677_0.list = chara.genchong;
                    vo_61677_0.count = chara.genchong.size();
                    GameObjectChar.send(new M61677_0(), vo_61677_0);

                }
            }
            Goods goods = new Goods();
            goods.goodsInfo.owner_id = 1;
            goods.goodsInfo.value = 262;
            goods.goodsInfo.quality = "金色";
            goods.goodsInfo.alias = packModification.getStr();
            goods.goodsInfo.amount = 17;
            goods.pos = 37;
            goods.goodsInfo.food_num = 0;
            goods.goodsInfo.merge_rate = 0;
            goods.goodsInfo.master = 0;
            goods.goodsInfo.recognize_recognized = 2;
            goods.goodsInfo.type = Integer.valueOf(packModification.getType());
            goods.goodsInfo.total_score = 23;
            goods.goodsInfo.damage_sel_rate = 809382;
            goods.goodsInfo.str = packModification.getStr();
//            goods.goodsInfo.metal = chara.menpai;
            goods.goodsInfo.attrib = 0;
            goods.goodsInfo.durability = 8;
            goods.goodsInfo.rebuild_level = 0;
            goods.goodsInfo.auto_fight = "5d65f0216e9552d52c521d59" + packModification.getType();
            chara.backpack.add(goods);
            List<Goods> list = new ArrayList();
            list.add(goods);
            GameObjectChar.send(new M65525_0(), list);
            Vo_61677_0 vo_61677_12 = new Vo_61677_0();
            vo_61677_12.store_type = "follow_pet_store";
            vo_61677_12.npcID = 0;
            vo_61677_12.count = 1;
            vo_61677_12.isGoon = 0;
            vo_61677_12.pos = packModification.getPosition();
            GameObjectChar.send(new M61677_01(), vo_61677_12);
            chara.genchong_icon = Integer.valueOf(packModification.getFasionType());
            Vo_65529_0 vo_65529_0 = new Vo_65529_0();
            vo_65529_0.id =  Integer.valueOf(packModification.getFasionType());;
            vo_65529_0.x = chara.x;
            vo_65529_0.y = chara.y;
            vo_65529_0.dir = 5;
            vo_65529_0.icon = chara.genchong_icon;
            vo_65529_0.type = 32768;
            vo_65529_0.sub_type = 2;
            vo_65529_0.owner_id = chara.id;
            vo_65529_0.name = packModification.getStr();
            vo_65529_0.org_icon = chara.genchong_icon;
            vo_65529_0.portrait = chara.genchong_icon;
            GameObjectChar.getGameObjectChar().gameMap.send(new M65529_0(), vo_65529_0);
        }


        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);

//
        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;

        GameObjectChar.send(new M61671_0(), vo_61671_0);
        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "穿戴成功";
        vo_8165_0.active = 0;
        GameObjectChar.send(new M8165_0(), vo_8165_0);
        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "equip_fasion";
        GameObjectChar.send(new M41505_0(), vo_41505_0);


    }

    @Override
    public int cmd() {
        return 41490;
    }
}