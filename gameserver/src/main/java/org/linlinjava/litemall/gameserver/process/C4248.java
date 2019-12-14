package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;
import org.linlinjava.litemall.gameserver.data.write.M65529_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

@Service
public class C4248 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        final int id = GameReadTool.readInt(buff);
        final int x = GameReadTool.readShort(buff);
        final int y = GameReadTool.readShort(buff);
        final int taskwalk = GameReadTool.readShort(buff);
        final Chara chara = GameObjectChar.getGameObjectChar().chara;
        Characters characters = GameData.that.characterService.findOneByID(id);
        String data = characters.getData();
        Chara chara1 = JSONUtils.parseObject(data, Chara.class);
        chara1.x = chara.x;
        chara1.y = chara.y;
        chara1.mapid = chara.mapid;
        chara1.mapName = chara.mapName;

        GameLine.getGameMap(chara.line, chara.mapName).joinduiyuan(GameObjectCharMng.getGameObjectChar(chara1.id), chara);

        for (int i = 0; i < chara.npcchubao.size(); i++) {
            if (chara1.mapid == chara.npcchubao.get(i).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcchubao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcshuadao.size(); i++) {
            if (chara1.mapid == chara.npcshuadao.get(i).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcshuadao.get(i), chara.id);

            }
        }


        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara1.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(5);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(3);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);

    }

    public Vo_65505_0 a65505(Chara chara) {
        Vo_65505_0 vo_65505_1 = new Vo_65505_0();
        vo_65505_1.map_id = chara.mapid;
        vo_65505_1.map_name = GameData.that.baseMapService.findOneByMapId(chara.mapid).getName();
        vo_65505_1.map_show_name = vo_65505_1.map_name;
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
        return 4248;
    }
}