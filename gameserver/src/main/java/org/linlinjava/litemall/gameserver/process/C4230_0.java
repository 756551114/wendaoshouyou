package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12269_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M12269_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4230_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        int owner_id = 1;
        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).id == id) {

                if (chara.pets.get(i).petShuXing.get(0).skill >= 50) {
                    owner_id = 10;
                }
                if (chara.pets.get(i).petShuXing.get(0).penetrate == 1) {
                    owner_id = 0;
                }
                chara.pets.remove(chara.pets.get(i));
                break;
            }
        }

        if (owner_id > 0) {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "获得了#R" + owner_id + "#n颗宠物经验丹。";
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);


            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = "宠物经验丹";
            vo_40964_0.param = "1";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);

            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName("宠物经验丹");
            GameUtil.huodedaoju(chara, storeInfo, owner_id);
        }
        Vo_12269_0 vo_12269_0 = new Vo_12269_0();
        vo_12269_0.id = id;
        vo_12269_0.owner_id = 96780;
        GameObjectChar.send(new M12269_0(), vo_12269_0);

    }

    @Override
    public int cmd() {
        return 4230;
    }
}