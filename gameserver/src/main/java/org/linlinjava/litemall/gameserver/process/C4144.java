package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C4144 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        final String room_name = GameReadTool.readString(buff);

        int isTaskWalk = GameReadTool.readByte(buff);
        final GameObjectChar session = GameObjectChar.getGameObjectChar();
        final Chara chara = session.chara;
        final GameMap gameMap = GameLine.getGameMap(chara.line, room_name);

        if(!chara.mapName.equals(room_name)){
            final List<NpcPoint> list = GameData.that.baseNpcPointService.findByMapname(room_name);
            for (NpcPoint npcPoint : list) {
                if(npcPoint.getDoorname().equals(chara.mapName)){
                    chara.x = npcPoint.getInx();
                    chara.y = npcPoint.getIny();
                }
            }
        }
        gameMap.join(session);
    }

    public Vo_65505_0 a65505(Chara chara) {
        Vo_65505_0 vo_65505_1 = new Vo_65505_0();
        vo_65505_1.map_id = chara.mapid;
        vo_65505_1.map_name = chara.mapName;
        vo_65505_1.map_show_name = chara.mapName;
        vo_65505_1.x = chara.x;
        vo_65505_1.y = chara.y;
        vo_65505_1.map_index = 50331648;
        vo_65505_1.compact_map_index = 49408;
        vo_65505_1.floor_index = 0;
        vo_65505_1.wall_index = 0;
        vo_65505_1.is_safe_zone = 0;
        vo_65505_1.is_task_walk = 0;
        vo_65505_1.enter_effect_index = 0;
        return vo_65505_1;
    }

    @Override
    public int cmd() {
        return 4144;
    }
}
