package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;

@Service
public class C20736_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {


        String select = GameReadTool.readString(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;

        Characters characters = GameData.that.characterService.findOneByID(GameObjectChar.getGameObjectChar().upduizhangid);
        String data = characters.getData();
        Chara chara1 = JSONUtils.parseObject(data, Chara.class);
        if (select.equals("0")) {
            Vo_61591_0 vo_61591_0 = new Vo_61591_0();
            vo_61591_0.ask_type = "request_team_leader";
            vo_61591_0.name = chara1.name;
            GameObjectChar.send(new M61591_0(), vo_61591_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "队长拒绝了你的带队申请。";
            vo_8165_0.active = 0;
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().upduizhangid).send(new M8165_0(), vo_8165_0);

        }
        if (select.equals("1")) {
            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_join";
            GameObjectChar.send(new M61593_0(), vo_61593_0);
            vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_team_leader";
            GameObjectChar.send(new M61593_0(), vo_61593_0);

            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
            int index = 0;
            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                if (gameTeam.duiwu.get(i).id == chara1.id) {
                    index = i;
                }
            }

            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(i).id).gameTeam.duiwu.set(index, chara);
                GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(i).id).gameTeam.duiwu.set(0, GameObjectCharMng.getGameObjectChar(chara1.id).chara);
                if (i != index) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = gameTeam.duiwu.get(0).name + "成为队长。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);
                }
            }
            Vo_4121_0 vo_4121_0 = gameTeam.zhanliduiyuan.get(0);
            Vo_4121_0 vo_4121_1 = gameTeam.zhanliduiyuan.get(index);
            for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).gameTeam.zhanliduiyuan.set(0, vo_4121_1);
                GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).gameTeam.zhanliduiyuan.set(index, vo_4121_0);
            }
            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";



            GameObjectChar.send(new M20568_0(), vo_20568_0);
            vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20568_0(), vo_20568_0);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "你被提升为队长。";
            vo_20481_0.time = 1562987118;
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20481_0(), vo_20481_0);


            GameUtil.a4119(gameTeam.duiwu);
            GameUtil.a4121(gameTeam.zhanliduiyuan);


        }
    }

    @Override
    public int cmd() {
        return 20736;
    }
}