//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.domain;

import java.util.UUID;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;

public class Goods {
    public int pos = 45;
    public GoodsInfo goodsInfo = new GoodsInfo();
    public GoodsBasics goodsBasics = new GoodsBasics();
    public GoodsLanSe goodsLanSe = new GoodsLanSe();
    public GoodsFenSe goodsFenSe = new GoodsFenSe();
    public GoodsHuangSe goodsHuangSe = new GoodsHuangSe();
    public GoodsLvSe goodsLvSe = new GoodsLvSe();
    public GoodsGaiZao goodsGaiZao = new GoodsGaiZao();
    public GoodsGaiZaoGongMing goodsGaiZaoGongMing = new GoodsGaiZaoGongMing();
    public GoodsGaiZaoGongMingChengGong goodsGaiZaoGongMingChengGong = new GoodsGaiZaoGongMingChengGong();
    public GoodsLvSeGongMing goodsLvSeGongMing = new GoodsLvSeGongMing();

    public Goods() {
    }

    public void goodsDaoju(StoreInfo info) {
        if (info.getQuality() != null) {
            this.goodsInfo.quality = info.getQuality();
        }

        if (info.getSilverCoin() != null) {
            this.goodsInfo.silver_coin = info.getSilverCoin();
        }

        if (info.getName().equals("血玲珑")) {
            this.goodsBasics.max_life = 4000000;
            this.goodsInfo.phy_rebuild_level = "剩余血量：4,000,000";
        }

        if (info.getName().equals("法玲珑")) {
            this.goodsBasics.max_mana = 4000000;
            this.goodsInfo.phy_rebuild_level = "剩余法力：4,000,000";
        }

        if (info.getName().equals("中级血玲珑")) {
            this.goodsBasics.max_life = 10000000;
            this.goodsInfo.phy_rebuild_level = "剩余血量：10,000,000";
        }

        if (info.getName().equals("中级法玲珑")) {
            this.goodsBasics.max_mana = 10000000;
            this.goodsInfo.phy_rebuild_level = "剩余法力：10,000,000";
        }

        if (info.getName().equals("火眼金睛")) {
            this.goodsInfo.max_durability = 10;
        }

        this.goodsInfo.type = info.getType();
        this.goodsInfo.str = info.getName();
        this.goodsInfo.recognize_recognized = 0;
        this.goodsInfo.auto_fight = UUID.randomUUID().toString();
        this.goodsInfo.total_score = info.getTotalScore();
        this.goodsInfo.rebuild_level = info.getRebuildLevel();
        this.goodsInfo.value = info.getValue();
        this.goodsInfo.degree_32 = 1;
    }

    public void goodsCreate(ZhuangbeiInfo info) {
        this.goodsInfo.amount = info.getAmount();
        this.goodsInfo.auto_fight = UUID.randomUUID().toString();
        this.goodsInfo.master = info.getMaster();
        this.goodsInfo.type = info.getType();
        this.goodsInfo.str = info.getStr();
        this.goodsInfo.metal = info.getMetal();
        this.goodsInfo.quality = info.getQuality();
        this.goodsInfo.attrib = info.getAttrib();
        this.goodsInfo.total_score = 1;
        this.goodsInfo.rebuild_level = 1500;
        this.goodsInfo.recognize_recognized = 1;
        this.goodsInfo.damage_sel_rate = 1000;
        this.goodsInfo.owner_id = 1;
        this.goodsInfo.dunwu_times = 0;
        this.goodsInfo.gift = 0;
        this.goodsInfo.nick = 0;
        this.goodsInfo.power = 0;
        this.goodsInfo.wrestlescore = 0;
        this.goodsInfo.skill = 0;
        this.goodsInfo.store_exp = 0;
        this.goodsInfo.suit_degree = 0;
        this.goodsInfo.party_stage_party_name = 0;
        this.goodsInfo.mailing_item_times = 0;
        this.goodsInfo.suit_enabled = 0;
        this.goodsInfo.degree_32 = 0;
        this.goodsInfo.value = 8388608;
        this.goodsInfo.color = 0;
        this.goodsBasics.accurate = info.getAccurate();
        this.goodsBasics.def = info.getDef();
        this.goodsBasics.dex = info.getDex();
        this.goodsBasics.mana = info.getMana();
        this.goodsBasics.parry = info.getParry();
        this.goodsBasics.wiz = info.getWiz();
    }
}
