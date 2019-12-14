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

import java.util.ArrayList;
import java.util.List;


@Service
public class C4156_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String peer_name = GameReadTool.readString(buff);

        int id = GameReadTool.readInt(buff);

        String ask_type = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        final GameObjectChar session = GameObjectChar.getGameObjectChar();

        Characters characters = GameData.that.characterService.findOneByName(peer_name);
        String data = characters.getData();
        Chara chara1 = JSONUtils.parseObject(data, Chara.class);

        final GameObjectChar session1 = GameObjectCharMng.getGameObjectChar(chara1.id);

        if ("request_team_leader".equals(ask_type)) {
            List<Vo_61545_0> vo_61545_0List = GameUtil.a61545(chara1);
            GameObjectChar.send(new M61545_0(), vo_61545_0List);
            Vo_24505_0 vo_24505_0 = GameUtil.a24505(chara1);
            GameObjectChar.send(new M24505_0(), vo_24505_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "你的申请已发送";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);


            Vo_20467_0 vo_20467_1 = new Vo_20467_0();
            vo_20467_1.caption = "";
            vo_20467_1.content = "";
            vo_20467_1.peer_name = peer_name;
            vo_20467_1.ask_type = "request_team_leader";
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20467_0(), vo_20467_1);
            Vo_45240_0 vo_45240_0 = new Vo_45240_0();
            vo_45240_0.tips = peer_name + "申请成为队长，是否同意？";
            vo_45240_0.down_count = 30;
            vo_45240_0.only_confirm = 0;
            vo_45240_0.confirm_type = "reject_count_down";
            vo_45240_0.confirmText = "";
            vo_45240_0.cancelText = "";
            vo_45240_0.show_dlg_mode = 3;
            vo_45240_0.countDownTips = "";
            vo_45240_0.para_str = "{}";
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M45240_0(), vo_45240_0);
            GameObjectCharMng.getGameObjectChar(chara1.id).upduizhangid = chara.id;

        }
        if (ask_type.equals("request_join")) {

            if (GameObjectCharMng.getGameObjectChar(id).gameTeam != null) {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你已发出申请，请耐心等待";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                Boolean has = false;

                for (int i = 0; i < GameObjectCharMng.getGameObjectChar(id).gameTeam.liebiao.size(); i++) {
                    for (int j = 0; j < GameObjectCharMng.getGameObjectChar(id).gameTeam.liebiao.get(i).size(); j++) {
                        if (GameObjectCharMng.getGameObjectChar(id).gameTeam.liebiao.get(i).get(j).id == chara.id) {
                            has = true;
                        }

                    }
                }
                if (!has) {

                    List<Chara> list = new ArrayList<>();
                    list.add(chara);

                    GameObjectCharMng.getGameObjectChar(id).gameTeam.liebiao.add(list);
                }


                Vo_20467_0 vo_20467_0 = new Vo_20467_0();
                vo_20467_0.caption = "";
                vo_20467_0.content = "";

                vo_20467_0.peer_name = chara.name;
                vo_20467_0.ask_type = "invite_join";
                vo_20467_0.org_icon = chara.waiguan;
                vo_20467_0.iid_str = chara.uuid;
                vo_20467_0.skill = chara.level;
                vo_20467_0.str = chara.name;
                vo_20467_0.master = chara.sex;
                vo_20467_0.metal = chara.menpai;
                vo_20467_0.req_str = "";
                vo_20467_0.passive_mode = chara.waiguan;

                vo_20467_0.party_contrib = "";
                vo_20467_0.teamMembersCount = 1;
                vo_20467_0.comeback_flag = 0;
                GameObjectCharMng.getGameObjectChar(id).sendOne(new M20467_0(), vo_20467_0);
                vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "有人申请组队，请查看";
                vo_8165_0.active = 0;
                GameObjectCharMng.getGameObjectChar(id).sendOne(new M8165_0(), vo_8165_0);
                return;
            }

            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "invite_join";
            GameObjectChar.send(new M61593_0(), vo_61593_0);


            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);


            GameTeam gameTeam = new GameTeam();
            gameTeam.duiwu.add(chara);
            gameTeam.zhanliduiyuan.add(GameUtil.add4121(chara, 1));
            GameObjectChar.getGameObjectChar().creator(gameTeam);
            List<Chara> duiwu = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
            GameUtil.a4119(duiwu);
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectChar.send(new M20568_0(), vo_20568_0);


            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你组建了一支队伍。";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);
        }
        if ("invite_join".equals(ask_type)) {


            if (GameObjectChar.getGameObjectChar().gameTeam == null) {
                Vo_61593_0 vo_61593_0 = new Vo_61593_0();
                vo_61593_0.ask_type = "invite_join";
                GameObjectChar.send(new M61593_0(), vo_61593_0);


                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = chara.id;
                vo_61671_0.count = 2;
                vo_61671_0.list.add(2);
                vo_61671_0.list.add(3);
                GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);


                GameTeam gameTeam = new GameTeam();
                gameTeam.duiwu.add(chara);
                gameTeam.zhanliduiyuan.add(GameUtil.add4121(chara, 1));
                GameObjectChar.getGameObjectChar().creator(gameTeam);
                List<Chara> duiwu = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
                GameUtil.a4119(duiwu);
                GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
                Vo_20568_0 vo_20568_0 = new Vo_20568_0();
                vo_20568_0.gid = "";
                GameObjectChar.send(new M20568_0(), vo_20568_0);


                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = "你组建了一支队伍。";
                vo_20480_0.time = 1562593376;
                GameObjectChar.send(new M20480_0(), vo_20480_0);
            } else {
                if (GameObjectChar.getGameObjectChar().gameTeam.duiwu.size() >= 5) {
                    return;
                }
            }


            List<Vo_61545_0> vo_61545_0List = GameUtil.a61545(chara1);
            GameObjectChar.send(new M61545_0(), vo_61545_0List);


            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "你已发出邀请，请耐心等待";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);


            GameUtil.a20467(chara, id, ask_type);


            vo_8165_0.msg = "" + chara.name + "邀请你加入其队伍，请打开队伍界面查看邀请信息。";
            vo_8165_0.active = 0;
            GameObjectCharMng.getGameObjectChar(id).sendOne(new M8165_0(), vo_8165_0);


        }


    }

    @Override
    public int cmd() {
        return 4156;
    }
}