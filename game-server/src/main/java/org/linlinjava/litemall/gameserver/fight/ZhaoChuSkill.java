package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;

import java.util.ArrayList;
import java.util.List;

import static org.linlinjava.litemall.gameserver.fight.FightManager.RANDOM;

public class ZhaoChuSkill implements FightSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        final FightObject charObject = FightManager.getFightObject(fightContainer, fightRequest.id);
        final FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, charObject);
        if (fightObjectPet != null) {
            Vo_7653_0 vo_7653_0 = new Vo_7653_0();
            vo_7653_0.id = fightObjectPet.fid;
            FightManager.send(fightContainer, new M7653_0(), vo_7653_0);
            FightManager.remove(fightContainer, fightObjectPet);
            Vo_64971_0 vo_64971_0 = new Vo_64971_0();
            vo_64971_0.count = 1;
            vo_64971_0.id = fightObjectPet.id;
            vo_64971_0.haveCalled = 0;
            GameObjectCharMng.getGameObjectChar(fightObjectPet.cid).sendOne(new M64971_0(), vo_64971_0);

            vo_64971_0 = new Vo_64971_0();
            vo_64971_0.id = fightObjectPet.id;
            vo_64971_0.haveCalled = 0;
            FightManager.send(fightContainer, new M64945_0(), vo_64971_0);


        }

        final Chara chara = GameObjectCharMng.getGameObjectChar(fightRequest.id).chara;
        final FightTeam friendsFightTeam = FightManager.getFightTeam(fightContainer, fightRequest.id);
        final FightTeam opponentsFightTeam = FightManager.getFightTeamDM(fightContainer, fightRequest.id);
        List<Petbeibao> pets = GameObjectCharMng.getGameObjectChar(fightRequest.id).chara.pets;
        FightObject fightObject = null;
        Petbeibao petbeibaoChuzhan = null;
        for (int j = 0; j < pets.size(); j++) {
            final Petbeibao petbeibao = pets.get(j);
            if (petbeibao.id == fightRequest.vid) {
                chara.chongwuchanzhanId = fightRequest.vid;
                fightObject = new FightObject(petbeibao);
                fightObject.pos = charObject.pos + 5;
                fightObject.fid = petbeibao.id;
                fightObject.id = petbeibao.id;
                fightObject.cid = chara.id;
                petbeibaoChuzhan = petbeibao;
                if (petbeibao.tianshu.size() != 0) {
                    final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                    fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                }

                friendsFightTeam.add(fightObject);
                break;
            }
        }
        if (fightObject == null) {
            return null;
        }
        final Vo_65017_0 vo_65017_0 = new Vo_65017_0();
        vo_65017_0.id = fightObject.fid;
        vo_65017_0.leader = fightObject.leader;
        vo_65017_0.weapon_icon = 0;
        vo_65017_0.pos = fightObject.pos;
        vo_65017_0.rank = 0;
        vo_65017_0.vip_type = 0;
        vo_65017_0.str = fightObject.str;
        vo_65017_0.type = fightObject.org_icon;
        vo_65017_0.durability = 2;
        vo_65017_0.req_level = 0;
        vo_65017_0.upgrade_level = 0;
        vo_65017_0.upgrade_type = 0;
        vo_65017_0.dex = fightObject.max_mofa;
        vo_65017_0.max_mana = fightObject.max_mofa;
        vo_65017_0.max_life = fightObject.max_shengming;
        vo_65017_0.def = fightObject.max_shengming;
        vo_65017_0.org_icon = fightObject.org_icon;
        vo_65017_0.suit_icon = fightObject.suit_icon;
        vo_65017_0.suit_light_effect = fightObject.suit_light_effect;
        vo_65017_0.special_icon = 0;
        List<Vo_65017_0> list65017 = new ArrayList<>();

        list65017.add(vo_65017_0);
        FightManager.sendTeam(fightContainer,friendsFightTeam.fightObjectList, new M64995_0(), list65017);
        FightManager.sendTeam(fightContainer,opponentsFightTeam.fightObjectList, new M64993_0(), list65017);

        Vo_64971_0 vo_64971_0 = new Vo_64971_0();
        vo_64971_0.count = 1;
        vo_64971_0.id = fightObject.id;
        vo_64971_0.haveCalled = 1;
        GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M64971_0(), vo_64971_0);

        List list = new ArrayList();
        list.add(petbeibaoChuzhan);
        GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M65507_0(), list);

        vo_64971_0 = new Vo_64971_0();
        vo_64971_0.id = fightObject.id;
        vo_64971_0.haveCalled = 1;
        GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M64945_0(), vo_64971_0);

        return null;
    }

    @Override
    public int getStateType() {
        return 0;
    }

}
