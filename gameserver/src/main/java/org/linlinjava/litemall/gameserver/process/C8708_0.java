package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.fight.FightContainer;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class C8708_0 implements GameHandler {
    static boolean b = true;
    private static final Logger log = LoggerFactory.getLogger(C8708_0.class);
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int answer = GameReadTool.readInt(buff);
        final int id = GameObjectChar.getGameObjectChar().chara.id;
        final FightContainer fightContainer = FightManager.getFightContainer();
        if(fightContainer == null){
            return;
        }
        if(fightContainer.state.compareAndSet(3, 1) || fightContainer.state.get() == 4){
            FightManager.nextRoundOrSendOver(FightManager.getFightContainer());
        }
    }

    @Override
    public int cmd() {
        return 8708;
    }
}
