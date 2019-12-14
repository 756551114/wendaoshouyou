package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19945_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.write.M19945_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class NormalAttackSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        final int id = fightRequest.id;
        final FightObject fightObject = FightManager.getFightObject(fightContainer, id);
        final FightObject victimFightObject = FightManager.getFightObject(fightContainer, fightRequest.vid);
        boolean fabao = true;
        final FightFabaoSkill fabaoSkill = fightObject.getFabaoSkill();
        float jiabei = 1;
        if (fabaoSkill != null) {
            if(fabaoSkill.getStateType() == 8398 && fabaoSkill.isActive()){
                fabao = false;
            }
            if(fabaoSkill.getStateType() == 8016 && fabaoSkill.isActive()){
                fabaoSkill.sendEffect(fightContainer);
                jiabei = 2.5f;
            }
        }

        Vo_19945_0 vo_19945_0 = new Vo_19945_0();
        vo_19945_0.id = fightRequest.vid;
        vo_19945_0.hid = fightRequest.id;
        vo_19945_0.para_ex = 0;
        vo_19945_0.missed = 1;
        vo_19945_0.para = 0;
        vo_19945_0.damage_type = 1;
        FightManager.send(fightContainer, new M19945_0(), vo_19945_0);


        int hurt = BattleUtils.battle(fightObject.accurate+fightObject.accurate_ext,0,  victimFightObject.fangyu+victimFightObject.fangyu_ext);
        hurt = (int) (hurt * jiabei);
        hurt = victimFightObject.reduceShengming(hurt,fabao);

        final FightResult fightResult = new FightResult();
        fightResult.id = fightRequest.id;
        fightResult.vid = fightRequest.vid;
        fightResult.point = -hurt;
        fightResult.effect_no = 0;
        fightResult.damage_type = 1;
        resultList.add(fightResult);
        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
