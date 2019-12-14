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

import java.util.List;

@Service
public class C4132_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String peer_name = GameReadTool.readString(buff);

        String ask_type = GameReadTool.readString(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        Characters characters = GameData.that.characterService.findOneByName(peer_name);
        String data = characters.getData();
        Chara chara1 = JSONUtils.parseObject(data, Chara.class);
        if (GameObjectChar.getGameObjectChar().gameTeam.duiwu.size() >= 5) {
            return;
        }
        if ("request_join".equals(ask_type)) {

            if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null) {
                if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "#Y#<" + peer_name + "#>#n已有队伍";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    return;
                }
            }

            List<Vo_61545_0> vo_61545_0List = GameUtil.a61545(chara1);
            GameObjectChar.send(new M61545_0(), vo_61545_0List);

            Vo_24505_0 vo_24505_0 = GameUtil.a24505(chara1);
            GameObjectChar.send(new M24505_0(), vo_24505_0);


            Vo_61591_0 vo_61591_0 = new Vo_61591_0();
            vo_61591_0.ask_type = ask_type;
            vo_61591_0.name = peer_name;
            GameObjectChar.send(new M61591_0(), vo_61591_0);

            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "#Y#<" + peer_name + "#>#n加入你的的队伍";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);

            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectChar.send(new M61671_0(), vo_61671_0);

            vo_61545_0List = GameUtil.a61545(chara1);
            GameObjectChar.send(new M61545_0(), vo_61545_0List);

            vo_24505_0 = GameUtil.a24505(chara1);
            GameObjectChar.send(new M24505_0(), vo_24505_0);

            Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara1);
            GameObjectChar.send(new M65529_0(), vo_65529_0);


//
            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "invite_join";
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61593_0(), vo_61593_0);

            vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你加入#Y#<" + chara.name + "#>#n的队伍";
            vo_20480_0.time = 1562593376;
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20480_0(), vo_20480_0);

            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61671_0(), vo_61671_0);
            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(4);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61671_0(), vo_61671_0);

//
            vo_61545_0List = GameUtil.a61545(chara);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61545_0(), vo_61545_0List);


            vo_24505_0 = GameUtil.a24505(chara);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M24505_0(), vo_24505_0);

            vo_65529_0 = GameUtil.a65529(chara);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M65529_0(), vo_65529_0);

            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61671_0(), vo_61671_0);

//
            GameObjectChar.getGameObjectChar().gameTeam.duiwu.add(chara1);
            GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.add(GameUtil.add4121(chara1, 1));
            GameObjectChar.getGameObjectChar().gameTeam.liebiao.remove(chara1);
            GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
            GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.liebiao.clear();
            List<Chara> charas = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
            GameUtil.a4119(charas);
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);

            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectChar.send(new M20568_0(), vo_20568_0);

            Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
            GameObjectChar.send(new M61661_0(), vo_61661_0);

            vo_61661_0 = GameUtil.a61661(chara1);
            GameObjectChar.send(new M61661_0(), vo_61661_0);

            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = peer_name + "加入队伍";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);


            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20568_0(), vo_20568_0);


            vo_61661_0 = GameUtil.a61661(chara1);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61661_0(), vo_61661_0);
            vo_61661_0 = GameUtil.a61661(chara);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61661_0(), vo_61661_0);


            vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "invite_join";
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61593_0(), vo_61593_0);


            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectChar.send(new M61671_0(), vo_61671_0);


            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M61671_0(), vo_61671_0);


        } else {
            if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam == null) {
                GameObjectChar.getGameObjectChar().gameTeam.duiwu = null;
                Vo_61593_0 vo_61593_0 = new Vo_61593_0();
                vo_61593_0.ask_type = ask_type;
                GameObjectChar.send(new M61593_0(), vo_61593_0);
                Vo_20568_0 vo_20568_0 = new Vo_20568_0();
                vo_20568_0.gid = "";
                GameObjectChar.send(new M20568_0(), vo_20568_0);

                return;
            }
            List<Vo_61545_0> vo_61545_0List = GameUtil.a61545(chara);
            GameObjectChar.send(new M61545_0(), vo_61545_0List);

            GameUtil.a24505(chara1);

            Vo_61591_0 vo_61591_0 = new Vo_61591_0();
            vo_61591_0.ask_type = ask_type;
            vo_61591_0.name = peer_name;
            GameObjectChar.send(new M61591_0(), vo_61591_0);

            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = ask_type;
            GameObjectChar.send(new M61593_0(), vo_61593_0);

            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你加入#Y#<" + peer_name + "#>#n的队伍";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);

            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(5);
            GameObjectChar.send(new M61671_0(), vo_61671_0);

            Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
            GameObjectChar.send(new M65529_0(), vo_65529_0);

            vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            GameObjectChar.send(new M61671_0(), vo_61671_0);

            GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.add(chara);
            GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.zhanliduiyuan.add(GameUtil.add4121(chara, 1));
            GameObjectChar.getGameObjectChar().gameTeam = GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam;
            GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
            GameObjectChar.getGameObjectChar().gameTeam.liebiao.clear();
            List<Chara> charas = GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu;
            GameUtil.a4119(charas);
            GameUtil.a4121(GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.zhanliduiyuan);

            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectChar.send(new M20568_0(), vo_20568_0);


            Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara1);
            GameObjectChar.send(new M61661_0(), vo_61661_0);

        }


    }

    @Override
    public int cmd() {
        return 4132;
    }
}