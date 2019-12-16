package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;
import org.linlinjava.litemall.gameserver.data.GameReadTool;

import java.util.ArrayList;
import java.util.List;

@Service
public class C8254_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int type = GameReadTool.readByte(buff);

        int para1 = GameReadTool.readShort(buff);

        int para2 = GameReadTool.readShort(buff);

        int para3 = GameReadTool.readShort(buff);

        int para4 = GameReadTool.readShort(buff);

        int para5 = GameReadTool.readShort(buff);

        int para6 = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (para1 > 3000) {
            para1 = para1 - 65536;
        }
        if (para2 > 3000) {
            para2 = para2 - 65536;
        }
        if (para3 > 3000) {
            para3 = para3 - 65536;
        }
        if (para4 > 3000) {
            para4 = para4 - 65536;
        }
        if (para5 > 3000) {
            para5 = para5 - 65536;
        }

        int fen = 0;
        if (id == 0) {
            if (type == 1) {
                fen = 59;
            } else {
                fen = 164;
            }
        } else {
            fen = 36;
        }

        int zong = para1 + para2 + para3 + para4 + para5;
        if (zong < 0) {
            if (chara.balance < zong * (-fen)) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "元宝不足";
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectChar.send(new M20481_0(), vo_20481_0);
            } else {
                chara.extra_life = chara.extra_life - (-zong) * fen;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            }
        }

        if (id == 0) {
            int count = para1 + para2 + para3 + para4 + para5;
            if (type == 1) {
                chara.life += para1;
                chara.mag_power += para2;
                chara.phy_power += para3;
                chara.speed += para4;
                chara.polar_point = chara.polar_point - count;
            } else if (type == 2) {
                chara.resist_metal += para5;
                chara.wood += para1;
                chara.water += para2;
                chara.fire += para3;
                chara.earth += para4;
                chara.stamina = chara.stamina - count;
            }
//        BasicAttributesUtils.shuxing(chara);
            ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), vo_65527_0);

        } else {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.id == id) {
                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);


                    int count = para1 + para2 + para3 + para4 + para5;
                    petShuXing.life += para1;
                    petShuXing.mag_power += para2;
                    petShuXing.phy_power += para3;
                    petShuXing.speed += para4;

                    petShuXing.polar_point = petShuXing.polar_point - count;

                    BasicAttributesUtils.petshuxing(petShuXing);


                    List list = new ArrayList();
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                }
            }
        }
    }

    @Override
    public int cmd() {
        return 8254;
    }
}