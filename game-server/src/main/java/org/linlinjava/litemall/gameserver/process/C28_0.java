package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;



@Service
public class C28_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {


        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        GameObjectChar.getGameObjectChar().gameTeam = GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id).gameTeam;

        final GameObjectChar session1 = GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id);

        GameObjectChar.getGameObjectChar().gameTeam.duiwu.add(chara);
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id);
            session.gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
        }
//        session1.gameMap.join();
        GameObjectChar.getGameObjectChar().gameMap.joinduiyuan(GameObjectChar.getGameObjectChar(), session1.chara);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size(); i++) {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i).id);
            for (int j = 0; j < session.gameTeam.zhanliduiyuan.size(); j++) {
                if (session.gameTeam.zhanliduiyuan.get(j).id == chara.id) {
                    session.gameTeam.zhanliduiyuan.get(j).memberteam_status = 1;
                }
            }
        }
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61661_0 vo_61661_0 = GameUtil.a61661(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M61661_0(), vo_61661_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = chara.name + "回到队伍中";
            vo_8165_0.active = 0;
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M8165_0(), vo_8165_0);
        }

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id).gameTeam.duiwu.get(0).id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(3);
        session1.gameMap.send(new M61671_0(), vo_61671_0);

        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(5);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = chara.name + "回到了队伍。";
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);
        vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = chara.name + "你回到了#Y#<" + session1.chara.name + "#>#n的队伍。";
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);

        GameUtil.a4119(gameTeam.duiwu);
        GameUtil.a4121(gameTeam.zhanliduiyuan);


        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(5);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);


         vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id).gameTeam.duiwu.get(0).id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(2);
        vo_61671_0.list.add(3);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);

    }

    @Override
    public int cmd() {
        return 28;
    }
}