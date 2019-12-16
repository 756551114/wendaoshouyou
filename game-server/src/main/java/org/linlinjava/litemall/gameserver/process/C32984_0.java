package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.fight.*;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C32984_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int auto_select = GameReadTool.readByte(buff);

        int multi_index = GameReadTool.readByte(buff);

        int action = GameReadTool.readByte(buff);

        int para = GameReadTool.readInt(buff);

        int multi_count = GameReadTool.readShort(buff);

        final Chara chara = GameObjectChar.getGameObjectChar().chara;

        boolean match = false;
        if (chara.id == id) {

            match = true;

        } else {
            Petbeibao pet = null;
            List<Petbeibao> pets = chara.pets;
            for (int j = 0; j < pets.size(); j++) {
                if (pets.get(j).id == chara.chongwuchanzhanId && pets.get(j).id == id) {
                    pet = pets.get(j);
                    break;
                }
            }
            if (pet != null) {
                match = true;
            }
        }
        if (match) {
            final FightObject fightObject = FightManager.getFightObject(id);

            if (fightObject != null) {
                fightObject.autofight_skillaction = action;
                fightObject.autofight_select = auto_select;
                fightObject.autofight_skillno = para;
                final FightContainer fightContainer = FightManager.getFightContainer();
                if (fightContainer.state.intValue() == 3) {
                    return;
                }

                final FightRequest fightRequest = new FightRequest();
                fightRequest.id = id;
                fightRequest.action = action;
                fightRequest.para = para;
                FightManager.generateActionDM(FightManager.getFightContainer(), fightObject, fightRequest);
                FightManager.addRequest(FightManager.getFightContainer(), fightRequest);
            }
        }
    }

    @Override
    public int cmd() {
        return 32984;
    }
}