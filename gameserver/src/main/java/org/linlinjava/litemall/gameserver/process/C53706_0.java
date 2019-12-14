package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_5;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class C53706_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int no = GameReadTool.readByte(buff);

        int num = GameReadTool.readShort(buff);

        int flag = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if (flag == 1) {
            for (int i = 0; i < chara.pets.size(); i++) {
                if (chara.pets.get(i).no == no) {
                    chara.pets.get(i).petShuXing.get(0).shape += 2000 * num;
                    GameUtil.removemunber(chara, "超级神兽丹", num);
                    List list = new ArrayList();
                    list.add(chara.pets.get(i));
                    GameObjectChar.send(new M65507_0(), list);
                    List list1 = new LinkedList();
                    list1.add(chara.pets.get(i).id);
                    list1.add(chara.pets.get(i).petShuXing.get(0).shape);
                    GameObjectChar.send(new M65527_5(), list1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "增加#R" + 2000 * num + "点#n亲密度。";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                }
            }
        }
    }

    @Override
    public int cmd() {
        return 53706;
    }
}