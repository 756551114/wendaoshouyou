package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.fight.FightFabaoSkill;

public class DinghaizhuSkill extends FightFabaoSkill {


    @Override
    public int getStateType() {
        return 8015;
    }

    @Override
    public int getTimes() {
        return (level+3)/4;
    }
}
