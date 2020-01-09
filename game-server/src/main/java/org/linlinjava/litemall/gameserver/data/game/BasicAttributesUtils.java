//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.game;

import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.fight.VipAddUils;

public class BasicAttributesUtils {
    public BasicAttributesUtils() {
    }

    public static int[] calculationAttributes(
            int attrib,
            int constitution,
            int mag_power,
            int phy_power,
            int speed,
            int wood,
            int water,
            int fire,
            int earth,
            int resist_metal
    ) {
        int[] attributes = new int[]{100, 80, 40, 40, 48, 20};
        int accurate_phy_power = phy_power * 5 + 40;
        int accurate_resist_metal = (int)((double)phy_power * 0.45D * (double)resist_metal);
        int accurate_all = accurate_phy_power + accurate_resist_metal;
        int mana_mag_power = mag_power * 5 + 40;
        int mana_wood = (int)((double)mag_power * 0.16D * (double)wood);
        int mana_all = mana_mag_power + mana_wood;
        int wiz_constitution = constitution * 5 + 20;
        int wiz_fire = (int)((double)constitution * 0.25D * (double)fire);
        int wiz_all = wiz_constitution + wiz_fire;
        int parry_speed = speed * 2 + 48;
        int parry_earth = (int)((double)speed * 0.023D * (double)earth);
        int parry_all = parry_speed + parry_earth;
        int dex_constitution_per = (int)((double)(attrib - 2) * 0.3D + 4.0D);
        int dex_constitution = dex_constitution_per * mag_power;
        int[] dex_attribs = new int[]{80, 239, 452, 699, 983, 1303, 1658, 2049, 2476, 2939, 3337, 3861, 4421, 5018};
        int dex_attrib = dex_attribs[0];
        int index;
        if (attrib >= 130) {
            dex_attrib = dex_attribs[13] + 60 * (attrib - 130);
        } else if (attrib > 1) {
            index = attrib / 10;
            dex_attrib = dex_attribs[index] + (dex_attribs[index + 1] - dex_attribs[index]) / 10 * (attrib % 10);
        }

        index = (int)((double)mag_power * 0.657D * (double)water);
        int dex_all = dex_constitution + dex_attrib + index;
        int def_constitution_per = (int)((double)(attrib - 2) * 0.3D + 5.0D);
        int def_constitution = def_constitution_per * constitution;
        int[] def_attribs = new int[]{100, 359, 727, 1177, 1712, 2281, 2971, 3746, 4604, 5546, 6571, 7569, 8751, 10016};
        int def_attrib = def_attribs[0];
//        int index;
        if (attrib >= 130) {
            def_attrib = def_attribs[13] + 127 * (attrib - 130);
        } else if (attrib > 1) {
            index = attrib / 10;
            def_attrib = def_attribs[index] + (def_attribs[index + 1] - def_attribs[index]) / 10 * (attrib % 10);
        }

        index = (int)((double)constitution * 1.4D * (double)water);
        int def_all = def_constitution + def_attrib + index;
        attributes[0] = def_all;
        attributes[1] = dex_all;
        attributes[2] = accurate_all * 2;
        attributes[3] = mana_all * 2;
        attributes[4] = parry_all;
        attributes[5] = wiz_all * 6 / 5;
        return attributes;
    }

    public static void petshuxing(PetShuXing petShuXing ) {
        Double add = VipAddUils.getUserVipAdd();
        if(add == null){
            add = 1D;
        }

        boolean fagong = petShuXing.rank > petShuXing.pet_mag_shape;
        int[] attributes = org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils.petAttributes(fagong, petShuXing.skill, petShuXing.life, petShuXing.mag_power, petShuXing.phy_power, petShuXing.speed, petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_phy_shape, petShuXing.pet_mag_shape, petShuXing.rank);
        petShuXing.def = (int)(attributes[0]* add);
        petShuXing.dex = (int)(attributes[1]* add);
        if (petShuXing.max_life >= petShuXing.def) {
            petShuXing.max_life = petShuXing.def;
        }

        if (petShuXing.max_mana >= petShuXing.dex) {
            petShuXing.max_mana = petShuXing.dex;
        }

        petShuXing.accurate = (int)(attributes[2] * add);
        petShuXing.mana = (int)(attributes[3]* add);
        petShuXing.parry = (int)(attributes[4]* add);
        petShuXing.wiz = (int)(attributes[5]* add);
    }

    public static void shuxing(Chara chara) {
        Double add = VipAddUils.getUserVipAdd();
        if(add == null){
            add = 1D;
        }

        int[] attributes = calculationAttributes(chara.level, chara.life + chara.zbAttribute.life, chara.mag_power + chara.zbAttribute.mag_power, chara.phy_power + chara.zbAttribute.phy_power, chara.speed + chara.zbAttribute.speed, chara.wood + chara.zbAttribute.wood, chara.water + chara.zbAttribute.water, chara.fire + chara.zbAttribute.fire, chara.earth + chara.zbAttribute.earth, chara.resist_metal + chara.zbAttribute.resist_metal);
        chara.def = (int)(attributes[0]* add);
        chara.dex = (int)(attributes[1]* add);
        if (chara.max_life > chara.def) {
            chara.max_life = chara.def + chara.zbAttribute.def;
        }

        if (chara.max_mana > chara.dex) {
            chara.max_mana = chara.dex + chara.zbAttribute.dex;
        }

        chara.accurate = (int)(attributes[2]* add);
        chara.mana = (int)(attributes[3]* add);
        chara.parry =(int)( attributes[4]* add);
        chara.wiz = (int)(attributes[5]* add);
    }

    public static int[] changeCalculationAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed) {
        int accurate_all = phy_power * 5;
        int mana_all = mag_power * 5;
        int wiz_all = constitution * 5;
        int parry_all = speed * 2;
        int dex_constitution_per = (int)((double)(attrib - 2) * 0.3D + 4.0D);
        int dex_all = dex_constitution_per * mag_power;
        int def_constitution_per = (int)((double)(attrib - 2) * 0.3D + 5.0D);
        int def_all = def_constitution_per * constitution;
        int[] attributes = new int[]{def_all, dex_all, accurate_all, mana_all, parry_all, wiz_all};
        return attributes;
    }

    public static int[] changeRelAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed, int wood, int water, int fire, int earth, int resist_metal) {
        int accurate_all = (int)((double)phy_power * 0.45D * (double)resist_metal);
        int mana_all = (int)((double)mag_power * 0.16D * (double)wood);
        int wiz_all = (int)((double)constitution * 0.25D * (double)fire);
        int parry_all = (int)((double)speed * 0.023D * (double)earth);
        int dex_all = (int)((double)mag_power * 0.657D * (double)water);
        int def_all = (int)((double)constitution * 1.4D * (double)water);
        int[] attributes = new int[]{def_all, dex_all, accurate_all, mana_all, parry_all, wiz_all};
        return attributes;
    }

    public static int[] calculationHelpAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed, int wood, int water, int fire, int earth, int resist_metal, int polar) {
        int[] attributes = new int[]{100, 80, 40, 40, 48, 20};
        int accurate_phy_power = phy_power * 5 + 40;
        int accurate_resist_metal = (int)((double)phy_power * 0.45D * (double)resist_metal);
        int accurate_all = accurate_phy_power + accurate_resist_metal;
        int mana_mag_power = mag_power * 5 + 40;
        int mana_wood = (int)((double)mag_power * 0.16D * (double)wood);
        int mana_all = mana_mag_power + mana_wood;
        int wiz_constitution = constitution * 5 + 20;
        int wiz_fire = (int)((double)constitution * 0.25D * (double)fire);
        int wiz_all = wiz_constitution + wiz_fire;
        int parry_speed = speed * 2 + 48;
        int parry_earth = (int)((double)speed * 0.023D * (double)earth);
        int parry_all = parry_speed + parry_earth;
        int dex_constitution_per = (int)((double)(attrib - 2) * 0.3D + 4.0D);
        int dex_constitution = dex_constitution_per * mag_power;
        int[] dex_attribs = new int[]{80, 239, 452, 699, 983, 1303, 1658, 2049, 2476, 2939, 3337, 3861, 4421, 5018};
        int dex_attrib = dex_attribs[0];
        int index;
        if (attrib >= 130) {
            dex_attrib = dex_attribs[13] + 60 * (attrib - 130);
        } else if (attrib > 1) {
            index = attrib / 10;
            dex_attrib = dex_attribs[index] + (dex_attribs[index + 1] - dex_attribs[index]) / 10 * (attrib % 10);
        }

        index = (int)((double)mag_power * 0.657D * (double)water);
        int dex_all = dex_constitution + dex_attrib + index;
        int def_constitution_per = (int)((double)(attrib - 2) * 0.3D + 5.0D);
        int def_constitution = def_constitution_per * constitution;
        int[] def_attribs = new int[]{100, 359, 727, 1177, 1712, 2281, 2971, 3746, 4604, 5546, 6571, 7569, 8751, 10016};
        int def_attrib = def_attribs[0];
//        int index;
        if (attrib >= 130) {
            def_attrib = def_attribs[13] + 127 * (attrib - 130);
        } else if (attrib > 1) {
            index = attrib / 10;
            def_attrib = def_attribs[index] + (def_attribs[index + 1] - def_attribs[index]) / 10 * (attrib % 10);
        }

        index = (int)((double)constitution * 1.4D * (double)water);
        int def_all = def_constitution + def_attrib + index;
        double[][] hs = new double[][]{{2.0D, 8.0D, 4.0D, 2.0D, 10.0D}, {1.3D, 8.0D, 9.0D, 2.0D, 2.6D}, {1.3D, 6.0D, 3.0D, 2.0D, 3.0D}, {2.0D, 1.7D, 7.0D, 2.0D, 6.3D}, {1.5D, 2.1D, 13.0D, 2.0D, 7.0D}};
        attributes[0] = (int)((double)def_all * hs[polar - 1][0]);
        attributes[1] = (int)((double)dex_all * hs[polar - 1][0]);
        attributes[2] = (int)((double)accurate_all * hs[polar - 1][1]);
        attributes[3] = (int)((double)mana_all * hs[polar - 1][2]);
        attributes[4] = (int)((double)parry_all * hs[polar - 1][3]);
        attributes[5] = (int)((double)wiz_all * hs[polar - 1][4]);
        return attributes;
    }
}
