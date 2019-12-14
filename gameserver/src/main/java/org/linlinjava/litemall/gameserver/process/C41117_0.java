package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_3;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class C41117_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int no = GameReadTool.readByte(buff);

        int num1 = GameReadTool.readShort(buff);

        int num2 = GameReadTool.readShort(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;

        int id = 0;
        int pot = 0;
        int resist_poison = 0;

        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).no == no) {
                if (chara.pets.get(i).petShuXing.get(0).skill>=chara.level||chara.pets.get(i).petShuXing.get(0).skill>=120){
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "无法使用";
                    vo_20481_0.time = (int) (System.currentTimeMillis()/1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    return;
                }
                id = chara.pets.get(i).id;
                GameUtil.addpetjingyan(chara.pets.get(i), num1 * 500000,chara);
                pot = chara.pets.get(i).petShuXing.get(0).pot;
                resist_poison = chara.pets.get(i).petShuXing.get(0).resist_poison;
                break;
            }
        }
        GameUtil.removemunber(chara, "宠物经验丹", num1);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你使用了#R" + num1 + "#n颗宠物经验丹。";
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new M20481_0(), vo_20481_0);


        List list = new LinkedList();
        list.add(id);
        list.add(pot);
        list.add(resist_poison);
        GameObjectChar.send(new M65527_3(), list);

    }

    @Override
    public int cmd() {
        return 41117;
    }
}