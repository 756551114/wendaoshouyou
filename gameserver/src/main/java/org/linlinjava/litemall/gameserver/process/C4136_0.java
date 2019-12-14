package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M65529_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.data.write.M61553_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C4136_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int pos = GameReadTool.readByte(buff);

        int equip_part = GameReadTool.readByte(buff);

        final Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (pos < 0) {
            pos = 129 + pos + 127;
        }

        if (chara.current_task.equals("主线—浮生若梦_s2")) {

            GameUtil.renwujiangli(chara);

            chara.current_task = GameUtil.nextrenw(chara.current_task);


            Renwu tasks = GameData.that.baseRenwuService.findOneByCurrentTask(chara.current_task);
            Vo_61553_0 vo_61553_0 = GameUtil.a61553(tasks, chara);
            GameObjectChar.send(new M61553_0(), vo_61553_0);
        }
        boolean has = false;
        Goods goodshas = new Goods();
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods.pos == equip_part) {
                goodshas = goods;
                has = true;
            }
        }
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods.pos == pos) {
                if (goods.goodsInfo.master != 0 && goods.goodsInfo.master != chara.sex) {
                    return;
                }
                goods.pos = equip_part;
                if (goods.pos == 1) {
                    chara.weapon_icon = goods.goodsInfo.type;
                }
                break;
            }
        }
        if (has) {
            goodshas.pos = pos;
        } else {
            List<Goods> listbeibao = new ArrayList<>();
            Goods goods1 = new Goods();
            goods1.goodsBasics = null;
            goods1.goodsInfo = null;
            goods1.goodsLanSe = null;
            goods1.pos = pos;
            listbeibao.add(goods1);
            GameObjectChar.send(new M65525_0(), listbeibao);
        }

        GameObjectChar.send(new M65525_0(), chara.backpack);

        GameUtil.a65511(chara);
        ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), vo_65527_0);

        Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
        GameObjectChar.send(new M65529_0(), vo_65529_0);

    }


    @Override
    public int cmd() {
        return 4136;
    }

}