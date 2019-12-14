package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.job.SaveCharaTimes;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.linlinjava.litemall.gameserver.process.GameUtilRenWu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class FightManager {
    private static final Logger log = LoggerFactory.getLogger(FightManager.class);
    public static final List<FightContainer> listFight = new CopyOnWriteArrayList<>();
    public static final List<Integer> MONSTER_POS = new CopyOnWriteArrayList<>(new Integer[]{3, 2, 4, 1, 5, 8, 7, 9, 6, 10});
    public static final List<Integer> PERSON_POS = new CopyOnWriteArrayList<>(new Integer[]{3, 2, 4, 1, 5});
    public static final Random RANDOM = new Random();

    public static void goFight(Chara chara, String mapName) {
        int monsterNum = 6;
        goFight(chara, mapName, monsterNum);
    }

    public static void goFight(Chara chara, String mapName, int monsterNum) {
        final List<Pet> monsterList = GameData.that.basePetService.findByZoon(mapName);
        List<String> monsterNameList = new ArrayList<>();
        if (monsterList.size() == 0) {
            return;
        }
        for (int i = 0; i < monsterNum; i++) {
            Pet pet = monsterList.get(RANDOM.nextInt(monsterList.size()));
            monsterNameList.add(pet.getName());
        }
        goFight(chara, monsterNameList);
    }

    private static void addFabao(FightContainer fc, Chara chara, FightObject fightObject) {
        final List zhandouisyoufabao = GameUtil.zhandouisyoufabao(chara);
        if (zhandouisyoufabao.size() >= 3) {
            String fabaoName = (String) zhandouisyoufabao.get(0);
            final FightFabaoSkill fabaoSkill = FightSkill.getFabaoSkill(fabaoName);
            if (fabaoSkill != null) {
                int level = (int) zhandouisyoufabao.get(1);
                int qinmi = (int) zhandouisyoufabao.get(2);
                fabaoSkill.level = level;
                fabaoSkill.qinmi = qinmi;
                fabaoSkill.buffObject = fightObject;
                fabaoSkill.fightContainer = fc;
                fightObject.addSkill(fabaoSkill);
            }
        }
    }

    public static void goFight(Chara chara, List<String> monsterList) {
        {
            FightContainer fightContainer = getFightContainer(chara.id);
            while (fightContainer != null) {
                listFight.remove(fightContainer);
                fightContainer = getFightContainer(chara.id);
            }
        }
        FightContainer fc = new FightContainer();

        FightTeam ft = new FightTeam();
        ft.type = 1;
        {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(chara.id);
            int num = 0;
            if (session.gameTeam != null) {
                for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                    FightObject fightObject = new FightObject(session.gameTeam.duiwu.get(i));
                    fightObject.pos = PERSON_POS.get(num);
                    fightObject.fid = session.gameTeam.duiwu.get(i).id;
                    fightObject.id = session.gameTeam.duiwu.get(i).id;
                    addFabao(fc, session.gameTeam.duiwu.get(i), fightObject);
                    if (i == 0) {
                        fightObject.leader = 1;
                    }
                    ft.add(fightObject);

                    List<Petbeibao> pets = session.gameTeam.duiwu.get(i).pets;
                    for (int j = 0; j < pets.size(); j++) {
                        final Petbeibao petbeibao = pets.get(j);
                        if (pets.get(j).id == session.gameTeam.duiwu.get(i).chongwuchanzhanId) {
                            fightObject = new FightObject(petbeibao);
                            fightObject.pos = PERSON_POS.get(num) + 5;
                            fightObject.fid = petbeibao.id;
                            fightObject.id = petbeibao.id;
                            fightObject.cid = session.gameTeam.duiwu.get(i).id;
                            if (petbeibao.tianshu.size() != 0) {
                                final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                                fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                                if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                    final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                    xiuluoshuSkill.buffObject = fightObject;
                                    xiuluoshuSkill.fightContainer = fc;
                                    fightObject.addSkill(xiuluoshuSkill);
                                }
                            }

                            ft.add(fightObject);
                            break;
                        }
                    }
                    num++;
                }
            } else {
                FightObject fightObject = new FightObject(chara);
                fightObject.pos = PERSON_POS.get(num);
                fightObject.fid = chara.id;
                fightObject.leader = 1;
                fightObject.id = chara.id;
                addFabao(fc, chara, fightObject);

                ft.add(fightObject);

                List<Petbeibao> pets = chara.pets;
                for (int j = 0; j < pets.size(); j++) {
                    final Petbeibao petbeibao = pets.get(j);
                    if (petbeibao.id == chara.chongwuchanzhanId) {
                        fightObject = new FightObject(petbeibao);
                        fightObject.pos = PERSON_POS.get(num) + 5;
                        fightObject.fid = petbeibao.id;
                        fightObject.id = petbeibao.id;
                        fightObject.cid = chara.id;
                        if (petbeibao.tianshu.size() != 0) {
                            final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                            fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                            if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                xiuluoshuSkill.buffObject = fightObject;
                                xiuluoshuSkill.fightContainer = fc;
                                fightObject.addSkill(xiuluoshuSkill);
                            }
                        }

                        ft.add(fightObject);
                        break;
                    }
                }
                num++;
            }

            for (int i = 0; i < chara.listshouhu.size() && num < 5; i++) {
                if (chara.listshouhu.get(i).listShouHuShuXing.get(0).nil != 0) {
                    final FightObject fightObject = new FightObject(chara.listshouhu.get(i));
                    fightObject.pos = PERSON_POS.get(num);
                    fightObject.fid = fc.id++;
                    ft.add(fightObject);
                    num++;
                }
            }
        }
        FightTeam monsterTeam = new FightTeam();
        monsterTeam.type = 2;

        int monsterIndex = 0;
        for (String monsterName : monsterList) {
            final FightObject fightObject = new FightObject(chara, monsterName);
            fightObject.pos = MONSTER_POS.get(monsterIndex);
            fightObject.fid = fc.id++;
            if (monsterIndex == 1) {
                fightObject.leader = 1;
            }
            monsterTeam.add(fightObject);
            monsterIndex++;
        }

        fc.teamList.add(ft);
        fc.teamList.add(monsterTeam);

        listFight.add(fc);

        if (chara.autofight_select != 0) {
            Vo_32985_0 vo_32985_0 = new Vo_32985_0();
            vo_32985_0.user_is_multi = 0;
            vo_32985_0.user_round = chara.autofight_select;
            vo_32985_0.user_action = chara.autofight_skillaction;
            vo_32985_0.user_next_action = chara.autofight_skillaction;
            vo_32985_0.user_para = chara.autofight_skillno;
            vo_32985_0.user_next_para = chara.autofight_skillno;
            vo_32985_0.pet_is_multi = 0;
            vo_32985_0.pet_round = 0;
            vo_32985_0.pet_action = 0;
            vo_32985_0.pet_next_action = 0;
            vo_32985_0.pet_para = 0;
            vo_32985_0.pet_next_para = 0;
            GameObjectChar.send(new M32985_0(), vo_32985_0);
        }


        GameUtil.a24505(chara);
        GameUtil.a65511(chara);

        final Vo_3583_0 vo_3583_0 = new Vo_3583_0();
        vo_3583_0.a = 1;
        vo_3583_0.b = 3;
        send(fc, new M3583_0(), vo_3583_0);

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 1;
        vo_61671_0.list.add(1);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);

        final FightTeam friendsFightTeam = getFightTeam(fc, chara.id);
        final List<FightObject> fightObjectList1 = friendsFightTeam.fightObjectList;
        for (FightObject fightObject : fightObjectList1) {
            if (fightObject.type == 2) {
                final Vo_64971_0 vo_64971_0 = new Vo_64971_0();
                vo_64971_0.count = 1;
                vo_64971_0.id = fightObject.id;
                vo_64971_0.haveCalled = 1;
                GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M64971_0(), vo_64971_0);
            }
        }

        List<Vo_65017_0> list65019 = new ArrayList<>();

        List<FightObject> fightObjectList = getFightTeam(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
            final Vo_65017_0 vo_65019_0 = new Vo_65017_0();
            vo_65019_0.id = fightObject.fid;
            vo_65019_0.leader = fightObject.leader;
            vo_65019_0.weapon_icon = fightObject.weapon_icon;
            vo_65019_0.pos = fightObject.pos;
            vo_65019_0.rank = fightObject.rank;
            vo_65019_0.vip_type = 0;
            vo_65019_0.str = fightObject.str;
            vo_65019_0.type = fightObject.org_icon;
            vo_65019_0.durability = fightObject.durability;
            vo_65019_0.req_level = 0;
            vo_65019_0.upgrade_level = 0;
            vo_65019_0.upgrade_type = 0;
            vo_65019_0.dex = fightObject.max_mofa;
            vo_65019_0.max_mana = fightObject.max_mofa;
            vo_65019_0.max_life = fightObject.max_shengming;
            vo_65019_0.def = fightObject.max_shengming;
            vo_65019_0.org_icon = fightObject.org_icon;
            vo_65019_0.suit_icon = fightObject.suit_icon;
            vo_65019_0.suit_light_effect = fightObject.suit_light_effect;
            vo_65019_0.special_icon = 0;
            list65019.add(vo_65019_0);
        }

        send(fc, new M65019_0(), list65019);

        List<Vo_65017_0> list65017 = new ArrayList<>();
        fightObjectList = getFightTeamDM(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
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
            list65017.add(vo_65017_0);
        }
        send(fc, new M65017_0(), list65017);
        fightObjectList = getFightTeam(fc, chara.id).fightObjectList;
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fc.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fc, new M19959_0(), vo_19959_0);
        for (FightObject fightObject : fightObjectList) {
            if (fightObject.godbook != 0) {
                final Vo_12025_0 vo_12025_0 = new Vo_12025_0();
                vo_12025_0.id = fightObject.fid;
                vo_12025_0.effect_no = fightObject.godbook;
                send(fc, new M12025_0(), vo_12025_0);
            }
        }
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fc, new M7655_0(), vo_7655_0);
        round(fc);
    }


    public static void addRequest(FightContainer fightContainer, FightRequest fightRequest) {
        if (fightContainer.state.get() != 1) {
            return;
        }
        if (fightRequest != null) {
            final FightObject fightObject = getFightObject(fightContainer, fightRequest.id);
            if (fightObject.fightRequest == null) {
                fightObject.fightRequest = fightRequest;

            }
        }
        boolean doAction = isAllRequested(fightContainer);

        if (doAction) {
            List<FightObject> doActionList = getAllFightObject(fightContainer);
            sortActions(doActionList);
            fightContainer.doActionList = doActionList;
            if (!fabao(fightContainer)) {
                doAction(fightContainer);
            }
            endaction(fightContainer);
        }
    }

    public static void doAutoSkill(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            if (fightObject.type == 1 || fightObject.type == 2) {
                if (fightObject.fightRequest == null && fightObject.autofight_select != 0) {
                    fightObject.fightRequest = new FightRequest();
                    fightObject.fightRequest.id = fightObject.fid;
                    fightObject.fightRequest.action = fightObject.autofight_skillaction;
                    fightObject.fightRequest.para = fightObject.autofight_skillno;
                    generateActionDM(fightContainer, fightObject, fightObject.fightRequest);
                }
            }
        }
        addRequest(fightContainer, null);
    }

    public static void doTimeupSkill(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            if (fightObject.type == 1 || fightObject.type == 2 && fightObject.fightRequest == null) {
                fightObject.fightRequest = new FightRequest();
                fightObject.fightRequest.id = fightObject.fid;
                fightObject.fightRequest.action = 2;
                fightObject.fightRequest.para = 2;
                generateActionDM(fightContainer, fightObject, fightObject.fightRequest);
            }
        }
        addRequest(fightContainer, null);
    }

    private static void sortActions(List<FightObject> doActionList) {
        doActionList.sort((ob1, ob2) -> ob2.parry + ob2.parry_ext - ob1.parry - ob1.parry_ext);
    }

    private static FightRequest generateAction(FightContainer fightContainer, FightObject fightObject) {
        final FightRequest fightRequest = new FightRequest();
        final List<JiNeng> skillsList = fightObject.skillsList;
        if (skillsList == null || skillsList.size() == 0) {
            fightRequest.para = 2;
            fightRequest.action = 2;
            fightRequest.id = fightObject.fid;
            generateActionDM(fightContainer, fightObject, fightRequest);
        } else {
            final JiNeng jiNeng = skillsList.get(RANDOM.nextInt(skillsList.size()));
            fightRequest.para = jiNeng.skill_no;
            fightRequest.action = 3;
            fightRequest.id = fightObject.fid;
            if (FightSkill.isOpSkill(jiNeng.skill_no)) {
                generateActionDM(fightContainer, fightObject, fightRequest);
            } else {
                generateActionVt(fightContainer, fightObject, fightRequest);
            }

        }
        return fightRequest;
    }

    public static FightRequest generateActionDM(FightContainer fightContainer, FightObject fightObject, FightRequest fightRequest) {
        final ArrayList<FightObject> fightObjects = new ArrayList<>();
        final FightTeam opponentsFightTeam = getFightTeamDM(fightContainer, fightObject.fid);
        for (FightObject object : opponentsFightTeam.fightObjectList) {
            if (object.canbeVictim()) {
                fightObjects.add(object);
            }
        }
        FightObject target = null;
        if (fightObjects.size() == 0) {
            return null;
        } else if (fightObjects.size() == 1) {
            target = fightObjects.get(0);
        } else {
            final int index = new Random().nextInt(fightObjects.size());
            target = fightObjects.get(index);
        }
        fightRequest.vid = target.fid;
        return fightRequest;
    }

    public static FightRequest generateActionVt(FightContainer fightContainer, FightObject fightObject, FightRequest fightRequest) {
        final ArrayList<FightObject> fightObjects = new ArrayList<>();
        final FightTeam friendsFightTeam = getFightTeam(fightContainer, fightObject.fid);
        for (FightObject object : friendsFightTeam.fightObjectList) {
            if (object.canbeVictim()) {
                fightObjects.add(object);
            }
        }
        FightObject target = null;
        if (fightObjects.size() == 0) {
            return null;
        } else if (fightObjects.size() == 1) {
            target = fightObjects.get(0);
        } else {
            final int index = new Random().nextInt(fightObjects.size());
            target = fightObjects.get(index);
        }
        fightRequest.vid = target.fid;
        return fightRequest;

    }

    public static FightRequest generateActionHunluan(FightContainer fightContainer, FightObject fightObject, FightRequest fightRequest) {
        final List<FightObject> allFightObject = getAlive(getAllFightObject(fightContainer));
        final Iterator<FightObject> iterator = allFightObject.iterator();
        while (iterator.hasNext()) {
            FightObject next = iterator.next();
            if (next.fid == fightObject.fid) {
                iterator.remove();
            }
        }
        final FightObject target = allFightObject.get(new Random().nextInt(allFightObject.size()));
        fightRequest.vid = target.fid;
        return fightRequest;

    }

    private static void doAction(FightContainer fightContainer) {
        fightContainer.state.set(3);
        sendReadyAction(fightContainer);
        while (fightContainer.doActionList.size() > 0) {
            final FightObject fightObject = fightContainer.doActionList.remove(0);
            FightRequest fightRequest = fightObject.fightRequest;
            fightObject.fightRequest = null;
            if (fightRequest == null) {
                fightRequest = generateAction(fightContainer, fightObject);
            }
            if ((fightObject.isDead() || !fightObject.canAtta()) && fightRequest.action != 7 && fightRequest.action != 4) {
                continue;
            }
            if (fightObject.isYiwang() && RANDOM.nextBoolean()) {
                continue;
            }
            if (!fightObject.canbeSkill()) {
                fightRequest.action = 2;
                fightRequest.para = 2;
            }
            if (fightObject.isZhongdu()) {
                if (fightRequest.action == 3 && fightRequest.para == 501) {
                    continue;
                }
                if (fightRequest.action == 2 && fightRequest.para == 2) {
                    continue;
                }
            }

            FightObject victimObject = getFightObject(fightContainer, fightRequest.vid);
            if (fightObject.isHunluan()) {
                generateActionHunluan(fightContainer, fightObject, fightRequest);
            } else {
                if (victimObject != null && !victimObject.canbeVictim() && fightRequest.action != 4) {
                    if (FightSkill.isOpSkill(fightRequest.para)) {
                        generateActionDM(fightContainer, fightObject, fightRequest);
                    } else {
                        generateActionVt(fightContainer, fightObject, fightRequest);
                    }
                }
            }

            final FightSkill skill = FightSkill.getFightSkill(fightRequest.action, fightRequest.para);
            JiNeng jiNeng = null;
            if (fightRequest.action == 3) {
                final List<JiNeng> jiNengList = fightObject.skillsList;
                for (JiNeng tjiNeng : jiNengList) {
                    if (tjiNeng.skill_no == fightRequest.para) {
                        jiNeng = tjiNeng;
                    }
                }
            }

            if (skill == null || (jiNeng == null && fightRequest.action == 3)) {
                continue;
            }
            final List<FightResult> resultList = skill.doSkill(fightContainer, fightRequest, jiNeng);
            if (resultList != null) {
                for (FightResult fightResult : resultList) {
                    send_LIFE_DELTA(fightContainer, fightResult);
                }
            }
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            if (isOver(fightContainer)) {
                doOver(fightContainer);
                return;
            }
        }
    }

    public static void send_LIFE_DELTA(FightContainer fightContainer, FightResult fightResult) {
        Vo_15857_0 vo_15857_0 = new Vo_15857_0();
        vo_15857_0.id = fightResult.vid;
        vo_15857_0.hitter_id = fightResult.id;
        vo_15857_0.point = fightResult.point;
        vo_15857_0.effect_no = fightResult.effect_no;
        vo_15857_0.damage_type = fightResult.damage_type;
        FightManager.send(fightContainer, new M15857_0(), vo_15857_0);

        final FightTeam friendsFightTeam = getFightTeam(fightContainer, fightResult.vid);
        if (friendsFightTeam.type == 1) {
            final FightObject updateBloodFightObject = getFightObject(fightContainer, fightResult.vid);
            updateBloodFightObject.update(fightContainer);
        }

        FightObject victimObject = getFightObject(fightContainer, fightResult.vid);
        if (victimObject.doDead()) {
            Vo_7669_0 vo_7669_0 = new Vo_7669_0();
            vo_7669_0.id = victimObject.fid;
            vo_7669_0.damage_type = 4098;
            send(fightContainer, new M7669_0(), vo_7669_0);
            if (victimObject.state == 3) {
                Vo_7653_0 vo_7653_0 = new Vo_7653_0();
                vo_7653_0.id = victimObject.fid;
                send(fightContainer, new M7653_0(), vo_7653_0);
            }
        }
    }

    public static void doOver(FightContainer fightContainer) {
        fightContainer.state.set(4);
    }

    public static void changeAutoFightSkill(FightContainer fightContainer, FightObject fightObject, int action, int para) {
        if (action == 1 || action == 2 || action == 3) {
            fightObject.autofight_skillaction = action;
            fightObject.autofight_skillno = para;
            if (fightObject.type == 1) {
                final GameObjectChar session = GameObjectCharMng.getGameObjectChar(fightObject.id);
                session.chara.autofight_skillaction = action;
                session.chara.autofight_skillno = para;
            } else if (fightObject.type == 2) {
                final GameObjectChar session = GameObjectCharMng.getGameObjectChar(fightObject.cid);
                final List<Petbeibao> pets = session.chara.pets;
                for (Petbeibao pet : pets) {
                    if (pet.id == fightObject.fid) {
                        pet.autofight_skillaction = action;
                        pet.autofight_skillno = para;
                        break;
                    }
                }
            }
        }
    }

    public static void nextRoundOrSendOver(FightContainer fightContainer) {
        if (fightContainer.state.compareAndSet(4, 5)) {
            FightManager.listFight.remove(fightContainer);
            sendOver(fightContainer);
        } else if (fightContainer.state.get() == 1) {
            fightContainer.round++;
            round(fightContainer);
        }
    }

    private static void endaction(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            final List<FightRoundSkill> fightSkillList = fightObject.getRoundSkill();
            for (FightRoundSkill fightSkill : fightSkillList) {
                final boolean remove = fightSkill.disappear(fightContainer);
                if (remove) {
                    fightObject.removeBuffSK(fightContainer, fightSkill.getStateType());
                }
            }
            final FightFabaoSkill fabaoSkill = fightObject.getFabaoSkill();
            if (fabaoSkill != null) {
                fabaoSkill.resetTimes();
            }
        }
    }

    private static boolean fabao(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            final List<FightRoundSkill> fightSkillList = fightObject.getRoundSkill();
            for (FightRoundSkill fightSkill : fightSkillList) {
                fightSkill.doRoundSkill();
            }
            final FightFabaoSkill fabaoSkill = fightObject.getFabaoSkill();
            if (fabaoSkill != null) {
                fabaoSkill.active();
            }
        }
        if (isOver(fightContainer)) {
            doOver(fightContainer);
            nextRoundOrSendOver(fightContainer);
            return true;
        }
        return false;
    }

    private static void sendReadyAction(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        for (FightObject fightObject : allFightObject) {

            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 0;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 0;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        }
    }

    public static void send(FightContainer fightContainer, BaseWrite baseWrite, Object obj) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            if (fightObject.type == 1) {
                try {
                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(baseWrite, obj);
                } catch (Exception e) {
                    log.error("    public static void send(FightContainer fightContainer, BaseWrite baseWrite, Object obj) {\n", e);
                }
            }
        }
    }

    public static void sendTeam(FightContainer fightContainer, List<FightObject> fightObjectList, BaseWrite baseWrite, Object obj) {
        for (FightObject fightObject : fightObjectList) {
            if (fightObject.type == 1) {
                GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(baseWrite, obj);
            }
        }
    }

    private static void sendOver(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            if (fightObject.type == 1) {
                Vo_19959_0 vo_19959_0 = new Vo_19959_0();
                vo_19959_0.round = fightContainer.round;
                vo_19959_0.aid = fightObject.fid;
                vo_19959_0.action = 43;
                vo_19959_0.vid = fightObject.fid;
                vo_19959_0.para = 0;
                FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
                Vo_7655_0 vo_7655_0 = new Vo_7655_0();
                vo_7655_0.id = fightObject.fid;
                FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
                fightObject.updateState(fightContainer, 0, 0);

                final Vo_3581_0 vo_3581_0 = new Vo_3581_0();
                vo_3581_0.a = 1;
                GameObjectChar.send(new M3581_0(), vo_3581_0, fightObject.id);

                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = fightObject.fid;
                vo_61671_0.count = 0;
                final GameObjectChar session = GameObjectCharMng.getGameObjectChar(fightObject.id);
                session.gameMap.send(new M61671_0(), vo_61671_0);

                fightObject.max_shengming = fightObject.shengming;
                fightObject.update(fightContainer);
            } else if (fightObject.type == 2) {
                fightObject.max_shengming = fightObject.shengming;
                fightObject.update(fightContainer);
            }
        }
        afterFight(fightContainer);

    }

    private static boolean isOver(FightContainer fightContainer) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            boolean over = true;
            int humanNum = 0;
            int runNum = 0;
            for (FightObject fightObject : fightObjectList) {
                if (!fightObject.isDead() && !fightObject.isRun()) {
                    over = false;
                }
                if (fightObject.type == 1) {
                    humanNum++;
                    if (fightObject.isRun()) {
                        runNum++;
                    }
                }
            }
            if (humanNum == runNum && humanNum > 0) {
                return true;
            }
            if (over) {
                return true;
            }
        }
        return false;
    }


    private static void round(FightContainer fightContainer) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        for (FightObject fightObject : allFightObject) {
            if (fightObject.type == 1) {

                final Vo_45141_0 vo_45141_0 = new Vo_45141_0();
                vo_45141_0.round = fightContainer.round;
                vo_45141_0.animate_done = 1;
                GameObjectChar.send(new M45141_0(), vo_45141_0, fightObject.id);

                final Vo_7659_0 vo_7659_0 = new Vo_7659_0();
                vo_7659_0.a = 0;
                vo_7659_0.id = 0;
                vo_7659_0.time = 25;
                vo_7659_0.question = 265576908;
                vo_7659_0.round = fightContainer.round;
                vo_7659_0.curTime = (int) (System.currentTimeMillis() / 1000);
                GameObjectChar.send(new M7659_0(), vo_7659_0, fightObject.id);
            }
        }
        fightContainer.roundTime = System.currentTimeMillis();
    }

    private static boolean isAllRequested(FightContainer fightContainer) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            if (fightTeam.type == 2) {
                continue;
            }
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.canAtta() && (fightObject.type == 1 || fightObject.type == 2) && fightObject.fightRequest == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static FightContainer getFightContainer() {
        final int id = GameObjectChar.getGameObjectChar().chara.id;
        for (FightContainer fightContainer : listFight) {
            final List<FightTeam> teamList = fightContainer.teamList;
            for (FightTeam fightTeam : teamList) {
                final List<FightObject> fightObjectList = fightTeam.fightObjectList;
                for (FightObject fightObject : fightObjectList) {
                    if (fightObject.fid == id) {
                        return fightContainer;
                    }
                }
            }
        }
        return null;
    }

    public static FightContainer getFightContainer(int id) {
        for (FightContainer fightContainer : listFight) {
            final List<FightTeam> teamList = fightContainer.teamList;
            for (FightTeam fightTeam : teamList) {
                final List<FightObject> fightObjectList = fightTeam.fightObjectList;
                for (FightObject fightObject : fightObjectList) {
                    if (fightObject.fid == id) {
                        return fightContainer;
                    }
                }
            }
        }
        return null;
    }


    public static FightTeam getFightTeam(FightContainer fightContainer, int id) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.fid == id) {
                    return fightTeam;
                }
            }
        }
        return null;
    }

    public static FightTeam getFightTeamDM(FightContainer fightContainer, int id) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.fid == id) {
                    return teamList.get(0) == fightTeam ? teamList.get(1) : teamList.get(0);
                }
            }
        }
        return null;
    }


    private static List<FightObject> getAllFightObject(FightContainer fightContainer) {
        List<FightObject> list = new ArrayList<>();
        for (FightTeam fightTeam : fightContainer.teamList) {
            list.addAll(fightTeam.fightObjectList);
        }
        return list;
    }


    public static FightObject getFightObject(int id) {
        for (FightContainer fightContainer : listFight) {
            final List<FightTeam> teamList = fightContainer.teamList;
            for (FightTeam fightTeam : teamList) {
                final List<FightObject> fightObjectList = fightTeam.fightObjectList;
                for (FightObject fightObject : fightObjectList) {
                    if (fightObject.fid == id) {
                        return fightObject;
                    }
                }
            }
        }
        return null;
    }

    public static FightObject getFightObject(FightContainer fightContainer, int id) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.fid == id) {
                    return fightObject;
                }
            }
        }
        return null;
    }

    public static FightObject getFightObjectPet(FightContainer fightContainer, FightObject fightObject) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject tfightObject : fightObjectList) {
                if (tfightObject.cid == fightObject.id) {
                    return tfightObject;
                }
            }
        }
        return null;
    }

    public static List<FightObject> getAlive(List<FightObject> list) {
        List<FightObject> rlist = new ArrayList<>();
        for (FightObject fightObject : list) {
            if (!fightObject.isDead()) {
                rlist.add(fightObject);
            }
        }
        return rlist;
    }

    public static List<FightObject> findTarget(FightContainer fightContainer, FightRequest fightRequest, int type, int num) {
        List<FightObject> fightObjects = new ArrayList<>();
        if (type == 1) {
            if (num == 1) {
                final FightObject fightObject = getFightObject(fightContainer, fightRequest.vid);
                if (fightObject.isDead()) {
                    final FightTeam opponentsFightTeam = getFightTeamDM(fightContainer, fightRequest.id);
                    final List<FightObject> alive = getAlive(opponentsFightTeam.fightObjectList);
                    final FightObject newTarget = alive.get(RANDOM.nextInt(alive.size()));
                    fightObjects.add(newTarget);
                } else {
                    fightObjects.add(fightObject);
                }
            } else {
                final FightTeam opponentsFightTeam = getFightTeamDM(fightContainer, fightRequest.id);
                final List<FightObject> alive = getAlive(opponentsFightTeam.fightObjectList);
                for (Iterator<FightObject> iterator = alive.iterator(); iterator.hasNext(); ) {
                    FightObject next = iterator.next();
                    if (next.fid == fightRequest.vid) {
                        num--;
                        fightObjects.add(next);
                        iterator.remove();
                    }
                }
                for (int i = 0; i < num && alive.size() != 0; i++) {
                    final FightObject newTarget = alive.remove(RANDOM.nextInt(alive.size()));
                    fightObjects.add(newTarget);
                }
            }
        } else if (type == 2) {
            final FightTeam friendsFightTeam = getFightTeam(fightContainer, fightRequest.id);
            final List<FightObject> alive = getAlive(friendsFightTeam.fightObjectList);
            for (Iterator<FightObject> iterator = alive.iterator(); iterator.hasNext(); ) {
                FightObject next = iterator.next();
                if (next.fid == fightRequest.vid) {
                    num--;
                    fightObjects.add(next);
                    iterator.remove();
                }
            }
            for (int i = 0; i < num && alive.size() != 0; i++) {
                final FightObject newTarget = alive.remove(RANDOM.nextInt(alive.size()));
                fightObjects.add(newTarget);
            }
        } else if (type == 3) {
            final FightTeam friendsFightTeam = getFightTeam(fightContainer, fightRequest.id);
            final List<FightObject> alive = getAlive(friendsFightTeam.fightObjectList);
            for (int i = 0; i < num && alive.size() != 0; i++) {
                final FightObject newTarget = alive.remove(RANDOM.nextInt(alive.size()));
                fightObjects.add(newTarget);
            }
        }
        return fightObjects;
    }


    //战斗结束
    private static void afterFight(FightContainer fightContainer) {

        List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.type == 1) {
                    int fid = fightObject.fid;
                    Chara chara = GameObjectCharMng.getGameObjectChar(fid).chara;
                    GameUtilRenWu.feiditu(chara.mapid, chara);
                    break;

                }
            }
        }

        List<FightObject> guaiwu = guaiwu(fightContainer);
        boolean isDead = false;
        if (guaiwu != null) {
            for (FightObject fightObject : guaiwu) {
                if (!fightObject.isDead()) {
                    isDead = true;
                }
            }
        }


        Chara chara1 = chara(fightContainer);


        GameUtilRenWu.feiditu(chara1.mapid, chara1);


        if (!isDead) {
            if (chara1.npcchubao.size() > 0) {
                if (guaiwu != null && chara1.npcchubao.get(0).name.equals(guaiwu.get(0).str)) {
                    if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                        for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                            GameUtil.chubaorenwu(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i));
                        }
                    } else {
                        GameUtil.chubaorenwu(chara1, chara1);
                    }
                    return;
                }
            }
            if (chara1.npcshuadao.size() > 0) {
                if (guaiwu != null && chara1.npcshuadao.get(0).name.equals(guaiwu.get(0).str)) {
                    if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                        for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                            GameUtil.nextshuadao(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i));
                        }
                    } else {
                        GameUtil.nextshuadao(chara1, chara1);
                    }
                    return;
                }
            }

            if (chara1.npcxuanshang.size() > 0) {
                if ("仙界叛逆".equals(guaiwu.get(0).str)) {
                    if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                        for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                            GameUtil.nextxuanshang(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i));
                        }
                    } else {
                        GameUtil.nextxuanshang(chara1, chara1);
                    }
                    return;
                }
            }
            if (guaiwu != null && chara1.xiuxingNpcname.equals(guaiwu.get(0).str)) {
                if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                    for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                        GameUtil.nextxiuxing(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i));
                    }
                } else {
                    GameUtil.nextxiuxing(chara1, chara1);
                }
                return;
            }
            for (int j = 0; j < GameLine.gameShuaGuai.shuaXing.size(); j++) {
                if (guaiwu != null && GameLine.gameShuaGuai.shuaXing.get(j).name.equals(guaiwu.get(0).str)) {
                    String replace = "";
                    if (guaiwu.get(0).str.length() > 1) {
                        String substring = guaiwu.get(0).str.substring(1, 2);
                        replace = guaiwu.get(0).str.replace(substring, "");
                    }

                    if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                        for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                            GameUtil.nextshaxing(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i), guaiwu.get(0).guaiwulevel, replace);
                        }
                    } else {
                        GameUtil.nextshaxing(chara1, chara1, guaiwu.get(0).guaiwulevel, replace);
                    }
                    GameObjectChar.sendduiwu(new M12285_1(), GameLine.gameShuaGuai.shuaXing.get(j).id, chara1.id);
                    GameLine.gameShuaGuai.shuaXing.remove(GameLine.gameShuaGuai.shuaXing.get(j));
                    return;
                }
            }

            if (guaiwu != null && "试道元魔".equals(guaiwu.get(0).str)) {
                if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                    for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                        GameUtil.shidaojingyan(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i), guaiwu.get(0).id);
                    }
                } else {
                    GameUtil.shidaojingyan(chara1, chara1, guaiwu.get(0).id);
                }
                return;
            }

            //试道PK
            if (chara1.mapid == 38004 && GameObjectCharMng.getGameObjectChar(chara1.id).gameMap.gameShiDao.statzhuangtai == 3) {
                teamList = fightContainer.teamList;
                for (int i = 0; i < teamList.size(); i++) {
                    boolean iswin = true;
                    for (FightObject fightObject : teamList.get(i).fightObjectList) {
                        //赢的一方
                        if (fightObject.isDead()) {
                            iswin = false;
                        }
                    }

                    if (iswin) {
                        for (FightObject fightObject : teamList.get(i).fightObjectList) {
                            if (!(fightObject.type == 2)) {
                                GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaodaguaijifen += 25;
                                List<GameObjectChar> gameSessions = SaveCharaTimes.insertionSort(GameObjectCharMng.getGameObjectChar(fightObject.id).gameMap.sessionList);
                                String mingname = "";
                                int mingci = 0;
                                for (int j = 0; j < gameSessions.size(); j++) {
                                    if (mingname.equals(gameSessions.get(j).gameTeam.duiwu.get(0).name + gameSessions.get(j).gameTeam.duiwu.get(0).shidaodaguaijifen)) {
                                        continue;
                                    }
                                    mingname = gameSessions.get(j).gameTeam.duiwu.get(0).name + gameSessions.get(j).gameTeam.duiwu.get(0).shidaodaguaijifen;
                                    mingci++;
                                }
                                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                                vo_20481_0.msg = "你当前队伍积分" + GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaodaguaijifen;
                                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                                GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_0);
                            }
                        }
                    } else {
                        for (FightObject fightObject : teamList.get(i).fightObjectList) {
                            if (!(fightObject.type == 2)) {
                                GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaodaguaijifen -= 25;
                                GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaocishu -= 1;
                                List<GameObjectChar> gameSessions = SaveCharaTimes.insertionSort(GameObjectCharMng.getGameObjectChar(fightObject.id).gameMap.sessionList);
                                String mingname = "";
                                int mingci = 0;
                                for (int j = 0; j < gameSessions.size(); j++) {
                                    if (mingname.equals(gameSessions.get(j).gameTeam.duiwu.get(0).name + gameSessions.get(j).gameTeam.duiwu.get(0).shidaodaguaijifen)) {
                                        continue;
                                    }
                                    mingname = gameSessions.get(j).gameTeam.duiwu.get(0).name + gameSessions.get(j).gameTeam.duiwu.get(0).shidaodaguaijifen;
                                    mingci++;
                                }
                                if (mingci == 3) {
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).chara.chenghao.put("试道勇者", "试道勇者");
                                    GameUtil.chenghaoxiaoxi(GameObjectCharMng.getGameObjectChar(fightObject.id).chara);
                                    Vo_20481_0 vo_20481_9 = new Vo_20481_0();
                                    vo_20481_9.msg = "你获得了#R试道勇者#n的称谓。";
                                    vo_20481_9.time = (int) (System.currentTimeMillis() / 1000);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_9);

                                    GameObjectCharMng.getGameObjectChar(fightObject.id).chara.extra_life = GameObjectCharMng.getGameObjectChar(fightObject.id).chara.extra_life + 50000;
                                    vo_20481_9 = new Vo_20481_0();
                                    vo_20481_9.msg = "你获得了50000元宝。";
                                    vo_20481_9.time = (int) (System.currentTimeMillis() / 1000);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_9);
                                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(GameObjectCharMng.getGameObjectChar(fightObject.id).chara);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M65527_0(), listVo_65527_0);
                                }
                                if (mingci == 2) {
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).chara.chenghao.put("试道勇者", "试道勇者");
                                    GameUtil.chenghaoxiaoxi(GameObjectCharMng.getGameObjectChar(fightObject.id).chara);
                                    Vo_20481_0 vo_20481_9 = new Vo_20481_0();
                                    vo_20481_9.msg = "你获得了#R试道勇者#n的称谓。";
                                    vo_20481_9.time = (int) (System.currentTimeMillis() / 1000);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_9);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).chara.extra_life = GameObjectCharMng.getGameObjectChar(fightObject.id).chara.extra_life + 100000;
                                    vo_20481_9 = new Vo_20481_0();
                                    vo_20481_9.msg = "你获得了100000元宝。";
                                    vo_20481_9.time = (int) (System.currentTimeMillis() / 1000);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_9);
                                    ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(GameObjectCharMng.getGameObjectChar(fightObject.id).chara);
                                    GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M65527_0(), listVo_65527_0);
                                }

                                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                                vo_20481_0.msg = "你当前队伍积分" + GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaodaguaijifen;
                                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                                GameObjectCharMng.getGameObjectChar(fightObject.id).sendOne(new M20481_0(), vo_20481_0);
                                if (GameObjectCharMng.getGameObjectChar(fightObject.id).chara.shidaocishu <= 0) {
                                    GameUtilRenWu.shidaohuicheng(GameObjectCharMng.getGameObjectChar(fightObject.id).chara);
                                }
                            }
                        }
                    }
                }
                return;
            }


            //打野怪
            if (guaiwu != null) {
                if (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) {
                    for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.size(); i++) {
                        GameUtil.shuayeguai(chara1, GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(i), guaiwu.get(0).guaiwulevel);
                    }
                } else {
                    GameUtil.shuayeguai(chara1, chara1, guaiwu.get(0).guaiwulevel);
                }
            }


        }

    }

    private static List<FightObject> guaiwu(FightContainer fightContainer) {
        List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            if (fightTeam.type == 2) {
                List<FightObject> fightObjectList = fightTeam.fightObjectList;
                return fightObjectList;
            }
        }
        return null;
    }

    private static Chara chara(FightContainer fightContainer) {
        List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            if (fightTeam.type == 1) {
                List<FightObject> fightObjectList = fightTeam.fightObjectList;
                for (FightObject fightObject : fightObjectList) {
                    if (fightObject.type == 1) {
                        int fid = fightObject.fid;
                        Chara chara = GameObjectCharMng.getGameObjectChar(fid).chara;
                        return chara;

                    }
                }
            }
        }
        return null;
    }


    //PK
    public static void goFight(Chara chara, Chara charaduishou) {
        {
            FightContainer fightContainer = getFightContainer(chara.id);
            if (fightContainer != null) {
                return;
            }
        }
        {
            FightContainer fightContainer = getFightContainer(charaduishou.id);
            if (fightContainer != null) {
                return;
            }
        }
        FightContainer fc = new FightContainer();

        FightTeam ft = new FightTeam();
        ft.type = 1;
        {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(chara.id);
            int num = 0;
            if (session.gameTeam != null) {
                for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                    FightObject fightObject = new FightObject(session.gameTeam.duiwu.get(i));
                    fightObject.pos = PERSON_POS.get(num);
                    fightObject.fid = session.gameTeam.duiwu.get(i).id;
                    fightObject.id = session.gameTeam.duiwu.get(i).id;
                    if (i == 0) {
                        fightObject.leader = 1;
                    }
                    addFabao(fc, session.gameTeam.duiwu.get(i), fightObject);

                    ft.add(fightObject);

                    List<Petbeibao> pets = session.gameTeam.duiwu.get(i).pets;
                    for (int j = 0; j < pets.size(); j++) {
                        if (pets.get(j).id == session.gameTeam.duiwu.get(i).chongwuchanzhanId) {
                            final Petbeibao petbeibao = pets.get(j);
                            fightObject = new FightObject(pets.get(j));
                            fightObject.pos = PERSON_POS.get(num) + 5;
                            fightObject.fid = pets.get(j).id;
                            fightObject.id = pets.get(j).id;
                            fightObject.cid = session.gameTeam.duiwu.get(i).id;
                            ft.add(fightObject);

                            if (petbeibao.tianshu.size() != 0) {
                                final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                                fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                                if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                    final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                    xiuluoshuSkill.buffObject = fightObject;
                                    xiuluoshuSkill.fightContainer = fc;
                                    fightObject.addSkill(xiuluoshuSkill);
                                }
                            }
                            break;
                        }
                    }
                    num++;
                }
            } else {
                FightObject fightObject = new FightObject(chara);
                fightObject.pos = PERSON_POS.get(num);
                fightObject.fid = chara.id;
                fightObject.leader = 1;
                fightObject.id = chara.id;
                addFabao(fc, chara, fightObject);

                ft.add(fightObject);

                List<Petbeibao> pets = chara.pets;
                for (int j = 0; j < pets.size(); j++) {
                    if (pets.get(j).id == chara.chongwuchanzhanId) {
                        final Petbeibao petbeibao = pets.get(j);

                        fightObject = new FightObject(pets.get(j));
                        fightObject.pos = PERSON_POS.get(num) + 5;
                        fightObject.fid = pets.get(j).id;
                        fightObject.id = pets.get(j).id;
                        fightObject.cid = chara.id;

                        ft.add(fightObject);

                        if (petbeibao.tianshu.size() != 0) {
                            final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                            fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                            if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                xiuluoshuSkill.buffObject = fightObject;
                                xiuluoshuSkill.fightContainer = fc;
                                fightObject.addSkill(xiuluoshuSkill);
                            }
                        }

                        break;
                    }
                }
                num++;
            }
        }
        FightTeam ftother = new FightTeam();
        ftother.type = 1;
        {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(charaduishou.id);
            int num = 0;
            if (session.gameTeam != null) {
                for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                    FightObject fightObject = new FightObject(session.gameTeam.duiwu.get(i));
                    fightObject.pos = PERSON_POS.get(num);
                    fightObject.fid = session.gameTeam.duiwu.get(i).id;
                    fightObject.id = session.gameTeam.duiwu.get(i).id;
                    if (i == 0) {
                        fightObject.leader = 1;
                    }
                    addFabao(fc, session.gameTeam.duiwu.get(i), fightObject);
                    ftother.add(fightObject);

                    List<Petbeibao> pets = session.gameTeam.duiwu.get(i).pets;
                    for (int j = 0; j < pets.size(); j++) {
                        if (pets.get(j).id == session.gameTeam.duiwu.get(i).chongwuchanzhanId) {
                            final Petbeibao petbeibao = pets.get(j);
                            fightObject = new FightObject(pets.get(j));
                            fightObject.pos = PERSON_POS.get(num) + 5;
                            fightObject.fid = pets.get(j).id;
                            fightObject.id = pets.get(j).id;
                            fightObject.cid = session.gameTeam.duiwu.get(i).id;
                            ftother.add(fightObject);

                            if (petbeibao.tianshu.size() != 0) {
                                final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                                fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                                if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                    final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                    xiuluoshuSkill.buffObject = fightObject;
                                    xiuluoshuSkill.fightContainer = fc;
                                    fightObject.addSkill(xiuluoshuSkill);
                                }
                            }
                            break;
                        }
                    }
                    num++;
                }
            } else {
                FightObject fightObject = new FightObject(charaduishou);
                fightObject.pos = PERSON_POS.get(num);
                fightObject.fid = charaduishou.id;
                fightObject.leader = 1;
                fightObject.id = charaduishou.id;
                addFabao(fc, charaduishou, fightObject);
                ftother.add(fightObject);

                List<Petbeibao> pets = charaduishou.pets;
                for (int j = 0; j < pets.size(); j++) {
                    if (pets.get(j).id == charaduishou.chongwuchanzhanId) {
                        final Petbeibao petbeibao = pets.get(j);
                        fightObject = new FightObject(petbeibao);
                        fightObject.pos = PERSON_POS.get(num) + 5;
                        fightObject.fid = pets.get(j).id;
                        fightObject.id = pets.get(j).id;
                        fightObject.cid = charaduishou.id;
                        if (petbeibao.tianshu.size() != 0) {
                            final Vo_12023_0 vo_12023_0 = petbeibao.tianshu.get(RANDOM.nextInt(petbeibao.tianshu.size()));
                            fightObject.godbook = FightTianshuMap.TIANSHU_EFFECT.get(vo_12023_0.god_book_skill_name);
                            if (vo_12023_0.god_book_skill_name.equals("修罗术")) {
                                final XiuluoshuSkill xiuluoshuSkill = new XiuluoshuSkill();
                                xiuluoshuSkill.buffObject = fightObject;
                                xiuluoshuSkill.fightContainer = fc;
                                fightObject.addSkill(xiuluoshuSkill);
                            }
                        }
                        ftother.add(fightObject);
                        break;
                    }
                }
                num++;
            }
        }


        fc.teamList.add(ft);
        fc.teamList.add(ftother);

        listFight.add(fc);

        final List<FightObject> fightObjectListAll = getAllFightObject(fc);

        for (FightObject fightObject : fightObjectListAll) {
            if (fightObject.type == 1) {
                final GameObjectChar session = GameObjectCharMng.getGameObjectChar(fightObject.id);
                final Chara tchar = session.chara;
                if (chara.autofight_select != 0) {
                    Vo_32985_0 vo_32985_0 = new Vo_32985_0();
                    vo_32985_0.user_is_multi = 0;
                    vo_32985_0.user_round = tchar.autofight_select;
                    vo_32985_0.user_action = tchar.autofight_skillaction;
                    vo_32985_0.user_next_action = tchar.autofight_skillaction;
                    vo_32985_0.user_para = tchar.autofight_skillno;
                    vo_32985_0.user_next_para = tchar.autofight_skillno;
                    vo_32985_0.pet_is_multi = 0;
                    vo_32985_0.pet_round = 0;
                    vo_32985_0.pet_action = 0;
                    vo_32985_0.pet_next_action = 0;
                    vo_32985_0.pet_para = 0;
                    vo_32985_0.pet_next_para = 0;
                    session.send(new M32985_0(), vo_32985_0);
                }
                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = fightObject.id;
                vo_61671_0.count = 1;
                vo_61671_0.list.add(1);
                session.gameMap.send(new M61671_0(), vo_61671_0);
            }
        }



        final Vo_3583_0 vo_3583_0 = new Vo_3583_0();
        vo_3583_0.a = 1;
        vo_3583_0.b = 3;
        send(fc, new M3583_0(), vo_3583_0);


        for (FightObject fightObject : fightObjectListAll) {
            if (fightObject.type == 2) {
                final Vo_64971_0 vo_64971_0 = new Vo_64971_0();
                vo_64971_0.count = 1;
                vo_64971_0.id = fightObject.id;
                vo_64971_0.haveCalled = 1;
                GameObjectCharMng.getGameObjectChar(fightObject.cid).send(new M64971_0(), vo_64971_0);
            }
        }

        List<Vo_65017_0> list65019 = new ArrayList<>();
        List<FightObject> fightObjectList = getFightTeam(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
            final Vo_65017_0 vo_65019_0 = new Vo_65017_0();
            vo_65019_0.id = fightObject.fid;
            vo_65019_0.leader = fightObject.leader;
            vo_65019_0.weapon_icon = fightObject.weapon_icon;
            vo_65019_0.pos = fightObject.pos;
            vo_65019_0.rank = fightObject.rank;
            vo_65019_0.vip_type = 0;
            vo_65019_0.str = fightObject.str;
            vo_65019_0.type = fightObject.org_icon;
            vo_65019_0.durability = fightObject.durability;
            vo_65019_0.req_level = 0;
            vo_65019_0.upgrade_level = 0;
            vo_65019_0.upgrade_type = 0;
            vo_65019_0.dex = fightObject.max_mofa;
            vo_65019_0.max_mana = fightObject.max_mofa;
            vo_65019_0.max_life = fightObject.max_shengming;
            vo_65019_0.def = fightObject.max_shengming;
            vo_65019_0.org_icon = fightObject.org_icon;
            vo_65019_0.suit_icon = fightObject.suit_icon;
            vo_65019_0.suit_light_effect = fightObject.suit_light_effect;
            vo_65019_0.special_icon = 0;
            vo_65019_0.portrait = fightObject.org_icon;
            list65019.add(vo_65019_0);
        }


        List<Vo_65017_0> list65017 = new ArrayList<>();
        List<FightObject> fightObjectListOther = getFightTeamDM(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectListOther) {
            final Vo_65017_0 vo_65017_0 = new Vo_65017_0();
            vo_65017_0.id = fightObject.fid;
            vo_65017_0.leader = fightObject.leader;
            vo_65017_0.weapon_icon = fightObject.weapon_icon;
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
            vo_65017_0.portrait = fightObject.org_icon;
            vo_65017_0.special_icon = 0;
            list65017.add(vo_65017_0);
        }
        sendTeam(fc, fightObjectList, new M65019_0(), list65019);
        sendTeam(fc, fightObjectList, new M65017_0(), list65017);

        sendTeam(fc, fightObjectListOther, new M65019_0(), list65017);
        sendTeam(fc, fightObjectListOther, new M65017_0(), list65019);

        fightObjectList = FightManager.getAllFightObject(fc);
        for (FightObject fightObject : fightObjectList) {
            if (fightObject.godbook != 0) {
                final Vo_12025_0 vo_12025_0 = new Vo_12025_0();
                vo_12025_0.id = fightObject.fid;
                vo_12025_0.effect_no = fightObject.godbook;
                send(fc, new M12025_0(), vo_12025_0);
            }
        }

        round(fc);
    }

    //杀星
    public static void goFight(Chara chara, List<String> monsterList, Vo_65529_0 vo_65529_0) {
        {
            FightContainer fightContainer = getFightContainer(chara.id);
            while (fightContainer != null) {
                listFight.remove(fightContainer);
                fightContainer = getFightContainer(chara.id);
            }
        }
        FightContainer fc = new FightContainer();
        FightTeam ft = new FightTeam();
        ft.type = 1;
        {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(chara.id);
            int num = 0;
            if (session.gameTeam != null) {
                for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                    FightObject fightObject = new FightObject(session.gameTeam.duiwu.get(i));
                    fightObject.pos = PERSON_POS.get(num);
                    fightObject.fid = session.gameTeam.duiwu.get(i).id;
                    fightObject.id = session.gameTeam.duiwu.get(i).id;
                    if (i == 0) {
                        fightObject.leader = 1;
                    }
                    addFabao(fc, session.gameTeam.duiwu.get(i), fightObject);
                    ft.add(fightObject);

                    List<Petbeibao> pets = session.gameTeam.duiwu.get(i).pets;
                    for (int j = 0; j < pets.size(); j++) {
                        if (pets.get(j).id == session.gameTeam.duiwu.get(i).chongwuchanzhanId) {
                            fightObject = new FightObject(pets.get(j));
                            fightObject.pos = PERSON_POS.get(num) + 5;
                            fightObject.fid = pets.get(j).id;
                            fightObject.id = pets.get(j).id;
                            fightObject.cid = session.gameTeam.duiwu.get(i).id;

                            ft.add(fightObject);
                            break;
                        }
                    }
                    num++;
                }
            } else {
                FightObject fightObject = new FightObject(chara);
                fightObject.pos = PERSON_POS.get(num);
                fightObject.fid = chara.id;
                fightObject.leader = 1;
                fightObject.id = chara.id;

                ft.add(fightObject);
                addFabao(fc, chara, fightObject);
                List<Petbeibao> pets = chara.pets;
                for (int j = 0; j < pets.size(); j++) {
                    if (pets.get(j).id == chara.chongwuchanzhanId) {
                        fightObject = new FightObject(pets.get(j));
                        fightObject.pos = PERSON_POS.get(num) + 5;
                        fightObject.fid = pets.get(j).id;
                        fightObject.id = pets.get(j).id;
                        fightObject.cid = chara.id;

                        ft.add(fightObject);
                        break;
                    }
                }
                num++;
            }

        }
        FightTeam monsterTeam = new FightTeam();
        monsterTeam.type = 2;

        int monsterIndex = 0;
        for (String monsterName : monsterList) {
            final FightObject fightObject = new FightObject(chara, monsterName, vo_65529_0);
            fightObject.pos = MONSTER_POS.get(monsterIndex);
            fightObject.fid = fc.id++;
            if (monsterIndex == 1) {
                fightObject.leader = 1;
            }
            monsterTeam.add(fightObject);
            monsterIndex++;
        }

        fc.teamList.add(ft);
        fc.teamList.add(monsterTeam);

        listFight.add(fc);

        if (chara.autofight_select != 0) {
            Vo_32985_0 vo_32985_0 = new Vo_32985_0();
            vo_32985_0.user_is_multi = 0;
            vo_32985_0.user_round = chara.autofight_select;
            vo_32985_0.user_action = chara.autofight_skillaction;
            vo_32985_0.user_next_action = chara.autofight_skillaction;
            vo_32985_0.user_para = chara.autofight_skillno;
            vo_32985_0.user_next_para = chara.autofight_skillno;
            vo_32985_0.pet_is_multi = 0;
            vo_32985_0.pet_round = 0;
            vo_32985_0.pet_action = 0;
            vo_32985_0.pet_next_action = 0;
            vo_32985_0.pet_para = 0;
            vo_32985_0.pet_next_para = 0;
            GameObjectChar.send(new M32985_0(), vo_32985_0);
        }


        GameUtil.a24505(chara);
        GameUtil.a65511(chara);

        final Vo_3583_0 vo_3583_0 = new Vo_3583_0();
        vo_3583_0.a = 1;
        vo_3583_0.b = 3;
        send(fc, new M3583_0(), vo_3583_0);

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 1;
        vo_61671_0.list.add(1);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);

        final FightTeam friendsFightTeam = getFightTeam(fc, chara.id);
        final List<FightObject> fightObjectList1 = friendsFightTeam.fightObjectList;
        for (FightObject fightObject : fightObjectList1) {
            if (fightObject.type == 2) {
                final Vo_64971_0 vo_64971_0 = new Vo_64971_0();
                vo_64971_0.count = 1;
                vo_64971_0.id = fightObject.id;
                vo_64971_0.haveCalled = 1;
                GameObjectCharMng.getGameObjectChar(fightObject.cid).sendOne(new M64971_0(), vo_64971_0);
            }
        }

        List<Vo_65017_0> list65019 = new ArrayList<>();

        List<FightObject> fightObjectList = getFightTeam(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
            final Vo_65017_0 vo_65019_0 = new Vo_65017_0();
            vo_65019_0.id = fightObject.fid;
            vo_65019_0.leader = fightObject.leader;
            vo_65019_0.weapon_icon = fightObject.weapon_icon;
            vo_65019_0.pos = fightObject.pos;
            vo_65019_0.rank = fightObject.rank;
            vo_65019_0.vip_type = 0;
            vo_65019_0.str = fightObject.str;
            vo_65019_0.type = fightObject.org_icon;
            vo_65019_0.durability = fightObject.durability;
            vo_65019_0.req_level = 0;
            vo_65019_0.upgrade_level = 0;
            vo_65019_0.upgrade_type = 0;
            vo_65019_0.dex = fightObject.max_mofa;
            vo_65019_0.max_mana = fightObject.max_mofa;
            vo_65019_0.max_life = fightObject.max_shengming;
            vo_65019_0.def = fightObject.max_shengming;
            vo_65019_0.org_icon = fightObject.org_icon;
            vo_65019_0.suit_icon = fightObject.suit_icon;
            vo_65019_0.suit_light_effect = fightObject.suit_light_effect;
            vo_65019_0.special_icon = 0;
            vo_65019_0.portrait = fightObject.org_icon;
            list65019.add(vo_65019_0);
        }

        send(fc, new M65019_0(), list65019);

        List<Vo_65017_0> list65017 = new ArrayList<>();
        fightObjectList = getFightTeamDM(fc, chara.id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
            final Vo_65017_0 vo_65017_0 = new Vo_65017_0();
            vo_65017_0.id = fightObject.fid;
            vo_65017_0.leader = fightObject.leader;
            vo_65017_0.weapon_icon = fightObject.weapon_icon;
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
            vo_65017_0.portrait = fightObject.org_icon;
            vo_65017_0.special_icon = 0;
            list65017.add(vo_65017_0);
        }
        send(fc, new M65017_0(), list65017);
        fightObjectList = FightManager.getAllFightObject(fc);
        for (FightObject fightObject : fightObjectList) {
            if (fightObject.godbook != 0) {
                final Vo_12025_0 vo_12025_0 = new Vo_12025_0();
                vo_12025_0.id = fightObject.fid;
                vo_12025_0.effect_no = fightObject.godbook;
                send(fc, new M12025_0(), vo_12025_0);
            }
        }
        round(fc);
    }

    public static FightObject getRandomObject(FightContainer fightContainer, List<FightObject> exclude) {
        final List<FightObject> allFightObject = getAllFightObject(fightContainer);
        for (FightObject fightObject : allFightObject) {
            if (!fightObject.isDead()) {
                if (!exclude.contains(fightObject)) {
                    return fightObject;
                }
            }
        }
        return null;
    }

    public static void remove(FightContainer fightContainer, FightObject fightObject) {
        final List<FightTeam> teamList = fightContainer.teamList;
        for (FightTeam fightTeam : teamList) {
            final Iterator<FightObject> iterator = fightTeam.fightObjectList.iterator();
            while (iterator.hasNext()) {
                FightObject next = iterator.next();
                if (next.fid == fightObject.fid) {
                    iterator.remove();
                    break;
                }
            }
        }
        final Iterator<FightObject> iterator = fightContainer.doActionList.iterator();
        while (iterator.hasNext()) {
            FightObject next = iterator.next();
            if (next.fid == fightObject.fid) {
                iterator.remove();
                break;
            }
        }
    }

    public static void reconnect(Chara chara) {
        final int id = chara.id;
        final GameObjectChar session = GameObjectCharMng.getGameObjectChar(id);
        final FightContainer fc = getFightContainer(id);
        if (fc == null) {
            return;
        }
        final Vo_3583_0 vo_3583_0 = new Vo_3583_0();
        vo_3583_0.a = 1;
        vo_3583_0.b = 3;
        session.send(new M3583_0(), vo_3583_0);

        List<FightObject> fightObjectList = getFightTeam(fc, id).fightObjectList;
        List<Vo_65017_0> list65019 = new ArrayList<>();
        for (FightObject fightObject : fightObjectList) {
            final Vo_65017_0 vo_65019_0 = new Vo_65017_0();
            vo_65019_0.id = fightObject.fid;
            vo_65019_0.leader = fightObject.leader;
            vo_65019_0.weapon_icon = fightObject.weapon_icon;
            vo_65019_0.pos = fightObject.pos;
            vo_65019_0.rank = fightObject.rank;
            vo_65019_0.vip_type = 0;
            vo_65019_0.str = fightObject.str;
            vo_65019_0.type = fightObject.org_icon;
            vo_65019_0.durability = fightObject.durability;
            vo_65019_0.req_level = 0;
            vo_65019_0.upgrade_level = 0;
            vo_65019_0.upgrade_type = 0;
            vo_65019_0.dex = fightObject.max_mofa;
            vo_65019_0.max_mana = fightObject.max_mofa;
            vo_65019_0.max_life = fightObject.max_shengming;
            vo_65019_0.def = fightObject.max_shengming;
            vo_65019_0.org_icon = fightObject.org_icon;
            vo_65019_0.suit_icon = fightObject.suit_icon;
            vo_65019_0.suit_light_effect = fightObject.suit_light_effect;
            vo_65019_0.special_icon = 0;
            list65019.add(vo_65019_0);
        }

        session.send(new M65019_0(), list65019);

        list65019 = new ArrayList<>();
        List<Vo_65017_0> list65017 = new ArrayList<>();
        fightObjectList = getFightTeamDM(fc, id).fightObjectList;
        for (FightObject fightObject : fightObjectList) {
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
            list65017.add(vo_65017_0);
        }
        session.send(new M65017_0(), list65017);
        fightObjectList = getFightTeam(fc, id).fightObjectList;
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fc.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        session.send(new M19959_0(), vo_19959_0);

        for (FightObject fightObject : fightObjectList) {
            if (fightObject.godbook != 0) {
                final Vo_12025_0 vo_12025_0 = new Vo_12025_0();
                vo_12025_0.id = fightObject.fid;
                vo_12025_0.effect_no = fightObject.godbook;
                session.send(new M12025_0(), vo_12025_0);
            }
        }
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        session.send(new M7655_0(), vo_7655_0);
    }


}
