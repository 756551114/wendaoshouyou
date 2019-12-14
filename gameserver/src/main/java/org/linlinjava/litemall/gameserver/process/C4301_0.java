package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45104_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45105_0;
import org.linlinjava.litemall.gameserver.data.write.M45104_0;
import org.linlinjava.litemall.gameserver.data.write.M45105_0;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4301_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String item_cookie = GameReadTool.readString(buff);

        String[] split = item_cookie.split("\\;");
        String goodsid = split[0];
        String pos = split[1];

        SaleGood saleGood = GameData.that.saleGoodService.findOneByGoodsId(goodsid);
        if (saleGood == null) {
            return;
        }
        String goods = saleGood.getGoods();

        if (saleGood.getIspet() == 1) {
            Goods goods1 = JSONUtils.parseObject(goods, Goods.class);
            Vo_45104_0 vo_45104_0 = new Vo_45104_0();
            vo_45104_0.id = goodsid;
            vo_45104_0.status = 2;
            vo_45104_0.endTime = saleGood.getEndTime();
            vo_45104_0.goods = goods1;
            GameObjectChar.send(new M45104_0(), vo_45104_0);

        } else {
            Petbeibao petbeibao = JSONUtils.parseObject(goods, Petbeibao.class);
            Vo_45105_0 vo_45105_0 = new Vo_45105_0();
            vo_45105_0.goodId = goodsid;
            vo_45105_0.status = 2;
            vo_45105_0.endTime = saleGood.getEndTime();
            vo_45105_0.petbeibao = petbeibao;
            GameObjectChar.send(new M45105_0(), vo_45105_0);
            return;

        }


    }

    @Override
    public int cmd() {
        return 4301;
    }
}