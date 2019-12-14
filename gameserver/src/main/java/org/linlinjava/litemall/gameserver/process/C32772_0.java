package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C32772_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int no = GameReadTool.readByte(buff);

        int is_set = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (is_set == 1) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                    PetShuXing shuXing = petbeibao.petShuXing.get(0);
                    shuXing.pet_mana_shape = shuXing.pet_mana_shape + shuXing.pet_mana_shape_temp;
                    shuXing.pet_speed_shape = shuXing.pet_speed_shape + shuXing.pet_speed_shape_temp;
                    shuXing.pet_phy_shape = shuXing.pet_phy_shape + shuXing.pet_phy_shape_temp;
                    shuXing.pet_mag_shape = shuXing.pet_mag_shape + shuXing.pet_mag_shape_temp;
                    shuXing.rank = shuXing.rank + shuXing.evolve_degree;

                    shuXing.mana_effect = shuXing.mana_effect + shuXing.pet_mana_shape_temp;
                    shuXing.attack_effect = shuXing.attack_effect + shuXing.pet_speed_shape_temp;
                    shuXing.mag_effect = shuXing.mag_effect + shuXing.pet_mag_shape_temp;
                    shuXing.phy_absorb = shuXing.phy_absorb + shuXing.evolve_degree;
                    shuXing.phy_effect = shuXing.phy_effect + shuXing.pet_phy_shape_temp;

                    //洗炼  洗炼气血成长 洗炼后未点替换成长显示+
                    shuXing.pet_mana_shape_temp = 0;
                    //洗炼  洗炼法力成长 洗炼后未点替换成长显示+
                    shuXing.pet_speed_shape_temp = 0;
                    //洗炼  洗炼速度成长 洗炼后未点替换成长显示+
                    shuXing.pet_phy_shape_temp = 0;
                    //洗炼  洗炼物攻成长 洗炼后未点替换成长显示+
                    shuXing.pet_mag_shape_temp = 0;
                    //洗炼  洗炼法攻成长 洗炼后未点替换成长显示+
                    shuXing.evolve_degree = 0;


                    List list = new ArrayList();
//更新技能 没写； //32747   //12023
                    BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                    shuXing.max_life = shuXing.def;
                    shuXing.max_mana = shuXing.dex;
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "你的#Y" + pet.getName() + "#n经过洗炼，基础成长已重新生成。";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);

                }
            }
        }


    }

    @Override
    public int cmd() {
        return 32772;
    }
}