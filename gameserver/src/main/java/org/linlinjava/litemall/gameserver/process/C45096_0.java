package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0;
import org.linlinjava.litemall.gameserver.data.write.M9129_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


//集市摆摊较便宜的物品
@Service
public class C45096_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String key = GameReadTool.readString(buff);

        String eatra = GameReadTool.readString(buff);

        int type = GameReadTool.readByte(buff);

        SaleClassifyGood classifyGood = GameData.that.baseSaleClassifyGoodService.findOneByCompose(key);
        if (classifyGood == null) {
            return;
        }
        Integer price = classifyGood.getPrice();
        String str = classifyGood.getStr();

        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 45;
        vo_9129_0.para = "{150:" + (int) (price * 1.5) + ",140:" + (int) (price * 1.4) + ",130:" + (int) (price * 1.3) + ",120:" + (int) (price * 1.2) + ",110:" + (int) price * 1.1 + ",100:" + price + ",90:" + (int) (price * 0.9) + ",80:" + (int) (price * 0.8) + ",70:" + (int) (price * 0.7) + ",60:" + (int) (price * 0.6) + ",50:" + (int) (price * 0.5) + ",\"name\":\"" + str + "\"}";
        GameObjectChar.send(new M9129_0(), vo_9129_0);
    }

    @Override
    public int cmd() {
        return 45096;
    }
}