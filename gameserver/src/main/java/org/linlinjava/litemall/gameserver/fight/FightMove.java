//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.HashMap;
import java.util.Map;

public class FightMove {
    public int id;
    public int curMove;
    public int nextMove;
    public static final Map<Integer, FightMove> MOVE_MAP = new HashMap();

    public FightMove() {
    }

    public static boolean move(int id) {
        FightMove fightMove = (FightMove)MOVE_MAP.get(id);
        if (fightMove == null) {
            fightMove = new FightMove();
            fightMove.curMove = 0;
            fightMove.nextMove = 5 + FightManager.RANDOM.nextInt(10);
            MOVE_MAP.put(id, fightMove);
            return false;
        } else {
            ++fightMove.curMove;
            if (fightMove.curMove >= fightMove.nextMove) {
                fightMove.curMove = 0;
                fightMove.nextMove = 5 + FightManager.RANDOM.nextInt(10);
                return true;
            } else {
                return false;
            }
        }
    }
}
