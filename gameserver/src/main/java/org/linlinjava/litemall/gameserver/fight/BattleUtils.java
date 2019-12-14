//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BattleUtils {
    public static final List<Integer> SKILL_INDEX_LIST = new ArrayList();
    public static final List<Integer> SKILL_PERCENT_POINT_LIST = new ArrayList();

    public BattleUtils() {
    }

    public static Hashtable<String, Integer>[] battlePosition(List<Hashtable<String, String>> list, List<String> monsters) {
        ConcurrentLinkedQueue<Integer> mineQueueFront = new ConcurrentLinkedQueue();
        mineQueueFront.offer(3);
        mineQueueFront.offer(2);
        mineQueueFront.offer(4);
        mineQueueFront.offer(1);
        mineQueueFront.offer(5);
        ConcurrentLinkedQueue<Integer> mineQueueBehind = new ConcurrentLinkedQueue();
        mineQueueBehind.offer(8);
        mineQueueBehind.offer(7);
        mineQueueBehind.offer(9);
        mineQueueBehind.offer(6);
        mineQueueBehind.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueFront = new ConcurrentLinkedQueue();
        monsterQueueFront.offer(8);
        monsterQueueFront.offer(7);
        monsterQueueFront.offer(9);
        monsterQueueFront.offer(6);
        monsterQueueFront.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueBehind = new ConcurrentLinkedQueue();
        monsterQueueBehind.offer(3);
        monsterQueueBehind.offer(2);
        monsterQueueBehind.offer(4);
        monsterQueueBehind.offer(1);
        monsterQueueBehind.offer(5);
        Hashtable<String, Integer> minePositionTab = new Hashtable();
        String monster;
        if (!list.isEmpty()) {
            Iterator var7 = list.iterator();

            while(var7.hasNext()) {
                Hashtable<String, String> hs = (Hashtable)var7.next();
                monster = (String)hs.get("person");
                String petValue = (String)hs.get("pet");
                minePositionTab.put(monster, mineQueueBehind.poll());
                int petPosition = (Integer)mineQueueFront.poll();
                if (null != petValue && !petValue.isEmpty()) {
                    minePositionTab.put(petValue, petPosition);
                }
            }
        }

        Hashtable<String, Integer> monsterPositionTab = new Hashtable();
        if (!monsters.isEmpty()) {
            Iterator var13 = monsters.iterator();

            while(var13.hasNext()) {
                monster = (String)var13.next();
                if (monsterQueueBehind.isEmpty()) {
                    monsterPositionTab.put(monster, monsterQueueFront.poll());
                } else {
                    monsterPositionTab.put(monster, monsterQueueBehind.poll());
                }
            }
        }

        Hashtable<String, Integer>[] hashtables = new Hashtable[]{minePositionTab, monsterPositionTab};
        return hashtables;
    }

    public static Hashtable<String, Integer>[] battlePkPosition(List<Hashtable<String, String>> list, List<Hashtable<String, String>> monsterList) {
        ConcurrentLinkedQueue<Integer> mineQueueFront = new ConcurrentLinkedQueue();
        mineQueueFront.offer(3);
        mineQueueFront.offer(2);
        mineQueueFront.offer(4);
        mineQueueFront.offer(1);
        mineQueueFront.offer(5);
        ConcurrentLinkedQueue<Integer> mineQueueBehind = new ConcurrentLinkedQueue();
        mineQueueBehind.offer(8);
        mineQueueBehind.offer(7);
        mineQueueBehind.offer(9);
        mineQueueBehind.offer(6);
        mineQueueBehind.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueFront = new ConcurrentLinkedQueue();
        monsterQueueFront.offer(8);
        monsterQueueFront.offer(7);
        monsterQueueFront.offer(9);
        monsterQueueFront.offer(6);
        monsterQueueFront.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueBehind = new ConcurrentLinkedQueue();
        monsterQueueBehind.offer(3);
        monsterQueueBehind.offer(2);
        monsterQueueBehind.offer(4);
        monsterQueueBehind.offer(1);
        monsterQueueBehind.offer(5);
        Hashtable<String, Integer> minePositionTab = new Hashtable();
        String personValue;
        if (!list.isEmpty()) {
            Iterator var7 = list.iterator();

            while(var7.hasNext()) {
                Hashtable<String, String> hs = (Hashtable)var7.next();
//                personValue = (String)hs.get("person");
                personValue = (String)hs.get("pet");
                minePositionTab.put(personValue, mineQueueBehind.poll());
                int petPosition = (Integer)mineQueueFront.poll();
                if (null != personValue && !personValue.isEmpty()) {
                    minePositionTab.put(personValue, petPosition);
                }
            }
        }

        Hashtable<String, Integer> monsterPositionTab = new Hashtable();
        if (!monsterList.isEmpty()) {
            Iterator var14 = monsterList.iterator();

            while(var14.hasNext()) {
                Hashtable<String, String> hs = (Hashtable)var14.next();
                personValue = (String)hs.get("person");
                String petValue = (String)hs.get("pet");
                monsterPositionTab.put(personValue, monsterQueueBehind.poll());
                int petPosition = (Integer)monsterQueueFront.poll();
                if (null != petValue && !petValue.isEmpty()) {
                    monsterPositionTab.put(petValue, petPosition);
                }
            }
        }

        Hashtable<String, Integer>[] hashtables = new Hashtable[]{minePositionTab, monsterPositionTab};
        return hashtables;
    }

    public static void main(String[] args) {
        Hashtable<String, String> mineTab1 = new Hashtable();
        mineTab1.put("person", "我");
        mineTab1.put("pet", "我对宠物");
        Hashtable<String, String> mineTab5 = new Hashtable();
        mineTab5.put("person", "队友5");
        mineTab5.put("pet", "队友5的宠物");
        Hashtable<String, String> mineTab2 = new Hashtable();
        mineTab2.put("person", "守护1");
        Hashtable<String, String> mineTab3 = new Hashtable();
        mineTab3.put("person", "守护2");
        Hashtable<String, String> mineTab4 = new Hashtable();
        mineTab4.put("person", "守护4");
        List<Hashtable<String, String>> list = new ArrayList();
        list.add(mineTab1);
        list.add(mineTab5);
        list.add(mineTab2);
        list.add(mineTab3);
        list.add(mineTab4);
        List<String> mlist = new ArrayList();
        mlist.add("怪物1");
        mlist.add("怪物2");
        mlist.add("怪物3");
        mlist.add("怪物4");
        mlist.add("怪物5");
        mlist.add("怪物6");
        mlist.add("怪物7");
        mlist.add("怪物8");
        mlist.add("怪物9");
        mlist.add("怪物10");
        battlePosition(list, mlist);
    }

    public static int produceRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int monsterCount(int attrib, int teamMember, int monsterAttrib) {
        if (monsterAttrib > 15 && attrib >= 10) {
            if (monsterAttrib > 35 && attrib >= 25) {
                return monsterAttrib > 50 && attrib >= 35 ? produceRandomNumber(teamMember, teamMember + 3 < 10 ? teamMember + 3 : 10) : produceRandomNumber(3, 5);
            } else {
                return produceRandomNumber(2, 3);
            }
        } else {
            return produceRandomNumber(1, 2);
        }
    }

    public static int battle(int baseAttack, int skillAttack, int monsterDefense) {
        double y = 1.483748645720477D;
        double x = 1.880943782352233D;
        double jp = (double)monsterDefense * 1.0D / (double)(baseAttack + skillAttack + monsterDefense);
        int hurt = (int)((double)(baseAttack + skillAttack) * (1.0D - jp * jp) * 0.8785D);
        int fudong = hurt / 10;
        if (fudong != 0) {
            int rfudong = FightManager.RANDOM.nextInt(fudong);
            hurt = hurt + rfudong - fudong / 2;
        }

        return hurt;
    }

    public static int skillAttack(int baseAttack, int skillLeave, String skillType, int skillPara) {
        if (skillType.contentEquals("WS")) {
            return (int)(0.001138120610055D * (double)skillLeave * (double)baseAttack);
        } else {
            int skillIndex = getSkillIndex(skillPara);
            double[] fs = new double[]{0.0D, 7.98084596967E-4D, 0.002394253790902D, 0.010375099760575D, 0.004788507581804D};
            return skillType.contentEquals("FS") ? (int)(fs[skillIndex] * (double)skillLeave * (double)baseAttack * 0.8D) : 0;
        }
    }

    public static double extAdd(int skillLeave, int skillPara) {
        int skillIndex = getSkillIndex(skillPara);
        int[] base_pro = new int[]{10, 17, 25, 50, 40};
        double append = (double)(skillLeave / 208) * 0.3D;
        return (double)base_pro[skillIndex] * (1.0D + append);
    }

    public static void init() {
        SKILL_INDEX_LIST.add(11);
        SKILL_INDEX_LIST.add(21);
        SKILL_INDEX_LIST.add(31);
        SKILL_INDEX_LIST.add(61);
        SKILL_INDEX_LIST.add(71);
        SKILL_INDEX_LIST.add(81);
        SKILL_INDEX_LIST.add(110);
        SKILL_INDEX_LIST.add(121);
        SKILL_INDEX_LIST.add(131);
        SKILL_INDEX_LIST.add(161);
        SKILL_INDEX_LIST.add(171);
        SKILL_INDEX_LIST.add(181);
        SKILL_INDEX_LIST.add(210);
        SKILL_INDEX_LIST.add(221);
        SKILL_INDEX_LIST.add(231);
        Collections.reverse(SKILL_INDEX_LIST);
        SKILL_PERCENT_POINT_LIST.add(15);
        SKILL_PERCENT_POINT_LIST.add(20);
        SKILL_PERCENT_POINT_LIST.add(30);
        SKILL_PERCENT_POINT_LIST.add(65);
        SKILL_PERCENT_POINT_LIST.add(50);
    }

    public static int getSkillIndex(int para) {
        Iterator var1 = SKILL_INDEX_LIST.iterator();

        Integer index;
        do {
            if (!var1.hasNext()) {
                return 0;
            }

            index = (Integer)var1.next();
        } while(index > para);

        return para - index;
    }
}
