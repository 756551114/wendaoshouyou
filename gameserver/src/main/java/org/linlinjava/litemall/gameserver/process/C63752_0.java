package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.*;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.NoviceGiftBagUtils;
import org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.*;
import org.linlinjava.litemall.gameserver.fight.*;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map;

@Service
public class C63752_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int type = GameReadTool.readShort(buff);

        String para1 = GameReadTool.readString(buff);

        String para2 = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if (type == 20023) {
            Vo_9129_0 vo_9129_52 = new Vo_9129_0();
            vo_9129_52.notify = 10001;
            vo_9129_52.para = "chaoji_goon";
            GameObjectChar.getGameObjectChar().send(new M9129_0(), vo_9129_52);

            Vo_61553_0 vo_61553_0 = new Vo_61553_0();
            vo_61553_0.count = 1;
            vo_61553_0.task_type = "超级宝藏";
            vo_61553_0.task_desc = "";
            vo_61553_0.task_prompt = "";
            vo_61553_0.refresh = 1;
            vo_61553_0.task_end_time = 1567909190;
            vo_61553_0.attrib = 1;
            vo_61553_0.reward = "";
            vo_61553_0.show_name = "";
            vo_61553_0.tasktask_extra_para = "";
            vo_61553_0.tasktask_state = "1";
            GameObjectChar.getGameObjectChar().send(new M61553_0(), vo_61553_0);
            String[] strings = GameUtilRenWu.luckFindDraw();
            GameUtil.huodechoujiang(strings, chara);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "喜从天降,恭喜#Y" + chara.name + "#n在高级挖宝中获得#R" + strings[1] + "#n ";
            vo_8165_0.active = 0;
            GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().upduizhangid).send(new M8165_0(), vo_8165_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "喜从天降,恭喜#Y" + chara.name + "#n在高级挖宝中获得#R" + strings[1] + "#n ";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);

            if (!strings[1].equals("金币")) {
                Vo_16383_0 vo_16383_5 = new Vo_16383_0();
                vo_16383_5.channel = 6;
                vo_16383_5.id = 0;
                vo_16383_5.name = "";
                vo_16383_5.msg = "喜从天降,恭喜#Y" + chara.name + "#n在高级挖宝中获得#R" + strings[1] + "#n ";
                vo_16383_5.time = (int) (System.currentTimeMillis() / 1000);
                vo_16383_5.privilege = 0;
                vo_16383_5.server_name = "3周年14线";
                vo_16383_5.show_extra = 1;
                vo_16383_5.compress = 0;
                vo_16383_5.orgLength = 65535;
                vo_16383_5.cardCount = 0;
                vo_16383_5.voiceTime = 0;
                vo_16383_5.token = "";
                vo_16383_5.checksum = 0;
                GameObjectCharMng.sendAll(new M16383_0(), vo_16383_5);
            }

        }

//宠风散开关;
        if (type == 30046) {
            if (chara.chongfengsan == 0) {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你已开启宠风散功能。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.chongfengsan = 1;
            } else {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你已关闭宠风散功能。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.chongfengsan = 0;
            }
        }

        //紫气鸿蒙开关；
        if (type == 30048) {
            if (chara.ziqihongmeng == 0) {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你已开启紫气鸿蒙功能。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.ziqihongmeng = 1;
            } else {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你已关闭紫气鸿蒙功能。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.ziqihongmeng = 0;
            }
        }
        //点开刷到面板
        if (type == 30002) {
            GameUtil.a45060(chara);
        }

        //双倍开关
        if (type == 52) {
            if (chara.charashuangbei == 0) {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "成功开启双倍点数，部分活动将消耗双倍点数获得双倍奖励。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.charashuangbei = 1;
            } else {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "成功关闭双倍点数，双倍点数将不再消耗。";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                chara.charashuangbei = 0;
            }
        }


        //关闭驱魔香
        if (type == 20009) {

            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "成功关闭驱魔香，在练功区走动时将会遇怪。";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 20010;
            vo_9129_0.para = "0";
            GameObjectChar.send(new M9129_0(), vo_9129_0);
            chara.qumoxiang = 0;

        }
        //开启驱魔香
        if (type == 20008) {
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "成功开启驱魔香，在练功区走动时将无法遇怪。";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            Vo_9129_0 vo_9129_0 = new Vo_9129_0();
            vo_9129_0.notify = 20010;
            vo_9129_0.para = "1";
            GameObjectChar.send(new M9129_0(), vo_9129_0);
            chara.qumoxiang = 1;

        }
//        改名字
        if (type == 1) {

            if (GameData.that.baseCharactersService.findOneByName(para1) != null) {
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "该名字已有人使用";
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                return;
            }
            Characters characters = GameData.that.baseCharactersService.findById(chara.id);
            characters.setName(para1);
            GameUtil.removemunber(chara, "改头换面卡", 1);
            chara.name = para1;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "修改成功";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            GameData.that.baseCharactersService.updateById(characters);
        }

        if (type == 40005) {
            Characters characters = GameData.that.characterService.finOnByGiD(para1);
            String data = characters.getData();
            Chara charaCha = JSONUtils.parseObject(data, Chara.class);
            Vo_49153_0 vo_49153_0 = new Vo_49153_0();
            vo_49153_0.name = chara.name;
            vo_49153_0.level = chara.level;
            vo_49153_0.icon = chara.waiguan;
            vo_49153_0.special_icon = chara.special_icon;
            vo_49153_0.weapon_icon = chara.weapon_icon;
            vo_49153_0.suit_icon = chara.suit_icon;
            vo_49153_0.suit_effect = chara.suit_light_effect;
            vo_49153_0.power = 0;
            vo_49153_0.partyName = "";
            vo_49153_0.fashionIcon = 0;
            vo_49153_0.upgradetype = 0;
            vo_49153_0.upgradelevel = 0;
            for (int i = 0; i < charaCha.backpack.size(); i++) {
                if (charaCha.backpack.get(i).pos <= 10) {
                    vo_49153_0.backpack.add(charaCha.backpack.get(i));
                }
            }
            GameObjectChar.send(new M49153_0(), vo_49153_0);
        }
//        活动
        if (32 == type) {

        }
//        移除妖石
        if (4 == type) {
            for (int i = 0; i < chara.pets.size(); i++) {
                if (chara.pets.get(i).no == Integer.valueOf(para1)) {
                    Petbeibao petbeibao = chara.pets.get(i);
                    int wiz = 0;
                    int parry = 0;
                    int def = 0;
                    int dex = 0;
                    int mana = 0;
                    int accurate = 0;
                    for (int j = 0; j < petbeibao.petShuXing.size(); j++) {
                        if (petbeibao.petShuXing.get(j).str.equals(para2)) {
                            PetShuXing petShuXing = petbeibao.petShuXing.get(j);
                            wiz = petShuXing.wiz;
                            parry = petShuXing.parry;
                            def = petShuXing.def;
                            dex = petShuXing.dex;
                            mana = petShuXing.mana;
                            accurate = petShuXing.accurate;
                            petbeibao.petShuXing.remove(petbeibao.petShuXing.get(j));
                        }
                    }

                    for (int j = 0; j < petbeibao.petShuXing.size(); j++) {
                        if (petbeibao.petShuXing.get(j).no == 0) {
                            PetShuXing petShuXing = petbeibao.petShuXing.get(j);
                            petShuXing.wiz -= wiz;
                            petShuXing.parry -= parry;
                            petShuXing.def -= def;
                            petShuXing.dex -= dex;
                            petShuXing.mana -= mana;
                            petShuXing.accurate -= accurate;
                        }
                    }


                    List list = new ArrayList();
                    list.add(chara.pets.get(i));
                    GameObjectChar.send(new M65507_0(), list);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = "移除妖石成功！";
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                }
            }
        }
        if (40013 == type) {


            int attrib = (Integer.parseInt(para1) + 1) * 10;
            String[] strings = NoviceGiftBagUtils.giftBags(attrib, chara.sex, chara.menpai);
            chara.xinshoulibao[Integer.parseInt(para1)] = 1;
            GameUtil.a49171(chara);
            for (int i = 0; i < strings.length; i++) {
                String[] split = strings[i].split("\\#");
                Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                vo_8165_0.msg = "你获得了#R" + split[0];
                vo_8165_0.active = 0;
                GameObjectChar.send(new M8165_0(), vo_8165_0);
                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = "你获得了#R" + split[0];
                vo_20480_0.time = (int) System.currentTimeMillis();
                GameObjectChar.send(new M20480_0(), vo_20480_0);
                GameUtil.huodechoujiang(split, chara);

            }
        }


        if (40014 == type) {
            GameUtil.a49171(chara);
        }

        if (37 == type) {
            chara.autofight_select = Integer.valueOf(para1);
            List<Petbeibao> pets = chara.pets;
            for (int j = 0; j < pets.size(); j++) {
                if (pets.get(j).id == chara.chongwuchanzhanId) {
                    pets.get(j).autofight_select = Integer.valueOf(para1);
                    break;
                }
            }
            final FightObject fightObject = FightManager.getFightObject(chara.id);
            if (fightObject == null) {
                return;
            }
            fightObject.autofight_select = chara.autofight_select;
            final FightContainer fightContainer = FightManager.getFightContainer();
            final FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, fightObject);
            if (fightObjectPet != null) {
                fightObjectPet.autofight_select = Integer.valueOf(para1);
            }


            if (chara.autofight_select == 0) {
                return;
            }
            if (fightContainer.state.intValue() == 3) {
                return;
            }
            if (fightObject.fightRequest != null) {
                FightManager.addRequest(FightManager.getFightContainer(), null);
            }

            FightRequest fightRequest = new FightRequest();
            fightRequest.id = chara.id;
            fightRequest.action = fightObject.autofight_skillaction;
            fightRequest.para = fightObject.autofight_skillno;
            FightManager.generateActionDM(FightManager.getFightContainer(), fightObject, fightRequest);
            FightManager.addRequest(FightManager.getFightContainer(), fightRequest);

            if (fightObjectPet != null) {
                fightRequest = new FightRequest();
                fightRequest.id = fightObjectPet.fid;
                fightRequest.action = fightObjectPet.autofight_skillaction;
                fightRequest.para = fightObjectPet.autofight_skillno;
                FightManager.generateActionDM(fightContainer, fightObjectPet, fightRequest);
                FightManager.addRequest(FightManager.getFightContainer(), fightRequest);
            }
        }
        if (10007 == type) {
            if (para1.equals("1")) {
                chara.extra_mana += 300000;
                if (chara.extra_mana > 90000000) {
                    chara.extra_mana = 90000000;
                }
                GameUtil.removemoney(chara, 120000);
            }
            if (para1.equals("2")) {
                chara.have_coin_pwd += 300000;
                if (chara.have_coin_pwd > 90000000) {
                    chara.have_coin_pwd = 90000000;
                }
                GameUtil.removemoney(chara, 360000);
            }
            if (para1.equals("3")) {
                chara.use_skill_d += 300000;
                if (chara.use_skill_d > 3000000) {
                    chara.use_skill_d = 3000000;
                }
                GameUtil.removemoney(chara, 1800000);
            }
        }

        if (50007 == type) {
            int viptype = Integer.valueOf(para1);
            if (viptype == 1) {
                chara.extra_life = chara.extra_life + 100;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            }
            if (viptype == 2) {
                chara.extra_life = chara.extra_life + 120;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            }
            if (viptype == 3) {
                chara.extra_life = chara.extra_life + 150;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            }
            chara.isGet = 1;

            Vo_40964_0 vo_40964_18 = new Vo_40964_0();
            vo_40964_18.type = 4;
            vo_40964_18.name = "银元宝";
            vo_40964_18.param = "100";
            vo_40964_18.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_18);

            GameUtil.addVip(chara);

        }

        if (50006 == type) {
            if (chara.vipTime != 0) {
                chara.vipTime = (int) (System.currentTimeMillis() / 1000);
            }
            int viptype = Integer.valueOf(para1);
            if (viptype == 1) {
                chara.extra_life = chara.extra_life - 3000;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
                chara.vipTimeShengYu = chara.vipTimeShengYu + 86400 * 30;
            }
            if (viptype == 2) {
                chara.extra_life = chara.extra_life - 9000;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
                chara.vipTimeShengYu = chara.vipTimeShengYu + 86400 * 30 * 3;
            }
            if (viptype == 3) {
                chara.extra_life = chara.extra_life - 36000;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
                chara.vipTimeShengYu = chara.vipTimeShengYu + 86400 * 365;
            }
            if (chara.vipType <= viptype) {
                chara.vipType = viptype;
                if (chara.vipTimeShengYu >= 86400 * 30 * 3) {
                    chara.vipType = 2;
                }
                if (chara.vipTimeShengYu >= 86400 * 365) {
                    chara.vipType = 3;
                }
            }
            if (chara.vipType == 1) {
                chara.chenghao.put("月卡", "位列仙班·灵识初开");
                GameUtil.chenghaoxiaoxi(chara);
                Vo_20481_0 vo_20481_9 = new Vo_20481_0();
                vo_20481_9.msg = "你获得了#R位列仙班·灵识初开#n的称谓。";
                vo_20481_9.time = 1567221761;
                GameObjectChar.send(new M20481_0(), vo_20481_9);
            }
            if (chara.vipType == 2) {
                chara.chenghao.put("月卡", "位列仙班·道法自然");
                GameUtil.chenghaoxiaoxi(chara);
                Vo_20481_0 vo_20481_9 = new Vo_20481_0();
                vo_20481_9.msg = "你获得了#R位列仙班·道法自然#n的称谓。";
                vo_20481_9.time = 1567221761;
                GameObjectChar.send(new M20481_0(), vo_20481_9);
            }
            if (chara.vipType == 3) {
                chara.chenghao.put("月卡", "位列仙班·大道无穷");
                GameUtil.chenghaoxiaoxi(chara);
                Vo_20481_0 vo_20481_9 = new Vo_20481_0();
                vo_20481_9.msg = "你获得了#R位列仙班·大道无穷#n的称谓。";
                vo_20481_9.time = 1567221761;
                GameObjectChar.send(new M20481_0(), vo_20481_9);
            }
            GameUtil.addVip(chara);


        }

        if (5 == type) {
            for (int i = 0; i < chara.pets.size(); i++) {
                if (chara.pets.get(i).no == Integer.valueOf(para1)) {
                    for (int j = 0; j < chara.pets.get(i).tianshu.size(); j++) {
                        if (chara.pets.get(i).tianshu.get(j).god_book_skill_name.equals(para2)) {
                            chara.pets.get(i).tianshu.remove(chara.pets.get(i).tianshu.get(j));
                            List list = new ArrayList();
                            list.add(chara.pets.get(i));
                            GameObjectChar.send(new M65507_0(), list);
                            boolean isfagong = chara.pets.get(i).petShuXing.get(0).rank > chara.pets.get(i).petShuXing.get(0).pet_mag_shape;
                            GameUtil.dujineng(1, chara.pets.get(i).petShuXing.get(0).metal, chara.pets.get(i).petShuXing.get(0).skill, isfagong, chara.pets.get(i).id, chara);
                            if (chara.pets.get(i).tianshu.size() == 0) {
                                Vo_12023_0 vo_12023_0 = new Vo_12023_0();
                                vo_12023_0.owner_id = chara.id;
                                vo_12023_0.id = chara.pets.get(i).id;
                                GameObjectChar.send(new M12023_1(), vo_12023_0);
                            } else {
                                GameObjectChar.send(new M12023_0(), chara.pets.get(i).tianshu);
                            }

                            StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(para2);
                            GameUtil.huodedaoju(chara, info, 1);
                            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                            vo_20481_0.msg = "你的宠物#Y" + chara.pets.get(i).petShuXing.get(0).str + "#n成功取出了天书散卷#R" + para2 + "#n。";
                            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                            GameObjectChar.send(new M20481_0(), vo_20481_0);
                            break;
                        }
                    }

                }
            }


        }


        //组队页面更换守护
        if (30010 == type) {
            for (int i = 0; i < chara.listshouhu.size(); i++) {
                if (chara.listshouhu.get(i).id == Integer.parseInt(para2)) {
                    chara.canzhanshouhunumber--;
                    chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = 0;
                    if (chara.listshouhu.get(i).listShouHuShuXing.get(0).nil == 0) {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).nil = 1;
                    } else {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).nil = 0;
                    }
                    List list = new ArrayList();
                    list.add(chara.listshouhu.get(i));
                    GameObjectChar.send(new M12016_0(), list);
                }


                if (chara.listshouhu.get(i).id == Integer.parseInt(para1)) {
                    if (chara.canzhanshouhunumber == 0) {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = 5;
                        chara.canzhanshouhunumber++;
                    } else {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).salary = chara.canzhanshouhunumber;
                        chara.canzhanshouhunumber++;
                    }
                    if (chara.listshouhu.get(i).listShouHuShuXing.get(0).nil == 0) {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).nil = 1;
                    } else {
                        chara.listshouhu.get(i).listShouHuShuXing.get(0).nil = 0;
                    }
                    List list = new ArrayList();
                    list.add(chara.listshouhu.get(i));
                    GameObjectChar.send(new M12016_0(), list);
                }
            }
            GameObjectChar.send(new M12016_0(), chara.listshouhu);

            List<Vo_45074_0> list = new ArrayList<>();
            for (int i = 0; i < chara.listshouhu.size(); i++) {
                if (chara.listshouhu.get(i).listShouHuShuXing.get(0).nil != 0) {
                    Vo_45074_0 vo_45074_0 = new Vo_45074_0();
                    vo_45074_0.guardName = chara.listshouhu.get(i).listShouHuShuXing.get(0).str;
                    vo_45074_0.guardLevel = chara.level;
                    vo_45074_0.guardIcon = chara.listshouhu.get(i).listShouHuShuXing.get(0).type;
                    vo_45074_0.guardOrder = chara.listshouhu.get(i).listShouHuShuXing.get(0).salary;
                    vo_45074_0.guardId = chara.listshouhu.get(i).id;
                    list.add(vo_45074_0);
                }
            }
            GameObjectChar.sendduiwu(new M45074_0(), list, chara.id);
            if (GameObjectChar.getGameObjectChar().gameTeam != null) {
                if (GameObjectChar.getGameObjectChar().gameTeam.duiwu != null) {
                    for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
                        GameObjectCharMng.getGameObjectChar(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i).id).sendOne(new M45074_0(), list);
                    }
                }
            }

        }

        //守护改攻击或辅助
        if (8 == type) {
            for (int i = 0; i < chara.listshouhu.size(); i++) {
                if (chara.listshouhu.get(i).id == Integer.parseInt(para1)) {
                    chara.listshouhu.get(i).listShouHuShuXing.get(0).max_degree = Integer.parseInt(para2);
                    List list = new ArrayList();
                    list.add(chara.listshouhu.get(i));
                    GameObjectChar.send(new M12016_0(), list);
                }
            }
        }

        //出售物品
        if (30006 == type) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                Goods goods = chara.backpack.get(i);
                if (goods.pos == Integer.parseInt(para1)) {
                    GameUtil.removemunber(chara, goods, Integer.valueOf(para2));
                    chara.use_money_type = chara.use_money_type + (goods.goodsInfo.rebuild_level / 5) * Integer.valueOf(para2);
                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new M65527_0(), listVo_65527_0);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "你成功出售" + goods.goodsInfo.str + "#n获得代金券#n。";
                    vo_20481_0.time = 1562987118;
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    break;
                }
            }

        }
        //仓库
        if (10002 == type) {
            Vo_61677_0 vo_61677_0 = new Vo_61677_0();
            vo_61677_0.list = chara.cangku;
            GameObjectChar.send(new M61677_0(), vo_61677_0);
        }
        //集市提现
        if (40022 == type) {
            chara.balance = chara.balance + chara.jishou_coin;
            chara.jishou_coin = 0;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            //摆摊的数据
            List<SaleGood> saleGoodList = GameData.that.baseSaleGoodService.findByOwnerUuid(chara.uuid);
            Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
            GameObjectChar.send(new M49179_0(), vo_49179_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 4;
            vo_40964_0.name = "金币";
            vo_40964_0.param = "100";
            vo_40964_0.rightNow = 1;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "你提款了钱";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你提款了钱";
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
        }

        //撤销摆摊
        if (40016 == type) {
            SaleGood saleGood = GameData.that.saleGoodService.findOneByGoodsId(para1);
            if (saleGood.getIspet() == 1) {
                String goods = saleGood.getGoods();
                Goods goods1 = JSONUtils.parseObject(goods, Goods.class);
                List list = new LinkedList();
                goods1.pos = GameUtil.beibaoweizhi(chara);
                goods1.goodsInfo.owner_id = 1;
                GameUtil.addwupin(goods1, chara);
                GameData.that.baseSaleGoodService.deleteById(saleGood.getId());

                Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                vo_40964_0.type = 1;
                vo_40964_0.name = saleGood.getName();
                vo_40964_0.param = "32271173";
                vo_40964_0.rightNow = 0;
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "你成功将#R" + saleGood.getName() + "#n撤摊了";
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectChar.send(new M20481_0(), vo_20481_0);


            } else {
                String goods = saleGood.getGoods();
                Petbeibao petbeibao = JSONUtils.parseObject(goods, Petbeibao.class);
                Vo_12269_0 vo_12269_0 = new Vo_12269_0();
                vo_12269_0.id = petbeibao.id;
                vo_12269_0.owner_id = chara.id;
                GameObjectChar.send(new M12269_0(), vo_12269_0);
                Vo_40964_0 vo_40964_11 = new Vo_40964_0();
                vo_40964_11.type = 2;
                vo_40964_11.name = "立正";
                vo_40964_11.param = String.valueOf(petbeibao.petShuXing.get(0).type);
                vo_40964_11.rightNow = 0;
                GameObjectChar.send(new M40964_0(), vo_40964_11);
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "你成功将#R" + saleGood.getName() + "#n撤摊了";
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                List list = new ArrayList();
                list.add(petbeibao);
                GameObjectChar.send(new M65507_0(), list);
                boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
                GameUtil.dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, petbeibao.id, chara);
                chara.pets.add(petbeibao);
                GameData.that.baseSaleGoodService.deleteById(saleGood.getId());
            }
            List<SaleGood> saleGoodList = GameData.that.baseSaleGoodService.findByOwnerUuid(chara.uuid);
            Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
            GameObjectChar.send(new M49179_0(), vo_49179_0);


        }
        //显示集市物品
        if (40018 == type) {
            String[] split = para2.split("\\;");
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            int pos3 = Integer.parseInt(split[2]);
            String pos4 = split[2];
            List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByStr(para1);
            Collections.sort(saleGoodList);


            Vo_49183_0 vo_49183_0 = new Vo_49183_0();
            vo_49183_0.totalPage = saleGoodList.size() / 8 + 1;
            if (pos1 > vo_49183_0.totalPage) {
                return;
            }
            vo_49183_0.cur_page = pos1;
            int weizhi = (pos1 - 1) * 8;
            int size = saleGoodList.size() - (pos1 - 1) * 8;
            if (size > 8) {
                size = 8;
            }
            for (int i = 0; i < size; i++) {
                Vo_49183 vo_49183 = new Vo_49183();
                vo_49183.name = saleGoodList.get(i + weizhi).getName();
                if (saleGoodList.get(i + weizhi).getName().contains("超级黑水晶·")) {
                    SaleGood saleGood = saleGoodList.get(i + weizhi);
                    String goods = saleGood.getGoods();
                    Goods goods1 = JSONUtils.parseObject(goods, Goods.class);
                    Map<Object, Object> goodsFenSe1 = UtilObjMapshuxing.GoodsLanSe(goods1.goodsLanSe);
                    int value = 0;
                    for (Map.Entry<Object, Object> entry : goodsFenSe1.entrySet()) {
                        if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType") || (int) entry.getValue() == 0) {
                            continue;
                        }
                        value = (int) entry.getValue();
                        break;
                    }
                    vo_49183.name = saleGoodList.get(i + weizhi).getName() + "|" + value + "|1";
                }

                vo_49183.is_my_goods = 0;
                vo_49183.id = saleGoodList.get(i + weizhi).getGoodsId();
                vo_49183.price = saleGoodList.get(i + weizhi).getPrice();
                vo_49183.status = 2;
                vo_49183.startTime = saleGoodList.get(i + weizhi).getStartTime();
                vo_49183.endTime = saleGoodList.get(i + weizhi).getEndTime();
                vo_49183.level = saleGoodList.get(i + weizhi).getReqLevel();
                vo_49183.unidentified = saleGoodList.get(i + weizhi).getLevel() > 0 ? 1 : 0;
                if (saleGoodList.get(i + weizhi).getIspet() == 2) {
                    vo_49183.unidentified = 0;
                }
                vo_49183.amount = 1;
                vo_49183.req_level = saleGoodList.get(i + weizhi).getReqLevel();
                vo_49183.extra = "\"{\"rank\":2,\"enchant\":0,\"mount_type\":0,\"rebuild_level\":1,\"eclosion\":0}\"";
                vo_49183.item_polar = 0;
                vo_49183_0.vo_49183s.add(vo_49183);
            }
            vo_49183_0.path_str = para1;
            vo_49183_0.select_gid = "";
            vo_49183_0.sell_stage = 2;
            vo_49183_0.sort_key = "price";
            vo_49183_0.is_descending = 0;
            GameObjectChar.send(new M49183_0(), vo_49183_0);

        }


        if (40012 == type) {

        }

        //当前身上出售列表
        if (40015 == type) {
            List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByOwnerUuid(chara.uuid);
            Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
            GameObjectChar.send(new M49179_0(), vo_49179_0);
        }

        //签到
        if (40010 == type) {
            DaySignPrize daySignPrize = GameData.that.baseDaySignPrizeService.findOneByIndex(chara.signDays + 1);
            String name = daySignPrize.getName();
            if (name.equals("银元宝")) {
                Vo_40964_0 vo_40964_9 = new Vo_40964_0();
                vo_40964_9.type = 4;
                vo_40964_9.name = "银元宝";
                vo_40964_9.param = "100";
                vo_40964_9.rightNow = 0;
                GameObjectChar.send(new M40964_0(), vo_40964_9);
                chara.gold_coin += 100;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            } else {
                StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName(name);
                GameUtil.huodedaoju(chara, storeInfo, 1);
                Vo_40964_0 vo_40964_9 = new Vo_40964_0();
                vo_40964_9.type = 1;
                vo_40964_9.name = name;
                vo_40964_9.param = "-1";
                vo_40964_9.rightNow = 0;
                GameObjectChar.send(new M40964_0(), vo_40964_9);
            }


            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "你获得了" + name;
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);


            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你领取了签到奖励。";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);

            chara.isCanSgin = 2;
            chara.signDays++;


            Vo_41051_0 vo_41051_0 = new Vo_41051_0();
            vo_41051_0.count = 1;
            vo_41051_0.name0 = "month_charge_gift";
            vo_41051_0.amount0 = 0;
            vo_41051_0.startTime0 = 1577825999;
            vo_41051_0.endTime0 = 1577825999;

            GameObjectChar.send(new M41051_0(), vo_41051_0);

            Vo_49169_0 vo_49169_0 = new Vo_49169_0();
            vo_49169_0.monthDays = 31;
            //天数
            vo_49169_0.signDays = chara.signDays;
            //是否领取0 or 1
            vo_49169_0.isCanSgin = chara.isCanSgin;

            vo_49169_0.isCanReplenishSign = 0;
            vo_49169_0.name0 = "超级归元露";
            vo_49169_0.number0 = 1;
            vo_49169_0.name1 = "银元宝";
            vo_49169_0.number1 = 100;
            vo_49169_0.name2 = "超级神兽丹";
            vo_49169_0.number2 = 1;
            vo_49169_0.name3 = "超级晶石";
            vo_49169_0.number3 = 1;
            vo_49169_0.name4 = "宠物强化丹";
            vo_49169_0.number4 = 1;
            vo_49169_0.name5 = "宠风散";
            vo_49169_0.number5 = 1;
            vo_49169_0.name6 = "银元宝";
            vo_49169_0.number6 = 100;
            vo_49169_0.name7 = "超级神兽丹";
            vo_49169_0.number7 = 1;
            vo_49169_0.name8 = "超级晶石";
            vo_49169_0.number8 = 1;
            vo_49169_0.name9 = "点化丹";
            vo_49169_0.number9 = 1;
            vo_49169_0.name10 = "超级归元露";
            vo_49169_0.number10 = 1;
            vo_49169_0.name11 = "银元宝";
            vo_49169_0.number11 = 100;
            vo_49169_0.name12 = "超级神兽丹";
            vo_49169_0.number12 = 1;
            vo_49169_0.name13 = "超级晶石";
            vo_49169_0.number13 = 1;
            vo_49169_0.name14 = "装备共鸣石";
            vo_49169_0.number14 = 1;
            vo_49169_0.name15 = "宠风散";
            vo_49169_0.number15 = 1;
            vo_49169_0.name16 = "银元宝";
            vo_49169_0.number16 = 100;
            vo_49169_0.name17 = "超级神兽丹";
            vo_49169_0.number17 = 1;
            vo_49169_0.name18 = "超级晶石";
            vo_49169_0.number18 = 1;
            vo_49169_0.name19 = "羽化丹";
            vo_49169_0.number19 = 1;
            vo_49169_0.name20 = "超级归元露";
            vo_49169_0.number20 = 1;
            vo_49169_0.name21 = "银元宝";
            vo_49169_0.number21 = 100;
            vo_49169_0.name22 = "超级神兽丹";
            vo_49169_0.number22 = 1;
            vo_49169_0.name23 = "超级晶石";
            vo_49169_0.number23 = 1;
            vo_49169_0.name24 = "神木鼎";
            vo_49169_0.number24 = 1;
            vo_49169_0.name25 = "宠风散";
            vo_49169_0.number25 = 1;
            vo_49169_0.name26 = "银元宝";
            vo_49169_0.number26 = 100;
            vo_49169_0.name27 = "超级神兽丹";
            vo_49169_0.number27 = 1;
            vo_49169_0.name28 = "超级晶石";
            vo_49169_0.number28 = 1;
            vo_49169_0.name29 = "精怪诱饵";
            vo_49169_0.number29 = 1;
            vo_49169_0.name30 = "超级归元露";
            vo_49169_0.number30 = 1;
            GameObjectChar.send(new M49169_0(), vo_49169_0);
        }
//获取签到
        if (40009 == type) {

            Vo_49169_0 vo_49169_0 = new Vo_49169_0();


            vo_49169_0.monthDays = 31;
            //天数
            vo_49169_0.signDays = chara.signDays;
            //是否领取0 or 1
            vo_49169_0.isCanSgin = chara.isCanSgin;

            vo_49169_0.isCanReplenishSign = 0;
            vo_49169_0.name0 = "超级归元露";
            vo_49169_0.number0 = 1;
            vo_49169_0.name1 = "银元宝";
            vo_49169_0.number1 = 100;
            vo_49169_0.name2 = "超级神兽丹";
            vo_49169_0.number2 = 1;
            vo_49169_0.name3 = "超级晶石";
            vo_49169_0.number3 = 1;
            vo_49169_0.name4 = "宠物强化丹";
            vo_49169_0.number4 = 1;
            vo_49169_0.name5 = "宠风散";
            vo_49169_0.number5 = 1;
            vo_49169_0.name6 = "银元宝";
            vo_49169_0.number6 = 100;
            vo_49169_0.name7 = "超级神兽丹";
            vo_49169_0.number7 = 1;
            vo_49169_0.name8 = "超级晶石";
            vo_49169_0.number8 = 1;
            vo_49169_0.name9 = "点化丹";
            vo_49169_0.number9 = 1;
            vo_49169_0.name10 = "超级归元露";
            vo_49169_0.number10 = 1;
            vo_49169_0.name11 = "银元宝";
            vo_49169_0.number11 = 100;
            vo_49169_0.name12 = "超级神兽丹";
            vo_49169_0.number12 = 1;
            vo_49169_0.name13 = "超级晶石";
            vo_49169_0.number13 = 1;
            vo_49169_0.name14 = "装备共鸣石";
            vo_49169_0.number14 = 1;
            vo_49169_0.name15 = "宠风散";
            vo_49169_0.number15 = 1;
            vo_49169_0.name16 = "银元宝";
            vo_49169_0.number16 = 100;
            vo_49169_0.name17 = "超级神兽丹";
            vo_49169_0.number17 = 1;
            vo_49169_0.name18 = "超级晶石";
            vo_49169_0.number18 = 1;
            vo_49169_0.name19 = "羽化丹";
            vo_49169_0.number19 = 1;
            vo_49169_0.name20 = "超级归元露";
            vo_49169_0.number20 = 1;
            vo_49169_0.name21 = "银元宝";
            vo_49169_0.number21 = 100;
            vo_49169_0.name22 = "超级神兽丹";
            vo_49169_0.number22 = 1;
            vo_49169_0.name23 = "超级晶石";
            vo_49169_0.number23 = 1;
            vo_49169_0.name24 = "神木鼎";
            vo_49169_0.number24 = 1;
            vo_49169_0.name25 = "宠风散";
            vo_49169_0.number25 = 1;
            vo_49169_0.name26 = "银元宝";
            vo_49169_0.number26 = 100;
            vo_49169_0.name27 = "超级神兽丹";
            vo_49169_0.number27 = 1;
            vo_49169_0.name28 = "超级晶石";
            vo_49169_0.number28 = 1;
            vo_49169_0.name29 = "精怪诱饵";
            vo_49169_0.number29 = 1;
            vo_49169_0.name30 = "超级归元露";
            vo_49169_0.number30 = 1;
            GameObjectChar.send(new M49169_0(), vo_49169_0);
        }

//

        if (6 == type) {
            PetHelpType petHelpType = GameData.that.basePetHelpTypeService.findOneByName(para1);
            int coin = petHelpType.getMoney();

            if (petHelpType.getQuality() == 3) {
                if (chara.extra_life < coin) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "代金卷不足";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    return;
                }
                chara.extra_life -= coin;
            } else {
                if (chara.balance < coin) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "金币不足";
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    return;
                }
                chara.balance = chara.balance - coin;
            }
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

            ShouHu shouHu = new ShouHu();
            shouHu.id = GameUtil.getCard(chara);
            ShouHuShuXing shouHuShuXing = new ShouHuShuXing();
            int pos1 = petHelpType.getPolar();
            int pos2 = petHelpType.getQuality();
            Hashtable<String, int[]> stringHashtable = PetAttributesUtils.helpPet(pos2, pos1, chara.level);
            //体质  灵力  力量   敏捷
            int[] attributes = stringHashtable.get("attribute");
            //金木水火土
            int[] polars = stringHashtable.get("polars");
            Vo_45128_0 vo_45128_0 = new Vo_45128_0();
            shouHuShuXing.life = attributes[0];
            shouHuShuXing.mag_power = attributes[1];
            shouHuShuXing.phy_power = attributes[2];
            shouHuShuXing.speed = attributes[3];
            shouHuShuXing.wood = polars[0];
            shouHuShuXing.water = polars[1];
            shouHuShuXing.fire = polars[2];
            shouHuShuXing.earth = polars[3];
            shouHuShuXing.resist_metal = polars[4];
            shouHuShuXing.skill = chara.level;
            shouHuShuXing.str = para1;
            shouHuShuXing.shape = 0;
            shouHuShuXing.penetrate = pos2;
            shouHuShuXing.metal = pos1;
            shouHuShuXing.color = pos2;
            shouHuShuXing.suit_polar = para1;
            shouHuShuXing.type = petHelpType.getType();
//            int[] ints = BasicAttributesUtils.calculationAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4]);

            int[] ints = BasicAttributesUtils.calculationHelpAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4], pos1);
            //气血	法力	 物伤  法伤	速度  	防御
            shouHuShuXing.max_life = ints[0];
            shouHuShuXing.def = ints[0];
            shouHuShuXing.accurate = ints[2];
            shouHuShuXing.mana = ints[3];
            shouHuShuXing.parry = ints[4];
            shouHuShuXing.wiz = ints[5];
            shouHuShuXing.salary = 0;
            shouHu.listShouHuShuXing.add(shouHuShuXing);
            chara.listshouhu.add(shouHu);
            List list = new ArrayList();
            list.add(shouHu);
            GameObjectChar.send(new M12016_0(), list);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "#n召唤守护#Y" + para1 + "#n";
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);

            GameUtil.dujineng(2, pos1, shouHuShuXing.skill, true, shouHu.id, chara);
        }


        if (10008 == type) {


        }

//组队
        if (30013 == type) {
            Vo_45075_0 vo_45075_0 = new Vo_45075_0();


            vo_45075_0.teams = 0;
            vo_45075_0.members = 0;
            GameObjectChar.send(new M45075_0(), vo_45075_0);
        }
// 宠物
        if (26 == type) {

        }

        //守护
        if (30038 == type) {
            PetHelpType petHelpType = GameData.that.basePetHelpTypeService.findOneByName(para1);
            String[] split = para2.split(";");
            int pos1 = Integer.parseInt(split[0]);
            int pos2 = Integer.parseInt(split[1]);
            Hashtable<String, int[]> stringHashtable = PetAttributesUtils.helpPet(pos2, pos1, chara.level);
            //体质  灵力  力量   敏捷
            int[] attributes = stringHashtable.get("attribute");
            //金木水火土
            int[] polars = stringHashtable.get("polars");
            Vo_45128_0 vo_45128_0 = new Vo_45128_0();
            vo_45128_0.life = attributes[0];
            vo_45128_0.mag_power = attributes[1];
            vo_45128_0.phy_power = attributes[2];
            vo_45128_0.speed = attributes[3];
            vo_45128_0.wood = polars[0];
            vo_45128_0.water = polars[1];
            vo_45128_0.fire = polars[2];
            vo_45128_0.earth = polars[3];
            vo_45128_0.resist_metal = polars[4];
            vo_45128_0.skill = chara.level;
            vo_45128_0.str = para1;
            vo_45128_0.shape = 0;
            vo_45128_0.penetrate = pos2;
            vo_45128_0.metal = pos1;
            vo_45128_0.color = pos2;
            vo_45128_0.suit_polar = para1;
            vo_45128_0.type = petHelpType.getType();

            int[] ints = BasicAttributesUtils.calculationHelpAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4], pos1);
//            int[] ints = BasicAttributesUtils.calculationAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4]);
            //气血	法力	 物伤  法伤	速度  	防御
            vo_45128_0.max_life = ints[0];
            vo_45128_0.def = ints[0];
            vo_45128_0.accurate = ints[2];
            vo_45128_0.mana = ints[3];
            vo_45128_0.parry = ints[4];
            vo_45128_0.wiz = ints[5];
            GameObjectChar.send(new M45128_0(), vo_45128_0);
        }

        if (30023 == type) {
            if (Integer.parseInt(para1) == 0) {
                chara.lock_exp = 0;
            } else {
                chara.lock_exp = 1;
            }
//                chara.lock_exp = Integer.parseInt(para1);
//            } else {
////                chara.lock_exp = 1;
////            }
            List list = new LinkedList();
            list.add(chara.id);
            list.add(Integer.parseInt(para1));
//            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_1(), list);

        }
        if (type == 40008) {
            GameUtil.a49159(chara);
        }


    }

    @Override
    public int cmd() {
        return 63752;
    }


}