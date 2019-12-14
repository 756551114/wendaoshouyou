package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class C12490_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String id = GameReadTool.readString(buff);

        String key = GameReadTool.readString(buff);

        String pageStr = GameReadTool.readString(buff);

        int price = GameReadTool.readInt(buff);

        int type = GameReadTool.readByte(buff);
//1
        int amount = GameReadTool.readShort(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        SaleGood saleGood = GameData.that.saleGoodService.findOneByGoodsId(id);

        if (saleGood.getOwnerUuid().equals(chara.uuid)) {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "道友,这是你自己出售的商品哦。";
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            return;
        }
        //装备和物品
        if (saleGood.getIspet() == 1) {
            String goods = saleGood.getGoods();
            Goods goods1 = JSONUtils.parseObject(goods, Goods.class);
            List list = new LinkedList();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo.owner_id = 1;
            GameUtil.addwupin(goods1, chara);
            Vo_40964_0 vo_40964_9 = new Vo_40964_0();
            vo_40964_9.type = 1;
            vo_40964_9.name = saleGood.getName();
            vo_40964_9.param = "-1";
            vo_40964_9.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_9);
        } else {
            String goods = saleGood.getGoods();
            Petbeibao petbeibao = JSONUtils.parseObject(goods, Petbeibao.class);
            Vo_12269_0 vo_12269_0 = new Vo_12269_0();
            vo_12269_0.id = petbeibao.id;
            vo_12269_0.owner_id = chara.id;
            GameObjectChar.send(new M12269_0(), vo_12269_0);
            Vo_40964_0 vo_40964_11 = new Vo_40964_0();
            vo_40964_11.type = 2;
            vo_40964_11.name = "立正";
            vo_40964_11.param = String.valueOf(petbeibao.petShuXing.get(0).type);
            vo_40964_11.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_11);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "你成功将#R" + saleGood.getName() + "#n购买了";
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            List list = new ArrayList();
            list.add(petbeibao);
            petbeibao.id = GameUtil.getCard(chara);
            GameObjectChar.send(new M65507_0(), list);
            boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
            GameUtil.dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, petbeibao.id, chara);
            chara.pets.add(petbeibao);
            GameData.that.saleGoodService.deleteById(saleGood.getId());
        }
        Vo_33049_0 vo_33049_0 = new Vo_33049_0();
        vo_33049_0.goods_gid = id;
        vo_33049_0.type = 0;
        vo_33049_0.result = 1;
        vo_33049_0.tips = "";
        GameObjectChar.send(new M33049_0(), vo_33049_0);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "购买了#R" + saleGood.getName() + "#n。";
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new M20481_0(), vo_20481_0);

        chara.balance = chara.balance - price;
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

        GameData.that.saleGoodService.deleteById(saleGood.getId());

        String[] split = pageStr.split("\\;");
        int pos1 = Integer.parseInt(split[0]);
        int pos2 = Integer.parseInt(split[1]);
        List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByStr(key);
        Vo_49183_0 vo_49183_0 = new Vo_49183_0();
        vo_49183_0.totalPage = saleGoodList.size() / 3;
        vo_49183_0.cur_page = pos1;
        int weizhi = (pos1 - 1) * 8;
        int size = saleGoodList.size() - (pos1 - 1) * 8;
        if (size > 8) {
            size = 8;
        }
        for (int i = 0; i < size; i++) {
            Vo_49183 vo_49183 = new Vo_49183();
            vo_49183.name = saleGoodList.get(i + weizhi).getName();
            vo_49183.is_my_goods = 0;
            vo_49183.id = saleGoodList.get(i + weizhi).getGoodsId();
            vo_49183.price = saleGoodList.get(i + weizhi).getPrice();
            vo_49183.status = 2;
            vo_49183.startTime = saleGoodList.get(i + weizhi).getStartTime();
            vo_49183.endTime = saleGoodList.get(i + weizhi).getEndTime();
            vo_49183.level = saleGoodList.get(i + weizhi).getLevel();
            vo_49183.unidentified = saleGoodList.get(i + weizhi).getLevel() > 0 ? 1 : 0;
            if (saleGoodList.get(i + weizhi).getIspet() == 2) {
                vo_49183.unidentified = 0;
            }
            vo_49183.amount = 1;
            vo_49183.req_level = saleGoodList.get(i + weizhi).getReqLevel();
            vo_49183.extra = "\"{\"rank\":2,\"enchant\":0,\"mount_type\":0,\"rebuild_level\":1,\"eclosion\":0}\"";
            vo_49183.item_polar = 0;
            vo_49183_0.vo_49183s.add(vo_49183);
        }
        vo_49183_0.path_str = key;
        vo_49183_0.select_gid = "";
        vo_49183_0.sell_stage = 2;
        vo_49183_0.sort_key = "price";
        vo_49183_0.is_descending = 0;
        GameObjectChar.send(new M49183_0(), vo_49183_0);

        Characters characters = GameData.that.characterService.finOnByGiD(saleGood.getOwnerUuid());
        Chara chara1 = JSONUtils.parseObject(characters.getData(), Chara.class);
        GameObjectChar session = GameObjectCharMng.getGameObjectChar(chara1.id);
        if (session != null) {
            session.chara.jishou_coin += price;
        } else {
            chara1.jishou_coin = chara1.jishou_coin + price;
            characters.setData(JSONUtils.toJSONString(chara1));
            GameData.that.characterService.updateById(characters);
        }
    }

    @Override
    public int cmd() {
        return 12490;
    }
}