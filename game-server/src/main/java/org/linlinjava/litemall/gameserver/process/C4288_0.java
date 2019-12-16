package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;
import org.linlinjava.litemall.gameserver.data.GameReadTool;

import java.util.Map;

@Service
public class C4288_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String select = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        boolean haschenhao = false;
        for (Map.Entry<String, String> entry : chara.chenghao.entrySet()) {
            if (entry.getKey().equals(select)) {
                chara.chenhao = entry.getValue();
                haschenhao = true;
            }
        }
        if (!haschenhao) {
            chara.chenhao = "";
        }
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);
    }

    @Override
    public int cmd() {
        return 4288;
    }
}