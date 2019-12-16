package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41488_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.write.M41505_0;
import org.linlinjava.litemall.gameserver.data.write.M41488_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C41489_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int fasion_label = GameReadTool.readByte(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;
        GameObjectChar.send(new M61671_0(), vo_61671_0);



        Vo_41488_0 vo_41488_0 = new Vo_41488_0();
        vo_41488_0.flag = 1;
        vo_41488_0.label = 0;
        vo_41488_0.para = "CustomDressDlg";
        vo_41488_0.count2 = 20;
        vo_41488_0.name0 = "点红烛·永久";
        vo_41488_0.goods_price0 = 26888;
        vo_41488_0.name1 = "日耀辰辉·永久";
        vo_41488_0.goods_price1 = 26888;
        vo_41488_0.name2 = "星垂月涌·永久";
        vo_41488_0.goods_price2 = 26888;
        vo_41488_0.name3 = "剑魄琴心·永久";
        vo_41488_0.goods_price3 = 26888;
        vo_41488_0.name4 = "引天长歌·永久";
        vo_41488_0.goods_price4 = 26888;
        vo_41488_0.name5 = "如意年·永久";
        vo_41488_0.goods_price5 = 26888;
        vo_41488_0.name6 = "星火昭·永久";
        vo_41488_0.goods_price6 = 26888;
        vo_41488_0.name7 = "吉祥天·永久";
        vo_41488_0.goods_price7 = 26888;
        vo_41488_0.name8 = "汉宫秋·永久";
        vo_41488_0.goods_price8 = 36888;
        vo_41488_0.name9 = "凤鸣空·永久";
        vo_41488_0.goods_price9 = 36888;
        vo_41488_0.name10 = "水光衫·永久";
        vo_41488_0.goods_price10 = 36888;
        vo_41488_0.name11 = "月孤影·永久";
        vo_41488_0.goods_price11 = 36888;
        vo_41488_0.name12 = "狐灵娇·永久";
        vo_41488_0.goods_price12 = 36888;
        vo_41488_0.name13 = "晓色红妆·永久";
        vo_41488_0.goods_price13 = 36888;
        vo_41488_0.name14 = "千秋梦·永久";
        vo_41488_0.goods_price14 = 36888;
        vo_41488_0.name15 = "龙吟水·永久";
        vo_41488_0.goods_price15 = 36888;
        vo_41488_0.name16 = "峥岚衣·永久";
        vo_41488_0.goods_price16 = 36888;
        vo_41488_0.name17 = "狐灵逸·永久";
        vo_41488_0.goods_price17 = 36888;
        vo_41488_0.name18 = "云暮风华·永久";
        vo_41488_0.goods_price18 = 36888;
        vo_41488_0.name19 = "星寒魄·永久";
        vo_41488_0.goods_price19 = 36888;
        GameObjectChar.send(new M41488_0(), vo_41488_0);
        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "swicth_label";
        GameObjectChar.send(new M41505_0(), vo_41505_0);


    }

    @Override
    public int cmd() {
        return 41489;
    }
}