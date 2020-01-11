package org.linlinjava.litemall.gameserver.util;

import com.cool.wendao.community.model.Pet;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.process.GameUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 强化BB
 */
public class QiangHuaPet {

    public static void mag(int no, Chara chara){
        for (int i = 0; i < chara.pets.size(); i++) {
            Petbeibao petbeibao = chara.pets.get(i);
            if (petbeibao.no == no) {
                Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                int[] ints = PetAttributesUtils.upgradePet(true, pet.getMagAttack(), petbeibao.petShuXing.get(0).raw_name, petbeibao.petShuXing.get(0).life_add_temp);
                if (petbeibao.petShuXing.get(0).raw_name < ints[0]) {
                    petbeibao.petShuXing.get(0).pet_life_shape_temp += ints[1];
                    petbeibao.petShuXing.get(0).rank += ints[1];
                    petbeibao.petShuXing.get(0).life_add_temp = 0;
                    petbeibao.petShuXing.get(0).raw_name = ints[0];
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "恭喜强化成功！";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                } else {
                    petbeibao.petShuXing.get(0).life_add_temp = ints[2];
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "成长完成度增加了！";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                }
                GameUtil.removemunber(chara, "宠物强化丹", 1);
                List list = new ArrayList();
                BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                list.add(petbeibao);
                GameObjectChar.send(new M65507_0(), list);
                //更新技能 没写； //32747   //12023

                break;
            }
        }


    }

}
