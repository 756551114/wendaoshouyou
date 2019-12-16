package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C41501_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int pos = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == pos) {
                List<Goods> listbeibao = new ArrayList<>();
                Goods goods2 = new Goods();
                goods2.goodsBasics = null;
                goods2.goodsInfo = null;
                goods2.goodsLanSe = null;
                goods2.pos = chara.backpack.get(i).pos;
                listbeibao.add(goods2);
                GameObjectChar.send(new M65525_0(), listbeibao);
                chara.backpack.remove(chara.backpack.get(i));
            }
        }
        if (pos == 31) {
            chara.special_icon = 0;
        }
        if (pos == 32) {
            chara.texiao_icon = 0;
        }
        if (pos == 37) {
            Vo_4197_0 vo_4197_0 = new Vo_4197_0();
            vo_4197_0.id = 0;
            GameObjectChar.getGameObjectChar().gameMap.send(new M4197_0(), vo_4197_0);
            GameObjectChar.getGameObjectChar().gameMap.send(new M12285_1(), chara.genchong_icon);
            chara.genchong_icon = 0;
        }

        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "follow_pet_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.genchong;
        vo_61677_0.count = chara.genchong.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);

        vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "fasion_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.shizhuang;
        vo_61677_0.count = chara.shizhuang.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);


        vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "effect_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.texiao;
        vo_61677_0.count = chara.texiao.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);

        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);


        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "卸下成功！";
        vo_8165_0.active = 0;
        GameObjectChar.send(new M8165_0(), vo_8165_0);
        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "unequip_fasion";
        GameObjectChar.send(new M41505_0(), vo_41505_0);
    }

    @Override
    public int cmd() {
        return 41501;
    }
}