package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19945_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7655_0;
import org.linlinjava.litemall.gameserver.data.write.M19945_0;
import org.linlinjava.litemall.gameserver.data.write.M64989_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.data.write.M7655_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CastMagic11Skill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();
        int attaNum = jiNeng.range;

        final FightObject attFightObject = FightManager.getFightObject(fightContainer, fightRequest.id);
        List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 1, attaNum);

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = 3;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        int attTimes = 1;
        boolean fabao = true;
        FightFabaoSkill fabaoSkill = attFightObject.getFabaoSkill();
        if (fabaoSkill != null) {
            if (fabaoSkill.getStateType() == 8013 && fabaoSkill.isActive()) {
                fabaoSkill.sendEffect(fightContainer);
                attTimes = 2;
            }
            if (fabaoSkill.getStateType() == 8398 && fabaoSkill.isActive()) {
                fabaoSkill.sendEffect(fightContainer);
                fabao = false;
            }
        }
        if (attFightObject.isActiveTianshu(fightContainer, 7041)) {
            attTimes = 2;
            attFightObject.fightRequest = fightRequest;
        }
        int hurt = 0;
        float jiabei = 1;
        if (attTimes != 2 && jiabei == 1 && attFightObject.isActiveTianshu(fightContainer, 7036)) {
            jiabei = 1.5f;
        }
        if (attTimes != 2 && jiabei == 1 && attFightObject.isActiveTianshu(fightContainer, 7039)) {
            jiabei = 1.5f;
        }


        Vo_19945_0 vo_19945_0 = new Vo_19945_0();
        vo_19945_0.id = fightRequest.vid;
        vo_19945_0.hid = fightRequest.id;
        vo_19945_0.para_ex = 0;
        vo_19945_0.missed = 1;
        vo_19945_0.para = 0;
        vo_19945_0.damage_type = 2;
        FightManager.send(fightContainer, new M19945_0(), vo_19945_0);
        Vo_64989_0 vo_64989_0 = new Vo_64989_0();
        vo_64989_0.hid = fightRequest.id;
        vo_64989_0.a = 1;

        for (FightObject fightObject : targetList) {
            vo_64989_0.list.add(fightObject.fid);
            vo_64989_0.missList.add(1);
        }
        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);



        for (FightObject fightObject : targetList) {
            if (hurt == 0) {
                int addHurt = BattleUtils.skillAttack(attFightObject.fashang + attFightObject.fashang_ext, jiNeng.skill_level, "FS", jiNeng.skill_no);
                addHurt = (int) (addHurt * jiabei);
                final int thurt = BattleUtils.battle(attFightObject.fashang + attFightObject.fashang_ext, addHurt, fightObject.fangyu + fightObject.fangyu_ext);
                hurt = thurt;
            } else {
                hurt = (int) (hurt * 0.9);
            }
            fabaoSkill = fightObject.getFabaoSkill();
            if (!fabao && fabaoSkill != null) {
                if (fabaoSkill.getStateType() == 8014 && fabaoSkill.isActive()) {
                    fabaoSkill.sendEffect(fightContainer);
                    List<FightObject> exclude = new ArrayList();
                    exclude.add(attFightObject);
                    exclude.add(fightObject);
                    final FightObject randomObject = FightManager.getRandomObject(fightContainer, exclude);
                    int showhurt = randomObject.reduceShengming(hurt, false);
                    final FightResult fightResult = new FightResult();
                    fightResult.id = fightRequest.id;
                    fightResult.vid = randomObject.fid;
                    fightResult.point = -showhurt;
                    fightResult.effect_no = 0;
                    fightResult.damage_type = 2;
                    resultList.add(fightResult);
                    continue;
                }
            }
            int showhurt = fightObject.reduceShengming(hurt, fabao);


            final FightResult fightResult = new FightResult();
            fightResult.id = fightRequest.id;
            fightResult.vid = fightObject.fid;
            fightResult.point = -showhurt;
            fightResult.effect_no = 0;
            fightResult.damage_type = 2;
            resultList.add(fightResult);
        }

        if (attTimes == 2) {
            if (resultList != null) {
                for (FightResult fightResult : resultList) {
                    FightManager.send_LIFE_DELTA(fightContainer, fightResult);
                }
            }
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = attFightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            final Iterator<FightObject> iterator = targetList.iterator();
            int remove = 0;
            while (iterator.hasNext()) {
                FightObject next = iterator.next();
                if (next.isDead()) {
                    iterator.remove();
                    remove++;
                }
            }
            final List<FightObject> fightObjectList = FightManager.getFightTeamDM(fightContainer, attFightObject.fid).fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (remove == 0) {
                    break;
                }
                if (!fightObject.isDead() && !targetList.contains(fightObject)) {
                    targetList.add(fightObject);
                    remove--;
                }
            }
            if(FightManager.getFightObject(fightContainer,fightRequest.vid).isDead()){
                if(targetList.size()>0){
                    fightRequest.vid = targetList.get(0).fid;
                }
            }

            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightRequest.id;
            vo_19959_0.action = 3;
            vo_19959_0.vid = fightRequest.vid;
            vo_19959_0.para = fightRequest.para;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);


            vo_19945_0 = new Vo_19945_0();
            vo_19945_0.id = fightRequest.vid;
            vo_19945_0.hid = fightRequest.id;
            vo_19945_0.para_ex = 0;
            vo_19945_0.missed = 1;
            vo_19945_0.para = 0;
            vo_19945_0.damage_type = 2;
            FightManager.send(fightContainer, new M19945_0(), vo_19945_0);
            vo_64989_0 = new Vo_64989_0();
            vo_64989_0.hid = fightRequest.id;
            vo_64989_0.a = 1;

            for (FightObject fightObject : targetList) {
                vo_64989_0.list.add(fightObject.fid);
                vo_64989_0.missList.add(1);
            }
            FightManager.send(fightContainer, new M64989_0(), vo_64989_0);

            resultList = new ArrayList<>();
            hurt = 0;
            for (FightObject fightObject : targetList) {
                if (hurt == 0) {
                    final int addHurt = BattleUtils.skillAttack(attFightObject.fashang + attFightObject.fashang_ext, jiNeng.skill_level, "FS", jiNeng.skill_no);
                    final int thurt = BattleUtils.battle(attFightObject.fashang + attFightObject.fashang_ext, addHurt, fightObject.fangyu + fightObject.fangyu_ext);
                    hurt = thurt;
                } else {
                    hurt = (int) (hurt * 0.9);
                }
                int showhurt = fightObject.reduceShengming(hurt, fabao);


                final FightResult fightResult = new FightResult();
                fightResult.id = fightRequest.id;
                fightResult.vid = fightObject.fid;
                fightResult.point = -showhurt;
                fightResult.effect_no = 0;
                fightResult.damage_type = 2;
                resultList.add(fightResult);
            }
        }


        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }
}
