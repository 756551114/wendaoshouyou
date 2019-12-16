package org.linlinjava.litemall.gameserver.game;

import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.domain.Chara;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameTeam {
    public List<List<Chara>> liebiao = new LinkedList<>();

    public List<Chara> duiwu = new LinkedList<>();

    public List<Vo_4121_0> zhanliduiyuan = new LinkedList<>();
}
