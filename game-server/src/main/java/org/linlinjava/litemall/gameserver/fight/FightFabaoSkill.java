//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.List;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12028_0;
import org.linlinjava.litemall.gameserver.data.write.M12028_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

public abstract class FightFabaoSkill implements FightSkill {
    protected FightObject buffObject = null;
    protected FightContainer fightContainer;
    public int level;
    public int qinmi;
    private int times = 0;

    public FightFabaoSkill() {
    }

    public void active() {
        this.times = 1;
    }

    public abstract int getTimes();

    public void resetTimes() {
        this.times = 0;
    }

    public boolean isActive() {
        if (this.times > 0) {
            --this.times;
            return true;
        } else {
            return false;
        }
    }

    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        return null;
    }

    public void sendEffect(FightContainer fightContainer) {
        Vo_12028_0 vo_12028_0 = new Vo_12028_0();
        vo_12028_0.id = this.buffObject.fid;
        vo_12028_0.effect_no = this.getStateType();
        vo_12028_0.type = 0;
        FightManager.send(fightContainer, new M12028_0(), vo_12028_0);
    }
}
