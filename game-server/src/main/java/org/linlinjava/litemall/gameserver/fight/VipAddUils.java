package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

public class VipAddUils {

    public static double getUserVipAdd(){
        try {
            return GameData.that.baseVipAddService.getUserAdd(GameObjectChar.getGameObjectChar().accountid).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN;
        }

    }
}
