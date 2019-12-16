package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8711_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.data.write.M8711_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class FleeSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();

        final int id = fightRequest.id;
        final FightObject fightObject = FightManager.getFightObject(id);
        final FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, fightObject);
        fightObject.run = true;

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        M8711_0 msg = new M8711_0();
        Vo_8711_0 vo_8711_0 = new Vo_8711_0();
        vo_8711_0.id = id;
        vo_8711_0.success = 1;
        vo_8711_0.die = 0;

        FightManager.send(fightContainer,msg,vo_8711_0);

        if(fightObjectPet !=null){
            fightObjectPet.state = 3;

            msg = new M8711_0();
            vo_8711_0 = new Vo_8711_0();
            vo_8711_0.id = fightObjectPet.id;
            vo_8711_0.success = 1;
            vo_8711_0.die = 0;

            FightManager.send(fightContainer,msg,vo_8711_0);
        }

        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }
}
