package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C53314_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {


        String type = GameReadTool.readString(buff);

        int no = GameReadTool.readInt(buff);

        String pos = GameReadTool.readString(buff);

        String other_pet = GameReadTool.readString(buff);

        String cost_type = GameReadTool.readString(buff);

        String ids = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;



        if (type.equals("pet_open_eclosion")) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "恭喜，你的#Y" + petbeibao.petShuXing.get(0).str + "#n已成功#G开启羽化";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);

                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);

                    int quality = petbeibao.petShuXing.get(0).penetrate - 1;


                    int[] appends = {petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_mag_shape, petShuXing.rank, petShuXing.pet_phy_shape};
                    int[] ints = PetAttributesUtils.emergencePet(quality, petShuXing.attrib, petbeibao.petShuXing.get(0).eclosion_nimbus, petShuXing.max_eclosion_nimbus, 1, 0, 0, appends);
//                    petbeibao.petShuXing.get(0).status_yanchuan_shenjiao = 1;
                    if (ints[0] == 1) {
                        petbeibao.petShuXing.get(0).eclosion_nimbus = 2;
                    } else {
                        petbeibao.petShuXing.get(0).eclosion_nimbus = 1;
                    }
                    //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
                    petbeibao.petShuXing.get(0).max_eclosion_nimbus = ints[1];
//                    petbeibao.petShuXing.get(0).pet_mana_shape += ints[2];
//                    petbeibao.petShuXing.get(0).pet_speed_shape += ints[3];
//                    petbeibao.petShuXing.get(0).pet_mag_shape += ints[4];
//                    petbeibao.petShuXing.get(0).rank += ints[5];
//                    petbeibao.petShuXing.get(0).pet_phy_shape += ints[6];
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    GameUtil.removemunber(chara, "羽化丹", 1);
                    GameObjectChar.send(new M53607_0(), null);
                }
            }
        }

        if (type.equals("pet_eclosion")) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "恭喜，你的#Y" + petbeibao.petShuXing.get(0).str + "#n获得灵气";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);
                    int quality = petbeibao.petShuXing.get(0).penetrate;
                    String[] split = pos.split("\\|");
                    int pill = 0;
                    int unidentifiedMoney = 0;
                    int equiqmentMoney = 0;
                    for (int j = 0; j < chara.backpack.size(); j++) {
                        Goods goods = chara.backpack.get(j);
                        for (int k = 0; k < split.length; k++) {

                            if (goods.pos == Integer.parseInt(split[k])) {
                                if (goods.goodsInfo.str.equals("羽化丹")) {
                                    pill++;
                                } else {
                                    if (goods.goodsInfo.degree_32 == 0) {
                                        unidentifiedMoney += 10000;
                                    } else {
                                        equiqmentMoney += 10000;
                                    }
                                    List<Goods> listbeibao = new ArrayList<>();
                                    Goods goods1 = new Goods();
                                    goods1.goodsBasics = null;
                                    goods1.goodsInfo = null;
                                    goods1.goodsLanSe = null;
                                    goods1.pos = goods.pos;
                                    listbeibao.add(goods1);
                                    chara.backpack.remove(chara.backpack.get(j));
                                    GameObjectChar.send(new M65525_0(), listbeibao);
                                }
                            }
                        }
                    }


                    int[] appends = {petShuXing.mana_effect + 40, petShuXing.attack_effect + 40, petShuXing.mag_effect + 40, petShuXing.phy_absorb + 40, petShuXing.phy_effect + 40};
                    int[] ints = PetAttributesUtils.emergencePet(quality, petShuXing.attrib, petbeibao.petShuXing.get(0).status_yanchuan_shenjiao + 1, petShuXing.max_eclosion_nimbus, pill, equiqmentMoney, equiqmentMoney, appends);
                    if (ints[0] == 1) {
                        int count = petbeibao.petShuXing.get(0).status_yanchuan_shenjiao++;
                        petbeibao.petShuXing.get(0).max_eclosion_nimbus = 0;
                        petbeibao.petShuXing.get(0).pet_mana_shape = petbeibao.petShuXing.get(0).pet_mana_shape + ints[2] / 3;
                        petbeibao.petShuXing.get(0).pet_speed_shape = petbeibao.petShuXing.get(0).pet_speed_shape + ints[3] / 3;
                        petbeibao.petShuXing.get(0).pet_mag_shape = petbeibao.petShuXing.get(0).pet_mag_shape + ints[4] / 3;
                        petbeibao.petShuXing.get(0).rank = petbeibao.petShuXing.get(0).rank + ints[5] / 3;
                        petbeibao.petShuXing.get(0).pet_phy_shape = petbeibao.petShuXing.get(0).pet_phy_shape + ints[6] / 3;
                    } else {
                        petbeibao.petShuXing.get(0).max_eclosion_nimbus = ints[1];

                    }
                    if (petbeibao.petShuXing.get(0).status_yanchuan_shenjiao > 2) {
                        petbeibao.petShuXing.get(0).status_yanchuan_shenjiao = 2;
                        petbeibao.petShuXing.get(0).eclosion_nimbus++;
                        petbeibao.petShuXing.get(0).max_eclosion_nimbus = 0;

//                        petbeibao.petShuXing.get(0).pet_mana_shape = petbeibao.petShuXing.get(0).mana_effect + ints[2] + 40;
//                        petbeibao.petShuXing.get(0).pet_speed_shape = petbeibao.petShuXing.get(0).attack_effect + ints[3] + 40;
//                        petbeibao.petShuXing.get(0).pet_mag_shape = petbeibao.petShuXing.get(0).mag_effect + ints[4] + 40;
//                        petbeibao.petShuXing.get(0).rank = petbeibao.petShuXing.get(0).phy_absorb + ints[5] + 40;
//                        petbeibao.petShuXing.get(0).pet_phy_shape = petbeibao.petShuXing.get(0).phy_effect + ints[6] + 40;
                    }
                    //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
//                    //洗练面板 血气成长93   客户端算法+40
//                    public int mana_effect=19;
//                    //洗炼面板   法力成长60  客户端算法+40
//                    public int attack_effect=1;
//                    //洗炼面板  速度成长48      客户端算法+40
//                    public int phy_effect;
//                    //洗炼面板  物攻成长6   65502+40=65542-65536=6
//                    public int mag_effect=16;
//                    //洗炼面板 法攻成长57    17+40
//                    public int phy_absorb=65504;

                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    GameUtil.removemunber(chara, "羽化丹", pill);
                    GameObjectChar.send(new M53607_0(), null);
                }
            }


        }


        if (type.equals("pet_enchant")) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();

                    vo_20481_0.msg = "恭喜，你的#Y" + petbeibao.petShuXing.get(0).str + "#n获得灵气";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);

                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);


                    int quality = petbeibao.petShuXing.get(0).penetrate - 1;

                    String[] split = pos.split("\\|");
                    int pill = 0;
                    int unidentifiedMoney = 0;
                    int equiqmentMoney = 0;
                    for (int j = 0; j < chara.backpack.size(); j++) {
                        Goods goods = chara.backpack.get(j);
                        for (int k = 0; k < split.length; k++) {
                            if (goods.pos == Integer.parseInt(split[k])) {
                                if (goods.goodsInfo.str.equals("点化丹")) {
                                    pill++;
                                } else {
                                    if (goods.goodsInfo.degree_32 == 0) {
                                        unidentifiedMoney += 10000;
                                    } else {
                                        equiqmentMoney += 10000;
                                    }
                                    List<Goods> listbeibao = new ArrayList<>();
                                    Goods goods1 = new Goods();
                                    goods1.goodsBasics = null;
                                    goods1.goodsInfo = null;
                                    goods1.goodsLanSe = null;
                                    goods1.pos = goods.pos;
                                    listbeibao.add(goods1);
                                    chara.backpack.remove(chara.backpack.get(j));
                                    GameObjectChar.send(new M65525_0(), listbeibao);
                                }
                            }
                        }
                    }


                    int[] appends = {petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_mag_shape, petShuXing.rank, petShuXing.pet_phy_shape};
                    int[] ints = PetAttributesUtils.dotPet(quality, petShuXing.attrib, petShuXing.max_enchant_nimbus, pill, equiqmentMoney, equiqmentMoney, appends);
                    if (ints[0] == 1) {
                        petbeibao.petShuXing.get(0).enchant_nimbus = 2;
                    } else {
                        petbeibao.petShuXing.get(0).enchant_nimbus = 1;
                    }
                    //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
//                    //洗练面板 血气成长93   客户端算法+40
//                    public int mana_effect=19;
//                    //洗炼面板   法力成长60  客户端算法+40
//                    public int attack_effect=1;
//                    //洗炼面板  速度成长48      客户端算法+40
//                    public int phy_effect;
//                    //洗炼面板  物攻成长6   65502+40=65542-65536=6
//                    public int mag_effect=16;
//                    //洗炼面板 法攻成长57    17+40
//                    public int phy_absorb=65504;
                    petbeibao.petShuXing.get(0).max_enchant_nimbus = ints[1];
                    petbeibao.petShuXing.get(0).pet_mana_shape = petbeibao.petShuXing.get(0).mana_effect + ints[2] + 40;
                    petbeibao.petShuXing.get(0).pet_speed_shape = petbeibao.petShuXing.get(0).attack_effect + ints[3] + 40;
                    petbeibao.petShuXing.get(0).pet_mag_shape = petbeibao.petShuXing.get(0).mag_effect + ints[4] + 40;
                    petbeibao.petShuXing.get(0).rank = petbeibao.petShuXing.get(0).phy_absorb + ints[5] + 40;
                    petbeibao.petShuXing.get(0).pet_phy_shape = petbeibao.petShuXing.get(0).phy_effect + ints[6] + 40;
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    GameUtil.removemunber(chara, "点化丹", pill);
                    GameObjectChar.send(new M45670_0(), null);
                }
            }

        }

        if (type.equals("pet_open_enchant")) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(petbeibao.petShuXing.get(0).str);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "恭喜，你的#Y" + petbeibao.petShuXing.get(0).str + "#n已成功#G开启点化";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);

                    PetShuXing petShuXing = petbeibao.petShuXing.get(0);

                    int quality = petbeibao.petShuXing.get(0).penetrate - 1;

//  //原始的气血 法力 物伤 法伤 速度
                    int[] appends = {petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_mag_shape, petShuXing.rank, petShuXing.pet_phy_shape};
                    int[] ints = PetAttributesUtils.dotPet(quality, petShuXing.attrib, petShuXing.max_enchant_nimbus, 1, 0, 0, appends);

                    if (ints[0] == 1) {
                        petbeibao.petShuXing.get(0).enchant_nimbus = 2;
                    } else {
                        petbeibao.petShuXing.get(0).enchant_nimbus = 1;
                    }
                    //[0] 是否完成 1完成0未完成  [1]当前的总点化灵气  [2-6]气血 法力 物伤 法伤 速度  返回点化增加的   点化面板显示的总的
                    petbeibao.petShuXing.get(0).max_enchant_nimbus = ints[1];
                    petbeibao.petShuXing.get(0).pet_mana_shape += ints[2];
                    petbeibao.petShuXing.get(0).pet_speed_shape += ints[3];
                    petbeibao.petShuXing.get(0).pet_mag_shape += ints[4];
                    petbeibao.petShuXing.get(0).rank += ints[5];
                    petbeibao.petShuXing.get(0).pet_phy_shape += ints[6];
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    GameUtil.removemunber(chara, "点化丹", 1);
                    GameObjectChar.send(new M45670_0(), null);
                }
            }
        }

    }

    @Override
    public int cmd() {
        return 53314;
    }
}