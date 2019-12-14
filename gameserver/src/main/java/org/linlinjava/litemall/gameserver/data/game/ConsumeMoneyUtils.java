package org.linlinjava.litemall.gameserver.data.game;

import java.util.Hashtable;

/**
 * 金币消耗计算类
 */
public class ConsumeMoneyUtils {

    //鉴定扣钱
    private int[] appraisalMoney(int eqType, int eq_attrib) {
        int[] min_max = {0, 0};
        if (eq_attrib <= 40) {
            return min_max;
        }
        if (eq_attrib > 120) {
            eq_attrib = 120;
        }
        if (eqType == 1 || eqType == 3) {
            int[] moneys = {50000, 100000, 150000, 250000, 300000, 35000, 500000, 750000};
            min_max[0] = moneys[eq_attrib / 10 - 5];
            min_max[1] = min_max[0] * 5;
        }

        if (eqType == 10 || eqType == 2) {
            int[] moneys = {35000, 50000, 75000, 100000, 200000, 300000, 400000, 500000};
            min_max[0] = moneys[eq_attrib / 10 - 5];
            min_max[1] = min_max[0] * 5;
        }

        return min_max;

    }

    /**
     * 首饰合成的钱
     *
     * @param dst_eq_attrib
     * @return
     */
    public static int appraisalMoney(int dst_eq_attrib) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(35, 0);
        hashtable.put(50, 25000);
        hashtable.put(60, 30000);
        hashtable.put(70, 35000);
        hashtable.put(80, 480000);
        hashtable.put(90, 540000);
        hashtable.put(100, 600000);
        hashtable.put(110, 1100000);
        hashtable.put(120, 1200000);
        return hashtable.get(dst_eq_attrib);
    }

    /**
     * 重组钱
     * 70
     *
     * @param eq_attrib
     * @return
     */
    public static int createMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        return (eq_attrib / 10 - 7) * 10000 + 75000;
    }

    /**
     * 拆分装备用的金币
     *
     * @param eq_attrib
     * @return
     */
    public static int removeMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        return (eq_attrib / 10 - 7) * 700 + 5200;
    }


    /**
     * 粉装备用的金币
     *
     * @param eq_attrib
     * @return
     */
    public static int pinkMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        if (eq_attrib > 120) {
            return 235400;
        }
        int[] moneys = {83400, 107400, 134600, 165000, 198600, 235400};
        return moneys[eq_attrib / 10 - 7];
    }

    /**
     * 改造 共鸣
     *
     * @param eq_attrib
     * @return
     */
    public static int remakeMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        if (eq_attrib > 120) {
            return 235400;
        }
        int[] moneys = {83400, 107400, 134600, 165000, 198600, 235400};
        return moneys[eq_attrib / 10 - 7];
    }


    /**
     * 黄装备用的金币
     *
     * @param eq_attrib
     * @return
     */
    public static int yellowMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        if (eq_attrib > 120) {
            return 353100;
        }
        int[] moneys = {125100, 161100, 201900, 247500, 297900, 353100};
        return moneys[eq_attrib / 10 - 7];
    }

    /**
     * 强化属性  套装炼化属性
     *
     * @param eq_attrib
     * @return
     */
    public static int appendEqMoney(int eq_attrib) {
        if (eq_attrib < 70) {
            return 0;
        }
        if (eq_attrib > 120) {
            return 353100;
        }
        int[] moneys = {125100, 161100, 201900, 247500, 297900, 353100};
        return moneys[eq_attrib / 10 - 7];
    }


}
