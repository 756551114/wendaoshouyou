package org.linlinjava.litemall.gameserver.fight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FightContainer {
    public int id = 1000;
    public List<FightResult> resultList = new ArrayList<>();
    public int round = 1;
    public AtomicInteger state = new AtomicInteger(1);
    public List<FightTeam> teamList = new ArrayList<>();
    public List<FightObject> doActionList;
    public long roundTime = System.currentTimeMillis();
}
