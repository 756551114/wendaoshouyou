package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;
import org.linlinjava.litemall.gameserver.data.write.M41480_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class C41479_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        Date date = new Date(chara.updatetime);
        boolean isnow = GameUtil.isNow(date);
        if (!isnow && chara.online_time != 0) {
            chara.online_time = 0;
            for (int i = 0; i < chara.shenmiliwu.size(); i++) {
                chara.shenmiliwu.get(i).online_time = 0;
                chara.shenmiliwu.get(i).name = "";
                chara.shenmiliwu.get(i).brate = 0;
            }
        }
        List<Vo_41480_0> list = new LinkedList<>();
        for (int i = 0; i < chara.shenmiliwu.size(); i++) {
            Vo_41480_0 vo_41480_0 = new Vo_41480_0();
            vo_41480_0.online_time = (int) (chara.online_time / 1000 + (System.currentTimeMillis() - chara.uptime) / 1000);
            vo_41480_0.time = chara.shenmiliwu.get(i).time;
            vo_41480_0.name = chara.shenmiliwu.get(i).name;
            vo_41480_0.index = chara.shenmiliwu.get(i).index;
            vo_41480_0.brate = chara.shenmiliwu.get(i).brate;
            list.add(vo_41480_0);
        }
        GameObjectChar.send(new M41480_0(), list);
    }

    @Override
    public int cmd() {
        return 41479;
    }
}