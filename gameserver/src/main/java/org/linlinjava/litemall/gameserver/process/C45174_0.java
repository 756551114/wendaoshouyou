package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M45185_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

@Service
public class C45174_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String type = GameReadTool.readString(buff);

        String para = GameReadTool.readString(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if ("team".equals(type)) {
            Characters characters = GameData.that.characterService.finOnByGiD(para);
            String data = characters.getData();
            Chara chara1 = JSONUtils.parseObject(data, Chara.class);

            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "已向#Y" + chara.name + "#n发送震动提醒。";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);

            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = chara.name + "在队伍中向你发送了一次震动提醒";
            vo_20481_0.time = 1562987118;
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20481_0(), vo_20481_0);

            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M45185_0(), "");

        }


    }

    @Override
    public int cmd() {
        return 45174;
    }
}