//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.game;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class NoviceGiftBagUtils {
    public NoviceGiftBagUtils() {
    }

    public static List<String[]> giftBag(int sex, int metal) {
        List<String[]> list = new LinkedList();
        list.add(giftBags(10, sex, metal));
        list.add(giftBags(20, sex, metal));
        list.add(giftBags(30, sex, metal));
        list.add(giftBags(40, sex, metal));
        list.add(giftBags(50, sex, metal));
        list.add(giftBags(60, sex, metal));
        list.add(giftBags(70, sex, metal));
        list.add(giftBags(80, sex, metal));
        return list;
    }

    public static String[] giftBags(int attrib, int sex, int metal) {
//        String[] bag;
//        String[] bag;
        String[] bag;
        if (attrib == 10) {
            bag = new String[]{"铁枪", "虎爪", "青锋剑", "精铁扇", "流星锤"};
            bag = new String[]{"飞凤钗", "绛紫裙"};
            bag = new String[]{"虎爪#装备", "皮帽#装备", "布鞋#装备", "虎皮衣#装备", "驯兽诀#物品"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 20) {
            bag = new String[]{"点钢枪", "赤炼爪", "沉香剑", "逍遥扇", "八棱锤"};
            bag = new String[]{"碧玉钗", "虹羽衣"};
            bag = new String[]{"赤炼爪#装备", "青铜盔#装备", "马靴#装备", "青铜铠#装备", "纹龙佩#首饰", "青珑挂珠#首饰", "金刚手镯#首饰", "金刚手镯#首饰", "血玲珑#物品", "法玲珑#物品", "代金券#100000"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 30) {
            bag = new String[]{"乌金枪", "残青爪", "飞虹剑", "玉骨扇", "亮银锤"};
            bag = new String[]{"蝴蝶钗", "凤暖袍"};
            bag = new String[]{"残青爪#装备", "冲天盔#装备", "牛皮靴#装备", "皂罗袍#装备", "天神护佑#物品", "血池#物品", "灵池#物品", "火眼金睛#物品", "代金券#150000"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 40) {
            bag = new String[]{"火焰枪", "阴风爪", "乾元剑", "阴阳扇", "乌金锤"};
            bag = new String[]{"金钗", "锦月袄"};
            bag = new String[]{"阴风爪#装备", "虎头盔#装备", "长筒靴#装备", "金锁甲#装备", "天神护佑#物品", "代金券#200000"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 50) {
            bag = new String[]{"双头枪", "寒冰刺", "斩妖剑", "凤羽扇", "混元锤"};
            bag = new String[]{"珍珠钗", "凝霜衣"};
            bag = new String[]{"寒冰刺#装备", "神龙盔#装备", "追云履#装备", "莽龙袍#装备", "天神护佑#物品", "代金券#250000"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 60) {
            bag = new String[]{"寒风枪", "骷髅爪", "昆吾剑", "百花扇", "霹雳锤"};
            bag = new String[]{"凤尾钗", "水合袍"};
            bag = new String[]{"骷髅爪#装备", "白玉冠#装备", "亮银靴#装备", "金丝甲#装备", "天神护佑#物品", "代金券#300000"};
            bag[0] = bag[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = bag[0] + "#装备";
                bag[3] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 70) {
            bag = new String[]{"鱼尾冠", "狐皮袄"};
            bag = new String[]{"乾坤冠#装备", "疾风履#装备", "八卦衣#装备", "天神护佑#物品", "代金券#400000"};
            if (sex == 2) {
                bag[0] = bag[0] + "#装备";
                bag[2] = bag[1] + "#装备";
            }

            return bag;
        } else if (attrib == 80) {
            bag = new String[]{"超级绿水晶#物品", "超级女娲石#物品", "血池#物品", "灵池#物品", "代金券#600000"};
            return bag;
        } else {
            return null;
        }
    }

    public static List<Hashtable<String, Integer>> equipmentGiftBags(int eqType, int eq_attrib) {
        List<Hashtable<String, Integer>> appraisalList = new ArrayList();
        int[] skill_low_cost = new int[]{60, 140, 240, 360, 500, 660, 660};
        int[] phy_power = new int[]{2, 3, 4, 6, 7, 9, 10};
        String[] var10000 = new String[]{"skill_low_cost", "phy_power", "mag_power"};
        var10000 = new String[]{"phy_power", "mag_power", "life"};
        Hashtable key_vlaue_tab;
        if (eqType == 1) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 2);
            key_vlaue_tab.put("skill_low_cost", skill_low_cost[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("phy_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("mag_power", phy_power[eq_attrib / 10 - 1]);
            appraisalList.add(key_vlaue_tab);
        } else {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 2);
            key_vlaue_tab.put("phy_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("mag_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("life", phy_power[eq_attrib / 10 - 1]);
            appraisalList.add(key_vlaue_tab);
        }

        String keyName1 = "wiz";
        String keyName2 = "wiz";
        if (eqType == 1) {
            keyName1 = "accurate";
            keyName2 = "mana";
        }

//        Hashtable key_vlaue_tab;
        if (eq_attrib == 10) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 141 : 48);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 141 : 48);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 20) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 267 : 93);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 267 : 93);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 30) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 417 : 147);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 417 : 147);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 40) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 396 : 140);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 396 : 140);
            key_vlaue_tab.put("changeNum", 2);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 50 && eqType != 1) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, 282);
            key_vlaue_tab.put(keyName2, 282);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 60) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 1023 : 363);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 1023 : 363);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 70 && eqType != 1) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, 453);
            key_vlaue_tab.put(keyName2, 453);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 70 && eqType != 1) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 3);
            key_vlaue_tab.put("phy_power", 10);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 70 && eqType != 1) {
            key_vlaue_tab = new Hashtable();
            key_vlaue_tab.put("groupNo", 4);
            key_vlaue_tab.put("mag_power", 10);
            appraisalList.add(key_vlaue_tab);
        }

        return appraisalList;
    }
}
