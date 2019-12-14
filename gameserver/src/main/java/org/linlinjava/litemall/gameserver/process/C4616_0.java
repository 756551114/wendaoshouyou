package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_11713_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53715_0;
import org.linlinjava.litemall.gameserver.data.write.M11713_0;
import org.linlinjava.litemall.gameserver.data.write.M53715_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.fight.FightContainer;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.fight.FightObject;
import org.linlinjava.litemall.gameserver.fight.FightRequest;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4616_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        final GameObjectChar session = GameObjectChar.getGameObjectChar();
        final Chara chara = session.chara;
        FightRequest fr = new FightRequest();
        fr.id = chara.id;
        fr.action = 9;
        fr.vid = 0;

        final FightContainer fightContainer = FightManager.getFightContainer();

        final FightObject fightObject = FightManager.getFightObject(fightContainer, chara.id);
        final FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, fightObject);
        if(fightObjectPet==null){
            final Vo_53715_0 vo_53715_0 = new Vo_53715_0();
            vo_53715_0.attacker_id = chara.id;
            vo_53715_0.victim_id = 0;
            vo_53715_0.action = 7;
            vo_53715_0.no = 0;
            GameObjectChar.send(new M53715_0(), vo_53715_0);

            final Vo_11713_0 vo_11713_0 = new Vo_11713_0();
            vo_11713_0.id = chara.id;
            vo_11713_0.show = 0;
            GameObjectChar.send(new M11713_0(), vo_11713_0);
        }
        FightManager.addRequest(fightContainer,fr);

    }

    @Override
    public int cmd() {
        return 4616;
    }
}