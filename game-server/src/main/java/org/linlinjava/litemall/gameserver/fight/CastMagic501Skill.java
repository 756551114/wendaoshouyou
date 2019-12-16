package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19945_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;
import org.linlinjava.litemall.gameserver.data.write.M19945_0;
import org.linlinjava.litemall.gameserver.data.write.M64989_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class CastMagic501Skill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();
        int attaNum = jiNeng.range;
        final FightObject attFightObject = FightManager.getFightObject(fightContainer, fightRequest.id);

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = 2;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        boolean fabao = true;
        final FightFabaoSkill fabaoSkill = attFightObject.getFabaoSkill();
        float jiabei = 1;
        if (fabaoSkill != null) {
            if(fabaoSkill.getStateType() == 8398 && fabaoSkill.isActive()){
                fabao = false;
                fabaoSkill.sendEffect(fightContainer);
            }
            if(fabaoSkill.getStateType() == 8016 && fabaoSkill.isActive()){
                fabaoSkill.sendEffect(fightContainer);
                jiabei = 2.5f;
            }

        }

        final List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 1, attaNum);
        Vo_19945_0 vo_19945_0 = new Vo_19945_0();
        vo_19945_0.id = fightRequest.vid;
        vo_19945_0.hid = fightRequest.id;
        vo_19945_0.para_ex = 0;
        vo_19945_0.missed = 1;
        vo_19945_0.para = 0;
        vo_19945_0.damage_type = 1;
        FightManager.send(fightContainer, new M19945_0(), vo_19945_0);



        final Vo_64989_0 vo_64989_0 = new Vo_64989_0();
        vo_64989_0.hid = fightRequest.id;
        vo_64989_0.a =1;

        for (FightObject fightObject : targetList) {
            vo_64989_0.list.add(fightObject.fid);
            vo_64989_0.missList.add(1);
        }
        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);



        int hurt = 0;
        for (FightObject fightObject : targetList) {
            if(hurt == 0){
                int addHurt = BattleUtils.skillAttack(attFightObject.accurate+attFightObject.accurate_ext, jiNeng.skill_level, "WS", jiNeng.skill_no - 501);
                addHurt = (int) (addHurt * jiabei);
                final int thurt = BattleUtils.battle(attFightObject.accurate+attFightObject.accurate_ext,addHurt,fightObject.fangyu+fightObject.fangyu_ext);
                hurt = thurt;
            }else{
                hurt = (int) (hurt*0.9);
            }
            int showhurt = fightObject.reduceShengming(hurt,fabao);
            final FightResult fightResult = new FightResult();
            fightResult.id = fightRequest.id;
            fightResult.vid = fightObject.fid;
            fightResult.point = -showhurt;
            fightResult.effect_no = 0;
            fightResult.damage_type = 4097;
            resultList.add(fightResult);
        }

        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
