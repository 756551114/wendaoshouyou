package org.linlinjava.litemall.gameserver.data.game;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class LuckDrawUtils {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if(luckDraw(false)[1].contentEquals("装备")){
                System.out.println(equipmentLuckDraw(75));
            }
        }
    }

    /**
     * 抽奖
     *
     * @param isSenior 高级true
     * @return
     */
    public static String[] luckDraw(boolean isSenior) {

        String nameType = "";
        String[] teDing = {"墨麒麟#精怪", "九尾狐#神兽", "白矖#神兽", "疆良#神兽", "玄武#神兽", "朱雀#神兽", "东山神灵#神兽"};
        String[] yiDing = {"帅帅猴#变异", "蛋蛋鸡#变异", "乖乖狗#变异", "招财猪#变异", "岳麓剑#精怪", "筋斗云#精怪"};
        String[] erDing = {"超级绿水晶#物品", "黄水晶#物品", "超级女娲石#物品", "高级驯兽诀#物品", "法玲珑#物品"
                , "羽化丹#物品", "神木鼎#物品", "风灵丸#物品",
                "超级绿水晶#物品", "黄水晶#物品", "超级女娲石#物品", "高级驯兽诀#物品", "法玲珑#物品"
                , "羽化丹#物品", "稀有满属性装备#装备", "神木鼎#物品", "风灵丸#物品"
                , "召唤令·上古神兽#物品", "召唤令·十二生肖#物品"};
        String[] siDing = {"超级归元露#物品", "随机满属性装备#装备", "龙鳞手镯#首饰", "八角晶牌#首饰", "驯兽诀#物品", "超级仙风散#物品", "灵池#物品", "血池#物品", "幻彩项链#首饰", "驯兽诀#物品", "超级仙风散#物品", "灵池#物品", "血池#物品"};
        Random random = new Random();
        int r = random.nextInt(1000) + 1;
        if (r <= 2 &&isSenior) {
            nameType = teDing[random.nextInt(teDing.length)];
        } else if (r < 20) {
            nameType = yiDing[random.nextInt(yiDing.length)];
        } else {
            if (isSenior) {
                nameType = erDing[random.nextInt(erDing.length)];
            } else {
                if (r < 500) {
                    nameType = erDing[random.nextInt(erDing.length)];
                } else {
                    nameType = siDing[random.nextInt(siDing.length)];
                }
            }
        }

        return nameType.split("#");

    }


    /**
     * 装备 抽奖
     * @param eq_attrib 人物等级对应抽取等级装备
     * @return
     */
    private static List<Hashtable<String, Integer>> equipmentLuckDraw(int eq_attrib) {
        if(eq_attrib<70){
            eq_attrib=70;
        }else{
            eq_attrib = eq_attrib/10*10;
        }

        Random random = new Random();
        //武器1,头盔2,鞋子10,衣服3
        int[] eqType = {1,2,10,3};
        return ForgingEquipmentUtils.appraisalEquipment(eqType[random.nextInt(4)], eq_attrib, ForgingEquipmentUtils.EQUIPMENT_LUCK_DRAW);
    }

}
