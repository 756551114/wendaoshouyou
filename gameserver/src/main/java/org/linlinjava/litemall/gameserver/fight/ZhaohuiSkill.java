package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64971_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7653_0;
import org.linlinjava.litemall.gameserver.data.write.M19959_0;
import org.linlinjava.litemall.gameserver.data.write.M7653_0;
import org.linlinjava.litemall.gameserver.data.write.M64971_0;
import org.linlinjava.litemall.gameserver.data.write.M64945_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;

import java.util.ArrayList;
import java.util.List;

public class ZhaohuiSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        final FightObject fightObject = FightManager.getFightObject(fightContainer, fightRequest.vid);
        if (fightObject.type != 2) {
            return null;
        }
        Vo_7653_0 vo_7653_0 = new Vo_7653_0();
        vo_7653_0.id = fightObject.fid;
        FightManager.send(fightContainer, new M7653_0(), vo_7653_0);

        Vo_64971_0 vo_64971_0 = new Vo_64971_0();
        vo_64971_0.id = fightObject.id;
        vo_64971_0.haveCalled = 0;
        FightManager.send(fightContainer, new M64945_0(), vo_64971_0);

        FightManager.remove(fightContainer,fightObject);

        vo_64971_0 = new Vo_64971_0();
        vo_64971_0.count = 1;
        vo_64971_0.id = fightObject.id;
        vo_64971_0.haveCalled = 0;
        GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M64971_0(), vo_64971_0);


        List<FightResult> resultList = new ArrayList<>();
        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
