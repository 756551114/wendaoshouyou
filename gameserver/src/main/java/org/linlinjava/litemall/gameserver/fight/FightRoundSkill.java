package org.linlinjava.litemall.gameserver.fight;

public abstract class FightRoundSkill implements FightSkill {
    protected FightObject buffObject = null;
    protected int removeRound;
    protected FightContainer fightContainer;
    public boolean disappear(FightContainer fightContainer) {
        if (removeRound <= fightContainer.round) {
            doDisappear();
            buffObject.removeBuffState(fightContainer, getStateType());
            return true;
        }
        return false;
    }

    protected abstract void doRoundSkill();
    protected abstract void doDisappear();
}
