package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_01;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C16502_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int from_pos = GameReadTool.readShort(buff);

        int to_pos = GameReadTool.readShort(buff);

        int amount = GameReadTool.readShort(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.cangku.size(); i++) {
            if (chara.cangku.get(i).pos == from_pos) {

                Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                vo_40964_0.type = 1;
                vo_40964_0.name = chara.cangku.get(i).goodsInfo.str;
                vo_40964_0.param = "156482";
                vo_40964_0.rightNow = 2;
                GameObjectChar.send(new M40964_0(), vo_40964_0);

                chara.cangku.get(i).pos = GameUtil.beibaoweizhi(chara);
                GameUtil.addwupin(chara.cangku.get(i), chara);
                chara.cangku.remove(chara.cangku.get(i));
                GameObjectChar.send(new M65525_0(), chara.backpack);
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.pos = from_pos;
                GameObjectChar.send(new M61677_01(), vo_61677_0);


            }
        }
    }

    @Override
    public int cmd() {
        return 16502;
    }
}