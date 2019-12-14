package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class C4128_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);


        List<Chara> list = new LinkedList();
        list.addAll(GameObjectChar.getGameObjectChar().gameTeam.duiwu);


        Chara chararemove = null;
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            if (chara.id == GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id) {
                chararemove = GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);

            }
        }

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).gameTeam.duiwu.remove(chararemove);
        }

        list.remove(chararemove);
        GameUtil.a4119(list);
        List<Vo_4119_0> object1 = new ArrayList<>();
        GameObjectChar.send(new M4119_0(), object1);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size(); i++) {
            if (chara.id == GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i).id) {
                GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i).memberteam_status = 2;
            }
        }
        GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);


        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61661_0 vo_61661_0 = GameUtil.a61661(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M61661_0(), vo_61661_0);
            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M20568_0(), vo_20568_0);
        }

        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = chara.name + "暂离了队伍。";
        vo_20480_0.time = 1562593376;
        GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0).id).sendOne(new M20480_0(), vo_20480_0);


        vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = "你暂时离开了#Y#<" + GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0).name + "#>#n的队伍。";
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);



    }

    @Override
    public int cmd() {
        return 4128;
    }
}