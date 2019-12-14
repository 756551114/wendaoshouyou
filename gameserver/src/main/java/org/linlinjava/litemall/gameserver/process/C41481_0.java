package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class C41481_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int index = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        if (index == 0) {
            for (int w = 0; w < 8; w++) {
                index = w + 1;
                int time = chara.shenmiliwu.get(w).time;
                if ((chara.online_time / 1000 + (System.currentTimeMillis() - chara.uptime) / 1000) > time && chara.shenmiliwu.get(index - 1).brate == 0) {
                    String name = "";
                    int potentialPoint = 0;
                    Random random = new Random();
                    int i = random.nextInt(3);
                    if (i == 1) {
                        name = "潜能";
                        potentialPoint = chara.level * 810;
                        chara.cash += potentialPoint;
                        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = "你获得了#R" + potentialPoint + "#n点" + name;
                        vo_20480_0.time = 1562593376;
                        GameObjectChar.send(new M20480_0(), vo_20480_0);
                    }
                    if (i == 2) {
                        name = "道行";
                        potentialPoint = chara.level * 7;
                        GameUtil.adddaohang(chara, potentialPoint);
                    } else if (i == 0) {
                        name = "经验";
                        Experience experience1 = GameData.that.baseExperienceService.findOneByAttrib(chara.level);
                        potentialPoint = experience1.getMaxLevel() * 2 / (chara.level + 9);
                        GameUtil.huodejingyan(chara, potentialPoint);
                    }
                    chara.shenmiliwu.get(index - 1).name = name;
                    chara.shenmiliwu.get(index - 1).brate = 1;

                    Vo_41482_0 vo_41482_0 = new Vo_41482_0();
                    vo_41482_0.brate = 1;
                    vo_41482_0.name = name;
                    vo_41482_0.index = index;
                    vo_41482_0.result = 0;
                    GameObjectChar.send(new M41482_0(), vo_41482_0);


                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);

                    List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
                    GameObjectChar.send(new M32747_0(), vo_32747_0List);

                    GameUtil.a65511(chara);

                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "恭喜，你意外获得了#R" + name + "#n奖励";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);

                    GameUtil.a49159(chara);


                    List<Vo_41480_0> list = new LinkedList<>();
                    for (int k = 0; k < chara.shenmiliwu.size(); k++) {
                        Vo_41480_0 vo_41480_0 = new Vo_41480_0();
                        vo_41480_0.online_time = (int) (chara.online_time / 1000 + (System.currentTimeMillis() - chara.uptime) / 1000);
                        vo_41480_0.time = chara.shenmiliwu.get(k).time;
                        vo_41480_0.name = chara.shenmiliwu.get(k).name;
                        vo_41480_0.index = chara.shenmiliwu.get(k).index;
                        vo_41480_0.brate = chara.shenmiliwu.get(k).brate;
                        list.add(vo_41480_0);
                    }
                    GameObjectChar.send(new M41480_0(), list);
                }
            }
            return;
        }
        int time = chara.shenmiliwu.get(index - 1).time;
        ;
//        for (int i = 0; i < index; i++) {
//            time += chara.shenmiliwu.get(i).time;
//        }
        long times = System.currentTimeMillis();
        boolean istime = (chara.online_time / 1000 + (System.currentTimeMillis() - chara.uptime) / 1000) > time;
        if (istime && chara.shenmiliwu.get(index - 1).brate == 0) {
            String name = "";
            int potentialPoint = 0;
            Random random = new Random();
            int i = random.nextInt(3);
            if (i == 1) {
                name = "潜能";
                potentialPoint = chara.level * 810;
                chara.cash += potentialPoint;
                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = "你获得了#R" + potentialPoint + "#n点" + name;
                vo_20480_0.time = 1562593376;
                GameObjectChar.send(new M20480_0(), vo_20480_0);
            }
            if (i == 2) {
                name = "道行";
                potentialPoint = chara.level * 7;
                GameUtil.adddaohang(chara, potentialPoint);
            } else if (i == 0) {
                name = "经验";
                Experience experience1 = GameData.that.baseExperienceService.findOneByAttrib(chara.level);
                potentialPoint = experience1.getMaxLevel() * 2 / (chara.level + 9);
                GameUtil.huodejingyan(chara, potentialPoint);
            }
            chara.shenmiliwu.get(index - 1).name = name;
            chara.shenmiliwu.get(index - 1).brate = 1;

            Vo_41482_0 vo_41482_0 = new Vo_41482_0();
            vo_41482_0.brate = 1;
            vo_41482_0.name = name;
            vo_41482_0.index = index;
            vo_41482_0.result = 0;
            GameObjectChar.send(new M41482_0(), vo_41482_0);


            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

            List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
            GameObjectChar.send(new M32747_0(), vo_32747_0List);

            GameUtil.a65511(chara);

            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "恭喜，你意外获得了#R" + name + "#n奖励";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);

            GameUtil.a49159(chara);


            List<Vo_41480_0> list = new LinkedList<>();
            for (int k = 0; k < chara.shenmiliwu.size(); k++) {
                Vo_41480_0 vo_41480_0 = new Vo_41480_0();
                vo_41480_0.online_time = (int) (chara.online_time / 1000 + (System.currentTimeMillis() - chara.uptime) / 1000);
                vo_41480_0.time = chara.shenmiliwu.get(k).time;
                vo_41480_0.name = chara.shenmiliwu.get(k).name;
                vo_41480_0.index = chara.shenmiliwu.get(k).index;
                vo_41480_0.brate = chara.shenmiliwu.get(k).brate;
                list.add(vo_41480_0);
            }
            GameObjectChar.send(new M41480_0(), list);
        } else {
            return;
        }


    }

    @Override
    public int cmd() {
        return 41481;
    }


}