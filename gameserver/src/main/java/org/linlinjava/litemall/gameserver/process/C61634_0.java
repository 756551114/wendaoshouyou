package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16431_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40981_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M16431_0;
import org.linlinjava.litemall.gameserver.data.write.M40981_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.fight.FightMove;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C61634_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int map_id = GameReadTool.readInt(buff);

        int map_index = GameReadTool.readInt(buff);

        int count = GameReadTool.readShort(buff);

        int x = 0;
        int y = 0;
        for (int i = 0; i < count; i++) {
//38
            x = GameReadTool.readShort(buff);
//110
            y = GameReadTool.readShort(buff);
        }


//2
        int dir = GameReadTool.readShort(buff);
//103756
        int send_time = GameReadTool.readInt(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (GameObjectChar.getGameObjectChar().gameTeam != null && GameObjectChar.getGameObjectChar().gameTeam.duiwu != null && GameObjectChar.getGameObjectChar().gameTeam.duiwu.size() > 0) {
            for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
                Chara chara1 = GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);
                chara1.x = x;
                chara1.y = y;
            }
        } else {
            GameObjectChar.getGameObjectChar().chara.x = x;
            GameObjectChar.getGameObjectChar().chara.y = y;
        }


        //广播回移动的消息
        Vo_16431_0 vo_16431_0 = new Vo_16431_0();
        vo_16431_0.id = id;
        vo_16431_0.x = x;
        vo_16431_0.y = y;
        GameObjectChar.getGameObjectChar().gameMap.send(new M16431_0(), vo_16431_0);
        if (chara.qumoxiang != 1) {
            if (FightMove.move(chara.id)) {
                FightManager.goFight(GameObjectChar.getGameObjectChar().chara, GameObjectChar.getGameObjectChar().chara.mapName);
                return;
            }
        }

        if (chara.changbaotu.mapid == chara.mapid && chara.changbaotu.x == chara.x && chara.changbaotu.y == y) {
            Vo_40981_0 vo_40981_0 = new Vo_40981_0();
            vo_40981_0.start_time = (int) (System.currentTimeMillis() / 1000);
            vo_40981_0.end_time = (int) (System.currentTimeMillis() / 1000) + 3;
            vo_40981_0.icon = 258;
            vo_40981_0.word = "挖宝中…";
            vo_40981_0.gather_style = "default";
            GameObjectChar.getGameObjectChar().send(new M40981_0(), vo_40981_0);
            chara.changbaotu = new Vo_65529_0();
        }

    }

    @Override
    public int cmd() {
        return 61634;
    }
}