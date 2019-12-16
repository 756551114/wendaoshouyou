package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45177_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8425_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M8425_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.data.write.M45177_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4382_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int pet_id = GameReadTool.readInt(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        chara.yidongsudu = 0;
        chara.zuoqiId = 0;
        chara.zuoqiwaiguan = 0;
        chara.zuowaiguan = 0;
        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).id == pet_id) {
                for (int j = 0; j < chara.pets.get(i).petShuXing.size(); j++) {
                    if (chara.pets.get(i).petShuXing.get(j).no == 23) {
                        chara.yidongsudu = chara.pets.get(i).petShuXing.get(0).capacity_level;
                    }
                }
                chara.zuoqiwaiguan = chara.pets.get(i).petShuXing.get(0).type + 1000;
                chara.zuowaiguan = typeMounts(chara.pets.get(i).petShuXing.get(0).type + 1000, chara.menpai, chara.sex - 1);
                chara.zuoqiId = chara.pets.get(i).id;
            }
        }

        if (pet_id != 0) {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "坐骑包裹已开启。";
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);
        } else {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "坐骑包裹已关闭。";
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);
        }


        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);

        Vo_8425_0 vo_8425_0 = new Vo_8425_0();
        vo_8425_0.id = pet_id;
        GameObjectChar.getGameObjectChar().gameMap.send(new M8425_0(), vo_8425_0);


      GameUtil.a65511(chara);


        Vo_45177_0 vo_45177_0 = new Vo_45177_0();
        vo_45177_0.id = chara.id;
        vo_45177_0.moveSpeedPercent = chara.yidongsudu;
        GameObjectChar.getGameObjectChar().gameMap.send(new M45177_0(), vo_45177_0);


    }

    @Override
    public int cmd() {
        return 4382;
    }

    private static int typeMounts(int type, int polar, int sex) {
        if (type == 31025) {
            int[][] type_31025 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31025[sex][polar - 1];
        } else if (type == 31010) {
            int[][] type_31010 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31010[sex][polar - 1];
        } else if (type == 31011) {
            int[][] type_31011 = {{760021, 770022, 770023, 760024, 760025, 760020}, {770021, 760022, 760023, 770024, 770025, 770020}};
            return type_31011[sex][polar - 1];
        } else if (type == 31013) {
            int[][] type_31013 = {{760021, 770022, 770023, 760024, 760025, 760020}, {770021, 760022, 760023, 770024, 770025, 770020}};
            return type_31013[sex][polar - 1];
        } else if (type == 31029) {
            int[][] type_31029 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31029[sex][polar - 1];
        } else if (type == 31026) {
            int[][] type_31026 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31026[sex][polar - 1];
        } else if (type == 31001) {
            int[][] type_31001 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31001[sex][polar - 1];
        } else if (type == 31019) {
            int[][] type_31019 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31019[sex][polar - 1];
        } else if (type == 31003) {
            int[][] type_31003 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31003[sex][polar - 1];
        } else if (type == 31020) {
            int[][] type_31020 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31020[sex][polar - 1];
        } else if (type == 31021) {
            int[][] type_31021 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31021[sex][polar - 1];
        } else if (type == 31006) {
            int[][] type_31006 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31006[sex][polar - 1];
        } else if (type == 31023) {
            int[][] type_31023 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31023[sex][polar - 1];

        }
        return 0;

    }
}