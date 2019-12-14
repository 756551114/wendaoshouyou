package org.linlinjava.litemall.gameserver.fight;

import java.util.ArrayList;
import java.util.List;

public class FightTeam {
    public List<FightObject> fightObjectList = new ArrayList<>();
    public int leader;
    public int type;
    public void add(FightObject fo){
        fightObjectList.add(fo);
    }
}
