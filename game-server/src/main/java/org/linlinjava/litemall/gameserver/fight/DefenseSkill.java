package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class DefenseSkill extends FightRoundSkill  {
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

        final FightObject fightObject = FightManager.getFightObject(fightContainer,fightRequest.id);
        fightObject.addBuffState(fightContainer,getStateType());
        fightObject.addSkill(this);

        fightObject.fangyu_ext = fightObject.fangyu/2;
        buffObject = fightObject;

        return resultList;

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
        return 36608;
    }

}
