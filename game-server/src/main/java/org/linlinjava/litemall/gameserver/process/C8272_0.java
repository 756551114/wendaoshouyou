package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_2;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class C8272_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
//2
        int no = GameReadTool.readByte(buff);
//鬼火萤123
        String name = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        int id = 0;
        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).no == no) {
                id = chara.pets.get(i).id;
                chara.pets.get(i).petShuXing.get(0).str = name;
            }
        }
        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "宠物名字修改成功。";
        vo_8165_0.active = 0;
        Vo_65527_0 vo_65527_35 = new Vo_65527_0();
        List list = new LinkedList();
        list.add(id);
        list.add(name);
        GameObjectChar.send(new M65527_2(), list);


    }

    @Override
    public int cmd() {
        return 8272;
    }
}