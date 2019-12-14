package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Map;
import org.linlinjava.litemall.db.domain.RenwuMonster;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;



@Service
public class C8236_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int pos = GameReadTool.readByte(buff);

        int amount = GameReadTool.readShort(buff);

        if (pos < 0) {
            pos = 129 + pos + 127;
        }

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == pos) {
                Goods goods = chara.backpack.get(i);
                if (goods.goodsInfo.str.equals("喇叭")) {
                    Vo_9129_0 vo_9129_0 = new Vo_9129_0();
                    vo_9129_0.notify = 97;
                    vo_9129_0.para = "HornDlg=喇叭";
                    GameObjectChar.send(new M9129_0(), vo_9129_0);

                }
                if (goods.goodsInfo.str.equals("血池")) {
                    chara.extra_mana += 300000;
                    if (chara.extra_mana > 90000000) {
                        chara.extra_mana = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "血池", 1);
                }
                if (goods.goodsInfo.str.equals("中级血池")) {
                    chara.extra_mana += 1500000;
                    if (chara.extra_mana > 90000000) {
                        chara.extra_mana = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "中级血池", 1);

                }
                if (goods.goodsInfo.str.equals("高级血池")) {
                    chara.extra_mana += 7500000;
                    if (chara.extra_mana > 90000000) {
                        chara.extra_mana = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "高级血池", 1);
                }
                if (goods.goodsInfo.str.equals("灵池")) {
                    chara.have_coin_pwd += 300000;
                    if (chara.have_coin_pwd > 90000000) {
                        chara.have_coin_pwd = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "灵池", 1);
                }
                if (goods.goodsInfo.str.equals("中级灵池")) {
                    chara.have_coin_pwd += 1500000;
                    if (chara.have_coin_pwd > 90000000) {
                        chara.have_coin_pwd = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "中级灵池", 1);
                }
                if (goods.goodsInfo.str.equals("高级灵池")) {
                    chara.have_coin_pwd += 7500000;
                    if (chara.have_coin_pwd > 90000000) {
                        chara.have_coin_pwd = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "高级灵池", 1);
                }
                if (goods.goodsInfo.str.equals("驯兽诀")) {
                    chara.use_skill_d += 300;
                    if (chara.use_skill_d > 90000000) {
                        chara.use_skill_d = 90000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "驯兽诀", 1);
                }


                if (goods.goodsInfo.str.equals("超级仙风散")) {
                    chara.enable_double_points += 200;
                    if (chara.enable_double_points > 12000) {
                        chara.enable_double_points = 12000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "超级仙风散", 1);

                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R超级仙风散#n，当前余额#R" + chara.enable_double_points + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("神木鼎")) {
                    chara.enable_shenmu_points += 1000;
                    if (chara.enable_shenmu_points > 8000) {
                        chara.enable_shenmu_points = 8000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "神木鼎", 1);

                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R神木鼎#n，当前余额#R" + chara.enable_shenmu_points + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("紫气鸿蒙")) {
                    chara.extra_skill += 200;
                    if (chara.extra_skill > 12000) {
                        chara.extra_skill = 12000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "紫气鸿蒙", 1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R紫气鸿蒙#n，当前余额#R" + chara.extra_skill + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("如意刷到令")) {
                    chara.chushi_ex += 200;
                    if (chara.chushi_ex > 4000) {
                        chara.chushi_ex = 4000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "如意刷到令", 1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R如意刷到令#n，当前余额#R" + chara.chushi_ex + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("急急如律令")) {
                    chara.fetch_nice += 200;
                    if (chara.fetch_nice > 4000) {
                        chara.fetch_nice = 4000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "急急如律令", 1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R急急如律令#n，当前余额#R" + chara.fetch_nice + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("宠风散")) {
                    chara.shuadaochongfeng_san += 200;
                    if (chara.shuadaochongfeng_san > 12000) {
                        chara.shuadaochongfeng_san = 12000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "宠风散", 1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了道具#R宠风散#n，当前余额#R" + chara.shuadaochongfeng_san + "点。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }


                if (goods.goodsInfo.str.equals("高级驯兽诀")) {
                    chara.use_skill_d += 2500;
                    if (chara.use_skill_d < 0) {
                        chara.use_skill_d = 3000000;
                    }
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "高级驯兽诀", 1);
                }
                if (goods.goodsInfo.str.equals("灵物囊")) {
                    String name = callMounts();
                    StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(name);
                    GameUtil.huodedaoju(chara, info, 1);
                    GameUtil.removemunber(chara, "灵物囊", 1);
                    Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                    vo_40964_0.type = 1;
                    vo_40964_0.name = name;
                    vo_40964_0.param = info.getType().toString();
                    vo_40964_0.rightNow = 0;
                    GameObjectChar.send(new M40964_0(), vo_40964_0);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你打开了灵物囊，获得了#R1#n个#R" + name + "#n。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }

                if (goods.goodsInfo.str.equals("天书")) {
                    String name = callMountstianshu();
                    StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(name);
                    GameUtil.huodedaoju(chara, info, 1);
                    String name1 = callMountstianshu();
                    StoreInfo info1 = GameData.that.baseStoreInfoService.findOneByName(name1);
                    GameUtil.huodedaoju(chara, info1, 1);
                    GameUtil.removemunber(chara, "天书", 1);
                    Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                    vo_40964_0.type = 1;
                    vo_40964_0.name = name;
                    vo_40964_0.param = info.getType().toString();
                    vo_40964_0.rightNow = 0;
                    GameObjectChar.send(new M40964_0(), vo_40964_0);
                    vo_40964_0 = new Vo_40964_0();
                    vo_40964_0.type = 1;
                    vo_40964_0.name = name;
                    vo_40964_0.param = info1.getType().toString();
                    vo_40964_0.rightNow = 0;
                    GameObjectChar.send(new M40964_0(), vo_40964_0);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你使用了天书";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }
                if (goods.goodsInfo.str.equals("超级藏宝图")) {
                    if (chara.changbaotu.mapid != 0) {
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "当前有藏宝图任务";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                        return;
                    }
                    Random random = new Random();
                    List<RenwuMonster> renwuMonsterServiceAll = GameData.that.baseRenwuMonsterService.findByType(8);
                    RenwuMonster renwuMonster = renwuMonsterServiceAll.get(random.nextInt(renwuMonsterServiceAll.size()));
                    Vo_61553_0 vo_61553_0 = new Vo_61553_0();
                    vo_61553_0.count = 1;
                    vo_61553_0.task_type = "超级宝藏";
                    vo_61553_0.task_desc = "在游戏中根据超级藏宝图进行寻宝。";
                    vo_61553_0.task_prompt = "#前往#Z" + renwuMonster.getMapName() + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")#Z寻宝";
                    vo_61553_0.refresh = 1;
                    vo_61553_0.task_end_time = 1567909190;
                    vo_61553_0.attrib = 1;
                    vo_61553_0.reward = "#I道行|道行#I#I潜能|潜能#I#I金钱|金钱#I#I物品|召唤令·十二生肖#I#I宠物|十二生肖=F#I";
                    vo_61553_0.show_name = "超级宝藏";
                    vo_61553_0.tasktask_extra_para = "";
                    vo_61553_0.tasktask_state = "1";
                    GameObjectChar.getGameObjectChar().send(new M61553_0(), vo_61553_0);
                    Map map = GameData.that.baseMapService.findOneByName(renwuMonster.getMapName());
                    chara.changbaotu.mapid = map.getMapId();
                    chara.changbaotu.name = renwuMonster.getMapName();
                    chara.changbaotu.x = renwuMonster.getX();
                    chara.changbaotu.y = renwuMonster.getY();
                    Vo_45063_0 vo_45063_0 = new Vo_45063_0();
                    vo_45063_0.task_name = "#前往#Z" + renwuMonster.getMapName() + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")#Z寻宝";
                    vo_45063_0.check_point = 147761859;
                    GameObjectChar.getGameObjectChar().send(new M45063_0(), vo_45063_0);

                    GameUtil.removemunber(chara, "超级藏宝图", 1);
                }
            }
        }


    }

    @Override
    public int cmd() {
        return 8236;
    }

    /**
     * 坐骑召唤
     * isOrdinary 普通召唤
     *
     * @return
     */
    private static String callMounts() {
        String[] mounts_name = {"控心玉", "定鞍石", "驱力刺", "困灵砂", "拘首环"};
        Random random = new Random();
        int randomInt = random.nextInt(5); //[1,100]
        String name = mounts_name[randomInt];
        return name;
    }

    /**
     * 天书
     * isOrdinary 天书
     *
     * @return
     */
    private static String callMountstianshu() {
        String[] mounts_name = {"反击", "惊雷", "尽忠", "烈炎", "碎石", "仙风", "青木", "修罗术", "降魔斩", "狂暴", "寒冰", "云体", "怒击", "破天", "魔引"};
        Random random = new Random();
        int randomInt = random.nextInt(15); //[1,100]
        String name = mounts_name[randomInt];
        return name;
    }
}