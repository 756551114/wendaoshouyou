package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.write.M12016_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class C4347_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int guard_id = GameReadTool.readInt(buff);

        int cheer = GameReadTool.readByte(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        for (int i = 0; i < chara.listshouhu.size(); i++) {
            if (guard_id == chara.listshouhu.get(i).id) {
                if (cheer == 1) {
                    if (chara.canzhanshouhunumber == 0) {
                        chara.canzhanshouhunumber++;
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = 5;
                    } else {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = chara.canzhanshouhunumber;
                        chara.canzhanshouhunumber++;
                    }
                }

                if (cheer == 0) {
                    chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = 0;
                    chara.canzhanshouhunumber--;
                }
                chara.listshouhu.get(i).listShouHuShuXing.get(0).nil = cheer;
                List<ShouHu> list = new LinkedList<>();
                list.add(chara.listshouhu.get(i));
                GameObjectChar.send(new M12016_0(), list);
            }
        }




    }

    @Override
    public int cmd() {
        return 4347;
    }
}