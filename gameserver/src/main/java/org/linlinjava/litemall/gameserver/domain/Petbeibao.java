package org.linlinjava.litemall.gameserver.domain;

import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0;
import org.linlinjava.litemall.gameserver.process.GameUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Petbeibao {

    public int no;
    public int id;
    public List<PetShuXing> petShuXing = new LinkedList<>();
    public List<Vo_12023_0> tianshu = new LinkedList<>();
    public int autofight_select = 0;
    public int autofight_skillaction = 2;
    public int autofight_skillno = 2;

    public void PetCreate(Pet pet, Chara chara, int suiji, int penetrate) {
        PetShuXing shuXing = new PetShuXing();
        shuXing.type = pet.getIcon();
        shuXing.passive_mode = pet.getIcon();
        shuXing.attrib = pet.getLevelReq();
        shuXing.str = pet.getName();
        shuXing.skill = 1;
        id = GameUtil.getCard(chara);
        no = GameUtil.getNo(chara, 1);
        shuXing.pot = 0;
        shuXing.resist_poison = 258;
        shuXing.martial = 15000;
        shuXing.double_hit = 100;
        shuXing.suit_polar = pet.getName();
        shuXing.auto_fight = shuXing.auto_fight + id;
        if (pet.getPolar().equals("金")) {
            shuXing.metal = 1;
        }
        if (pet.getPolar().equals("木")) {
            shuXing.metal = 2;
        }
        if (pet.getPolar().equals("水")) {
            shuXing.metal = 3;
        }
        if (pet.getPolar().equals("火")) {
            shuXing.metal = 4;
        }
        if (pet.getPolar().equals("土")) {
            shuXing.metal = 5;
        }
        shuXing.mana_effect = pet.getLife() - 40 - subtraction(suiji);
        shuXing.attack_effect = pet.getMana() - 40 - subtraction(suiji);
        shuXing.mag_effect = pet.getPhyAttack() - 40 - subtraction(suiji);
        shuXing.phy_absorb = pet.getMagAttack() - 40 - subtraction(suiji);
        shuXing.phy_effect = pet.getSpeed() - 40 - subtraction(suiji);
        shuXing.pet_mana_shape = shuXing.mana_effect + 40;
        shuXing.pet_speed_shape = shuXing.attack_effect + 40;
        shuXing.pet_phy_shape = shuXing.phy_effect + 40;
        shuXing.pet_mag_shape = shuXing.mag_effect + 40;
        shuXing.rank = shuXing.phy_absorb + 40;
        shuXing.resist_point = shuXing.pet_mana_shape + shuXing.pet_speed_shape + shuXing.pet_phy_shape + shuXing.pet_mag_shape + shuXing.rank;


        shuXing.penetrate = penetrate;
        shuXing.polar_point = 4;

        shuXing.enchant_nimbus = 0;
        shuXing.max_enchant_nimbus = 0;
        shuXing.suit_light_effect = 0;
        shuXing.hide_mount = 0;
        shuXing.phy_power = 1;
        shuXing.mag_power = 1;
        shuXing.life = 1;
        shuXing.speed = 1;

        BasicAttributesUtils.petshuxing(shuXing);
        shuXing.max_life = shuXing.def;
        shuXing.max_mana = shuXing.dex;
        petShuXing.add(shuXing);

    }


    public void petCreate(Pet pet, Chara chara, int suiji) {
        PetShuXing shuXing = new PetShuXing();
        shuXing.type = pet.getIcon();
        shuXing.passive_mode = pet.getIcon();
        shuXing.attrib = pet.getLevelReq();
        shuXing.str = pet.getName();
        shuXing.skill = 1;
        id = GameUtil.getCard(chara);
        no = GameUtil.getNo(chara, 1);
        shuXing.pot = 0;
        shuXing.resist_poison = 258;
        shuXing.martial = 15000;
        shuXing.double_hit = 100;
        shuXing.suit_polar = pet.getName();
        shuXing.auto_fight = shuXing.auto_fight + id;
        if (pet.getPolar().equals("金")) {
            shuXing.metal = 1;
        }
        if (pet.getPolar().equals("木")) {
            shuXing.metal = 2;
        }
        if (pet.getPolar().equals("水")) {
            shuXing.metal = 3;
        }
        if (pet.getPolar().equals("火")) {
            shuXing.metal = 4;
        }
        if (pet.getPolar().equals("土")) {
            shuXing.metal = 5;
        }


        shuXing.mana_effect = pet.getLife() - 40 - subtraction(suiji);
        shuXing.attack_effect = pet.getMana() - 40 - subtraction(suiji);
        shuXing.mag_effect = pet.getPhyAttack() - 40 - subtraction(suiji);
        shuXing.phy_absorb = pet.getMagAttack() - 40 - subtraction(suiji);
        shuXing.phy_effect = pet.getSpeed() - 40 - subtraction(suiji);
        shuXing.pet_mana_shape = shuXing.mana_effect + 40;
        shuXing.pet_speed_shape = shuXing.attack_effect + 40;
        shuXing.pet_phy_shape = shuXing.phy_effect + 40;
        shuXing.pet_mag_shape = shuXing.mag_effect + 40;
        shuXing.rank = shuXing.phy_absorb + 40;
        shuXing.resist_point = shuXing.pet_mana_shape + shuXing.pet_speed_shape + shuXing.pet_phy_shape + shuXing.pet_mag_shape + shuXing.rank;
        petShuXing.add(shuXing);
    }

    public int subtraction(int i) {
        Random r = new Random();
        if (i == 0) {
            return 0;
        }
        return r.nextInt(i);
    }


}
