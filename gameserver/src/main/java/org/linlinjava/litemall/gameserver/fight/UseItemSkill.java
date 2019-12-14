package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_11719_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53717_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7655_0;
import org.linlinjava.litemall.gameserver.data.write.M53717_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.data.write.M11719_0;
import org.linlinjava.litemall.gameserver.data.write.M7655_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class UseItemSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        if (fightRequest.item_type != 9050) {
            return null;
        }

        final Vo_53717_0 vo_53717_0 = new Vo_53717_0();
        vo_53717_0.attacker_id = fightRequest.id;
        vo_53717_0.victim_id = fightRequest.vid;
        vo_53717_0.type = 4;
        vo_53717_0.result = 1;
        vo_53717_0.itemName = "血玲珑";
        FightManager.send(fightContainer, new M53717_0(), vo_53717_0);
        final Vo_11719_0 vo_11719_0 = new Vo_11719_0();
        vo_11719_0.id = fightRequest.vid;
        vo_11719_0.owner_id = fightRequest.vid;
        vo_11719_0.no = 1002;
        FightManager.send(fightContainer, new M11719_0(), vo_11719_0);

        List<FightResult> resultList = new ArrayList<>();
        final FightResult fightResult = new FightResult();
        final FightObject fightObject = FightManager.getFightObject(fightContainer, fightRequest.vid);
        int point = 39000;


        final int shengming = fightObject.addShengming(point);
        if (fightObject.state == 2) {
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 0;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            fightObject.state = 1;
            fightObject.revive(fightContainer);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        } else {
            fightResult.id = fightRequest.vid;
            fightResult.vid = fightRequest.vid;
            fightResult.point = shengming;
            resultList.add(fightResult);
        }


        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
