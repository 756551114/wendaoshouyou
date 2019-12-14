package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.write.M65499_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C216_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String name = GameReadTool.readString(buff);

        String para = GameReadTool.readString(buff);

        if (para.equals("")) {
            List<StoreGoods> all = GameData.that.baseStoreGoodsService.findAll();
            GameObjectChar.send(new M65499_0(), all);
        }



    }

    @Override
    public int cmd() {
        return 216;
    }
}