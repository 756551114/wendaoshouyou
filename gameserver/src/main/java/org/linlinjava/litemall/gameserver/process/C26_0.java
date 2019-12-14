package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C26_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;


        if (chara.id == gameTeam.duiwu.get(0).id) {
            for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                List<Vo_4119_0> object1 = new ArrayList<>();
                GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M4119_0(), object1);
                List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
                GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M4121_0(), vo_4121_0List);
                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = "队伍解散了。";
                vo_20480_0.time = 1562593376;
                GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M20480_0(), vo_20480_0);
                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = gameTeam.zhanliduiyuan.get(i).id;
                vo_61671_0.count = 0;
                GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
            }
//
            for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size() - 1; i++) {
                GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i + 1).id).gameTeam = null;
            }
            GameObjectChar.getGameObjectChar().gameTeam = null;
            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_join";
            GameObjectChar.send(new M61593_0(), vo_61593_0);


            vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_team_leader";
            GameObjectChar.send(new M61593_0(), vo_61593_0);
            List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
            GameObjectChar.send(new M4121_0(), vo_4121_0List);
            GameObjectChar.getGameObjectChar().gameTeam = null;
        } else {

            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 0;
            GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
            List<Vo_4119_0> object1 = new ArrayList<>();
            GameObjectChar.send(new M4119_0(), object1);
            List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
            GameObjectChar.send(new M4121_0(), vo_4121_0List);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你离开了队伍";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                Vo_61661_0 vo_61661_0 = GameUtil.a61661(gameTeam.duiwu.get(i));
                GameObjectChar.send(new M61661_0(), vo_61661_0);
            }

            Vo_49189_0 vo_49189_0 = new Vo_49189_0();
            GameObjectChar.send(new M49189_0(), vo_49189_0);
            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                if (gameTeam.duiwu.get(i).id == chara.id) {
                    gameTeam.duiwu.remove(i);
                }
            }
            for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                if (gameTeam.zhanliduiyuan.get(i).id == chara.id) {
                    gameTeam.zhanliduiyuan.remove(i);
                }
            }
            List<Chara> duiwu = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
            GameUtil.a4119(duiwu);
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);

            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id).sendOne(new M20568_0(), vo_20568_0);

            for (int i = 0; i < duiwu.size(); i++) {
                vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = chara.name + "离开了队伍";
                vo_20480_0.time = 1562593376;
                GameObjectCharMng.getGameObjectChar(duiwu.get(i).id).sendOne(new M20480_0(), vo_20480_0);


                Vo_45124_0 vo_45124_0 = new Vo_45124_0();
                GameObjectCharMng.getGameObjectChar(duiwu.get(i).id).sendOne(new M45124_0(), vo_45124_0);
            }
        }
        GameObjectChar.getGameObjectChar().gameTeam = null;

    }

    @Override
    public int cmd() {
        return 26;
    }
}