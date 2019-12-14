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
import java.util.List;

public class FuzhuShui131Skill extends FightRoundSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
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

        final Vo_64989_0 vo_64989_0 = new Vo_64989_0();
        vo_64989_0.hid = fightRequest.id;
        vo_64989_0.a =2;

        final List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 2, jiNeng.range);
        for (FightObject fightObject : targetList) {
            vo_64989_0.list.add(fightObject.fid);
        }
        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);

        for (FightObject fightObject : targetList) {
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
            fightObject.addBuffState(fightContainer, getStateType());
            final FuzhuShui131Skill that = new FuzhuShui131Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
            that.removeRound = fightContainer.round + jiNeng.skillRound -1;
            int fangyu = (int) BattleUtils.extAdd(jiNeng.skill_level, jiNeng.skill_no);
            that.buffObject.fangyu_ext = that.buffObject.fangyu*fangyu/100;
        }

        return null;
    }

    @Override
    protected void doRoundSkill() {

    }

    @Override
    protected void doDisappear() {
        buffObject.fangyu_ext = 0;
    }

    @Override
    public int getStateType() {
        return 265984;
    }

}
