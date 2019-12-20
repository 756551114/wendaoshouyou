package org.linlinjava.litemall.gameserver.fight;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.netty.ServerHandler;

public class VipAddUils {

    public static double getUserVipAdd(ChannelHandlerContext ctx){
        try {
            Attribute<GameObjectChar> attr = ctx.channel().attr(ServerHandler.akey);
            GameObjectChar gameObjectChar = attr.get();
            return GameData.that.baseVipAddService.getUserAdd(gameObjectChar.accountid).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN;
        }

    }
}
