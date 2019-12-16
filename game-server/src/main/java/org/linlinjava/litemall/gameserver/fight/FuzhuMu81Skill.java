//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19945_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7655_0;
import org.linlinjava.litemall.gameserver.data.write.M19945_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.data.write.M64989_0;
import org.linlinjava.litemall.gameserver.data.write.M7655_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

public class FuzhuMu81Skill extends FightRoundSkill {
    boolean use = false;

    public FuzhuMu81Skill() {
    }

    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList();
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
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
        vo_64989_0.a = 2;
        List<FightObject> targetList = findTarget(fightContainer, fightRequest, 2, jiNeng.range);
        Iterator var9 = targetList.iterator();

        FightObject fightObject;
        while(var9.hasNext()) {
            fightObject = (FightObject)var9.next();
            vo_64989_0.list.add(fightObject.fid);
        }

        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);
        var9 = targetList.iterator();

        while(var9.hasNext()) {
            fightObject = (FightObject)var9.next();
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 43;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            fightObject.addBuffState(fightContainer, this.getStateType());
            FuzhuMu81Skill that = new FuzhuMu81Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
            that.removeRound = fightContainer.round + jiNeng.skillRound;
            that.fightContainer = fightContainer;
            if (fightObject.isDead()) {
                that.doRoundSkill();
                fightObject.removeSkill(that);
                fightObject.removeBuffState(fightContainer, this.getStateType());
            } else {
                int jiaxue = (int)BattleUtils.extAdd(jiNeng.skill_level, jiNeng.skill_no);
                int xueliang = fightObject.max_shengming * jiaxue / 100;
                xueliang = fightObject.addShengming(xueliang);
                fightObject.update(fightContainer);
                FightResult fightResult = new FightResult();
                fightResult.id = fightRequest.id;
                fightResult.vid = fightObject.fid;
                fightResult.point = xueliang;
                fightResult.effect_no = 10005;
                fightResult.damage_type = 0;
                resultList.add(fightResult);
            }
        }

        return resultList;
    }

    protected void doRoundSkill() {
        if (!this.use && this.buffObject.state == 2) {
            Vo_19959_0 vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = this.fightContainer.round;
            vo_19959_0.aid = this.buffObject.fid;
            vo_19959_0.action = 0;
            vo_19959_0.vid = this.buffObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(this.fightContainer, new M19959_0(), vo_19959_0);
            this.buffObject.state = 1;
            int blood = this.buffObject.max_shengming / 5;
            this.buffObject.shengming = blood;
            this.buffObject.revive(this.fightContainer);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = this.buffObject.fid;
            FightManager.send(this.fightContainer, new M7655_0(), vo_7655_0);
            this.use = true;
            this.buffObject.removeBuffState(this.fightContainer, this.getStateType());
        }

    }

    protected void doDisappear() {
    }

    public int getStateType() {
        return 528128;
    }

    public static List<FightObject> findTarget(FightContainer fightContainer, FightRequest fightRequest, int type, int num) {
        List<FightObject> fightObjects = new ArrayList();
        List<FightTeam> teamList = fightContainer.teamList;
        List<FightObject> friendsFightTeam = null;
        Iterator iterator = teamList.iterator();

        while(iterator.hasNext()) {
            FightTeam fightTeam = (FightTeam)iterator.next();
            List<FightObject> fightObjectList = fightTeam.fightObjectList;
            Iterator var10 = fightObjectList.iterator();

            while(var10.hasNext()) {
                FightObject fightObject = (FightObject)var10.next();
                if (fightObject.fid == fightRequest.id) {
                    friendsFightTeam = new ArrayList(fightTeam.fightObjectList);
                }
            }
        }

        iterator = friendsFightTeam.iterator();

        FightObject newTarget;
        while(iterator.hasNext()) {
            newTarget = (FightObject)iterator.next();
            if (newTarget.fid == fightRequest.vid) {
                --num;
                fightObjects.add(newTarget);
                iterator.remove();
            }
        }

        for(int i = 0; i < num && friendsFightTeam.size() != 0; ++i) {
            newTarget = (FightObject)friendsFightTeam.remove(FightManager.RANDOM.nextInt(friendsFightTeam.size()));
            fightObjects.add(newTarget);
        }

        return fightObjects;
    }
}
