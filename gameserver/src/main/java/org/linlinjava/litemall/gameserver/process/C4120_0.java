package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
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
public class C4120_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String peer_name = GameReadTool.readString(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Chara chara1 = null;
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            if (GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).name.equals(peer_name)) {
                chara1 = GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);
            }
        }

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 0;
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M61671_0(), vo_61671_0);
        }
        List<Vo_4119_0> object1 = new ArrayList<>();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M4119_0(), object1);
        List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M4121_0(), vo_4121_0List);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你被请离了队伍。";
        vo_20481_0.time = 1562987118;
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20481_0(), vo_20481_0);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61661_0 vo_61661_0 = GameUtil.a61661(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M61661_0(), vo_61661_0);
            vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = peer_name + "离开了队伍。。";
            vo_20481_0.time = 1562987118;
            if (GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id != chara1.id) {
                GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M20481_0(), vo_20481_0);
            } else {
                GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).gameTeam.duiwu.remove(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
                GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i).id).gameTeam.zhanliduiyuan.remove(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i));
                GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam = null;
            }

        }

        Vo_20568_0 vo_20568_0 = new Vo_20568_0();
        vo_20568_0.gid = "";
        GameObjectChar.send(new M20568_0(), vo_20568_0);
        GameUtil.a4119(GameObjectChar.getGameObjectChar().gameTeam.duiwu);
        GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
        Vo_49189_0 vo_49189_0 = new Vo_49189_0();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M49189_0(), vo_49189_0);

        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "你被请离了队伍";
        vo_8165_0.active = 0;
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M8165_0(), vo_8165_0);

        Vo_45124_0 vo_45124_0 = new Vo_45124_0();
        GameObjectChar.getGameObjectChar().send(new M45124_0(), vo_45124_0);
    }

    @Override
    public int cmd() {
        return 4120;
    }
}