package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36871_0;
import org.linlinjava.litemall.gameserver.data.write.M36871_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

@Service
public class C33287_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String char_gid = GameReadTool.readString(buff);

        String dlg_type = GameReadTool.readString(buff);

        int offline = GameReadTool.readByte(buff);

        String para = GameReadTool.readString(buff);

        String user_dist = GameReadTool.readString(buff);


        Characters characters = GameData.that.characterService.finOnByGiD(char_gid);
        String data = characters.getData();
        Chara chara = JSONUtils.parseObject(data, Chara.class);


        Vo_36871_0 vo_36871_0 = new Vo_36871_0();
        vo_36871_0.msg_type = "";
        vo_36871_0.icon = chara.waiguan;
        vo_36871_0.id = characters.getId();
        vo_36871_0.level = chara.level;
        vo_36871_0.gid = char_gid;
        vo_36871_0.name = chara.name;
        vo_36871_0.party = "";
        vo_36871_0.friend_score = 0;
        vo_36871_0.setting_flag = 363017012;
        if (GameObjectCharMng.getGameObjectChar(chara.id)==null){
            return;
        }
        if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam!= null) {
            if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu!=null){
                vo_36871_0.char_status = 3;
            }else {
                vo_36871_0.char_status = 0;
            }
        } else {
            vo_36871_0.char_status = 0;
        }
        vo_36871_0.vip = 0;
        vo_36871_0.serverId = user_dist;
        vo_36871_0.account = "110001bph1cq2p";
        vo_36871_0.polar = 1;
        vo_36871_0.isInThereFrend = 0;
        vo_36871_0.ringScore = 0;
        vo_36871_0.comeback_flag = 0;
        GameObjectChar.send(new M36871_0(), vo_36871_0);


//        characterService.findOneByID()
    }

    @Override
    public int cmd() {
        return 33287;
    }

}