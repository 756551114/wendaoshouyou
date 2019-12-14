package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_14337_0;
import org.linlinjava.litemall.gameserver.data.write.M14337_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C14338_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int type = GameReadTool.readByte(buff);

        int para1 = GameReadTool.readShort(buff);

        int para2 = GameReadTool.readShort(buff);

        int para3 = GameReadTool.readShort(buff);

        int para4 = GameReadTool.readShort(buff);

        int para5 = GameReadTool.readShort(buff);

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


        if (0 == id) {
            Vo_14337_0 vo_14337_0 = new Vo_14337_0();
            if (type == 1) {
                //气血	法力	 物伤  法伤	速度  	防御
                int[] ints = BasicAttributesUtils.changeCalculationAttributes(chara.level, para1, para2, para3, para4);
                vo_14337_0.id = 0;
                vo_14337_0.type = 1;
                vo_14337_0.life_plus = ints[0];
                vo_14337_0.max_life_plus = ints[0];
                vo_14337_0.mana_plus = ints[1];
                vo_14337_0.max_mana_plus = ints[1];
                vo_14337_0.phy_power_plus = ints[2];
                vo_14337_0.mag_power_plus = ints[3];
                vo_14337_0.speed_plus = ints[4];
                vo_14337_0.def_plus = ints[5];
                vo_14337_0.free = 0;
            } else if (type == 2) {
                int[] ints = BasicAttributesUtils.changeRelAttributes(chara.level, chara.life, chara.mag_power, chara.phy_power, chara.speed, para1, para2, para3, para4, para5);
                vo_14337_0.id = 0;
                vo_14337_0.type = 1;
                vo_14337_0.life_plus = ints[0];
                vo_14337_0.max_life_plus = ints[0];
                vo_14337_0.mana_plus = ints[1];
                vo_14337_0.max_mana_plus = ints[1];
                vo_14337_0.phy_power_plus = ints[2];
                vo_14337_0.mag_power_plus = ints[3];
                vo_14337_0.speed_plus = ints[4];
                vo_14337_0.def_plus = ints[5];
                vo_14337_0.free = 0;
            }
            GameObjectChar.send(new M14337_0(), vo_14337_0);
        } else {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.id == id) {
                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);

                    boolean fagong = petShuXing.rank > petShuXing.pet_mag_shape;

                    //当前力量
//                    public int phy_power=1;
//                    //当前灵力
//                    public int mag_power=1;
//                    //当前体力
//                    public int life=1;
//                    //当前敏捷
//                    public int speed=1;
                    int[] ints = PetAttributesUtils.petAttributes(fagong, petShuXing.skill, petShuXing.life + para1, petShuXing.mag_power + para2, petShuXing.phy_power + para3, petShuXing.speed + para4, petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_phy_shape, petShuXing.pet_mag_shape, petShuXing.rank);
                    int[] ints1 = PetAttributesUtils.petAttributes(fagong, petShuXing.skill, petShuXing.life, petShuXing.mag_power, petShuXing.phy_power, petShuXing.speed, petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_phy_shape, petShuXing.pet_mag_shape, petShuXing.rank);
                    Vo_14337_0 vo_14337_0 = new Vo_14337_0();
                    vo_14337_0.id = id;
                    vo_14337_0.type = 1;
                    vo_14337_0.life_plus = ints[0] - ints1[0];
                    vo_14337_0.max_life_plus = ints[0] - ints1[0];
                    vo_14337_0.mana_plus = ints[1] - ints1[1];
                    vo_14337_0.max_mana_plus = ints[1] - ints1[1];
                    vo_14337_0.phy_power_plus = ints[2] - ints1[2];
                    vo_14337_0.mag_power_plus = ints[3] - ints1[3];
                    vo_14337_0.speed_plus = ints[4] - ints1[4];
                    vo_14337_0.def_plus = ints[5] - ints1[5];
                    vo_14337_0.free = 0;
                    GameObjectChar.send(new M14337_0(), vo_14337_0);

                }
            }
        }

    }

    @Override
    public int cmd() {
        return 14338;
    }
}