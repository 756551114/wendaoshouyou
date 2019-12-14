package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.game.ConsumeMoneyUtils;
import org.linlinjava.litemall.gameserver.data.game.ForgingEquipmentUtils;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.*;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class C32776_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {



        int pos = GameReadTool.readShort(buff);

        int type = GameReadTool.readByte(buff);


        String para = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (pos < 0) {
            pos = 129 + pos + 127;
        }

        //80级以上首饰合成
        if (13 == type) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                if (goods.pos == pos) {
                    //需要合成的装备等级
                    int attrib = goods.goodsInfo.attrib + 10;
                    //需要合成装备的名字
                    String current = "";
                    List<ZhuangbeiInfo> infoList = GameData.that.baseZhuangbeiInfoService.findByAttrib(attrib);
                    for (int j = 0; j < infoList.size(); j++) {
                        if (infoList.get(j).getAmount() == goods.goodsInfo.amount) {
                            current = infoList.get(j).getStr();
                        }
                    }

                    Hashtable hashMap = new Hashtable();
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if (0 != (Integer) entry.getValue()) {
                            hashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalALLEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, hashMap);
                    if (hashtables.size() > 0) {
                        //找到要合成的装备信息
                        ZhuangbeiInfo zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByStr(current);
                        for (Hashtable<String, Integer> maps : hashtables) {
                            if (maps.get("groupNo") == 2) {
                                maps.put("groupType", 2);
                                GoodsLanSe gooodsLanSe = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLanSe.class);
                                GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, 1, gooodsLanSe);
                            }
                        }
                        GameUtil.removemunber(chara, goods, 1);


                        Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                        vo_40964_0.type = 1;
                        vo_40964_0.name = zhuangbeiInfo.getStr();
                        vo_40964_0.param = "20691134";
                        vo_40964_0.rightNow = 0;
                        GameObjectChar.send(new M40964_0(), vo_40964_0);
                        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
                        vo_9129_0.notify = 10000;
                        vo_9129_0.para = "20691134";
                        GameObjectChar.send(new M9129_0(), vo_9129_0);

                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "你成功合成了1个#R" + zhuangbeiInfo.getStr() + "#n。";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);

                    } else {
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "合成失败!";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                    }
                    int coin = ConsumeMoneyUtils.appraisalMoney(attrib);
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);

                    if (goods.goodsInfo.attrib >= 100) {
                        infoList = GameData.that.baseZhuangbeiInfoService.findByAttrib(70);
                        for (int j = 0; j < infoList.size(); j++) {
                            if (infoList.get(j).getAmount() == goods.goodsInfo.amount) {
                                current = infoList.get(j).getStr();
                            }
                        }
                        GameUtil.removemunber(chara, current, 2);
                    } else {
                        GameUtil.removemunber(chara, "超级女娲石", 2);
                    }
                }
            }

        }
        //首饰合成    //名字_1_0 全部合成 名字_1_1
        if (6 == type) {
            String[] split = para.split("\\_");
            String pos1 = split[0];
            int pos2 = Integer.parseInt(split[1]);
            int pos3 = Integer.parseInt(split[2]);
            int ClassCurrent = 0;
            int count = 0;
            //需要材料的名字
            String current = "";

            //这件要打造出来的装备
            ZhuangbeiInfo zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByStr(pos1);
            if (zhuangbeiInfo.getAttrib() <= 50) {
                ClassCurrent = zhuangbeiInfo.getAttrib() - 15;
            } else {
                ClassCurrent = zhuangbeiInfo.getAttrib() - 10;
            }
            List<ZhuangbeiInfo> infoList = GameData.that.baseZhuangbeiInfoService.findByAttrib(ClassCurrent);
            for (int i = 0; i < infoList.size(); i++) {
                if (infoList.get(i).getAmount() == zhuangbeiInfo.getAmount()) {
                    current = infoList.get(i).getStr();
                }
            }
            //自动合成
            if (pos3 == 1) {
                int currentcount = 0;
                for (int i = 0; i < chara.backpack.size(); i++) {
                    Goods goods = chara.backpack.get(i);
                    if (current.equals(goods.goodsInfo.str)) {
                        currentcount += goods.goodsInfo.owner_id;
                    }
                }
                int owner_id = currentcount / 3;
                GameUtil.removemunber(chara, current, owner_id * 3);
                GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, owner_id);
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "你成功合成了1个#R" + pos1 + "#n。";
                vo_20481_0.time = 1562987118;
                for (int i = 0; i < owner_id; i++) {
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }
                int coin = ConsumeMoneyUtils.appraisalMoney(zhuangbeiInfo.getAttrib());
                chara.balance = chara.balance - coin * owner_id;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            } else {
                if (zhuangbeiInfo.getAttrib() <= 70) {
                    GameUtil.removemunber(chara, current, 3);
                    GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, 1);
                } else {
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalALLEquipment(zhuangbeiInfo.getAmount(), zhuangbeiInfo.getAttrib(), null);
                    GameUtil.removemunber(chara, current, 1);
                    GameUtil.removemunber(chara, "超级女娲石", 2);
                    if (hashtables.size() >= 0) {
                        for (Hashtable<String, Integer> maps : hashtables) {
                            if (maps.get("groupNo") == 2) {
                                maps.put("groupType", 2);
                                GoodsLanSe gooodsLanSe = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLanSe.class);
                                GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, 1, gooodsLanSe);
                            }
                        }
                    }
                }
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "\"你成功合成了1个#R" + pos1 + "#n。";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                int coin = ConsumeMoneyUtils.appraisalMoney(zhuangbeiInfo.getAttrib());
                chara.balance = chara.balance - coin;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            }
            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 10000;
            vo_9129_0.para = "20643387";
            GameObjectChar.send(new M9129_0(), vo_9129_0);
        }
        //装备共鸣
        //1|1  24
        if (24 == type) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                String[] split = para.split("\\|");
                int pos1 = Integer.parseInt(split[0]);
                int pos2 = Integer.parseInt(split[1]);
                Goods goods = chara.backpack.get(i);
                boolean has = true;
                if (pos == goods.pos) {
                    Map<Object, Object> goodsGaiZaoGongMing = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                    for (Map.Entry<Object, Object> entry : goodsGaiZaoGongMing.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            has = false;
                        }
                    }
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.resonanceEquipMent(goods.goodsInfo.attrib, goods.goodsInfo.color, pos1, has);
                    if (hashtables.size() > 0) {
                        for (Hashtable<String, Integer> maps : hashtables) {
                            if (maps.get("groupNo") == 27) {
                                maps.put("groupType", 2);
                                GoodsGaiZaoGongMing goodsLvSeGongMing = (GoodsGaiZaoGongMing) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsGaiZaoGongMing.class);
                                goods.goodsGaiZaoGongMing = goodsLvSeGongMing;
                            }
                        }
                        List<Goods> list = new ArrayList<>();
                        list.add(goods);
                        GameObjectChar.send(new M65525_0(), list);
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 1;
                        vo_41191_0.opType = "";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "恭喜你，炼化成功!";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                    } else {
                        //失败
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 0;
                        vo_41191_0.opType = "";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "炼化失败，请继续努力";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                    }
                    int coin = ConsumeMoneyUtils.remakeMoney(goods.goodsInfo.attrib);
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);

                    GameUtil.removemunber(chara, "装备共鸣石", pos1);
                }
            }
        }
//套装装备炼化
// pos2 金木水火土
        if (5 == type) {
            String[] split = para.split("\\|");
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            int pos3 = Integer.parseInt(split[2]);
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                if (pos == goods.pos) {
                    goods.goodsInfo.suit_enabled = pos2;
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalGreenEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, pos2);
                    for (Hashtable<String, Integer> maps : hashtables) {
                        if (maps.get("groupNo") == 12) {
                            maps.put("groupType", 2);
                            GoodsLvSe goodsLvSe = (GoodsLvSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLvSe.class);
                            if (goodsLvSe == null) {
                                goodsLvSe = new GoodsLvSe();
                            }
                            goods.goodsLvSe = goodsLvSe;
                        }
                        if (maps.get("groupNo") == 8) {
                            maps.put("groupType", 2);
                            GoodsLvSeGongMing goodsLvSeGongMing = (GoodsLvSeGongMing) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLvSeGongMing.class);
                            goods.goodsLvSeGongMing = goodsLvSeGongMing;
                        }
                    }
                    int coin = ConsumeMoneyUtils.appendEqMoney(goods.goodsInfo.attrib);
                    chara.balance = chara.balance - coin;
                    GameUtil.a65511(chara);


                    List<Goods> list = new ArrayList<>();
                    list.add(goods);
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65525_0(), list);


                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                    vo_41191_0.flag = 1;
                    vo_41191_0.opType = "";
                    GameObjectChar.send(new M41191_0(), vo_41191_0);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "恭喜你，炼化成功，属性已生成";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    GameUtil.removemunber(chara, "超级绿水晶", 1);
                }

            }

        }


        //改造装备 2_1  武器1_1
        if (3 == type) {
            String[] split = para.split("\\_");
            if (split.length == 1) {
                return;
            }
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            int iswuqi = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                if (pos == goods.pos) {
                    iswuqi = goods.goodsInfo.amount;
                    String str = null;
                    Map<Object, Object> goodsGaiZai = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                    int[] ints = ForgingEquipmentUtils.remakeAttrib(goods.goodsInfo.color, goods.goodsInfo.store_exp, pos1);
                    if (ints[0] != goods.goodsInfo.color) {
                        goods.goodsInfo.store_exp = 0;
                        for (Map.Entry<Object, Object> entry : goodsGaiZai.entrySet()) {
                            if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                                continue;
                            }
                            if ((Integer) entry.getValue() != 0) {
                                str = (String) entry.getKey();
                            }
                        }
                        List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalRemakeEquipment(str, goods.goodsInfo.amount, goods.goodsInfo.attrib, goods.goodsInfo.color + 1);
                        for (Hashtable<String, Integer> maps : hashtables) {
                            if (maps.get("groupNo") == 27) {
                                maps.put("groupType", 2);
                                GoodsGaiZaoGongMing goodsGaiZaoGongMing = (GoodsGaiZaoGongMing) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsGaiZaoGongMing.class);
                                goods.goodsGaiZaoGongMing = goodsGaiZaoGongMing;
                            }
                            if (maps.get("groupNo") == 10) {
                                maps.put("groupType", 2);
                                GoodsGaiZao goodsGaiZao = (GoodsGaiZao) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsGaiZao.class);
                                goods.goodsGaiZao = goodsGaiZao;
                            }
                        }
                        goods.goodsInfo.color += 1;
                        GameObjectChar.send(new M32775_0(), goods);
                        List<Goods> listgood = new ArrayList<>();
                        listgood.add(goods);
                        GameObjectChar.send(new M65525_0(), listgood);
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "恭喜你，改造成功！装备的改造等级提升到1级";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                        //需要更新 改造页面板
                        //更新人物装备属性
                        GameUtil.a65511(chara);
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 1;
                        vo_41191_0.opType = "";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                    } else {
                        goods.goodsInfo.store_exp = ints[1];
                        List<Goods> listgood = new ArrayList<>();
                        listgood.add(goods);
                        GameObjectChar.send(new M65525_0(), listgood);
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "改造失敗，再接再厉";
                        vo_20481_0.time = 1562987118;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 0;
                        vo_41191_0.opType = "";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                    }

                    int coin = ConsumeMoneyUtils.remakeMoney(goods.goodsInfo.attrib);
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    if (iswuqi == 1) {
                        GameUtil.removemunber(chara, "超级灵石", pos1);
                    } else {
                        GameUtil.removemunber(chara, "超级晶石", pos1);
                    }
                    GameObjectChar.send(new M65525_0(), chara.backpack);
                    return;
                }


            }

        }


        //黄色炼化
        if (8 == type) {
            String[] split = para.split("\\|");
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            int pos3 = Integer.parseInt(split[2]);
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                //找到这个装备
                if (goods.pos == pos) {
                    Map<Object, Object> goodsHuangSe = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    Map<Object, Object> goodsFenSe = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                    HashSet set = new HashSet();
                    List a = new ArrayList();
                    for (Map.Entry<Object, Object> entry : goodsHuangSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            a.add(entry.getKey());
                            set.add(entry.getKey());
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            a.add(entry.getKey());
                            set.add(entry.getKey());
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsFenSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            a.add(entry.getKey());
                            set.add(entry.getKey());
                        }
                    }
                    Collection rs = org.apache.commons.collections.CollectionUtils.disjunction(a, set);
                    set = new HashSet();
                    Object[] objects = rs.toArray();
                    for (int j = 0; j < objects.length; j++) {
                        set.add(objects[j]);
                    }
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalYellowEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, 4, set, pos1);
                    if (hashtables.size() > 0) {
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 1;
                        vo_41191_0.opType = "gold_refine";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);

                        for (Hashtable<String, Integer> maps : hashtables) {
                            System.out.println(maps.values());
                            System.out.println(maps.keys());
                            maps.put("groupType", 2);
                            GoodsHuangSe goodsLanSeObj = (GoodsHuangSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsHuangSe.class);
                            goods.goodsHuangSe = goodsLanSeObj;

                            GameUtil.a65511(chara);
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
                            vo_9129_0.notify = 50;
                            vo_9129_0.para = "39563320";
                            GameObjectChar.send(new M9129_0(), vo_9129_0);
                        }
                    } else {
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 0;
                        vo_41191_0.opType = "gold_refine";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                        vo_20481_0.msg = "炼化失败，请继续努力！";
                        vo_20481_0.time = 1564556611;
                        GameObjectChar.send(new M20481_0(), vo_20481_0);
                    }
                    int coin = ConsumeMoneyUtils.yellowMoney(goods.goodsInfo.attrib);
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    GameUtil.removemunber(chara, "黄水晶", pos2);
                }


            }

        }

//炼化 粉色装备
        if (7 == type) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                //找到这个装备
                if (goods.pos == pos) {
                    Map<Object, Object> goodsHuangSe = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    Map<Object, Object> goodsFenSe = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                    HashSet set = new HashSet();
                    List a = new ArrayList();
                    for (Map.Entry<Object, Object> entry : goodsHuangSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            set.add(entry.getKey());
                            a.add(entry.getKey());
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            set.add(entry.getKey());
                            a.add(entry.getKey());
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsFenSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0) {
                            set.add(entry.getKey());
                            a.add(entry.getKey());
                        }
                    }
                    Collection rs = org.apache.commons.collections.CollectionUtils.disjunction(a, set);
                    set = new HashSet();
                    Object[] objects = rs.toArray();
                    for (int j = 0; j < objects.length; j++) {
                        set.add(objects[j]);
                    }
                    List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, 3, set);
                    for (Hashtable<String, Integer> maps : hashtables) {
                        maps.put("groupType", 2);
                        GoodsFenSe goodsLanSeObj = (GoodsFenSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsFenSe.class);
                        goods.goodsFenSe = goodsLanSeObj;
                        GameUtil.a65511(chara);
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                        int coin = ConsumeMoneyUtils.pinkMoney(goods.goodsInfo.attrib);
                        chara.balance = chara.balance - coin;
                        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                        GameObjectChar.send(new M65527_0(), listVo_65527_0);
                        Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                        vo_41191_0.flag = 1;
                        vo_41191_0.opType = "gold_refine";
                        GameObjectChar.send(new M41191_0(), vo_41191_0);
                        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
                        vo_9129_0.notify = 50;
                        vo_9129_0.para = "39563320";
                        GameObjectChar.send(new M9129_0(), vo_9129_0);
                    }
                    GameUtil.removemunber(chara, "超级粉水晶", 1);
                }

            }
        }

        //强化粉色
        if (10 == type) {
            String[] split = para.split("\\|");
            //宝石的位置
            int pos1 = Integer.parseInt(split[0]);
            String pos2 = split[1];
            int pos3 = Integer.parseInt(split[2]);
            int count = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == pos1) {
                    count++;
                }
            }
            if (count == 0) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "请放入超级黑水晶！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            int leve = 0;
            Goods backpack1 = null;
            Boolean has = false;
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                //找到这个装备
                if (goods.pos == pos) {
                    leve = goods.goodsInfo.attrib;
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        String name = GameData.that.baseShuxingduiyingService.findOneByYingwen(pos2).getName();
                        String equipmentKeyByName = ForgingEquipmentUtils.getEquipmentKeyByName(name, true);
                        if (entry.getKey().equals(equipmentKeyByName)) {
                            int[] equipmentKeyByNames = ForgingEquipmentUtils.appendAttrib(equipmentKeyByName, (Integer) entry.getValue(), goods.goodsInfo.attrib, goods.goodsInfo.amount);
                            int value = equipmentKeyByNames[0];
                            if ((Integer) entry.getValue() < value) {
                                has = true;
                            }
                            goodsLanSe.put(entry.getKey(), value);
                            GoodsFenSe goodsHuangSeObj1 = (GoodsFenSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsFenSe.class);
                            goods.goodsFenSe = goodsHuangSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                        }
                    }
                    GameUtil.removemunber(chara, "超级圣水晶", 1);
                }

            }
            if (has) {

                for (int i = 0; i < chara.backpack.size(); i++) {
                    Goods goods = chara.backpack.get(i);
                    if (goods.pos == pos1) {
                        List<Goods> listbeibao = new ArrayList<>();
                        Goods goods2 = new Goods();
                        goods2.goodsBasics = null;
                        goods2.goodsInfo = null;
                        goods2.goodsLanSe = null;
                        goods2.goodsHuangSe = null;
                        goods2.goodsLvSe = null;
                        goods2.goodsFenSe = null;
                        goods2.pos = pos1;
                        listbeibao.add(goods2);
                        GameObjectChar.send(new M65525_0(), listbeibao);
                        chara.backpack.remove(chara.backpack.get(i));
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                        break;
                    }
                }

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化成功，请再接再厉！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 1;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
            } else {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化失败!";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 0;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
            }

            GameObjectChar.send(new M65525_0(), chara.backpack);

            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 51;
            vo_9129_0.para = "33927504";
            GameObjectChar.send(new M9129_0(), vo_9129_0);

            int coin = ConsumeMoneyUtils.appendEqMoney(leve);
            chara.balance = chara.balance - coin;


            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

        }
        //强化黄色
        if (11 == type) {
            String[] split = para.split("\\|");
            //宝石的位置
            int pos1 = Integer.parseInt(split[0]);
            String pos2 = split[1];
            int pos3 = Integer.parseInt(split[2]);
            int count = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == pos1) {
                    count++;
                }
            }
            if (count == 0) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "请放入超级黑水晶！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            int leve = 0;
            Goods backpack1 = null;
            Boolean has = false;
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                //找到这个装备
                if (goods.pos == pos) {
                    leve = goods.goodsInfo.attrib;
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        String name = GameData.that.baseShuxingduiyingService.findOneByYingwen(pos2).getName();
                        String equipmentKeyByName = ForgingEquipmentUtils.getEquipmentKeyByName(name, true);
                        if (entry.getKey().equals(equipmentKeyByName)) {
                            int[] equipmentKeyByNames = ForgingEquipmentUtils.appendAttrib(equipmentKeyByName, (Integer) entry.getValue(), goods.goodsInfo.attrib, goods.goodsInfo.amount);
                            int value = equipmentKeyByNames[0];
                            if ((Integer) entry.getValue() < value) {
                                has = true;
                            }
                            goodsLanSe.put(entry.getKey(), value);
                            GoodsHuangSe goodsHuangSeObj1 = (GoodsHuangSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsHuangSe.class);
                            goods.goodsHuangSe = goodsHuangSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                        }
                    }
                    GameUtil.removemunber(chara, "超级圣水晶", 1);
                }

            }
            if (has) {

                for (int i = 0; i < chara.backpack.size(); i++) {
                    Goods goods = chara.backpack.get(i);
                    if (goods.pos == pos1) {
                        List<Goods> listbeibao = new ArrayList<>();
                        Goods goods2 = new Goods();
                        goods2.goodsBasics = null;
                        goods2.goodsInfo = null;
                        goods2.goodsLanSe = null;
                        goods2.goodsHuangSe = null;
                        goods2.goodsLvSe = null;
                        goods2.goodsFenSe = null;
                        goods2.pos = pos1;
                        listbeibao.add(goods2);
                        GameObjectChar.send(new M65525_0(), listbeibao);
                        chara.backpack.remove(chara.backpack.get(i));
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                        break;
                    }
                }

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化成功，请再接再厉！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 1;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
            } else {

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化失败!";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 0;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
            }


            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 51;
            vo_9129_0.para = "33927504";
            GameObjectChar.send(new M9129_0(), vo_9129_0);

            int coin = ConsumeMoneyUtils.appendEqMoney(leve);
            chara.balance = chara.balance - coin;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

        }
        //装备强化
        if (9 == type) {

            String[] split = para.split("\\|");
            //宝石的位置
            int pos1 = Integer.parseInt(split[0]);
            String pos2 = split[1];
            int pos3 = Integer.parseInt(split[2]);
            int count = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == pos1) {
                    count++;
                }
            }
            if (count == 0) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "请放入超级黑水晶！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            int leve = 0;
            Goods backpack1 = null;
            Boolean has = false;
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                //找到这个装备
                if (goods.pos == pos) {
                    leve = goods.goodsInfo.attrib;
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        String name = GameData.that.baseShuxingduiyingService.findOneByYingwen(pos2).getName();
                        String equipmentKeyByName = ForgingEquipmentUtils.getEquipmentKeyByName(name, true);
                        if (entry.getKey().equals(equipmentKeyByName)) {
                            int[] equipmentKeyByNames = ForgingEquipmentUtils.appendAttrib(equipmentKeyByName, (Integer) entry.getValue(), goods.goodsInfo.attrib, goods.goodsInfo.amount);
                            int value = equipmentKeyByNames[0];
                            if ((Integer) entry.getValue() < value) {
                                has = true;
                            }
                            goodsLanSe.put(entry.getKey(), value);
                            GoodsLanSe goodsHuangSeObj1 = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsLanSe.class);
                            goods.goodsLanSe = goodsHuangSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                        }
                    }
                    GameUtil.removemunber(chara, "超级圣水晶", 1);
                }

            }
            if (has) {

                for (int i = 0; i < chara.backpack.size(); i++) {
                    Goods goods = chara.backpack.get(i);
                    if (goods.pos == pos1) {
                        List<Goods> listbeibao = new ArrayList<>();
                        Goods goods2 = new Goods();
                        goods2.goodsBasics = null;
                        goods2.goodsInfo = null;
                        goods2.goodsLanSe = null;
                        goods2.goodsHuangSe = null;
                        goods2.goodsLvSe = null;
                        goods2.goodsFenSe = null;
                        goods2.pos = pos1;
                        listbeibao.add(goods2);
                        GameObjectChar.send(new M65525_0(), listbeibao);
                        chara.backpack.remove(chara.backpack.get(i));
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                        break;
                    }
                }

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化成功，请再接再厉！";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 1;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
                Vo_9129_0 vo_9129_0 = new Vo_9129_0();
                vo_9129_0.notify = 51;
                vo_9129_0.para = "33927504";
                GameObjectChar.send(new M9129_0(), vo_9129_0);
            } else {

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "强化失败!";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                Vo_41191_0 vo_41191_0 = new Vo_41191_0();
                vo_41191_0.flag = 0;
                vo_41191_0.opType = "";
                GameObjectChar.send(new M41191_0(), vo_41191_0);
            }


            int coin = ConsumeMoneyUtils.appendEqMoney(leve);
            chara.balance = chara.balance - coin;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
        }

//装备重组
        if (4 == type) {
            ZhuangbeiInfo zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByType(pos);
            //刷新钱
            int coin = ConsumeMoneyUtils.createMoney(zhuangbeiInfo.getAttrib());
            chara.balance = chara.balance - coin;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

            String[] split = para.split("\\|");
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            int pos3 = Integer.parseInt(split[2]);
            Goods goods1 = new Goods();
            Map<Object, Object> goodsLanSe1 = UtilObjMapshuxing.GoodsLanSe(goods1.goodsLanSe);
            Goods backpack1 = null;
            Goods backpack2 = null;
            Goods backpack3 = null;
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                if (goods.pos == pos1) {
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if (0 != (Integer) entry.getValue()) {
                            goodsLanSe1.put(entry.getKey(), entry.getValue());
                        }
                    }
                    List<Goods> listbeibao = new ArrayList<>();
                    Goods goods2 = new Goods();
                    goods2.goodsBasics = null;
                    goods2.goodsInfo = null;
                    goods2.goodsLanSe = null;
                    goods2.pos = pos1;
                    listbeibao.add(goods2);
                    backpack1 = chara.backpack.get(i);
                    GameObjectChar.send(new M65525_0(), listbeibao);
                }
                if (chara.backpack.get(i).pos == pos2) {
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if (0 != (Integer) entry.getValue()) {
                            goodsLanSe1.put(entry.getKey(), entry.getValue());
                        }
                    }
                    List<Goods> listbeibao = new ArrayList<>();
                    Goods goods2 = new Goods();
                    goods2.goodsBasics = null;
                    goods2.goodsInfo = null;
                    goods2.goodsLanSe = null;
                    goods2.pos = pos2;
                    listbeibao.add(goods2);
                    backpack2 = chara.backpack.get(i);
                    GameObjectChar.send(new M65525_0(), listbeibao);

                }
                if (chara.backpack.get(i).pos == pos3) {
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if (0 != (Integer) entry.getValue()) {
                            goodsLanSe1.put(entry.getKey(), entry.getValue());
                        }
                    }
                    List<Goods> listbeibao = new ArrayList<>();
                    Goods goods2 = new Goods();
                    goods2.goodsBasics = null;
                    goods2.goodsInfo = null;
                    goods2.goodsLanSe = null;
                    goods2.pos = pos3;
                    listbeibao.add(goods2);
                    backpack3 = chara.backpack.get(i);

                    GameObjectChar.send(new M65525_0(), listbeibao);
                }
            }

            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = zhuangbeiInfo.getStr();
            vo_40964_0.param = "32271173";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            chara.backpack.remove(backpack1);
            chara.backpack.remove(backpack2);
            chara.backpack.remove(backpack3);
            GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, goods1);
            GoodsLanSe goodsHuangSeObj1 = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe1), GoodsLanSe.class);
            goods1.goodsLanSe = goodsHuangSeObj1;
            List<Goods> listbeibao = new ArrayList<>();
            listbeibao.add(goods1);
            GameObjectChar.send(new M65525_0(), listbeibao);
            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 49;
            vo_9129_0.para = "32271173";
            GameObjectChar.send(new M9129_0(), vo_9129_0);
        }

        //拆分装备
        if (type == 2) {

            for (int i = 0; i < chara.backpack.size(); i++) {
                boolean has = false;

                if (chara.backpack.get(i).pos == pos) {
                    int coin = ConsumeMoneyUtils.removeMoney(chara.backpack.get(i).goodsInfo.attrib);
                    //刷新钱
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);

                    Random random = new Random();
                    Goods goods = chara.backpack.get(i);
                    Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                    Map<Object, Object> goodsHuangSe = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                    Map<Object, Object> goodsFenSe = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                    String name = "";
                    int cont = random.nextInt(10);
                    if (para.equals("3")) {
                        cont = 2;
                    }
                    int jilv = 2;
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if ((Integer) entry.getValue() != 0 && cont <= jilv) {
                            if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                                continue;
                            }
                            Goods good = new Goods();
                            Map<Object, Object> goodsLanSe1 = UtilObjMapshuxing.GoodsLanSe(good.goodsLanSe);
                            goodsLanSe1.put(entry.getKey(), entry.getValue());
                            name = ForgingEquipmentUtils.getEquipmentKeyByName((String) entry.getKey(), false);
                            if (name.contentEquals("伤害_最低伤害")) {
                                name = "伤害";
                            }
                            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("超级黑水晶");
                            GoodsLanSe goodsLanSeObj = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe1), GoodsLanSe.class);
                            good.goodsLanSe = goodsLanSeObj;
                            GameUtil.huodecaifen(chara, storeInfo, 1, goods.goodsInfo.attrib, (Integer) entry.getValue(), name, good, goods.goodsInfo.amount);
                            goodsLanSe.remove(entry.getKey());
                            GoodsLanSe goodsLanSeObj1 = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsLanSe.class);
                            goods.goodsLanSe = goodsLanSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                            jilv = 0;
                            break;
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsHuangSe.entrySet()) {
                        if ((Integer) entry.getValue() != 0 && cont <= jilv) {
                            if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                                continue;
                            }
                            Goods good = new Goods();
                            Map<Object, Object> goodsHuangSe1 = UtilObjMapshuxing.GoodsLanSe(good.goodsLanSe);
                            goodsHuangSe1.put(entry.getKey(), entry.getValue());
                            name = ForgingEquipmentUtils.getEquipmentKeyByName((String) entry.getKey(), false);
                            if (name.contentEquals("伤害_最低伤害")) {
                                name = "伤害";
                            }
                            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("超级黑水晶");
                            GoodsLanSe goodsHuangSeObj = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsHuangSe1), GoodsLanSe.class);
                            good.goodsLanSe = goodsHuangSeObj;
                            GameUtil.huodecaifen(chara, storeInfo, 1, goods.goodsInfo.attrib, (Integer) entry.getValue(), name, good, goods.goodsInfo.amount);
                            goodsHuangSe.remove(entry.getKey());
                            GoodsHuangSe goodsHuangSeObj1 = (GoodsHuangSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsHuangSe), GoodsHuangSe.class);
                            goods.goodsHuangSe = goodsHuangSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                            jilv = 0;
                            break;
                        }
                    }
                    for (Map.Entry<Object, Object> entry : goodsFenSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        if ((Integer) entry.getValue() != 0 && cont <= jilv) {
                            Goods good = new Goods();
                            Map<Object, Object> goodsFenSe1 = UtilObjMapshuxing.GoodsLanSe(good.goodsLanSe);
                            goodsFenSe1.put(entry.getKey(), entry.getValue());
                            name = ForgingEquipmentUtils.getEquipmentKeyByName((String) entry.getKey(), false);
                            if (name.contentEquals("伤害_最低伤害")) {
                                name = "伤害";
                            }
                            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("超级黑水晶");
                            GoodsLanSe goodsFenSeObj = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsFenSe1), GoodsLanSe.class);
                            good.goodsLanSe = goodsFenSeObj;
                            GameUtil.huodecaifen(chara, storeInfo, 1, goods.goodsInfo.attrib, (Integer) entry.getValue(), name, good, goods.goodsInfo.amount);
                            goodsFenSe.remove(entry.getKey());
                            GoodsFenSe goodsFenSeObj1 = (GoodsFenSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsFenSe), GoodsFenSe.class);
                            goods.goodsFenSe = goodsFenSeObj1;
                            List list = new ArrayList();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                            jilv = 0;
                            break;
                        }
                    }
                    int number = 0;
                    for (Map.Entry<Object, Object> entry : goodsLanSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        number += (Integer) entry.getValue();
                    }
                    for (Map.Entry<Object, Object> entry : goodsHuangSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        number += (Integer) entry.getValue();
                    }
                    for (Map.Entry<Object, Object> entry : goodsFenSe.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                            continue;
                        }
                        number += (Integer) entry.getValue();
                    }
                    if (number == 0) {
                        List<Goods> listbeibao = new ArrayList<>();
                        Goods goods1 = new Goods();
                        goods1.goodsBasics = null;
                        goods1.goodsInfo = null;
                        goods1.goodsLanSe = null;
                        goods1.pos = pos;
                        listbeibao.add(goods1);
                        chara.backpack.remove(chara.backpack.get(i));
                        GameObjectChar.send(new M65525_0(), listbeibao);
                    }
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    if (name.equals("")) {
                        vo_20481_0.msg = "拆分失败，请继续努力";
                    } else {
                        vo_20481_0.msg = "你成功拆分出了属性#R" + name + "#n";
                    }
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    GameUtil.removemunber(chara, "超级黑水晶", 1);
                    if (para.equals("3")) {
                        GameUtil.removemunber(chara, "混沌玉", 1);
                    }
                }
            }
        }

        if (1 == type || 12 == type) {

            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == pos) {
                    Goods goods = chara.backpack.get(i);
                    Map<Object, Object> objectObjectMap = UtilObjMapshuxing.Goods(goods);
                    //普通鉴定
                    if (type == 1) {
                        List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, 1);
                        Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                        for (Hashtable<String, Integer> maps : hashtables) {
                            System.out.println();
                            System.out.println();
                            int groupNo = maps.get("groupNo");
                            int groupNolanse = (Integer) goodsLanSe.get("groupNo");
                            if (groupNolanse == groupNo) {
                                for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                                    goodsLanSe.put(entry.getKey(), entry.getValue());
                                }
                            }
                        }
                        GoodsLanSe goodsLanSeObj = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsLanSe.class);
                        Goods goods2 = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectObjectMap), Goods.class);
                        Goods goods1 = new Goods();
                        goods1 = goods2;
                        goods1.pos = GameUtil.beibaoweizhi(chara);
                        goods1.goodsInfo.degree_32 = 0;
                        goods1.goodsInfo.owner_id = 1;
                        goods1.goodsLanSe = goodsLanSeObj;
                        GameUtil.a65511(chara);
                        List list = new ArrayList();
                        list.add(goods1);
                        GameUtil.removemunber(chara, goods, 1);
                        chara.backpack.add(goods1);
                        GameObjectChar.send(new M65525_0(), list);
                    }
                    //精致鉴定
                    if (type == 12) {
                        List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalEquipment(goods.goodsInfo.amount, goods.goodsInfo.attrib, 2);
                        Map<Object, Object> goodsLanSe = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                        Map<Object, Object> goodshuangse = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                        Map<Object, Object> goodsfense = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                        for (Hashtable<String, Integer> maps : hashtables) {
                            System.out.println();
                            System.out.println();
                            int groupNo = maps.get("groupNo");
                            int groupNolanse = (Integer) goodsLanSe.get("groupNo");
                            int groupNohuangse = (Integer) goodshuangse.get("groupNo");
                            int groupNofense = (Integer) goodsfense.get("groupNo");
                            if (groupNolanse == groupNo) {
                                for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                                    goodsLanSe.put(entry.getKey(), entry.getValue());
                                }
                            }
                            if (groupNohuangse == groupNo) {
                                for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                                    goodshuangse.put(entry.getKey(), entry.getValue());
                                }
                            }
                            if (groupNofense == groupNo) {
                                for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                                    goodsfense.put(entry.getKey(), entry.getValue());
                                }
                            }
                        }
                        GoodsLanSe goodsLanSeObj = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsLanSe), GoodsLanSe.class);
                        GoodsHuangSe goodshuangseObj = (GoodsHuangSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodshuangse), GoodsHuangSe.class);
                        GoodsFenSe goodsfenseObj = (GoodsFenSe) JSONUtils.parseObject(JSONUtils.toJSONString(goodsfense), GoodsFenSe.class);

                        Goods goods1 = new Goods();
                        Goods goods2 = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectObjectMap), Goods.class);
                        goods1 = goods2;
                        goods1.pos = GameUtil.beibaoweizhi(chara);
                        goods1.goodsInfo.owner_id = 1;
                        goods1.goodsInfo.degree_32 = 0;
                        goods1.goodsLanSe = goodsLanSeObj;
                        goods1.goodsHuangSe = goodshuangseObj;
                        goods1.goodsFenSe = goodsfenseObj;
                        GameUtil.a65511(chara);
                        List list = new ArrayList();
                        list.add(goods1);
                        GameUtil.removemunber(chara, goods, 1);
                        chara.backpack.add(goods1);
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                    }
                    int coin = ConsumeMoneyUtils.appraisalMoney(goods.goodsInfo.attrib);
                    chara.balance = chara.balance - coin;
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                }

            }
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "鉴定成功！";
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 20022;
            vo_9129_0.para = "11516529|1";
            GameObjectChar.send(new M9129_0(), vo_9129_0);


        }
    }

    @Override
    public int cmd() {
        return 32776;
    }


    public static Goods shuxing(Goods goods, Goods good) {

        return good;
    }
}