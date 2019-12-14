package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.PackUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C28840_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int index = GameReadTool.readInt(buff);

        int type = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        int count = 3;
        if (index / 10 == 10) {
            if (!has(chara, index, "凝香幻彩")) {
                return;
            }
            deledaoju(chara, index, "凝香幻彩");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("凝香幻彩");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.def = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            list.add(goods1);
            GameObjectChar.send(new M65525_0(), list);

        }
        if (index / 10 == 12) {
            if (!has(chara, index, "炫影霜星")) {
                return;
            }
            deledaoju(chara, index, "炫影霜星");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("炫影霜星");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.parry = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            GameObjectChar.send(new M65525_0(), chara.backpack);


        }
        if (index / 10 == 14) {
            if (!has(chara, index, "风寂云清")) {
                return;
            }
            deledaoju(chara, index, "风寂云清");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("风寂云清");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.wiz = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            GameObjectChar.send(new M65525_0(), chara.backpack);

        }


        if (index / 10 == 16) {
            if (!has(chara, index, "枯月流魂")) {
                return;
            }
            deledaoju(chara, index, "枯月流魂");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("枯月流魂");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.accurate = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            GameObjectChar.send(new M65525_0(), chara.backpack);

        }
        if (index / 10 == 20) {
            if (!has(chara, index, "冰落残阳")) {
                return;
            }
            deledaoju(chara, index, "冰落残阳");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("冰落残阳");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.dex = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            GameObjectChar.send(new M65525_0(), chara.backpack);

        }
        if (index / 10 == 18) {
            if (!has(chara, index, "雷极弧光")) {
                return;
            }
            deledaoju(chara, index, "雷极弧光");
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("雷极弧光");
            List<Goods> list = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo = new GoodsInfo();
            goods1.goodsDaoju(storeInfo);
            goods1.goodsInfo.degree_32 = 0;
            goods1.goodsInfo.skill = (index % 10) + 1;
            goods1.goodsInfo.owner_id = 1;
            goods1.goodsInfo.damage_sel_rate = 400976;
            goods1.goodsInfo.silver_coin = 6000;
            goods1.goodsLanSe.mana = PackUtils.demonStoneValue(index);
            GameUtil.addwupin(goods1, chara);
            GameObjectChar.send(new M65525_0(), chara.backpack);

        }
    }

    @Override
    public int cmd() {
        return 28840;
    }

    public boolean has(Chara chara, int index, String str) {
        int count1 = 0;
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods.goodsInfo.str.equals(str) && goods.goodsInfo.skill == (index % 10)) {
                count1 += goods.goodsInfo.owner_id;
            }
        }
        if (count1 >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public void deledaoju(Chara chara, int index, String str) {
        int count = 3;
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods.goodsInfo.str.equals(str) && goods.goodsInfo.skill == (index % 10)) {
                if (goods.goodsInfo.owner_id >= count) {
                    goods.goodsInfo.owner_id = goods.goodsInfo.owner_id - count;
                    count = 0;
                } else {
                    count -= goods.goodsInfo.owner_id;
                    goods.goodsInfo.owner_id = 0;
                }
                if (goods.goodsInfo.owner_id == 0) {
                    list.add(goods);
                }
                List<Goods> listbeibao = new ArrayList<>();
                Goods goods1 = new Goods();
                goods1.goodsBasics = null;
                goods1.goodsInfo = null;
                goods1.goodsLanSe = null;
                goods1.pos = goods.pos;
                listbeibao.add(goods1);
                GameObjectChar.send(new M65525_0(), listbeibao);
                if (count == 0) {
                    break;
                }
            }
        }
        for (int j = 0; j < list.size(); j++) {
            chara.backpack.remove(list.get(j));
            GameObjectChar.send(new M65525_0(), chara.backpack);
        }
        GameObjectChar.send(new M65525_0(), chara.backpack);

        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "炼制成功";
        vo_8165_0.active = 0;
        GameObjectChar.send(new M8165_0(), vo_8165_0);
        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = "炼制成功";
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);
        Vo_40964_0 vo_40964_0 = new Vo_40964_0();
        vo_40964_0.type = 1;
        vo_40964_0.name = str;
        vo_40964_0.param = "394250";
        vo_40964_0.rightNow = 0;
        GameObjectChar.send(new M40964_0(), vo_40964_0);
        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 46;
        vo_9129_0.para = "1";
        GameObjectChar.send(new M9129_0(), vo_9129_0);
    }
}