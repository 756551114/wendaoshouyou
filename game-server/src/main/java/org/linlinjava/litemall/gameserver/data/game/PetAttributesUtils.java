package org.linlinjava.litemall.gameserver.data.game;

import java.util.Hashtable;
import java.util.Random;

/**
 * 人物基础属性
 * 气血	法力	物伤	法伤	速度	防御 计算
 * @author cool
 */
public class PetAttributesUtils {


    /**
     * 整体伤害
     *
     * @param isMagic      法攻 true 物攻 false
     * @param attrib       宝宝等级
     * @param constitution 所有体质（人物拥有的，不含未加点）
     * @param mag_power    所有灵力
     * @param phy_power    所有力量
     * @param speed        所有敏捷
     * @param qx_append    气血成长
     * @param fl_append    法力成长
     * @param sd_append    速度成长
     * @param wg_append    物攻成长
     * @param fg_append    法攻成长
     * @return int[]  气血	法力 物伤  法伤	速度	 防御
     */

    public static int[] petAttributes(boolean isMagic, int attrib, int constitution, int mag_power, int phy_power, int speed
            , int qx_append, int fl_append, int sd_append, int wg_append, int fg_append) {

        /**速度计算*******/
        int parry_all = (int) (0.06 * sd_append * speed + 50);
        /**end *******/

        //物伤
        int accurate_all = (int) (wg_append * (0.3) * phy_power + 16 * (attrib) + 50);

        //法伤
        int mana_all = (int) (fg_append * mag_power * 0.55 + 15 * (attrib) + 70);

        //气血  todo
        int def_all = (int) (qx_append * (0.81) * constitution + 3.237 * (attrib*attrib));

        //法力
        int dex_all = (int) (fl_append * (0.38) * mag_power + 70 * (attrib));

        //防御 todo
        int wiz_all = (int) (qx_append * (0.0835) * constitution + 0.77 * (attrib*attrib));
        int[] attributes = new int[6];
        //气血	法力	 物伤  法伤	速度  	防御
        attributes[0] = def_all;
        attributes[1] = dex_all;
        attributes[2] = accurate_all;
        attributes[3] = mana_all;
        attributes[4] = parry_all;
        attributes[5] = wiz_all;


        return attributes;
    }
//    public static int[] petAttributes(boolean isMagic, int attrib, int constitution, int mag_power, int phy_power, int speed
//            , int qx_append, int fl_append, int sd_append, int wg_append, int fg_append) {
//
//        /**速度计算*******/
//        int parry_all = (int) (0.06 * sd_append * speed + 50);
//        /**end *******/
//        //物伤
//        int accurate_all = (int) (wg_append * (0.3) * phy_power + 16 * (attrib) + 50);
//
//        //法伤
//        int mana_all = (int) (fg_append * mag_power * 0.55 + 15 * (attrib) + 70);
//
//        //气血
//        int def_all = (int) (qx_append * (1.4) * constitution + 80 * (attrib));
//
//        //法力
//        int dex_all = (int) (fl_append * (0.38) * mag_power + 70 * (attrib));
//
//        //防御
////        int wiz_all = (int) (qx_append * (0.2) * constitution + 10 * (attrib));
//        int wiz_all = (int) (qx_append * (0.2) * constitution + 50 * (attrib));
//        int[] attributes = new int[6];
//        //气血	法力	 物伤  法伤	速度  	防御
//        attributes[0] = def_all;
//        attributes[1] = dex_all;
////        attributes[2] = accurate_all * 4 / 3;
////        attributes[3] = mana_all * 4 / 3;
//        attributes[2] = accurate_all * 4 / 3;
//        attributes[3] = mana_all * 4 / 3;
//        attributes[4] = parry_all;
//        attributes[5] = wiz_all;
//
//
//        return attributes;
//    }


    /**
     * 羽化 和点化一样基于基础的成长来计算  面板也都一样显示总的
     * *                          羽化https://zhidao.baidu.com/question/2116404805398417027.html
     *
     * @param quality           品质 1普通  2变异 3 精怪  4神兽
     * @param use_attrib        携带等级
     * @param currentReiki      宠物的当前阶段  初级1  中级2  高级3  完成羽化
     * @param currentReiki      宠物的当前点化灵气
     * @param pill              点化丹个数
     * @param equipmentMoney    鉴定的装备价格
     * @param UnidentifiedMoney 未鉴定的价格
     * @param appends           //原始的气血 法力 物伤 法伤 速度  完成之后才+的   没有完成只做完显示
     *                          def_append;
     *                          dex_append;
     *                          accurate_append;
     *                          mana_append;
     *                          parry_append;
     *                          坐骑始终都是300000
     *                          变异 140000  210000
     *                          神兽 280000  420000
     * @return
     */
    public static int[] emergencePet(int quality, int use_attrib, int currentStep, int currentReiki, int pill, int equipmentMoney, int UnidentifiedMoney, int[] appends) {
        //1级   24000
        //5     25756
        //27575
        //15    29395
        //20    31056
        //25    32655
        //30    34203
        //35    35719
        //40    37200
        //45    38653
        //50    40083
        //55    41490
        //60    42879
        //65    44251   1355
        //70    45606   1340
        //75    46947   1328
        //80    48275   1316
        //85    49591
        //90    50895
        //95    52188
        //100   53471
        //105   54744
        //110   56008   1264
        //115   57272
        //120   58536
        //125   59800
        //携带等级/5
        int[] reikis = {24000, 25756, 27575, 29395, 31056, 32655, 34203,
                35719, 37200, 38653, 40083, 41490, 42879, 44251, 45606, 46947, 48275,
                49591, 50895, 52188, 53471, 54744, 56008, 57272, 58536, 59800};

        //灵气比例  2  3  5
        int maxReiki = 0;
        if (quality == 1) {
            if (use_attrib >= 130) {
                maxReiki = (use_attrib - 125) / 5 * 1264 + 59800;
            } else {
                maxReiki = reikis[use_attrib / 5];
            }
            if (currentStep == 1) {
            } else if (currentStep == 2) {
                maxReiki = maxReiki / 2 * 3;
            } else if (currentStep == 3) {
                maxReiki = maxReiki / 2 * 5;
            }
        } else if (quality == 3) {
            maxReiki = 300000;
        } else if (quality == 2) {
            maxReiki = 140000;
            if (currentStep == 1) {
            } else if (currentStep == 2) {
                maxReiki = maxReiki / 2 * 3;
            } else if (currentStep == 3) {
                maxReiki = maxReiki / 2 * 5;
            }
        } else if (quality == 4) {
            maxReiki = 280000;
            if (currentStep == 1) {
            } else if (currentStep == 2) {
                maxReiki = maxReiki / 2 * 3;
            } else if (currentStep == 3) {
                maxReiki = maxReiki / 2 * 5;
            }
        }

        //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
        int[] result = new int[7];

        //丹药3000   鉴定到99自动完成
        //装备未鉴定的钱714.285714285714286
        //鉴定5000
        int newReiki = (int) (currentReiki + pill * 3000 + equipmentMoney / 5000 + UnidentifiedMoney / 714.285714285714286);
        if (newReiki >= maxReiki * 0.95) {
            //
            result[0] = 1;
            result[1] = maxReiki;
        } else {
            if (newReiki > maxReiki * 0.7 && new Random().nextInt(10) < 2) {
                result[0] = 1;
                result[1] = maxReiki;
            } else {
                result[1] = newReiki;
            }
        }

        /**
         * 普通
         * 物攻成长 基础成长 * 20%
         * 法攻成长 基础成长 * 20%
         * 速度成长 基础成长 * 30%
         * 法力成长 基础成长 * 20%
         * 血量成长 基础成长 * 50%
         */

        /**
         * 变异
         * 物攻成长 基础成长 * 40%
         * 法攻成长 基础成长 * 50%
         * 速度成长 基础成长 * 40%
         * 法力成长 基础成长 * 25%
         * 血量成长 基础成长 * 60%
         */


        /**
         * 物攻成长 基础成长 * 50%
         * 法攻成长 基础成长 * 70%
         * 速度成长 基础成长 * 45%
         * 法力成长 基础成长 * 40%
         * 血量成长 基础成长 * 80%
         */

        //气血 法力 物伤 法伤 速度
        if (quality == 1) {
            result[2] = (int) (0.5 * Math.abs(appends[0]));
            result[3] = (int) (0.2 * Math.abs(appends[1]));
            result[4] = (int) (0.2 * Math.abs(appends[2]));
            result[5] = (int) (0.2 * Math.abs(appends[3]));
            result[6] = (int) (0.3 * Math.abs(appends[4]));
        } else if (quality == 2) {
            result[2] = (int) (0.6 * Math.abs(appends[0]));
            result[3] = (int) (0.25 * Math.abs(appends[1]));
            result[4] = (int) (0.4 * Math.abs(appends[2]));
            result[5] = (int) (0.5 * Math.abs(appends[3]));
            result[6] = (int) (0.4 * Math.abs(appends[4]));
        } else if (quality == 3) {
            result[2] = (int) (0.8 * Math.abs(appends[0]));
            result[3] = (int) (0.4 * Math.abs(appends[1]));
            result[4] = (int) (0.5 * Math.abs(appends[2]));
            result[5] = (int) (0.7 * Math.abs(appends[3]));
            result[6] = (int) (0.45 * Math.abs(appends[4]));
        }


        return result;

    }


    /**
     * 点化
     * 精怪  300000
     *
     * @param quality           品质 1普通  2变异 3 精怪  4神兽
     * @param use_attrib        携带等级
     * @param currentReiki      宠物的当前点化灵气
     * @param pill              点化丹个数
     * @param equipmentMoney    鉴定的装备价格
     * @param UnidentifiedMoney 未鉴定的价格
     * @param appends           //原始的气血 法力 物伤 法伤 速度
     *                          def_append;
     *                          dex_append;
     *                          accurate_append;
     *                          mana_append;
     *                          parry_append;
     *                          精怪300000
     *                          变异的400000
     *                          神兽400000
     */
    public static int[] dotPet(int quality, int use_attrib, int currentReiki, int pill, int equipmentMoney, int UnidentifiedMoney, int[] appends) {
        //进度一个点化丹6000的灵力
        //鉴定的装备价格/1000
        //未鉴定的价格/142

        //点化完成后充值宠物丹属性 抗性加点
        //灵气增长基础属性就会增长

        //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
        int[] result = new int[7];

        int maxReiki = 0;
        if (quality == 1) {
            maxReiki = use_attrib * use_attrib * 30;
        } else if (quality == 2) {
            maxReiki = 400000;
        } else if (quality == 3) {
            maxReiki = 300000;
        } else if (quality == 4) {
            maxReiki = 400000;
        }

        int newReiki = currentReiki + pill * 6000 + equipmentMoney / 1000 + UnidentifiedMoney / 142;
        double proportion;
        if (newReiki >= maxReiki) {
            result[0] = 1;
            result[1] = maxReiki;
            proportion = 1;
        } else {
            result[1] = newReiki;
            proportion = 1.0 * newReiki / maxReiki;
        }
        result[2] = (int) (proportion * 0.3 * Math.abs(appends[0]));
        result[3] = (int) (proportion * 0.3 * Math.abs(appends[1]));
        result[4] = (int) (proportion * 0.3 * Math.abs(appends[2]));
        result[5] = (int) (proportion * 0.3 * Math.abs(appends[3]));
        result[6] = (int) (proportion * 0.3 * Math.abs(appends[4]));
        return result;


    }


    /**
     * 强化
     *
     * @param isMagic         法攻 true 物攻 false
     * @param maxAttrib       最大属性
     * @param currentUpgrade  当前强化等级
     * @param currentProgress 当前强化进度
     *                        int[0] 强化等级 ;int[1] 如果成功加的成长值;  int[2]  总进度 如果成功0  如果失败则返回当前的总进度
     */
    public static int[] upgradePet(boolean isMagic, int maxAttrib, int currentUpgrade, int currentProgress) {
        int[] result = new int[3];
        Random random = new Random();
        int raInt = random.nextInt(10000);
        int[] probability = {6450, 1000, 214, 133, 90, 65, 45, 35, 21, 15, 8, 5, 3};
        if (currentUpgrade >= 12) {
            result[0] = currentUpgrade;
            return result;
        }
        if (raInt <= probability[currentUpgrade]) {
            result[0] = currentUpgrade + 1;
            result[2] = 0;
        } else {
            if (currentProgress + probability[currentUpgrade] >= 10000) {
                result[0] = currentUpgrade + 1;
                result[2] = 0;
            } else {
                result[2] = currentProgress + probability[currentUpgrade];
            }
        }


        if (isMagic) {
            result[1] = (int) (maxAttrib / 12.5);
        } else {
            result[1] = (int) (maxAttrib / 12.5);
        }

        return result;

    }


    /**
     * 守护属性
     *
     * @param type  品质    普通1/优秀2/卓越3
     * @param polar 相性    金木水火土12345
     *              守护最低13级
     */
    public static Hashtable<String, int[]> helpPet(int type, int polar, int attriba) {
        //金木水火土
        //基础最高多是38
        int[] base_polars = {6, 6, 6, 6, 6};
        int[] j = {1, 3, 4, 2, 5};
        int[] m = {4, 1, 2, 3, 5};
        int[] s = {2, 3, 1, 4, 5};
        int[] h = {4, 3, 5, 1, 2};
        int[] t = {4, 2, 3, 5, 1};


        Hashtable<Integer, int[]> hashtable = new Hashtable<>();
        hashtable.put(1, j);
        hashtable.put(2, m);
        hashtable.put(3, s);
        hashtable.put(4, h);
        hashtable.put(5, t);
        //125级   97+30

        //相性
        int count_xx = 2;

        if (attriba <= 60) {
            count_xx = attriba / 2 + 2;
        } else if (attriba < 81) {
            count_xx = (int) ((attriba - 60) * 1.45 + 32);
        } else {//>=81
            count_xx = attriba - 19;
            if (count_xx > 97) {
                count_xx = 97;
            }
        }

        int[] xx = hashtable.get(polar);
        for (int i = 0; i < xx.length; i++) {
            if (xx[i] == 1) {
                if (count_xx >= 33) {
                    base_polars[i] = base_polars[i] + 33;
                } else {
                    base_polars[i] = base_polars[i] + count_xx;
                }
            }

            if (xx[i] == 2) {
                if (count_xx >= 33) {
                    if (count_xx - 33 >= 32) {
                        base_polars[i] = base_polars[i] + 32;
                    } else {
                        base_polars[i] = base_polars[i] + count_xx - 33;
                    }
                }
            }

            if (xx[i] == 3) {
                if (count_xx >= 65) {
                    if (count_xx - 65 >= 32) {
                        base_polars[i] = base_polars[i] + 32;
                    } else {
                        base_polars[i] = base_polars[i] + count_xx - 65;
                    }
                }
            }

            if (type == 2) {
                base_polars[i] = base_polars[i] + 1;
            } else if (type == 3) {
                base_polars[i] = base_polars[i] + 2;
            }
        }


        //体质  灵力  力量   敏捷
        int[] base_ss = {16, 40, 12, 29};
        Hashtable<Integer, int[]> hashtabless125 = new Hashtable<>();
        hashtabless125.put(1, new int[]{197, 480, 158, 354});
        hashtabless125.put(2, new int[]{443, 158, 158, 511});
        hashtabless125.put(3, new int[]{255, 427, 140, 235});
        hashtabless125.put(4, new int[]{175, 140, 252, 533});
        hashtabless125.put(5, new int[]{235, 140, 490, 175});
        if (attriba <= 13) {
            base_ss = new int[]{16, 40, 12, 29};
        } else if (attriba >= 125) {
            base_ss = hashtabless125.get(polar);
        } else {
            int[] base_ss125 = hashtabless125.get(polar);
            for (int i = 0; i < 4; i++) {
                base_ss[i] = (base_ss125[i] - base_ss[i]) / 112 * (attriba - base_ss[i]) + base_ss[i];
            }
        }


        int[] js = {9, 26, 8, 19};
        int[] ms = {36, 13, 8, 46};
        int[] ss = {38, 67, 29, 35};
        int[] hs = {22, 67, 29, 35};
        int[] ts = {29, 18, 11, 22};

        Hashtable<Integer, int[]> hashtablessadd = new Hashtable<>();
        hashtablessadd.put(1, js);
        hashtablessadd.put(2, ms);
        hashtablessadd.put(3, ss);
        hashtablessadd.put(4, hs);
        hashtablessadd.put(5, ts);
        int[] addss = hashtablessadd.get(polar);
        if (type == 2) {
            for (int i = 0; i < 4; i++) {
                base_ss[i] = base_ss[i] + addss[i];
            }
        } else {
            for (int i = 0; i < 4; i++) {
                base_ss[i] = (int) (base_ss[i] + addss[i] * 1.5);
            }
        }

        Hashtable<String, int[]> hp = new Hashtable<>();
        hp.put("attribute", base_ss);
        hp.put("polars", base_polars);

        return hp;


    }

}
