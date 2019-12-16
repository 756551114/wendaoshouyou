package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8249_0;
import org.linlinjava.litemall.gameserver.data.write.M8249_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C8246_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int count = GameReadTool.readShort(buff);

        String range = GameReadTool.readString2(buff);

        int start_pos = GameReadTool.readShort(buff);

        String to_store_cards = GameReadTool.readString2(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        String[] split = range.split("\\|");
        //交换位置和叠加
        String pos1 = split[0];
        //交换位置
        String pos2 = split[1];

        String[] split1 = pos1.split("\\,");
        String[] split2 = pos2.split("\\,");


        Vo_8249_0 vo_8249_0 = new Vo_8249_0();
        vo_8249_0.start_range = 1;
        GameObjectChar.send(new M8249_0(), vo_8249_0);

        GameUtil.removerbeibaocangku(chara);

        //背包
        if (start_pos == 41) {
            List<Goods> list = new ArrayList<>();
            if (!pos1.equals("")) {
                for (int i = 0; i < split1.length; i++) {
                    String[] split3 = split1[i].split("\\-");
                    Goods goods = null;
                    for (int j = 0; j < chara.backpack.size(); j++) {
                        if (chara.backpack.get(j).pos == Integer.parseInt(split3[0])) {
                            goods = chara.backpack.get(j);
                            break;
                        }
                    }
                    for (int j = 0; j < chara.backpack.size(); j++) {
                        for (int k = 0; k < split3.length - 1; k++) {
                            if (chara.backpack.get(j).pos == Integer.parseInt(split3[k + 1])) {
                                int munber = 10;
                                if ("凝香幻彩#炫影霜星#风寂云清#枯月流魂#冰落残阳#雷极弧光".contains(chara.backpack.get(j).goodsInfo.str)) {
                                    munber = 999;
                                }
                                Goods goods1 = chara.backpack.get(j);
                                int owner = goods.goodsInfo.owner_id;
                                goods.goodsInfo.owner_id = goods.goodsInfo.owner_id + goods1.goodsInfo.owner_id;
                                if (goods.goodsInfo.owner_id >= munber) {
                                    goods.goodsInfo.owner_id = munber;
                                    goods1.goodsInfo.owner_id = goods1.goodsInfo.owner_id - munber + owner;
                                    break;
                                } else {
                                    goods1.goodsInfo.owner_id = 0;
                                    List<Goods> listbeibao = new ArrayList<>();
                                    Goods goods2 = new Goods();
                                    goods2.goodsBasics = null;
                                    goods2.goodsInfo = null;
                                    goods2.goodsLanSe = null;
                                    goods2.pos = Integer.parseInt(split3[k + 1]);
                                    listbeibao.add(goods2);
                                    list.add(goods1);
//                                    chara.backpack.remove(goods1);
                                    GameObjectChar.send(new M65525_0(), listbeibao);
                                }
                                break;
                            }
                        }
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    chara.backpack.remove(list.get(i));
                }
            }
            if (!pos2.equals("")) {
                for (int i = 0; i < split2.length; i++) {
                    String[] split4 = split2[i].split("\\-");
                    for (int j = 0; j < chara.backpack.size(); j++) {
                        if (chara.backpack.get(j).pos == Integer.parseInt(split4[0])) {
                            Goods goods = chara.backpack.get(j);
                            goods.pos = Integer.parseInt(split4[1]);
                            list = new ArrayList<>();
                            list.add(goods);
                            GameObjectChar.send(new M65525_0(), list);
                            break;
                        }
                    }
                    List<Goods> listbeibao = new ArrayList<>();
                    Goods goods1 = new Goods();
                    goods1.goodsBasics = null;
                    goods1.goodsInfo = null;
                    goods1.goodsLanSe = null;
                    goods1.pos = Integer.parseInt(split4[0]);
                    listbeibao.add(goods1);
                    GameObjectChar.send(new M65525_0(), listbeibao);
                }
            }
            GameObjectChar.send(new M65525_0(), chara.backpack);
            vo_8249_0 = new Vo_8249_0();
            vo_8249_0.start_range = 0;
            GameObjectChar.send(new M8249_0(), vo_8249_0);
        }
        vo_8249_0 = new Vo_8249_0();
        vo_8249_0.start_range = 1;
        GameObjectChar.send(new M8249_0(), vo_8249_0);
        //仓库
        if (start_pos == 201) {
            List<Goods> list = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                String[] split3 = split1[i].split("\\-");
                Goods goods = null;
                if (!split3[0].equals("")) {

                    for (int j = 0; j < chara.cangku.size(); j++) {
                        if (chara.cangku.get(j).pos == Integer.parseInt(split3[0])) {
                            goods = chara.cangku.get(j);
                            break;
                        }
                    }
                    for (int j = 0; j < chara.cangku.size(); j++) {
                        for (int k = 0; k < split3.length - 1; k++) {
                            if (chara.cangku.get(j).pos == Integer.parseInt(split3[k + 1])) {
                                int munber = 10;
                                if ("凝香幻彩#炫影霜星#风寂云清#枯月流魂#冰落残阳#雷极弧光".contains(chara.cangku.get(j).goodsInfo.str)) {
                                    munber = 999;
                                }
                                Goods goods1 = chara.cangku.get(j);
                                int owner = goods.goodsInfo.owner_id;
                                goods.goodsInfo.owner_id = goods.goodsInfo.owner_id + goods1.goodsInfo.owner_id;
                                if (goods.goodsInfo.owner_id >= munber) {
                                    goods.goodsInfo.owner_id = munber;
                                    goods1.goodsInfo.owner_id = goods1.goodsInfo.owner_id - munber + owner;
                                    break;
                                } else {
                                    goods1.goodsInfo.owner_id = 0;
                                    list.add(goods1);
                                }
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                chara.cangku.remove(list.get(i));
            }
            Vo_61677_0 vo_61677_0 = new Vo_61677_0();
            vo_61677_0.list = chara.cangku;
            GameObjectChar.send(new M61677_0(), vo_61677_0);
            if (!pos2.equals("")) {
                for (int i = 0; i < split2.length; i++) {
                    String[] split4 = split2[i].split("\\-");
                    for (int j = 0; j < chara.cangku.size(); j++) {
                        if (chara.cangku.get(j).pos == Integer.parseInt(split4[0])) {
                            Goods goods = chara.cangku.get(j);
                            goods.pos = Integer.parseInt(split4[1]);
                            break;
                        }
                    }
                }
            }
            vo_61677_0 = new Vo_61677_0();
            vo_61677_0.list = chara.cangku;
            GameObjectChar.send(new M61677_0(), vo_61677_0);

        }
        vo_8249_0 = new Vo_8249_0();
        vo_8249_0.start_range = 0;
        GameObjectChar.send(new M8249_0(), vo_8249_0);

    }

    @Override
    public int cmd() {
        return 8246;
    }
}