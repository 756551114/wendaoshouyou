package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C8410_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String barcode = GameReadTool.readString(buff);

        int amount = GameReadTool.readShort(buff);

        String coin_pwd = GameReadTool.readString(buff);

        String coin_type = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if (barcode.equals("C0000001")) {
            chara.balance = chara.balance + 3000000;
            chara.extra_life = chara.extra_life - 300;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "3000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R300#n个金元宝购买了#Y3,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }
        if (barcode.equals("C0000002")) {
            chara.balance = chara.balance + 6000000;
            chara.extra_life = chara.extra_life - 600;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "6000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R600#n个金元宝购买了#Y6,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }
        if (barcode.equals("C0000003")) {
            chara.balance = chara.balance + 10000000;
            chara.extra_life = chara.extra_life - 1100;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "6000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R1100#n个金元宝购买了#Y10,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }
        if (barcode.equals("C0000004")) {
            chara.balance = chara.balance + 30000000;
            chara.extra_life = chara.extra_life - 3300;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "6000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R3300#n个金元宝购买了#Y30,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }
        if (barcode.equals("C0000005")) {
            chara.balance = chara.balance + 60000000;
            chara.extra_life = chara.extra_life - 7200;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "6000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R7200#n个金元宝购买了#Y60,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }
        if (barcode.equals("C0000006")) {
            chara.balance = chara.balance + 100000000;
            chara.extra_life = chara.extra_life - 7200;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 3;
            vo_40964_0.name = "金钱";
            vo_40964_0.param = "100000000";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你花费#R12000#n个金元宝购买了#Y100,000,000#n文钱#n。";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "购买成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            return;
        }


        StoreGoods oneByBarcode = GameData.that.baseStoreGoodsService.findOneByBarcode(barcode);
//        public int gold_coin;
//        //金元宝
//        public int extra_life;
        if (oneByBarcode.getForSale() == 1) {
            coin_type = "gold_coin";
        }
        if (coin_type.equals("")) {
            if (oneByBarcode.getCoin() * amount <= chara.gold_coin) {
                chara.gold_coin -= oneByBarcode.getCoin() * amount;
            } else if (oneByBarcode.getCoin() * amount <= chara.extra_life) {
                chara.extra_life -= oneByBarcode.getCoin() * amount;
            }
        } else if (coin_type.equals("gold_coin") && oneByBarcode.getCoin() * amount < chara.extra_life) {
            chara.extra_life -= oneByBarcode.getCoin() * amount;
        } else {
            return;
        }

        if (barcode.equals("R0004026") || barcode.equals("R0004025") || barcode.equals("R0004024")) {

            ZhuangbeiInfo oneByStr = GameData.that.baseZhuangbeiInfoService.findOneByStr(oneByBarcode.getName());

            GameUtil.huodezhuangbei(chara, oneByStr, 0, amount);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = oneByStr.getStr();
            vo_40964_0.param = "-1";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
        } else {
            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName(oneByBarcode.getName());
            GameUtil.huodedaoju(chara, storeInfo, amount);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = storeInfo.getName();
            vo_40964_0.param = "-1";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
        }


        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

    }

    @Override
    public int cmd() {
        return 8410;
    }
}