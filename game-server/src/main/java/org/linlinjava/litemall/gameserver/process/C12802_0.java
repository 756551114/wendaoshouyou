package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_11713_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36889_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53715_0;
import org.linlinjava.litemall.gameserver.data.write.M11713_0;
import org.linlinjava.litemall.gameserver.data.write.M36889_0;
import org.linlinjava.litemall.gameserver.data.write.M53715_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.fight.*;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C12802_0 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int victim_id = GameReadTool.readInt(buff);

        int action = GameReadTool.readInt(buff);

        int para = GameReadTool.readInt(buff);


        String para1 = GameReadTool.readString(buff);


        String para2 = GameReadTool.readString(buff);

        String para3 = GameReadTool.readString(buff);

        String skill_talk = GameReadTool.readString(buff);

        final FightContainer fightContainer = FightManager.getFightContainer();
        if (fightContainer == null || fightContainer.state.intValue() == 3) {
            return;
        }

        final Chara chara = GameObjectChar.getGameObjectChar().chara;


        boolean checkSkill = false;
        final FightObject fightObject = FightManager.getFightObject(fightContainer, id);
        if (fightObject.fid != chara.id && fightObject.cid != chara.id) {
            return;
        }



        if (fightObject.fightRequest != null) {
            return;
        }


        if (action == 3) {
            final List<JiNeng> jiNengList = fightObject.skillsList;
            for (JiNeng jiNeng : jiNengList) {
                if (jiNeng.skill_no == para) {
                    checkSkill = true;
                    break;
                }
            }
            if (!checkSkill) {
                return;
            }
        }


        FightRequest fr = new FightRequest();
        fr.id = id;
        fr.action = action;
        fr.vid = victim_id;
        fr.para = para;
        fr.para1 = para1;
        fr.para2 = para2;
        fr.para3 = para3;
        fr.skill_talk = skill_talk;

        Vo_36889_0 vo_36889_0 = new Vo_36889_0();
        vo_36889_0.count = 1;
        vo_36889_0.id = id;
        vo_36889_0.auto_select = 2;
        vo_36889_0.multi_index = 0;
        vo_36889_0.action = action;
        vo_36889_0.para = para;
        vo_36889_0.multi_count = 0;
        GameObjectChar.send(new M36889_0(), vo_36889_0);

        if (fightObject.type == 1) {
            final FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, fightObject);
            if (fightObjectPet == null || fightObjectPet.isDead()) {
                final Vo_53715_0 vo_53715_0 = new Vo_53715_0();
                vo_53715_0.attacker_id = id;
                vo_53715_0.victim_id = victim_id;
                vo_53715_0.action = action;
                if (para != 2) {
                    vo_53715_0.no = para;
                }
                if (action == 4) {
                    final Goods beibaowupin = GameUtil.beibaowupin(chara, para);
                    if (beibaowupin != null) {
                        vo_53715_0.no = beibaowupin.goodsInfo.type;
                        fr.item_type = beibaowupin.goodsInfo.type;
                    }
                }
                GameObjectChar.send(new M53715_0(), vo_53715_0);

                final Vo_11713_0 vo_11713_0 = new Vo_11713_0();
                vo_11713_0.id = id;
                vo_11713_0.show = 0;
                GameObjectChar.send(new M11713_0(), vo_11713_0);
            }
        } else {
            final FightObject fightObjectChar = FightManager.getFightObject(fightContainer, chara.id);
            Vo_53715_0 vo_53715_0 = new Vo_53715_0();
            vo_53715_0.attacker_id = fightObjectChar.fightRequest.id;
            vo_53715_0.victim_id = fightObjectChar.fightRequest.vid;
            vo_53715_0.action = fightObjectChar.fightRequest.action;
            if (vo_53715_0.action != 2) {
                vo_53715_0.no = fightObjectChar.fightRequest.para;
            }
            if (fightObjectChar.fightRequest.action == 4) {
                final Goods beibaowupin = GameUtil.beibaowupin(chara, fightObjectChar.fightRequest.para);
                if (beibaowupin != null) {
                    vo_53715_0.no = beibaowupin.goodsInfo.type;
                    fightObjectChar.fightRequest.item_type = beibaowupin.goodsInfo.type;
                }
            }
            GameObjectChar.send(new M53715_0(), vo_53715_0);
            vo_53715_0 = new Vo_53715_0();
            vo_53715_0.attacker_id = id;
            vo_53715_0.victim_id = victim_id;
            vo_53715_0.action = action;
            if (para != 2) {
                vo_53715_0.no = para;
            }
            if (action == 4) {
                final Goods beibaowupin = GameUtil.beibaowupin(chara, para);
                if (beibaowupin != null) {
                    vo_53715_0.no = beibaowupin.goodsInfo.type;
                    fr.item_type = beibaowupin.goodsInfo.type;
                }
            }

            GameObjectChar.send(new M53715_0(), vo_53715_0);

            final Vo_11713_0 vo_11713_0 = new Vo_11713_0();
            vo_11713_0.id = id;
            vo_11713_0.show = 0;
            GameObjectChar.send(new M11713_0(), vo_11713_0);
        }
        FightManager.changeAutoFightSkill(fightContainer, fightObject, action, para);
        FightManager.addRequest(fightContainer, fr);
    }

    @Override
    public int cmd() {
        return 12802;
    }
}