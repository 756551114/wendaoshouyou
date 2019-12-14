package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20568_0;
import org.linlinjava.litemall.gameserver.data.write.M53741_0;
import org.linlinjava.litemall.gameserver.data.write.M20568_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Duiyuan;
import org.linlinjava.litemall.gameserver.domain.LieBiao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C41125_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String ask_type = GameReadTool.readString(buff);
        final GameObjectChar session = GameObjectChar.getGameObjectChar();
        if (ask_type.equals("invite_join")) {

            List<LieBiao> lieBiaoList = new ArrayList<>();

            if (GameObjectChar.getGameObjectChar().gameTeam != null) {
                for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.liebiao.size(); i++) {
                    LieBiao lieBiao = new LieBiao();
                    lieBiao.ask_type = "invite_join";
                    lieBiao.peer_name = GameObjectChar.getGameObjectChar().gameTeam.liebiao.get(i).get(0).name;
                    Duiyuan duiyuan = new Duiyuan();
                    Chara chara = GameObjectChar.getGameObjectChar().gameTeam.liebiao.get(i).get(0);
                    duiyuan.org_icon = chara.waiguan;
                    duiyuan.iid_str = chara.uuid;
                    duiyuan.str = chara.name;
                    duiyuan.skill = chara.level;
                    duiyuan.master = chara.sex;
                    duiyuan.metal = chara.menpai;
                    duiyuan.req_str = "";
                    duiyuan.passive_mode = chara.waiguan;
                    duiyuan.party_contrib = "";
                    duiyuan.mapteamMembersCount = 1;
                    duiyuan.mapcomeback_flag = 0;
                    lieBiao.duiyuanList.add(duiyuan);
//                    }
                    lieBiaoList.add(lieBiao);
                }
                GameObjectChar.send(new M53741_0(), lieBiaoList);
            } else {
            }
        }
        if (ask_type.equals("request_join")) {
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectChar.send(new M20568_0(), vo_20568_0);

            List<LieBiao> lieBiaoList = new ArrayList<>();

            if (GameObjectChar.getGameObjectChar().gameTeam != null) {
                for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.liebiao.size(); i++) {
                    LieBiao lieBiao = new LieBiao();
                    lieBiao.ask_type = "request_join";
                    lieBiao.peer_name = GameObjectChar.getGameObjectChar().gameTeam.liebiao.get(i).get(0).name;
                    for (int j = 0; j < GameObjectChar.getGameObjectChar().gameTeam.liebiao.get(i).size(); j++) {
                        Duiyuan duiyuan = new Duiyuan();
                        Chara chara = GameObjectChar.getGameObjectChar().gameTeam.liebiao.get(i).get(j);
                        duiyuan.org_icon = chara.waiguan;
                        duiyuan.iid_str = chara.uuid;
                        duiyuan.str = chara.name;
                        duiyuan.skill = chara.level;
                        duiyuan.master = chara.sex;
                        duiyuan.metal = chara.menpai;
                        duiyuan.req_str = "";
                        duiyuan.passive_mode = chara.waiguan;
                        duiyuan.party_contrib = "";
                        duiyuan.mapteamMembersCount = 1;
                        duiyuan.mapcomeback_flag = 0;
                        lieBiao.duiyuanList.add(duiyuan);
                    }
                    lieBiaoList.add(lieBiao);
                }
                GameObjectChar.send(new M53741_0(), lieBiaoList);
            } else {
            }
        }
    }

    @Override
    public int cmd() {
        return 41125;
    }
}