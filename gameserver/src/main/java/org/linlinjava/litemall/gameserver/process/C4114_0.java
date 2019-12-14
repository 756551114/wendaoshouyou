package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;
import org.linlinjava.litemall.gameserver.data.GameReadTool;

@Service
public class C4114_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int victim_id = GameReadTool.readInt(buff);

        int flag = GameReadTool.readShort(buff);

        String gid = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Characters characters = GameData.that.characterService.finOnByGiD(gid);
        Chara chara1 = JSONUtils.parseObject(characters.getData(), Chara.class);

        if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectChar.getGameObjectChar().gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null && GameObjectChar.getGameObjectChar().gameTeam.duiwu != null) {
            if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(0).id == GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0).id) {
                return;
            }

        }


        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你进入切磋战斗中！";
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);


        FightManager.goFight(chara, chara1);
    }

    @Override
    public int cmd() {
        return 4114;
    }
}