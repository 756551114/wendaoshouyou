package org.linlinjava.litemall.gameserver.data.game;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 蓝 粉 黄 任何属性不能同时存在3条及以上
 * <p>
 * <p>
 * 拆分的话40%
 */
public class ForgingEquipmentUtils {


    //金木水火土
    public static final int RESIST_POLAR_J = 1;
    public static final int RESIST_POLAR_M = 2;
    public static final int RESIST_POLAR_S = 3;
    public static final int RESIST_POLAR_H = 4;
    public static final int RESIST_POLAR_T = 5;


    //改造装备
    public static final int EQUIPMENT_APPRAISA_NORMAL = 1;//普通鉴定
    public static final int EQUIPMENT_APPRAISA_DELICATE = 2;//精致鉴定
    public static final int EQUIPMENT_APPRAISA_PINK = 3;//粉
    public static final int EQUIPMENT_APPRAISA_YELLOW = 4;//黄
    public static final int EQUIPMENT_APPRAISA_GREEN = 5;//绿
    public static final int EQUIPMENT_APPRAISA_REMAKE = 6;//改造
    public static final int EQUIPMENT_APPRAISA_REMAKE_FIVE = 7;//改造5   //只有武器
    public static final int EQUIPMENT_APPRAISA_RESONANCE = 8;//共鸣
    public static final int EQUIPMENT_SYNTHESIS_JEWELRY = 9;//首饰合成
    public static final int EQUIPMENT_LUCK_DRAW = 10;//获得装备抽奖


    /**
     * 强化属性
     *
     * @param key          属性对应的英文
     * @param currentValue 当前值
     * @param eq_attrib    装备等级
     * @param eqType       装备类型  武器1,头盔2,鞋子10,衣服3
     * @return
     */
    public static int[] appendAttrib(String key, int currentValue, int eq_attrib, int eqType) {
        return appendAttrib(key, currentValue, eq_attrib, 0, eqType);
    }


    /**
     * 爆的比例 失败时调用
     *
     * @param currentProportion 当前属性强化的率池子
     * @param a                 失败返回的池加多少值
     * @param maxValue
     * @param newValue
     * @param step
     * @return
     */
    private static int[] proportion(int currentProportion, int a, int maxValue, int newValue, int step) {
        //0.44   442222
        int[] new_pro = new int[2];
        if (currentProportion + a >= 100000000) {
            //爆
            if (newValue + step < maxValue) {
                new_pro[0] = newValue + step;
                new_pro[1] = 0;
                return new_pro;
            }
        }

        new_pro[0] = newValue;
        new_pro[1] = currentProportion + a;
        return new_pro;
    }


    /**
     * 概率改造   todo
     * 只有3条蓝色属性的装备才可以改造
     *
     * @param currentColor      当前改造等级
     * @param currentProportion 当前进度
     * @param stoneCount        石头的个数 石头越多概率
     *                          v_a[0] = 值;
     *                          v_a[1] = currentProportion 当前总比例
     * @return 返回强化值
     */
    public static int[] remakeAttrib(int currentColor, int currentProportion, int stoneCount) {

        /** 0.1   100000000   10000
         * 1            48%到改2加  48000000
         * 2  302      24%
         * 3  453      12%
         * 4  604      6%
         * 5  755      3%
         * 6  906      1.5%
         * 7  1057     0.75
         * 8  1208     0.38%
         * 9  1359     0.19%    19 10000
         */
        //改造值   当前比例
        int[] v_a = new int[2];
        if (currentProportion >= 100000000) {
            currentColor = currentColor + 1;
        }
        if (currentColor >= 12) {
            currentColor = 12;
            v_a[0] = currentColor;
            v_a[1] = 0;
            return v_a;
        }

        Random random = new Random();
        int raInt = random.nextInt(100000000);
        int suc = (int) (96000000 / Math.pow(2, currentColor));
        if (raInt < suc) {// + (stoneCount >= 3 ? 0.02 : 0) * suc
            currentColor = currentColor + 1;
            currentProportion = 0;
        } else {
            currentProportion = currentProportion + suc;
            if (currentProportion >= 100000000) {
                currentColor = currentColor + 1;
                currentProportion = 0;
            }
        }

        v_a[0] = currentColor;
        v_a[1] = currentProportion;

        return v_a;

    }


    /**
     * 概率强化 强化蓝 粉  黄 属性   todo
     *
     * @param currentProportion 当前比例
     *                          v_a[0] = 值;
     *                          v_a[1] = +的比例;
     *                          v_a[2] = currentProportion 当前总比例
     * @param eqType            装备类型  武器1,头盔2,鞋子10,衣服3
     * @return
     */
    public static int[] appendAttrib(String key, int currentValue, int eq_attrib, int currentProportion, int eqType) {
        String chineseName = getEquipmentKeyByName(key, false);
        int maxValue = getMaxValueByChineseName(chineseName, eq_attrib, eqType == 3, false);
        int[] v_a = new int[3];
        if (currentValue >= maxValue) {
            v_a[0] = maxValue;
            v_a[1] = 0;
            v_a[2] = 0;
            return v_a;
        }
        int step = 1;//步长
        if (maxValue <= 30) {
            step = 1;
        } else if (maxValue <= 50) {
            step = 2;
        } else if (maxValue <= 100) {
            step = 5;
        } else if (maxValue <= 500) {
            step = 50;
        } else if (maxValue <= 1000) {
            step = 100;
        } else if (maxValue <= 2000) {
            step = 200;
        } else if (maxValue <= 4000) {
            step = 400;
        } else {
            step = 500;
        }
        int[] as = {11200000, 8200000, 5300000, 1900000, 142222};
        //新值   和   失败对应的百分比如0.44   442222
        Random random = new Random();
        //距离满属性一步之遥
        if (maxValue - currentValue <= step) {//%2从最后阶段上成功
            int v = random.nextInt(100) == 1 || random.nextInt(100) == 99 ? maxValue : currentValue;
            v_a[0] = v;
            v_a[1] = as[4];
            int[] new_value = proportion(currentProportion, v_a[1], maxValue, v_a[0], step);
            v_a[0] = new_value[0];
            v_a[2] = new_value[1];
            return v_a;
        } else if (maxValue - currentValue <= 2 * step && maxValue - currentValue > step) {//倒数第二阶段10%概率到最后一阶段
            int v = random.nextInt(100) < 10 ? maxValue - step : currentValue;
            v_a[0] = v;
            v_a[1] = as[3];
            int[] new_value = proportion(currentProportion, v_a[1], maxValue, v_a[0], step);
            v_a[0] = new_value[0];
            v_a[2] = new_value[1];
            return v_a;
        } else if (maxValue - currentValue <= 3 * step) {//倒数低3阶段到倒数第二阶段30%
            int v = random.nextInt(100) < 30 ? maxValue - 2 * step : currentValue;
            v_a[0] = v;
            v_a[1] = as[2];
            int[] new_value = proportion(currentProportion, v_a[1], maxValue, v_a[0], step);
            v_a[0] = new_value[0];
            v_a[2] = new_value[1];
            return v_a;
        } else {
            List<Integer> vlist = new ArrayList<>();
            int count = (maxValue + step - currentValue) / step;
            for (int m = 0; m < count; m++) {
                int value = currentValue + m * step;
                if (value >= maxValue) {
                    value = maxValue;
                }
                vlist.add(value);
                if (value == maxValue) {
                    break;
                }
            }
            int length = vlist.size() - 1;
            List<Integer> separates = new ArrayList<Integer>();
            List<Integer> percents = new ArrayList<Integer>();
            if (length == 2) {
                separates.add(1);
                percents.add(97);
                percents.add(3);
                v_a[1] = as[4];
            } else if (length == 3) {
                separates.add(1);
                separates.add(2);
                percents.add(78);
                percents.add(20);
                percents.add(2);
                v_a[1] = as[3];
            } else if (length == 4) {
                separates.add(2);
                separates.add(3);
                percents.add(78);
                percents.add(20);
                percents.add(2);
                v_a[1] = as[2];
            } else {
                separates.add(length / 2);
                separates.add(length - 3);
                separates.add(length - 1);
                percents.add(63);
                percents.add(30);
                percents.add(5);
                percents.add(2);
                v_a[1] = as[0];
            }
            int number = RateRandomNumber.produceRateRandomNumber(0, length, separates, percents);
            v_a[0] = vlist.get(number);
            int[] new_value = proportion(currentProportion, v_a[1], maxValue, v_a[0], step);
            v_a[0] = new_value[0];
            v_a[2] = new_value[1];
            return v_a;

        }


    }


    /**
     * 拆分装备
     * 把 蓝 粉 黄装备属性拿进来
     *
     * @param attribs
     * @return
     */
    public static String[] removeAttrib(String[] attribs) {
        return removeAttrib(attribs, false);
    }


    /**
     * 拆分装备
     * 把 蓝 粉 黄装备属性拿进来
     *
     * @param useChaos 使用了混沌玉
     * @return
     */
    public static String[] removeAttrib(String[] attribs, boolean useChaos) {
        String[] strings = new String[2];
        int length = attribs.length;
        if (length == 0) {
            return null;
        }
        Random random = new Random();
        if (!useChaos) {
            if (random.nextInt(10) <= 3) {
                return null;
            }
        }
        int r = random.nextInt(length);
        String name = getEquipmentKeyByName(attribs[r], false);
        if (name.contentEquals("伤害_最低伤害")) {
            name = "伤害";
        }
        strings[0] = String.valueOf(r);
        strings[1] = name;
        return strings;
    }


    /**
     * 鉴定装备
     *
     * @param eqType        装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib     装备等级
     * @param appraisalType 不同的操作类型
     */
    public static List<Hashtable<String, Integer>> appraisalEquipment(int eqType, int eq_attrib, int appraisalType) {
        return appraisalEquipment(eqType, eq_attrib, appraisalType, null, 0, 0);
    }


    /**
     * 首饰合成并且拿到属性值
     *
     * @param eqType
     * @param dst_eq_attrib 需要合成的首饰等级
     * @param hashtable     当前首饰有的蓝色属性  如果没有null 或者空map
     */
    public static List<Hashtable<String, Integer>> appraisalALLEquipment(int eqType, int dst_eq_attrib, Hashtable<String, Integer> hashtable) {
        List<Hashtable<String, Integer>> hashtableList = new ArrayList<>();
        if (null == hashtable) {
            hashtable = new Hashtable<>();
        }
        if (appraisalEquipment(eqType)) {
            hashtableList = appraisalEquipment(eqType, dst_eq_attrib, hashtable);

            //原有属性计算升值  按照比例重新赋值
            if (!hashtable.isEmpty() && dst_eq_attrib >= 90) {
                Set<String> keys = hashtable.keySet();
                for (String key : keys) {
                    String chineseName = getEquipmentKeyByName(key, false);
                    int current_max = getMaxValueByChineseName(chineseName, dst_eq_attrib - 10, false, false);
                    int dst_max = getMaxValueByChineseName(chineseName, dst_eq_attrib, false, false);
                    int dst_value = hashtable.get(key) * dst_max / current_max;
                    hashtable.put(key, dst_value);//下面已经设置了都不能重复
                }
            }


            hashtableList.get(0).putAll(hashtable);
        }
        return hashtableList;
    }


    /**
     * 合成首饰概率
     *
     * @param dst_eq_attrib
     * @return
     */
    public static boolean appraisalEquipment(int dst_eq_attrib) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(35, 0);
        hashtable.put(50, 1);
        hashtable.put(60, 2);
        hashtable.put(70, 3);
        hashtable.put(80, 4);
        hashtable.put(90, 5);
        hashtable.put(100, 6);
        hashtable.put(110, 7);
        hashtable.put(120, 8);
        if (hashtable.contains(dst_eq_attrib)) {
            if (dst_eq_attrib <= 70) {
                return true;
            }
            if (dst_eq_attrib >= 70 && dst_eq_attrib <= 100) {
                Random random = new Random();
                return random.nextInt(100) < 30 - 8 * (dst_eq_attrib / 10 - 7);
            }
            if (dst_eq_attrib >= 110) {
                return true;
            }
        }

        return false;

    }


    /**
     * 首饰合成
     *
     * @param eqType
     * @param eq_attrib
     * @return
     */
    public static List<Hashtable<String, Integer>> appraisalEquipment(int eqType, int eq_attrib, Hashtable<String, Integer> hashtable) {
        //现在改未所有都不能出现2条
        HashSet<String> only = new HashSet<>();
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        if (null != hashtable && !hashtable.isEmpty()) {
            only.addAll(hashtable.keySet());
        }
        return appraisalEquipment(eqType, eq_attrib, EQUIPMENT_SYNTHESIS_JEWELRY, only, 0, 0);

    }


    /**
     * 绿装备
     *
     * @param eqType    装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib 装备等级
     * @param polar     相性    金木水火土12345
     */

    public static List<Hashtable<String, Integer>> appraisalGreenEquipment(int eqType, int eq_attrib, int polar) {
        return appraisalEquipment(eqType, eq_attrib, EQUIPMENT_APPRAISA_GREEN, null, polar, 0);
    }

    /**
     * 通过改造等级获取改造属性和值
     *
     * @param eqType       装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib    装备等级
     * @param currentColor
     */
    public static List<Hashtable<String, Integer>> appraisalRemakeEquipment(int eqType, int eq_attrib, int currentColor) {
        List<Hashtable<String, Integer>> hashtableList = new ArrayList<>();
        if (currentColor < 5) {
            hashtableList.addAll(appraisalEquipment(eqType, eq_attrib, EQUIPMENT_APPRAISA_REMAKE, null, 0, currentColor));
        } else {
            List<Hashtable<String, Integer>> list = appraisalEquipment(eqType, eq_attrib, EQUIPMENT_APPRAISA_REMAKE, null, 0, currentColor);
            if (!list.isEmpty()) {
                Hashtable<String, Integer> hashtable = list.get(0);
                if (null != hashtable) {
                    List<Hashtable<String, Integer>> listf = appraisalEquipment(eqType, eq_attrib, EQUIPMENT_APPRAISA_REMAKE_FIVE, null, 0, currentColor);
                    if (!list.isEmpty()) {
                        Hashtable<String, Integer> hashtablef = listf.get(0);
                        if (hashtablef.get("groupNo").equals(hashtable.get("groupNo"))) {
                            hashtable.putAll(hashtablef);
                            hashtableList.add(hashtable);
                        }

                    }
                }
            }

        }
        return hashtableList;
    }


    /**
     * 拿改造属性和共鸣属性性的值
     * 改造装备的时候可以用
     *
     * @param eqType       装备类型  武器1,头盔2,鞋子10,衣服3
     * @param resonance    共鸣属性字段
     * @param eq_attrib    装备等级
     * @param currentColor 要获得的改造等级
     * @return
     */
    public static List<Hashtable<String, Integer>> appraisalRemakeEquipment(String resonance, int eqType, int eq_attrib, int currentColor) {
        List<Hashtable<String, Integer>> hashtableList = new ArrayList<>();
        if (null != resonance && resonance.length() != 0) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 27);
            key_vlaue_tab.put(resonance, getMaxValueByChineseName(resonance, eq_attrib, eqType == 3, true) * 2 / 12 * currentColor);
            hashtableList.add(key_vlaue_tab);
        }
        List<Hashtable<String, Integer>> hashtableList2 = appraisalRemakeEquipment(eqType, eq_attrib, currentColor);
        hashtableList.addAll(hashtableList2);
        return hashtableList;
    }


    /**
     * 共鸣
     *
     * @param eq_attrib    装备等级
     * @param currentColor 当前改造属性
     * @param stone        石头个数
     * @param addOrChange  true add 添加共鸣属性 ; false change 修改共鸣属性
     * @return
     */
    public static List<Hashtable<String, Integer>> resonanceEquipMent(int eq_attrib, int currentColor, int stone, boolean addOrChange) {
        List<Hashtable<String, Integer>> hashtableList = new ArrayList<>();
        Random random = new Random();
        if (addOrChange || stone >= 3 || random.nextBoolean()) {
            hashtableList.addAll(appraisalEquipment(0, eq_attrib, EQUIPMENT_APPRAISA_RESONANCE, null, 0, currentColor));
        }
        return hashtableList;

    }


    /**
     * 绿装备
     *
     * @param eqType        装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib     装备等级
     * @param appraisalType 不同的操作类型
     * @param polar         相性
     */
    public static List<Hashtable<String, Integer>> appraisalEquipment(int eqType, int eq_attrib, int appraisalType, int polar) {
        return appraisalEquipment(eqType, eq_attrib, appraisalType, null, polar, 0);
    }


    /**
     * 粉
     *
     * @param eqType           装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib        装备等级
     * @param appraisalType    不同的操作类型
     * @param repeatAttributes 重复的属性
     * @return
     */
    public static List<Hashtable<String, Integer>> appraisalEquipment(int eqType, int eq_attrib, int appraisalType, HashSet<String> repeatAttributes) {
        if (EQUIPMENT_APPRAISA_PINK == appraisalType) {
            return appraisalEquipment(eqType, eq_attrib, appraisalType, repeatAttributes, 0, 0);
        }
        return new ArrayList<>();
    }


    /**
     * 黄 黄色色有概率
     *
     * @param eqType           装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib        装备等级
     * @param appraisalType    不同的操作类型
     * @param repeatAttributes 重复的属性
     * @param stone            石头的个数 石头越多概率
     * @return
     */
    public static List<Hashtable<String, Integer>> appraisalYellowEquipment(int eqType, int eq_attrib, int appraisalType, HashSet<String> repeatAttributes, int stone) {
        if (EQUIPMENT_APPRAISA_YELLOW == appraisalType) {
            Random random = new Random();
            int r = random.nextInt(100);
            if (r < 90 || stone >= 6) {
                return appraisalEquipment(eqType, eq_attrib, appraisalType, repeatAttributes, 0, 0);
            }
        }
        return new ArrayList<>();
    }


    /**
     * 装备操作集合
     * <p>
     * 粉 黄   80%的概率
     *
     * @param eqType           装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib        装备等级
     * @param appraisalType    不同的操作类型
     * @param repeatAttributes 装备的蓝 粉 黄 属里面出现>=2的属性放进来
     *                         外部计算方法：
     *                         List a = new ArrayList();
     *                         a.add("key1");
     *                         a.add("key1");
     *                         a.add("key2");
     *                         a.add("key3");
     *                         a.add("key3");
     *                         a.add("key3");
     *                         Set b = new HashSet();
     *                         b.addAll(a);
     *                         Collection rs = org.apache.commons.collections.CollectionUtils.disjunction(a, b);
     *                         System.out.println(rs);[key3, key3, key1]
     */
    private static List<Hashtable<String, Integer>> appraisalEquipment(int eqType, int eq_attrib, int appraisalType, HashSet<String> repeatAttributes, int polar, int color) {

        List<Hashtable<String, Integer>> appraisalList = new ArrayList<>();
        if (EQUIPMENT_LUCK_DRAW == appraisalType) {
            Hashtable<Integer, String[]> hashtable = baseBlueSuit(eqType, eq_attrib);
            List<String> blueList = randomAttribute(hashtable.get(eqType), new Random().nextInt(5) < 4 ? 1 : 2);//随机2个属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 2);
            for (String key : blueList) {
                key_vlaue_tab.put(getEquipmentKeyByName(key), getMaxValueByChineseName(key, eq_attrib, eqType == 3, false));
            }
            appraisalList.add(key_vlaue_tab);
        } else if (EQUIPMENT_APPRAISA_NORMAL == appraisalType) {
            Hashtable<Integer, String[]> hashtable = baseBlueSuit(eqType, eq_attrib);
            List<String> blueList = randomAttribute(hashtable.get(eqType), new Random().nextInt(3) + 1);//随机3个属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 2);
            for (String key : blueList) {
                key_vlaue_tab.put(getEquipmentKeyByName(key), getValueByChineseName(key, eq_attrib, eqType == 3, false));
            }
            appraisalList.add(key_vlaue_tab);
        } else if (EQUIPMENT_APPRAISA_DELICATE == appraisalType) {//精致鉴定
            Random random = new Random();
            //蓝色
            Hashtable<Integer, String[]> hashtable = baseBlueSuit(eqType, eq_attrib);
            List<String> blueList = randomAttribute(hashtable.get(eqType), random.nextInt(2) + 2);//随机3个属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            for (String key : blueList) {
                key_vlaue_tab.put("groupNo", 2);
                key_vlaue_tab.put(getEquipmentKeyByName(key), getValueByChineseName(key, eq_attrib, eqType == 3, false));
            }
            appraisalList.add(key_vlaue_tab);
            //粉色 黄色
            Hashtable<Integer, String[]> pink_hashtable = pinkSuit(eqType, eq_attrib);
            List<String> pinkList = randomAttribute(pink_hashtable.get(eqType), 2);
            if (pinkList.size() == 2) {
                Hashtable<String, Integer> key_vlaue_pTab = new Hashtable<>();
                key_vlaue_pTab.put("groupNo", 3);//粉
                key_vlaue_pTab.put(getEquipmentKeyByName(pinkList.get(0)), getValueByChineseName(pinkList.get(0), eq_attrib, eqType == 3, false));
                appraisalList.add(key_vlaue_pTab);
                if (random.nextInt(10) <= 7) {
                    Hashtable<String, Integer> key_vlaue_yTab = new Hashtable<>();
                    key_vlaue_yTab.put("groupNo", 4);//黄
                    key_vlaue_yTab.put(getEquipmentKeyByName(pinkList.get(1)), getValueByChineseName(pinkList.get(1), eq_attrib, eqType == 3, false));
                    appraisalList.add(key_vlaue_yTab);
                }
            }
        } else if (EQUIPMENT_APPRAISA_PINK == appraisalType || EQUIPMENT_APPRAISA_YELLOW == appraisalType) {//粉
            Hashtable<Integer, String[]> pink_hashtable = pinkSuit(eqType, eq_attrib);
            String[] attributes = pink_hashtable.get(eqType);
            List<String> resultList = new ArrayList<>(attributes.length);
            Collections.addAll(resultList, attributes);
            if (null != repeatAttributes && !repeatAttributes.isEmpty()) {
                Iterator<String> iterator = repeatAttributes.iterator();
                while (iterator.hasNext()) {
                    String repKey = iterator.next();
                    String name = getEquipmentKeyByName(repKey, false);
                    if (resultList.contains(name)) {
                        resultList.remove(name);//移除2个属性 不能出现3个一样的属性
                    }
                }
            }
            String[] arrayLeave = resultList.toArray(new String[resultList.size()]);
            List<String> pinkList = randomAttribute(arrayLeave, 1);
            Hashtable<String, Integer> key_vlaue_pTab = new Hashtable<>();
            key_vlaue_pTab.put("groupNo", EQUIPMENT_APPRAISA_PINK == appraisalType ? 3 : 4);//粉3 黄4
            key_vlaue_pTab.put(getEquipmentKeyByName(pinkList.get(0)), getValueByChineseName(pinkList.get(0), eq_attrib, eqType == 3, false));
            appraisalList.add(key_vlaue_pTab);
        } else if (EQUIPMENT_SYNTHESIS_JEWELRY == appraisalType) {
            Hashtable<Integer, String[]> jewelry_hashtable = baseBlueSuit(eqType, eq_attrib);
            String[] attributes = jewelry_hashtable.get(eqType);
            List<String> resultList = new ArrayList<>(attributes.length);
            Collections.addAll(resultList, attributes);
            if (null != repeatAttributes && !repeatAttributes.isEmpty()) {
                Iterator<String> iterator = repeatAttributes.iterator();
                while (iterator.hasNext()) {
                    String repKey = iterator.next();
                    String name = getEquipmentKeyByName(repKey, false);
                    if (resultList.contains(name)) {
                        resultList.remove(name);//移除2个属性 不能出现3个一样的属性
                    }
                }
            }
            String[] arrayLeave = resultList.toArray(new String[resultList.size()]);
            List<String> pinkList = randomAttribute(arrayLeave, 1);
            Hashtable<String, Integer> key_vlaue_pTab = new Hashtable<>();
            key_vlaue_pTab.put("groupNo", 2);//首饰
            key_vlaue_pTab.put(getEquipmentKeyByName(pinkList.get(0)), getValueByChineseName(pinkList.get(0), eq_attrib, eqType == 3, false));
            appraisalList.add(key_vlaue_pTab);

        } else if (EQUIPMENT_APPRAISA_GREEN == appraisalType) {//绿
            //绿色的第一条
            Hashtable<Integer, String[]> green_hashtable = randomGreenSuit(polar);
            String[] attributes = green_hashtable.get(eqType);
            List<String> greenAttribute = randomAttribute(attributes, 1);//随机1个属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 12);
            key_vlaue_tab.put(getEquipmentKeyByName(greenAttribute.get(0)), getValueByChineseName(greenAttribute.get(0), eq_attrib, eqType == 3, true));
            appraisalList.add(key_vlaue_tab);
            //绿色的第二条
            String basekey = getEquipmentKeyByName(baseGreenSuit(polar));
            Hashtable<String, Integer> key_vlaue_baseTab = new Hashtable<>();
            key_vlaue_baseTab.put("groupNo", 8);
            key_vlaue_baseTab.put(basekey, getValueByChineseName(baseGreenSuit(polar), eq_attrib, eqType == 3, true));
            appraisalList.add(key_vlaue_baseTab);
        } else if (EQUIPMENT_APPRAISA_REMAKE == appraisalType) {//改造1
            String keyName1 = "防御";
            String keyName2 = "防御";
            if (eqType == 1) {
                keyName1 = "物伤";
                keyName2 = "法伤";
            }
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(getEquipmentKeyByName(keyName1), getMaxValueByChineseName(keyName1, eq_attrib, eqType == 3, true) * 2 / 12 * color);
            key_vlaue_tab.put(getEquipmentKeyByName(keyName2), getMaxValueByChineseName(keyName2, eq_attrib, eqType == 3, true) * 2 / 12 * color);
            appraisalList.add(key_vlaue_tab);
        } else if (EQUIPMENT_APPRAISA_REMAKE_FIVE == appraisalType) {//武器用 改5多一条属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            if ((eqType == 2 || eqType == 10 || eqType == 3) && eq_attrib >= 100) {//如果是衣服 头 鞋子
                key_vlaue_tab.put(getEquipmentKeyByName("气血"), getMaxValueByChineseName("气血", eq_attrib, eqType == 3, true) * 2 / 12 * color);
            } else if (eqType == 1) {
                key_vlaue_tab.put(getEquipmentKeyByName("所有属性"), getMaxValueByChineseName("所有属性", eq_attrib, eqType == 3, true) * 2 / 12 * color);
            }
            appraisalList.add(key_vlaue_tab);
        } else if (EQUIPMENT_APPRAISA_RESONANCE == appraisalType) {//共鸣
            List<String> greenAttribute = randomAttribute(resonanceBlueSuit(), 1);//随机1个属性
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 27);
            key_vlaue_tab.put(getEquipmentKeyByName(greenAttribute.get(0)), getMaxValueByChineseName(greenAttribute.get(0), eq_attrib, eqType == 3, true) * 2 / 12 * color);
            appraisalList.add(key_vlaue_tab);
        }

        return appraisalList;

    }

    /**
     * 随机一个属性
     *
     * @param pinkAttributes
     */
    private static List<String> randomAttribute(String[] pinkAttributes, int count) {
        int length = pinkAttributes.length;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int i;
        while (list.size() < count) {
            i = random.nextInt(length);
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        List<String> attributes = new ArrayList<>();
        for (Integer index : list) {
            attributes.add(pinkAttributes[index]);
        }
        return attributes;
    }


    /**
     * 蓝色基础属性
     * 武器1,头盔2,鞋子10,衣服3,项链4,玉佩5,手镯6
     *
     * @param eqType
     * @param eq_attrib
     */
    public static Hashtable<Integer, String[]> baseBlueSuit(int eqType, int eq_attrib) {

        String[] pinkAttribute_1 = {
                "力量", "灵力", "敏捷", "体质"
                , "伤害_最低伤害", "所有技能上升"
                , "所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"
                , "物理必杀率", "物理连击率"
                , "反击率"
                , "忽视所有抗异常"
                , "忽视所有抗性"
        };


        String[] pinkAttribute_2 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有属性"
                , "物理连击次数"
                , "气血", "法力", "防御"
                , "反震度"
                , "反击次数"
        };

        String[] pinkAttribute_10 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有属性"
                , "物理连击次数"
//                , "防御", "速度"
                , "防御"
                , "反震度"
                , "反击次数"
        };


        String[] pinkAttribute_3 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有属性"
                , "气血", "法力", "防御"
                , "反震率", "反震度"
                , "反击次数", "反击率"
                , "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "金抗性", "木抗性", "水抗性", "火抗性", "土抗性"
                , "所有抗异常", "所有抗性"
        };


        // 项链4,玉佩5,手镯6
        String[] pinkAttribute_4 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有相性"
//                , "所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"
                , "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "所有抗异常", "所有技能上升"

        };

        String[] pinkAttribute_5 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有相性"
//                , "所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"
                , "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "所有抗异常", "所有技能上升"
        };

        String[] pinkAttribute_6 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有相性", "所有技能上升"
                , "忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"
                , "忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"
                , "忽视所有抗异常"

        };


        Hashtable<Integer, String[]> hashtable = new Hashtable<>();
        hashtable.put(1, pinkAttribute_1);
        hashtable.put(2, pinkAttribute_2);
        hashtable.put(10, pinkAttribute_10);
        hashtable.put(3, pinkAttribute_3);
        hashtable.put(4, pinkAttribute_4);
        hashtable.put(5, pinkAttribute_5);
        hashtable.put(6, pinkAttribute_6);
        return hashtable;

    }


    /**
     * 改造的属性
     *
     * @param eqType    武器1  非武器
     * @param color     改造等级
     * @param eq_attrib
     */
    public void remakeBlueSuit(int eqType, int color, int eq_attrib) {
        if (eqType == 1) {
            if (color == 1) {
                getEquipmentKeyByName("物伤");
            } else if (color == 5) {
                getEquipmentKeyByName("所有属性");
            }
        } else {
            if (color == 1) {
                getEquipmentKeyByName("防御");
            } else if (color == 5 && eq_attrib >= 100) {//如果是衣服
                getEquipmentKeyByName("气血");
            }
        }


    }


    /**
     * 改造的共鸣属性
     */
    public static String[] resonanceBlueSuit() {
        //才可以共鸣
        // if (color >= 4) {
        String[] resonanceAttribute = {"物理必杀率"
                //,"法术必杀率"
                , "物伤", "法伤" //伤害是啥  todo  2个都有？
                , "法伤", "气血", "防御", "速度", "物伤"
                , "力量", "灵力", "敏捷", "体质"
                , "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "金抗性", "木抗性", "水抗性", "火抗性", "土抗性"
                , "所有技能上升"
                , "物理连击率", "反击率", "物理必杀率"
                //,"准确"
                , "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                , "反击次数", "反震度", "反震率"
                , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"
                , "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"};
        //改造的伤害计算不一样。
        // }


        return resonanceAttribute;
    }


    /**
     * 粉色属性
     *
     * @param eqType    武器1,头盔2,鞋子10,衣服3,项链4,手镯6,玉佩5
     * @param eq_attrib 等级
     */
    public static Hashtable<Integer, String[]> pinkSuit(int eqType, int eq_attrib) {

        String[] pinkAttribute_1 = {
                "力量", "灵力", "敏捷", "体质"
                , "伤害_最低伤害", "所有技能上升"
                , "所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"
                , "物理必杀率", "物理连击率"
                , "反击率"
                , "忽视所有抗异常"
                , "忽视所有抗性"
        };


        String[] pinkAttribute_2 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有属性"
                , "物理连击次数"
                , "气血", "法力", "防御"
                , "反震度"
                , "反击次数"
        };

        String[] pinkAttribute_10 = {
                "力量", "灵力", "敏捷", "体质"
//                "力量", "灵力", "体质"
                , "所有属性"
                , "物理连击次数"
//                , "防御", "速度"
                , "防御"
                , "反震度"
                , "反击次数"
        };


        String[] pinkAttribute_3 = {
                "力量", "灵力", "敏捷", "体质"
                , "所有属性"
                , "气血", "法力", "防御"
                , "反震率", "反震度"
                , "反击次数", "反击率"
                , "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "金抗性", "木抗性", "水抗性", "火抗性", "土抗性"
                , "所有抗异常", "所有抗性"
        };

        Hashtable<Integer, String[]> hashtable = new Hashtable<>();
        hashtable.put(1, pinkAttribute_1);
        hashtable.put(2, pinkAttribute_2);
        hashtable.put(10, pinkAttribute_10);
        hashtable.put(3, pinkAttribute_3);


        return hashtable;
    }


    /**
     * 绿色的时候基础属性
     * 绿色套装属性
     * 绿色第二条  只有相性套装才激活
     *
     * @param resist_polar 套装相性  1-5
     */
    public static String baseGreenSuit(int resist_polar) {
        //不要移动位置
        String[] baseAttribute = {"法伤", "气血", "防御", "速度", "物伤"};
        return baseAttribute[resist_polar - 1];
    }


    /**
     * 绿色的时候随机属性
     * 绿色套装属性s
     * 绿色第一条  随机属性
     * 武器1,头盔2,鞋子10,衣服3,项链4,手镯6,玉佩5
     */
    public static Hashtable<Integer, String[]> randomGreenSuit(int resist_polar) {
        String[] strList = {"强金法伤害", "强木法伤害", "强水法伤害", "强火法伤害", "强土法伤害"};
        String[] strList2 = {"强力遗忘", "强力中毒", "强力冰冻", "强力昏睡", "强力混乱"};
        String[] strList3 = {"忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"};
        String[] strList4 = {"忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"};


        //武器
        String[] randomAttribute = {
                //"抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                , strList[resist_polar - 1]
                , "强物理伤害"
                //, "几率躲避攻击"
                // , "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"
                , strList2[resist_polar - 1]
                , strList4[resist_polar - 1]
                //, "破防", "破防率"
                , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"
                //, "忽视躲避攻击"
                , "忽视所有抗异常", "忽视所有抗性"
                //todo  金    木         水          火         土
                , strList3[resist_polar - 1]
        };

        //衣服
        String[] randomAttributeNoEq = {
                "抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                //, "破防" //, "破防率"  todo 战斗的时候破防率每个玩家一样30%
                , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"
        };


        //头盔
        String[] randomAttributeNoH = {
                //"抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                // , "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                //, "强金法伤害", "强木法伤害", "强水法伤害", "强火法伤害", "强土法伤害"
                //, "强物理伤害"
                //, "几率躲避攻击"
                "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"
                //, "强力遗忘", "强力中毒", "强力冰冻", "强力昏睡", "强力混乱"
                //, "忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"
                //, "破防"//, "破防率"
                // , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"
                //, "忽视躲避攻击"
                // , "忽视所有抗异常", "忽视所有抗性"
                // , "忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"
        };


        //鞋子
        String[] randomAttributeNoEq2 = {
                //"抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                // , "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                //, "强金法伤害", "强木法伤害", "强水法伤害", "强火法伤害", "强土法伤害"
                //, "强物理伤害"
                "几率躲避攻击"
                , "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"
                //, "强力遗忘", "强力中毒", "强力冰冻", "强力昏睡", "强力混乱"
                //, "忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"
                //, "破防"// "破防率"
                //, "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"
                //, "忽视躲避攻击"
                //, "忽视所有抗异常", "忽视所有抗性"
                // , "忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"
        };


        Hashtable<Integer, String[]> hashtable = new Hashtable<>();
        hashtable.put(1, randomAttribute);
        hashtable.put(2, randomAttributeNoH);
        hashtable.put(10, randomAttributeNoEq2);
        hashtable.put(3, randomAttributeNoEq);


        return hashtable;
    }


    /**
     * 所有属性
     * 金 木  水  火  土
     * wood,  water,  fire,  earth , metal
     * 通过中文名字获得对应的传参数值
     */
    public static String getEquipmentKeyByName(String chineseName) {
        return getEquipmentKeyByName(chineseName, true);
    }

    /**
     * 所有属性
     * 金 木  水  火  土
     * wood,  water,  fire,  earth , metal
     * 通过中文名字获得对应的传参数值
     * <p>
     * isName 是否是通过中文拿英文   false 通过英文拿中文
     */
    public static String getEquipmentKeyByName(String chineseName, boolean isName) {

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("法伤", "mana");
        hashtable.put("气血", "def");
        hashtable.put("防御", "wiz");
        hashtable.put("速度", "parry");
        hashtable.put("物伤", "accurate");
        hashtable.put("法力", "dex");
        /**
         * 蓝色  绿色  改造值计算也不一样
         */

        /**
         * 蓝色  速度 气血 法力 防御
         */

        /**
         * 绿色 物伤	气血	法力	速度	法伤	防御
         */


        hashtable.put("抗中毒", "resist_frozen");//5% ?% /20%  最大最小    2
        hashtable.put("抗冰冻", "resist_sleep");//5% ?% /20%    2
        hashtable.put("抗昏睡", "resist_forgotten");//5% ?% /20%  2
        hashtable.put("抗遗忘", "resist_confusion");//5% ?% /20%  2
        hashtable.put("抗混乱", "longevity");//5% ?% /20%   2


        hashtable.put("金抗性", "resist_wood");//5% ?% /15%  0
        hashtable.put("木抗性", "resist_water");//5% ?% /15%  0
        hashtable.put("水抗性", "resist_fire");//5% ?% /15% 0
        hashtable.put("火抗性", "resist_earth");//5% ?% /15% 0
        hashtable.put("土抗性", "exp_to_next_level");//5% ?% /15% 0


        hashtable.put("强力克金", "super_excluse_wood");//5% ?% /20% 0
        hashtable.put("强力克木", "super_excluse_water");//5% ?% /20% 0
        hashtable.put("强力克水", "super_excluse_fire");//5% ?% /20% 0
        hashtable.put("强力克火", "super_excluse_earth");//5% ?% /20% 0
        hashtable.put("强力克土", "B_skill_low_cost");//5% ?% /20% 0

        hashtable.put("强金法伤害", "enhanced_wood");//3% ?%/10% 0
        hashtable.put("强木法伤害", "enhanced_water");//3% ?%/10% 0
        hashtable.put("强水法伤害", "enhanced_fire");//3% ?%/10% 0
        hashtable.put("强火法伤害", "enhanced_earth");//3% ?%/10% 0
        hashtable.put("强土法伤害", "mag_dodge");//3% ?%/10% 0

        hashtable.put("强物理伤害", "ignore_mag_dodge");//3% ?%/10% 0
        hashtable.put("几率躲避攻击", "jinguang_zhaxian_counter_att_rate");//10% ?%/30%  0

        hashtable.put("法攻技能消耗降低", "C_skill_low_cost");//3% ?%/10%  0
        hashtable.put("障碍技能消耗降低", "D_skill_low_cost");//3% ?%/10%  0
        hashtable.put("辅助技能消耗降低", "super_poison");//3% ?%/10%  0

        hashtable.put("忽视目标抗金", "ignore_resist_wood");//10% ?%/30% 0
        hashtable.put("忽视目标抗木", "ignore_resist_water");//10% ?%/30% 0
        hashtable.put("忽视目标抗水", "ignore_resist_fire");//10% ?%/30% 0
        hashtable.put("忽视目标抗火", "ignore_resist_earth");//10% ?%/30% 0
        hashtable.put("忽视目标抗土", "ignore_resist_forgotten");//10% ?%/30% 0

        hashtable.put("伤害_最低伤害", "skill_low_cost");//公式 maxSkill_Low_Cost()
        hashtable.put("金相性", "wood");//<=5
        hashtable.put("木相性", "water");//<=5
        hashtable.put("水相性", "fire");//<=5
        hashtable.put("火相性", "earth");//<=5
        hashtable.put("土相性", "resist_metal");//<=5

        hashtable.put("灵力", "mag_power");//公式 maxSpeed()
        hashtable.put("力量", "phy_power");//公式 maxSpeed()
        hashtable.put("敏捷", "speed");//公式 maxSpeed()
        hashtable.put("体质", "life");//公式 maxSpeed()

        hashtable.put("忽视所有抗性", "ignore_all_resist_except");//3% ?%/10%  0
        hashtable.put("所有技能上升", "mstunt_rate");//?/10
        hashtable.put("忽视所有抗异常", "release_forgotten");//5% ?% /20%  2
        hashtable.put("物理必杀率", "damage_sel");//10% ?%/30%
        hashtable.put("物理连击率", "stunt_rate");//10% ?%/30%
        hashtable.put("反击率", "double_hit_rate");//10% ?%/30%  0
        hashtable.put("物理连击次数", "stunt");//2 <12

        hashtable.put("反击次数", "life_recover");//<10  0
        hashtable.put("反震率", "portrait");//10% ?%/30%  0
        hashtable.put("反震度", "family");//10% ?%/30%  0

        hashtable.put("所有抗性", "all_resist_except");//3% ?%/10%  0
        hashtable.put("所有相性", "all_resist_polar");//<=5
        hashtable.put("所有属性", "all_polar");//等级/5
        hashtable.put("所有抗异常", "all_skill");//5% ?% /15% 0


        hashtable.put("几率解除混乱状态", "tao_ex");//5% ?% /15%  0
        hashtable.put("几率解除昏睡状态", "release_confusion");//5% ?% /15% 0
        hashtable.put("几率解除冰冻状态", "release_sleep");//5% ?% /15%  0
        hashtable.put("几率解除中毒状态", "release_frozen");//5% ?% /15%  0
        hashtable.put("几率解除遗忘状态", "release_poison");//5% ?% /15%  0


        hashtable.put("忽视目标抗中毒", "ignore_resist_frozen");//10% ?%/30%  2
        hashtable.put("忽视目标抗冰冻", "ignore_resist_sleep");//10% ?%/30%   2
        hashtable.put("忽视目标抗昏睡", "ignore_resist_confusion");//10% ?%/30%  2
        hashtable.put("忽视目标抗混乱", "super_excluse_metal");//10% ?%/30%  2
        hashtable.put("忽视目标抗遗忘", "ignore_resist_poison");//10% ?%/30%  2

        hashtable.put("强力遗忘", "super_confusion");//10% ?%/30%  2
        hashtable.put("强力中毒", "super_sleep");//10% ?%/30%  2
        hashtable.put("强力冰冻", "enhanced_metal");//10% ?%/30% 2
        hashtable.put("强力昏睡", "super_forgotten");//10% ?%/30% 2
        hashtable.put("强力混乱", "super_frozen");//10% ?%/30% 2

        // hashtable.put("破防", "nil");//10% ?%/30% 2

        //isName 是否是通过中文拿英文
        if (isName) {
            if (!hashtable.containsKey(chineseName)) {
                return new StringBuffer(chineseName).append("中文 No Find").toString();
            }
            return hashtable.get(chineseName);
        } else {
            if (!hashtable.containsValue(chineseName)) {
                return new StringBuffer(chineseName).append("英文 No Find").toString();
            }
            String key = null;
            //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
            for (String getKey : hashtable.keySet()) {
                if (hashtable.get(getKey).equals(chineseName)) {
                    key = getKey;
                }
            }
            return key;

        }


    }


    private static boolean contains(String[] values, String name) {
        List<String> resultList = new ArrayList<>(values.length);
        Collections.addAll(resultList, values);
        return resultList.contains(name);
    }


    /**
     * 阶梯伤害
     *
     * @param skill
     * @return
     */
    public static int peekValue(int skill) {
        if (skill < 10) {
            return skill / 2;
        }
        if (skill < 50) {
            return (int) (skill / 2.4);
        }
        Random random = new Random();
        if (skill < 100) {
            int skillCount = skill / 10;
            int r = random.nextInt(skillCount);
            if (r < skillCount / 2) {
                r = skillCount / 2;
            }
            return r * 10 + random.nextInt(9);
        }

        if (skill <= 1000) {
            int skillCount = skill / 100;
            int r = random.nextInt(skillCount);
            if (r < skillCount / 2) {
                r = skillCount / 2;
            }
            return r * 100 + random.nextInt(9) * 10;
        }

        //skill>1000
        int skillCount = skill / 100;
        int r = random.nextInt(skillCount);
        if (r < skillCount / 2) {
            r = skillCount / 2;
        }
        return r * 100 + random.nextInt(9) * 10;

    }

    /**
     * 获得伤害的值
     *
     * @param name
     * @param eq_attrib 装备等级
     * @return
     */
    private static int getValueByChineseName(String name, int eq_attrib, boolean isClothes, boolean green) {

        if ("伤害_最低伤害".contentEquals(name)) {
            int skill = maxSkill_Low_Cost(eq_attrib);
            return peekValue(skill);
        }


        /**
         * 蓝色  速度 气血 法力 防御
         */

        /**
         * 绿色 物伤	气血	法力	速度	法伤	防御
         */
        if ("物伤#气血#法力#速度#法伤#防御".contains(name)) {
            int skill = getMaxValueGiven(name, eq_attrib, isClothes, green);
            return peekValue(skill);
        }


        if ("所有属性".contentEquals(name)) {
            return getProbabilityValue(1, eq_attrib / 5);
        }

        String[] valuel_t = {"力量", "灵力", "敏捷", "体质"};
        if (contains(valuel_t, name)) {
            if (maxSpeed(eq_attrib) <= 2) {
                return maxSpeed(eq_attrib);
            }
            return getProbabilityValue(maxSpeed(eq_attrib) / 2, maxSpeed(eq_attrib));
        }
        String[] value10_30 = {"几率躲避攻击"
                , "忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"
                , "物理必杀率", "物理连击率", "反击率"
                , "反震率", "反震度"
                , "忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"
                , "强力遗忘", "强力中毒", "强力冰冻", "强力昏睡", "强力混乱"  //, "破防"
        };
        if (contains(value10_30, name)) {
            return getProbabilityValue(10, 30);
        }


        String[] value5_20 = {"抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                , "忽视所有抗异常"};
        if (contains(value5_20, name)) {
            return getProbabilityValue(5, 20);
        }

        String[] value5_15 = {"金抗性", "木抗性", "水抗性", "火抗性", "土抗性", "所有抗异常"
                , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"};
        if (contains(value5_15, name)) {
            return getProbabilityValue(5, 15);
        }


        String[] value3_10 = {"强金法伤害", "强木法伤害", "强水法伤害", "强火法伤害", "强土法伤害"
                , "强物理伤害"
                , "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"
                , "忽视所有抗性"
                , "所有抗性", "反击次数"};
        if (contains(value3_10, name)) {
            return getProbabilityValue(3, 10);
        }


        String[] value1_5 = {"所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"};
        if (contains(value1_5, name)) {
            return getProbabilityValue(1, 5);
        }

        String[] value1_10 = {"所有技能上升"};
        if (contains(value1_10, name)) {
            return getProbabilityValue(2, 10);
        }


        String[] value1_12 = {
                "物理连击次数"};
        if (contains(value1_12, name)) {
            return getProbabilityValue(2, 12);
        }


        return 100;
    }


    /**
     * 特定获取
     * 蓝色  速度 气血 法力 防御
     * 绿色  物伤	 气血 速度 法伤 防御
     *
     * @param name
     * @param eq_attrib
     * @param clothes   是否是衣服 true是的  衣服的蓝色属性 "气血", "法力", "防御"和其他的不一样
     * @return
     */
    public static int getMaxValueGiven(String name, int eq_attrib, boolean clothes, boolean green) {

        String[] bv = {"速度", "气血", "法力", "防御"};
        String[] gv = {"物伤", "气血", "速度", "法伤", "防御"};
        int point = 0;
        if (green) {
            for (int i = 0; i < gv.length; i++) {
                if (gv[i].contentEquals(name)) {
                    point = i + 4;
                    break;
                }
            }
        } else {
            for (int i = 0; i < bv.length; i++) {
                if (bv[i].contentEquals(name)) {
                    point = i;
                    break;
                }
            }
        }
        if (eq_attrib < 20) {
            int[] bgv = {13, 45, 80, 15, 49, 211, 8, 28, 45};
            int[] bgv_yf = {0, 85, 140, 30, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 20 && eq_attrib < 30) {
            int[] bgv = {26, 110, 180, 35, 113, 478, 16, 63, 102};
            int[] bgv_yf = {0, 190, 320, 65, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 30 && eq_attrib < 40) {
            int[] bgv = {40, 190, 300, 55, 191, 806, 24, 107, 173};
            int[] bgv_yf = {0, 320, 500, 110, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }

        if (eq_attrib >= 40 && eq_attrib < 50) {
            int[] bgv = {50, 280, 460, 85, 191, 806, 24, 107, 173};
            int[] bgv_yf = {0, 480, 800, 170, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 50 && eq_attrib < 60) {
            int[] bgv = {65, 380, 600, 120, 389, 1642, 41, 218, 354};
            int[] bgv_yf = {0, 650, 1100, 240, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 60 && eq_attrib < 70) {
            int[] bgv = {80, 500, 800, 150, 509, 2149, 49, 286, 464};
            int[] bgv_yf = {0, 850, 1400, 300, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }

        if (eq_attrib >= 70 && eq_attrib < 80) {
            int[] bgv = {90, 600, 1000, 190, 644, 2717, 57, 362, 586};
            int[] bgv_yf = {0, 1100, 1800, 380, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 80 && eq_attrib < 90) {
            int[] bgv = {100, 750, 1200, 240, 792, 3345, 65, 446, 722};
            int[] bgv_yf = {0, 1300, 2200, 480, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 90 && eq_attrib < 100) {
            int[] bgv = {120, 950, 1500, 280, 956, 4033, 73, 537, 871};
            int[] bgv_yf = {0, 1600, 2600, 550, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 100 && eq_attrib < 110) {
            int[] bgv = {130, 1300, 4400, 440, 1133, 4781, 82, 637, 1032};
            int[] bgv_yf = {0, 2400, 7500, 850, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 110 && eq_attrib < 120) {
            int[] bgv = {140, 1600, 5000, 500, 1324, 5589, 90, 745, 1207};
            int[] bgv_yf = {0, 2800, 9000, 1000, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 120 && eq_attrib < 130) {
            int[] bgv = {160, 1800, 5500, 550, 1530, 6457, 98, 861, 1395};
            int[] bgv_yf = {0, 3200, 10000, 1100, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        if (eq_attrib >= 130) {
            int[] bgv = {170, 2000, 6500, 650, 1750, 7386, 106, 984, 1595};
            int[] bgv_yf = {0, 3600, 11000, 1300, 0, 0, 0, 0, 0};
            if (clothes) {
                bgv[1] = bgv_yf[1];
                bgv[2] = bgv_yf[2];
                bgv[3] = bgv_yf[3];
            }
            return bgv[point];
        }


        return 100;

    }


    /**
     * 获取
     * 蓝色 粉 黄属性的最大值
     * 绿色 物伤	气血	法力	速度	法伤	防御
     *
     * @param name
     * @param eq_attrib
     * @param isClothes 是否是衣服 true 衣服
     * @return
     */
    public static int getMaxValueByChineseName(String name, int eq_attrib, boolean isClothes) {
        return getMaxValueByChineseName(name, eq_attrib, isClothes, false);
    }

    /**
     * 获取蓝色 粉 黄属性的最大值
     *
     * @param name
     * @param eq_attrib
     * @param green     是否是绿色
     * @param isClothes 是否是衣服 true 衣服
     * @return
     */
    public static int getMaxValueByChineseName(String name, int eq_attrib, boolean isClothes, boolean green) {

        if ("伤害_最低伤害".contentEquals(name)) {
            return maxSkill_Low_Cost(eq_attrib);
        }


        /**
         * 蓝色  速度 气血 法力 防御
         */

        /**
         * 绿色 物伤	气血	法力	速度	法伤	防御
         */
        if ("物伤#气血#法力#速度#法伤#防御".contains(name)) {
            return getMaxValueGiven(name, eq_attrib, isClothes, green);
        }


        if ("所有属性".contentEquals(name)) {
            return eq_attrib / 5;
        }
        String[] valuel_t = {"力量", "灵力", "敏捷", "体质"};
        if (contains(valuel_t, name)) {
            return maxSpeed(eq_attrib);
        }
        String[] value10_30 = {"几率躲避攻击"
                , "忽视目标抗金", "忽视目标抗木", "忽视目标抗水", "忽视目标抗火", "忽视目标抗土"
                , "物理必杀率", "物理连击率", "反击率"
                , "反震率", "反震度"
                , "忽视目标抗中毒", "忽视目标抗冰冻", "忽视目标抗昏睡", "忽视目标抗混乱", "忽视目标抗遗忘"
                , "强力遗忘", "强力中毒", "强力冰冻", "强力昏睡", "强力混乱" //, "破防"
        };
        if (contains(value10_30, name)) {
            return 30;
        }


        String[] value5_20 = {"抗中毒", "抗冰冻", "抗昏睡", "抗遗忘", "抗混乱"
                , "强力克金", "强力克木", "强力克水", "强力克火", "强力克土"
                , "忽视所有抗异常"};
        if (contains(value5_20, name)) {
            return 20;
        }

        String[] value5_15 = {"金抗性", "木抗性", "水抗性", "火抗性", "土抗性", "所有抗异常"
                , "几率解除混乱状态", "几率解除昏睡状态", "几率解除冰冻状态", "几率解除中毒状态", "几率解除遗忘状态"};
        if (contains(value5_15, name)) {
            return 15;
        }


        String[] value3_10 = {"强金法伤害", "强木法伤害", "强水法伤害", "强火法伤害", "强土法伤害"
                , "强物理伤害"
                , "法攻技能消耗降低", "障碍技能消耗降低", "辅助技能消耗降低"
                , "忽视所有抗性"
                , "所有抗性", "反击次数"};
        if (contains(value3_10, name)) {
            return 10;
        }


        String[] value1_5 = {"所有相性", "金相性", "木相性", "水相性", "火相性", "土相性"
                , "所有属性"};
        if (contains(value1_5, name)) {
            return 5;
        }

        String[] value1_10 = {"所有技能上升"};
        if (contains(value1_10, name)) {
            return 10;
        }


        String[] value1_12 = {
                "物理连击次数"};
        if (contains(value1_12, name)) {
            return 12;
        }


        return 100;
    }


    /**
     * 获得概率
     */
    public static int getProbabilityValue(int min, int max) {
        //5---20    5-10 概率30%   10-19  概率65%  20概率5%
        List<Integer> separates = new ArrayList<Integer>();
        separates.add((max + min) / 2);
        separates.add(max - 1);
        List<Integer> percents = new ArrayList<Integer>();
        percents.add(30);
        percents.add(68);
        percents.add(2);
        int number = RateRandomNumber.produceRateRandomNumber(min, max, separates, percents);
        return number;
    }


    /**
     * 获取附加属性伤害的算法
     *
     * @param eq_attrib 装备等级
     * @return
     */
    public static int maxSkill_Low_Cost(int eq_attrib) {
        int[] maxValues = {37, 100, 240, 400, 600, 850, 1100, 1400, 1700, 2000, 2400, 2800, 3200};
        //70级一下的装备不能强化
        if (eq_attrib / 10 < 7) {
            return maxValues[eq_attrib / 10];
        }
        int leave = eq_attrib % 10 / 3;
        return maxValues[eq_attrib / 10] + leave * 100;
    }

    /**
     * 敏捷 灵力 体质  力量  共用最大值
     *
     * @param eq_attrib
     * @return
     */
    public static int maxSpeed(int eq_attrib) {
        return eq_attrib / 4;
    }


    /**
     * 蓝色属性法力
     * 77  /2000
     *
     * @param eq_attrib
     * @return
     */
    public static int maxDex(int eq_attrib) {
        return 100;
    }

    /**
     * 粉 黄的时候的防御和气血的值
     * 70   /380      1100
     * 90   /280
     * 100  /440
     * 110  /500
     *
     * @param eq_attrib
     * @return
     */
    public static int maxDefWiz(int eq_attrib) {
        return 100;
    }


    /**
     * * 妖石合成
     * * 1-9级
     * * accurate 物伤
     * * mana 法伤
     * * def  血气
     * * parry  速度
     * * dex  法力
     * * wiz 防御
     * *
     *
     * @param type 妖石客户端type
     */
    public Hashtable<String, String> demonStoneSynthesis(int type) {
        //1  4000
        //2  5000
        //4  7000
        //5  8000
        //8  11000
        int skill = type % 10;
        Hashtable<String, String> hashtable = new Hashtable<>();
        int silver_coin = 3000 + skill * 1000;
        //凝香幻彩 气血增加 1560  客户端端101
        int def = skill * skill * 100;
        //炫影霜星 速度 1563  客户端端  121  如果是2级是122
        int parry = skill * 32;
        //风寂云清 防御 1562 客户端端 141
        int wiz = skill * skill * 30;
        //枯月流魂 物伤 1561 客户端端  161
        int accurate = skill * skill * 66;
        //冰落残阳 法力 1566 客户端端201
        int dex = skill * skill * 66;
        //雷极弧光 法伤 1564  客户端端  181
        int[] manas = {0, 43, 174, 392, 696, 1089, 1568, 2134, 2787, 3528};
        if (skill > 9) {
            skill = 9;
        }
        int mana = manas[skill];
        hashtable.put("silver_coin", String.valueOf(silver_coin));
        hashtable.put("skill", String.valueOf(skill));
        hashtable.put("", String.valueOf(skill));

        int swType = type / 10;
        switch (swType) {
            case 10:
                hashtable.put("def", String.valueOf(def));
                hashtable.put("str", "凝香幻彩");
                break;
            case 12:
                hashtable.put("parry", String.valueOf(parry));
                hashtable.put("str", "炫影霜星");
                break;
            case 14:
                hashtable.put("wiz", String.valueOf(wiz));
                hashtable.put("str", "风寂云清");
                break;
            case 16:
                hashtable.put("accurate", String.valueOf(accurate));
                hashtable.put("str", "枯月流魂");
                break;
            case 18:
                hashtable.put("mana", String.valueOf(mana));
                hashtable.put("str", "雷极弧光");
                break;
            case 20:
                hashtable.put("dex", String.valueOf(dex));
                hashtable.put("str", "冰落残阳");
                break;
        }

        return hashtable;
    }


    public static int demonStoneValue(int type) {

        int skill = type % 10;
        int silver_coin = 3000 + skill * 1000;
        //凝香幻彩 气血增加 1560  客户端端101
        int def = skill * skill * 100;
        //炫影霜星 速度 1563  客户端端  121  如果是2级是122
        int parry = skill * 32;
        //风寂云清 防御 1562 客户端端 141
        int wiz = skill * skill * 30;
        //枯月流魂 物伤 1561 客户端端  161
        int accurate = skill * skill * 66;
        //冰落残阳 法力 1566 客户端端201
        int dex = skill * skill * 66;
        //雷极弧光 法伤 1564  客户端端  181
        int[] manas = {0, 43, 174, 392, 696, 1089, 1568, 2134, 2787, 3528};
        if (skill > 9) {
            skill = 9;
        }
        int mana = manas[skill];
        int swType = type / 10;
        switch (swType) {
            case 10:
                return def;
            case 12:
                return parry;
            case 14:
                return wiz;
            case 16:
                return accurate;
            case 18:
                return mana;
            case 20:
                return dex;
        }

        return 100;
    }

}
