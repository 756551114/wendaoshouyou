package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.fight.*;

import java.util.ArrayList;
import java.util.List;

public class DoubleHitSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();

        return resultList;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
