package org.linlinjava.litemall.gameserver.process;

import org.json.JSONObject;
import org.linlinjava.litemall.db.domain.*;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.game.*;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.*;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.*;


@Service
public class GameUtil {


    public static void addshouhu(Chara chara) {

        for (int i = 0; i < chara.listshouhu.size(); i++) {

            ShouHu shouHu = chara.listshouhu.get(i);
            ShouHuShuXing shouHuShuXing = chara.listshouhu.get(i).listShouHuShuXing.get(0);
            Hashtable<String, int[]> stringHashtable = PetAttributesUtils.helpPet(shouHuShuXing.penetrate, shouHuShuXing.metal, chara.level);
            int[] attributes = stringHashtable.get("attribute");
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
            shouHuShuXing.shape = 0;

            int[] ints = BasicAttributesUtils.calculationHelpAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4], shouHuShuXing.metal);
            shouHuShuXing.max_life = ints[0];
            shouHuShuXing.def = ints[0];
            shouHuShuXing.accurate = ints[2];
            shouHuShuXing.mana = ints[3];
            shouHuShuXing.parry = ints[4];
            shouHuShuXing.wiz = ints[5];
            shouHuShuXing.salary = 0;
            List list = new ArrayList();
            list.add(shouHu);
            GameObjectChar.send(new M12016_0(), list);
            GameUtil.dujineng(2, shouHuShuXing.metal, shouHuShuXing.skill, true, shouHu.id, chara);
        }


    }


    public static void addfabaojingyan(Chara chara1, int jingyan) {
        Boolean has = fabaojingyan(chara1, jingyan);
        if (has) {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "你的法宝获得了#R" + jingyan + "#n经验";
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20481_0(), vo_20481_0);
        }

    }


    public static Boolean fabaojingyan(Chara chara1, int jingyan) {
        Boolean has = false;
        for (int i = 0; i < chara1.backpack.size(); i++) {
            if (chara1.backpack.get(i).pos == 9) {
                if (chara1.backpack.get(i).goodsInfo.skill >= 24) {
                    return has;
                }
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara1);
                GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M65527_0(), listVo_65527_0);
                chara1.backpack.get(i).goodsInfo.pot = chara1.backpack.get(i).goodsInfo.pot + jingyan;
                List<Goods> list = new ArrayList<>();
                list.add(chara1.backpack.get(i));
                GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M65525_0(), list);
                if (chara1.backpack.get(i).goodsInfo.pot >= chara1.backpack.get(i).goodsInfo.resist_poison) {
                    chara1.backpack.get(i).goodsInfo.skill = chara1.backpack.get(i).goodsInfo.skill + 1;
                    chara1.backpack.get(i).goodsInfo.pot = 0;
                    jingyan = jingyan - chara1.backpack.get(i).goodsInfo.resist_poison;
                    chara1.backpack.get(i).goodsInfo.resist_poison = GameData.that.baseExperienceTreasureService.findOneByAttrib(chara1.backpack.get(i).goodsInfo.skill).getMaxLevel();

                    fabaojingyan(chara1, jingyan);
                }
                has = true;
                break;
            }
        }
        return has;

    }

    public static Goods beibaowupin(Chara chara, int pos) {
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == pos) {
                return chara.backpack.get(i);
            }
        }
        return null;
    }


    public static boolean belongCalendar() {
        Date nowTime = null;
        Date beginTime = null;
        Date endTime = null;
        SimpleDateFormat df = new SimpleDateFormat("mm");
        try {
            nowTime = df.parse(df.format(new Date()));
            beginTime = df.parse("29");
            endTime = df.parse("40");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


    public static void nextshaxing(Chara chara1, Chara duiyuan, int level, String replace) {

        Random random = new Random();

        if (replace.equals("天星")) {
            int cash = (int) (1231 * level);
            duiyuan.cash += cash;
            int i = Math.abs(duiyuan.level - level) / 5;
            if (i == 0) {
                i = 1;
            }
            int jingyan = 2597 * level / i;
            int i1 = random.nextInt(100);
            jingyan = (int) (jingyan * (1000 - i1) * 0.001);
            if (jingyan < 1) {
                jingyan = 1;
            }
            jingyan = shuangbei(chara1, jingyan);
            if (duiyuan.level - level > 29) {
                jingyan = 1;
            }
            huodejingyan(duiyuan, jingyan);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
        }
        if (replace.equals("地星")) {
            int i = Math.abs(duiyuan.level - level) / 5;
            if (i == 0) {
                i = 1;
            }
            int jingyan = 1298 * level / i;
            int i1 = random.nextInt(100);
            jingyan = (int) (jingyan * (1000 - i1) * 0.001);
            if (jingyan < 1) {
                jingyan = 1;
            }
            jingyan = shuangbei(chara1, jingyan);
            if (duiyuan.level - level > 29) {
                jingyan = 1;
            }
            huodejingyan(duiyuan, jingyan);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);

            int base_dh = (int) (0.29 * duiyuan.level * duiyuan.level * duiyuan.level);
            int owner_name = (int) (3272 * level / i / (duiyuan.friend > base_dh ? duiyuan.friend / base_dh : 1));
            adddaohang(duiyuan, owner_name);
            for (int j = 0; j < duiyuan.pets.size(); j++) {
                if (duiyuan.pets.get(j).id == duiyuan.chongwuchanzhanId) {
                    PetShuXing petShuXing = duiyuan.pets.get(j).petShuXing.get(0);
                    int base_pet_dh = (int) (0.29 * petShuXing.skill * petShuXing.skill * petShuXing.skill);
                    int intimacy = (int) (33 * level / (petShuXing.intimacy > base_pet_dh ? petShuXing.intimacy / base_pet_dh : 1));
                    petShuXing.intimacy += intimacy;
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "宠物获得武学#R" + intimacy;
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
                }
                listVo_65527_0 = GameUtil.a65527(duiyuan);
                GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
            }
        }


    }

    
    public static void shuayeguai(Chara chara1, Chara duiyuan, int level) {

        Random random = new Random();

        int i = Math.abs(duiyuan.level - level) / 5;
        if (i == 0) {
            i = 1;
        }
        int jingyan = 20 * level / i;
        int i1 = random.nextInt(100);
        jingyan = (int) (jingyan * (1000 - i1) * 0.001);
        if (jingyan < 1) {
            jingyan = 1;
        }
        
        jingyan = shuangbei(chara1, jingyan);

        huodejingyan(duiyuan, jingyan);
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
        GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
        i = random.nextInt(1000);
        if (i < 5 && level >= 60) {
            GameUtil.weijianding(duiyuan);
        }


    }


    public static void shidaojingyan(Chara chara1, Chara duiyuan, int id) {

        Random random = new Random();


        GameObjectChar.getGameObjectChar().gameMap.send(new M12285_1(), id);
        duiyuan.shidaodaguaijifen = duiyuan.shidaodaguaijifen + 2;


        int base_dh = (int) (0.29 * duiyuan.level * duiyuan.level * duiyuan.level);
        int owner_name = (int) (3272 * duiyuan.level / (duiyuan.friend > base_dh ? duiyuan.friend / base_dh : 1));
        adddaohang(duiyuan, owner_name);


        int jingyan = (int) (duiyuan.level * 1281);
        if (jingyan < 1) {
            jingyan = 1;
        }
        jingyan = shuangbei(chara1, jingyan);
        huodejingyan(duiyuan, jingyan);

        for (int i = 0; i < duiyuan.pets.size(); i++) {
            if (duiyuan.pets.get(i).id == duiyuan.chongwuchanzhanId) {
                PetShuXing petShuXing = duiyuan.pets.get(i).petShuXing.get(0);
                int base_pet_dh = (int) (0.29 * petShuXing.skill * petShuXing.skill * petShuXing.skill);
                int intimacy = (int) (33 * petShuXing.skill / (petShuXing.intimacy > base_pet_dh ? petShuXing.intimacy / base_pet_dh : 1));
                petShuXing.intimacy += intimacy;
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "宠物获得武学#R" + intimacy;
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
            }
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
        }
    }

    public static void nextxuanshang(Chara chara1, Chara duiyuan) {

        Random random = new Random();

        duiyuan.xuanshangcishu++;

        GameObjectChar.sendduiwu(new M12285_1(), chara1.npcxuanshang.get(0).id, chara1.id);


        int base_dh = (int) (0.29 * duiyuan.level * duiyuan.level * duiyuan.level);
        int owner_name = (int) (878 * duiyuan.level / (duiyuan.friend > base_dh ? duiyuan.friend / base_dh : 1));
        adddaohang(duiyuan, owner_name);
        int cash = (int) (18936 * duiyuan.level);
        duiyuan.cash += cash;
        for (int i = 0; i < duiyuan.pets.size(); i++) {
            if (duiyuan.pets.get(i).id == duiyuan.chongwuchanzhanId) {
                PetShuXing petShuXing = duiyuan.pets.get(i).petShuXing.get(0);
                int base_pet_dh = (int) (0.29 * petShuXing.skill * petShuXing.skill * petShuXing.skill);
                int intimacy = (int) (29 * petShuXing.skill / (petShuXing.intimacy > base_pet_dh ? petShuXing.intimacy / base_pet_dh : 1));
                petShuXing.intimacy += intimacy;
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "宠物获得武学#R" + intimacy;
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
            }
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
        }
        GameUtilRenWu.renwukuangkuang("悬赏祍务", "", "", duiyuan);


        chara1.npcXuanShangName = "领取奖励";
        chara1.npcxuanshang = new ArrayList<>();

    }


    public static boolean duiwudengji(Chara chara, GameObjectChar session) {
        boolean hasyes = true;
        for (int i = 0; i < session.gameTeam.duiwu.size() - 1; i++) {
            if (Math.abs(session.gameTeam.duiwu.get(i).level - session.gameTeam.duiwu.get(i + 1).level) > 10) {
                hasyes = false;
            }
        }
        return hasyes;
    }

    public static boolean duiwudengji80(Chara chara, GameObjectChar session) {
        boolean hasyes = true;
        for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
            if (session.gameTeam.duiwu.get(i).level < 80) {
                hasyes = false;
            }
        }
        return hasyes;
    }

    
    public static void adddaohang(Chara chara, int daohangdian) {
        chara.owner_name += daohangdian;
        chara.friend += chara.owner_name / 1440;
        chara.owner_name = chara.owner_name % 1440;

        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "获得道行#R" + daohangdian;
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M20481_0(), vo_20481_0);
    }

    public static int shuangbei(Chara chara1, int jingyan) {
        if (chara1.charashuangbei == 1 && chara1.enable_double_points > 0) {
            jingyan = jingyan * 2;
            chara1.enable_double_points = chara1.enable_double_points - 4;
        }
        if (chara1.enable_double_points <= 0) {
            chara1.enable_double_points = 0;
        }
        return jingyan;
    }


    
    public static void nextxiuxing(Chara chara1, Chara duiyuan) {

        Random random = new Random();

        duiyuan.xiuxingcishu++;
        int chubao = chara1.xiuxingcishu - 1;
        if (duiyuan.xiuxingcishu <= 40) {
            int use_money_type = (int) (duiyuan.level / 10 * 6815 * (1 + 0.2 * chubao));
            duiyuan.use_money_type += use_money_type;
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "获得代金券#R" + use_money_type;
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
            int jingyan = (int) (1281 * duiyuan.level * (1 + 0.05 * chubao));
            
            jingyan = shuangbei(chara1, jingyan);
            huodejingyan(duiyuan, jingyan);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
            if (duiyuan.xiuxingcishu == 20 || duiyuan.xiuxingcishu == 40) {
                GameUtil.weijianding(duiyuan);

            }
        }

        String[] npces = {"雷神", "花神", "炎神", "山神", "龙神"};
        int i = random.nextInt(npces.length);
        chara1.xiuxingNpcname = npces[i];
        int cishu = chubao + 1;
        String task_prompt = "";
        String show_name = "";
        task_prompt = "拜访#P" + npces[i] + "| M=【修行】请仙人赐教#P";
        show_name = "【修炼】修行(" + cishu + "/40)";

        if (chara1.xiuxingcishu > 40) {
            task_prompt = "";
            show_name = "";
        }
        
        GameUtilRenWu.renwukuangkuang("修炼", task_prompt, show_name, chara1);

        Vo_45063_0 vo_45063_0 = new Vo_45063_0();
        vo_45063_0.task_name = task_prompt;
        vo_45063_0.check_point = 147761859;
        GameObjectChar.sendduiwu(new M45063_0(), vo_45063_0, chara1.id);


    }

    
    public static void nextshuadao(Chara chara1, Chara duiyuan) {

        Random random = new Random();
        int chubao = (chara1.shuadao - 1) % 10;

        duiyuan.shuadao++;
        GameObjectChar.sendduiwu(new M12285_1(), chara1.npcshuadao.get(0).id, chara1.id);


        if (duiyuan.shuadao <= 400) {
            double beishu = 1;
            if (chara1.npcshuadao.get(0).leixing == 3) {
                beishu = 1.5;
            }
            if (chara1.npcshuadao.get(0).leixing == 4) {
                beishu = 3;
            }
            int base_dh = (int) (0.29 * duiyuan.level * duiyuan.level * duiyuan.level);
            
            int owner_name = (int) ((39 * duiyuan.level * (1 + 0.2 * chubao) / (duiyuan.friend > base_dh ? duiyuan.friend / base_dh : 1)) * beishu);
            if (duiyuan.ziqihongmeng == 1 && duiyuan.extra_skill > 0) {
                owner_name = (int) (owner_name * 1.5);
                chara1.extra_skill = chara1.extra_skill - 4;
                if (chara1.extra_skill <= 0) {
                    chara1.extra_skill = 0;
                }
            }
            adddaohang(duiyuan, owner_name);


            addfabaojingyan(duiyuan, (int) (beishu * chara1.level * 3));


            for (int i = 0; i < duiyuan.pets.size(); i++) {
                if (duiyuan.pets.get(i).id == duiyuan.chongwuchanzhanId) {
                    PetShuXing petShuXing = duiyuan.pets.get(i).petShuXing.get(0);
                    int base_pet_dh = (int) (0.29 * petShuXing.skill * petShuXing.skill * petShuXing.skill) + 1;
                    int intimacy = (int) ((22 * petShuXing.skill * (1 + 0.2 * chubao) / (petShuXing.intimacy > base_pet_dh ? petShuXing.intimacy / base_pet_dh : 1)) * beishu);
                    if (duiyuan.chongfengsan == 1 && duiyuan.shuadaochongfeng_san > 0) {
                        intimacy = (int) (intimacy * 1.5);
                        chara1.shuadaochongfeng_san = chara1.shuadaochongfeng_san - 4;
                        if (chara1.shuadaochongfeng_san <= 0) {
                            chara1.shuadaochongfeng_san = 0;
                        }
                    }
                    petShuXing.intimacy += intimacy;
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "宠物获得武学#R" + intimacy;
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
                }
            }
            int use_money_type = (int) ((159 * duiyuan.level * (1 + 0.2 * chubao)) * beishu);
            duiyuan.use_money_type += use_money_type;
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "获得代金券#R" + use_money_type;
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
            int cash = (int) ((int) (673 * duiyuan.level * (1 + 0.2 * chubao)) * beishu);
            duiyuan.cash += cash;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
        }


        int cishu = chubao + 1;
        String task_prompt = "";
        String show_name = "";
        if (chara1.npcshuadao.get(0).leixing == 2) {
            task_prompt = "找#P通灵道人|M=【降妖】降拿妖怪#P领取降妖任务";
            show_name = "降妖(" + cishu + "/10)";
        }

        if (chara1.npcshuadao.get(0).leixing == 3) {
            task_prompt = "找#P陆压真人|M=【伏魔】我这就去#P领取任务";
            show_name = "伏魔(" + cishu + "/10)";
        }

        
        if (chara1.npcshuadao.get(0).leixing == 4) {
            task_prompt = "找#P清微真人|M=【伏魔】我这就去#P领取任务";
            show_name = "飞仙渡劫(" + cishu + "/10)";
        }

        
        GameUtilRenWu.renwukuangkuang("降妖", task_prompt, show_name, chara1);

        Vo_45063_0 vo_45063_0 = new Vo_45063_0();
        vo_45063_0.task_name = task_prompt;
        vo_45063_0.check_point = 147761859;
        GameObjectChar.sendduiwu(new M45063_0(), vo_45063_0, chara1.id);



    }

    public static void chubaorenwu(Chara chara1, Chara duiyuan) {
        Random random = new Random();
        int chubao = (chara1.chubao - 1) % 10;

        duiyuan.chubao++;
        List<RenwuMonster> all = GameData.that.baseRenwuMonsterService.findByType(1);

        int k = random.nextInt(all.size());
        RenwuMonster renwuMonster = all.get(k);
        String name = renwuMonster.getName() + GameUtil.getRandomJianHan();
        Renwu tasks = GameData.that.baseRenwuService.findOneByCurrentTask(chara1.current_task);
        org.linlinjava.litemall.db.domain.Map map = GameData.that.baseMapService.findOneByName(renwuMonster.getMapName());

        GameObjectChar.sendduiwu(new M12285_1(), chara1.npcchubao.get(0).id, chara1.id);


        if (duiyuan.chubao < 21) {
            int base_dh = (int) (0.29 * duiyuan.level * duiyuan.level * duiyuan.level);
            
            int owner_name = (int) (39 * duiyuan.level * (1 + 0.2 * chubao) / (duiyuan.friend > base_dh ? duiyuan.friend / base_dh : 1));
            adddaohang(duiyuan, owner_name);

            for (int i = 0; i < duiyuan.pets.size(); i++) {
                if (duiyuan.pets.get(i).id == duiyuan.chongwuchanzhanId) {
                    PetShuXing petShuXing = duiyuan.pets.get(i).petShuXing.get(0);
                    int base_pet_dh = (int) (0.29 * petShuXing.skill * petShuXing.skill * petShuXing.skill);
                    int intimacy = (int) (13 * petShuXing.skill * (1 + 0.2 * chubao) / (petShuXing.intimacy > base_pet_dh ? petShuXing.intimacy / base_pet_dh : 1));
                    petShuXing.intimacy += intimacy;
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "宠物获得武学#R" + intimacy;
                    vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                    GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
                }
            }
            int use_money_type = (int) (159 * duiyuan.level * (1 + 0.2 * chubao));
            duiyuan.use_money_type += use_money_type;
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "获得代金券#R" + use_money_type;
            vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M20481_0(), vo_20481_0);
            int cash = (int) (471 * duiyuan.level * (1 + 0.2 * chubao));
            duiyuan.cash += cash;
            int jingyan = (int) (546 * duiyuan.level * (1 + 0.2 * chubao));
            
            jingyan = shuangbei(chara1, jingyan);
            huodejingyan(duiyuan, jingyan);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(duiyuan);
            GameObjectCharMng.getGameObjectChar(duiyuan.id).sendOne(new M65527_0(), listVo_65527_0);
        }
        chara1.npcchubao = new ArrayList<>();

        Vo_65529_0 vo_65529_0 = new Vo_65529_0();
        vo_65529_0.mapid = map.getMapId();
        vo_65529_0.id = GameUtil.getCard(chara1);
        vo_65529_0.x = renwuMonster.getX();
        vo_65529_0.y = renwuMonster.getY();
        vo_65529_0.icon = renwuMonster.getIcon();
        vo_65529_0.type = 2;
        vo_65529_0.org_icon = renwuMonster.getIcon();
        vo_65529_0.portrait = renwuMonster.getIcon();
        vo_65529_0.name = name;
        vo_65529_0.level = chara1.level;
        chara1.npcchubao.add(vo_65529_0);
        if (chara1.chubao == 21) {
            String task_prompt = "";
            String show_name = "";
            
            GameUtilRenWu.renwukuangkuang("为民除暴", task_prompt, show_name, chara1);
            return;
        }

        if (chara1.mapid == chara1.npcchubao.get(0).mapid) {
            GameObjectChar.sendduiwu(new M65529_0(), chara1.npcchubao.get(0), chara1.id);
        }

        String task_prompt = "捉拿#P" + name + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")|M=就是来抓你的|$0#P";
        int cishu = chubao + 1;
        String show_name = "为民除暴(" + cishu + "/10)";
        
        GameUtilRenWu.renwukuangkuang("为民除暴", task_prompt, show_name, chara1);
        Vo_45063_0 vo_45063_0 = new Vo_45063_0();
        vo_45063_0.task_name = task_prompt;
        vo_45063_0.check_point = 147761859;
        GameObjectChar.sendduiwu(new M45063_0(), vo_45063_0, chara1.id);

    }

    public static void chenghaoxiaoxi(Chara chara) {
        List<Vo_62209_0> list = new LinkedList<>();
        Vo_62209_0 vo_62209_0 = new Vo_62209_0();
        vo_62209_0.stringformat = "无显示";
        vo_62209_0.title = "";
        vo_62209_0.titled_left_time = 0;
        list.add(vo_62209_0);
        for (Map.Entry<String, String> entry : chara.chenghao.entrySet()) {
            vo_62209_0 = new Vo_62209_0();
            vo_62209_0.stringformat = entry.getKey();
            vo_62209_0.title = entry.getValue();
            vo_62209_0.titled_left_time = 0;
            list.add(vo_62209_0);
        }
        GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M62209_0(), list);
    }


    public static List zhandouisyoufabao(Chara chara) {
        List fabao = new LinkedList();
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 9) {
                fabao.add(chara.backpack.get(i).goodsInfo.str);
                fabao.add(chara.backpack.get(i).goodsInfo.skill);
                fabao.add(chara.backpack.get(i).goodsInfo.shape);
            }
        }
        return fabao;
    }

    
    public static void shuafabao(Chara chara) {
        String[] fb = {"番天印", "定海珠", "混元金斗", "阴阳镜", "九龙神火罩", "卸甲金葫"};
        Random random = new Random();
        int i = random.nextInt(5);
        String fabao = fb[random.nextInt(fb.length)];
        StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(fabao);
        List<Goods> list = new ArrayList<>();
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        if (info.getQuality() != null) {
            goods.goodsInfo.quality = info.getQuality();
        }
        if (info.getSilverCoin() != null) {
            goods.goodsInfo.silver_coin = info.getSilverCoin();
        }
        goods.goodsInfo.type = info.getType();
        goods.goodsInfo.attrib = 0;
        goods.goodsInfo.shape = 0;
        goods.goodsInfo.str = info.getName();
        goods.goodsInfo.nick = 0;
        goods.goodsInfo.recognize_recognized = info.getRecognizeRecognized();
        goods.goodsInfo.auto_fight = UUID.randomUUID().toString();
        goods.goodsInfo.total_score = info.getTotalScore();
        goods.goodsInfo.rebuild_level = 50000;
        goods.goodsInfo.value = info.getValue();
        goods.goodsInfo.degree_32 = 1;
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.pot = 0;
        goods.goodsInfo.damage_sel_rate = 400976;
        goods.goodsInfo.diandqk_frozen_round = 3;

        goods.goodsInfo.skill = 24;
        goods.goodsInfo.amount = 9;
        goods.goodsInfo.resist_poison = 1830;
        goods.goodsInfo.shuadao_ziqihongmeng = i + 1;
        chara.backpack.add(goods);
        GameObjectChar.send(new M65525_0(), chara.backpack);
        Vo_40964_0 vo_40964_0 = new Vo_40964_0();
        vo_40964_0.type = 1;
        vo_40964_0.name = fabao;
        vo_40964_0.param = "20691134";
        vo_40964_0.rightNow = 0;
        GameObjectChar.send(new M40964_0(), vo_40964_0);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "获得#R" + fabao;
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectChar.send(new M20481_0(), vo_20481_0);

    }

    public static void weijianding(Chara chara) {
        Random random = new Random();
        int[] eqType = {1, 2, 10, 3};
        int leixing = eqType[random.nextInt(4)];
        String zhuangbname = zhuangbname(chara, leixing);
        List<Hashtable<String, Integer>> hashtables = equipmentLuckDraw(chara.level, leixing);
        ZhuangbeiInfo zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByStr(zhuangbname);
        GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 1, 1);
    }

    public static void renwujiangli(Chara chara) {
        Renwu renwu = GameData.that.baseRenwuService.findOneByCurrentTask(chara.current_task);
        String reward = renwu.getReward();
        String[] split = reward.split("\\,");
        for (int i = 0; i < split.length; i++) {
            String[] jiangli = split[i].split("\\#");
            GameUtil.huodechoujiang(jiangli, chara);
        }
    }

    public static String nextrenw(String str) {
        String substring = str.substring(9, str.length());
        int next = Integer.valueOf(substring) + 1;
        String substring1 = str.substring(0, 9);
        String renwu = substring1 + next;
        Renwu serviceOneByCurrentTask = GameData.that.baseRenwuService.findOneByCurrentTask(renwu);
        if (renwu.equals("主线—浮生若梦_s23")) {


            return "";
        }
        if (serviceOneByCurrentTask.getNpcName() != null) {
            if (serviceOneByCurrentTask.getNpcName().equals("跳")) {
                return nextrenw(renwu);

            }
        }
        return renwu;
    }


    public static void removemoney(Chara chara, int monet) {
        if (chara.lock_exp == 0) {
            chara.balance = chara.balance - monet;
        } else {
            chara.use_money_type = chara.use_money_type - monet;
        }
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);
    }

    public static void addVip(Chara chara) {
        if (chara.vipTime != 0) {
            chara.vipTimeShengYu = (int) (System.currentTimeMillis() / 1000) - chara.vipTime;
        }

        Vo_53257_0 vo_53257_0 = new Vo_53257_0();
        vo_53257_0.vipType = chara.vipType;
        vo_53257_0.leftTime = 945225798 + chara.vipTimeShengYu;
        vo_53257_0.curTime = 622080000;
        vo_53257_0.isGet = chara.isGet;
        vo_53257_0.tempInsider = 0;
        GameObjectChar.send(new M53257_0(), vo_53257_0);
    }

    public static void genchongfei(Chara chara) {
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 37) {
                Vo_65529_0 vo_65529_0 = new Vo_65529_0();
                vo_65529_0.id = chara.genchong_icon;
                vo_65529_0.x = chara.x;
                vo_65529_0.y = chara.y;
                vo_65529_0.dir = 5;
                vo_65529_0.icon = chara.genchong_icon;
                vo_65529_0.type = 32768;
                vo_65529_0.sub_type = 2;
                vo_65529_0.owner_id = chara.id;
                vo_65529_0.name = chara.backpack.get(i).goodsInfo.str;
                vo_65529_0.org_icon = chara.genchong_icon;
                vo_65529_0.portrait = chara.genchong_icon;
                GameObjectChar.getGameObjectChar().gameMap.send(new M65529_0(), vo_65529_0);
            }
        }

    }


    public static void removerbeibaocangku(Chara chara) {
        List<Goods> removergoods = new ArrayList<>();
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods.goodsInfo.owner_id == 0) {
                removergoods.add(goods);
            }
        }

        for (int i = 0; i < removergoods.size(); i++) {
            List<Goods> listbeibao = new ArrayList<>();
            Goods goods2 = new Goods();
            goods2.goodsBasics = null;
            goods2.goodsInfo = null;
            goods2.goodsLanSe = null;
            goods2.pos = removergoods.get(i).pos;
            listbeibao.add(goods2);
            GameObjectChar.send(new M65525_0(), listbeibao);
            chara.backpack.remove(removergoods.get(i));
        }
        removergoods = new ArrayList<>();
        for (int i = 0; i < chara.cangku.size(); i++) {
            Goods goods = chara.cangku.get(i);
            if (goods.goodsInfo.owner_id == 0) {
                removergoods.add(goods);
            }
        }

        for (int i = 0; i < removergoods.size(); i++) {
            chara.cangku.remove(removergoods.get(i));
            Vo_61677_0 vo_61677_0 = new Vo_61677_0();
            vo_61677_0.list = chara.cangku;
            GameObjectChar.send(new M61677_0(), vo_61677_0);
        }
    }

    
    public static void addpetjingyan(Petbeibao petbeibao, int jingyan, Chara chara) {
        PetShuXing petShuXing = petbeibao.petShuXing.get(0);
        petShuXing.pot += jingyan;

        if (petShuXing.pot >= petShuXing.resist_poison && petShuXing.skill < 125) {
            petShuXing.pot = petShuXing.pot - petShuXing.resist_poison;
            petShuXing.skill = petShuXing.skill + 1;
            Experience oneByMaxLevel = GameData.that.baseExperienceService.findOneByAttrib(petShuXing.skill);
            petShuXing.resist_poison = oneByMaxLevel.getMaxLevel() / 2;
            Vo_4323_0 vo_4323_0 = new Vo_4323_0();
            vo_4323_0.id = petbeibao.id;
            vo_4323_0.level = 1;
            GameObjectChar.send(new M4323_0(), vo_4323_0);
            petShuXing.phy_power++;
            petShuXing.life++;
            petShuXing.speed++;
            petShuXing.mag_power++;
            petShuXing.polar_point += 4;
            if (petShuXing.skill < 60 && petShuXing.skill % 2 != 0) {
                petShuXing.stamina++;
            } else if (petShuXing.skill > 60) {
                petShuXing.stamina++;
            }
            if (petShuXing.pot >= petShuXing.resist_poison) {
                addpetjingyan(petbeibao, 0, chara);
            }
            BasicAttributesUtils.petshuxing(petShuXing);
            petShuXing.max_life = petShuXing.def;
            petShuXing.max_mana = petShuXing.dex;
            if (petbeibao.petShuXing.get(0).suit_light_effect != 0) {
                for (int i = 0; i < petbeibao.petShuXing.size(); i++) {
                    if (petbeibao.petShuXing.get(i).no == 23) {
                        petbeibao.petShuXing.get(i).accurate = 4 * (petbeibao.petShuXing.get(0).hide_mount - 1) * petbeibao.petShuXing.get(0).skill;
                        petbeibao.petShuXing.get(i).mana = 4 * (petbeibao.petShuXing.get(0).hide_mount - 1) * petbeibao.petShuXing.get(0).skill;
                        petbeibao.petShuXing.get(i).wiz = 3 * (petbeibao.petShuXing.get(0).hide_mount - 1) * petbeibao.petShuXing.get(0).skill;
                    }
                }
            }


            List list = new ArrayList();
            boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
            GameUtil.dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, petbeibao.id, chara);
            list.add(petbeibao);
            GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M65507_0(), list);
        }
        List list = new ArrayList();
        list.add(petbeibao);
        GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M65507_0(), list);
    }

    
    public static void huodejingyan(Chara chara, int jingyan) {
        jingyan = jingyan * 5;
        addjingyan(chara, jingyan);
        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).id == chara.chongwuchanzhanId) {
                chara.pets.get(i).petShuXing.get(0).shape += 10;
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                addpetjingyan(chara.pets.get(i), jingyan, chara);
                vo_20481_0.msg = "宠物获得#R" + jingyan / 2 + "#n经验";
                vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
                GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M20481_0(), vo_20481_0);
                break;
            }
        }
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你获得了#R" + jingyan + "#n经验";
        vo_20481_0.time = (int) (System.currentTimeMillis() / 1000);
        GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M20481_0(), vo_20481_0);
    }


    
    public static void addjingyan(Chara chara, int jingyan) {
        chara.pot += jingyan;
        if (chara.pot >= chara.resist_poison && chara.level < 128) {
            chara.pot = chara.pot - chara.resist_poison;
            chara.level = chara.level + 1;
            Experience oneByMaxLevel = GameData.that.baseExperienceService.findOneByAttrib(chara.level);
            chara.resist_poison = oneByMaxLevel.getMaxLevel();
            Vo_4323_0 vo_4323_0 = new Vo_4323_0();
            vo_4323_0.id = chara.id;
            vo_4323_0.level = 1;
            GameObjectChar.send(new M4323_0(), vo_4323_0);
            chara.phy_power++;
            chara.life++;
            chara.speed++;
            chara.mag_power++;
            chara.polar_point += 4;
            if (chara.level < 60 && chara.level % 2 != 0) {
                chara.stamina++;
            } else if (chara.level > 60) {
                chara.stamina++;
            }
            if (chara.pot >= chara.resist_poison) {
                addjingyan(chara, 0);
            }
            BasicAttributesUtils.shuxing(chara);
            chara.max_life = chara.def + chara.zbAttribute.def;
            chara.max_mana = chara.dex + chara.zbAttribute.dex;
            GameUtil.addshouhu(chara);

            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M65527_0(), listVo_65527_0);

        }

    }

    public static void cangkuaddwupin(Goods goods, Chara chara) {
        boolean has = true;
        int munber = 10;
        if ("凝香幻彩#炫影霜星#风寂云清#枯月流魂#冰落残阳#雷极弧光".contains(goods.goodsInfo.str)) {
            munber = 999;
        }
        for (int i = 0; i < chara.cangku.size(); i++) {
            Goods goods1 = chara.cangku.get(i);
            Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
            Map<Object, Object> objectMapGoodxin1 = UtilObjMapshuxing.GoodsLanSe(goods1.goodsLanSe);

            objectMapGoodxin.remove("auto_fight");
            objectMapGoodxin.remove("owner_id");
            Map<Object, Object> objectMapGoodjold = UtilObjMapshuxing.GoodsInfo(goods1.goodsInfo);
            Map<Object, Object> objectMapGoodjold1 = UtilObjMapshuxing.GoodsLanSe(goods1.goodsLanSe);
            objectMapGoodjold.remove("auto_fight");
            objectMapGoodjold.remove("owner_id");
            if (objectMapGoodjold.toString().equals(objectMapGoodxin.toString()) && objectMapGoodxin1.toString().equals(objectMapGoodjold1.toString()) && goods1.goodsInfo.degree_32 == 1) {

                if (goods1.goodsInfo.owner_id < munber) {
                    int owner = goods1.goodsInfo.owner_id;
                    goods1.goodsInfo.owner_id = goods1.goodsInfo.owner_id + goods.goodsInfo.owner_id;
                    if (goods1.goodsInfo.owner_id >= munber) {
                        goods1.goodsInfo.owner_id = munber;
                        goods.goodsInfo.owner_id = goods.goodsInfo.owner_id - munber + owner;
                    } else {
                        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                        vo_61677_0.list = chara.cangku;
                        GameObjectChar.send(new M61677_0(), vo_61677_0);
                        has = false;
                    }
                }
            }
        }
        if (has) {
            List list = new ArrayList();
            if (goods.goodsInfo.owner_id > munber) {
                int len = goods.goodsInfo.owner_id / munber;
                int last = goods.goodsInfo.owner_id % munber;
                for (int i = 0; i < len; i++) {
                    Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.Goods(goods);
                    Goods goodsxin = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectMapGoodxin), Goods.class);
                    goodsxin.pos = cangkuweizhi(chara);
                    goodsxin.goodsInfo.owner_id = munber;
                    chara.cangku.add(goodsxin);
                    list = new ArrayList();
                    list.add(goodsxin);
                    Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                    vo_61677_0.list = chara.cangku;
                    GameObjectChar.send(new M61677_0(), vo_61677_0);
                }
                if (last != 0) {
                    Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.Goods(goods);
                    Goods goodsxin = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectMapGoodxin), Goods.class);
                    goodsxin.pos = cangkuweizhi(chara);
                    goodsxin.goodsInfo.owner_id = last;
                    chara.cangku.add(goodsxin);
                    list = new ArrayList();
                    list.add(goodsxin);
                    Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                    vo_61677_0.list = chara.cangku;
                    GameObjectChar.send(new M61677_0(), vo_61677_0);
                }
            } else {
                goods.pos = cangkuweizhi(chara);
                chara.cangku.add(goods);
                list = new ArrayList();
                list.add(goods);
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.list = chara.cangku;
                GameObjectChar.send(new M61677_0(), vo_61677_0);
            }
            Vo_61677_0 vo_61677_0 = new Vo_61677_0();
            vo_61677_0.list = chara.cangku;
            GameObjectChar.send(new M61677_0(), vo_61677_0);
        }
    }

    public static void addwupin(Goods goods, Chara chara) {
        boolean has = true;
        int munber = 10;
        if ("凝香幻彩#炫影霜星#风寂云清#枯月流魂#冰落残阳#雷极弧光".contains(goods.goodsInfo.str)) {
            munber = 999;
        }
        int pos = beibaoweizhi(chara);
        if (pos == 0) {
            return;
        }
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods1 = chara.backpack.get(i);
            Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
            Map<Object, Object> objectMapGoodxin1 = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
            objectMapGoodxin.remove("auto_fight");
            objectMapGoodxin.remove("owner_id");
            Map<Object, Object> objectMapGoodjold = UtilObjMapshuxing.GoodsInfo(goods1.goodsInfo);
            Map<Object, Object> objectMapGoodjold1 = UtilObjMapshuxing.GoodsLanSe(goods1.goodsLanSe);
            objectMapGoodjold.remove("auto_fight");
            objectMapGoodjold.remove("owner_id");
            if (objectMapGoodjold.toString().equals(objectMapGoodxin.toString()) && objectMapGoodxin1.toString().equals(objectMapGoodjold1.toString()) && goods1.goodsInfo.degree_32 == 1) {

                if (goods1.goodsInfo.owner_id < munber) {
                    int owner = goods1.goodsInfo.owner_id;
                    goods1.goodsInfo.owner_id = goods1.goodsInfo.owner_id + goods.goodsInfo.owner_id;
                    if (goods1.goodsInfo.owner_id >= munber) {
                        goods1.goodsInfo.owner_id = munber;
                        goods.goodsInfo.owner_id = goods.goodsInfo.owner_id - munber + owner;
                    } else {
                        GameObjectChar.send(new M65525_0(), chara.backpack);
                        has = false;
                    }
                }
            }
        }
        if (has) {

            List list = new ArrayList();
            if (goods.goodsInfo.owner_id > munber) {
                int len = goods.goodsInfo.owner_id / munber;
                int last = goods.goodsInfo.owner_id % munber;
                for (int i = 0; i < len; i++) {
                    Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.Goods(goods);
                    Goods goodsxin = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectMapGoodxin), Goods.class);
                    goodsxin.pos = beibaoweizhi(chara);
                    goodsxin.goodsInfo.owner_id = munber;
                    chara.backpack.add(goodsxin);
                    list = new ArrayList();
                    list.add(goodsxin);
                    GameObjectChar.send(new M65525_0(), chara.backpack);
                }
                if (last != 0) {
                    Map<Object, Object> objectMapGoodxin = UtilObjMapshuxing.Goods(goods);
                    Goods goodsxin = (Goods) JSONUtils.parseObject(JSONUtils.toJSONString(objectMapGoodxin), Goods.class);
                    goodsxin.pos = beibaoweizhi(chara);
                    goodsxin.goodsInfo.owner_id = last;
                    chara.backpack.add(goodsxin);
                    list = new ArrayList();
                    list.add(goodsxin);
                    GameObjectChar.send(new M65525_0(), chara.backpack);
                }
            } else if (goods.goodsInfo.owner_id != 0) {
                goods.pos = beibaoweizhi(chara);
                chara.backpack.add(goods);
                list = new ArrayList();
                list.add(goods);
                GameObjectChar.send(new M65525_0(), chara.backpack);
            }
            GameObjectChar.send(new M65525_0(), chara.backpack);
        }
    }


    public static Vo_49179_0 a49179(List<SaleGood> saleGoodList, Chara chara) {
        Vo_49179_0 vo_49179_0 = new Vo_49179_0();
        vo_49179_0.dealNum = 0;
        vo_49179_0.sellCash = String.valueOf(chara.jishou_coin);
        vo_49179_0.stallTotalNum = 4;
        vo_49179_0.record_count_max = 30;
        for (int i = 0; i < saleGoodList.size(); i++) {


            SaleGood saleGood = saleGoodList.get(i);


            Vo_49179 vo_49179 = new Vo_49179();

            vo_49179.name = saleGood.getName();
            if (saleGood.getName().contains("超级黑水晶·")) {
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
                vo_49179.name = saleGood.getName() + "|" + value + "|1";
            }
            vo_49179.id = saleGood.getGoodsId();
            vo_49179.price = saleGood.getPrice();
            vo_49179.pos = 2;
            vo_49179.status = 2;
            vo_49179.startTime = saleGood.getStartTime();
            vo_49179.endTime = saleGood.getEndTime();
            vo_49179.level = 0;
            vo_49179.unidentified = 1;
            vo_49179.amount = saleGood.getReqLevel();
            vo_49179.req_level = 635;
            vo_49179.extra = 125;
            vo_49179.item_polar = 0;
            vo_49179.cg_price_count = 4;
            vo_49179.init_price = saleGood.getPrice();
            vo_49179_0.vo_49179s.add(vo_49179);
        }
        return vo_49179_0;
    }

    public static void a49159(Chara chara) {
        Vo_49159_0 vo_49159_3 = new Vo_49159_0();
        int isCanSign = 0;
        for (int j = 0; j < chara.shenmiliwu.size(); j++) {
            if (!chara.shenmiliwu.get(j).name.equals("")) {
                vo_49159_3.leftTime += chara.shenmiliwu.get(j).time;
            }
        }
        for (int i = 0; i < chara.shenmiliwu.size(); i++) {
            if (chara.shenmiliwu.get(i).name.equals("")) {
                int times = chara.shenmiliwu.get(i).time;
                vo_49159_3.leftTime = (int) (times - (chara.online_time / 1000));
                vo_49159_3.leftTime = (int) (vo_49159_3.leftTime - (System.currentTimeMillis() - chara.uptime) / 1000);
                if (vo_49159_3.leftTime > 0) {
                    break;
                } else {
                    isCanSign++;
                }
            }
        }

        vo_49159_3.times = isCanSign;
        vo_49159_3.leftTimes = 8;
        vo_49159_3.isCanSign = 0;
        vo_49159_3.isCanGetNewPalyerGift = 0;
        vo_49159_3.firstChargeState = 2;
        vo_49159_3.cumulativeReward = 255;
        vo_49159_3.loginGiftState = 2;
        vo_49159_3.activeCount = 255;
        vo_49159_3.holidayCount = 255;
        vo_49159_3.isCanReplenishSign = 255;
        vo_49159_3.chargePointFlag = 255;
        vo_49159_3.consumePointFlag = 255;
        vo_49159_3.isShowHuiGui = 0;
        vo_49159_3.canGetZXQYHuoYue = 0;
        vo_49159_3.canGetZXQYSevenLogin = 0;
        vo_49159_3.isShowZhaohui = 0;
        vo_49159_3.activeVIPFlag = 0;
        vo_49159_3.rename_discount_time = 0;
        vo_49159_3.summerSF2017 = 0;
        vo_49159_3.zaohua = 255;
        vo_49159_3.welcomeDrawStatue = 255;
        vo_49159_3.activeLoginStatue = 255;
        vo_49159_3.xundcf = 255;
        vo_49159_3.mergeLoginStatus = 255;
        vo_49159_3.mergeLoginActiveStatus = 255;
        vo_49159_3.reentryAsktaoRecharge = 255;
        vo_49159_3.expStoreStatus = 0;
        vo_49159_3.isShowXYFL = 255;
        vo_49159_3.isShowXFSD = 0;
        vo_49159_3.newServeAddNum = 0;
        GameObjectChar.send(new M49159_0(), vo_49159_3);
    }


    public static boolean isNow(Date date) {
        
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        
        String nowDay = sf.format(now);
        
        String day = sf.format(date);

        return day.equals(nowDay);


    }

    public static List<JiNeng> dujineng(int leixing, int pos, int level, boolean isMagic, int id, Chara chara) {
        List<JiNeng> jiNengList = new ArrayList<>();
        List<JSONObject> nomelSkills = PetAndHelpSkillUtils.getNomelSkills(leixing, pos, level, true);
        for (int i = 0; i < nomelSkills.size(); i++) {
            JiNeng jiNeng = new JiNeng();
            JSONObject jsonObject = nomelSkills.get(i);
            jiNeng.id = id;
            jiNeng.skill_no = Integer.parseInt((String) jsonObject.get("skillNo"));
            JSONObject jsonObject1 = PetAndHelpSkillUtils.jsonArray(jiNeng.skill_no);
            jiNeng.skill_attrib1 = Integer.parseInt((String) jsonObject1.get("skill_attrib"));
            jiNeng.skill_attrib = (int) jsonObject.get("skillLevel");
            jiNeng.skill_level = (int) jsonObject.get("skillLevel");
            jiNeng.skillRound = jsonObject.optInt("skillRound");
            jiNeng.level_improved = 0;
            jiNeng.skill_mana_cost = (int) jsonObject.get("skillBlue");
            jiNeng.skill_nimbus = 42949672;
            jiNeng.skill_disabled = 0;
            jiNeng.range = (int) jsonObject.get("skillNum");
            jiNeng.max_range = (int) jsonObject.get("skillNum");
            jiNengList.add(jiNeng);
        }
        List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(jiNengList);
        GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M32747_0(), vo_32747_0List);

        return jiNengList;
    }


    
    public static int getCard(Chara chara) {
        chara.allId = chara.allId + 1;
        return chara.allId;
    }


    public static int getNo(Chara chara, int no) {
        no = 1;
        for (int j = 0; j < chara.pets.size(); j++) {
            if (no < chara.pets.get(j).no) {
                no = chara.pets.get(j).no;
            }
        }
        return no + 1;
    }

    public static List<Vo_32747_0> a32747(List<JiNeng> jiNengs) {
        List<Vo_32747_0> vo_32747_0List = new ArrayList<>();
        for (JiNeng jiNeng : jiNengs) {
            Vo_32747_0 vo_32747_0 = new Vo_32747_0();
            vo_32747_0.id = jiNeng.id;
            vo_32747_0.skill_no = jiNeng.skill_no;
            vo_32747_0.skill_attrib = jiNeng.skill_attrib;
            vo_32747_0.skill_attrib1 = jiNeng.skill_attrib1;
            vo_32747_0.skill_level = jiNeng.skill_level;
            vo_32747_0.level_improved = jiNeng.level_improved;
            vo_32747_0.skill_mana_cost = jiNeng.skill_mana_cost;
            vo_32747_0.skill_nimbus = jiNeng.skill_nimbus;
            vo_32747_0.skill_disabled = jiNeng.skill_disabled;
            vo_32747_0.range = jiNeng.range;
            vo_32747_0.max_range = jiNeng.max_range;
            vo_32747_0.count1 = 0;
            vo_32747_0.s1 = jiNeng.s1;
            vo_32747_0.s2 = jiNeng.s2;
            vo_32747_0.isTempSkill = 0;
            vo_32747_0List.add(vo_32747_0);
        }
        return vo_32747_0List;
    }

    public static List<Vo_32747_0> a32747(Chara chara) {
        List<Vo_32747_0> vo_32747_0List = new ArrayList<>();
        for (JiNeng jiNeng : chara.jiNengList) {
            Vo_32747_0 vo_32747_0 = new Vo_32747_0();
            vo_32747_0.id = chara.id;
            vo_32747_0.skill_no = jiNeng.skill_no;
            vo_32747_0.skill_attrib = jiNeng.skill_attrib;
            vo_32747_0.skill_attrib1 = jiNeng.skill_attrib1;
            vo_32747_0.skill_level = jiNeng.skill_level;
            vo_32747_0.level_improved = jiNeng.level_improved;
            vo_32747_0.skill_mana_cost = jiNeng.skill_mana_cost;
            vo_32747_0.skill_nimbus = jiNeng.skill_nimbus;
            vo_32747_0.skill_disabled = jiNeng.skill_disabled;
            vo_32747_0.range = jiNeng.range;
            vo_32747_0.max_range = jiNeng.max_range;
            vo_32747_0.count1 = jiNeng.count1;
            vo_32747_0.s1 = jiNeng.s1;
            vo_32747_0.s2 = jiNeng.s2;
            vo_32747_0.isTempSkill = 0;
            vo_32747_0List.add(vo_32747_0);
        }
        return vo_32747_0List;
    }


    public static List<Vo_61545_0> a61545(Chara chara) {
        List<Vo_61545_0> vo_61545_0List = new ArrayList<>();
        Vo_61545_0 vo_61545_0 = new Vo_61545_0();
        vo_61545_0.groupBuf = "6";
        vo_61545_0.charBuf = chara.name;
        vo_61545_0.blocked = 0;
        vo_61545_0.online = 1;
        vo_61545_0.server_name1 = "剑影寒光22线";
        vo_61545_0.insider_level = 0;
        vo_61545_0.user_state = 0;
        vo_61545_0.auto_reply = 0;
        vo_61545_0.gid = "";
        vo_61545_0.placed_amount = 0;
        vo_61545_0.tao_effect = chara.waiguan;
        vo_61545_0.skill = chara.level;
        vo_61545_0.type = chara.waiguan;
        vo_61545_0.server_name = "剑影寒光22线";
        vo_61545_0.suit_icon = chara.weapon_icon;
        vo_61545_0.party_contrib = "";
        vo_61545_0.character_harmony = "";
        vo_61545_0.evolve_level = 0;
        vo_61545_0.nice = "";
        vo_61545_0.req_str = "";
        vo_61545_0.org_icon = 0;
        vo_61545_0.iid_str = chara.uuid;
        vo_61545_0.balance = chara.balance;
        vo_61545_0.arena_rank = 1;
        vo_61545_0List.add(vo_61545_0);

        return vo_61545_0List;
    }

    public static Vo_24505_0 a24505(Chara chara) {
        Vo_24505_0 vo_24505_0 = new Vo_24505_0();
        vo_24505_0.update_type = 2;
        vo_24505_0.groupBuf = "6";
        vo_24505_0.charBuf = chara.name;
        vo_24505_0.user_state = 0;
        vo_24505_0.auto_reply = 0;
        vo_24505_0.placed_amount = 0;
        vo_24505_0.gid = "";
        vo_24505_0.tao_effect = chara.waiguan;
        vo_24505_0.skill = chara.level;
        vo_24505_0.type = chara.waiguan;
        vo_24505_0.server_name = "涅槃重生22";
        vo_24505_0.suit_icon = chara.weapon_icon;
        vo_24505_0.party_contrib = "";
        vo_24505_0.character_harmony = "";
        vo_24505_0.evolve_level = 0;
        vo_24505_0.nice = "";
        vo_24505_0.req_str = "";
        vo_24505_0.org_icon = 0;
        vo_24505_0.iid_str = chara.uuid;
        vo_24505_0.balance = chara.balance;
        vo_24505_0.arena_rank = 1;

        return vo_24505_0;

    }

    public static void a20467(Chara chara, int id, String ask_type) {
        GameTeam gameTeam = new GameTeam();

        if (GameObjectCharMng.getGameObjectChar(id).gameTeam == null) {
            GameObjectCharMng.getGameObjectChar(id).creator(gameTeam);
        }

        GameObjectCharMng.getGameObjectChar(id).gameTeam.liebiao.add(GameObjectChar.getGameObjectChar().gameTeam.duiwu);
        Vo_20467_0 vo_20467_0 = new Vo_20467_0();
        vo_20467_0.caption = "";
        vo_20467_0.content = "";

        vo_20467_0.peer_name = chara.name;
        vo_20467_0.ask_type = "invite_join";
        vo_20467_0.org_icon = chara.waiguan;
        vo_20467_0.iid_str = chara.uuid;
        vo_20467_0.skill = chara.level;
        vo_20467_0.str = chara.name;
        vo_20467_0.master = chara.sex;
        vo_20467_0.metal = chara.menpai;
        vo_20467_0.req_str = "";
        vo_20467_0.passive_mode = chara.waiguan;

        vo_20467_0.party_contrib = "";
        vo_20467_0.teamMembersCount = 1;
        vo_20467_0.comeback_flag = 0;
        GameObjectCharMng.getGameObjectChar(id).sendOne(new M20467_0(), vo_20467_0);
    }

    public static Vo_4121_0 add4121(Chara chara, int memberteam_status) {
        Vo_4121_0 vo_4121_0 = new Vo_4121_0();
        vo_4121_0.id = chara.id;
        vo_4121_0.gid = chara.uuid;
        vo_4121_0.suit_icon = 0;
        vo_4121_0.weapon_icon = chara.weapon_icon;
        vo_4121_0.org_icon = chara.waiguan;
        vo_4121_0.skill = chara.level;
        vo_4121_0.str = chara.name;
        vo_4121_0.master = chara.sex;
        vo_4121_0.metal = chara.menpai;
        vo_4121_0.passive_mode = chara.waiguan;
        vo_4121_0.req_str = "";
        vo_4121_0.durability = 1;
        vo_4121_0.party_contrib = chara.chenhao;
        vo_4121_0.upgrade_level = 0;
        vo_4121_0.memberpos_x = chara.x;
        vo_4121_0.memberpos_y = chara.y;
        vo_4121_0.membermap_id = chara.mapid;
        vo_4121_0.memberteam_status = memberteam_status;
        vo_4121_0.membercard_name = "";
        vo_4121_0.membercomeback_flag = 0;
        vo_4121_0.memberlight_effect_count = 0;
        return vo_4121_0;
    }

    public static void a4121(List<Vo_4121_0> charaList) {
        List<Vo_4121_0> vo_4121_0List = new ArrayList<>();

        for (Vo_4121_0 vo41210 : charaList) {
            Vo_4121_0 vo_4121_0 = new Vo_4121_0();
            vo_4121_0.id = vo41210.id;
            vo_4121_0.gid = vo41210.gid;
            vo_4121_0.suit_icon = 0;
            vo_4121_0.weapon_icon = vo41210.weapon_icon;
            vo_4121_0.org_icon = vo41210.org_icon;
            vo_4121_0.skill = vo41210.skill;
            vo_4121_0.str = vo41210.str;
            vo_4121_0.master = vo41210.master;
            vo_4121_0.metal = vo41210.metal;
            vo_4121_0.passive_mode = vo41210.passive_mode;
            vo_4121_0.req_str = "";
            vo_4121_0.durability = 1;
            vo_4121_0.party_contrib = vo41210.party_contrib;
            vo_4121_0.upgrade_level = 0;
            vo_4121_0.memberpos_x = vo41210.memberpos_x;
            vo_4121_0.memberpos_y = vo41210.memberpos_y;
            vo_4121_0.membermap_id = vo41210.membermap_id;
            vo_4121_0.memberteam_status = vo41210.memberteam_status;
            vo_4121_0.membercard_name = "";
            vo_4121_0.membercomeback_flag = vo41210.membercomeback_flag;
            vo_4121_0.memberlight_effect_count = 0;
            vo_4121_0List.add(vo_4121_0);
        }
        for (Vo_4121_0 vo41210 : charaList) {
            GameObjectCharMng.getGameObjectChar(vo41210.id).sendOne(new M4121_0(), vo_4121_0List);
        }
    }

    public static void a4119(List<Chara> charaList) {

        List<Vo_4119_0> vo_4119_0List = new ArrayList<>();

        for (Chara chara : charaList) {
            Vo_4119_0 vo_4119_0 = new Vo_4119_0();
            vo_4119_0.id = chara.id;
            vo_4119_0.gid = chara.uuid;
            vo_4119_0.suit_icon = 0;
            vo_4119_0.weapon_icon = chara.weapon_icon;
            vo_4119_0.org_icon = chara.waiguan;
            vo_4119_0.skill = chara.level;
            vo_4119_0.str = chara.name;
            vo_4119_0.master = chara.sex;
            vo_4119_0.metal = chara.menpai;
            vo_4119_0.passive_mode = chara.waiguan;
            vo_4119_0.req_str = "";
            vo_4119_0.party_contrib = chara.chenhao;
            vo_4119_0.upgrade_level = 0;
            vo_4119_0.membercard_name = "";
            vo_4119_0.memberlight_effect_count = 0;
            vo_4119_0List.add(vo_4119_0);
        }
        List<Vo_45074_0> list = new ArrayList<>();
        Chara chara1 = charaList.get(0);
        for (int i = 0; i < chara1.listshouhu.size(); i++) {
            if (chara1.listshouhu.get(i).listShouHuShuXing.get(0).nil != 0) {
                Vo_45074_0 vo_45074_0 = new Vo_45074_0();
                vo_45074_0.guardName = chara1.listshouhu.get(i).listShouHuShuXing.get(0).str;
                vo_45074_0.guardLevel = chara1.level;
                vo_45074_0.guardIcon = chara1.listshouhu.get(i).listShouHuShuXing.get(0).type;
                vo_45074_0.guardOrder = chara1.listshouhu.get(i).listShouHuShuXing.get(0).salary;
                vo_45074_0.guardId = chara1.listshouhu.get(i).id;
                list.add(vo_45074_0);
            }
        }
        for (Chara chara : charaList) {
            GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M45074_0(), list);
            GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M4119_0(), vo_4119_0List);
        }

    }


    public static void huodecaifen(Chara chara, StoreInfo wupin, int owner_id, int leve, int value, String
            name, Goods goods, int add_pet_exp) {
        List<Goods> list = new ArrayList<>();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsDaoju(wupin);
        goods.goodsInfo.degree_32 = 0;
        goods.goodsInfo.owner_id = owner_id;
        goods.goodsInfo.damage_sel_rate = 400976;
        goods.goodsInfo.attrib = leve;
        goods.goodsInfo.skill = leve;
        goods.goodsInfo.total_score = 6;
        goods.goodsInfo.damage_sel_rate = 156945;
        goods.goodsInfo.auto_fight = UUID.randomUUID().toString();
        goods.goodsInfo.str = goods.goodsInfo.str + "·" + name;
        goods.goodsInfo.value = 8388608;
        goods.goodsInfo.damage_sel_rate = 156945;
        goods.goodsInfo.rebuild_level = 0;
        goods.goodsInfo.recognize_recognized = 274096;
        goods.goodsInfo.add_pet_exp = add_pet_exp;
        goods.goodsInfo.durability = 8;
        chara.backpack.add(goods);
        list.add(goods);
        GameObjectChar.send(new M65525_0(), list);
    }

    public static void removemunber(Chara chara, String str, int count) {
        List<Goods> list1 = new ArrayList<>();
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (str.equals(goods.goodsInfo.str)) {
                if (goods.goodsInfo.owner_id >= count) {
                    goods.goodsInfo.owner_id = goods.goodsInfo.owner_id - count;
                    count = 0;
                } else {
                    count -= goods.goodsInfo.owner_id;
                    goods.goodsInfo.owner_id = 0;
                }
                if (goods.goodsInfo.owner_id == 0) {
                    list1.add(goods);
                }
                List<Goods> list = new ArrayList<>();
                list.add(chara.backpack.get(i));
                GameObjectChar.send(new M65525_0(), list);
                if (count == 0) {
                    break;
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            chara.backpack.remove(list1.get(i));
            GameObjectChar.send(new M65525_0(), chara.backpack);
        }
    }

    public static void removemunber(Chara chara, Goods goods1, int count) {
        List<Goods> list1 = new ArrayList<>();
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods goods = chara.backpack.get(i);
            if (goods1 == goods) {
                if (goods.goodsInfo.owner_id >= count) {
                    goods.goodsInfo.owner_id = goods.goodsInfo.owner_id - count;
                    count = 0;
                } else {
                    count -= goods.goodsInfo.owner_id;
                    goods.goodsInfo.owner_id = 0;
                }
                if (goods.goodsInfo.owner_id == 0) {
                    list1.add(goods);
                }
                List<Goods> list = new ArrayList<>();
                list.add(chara.backpack.get(i));
                GameObjectChar.send(new M65525_0(), list);
                GameObjectChar.send(new M65525_0(), chara.backpack);
                if (count == 0) {
                    break;
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            chara.backpack.remove(list1.get(i));
            GameObjectChar.send(new M65525_0(), chara.backpack);
        }
    }


    public static void huodedaoju(Chara chara, StoreInfo wupin, int owner_id) {
        List<Goods> list = new ArrayList<>();
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsDaoju(wupin);
        goods.goodsInfo.owner_id = owner_id;
        goods.goodsInfo.damage_sel_rate = 400976;
        goods.goodsInfo.degree_32 = 1;
        GameUtil.addwupin(goods, chara);
    }

    public static void huodezhuangbei(Chara chara, ZhuangbeiInfo zhuangb, int degree_32, Goods goods) {
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = new GoodsLanSe();
        goods.goodsCreate(zhuangb);
        goods.goodsInfo.degree_32 = degree_32;
        chara.backpack.add(goods);

        GameObjectChar.send(new M65525_0(), chara.backpack);
    }

    public static void huodezhuangbei(Chara chara, ZhuangbeiInfo zhuangb, int degree_32, int owner_id, GoodsLanSe
            goodsLanSe) {
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = goodsLanSe;
        goods.goodsCreate(zhuangb);
        goods.goodsInfo.owner_id = owner_id;
        goods.goodsInfo.degree_32 = degree_32;
        chara.backpack.add(goods);

        GameObjectChar.send(new M65525_0(), chara.backpack);
    }


    public static void huodezhuangbeixiangwu(Chara chara, ZhuangbeiInfo zhuangb, int degree_32, int owner_id) {
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = new GoodsLanSe();
        goods.goodsCreate(zhuangb);
        goods.goodsInfo.owner_id = owner_id;
        goods.goodsInfo.degree_32 = degree_32;
        goods.goodsLanSe.all_resist_polar = 5;
        GameUtil.addwupin(goods, chara);
        GameObjectChar.send(new M65525_0(), chara.backpack);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "获得#R" + goods.goodsInfo.str + "";
        vo_20481_0.time = 1562987118;
        GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);
    }

    public static void huodezhuangbei(Chara chara, ZhuangbeiInfo zhuangb, int degree_32, int owner_id) {
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = new GoodsLanSe();
        goods.goodsCreate(zhuangb);
        goods.goodsInfo.owner_id = owner_id;
        goods.goodsInfo.degree_32 = degree_32;
        GameUtil.addwupin(goods, chara);
        GameObjectChar.send(new M65525_0(), chara.backpack);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "获得#R" + goods.goodsInfo.str + "";
        vo_20481_0.time = 1562987118;
        GameObjectChar.getGameObjectChar().send(new M20481_0(), vo_20481_0);
    }

    public static void huodezhuangbei(Chara chara, ZhuangbeiInfo zhuangb, int degree_32) {
        Goods goods = new Goods();
        goods.pos = GameUtil.beibaoweizhi(chara);
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = new GoodsLanSe();
        goods.goodsCreate(zhuangb);
        goods.goodsInfo.degree_32 = degree_32;
        chara.backpack.add(goods);

        GameObjectChar.send(new M65525_0(), chara.backpack);
    }

    public static int cangkuweizhi(Chara chara) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < chara.cangku.size(); i++) {
            map.put(chara.cangku.get(i).pos, chara.cangku.get(i).pos);
        }

        int size = 50;

        if (chara.vipType == 1 || chara.vipType == 2) {
            size += 25;
        }
        if (chara.vipType == 3) {
            size += 50;
        }
        int count = 201;
        for (int i = 0; i < size; i++) {
            if (map.get(count) == null) {
                return count;
            }
            count++;
        }
        return 0;
    }

    public static int beibaoweizhi(Chara chara) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < chara.backpack.size(); i++) {
            map.put(chara.backpack.get(i).pos, chara.backpack.get(i).pos);
        }
        int size = 50;
        if (chara.zuoqiwaiguan != 0) {
            size += 25;
        }
        if (chara.vipType == 1 || chara.vipType == 2) {
            size += 25;
        }
        if (chara.vipType == 3) {
            size += 50;
        }
        int count = 41;
        for (int i = 0; i < size; i++) {
            if (map.get(count) == null) {
                return count;
            }
            count++;
        }
        return 0;
    }



    public static void zhuangbeiValue(Chara chara) {
        chara.zbAttribute = new ZbAttribute();
        chara.zbAttribute.accurate = 0;
        chara.zbAttribute.def = 0;
        chara.zbAttribute.dex = 0;
        chara.zbAttribute.mana = 0;
        chara.zbAttribute.parry = 0;
        chara.zbAttribute.wiz = 0;
        int taozhuang = 0;
        int qianghua = 0;
        int dengji1 = 0;
        int dengji2 = 0;
        int dengji3 = 0;
        int dengji4 = 0;


        int tao1 = 0;
        int tao2 = 0;
        int tao3 = 0;
        int tao4 = 0;
        int color = 20;
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 1 || chara.backpack.get(i).pos == 2 || chara.backpack.get(i).pos == 3 || chara.backpack.get(i).pos == 10) {
                Map<Object, Object> map = UtilObjMapshuxing.GoodsLvSeGongMing(chara.backpack.get(i).goodsLvSeGongMing);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }

                if (map.size() >= 3) {

                    taozhuang++;
                }
                map = UtilObjMapshuxing.GoodsGaiZaoGongMing(chara.backpack.get(i).goodsGaiZaoGongMing);
                it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }

                if (map.size() >= 3) {
                    if (chara.backpack.get(i).goodsInfo.color < color) {
                        color = chara.backpack.get(i).goodsInfo.color;
                    }
                    qianghua++;
                }
                if (chara.backpack.get(i).pos == 1) {
                    dengji1 = chara.backpack.get(i).goodsInfo.attrib;
                    tao1 = chara.backpack.get(i).goodsInfo.suit_enabled;
                }
                if (chara.backpack.get(i).pos == 2) {
                    dengji2 = chara.backpack.get(i).goodsInfo.attrib;
                    tao2 = chara.backpack.get(i).goodsInfo.suit_enabled;
                }
                if (chara.backpack.get(i).pos == 3) {
                    dengji3 = chara.backpack.get(i).goodsInfo.attrib;
                    tao3 = chara.backpack.get(i).goodsInfo.suit_enabled;
                }
                if (chara.backpack.get(i).pos == 10) {
                    dengji4 = chara.backpack.get(i).goodsInfo.attrib;
                    tao4 = chara.backpack.get(i).goodsInfo.suit_enabled;
                }
            }
        }

        if (taozhuang == 4 && dengji1 == dengji2 && dengji2 == dengji3 && dengji3 == dengji4 && tao1 == tao2 && tao2 == tao3 && tao3 == tao4) {
            int[] suit = SuitEffectUtils.suit(chara.sex - 1, dengji4, chara.menpai, tao1);
            chara.suit_icon = suit[0];
            chara.suit_light_effect = suit[1];
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == 1 || chara.backpack.get(i).pos == 2 || chara.backpack.get(i).pos == 3 || chara.backpack.get(i).pos == 10) {
                    chara.backpack.get(i).goodsInfo.gift = 1;
                }
            }
        } else {
            chara.suit_icon = 0;
            chara.suit_light_effect = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == 1 || chara.backpack.get(i).pos == 2 || chara.backpack.get(i).pos == 3 || chara.backpack.get(i).pos == 10) {
                    chara.backpack.get(i).goodsInfo.gift = 0;
                }
            }
        }
        if (qianghua == 4 && dengji1 == dengji2 && dengji2 == dengji3 && dengji3 == dengji4) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (chara.backpack.get(i).pos == 1 || chara.backpack.get(i).pos == 2 || chara.backpack.get(i).pos == 3 || chara.backpack.get(i).pos == 10) {
                    Map<Object, Object> map = UtilObjMapshuxing.GoodsGaiZaoGongMing(chara.backpack.get(i).goodsGaiZaoGongMing);
                    chara.backpack.get(i).goodsGaiZaoGongMingChengGong = (GoodsGaiZaoGongMingChengGong) JSONUtils.parseObject(JSONUtils.toJSONString(map), GoodsGaiZaoGongMingChengGong.class);
                    chara.backpack.get(i).goodsGaiZaoGongMingChengGong.groupNo = 29;
                    chara.backpack.get(i).goodsGaiZaoGongMingChengGong.color = color;
                }
            }
        } else {
            for (int i = 0; i < chara.backpack.size(); i++) {
                chara.backpack.get(i).goodsGaiZaoGongMingChengGong = new GoodsGaiZaoGongMingChengGong();
            }
        }
        GameObjectChar.send(new M65525_0(), chara.backpack);
        for (int i = 0; i < chara.backpack.size(); i++) {
            Goods good = chara.backpack.get(i);
            if (good.goodsFenSe != null) {

                Map<Object, Object> goodsfense = UtilObjMapshuxing.GoodsFenSe(good.goodsFenSe);
                for (Map.Entry<Object, Object> entry : goodsfense.entrySet()) {
                    if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                        continue;
                    }
                    if ((Integer) entry.getValue() != 0) {
                        good.goodsInfo.quality = "粉色";
                    }
                }
            }
            if (good.goodsHuangSe != null) {
                Map<Object, Object> goodshuangse = UtilObjMapshuxing.GoodsHuangSe(good.goodsHuangSe);
                for (Map.Entry<Object, Object> entry : goodshuangse.entrySet()) {
                    if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                        continue;
                    }
                    if ((Integer) entry.getValue() != 0) {
                        good.goodsInfo.quality = "金色";
                    }
                }
            }

            if (good.goodsLvSe != null) {
                Map<Object, Object> goodslvse = UtilObjMapshuxing.GoodsLvSe(good.goodsLvSe);
                for (Map.Entry<Object, Object> entry : goodslvse.entrySet()) {
                    if (entry.getKey().equals("groupNo") || entry.getKey().equals("groupType")) {
                        continue;
                    }
                    if ((Integer) entry.getValue() != 0) {
                        good.goodsInfo.quality = "绿色";
                    }
                }
            }
            if (good.pos <= 10 && good.pos > 0) {
                chara.zbAttribute.accurate += good.goodsBasics.accurate;
                chara.zbAttribute.def += good.goodsBasics.def;
                chara.zbAttribute.dex += good.goodsBasics.dex;
                chara.zbAttribute.mana += good.goodsBasics.mana;
                chara.zbAttribute.parry += good.goodsBasics.parry;
                chara.zbAttribute.wiz += good.goodsBasics.wiz;

                chara.zbAttribute.phy_power = chara.zbAttribute.phy_power + good.goodsLanSe.phy_power + good.goodsLanSe.all_polar;
                
                chara.zbAttribute.mag_power = chara.zbAttribute.mag_power + good.goodsLanSe.mag_power + good.goodsLanSe.all_polar;
                
                chara.zbAttribute.speed = chara.zbAttribute.speed + good.goodsLanSe.speed + good.goodsLanSe.all_polar;
                
                chara.zbAttribute.life = chara.zbAttribute.life + good.goodsLanSe.life + good.goodsLanSe.all_polar;
                
                chara.zbAttribute.skill_low_cost += good.goodsLanSe.skill_low_cost;
                
                chara.zbAttribute.mstunt_rate += good.goodsLanSe.mstunt_rate;
                
                chara.zbAttribute.wood = chara.zbAttribute.wood + good.goodsLanSe.wood + good.goodsLanSe.all_resist_polar;
                
                chara.zbAttribute.water = chara.zbAttribute.water + good.goodsLanSe.water + good.goodsLanSe.all_resist_polar;
                
                chara.zbAttribute.fire = chara.zbAttribute.fire + good.goodsLanSe.fire + good.goodsLanSe.all_resist_polar;
                
                chara.zbAttribute.earth = chara.zbAttribute.earth + good.goodsLanSe.earth + good.goodsLanSe.all_resist_polar;
                
                chara.zbAttribute.resist_metal = chara.zbAttribute.resist_metal + good.goodsLanSe.resist_metal + good.goodsLanSe.all_resist_polar;


                
                chara.zbAttribute.damage_sel += good.goodsLanSe.damage_sel;
                
                chara.zbAttribute.stunt_rate += good.goodsLanSe.stunt_rate;
                
                chara.zbAttribute.double_hit_rate += good.goodsLanSe.double_hit_rate;
                
                chara.zbAttribute.release_forgotten += good.goodsLanSe.release_forgotten;
                
                chara.zbAttribute.ignore_all_resist_except += good.goodsLanSe.ignore_all_resist_except;
                
                chara.zbAttribute.stunt += good.goodsLanSe.stunt;
                
                chara.zbAttribute.def += good.goodsLanSe.def;
                
                chara.zbAttribute.dex += good.goodsLanSe.dex;
                
                chara.zbAttribute.wiz += good.goodsLanSe.wiz;
                
                chara.zbAttribute.family += good.goodsLanSe.family;
                
                chara.zbAttribute.life_recover += good.goodsLanSe.life_recover;
                
                chara.zbAttribute.all_skill += good.goodsLanSe.all_skill;
                
                chara.zbAttribute.portrait += good.goodsLanSe.portrait;
                
                chara.zbAttribute.resist_frozen += good.goodsLanSe.resist_frozen;
                
                chara.zbAttribute.resist_sleep += good.goodsLanSe.resist_sleep;
                
                chara.zbAttribute.resist_forgotten += good.goodsLanSe.resist_forgotten;
                
                chara.zbAttribute.resist_confusion += good.goodsLanSe.resist_confusion;
                
                chara.zbAttribute.longevity += good.goodsLanSe.longevity;
                
                chara.zbAttribute.resist_wood += good.goodsLanSe.resist_wood;
                
                chara.zbAttribute.resist_water += good.goodsLanSe.resist_water;
                
                chara.zbAttribute.resist_fire += good.goodsLanSe.resist_fire;
                
                chara.zbAttribute.resist_earth += good.goodsLanSe.resist_earth;
                
                chara.zbAttribute.exp_to_next_level += good.goodsLanSe.exp_to_next_level;
                
                chara.zbAttribute.all_resist_except += good.goodsLanSe.all_resist_except;
                
                chara.zbAttribute.accurate += good.goodsLanSe.accurate;

                chara.zbAttribute.mana += good.goodsLanSe.mana;

                chara.zbAttribute.parry += good.goodsLanSe.parry;


                chara.zbAttribute.ignore_resist_wood += good.goodsLanSe.ignore_resist_wood;
                
                chara.zbAttribute.ignore_resist_water += good.goodsLanSe.ignore_resist_water;
                
                chara.zbAttribute.ignore_resist_fire += good.goodsLanSe.ignore_resist_fire;
                
                chara.zbAttribute.ignore_resist_earth += good.goodsLanSe.ignore_resist_earth;
                
                chara.zbAttribute.ignore_resist_forgotten += good.goodsLanSe.ignore_resist_forgotten;
                
                chara.zbAttribute.ignore_resist_frozen += good.goodsLanSe.ignore_resist_frozen;
                
                chara.zbAttribute.ignore_resist_sleep += good.goodsLanSe.ignore_resist_sleep;
                
                chara.zbAttribute.ignore_resist_confusion += good.goodsLanSe.ignore_resist_confusion;
                
                chara.zbAttribute.super_excluse_metal += good.goodsLanSe.super_excluse_metal;
                
                chara.zbAttribute.ignore_resist_poison += good.goodsLanSe.ignore_resist_poison;


                
                chara.zbAttribute.phy_power = chara.zbAttribute.phy_power + good.goodsHuangSe.phy_power + good.goodsHuangSe.all_polar;
                
                chara.zbAttribute.mag_power = chara.zbAttribute.mag_power + good.goodsHuangSe.mag_power + good.goodsHuangSe.all_polar;
                
                chara.zbAttribute.speed = chara.zbAttribute.speed + good.goodsHuangSe.speed + good.goodsHuangSe.all_polar;
                
                chara.zbAttribute.life = chara.zbAttribute.life + good.goodsHuangSe.life + good.goodsHuangSe.all_polar;
                
                chara.zbAttribute.skill_low_cost += good.goodsHuangSe.skill_low_cost;
                
                chara.zbAttribute.mstunt_rate += good.goodsHuangSe.mstunt_rate;
                
                chara.zbAttribute.wood = chara.zbAttribute.wood + good.goodsHuangSe.wood + good.goodsHuangSe.all_resist_polar;
                
                chara.zbAttribute.water = chara.zbAttribute.water + good.goodsHuangSe.water + good.goodsHuangSe.all_resist_polar;
                
                chara.zbAttribute.fire = chara.zbAttribute.fire + good.goodsHuangSe.fire + good.goodsHuangSe.all_resist_polar;
                
                chara.zbAttribute.earth = chara.zbAttribute.earth + good.goodsHuangSe.earth + good.goodsHuangSe.all_resist_polar;
                
                chara.zbAttribute.resist_metal = chara.zbAttribute.resist_metal + good.goodsHuangSe.resist_metal + good.goodsHuangSe.all_resist_polar;


                
                chara.zbAttribute.damage_sel += good.goodsHuangSe.damage_sel;
                
                chara.zbAttribute.stunt_rate += good.goodsHuangSe.stunt_rate;
                
                chara.zbAttribute.double_hit_rate += good.goodsHuangSe.double_hit_rate;
                
                chara.zbAttribute.release_forgotten += good.goodsHuangSe.release_forgotten;
                
                chara.zbAttribute.ignore_all_resist_except += good.goodsHuangSe.ignore_all_resist_except;
                
                chara.zbAttribute.stunt += good.goodsHuangSe.stunt;
                
                chara.zbAttribute.def += good.goodsHuangSe.def;
                
                chara.zbAttribute.dex += good.goodsHuangSe.dex;
                
                chara.zbAttribute.wiz += good.goodsHuangSe.wiz;
                
                chara.zbAttribute.family += good.goodsHuangSe.family;
                
                chara.zbAttribute.life_recover += good.goodsHuangSe.life_recover;
                
                chara.zbAttribute.all_skill += good.goodsHuangSe.all_skill;
                
                chara.zbAttribute.portrait += good.goodsHuangSe.portrait;
                
                chara.zbAttribute.resist_frozen += good.goodsHuangSe.resist_frozen;
                
                chara.zbAttribute.resist_sleep += good.goodsHuangSe.resist_sleep;
                
                chara.zbAttribute.resist_forgotten += good.goodsHuangSe.resist_forgotten;
                
                chara.zbAttribute.resist_confusion += good.goodsHuangSe.resist_confusion;
                
                chara.zbAttribute.longevity += good.goodsHuangSe.longevity;
                
                chara.zbAttribute.resist_wood += good.goodsHuangSe.resist_wood;
                
                chara.zbAttribute.resist_water += good.goodsHuangSe.resist_water;
                
                chara.zbAttribute.resist_fire += good.goodsHuangSe.resist_fire;
                
                chara.zbAttribute.resist_earth += good.goodsHuangSe.resist_earth;
                
                chara.zbAttribute.exp_to_next_level += good.goodsHuangSe.exp_to_next_level;
                
                chara.zbAttribute.all_resist_except += good.goodsHuangSe.all_resist_except;
                
                chara.zbAttribute.accurate += good.goodsHuangSe.accurate;

                chara.zbAttribute.mana += good.goodsHuangSe.mana;

                chara.zbAttribute.parry += good.goodsHuangSe.parry;


                chara.zbAttribute.ignore_resist_wood += good.goodsHuangSe.ignore_resist_wood;
                
                chara.zbAttribute.ignore_resist_water += good.goodsHuangSe.ignore_resist_water;
                
                chara.zbAttribute.ignore_resist_fire += good.goodsHuangSe.ignore_resist_fire;
                
                chara.zbAttribute.ignore_resist_earth += good.goodsHuangSe.ignore_resist_earth;
                
                chara.zbAttribute.ignore_resist_forgotten += good.goodsHuangSe.ignore_resist_forgotten;
                
                chara.zbAttribute.ignore_resist_frozen += good.goodsHuangSe.ignore_resist_frozen;
                
                chara.zbAttribute.ignore_resist_sleep += good.goodsHuangSe.ignore_resist_sleep;
                
                chara.zbAttribute.ignore_resist_confusion += good.goodsHuangSe.ignore_resist_confusion;
                
                chara.zbAttribute.super_excluse_metal += good.goodsHuangSe.super_excluse_metal;
                
                chara.zbAttribute.ignore_resist_poison += good.goodsHuangSe.ignore_resist_poison;


                
                chara.zbAttribute.phy_power = chara.zbAttribute.phy_power + good.goodsFenSe.phy_power + good.goodsFenSe.all_polar;
                
                chara.zbAttribute.mag_power = chara.zbAttribute.mag_power + good.goodsFenSe.mag_power + good.goodsFenSe.all_polar;
                
                chara.zbAttribute.speed = chara.zbAttribute.speed + good.goodsFenSe.speed + good.goodsFenSe.all_polar;
                
                chara.zbAttribute.life = chara.zbAttribute.life + good.goodsFenSe.life + good.goodsFenSe.all_polar;
                
                chara.zbAttribute.skill_low_cost += good.goodsFenSe.skill_low_cost;
                
                chara.zbAttribute.mstunt_rate += good.goodsFenSe.mstunt_rate;
                
                chara.zbAttribute.wood = chara.zbAttribute.wood + good.goodsFenSe.wood + good.goodsFenSe.all_resist_polar;
                
                chara.zbAttribute.water = chara.zbAttribute.water + good.goodsFenSe.water + good.goodsFenSe.all_resist_polar;
                
                chara.zbAttribute.fire = chara.zbAttribute.fire + good.goodsFenSe.fire + good.goodsFenSe.all_resist_polar;
                
                chara.zbAttribute.earth = chara.zbAttribute.earth + good.goodsFenSe.earth + good.goodsFenSe.all_resist_polar;
                
                chara.zbAttribute.resist_metal = chara.zbAttribute.resist_metal + good.goodsFenSe.resist_metal + good.goodsFenSe.all_resist_polar;


                
                chara.zbAttribute.damage_sel += good.goodsFenSe.damage_sel;
                
                chara.zbAttribute.stunt_rate += good.goodsFenSe.stunt_rate;
                
                chara.zbAttribute.double_hit_rate += good.goodsFenSe.double_hit_rate;
                
                chara.zbAttribute.release_forgotten += good.goodsFenSe.release_forgotten;
                
                chara.zbAttribute.ignore_all_resist_except += good.goodsFenSe.ignore_all_resist_except;
                
                chara.zbAttribute.stunt += good.goodsFenSe.stunt;
                
                chara.zbAttribute.def += good.goodsFenSe.def;
                
                chara.zbAttribute.dex += good.goodsFenSe.dex;
                
                chara.zbAttribute.wiz += good.goodsFenSe.wiz;
                
                chara.zbAttribute.family += good.goodsFenSe.family;
                
                chara.zbAttribute.life_recover += good.goodsFenSe.life_recover;
                
                chara.zbAttribute.all_skill += good.goodsFenSe.all_skill;
                
                chara.zbAttribute.portrait += good.goodsFenSe.portrait;
                
                chara.zbAttribute.resist_frozen += good.goodsFenSe.resist_frozen;
                
                chara.zbAttribute.resist_sleep += good.goodsFenSe.resist_sleep;
                
                chara.zbAttribute.resist_forgotten += good.goodsFenSe.resist_forgotten;
                
                chara.zbAttribute.resist_confusion += good.goodsFenSe.resist_confusion;
                
                chara.zbAttribute.longevity += good.goodsFenSe.longevity;
                
                chara.zbAttribute.resist_wood += good.goodsFenSe.resist_wood;
                
                chara.zbAttribute.resist_water += good.goodsFenSe.resist_water;
                
                chara.zbAttribute.resist_fire += good.goodsFenSe.resist_fire;
                
                chara.zbAttribute.resist_earth += good.goodsFenSe.resist_earth;
                
                chara.zbAttribute.exp_to_next_level += good.goodsFenSe.exp_to_next_level;
                
                chara.zbAttribute.all_resist_except += good.goodsFenSe.all_resist_except;
                
                chara.zbAttribute.accurate += good.goodsFenSe.accurate;

                chara.zbAttribute.mana += good.goodsFenSe.mana;

                chara.zbAttribute.parry += good.goodsFenSe.parry;


                chara.zbAttribute.ignore_resist_wood += good.goodsFenSe.ignore_resist_wood;
                
                chara.zbAttribute.ignore_resist_water += good.goodsFenSe.ignore_resist_water;
                
                chara.zbAttribute.ignore_resist_fire += good.goodsFenSe.ignore_resist_fire;
                
                chara.zbAttribute.ignore_resist_earth += good.goodsFenSe.ignore_resist_earth;
                
                chara.zbAttribute.ignore_resist_forgotten += good.goodsFenSe.ignore_resist_forgotten;
                
                chara.zbAttribute.ignore_resist_frozen += good.goodsFenSe.ignore_resist_frozen;
                
                chara.zbAttribute.ignore_resist_sleep += good.goodsFenSe.ignore_resist_sleep;
                
                chara.zbAttribute.ignore_resist_confusion += good.goodsFenSe.ignore_resist_confusion;
                
                chara.zbAttribute.super_excluse_metal += good.goodsFenSe.super_excluse_metal;
                
                chara.zbAttribute.ignore_resist_poison += good.goodsFenSe.ignore_resist_poison;


                
                chara.zbAttribute.accurate += good.goodsLvSe.accurate;
                
                chara.zbAttribute.resist_frozen += good.goodsLvSe.resist_frozen;
                
                chara.zbAttribute.resist_sleep += good.goodsLvSe.resist_sleep;
                
                chara.zbAttribute.resist_forgotten += good.goodsLvSe.resist_forgotten;
                
                chara.zbAttribute.resist_confusion += good.goodsLvSe.resist_confusion;
                
                chara.zbAttribute.longevity += good.goodsLvSe.longevity;
                chara.zbAttribute.super_excluse_wood += good.goodsLvSe.super_excluse_wood;
                
                chara.zbAttribute.super_excluse_water += good.goodsLvSe.super_excluse_water;
                
                chara.zbAttribute.super_excluse_fire += good.goodsLvSe.super_excluse_fire;
                
                chara.zbAttribute.super_excluse_earth += good.goodsLvSe.super_excluse_earth;
                
                chara.zbAttribute.B_skill_low_cost += good.goodsLvSe.B_skill_low_cost;
                
                chara.zbAttribute.enhanced_wood += good.goodsLvSe.enhanced_wood;
                
                chara.zbAttribute.enhanced_water += good.goodsLvSe.enhanced_water;
                
                chara.zbAttribute.enhanced_fire += good.goodsLvSe.enhanced_fire;
                
                chara.zbAttribute.enhanced_earth += good.goodsLvSe.enhanced_earth;
                
                chara.zbAttribute.mag_dodge += good.goodsLvSe.mag_dodge;
                
                chara.zbAttribute.ignore_mag_dodge += good.goodsLvSe.ignore_mag_dodge;
                
                chara.zbAttribute.jinguang_zhaxian_counter_att_rate += good.goodsLvSe.jinguang_zhaxian_counter_att_rate;
                
                chara.zbAttribute.C_skill_low_cost += good.goodsLvSe.C_skill_low_cost;
                
                chara.zbAttribute.D_skill_low_cost += good.goodsLvSe.D_skill_low_cost;
                
                chara.zbAttribute.super_poison += good.goodsLvSe.super_poison;
                
                chara.zbAttribute.ignore_resist_wood += good.goodsLvSe.ignore_resist_wood;
                
                chara.zbAttribute.ignore_resist_water += good.goodsLvSe.ignore_resist_water;
                
                chara.zbAttribute.ignore_resist_fire += good.goodsLvSe.ignore_resist_fire;
                
                chara.zbAttribute.ignore_resist_earth += good.goodsLvSe.ignore_resist_earth;
                
                chara.zbAttribute.ignore_resist_forgotten += good.goodsLvSe.ignore_resist_forgotten;
                
                chara.zbAttribute.release_forgotten += good.goodsLvSe.release_forgotten;
                
                chara.zbAttribute.ignore_all_resist_except += good.goodsLvSe.ignore_all_resist_except;
                
                chara.zbAttribute.super_confusion += good.goodsLvSe.super_confusion;
                
                chara.zbAttribute.super_sleep += good.goodsLvSe.super_sleep;
                
                chara.zbAttribute.enhanced_metal += good.goodsLvSe.enhanced_metal;
                
                chara.zbAttribute.super_forgotten += good.goodsLvSe.super_forgotten;
                chara.zbAttribute.super_frozen += good.goodsLvSe.super_frozen;
                
                chara.zbAttribute.ignore_resist_frozen += good.goodsLvSe.ignore_resist_frozen;
                
                chara.zbAttribute.ignore_resist_sleep += good.goodsLvSe.ignore_resist_sleep;
                
                chara.zbAttribute.ignore_resist_confusion += good.goodsLvSe.ignore_resist_confusion;
                
                chara.zbAttribute.super_excluse_metal += good.goodsLvSe.super_excluse_metal;
                
                chara.zbAttribute.ignore_resist_poison += good.goodsLvSe.ignore_resist_poison;
                
                chara.zbAttribute.tao_ex += good.goodsLvSe.tao_ex;
                
                chara.zbAttribute.release_confusion += good.goodsLvSe.release_confusion;
                chara.zbAttribute.release_sleep += good.goodsLvSe.release_sleep;
                
                chara.zbAttribute.release_frozen += good.goodsLvSe.release_frozen;
                
                chara.zbAttribute.release_poison += good.goodsLvSe.release_poison;

                
                
                chara.zbAttribute.accurate += good.goodsGaiZao.accurate;
                
                chara.zbAttribute.wiz += good.goodsGaiZao.wiz;
                
                chara.zbAttribute.def += good.goodsGaiZao.def;
                
                chara.zbAttribute.mana += good.goodsGaiZao.mana;


                chara.zbAttribute.phy_power = chara.zbAttribute.phy_power + good.goodsGaiZao.all_polar;
                
                chara.zbAttribute.mag_power = chara.zbAttribute.mag_power + good.goodsGaiZao.all_polar;
                
                chara.zbAttribute.speed = chara.zbAttribute.speed + good.goodsGaiZao.all_polar;
                
                chara.zbAttribute.life = chara.zbAttribute.life + good.goodsGaiZao.all_polar;



                
                chara.zbAttribute.damage_sel += good.goodsGaiZaoGongMingChengGong.damage_sel;
                
                chara.zbAttribute.accurate += good.goodsGaiZaoGongMingChengGong.accurate;
                
                chara.zbAttribute.mana += good.goodsGaiZaoGongMingChengGong.mana;
                
                chara.zbAttribute.def += good.goodsGaiZaoGongMingChengGong.def;
                
                chara.zbAttribute.wiz += good.goodsGaiZaoGongMingChengGong.wiz;
                
                chara.zbAttribute.parry += good.goodsGaiZaoGongMingChengGong.parry;
                
                chara.zbAttribute.phy_power += good.goodsGaiZaoGongMingChengGong.phy_power;
                
                chara.zbAttribute.mag_power += good.goodsGaiZaoGongMingChengGong.mag_power;
                
                chara.zbAttribute.speed += good.goodsGaiZaoGongMingChengGong.speed;
                
                chara.zbAttribute.life += good.goodsGaiZaoGongMingChengGong.life;
                
                chara.zbAttribute.resist_frozen += good.goodsGaiZaoGongMingChengGong.resist_frozen;
                
                chara.zbAttribute.resist_sleep += good.goodsGaiZaoGongMingChengGong.resist_sleep;
                
                chara.zbAttribute.resist_forgotten += good.goodsGaiZaoGongMingChengGong.resist_forgotten;
                
                chara.zbAttribute.resist_confusion += good.goodsGaiZaoGongMingChengGong.resist_confusion;
                
                chara.zbAttribute.longevity += good.goodsGaiZaoGongMingChengGong.longevity;
                
                chara.zbAttribute.resist_wood += good.goodsGaiZaoGongMingChengGong.resist_wood;
                
                chara.zbAttribute.resist_water += good.goodsGaiZaoGongMingChengGong.resist_water;
                
                chara.zbAttribute.resist_fire += good.goodsGaiZaoGongMingChengGong.resist_fire;
                
                chara.zbAttribute.resist_earth += good.goodsGaiZaoGongMingChengGong.resist_earth;
                
                chara.zbAttribute.exp_to_next_level += good.goodsGaiZaoGongMingChengGong.exp_to_next_level;
                
                chara.zbAttribute.mstunt_rate += good.goodsGaiZaoGongMingChengGong.mstunt_rate;
                
                chara.zbAttribute.stunt_rate += good.goodsGaiZaoGongMingChengGong.stunt_rate;
                
                chara.zbAttribute.double_hit_rate += good.goodsGaiZaoGongMingChengGong.double_hit_rate;
                
                chara.zbAttribute.super_excluse_wood += good.goodsGaiZaoGongMingChengGong.super_excluse_wood;
                
                chara.zbAttribute.super_excluse_water += good.goodsGaiZaoGongMingChengGong.super_excluse_water;
                
                chara.zbAttribute.super_excluse_fire += good.goodsGaiZaoGongMingChengGong.super_excluse_fire;
                
                chara.zbAttribute.super_excluse_earth += good.goodsGaiZaoGongMingChengGong.super_excluse_earth;
                
                chara.zbAttribute.B_skill_low_cost += good.goodsGaiZaoGongMingChengGong.B_skill_low_cost;
                
                chara.zbAttribute.life_recover += good.goodsGaiZaoGongMingChengGong.life_recover;
                
                chara.zbAttribute.family += good.goodsGaiZaoGongMingChengGong.family;
                
                chara.zbAttribute.portrait += good.goodsGaiZaoGongMingChengGong.portrait;
                
                chara.zbAttribute.tao_ex += good.goodsGaiZaoGongMingChengGong.tao_ex;
                
                chara.zbAttribute.release_confusion += good.goodsGaiZaoGongMingChengGong.release_confusion;
                
                chara.zbAttribute.release_sleep += good.goodsGaiZaoGongMingChengGong.release_sleep;
                
                chara.zbAttribute.release_frozen += good.goodsGaiZaoGongMingChengGong.release_frozen;
                
                chara.zbAttribute.release_poison += good.goodsGaiZaoGongMingChengGong.release_poison;
                
                chara.zbAttribute.C_skill_low_cost += good.goodsGaiZaoGongMingChengGong.C_skill_low_cost;
                
                chara.zbAttribute.D_skill_low_cost += good.goodsGaiZaoGongMingChengGong.D_skill_low_cost;
                
                chara.zbAttribute.super_poison += good.goodsGaiZaoGongMingChengGong.super_poison;


                
                if (chara.suit_icon != 0) {
                    
                    chara.zbAttribute.mana += good.goodsLvSeGongMing.mana;
                    
                    chara.zbAttribute.def += good.goodsLvSeGongMing.def;
                    
                    chara.zbAttribute.wiz += good.goodsLvSeGongMing.wiz;
                    
                    chara.zbAttribute.parry += good.goodsLvSeGongMing.parry;
                    
                    chara.zbAttribute.accurate += good.goodsLvSeGongMing.accurate;
                }
            }

        }

        for (int i = 0; i < chara.pets.size(); i++) {
            if (chara.pets.get(i).id == chara.zuoqiId) {
                for (int j = 0; j < chara.pets.get(i).petShuXing.size(); j++) {
                    if (chara.pets.get(i).petShuXing.get(j).no == 23) {
                        chara.zbAttribute.mana += chara.pets.get(i).petShuXing.get(j).mana;
                        chara.zbAttribute.accurate += chara.pets.get(i).petShuXing.get(j).accurate;
                        chara.zbAttribute.wiz += chara.pets.get(i).petShuXing.get(j).wiz;
                    }
                }
            }
        }
        for (int i = 0; i < chara.jiNengList.size(); i++) {
            if (chara.jiNengList.get(i).skill_no == 301) {
                chara.zbAttribute.def = chara.zbAttribute.def + (int) ((chara.zbAttribute.def + chara.def) * 0.01 * chara.jiNengList.get(i).skill_level);

            }
            if (chara.jiNengList.get(i).skill_no == 302) {
                chara.zbAttribute.dex = chara.zbAttribute.dex + (int) ((chara.zbAttribute.dex + chara.dex) * 0.01 * chara.jiNengList.get(i).skill_level);
            }
        }


        for (int i = 0; i < chara.backpack.size(); i++) {
            if (chara.backpack.get(i).pos == 9) {
                Goods goods = chara.backpack.get(i);
                if (goods.goodsInfo.shuadao_ziqihongmeng == 4) {
                    chara.zbAttribute.parry = chara.zbAttribute.parry + (int) ((chara.zbAttribute.parry + chara.parry) * 0.015);
                }
                if (goods.goodsInfo.shuadao_ziqihongmeng == 1) {
                    chara.zbAttribute.mana = chara.zbAttribute.mana + (int) ((chara.zbAttribute.mana + chara.mana) * 0.015);
                }
                if (goods.goodsInfo.shuadao_ziqihongmeng == 2) {
                    chara.zbAttribute.def = chara.zbAttribute.def + (int) ((chara.zbAttribute.def + chara.def) * 0.025);
                    chara.zbAttribute.dex = chara.zbAttribute.dex + (int) ((chara.zbAttribute.dex + chara.dex) * 0.025);
                }
                if (goods.goodsInfo.shuadao_ziqihongmeng == 3) {
                    chara.zbAttribute.wiz = chara.zbAttribute.wiz + (int) ((chara.zbAttribute.wiz + chara.wiz) * 0.03);
                }
                if (goods.goodsInfo.shuadao_ziqihongmeng == 5) {
                    chara.zbAttribute.accurate = chara.zbAttribute.accurate + (int) ((chara.zbAttribute.accurate + chara.accurate) * 0.015);
                }

            }
        }

    }

    
    public static Vo_16383_0 a16383(Chara chara, String msg, int channel, Chara chara1) {
        Vo_16383_0 vo_16383_0 = new Vo_16383_0();
        vo_16383_0.channel = channel;
        vo_16383_0.id = chara.id;
        vo_16383_0.name = chara.name;
        vo_16383_0.msg = msg;
        long times = System.currentTimeMillis() / 1000;
        vo_16383_0.time = (int) times;
        vo_16383_0.privilege = 0;
        vo_16383_0.server_name = "涅槃重生22";
        vo_16383_0.show_extra = 2;
        vo_16383_0.compress = 0;
        vo_16383_0.orgLength = 65535;
        vo_16383_0.cardCount = 0;
        vo_16383_0.voiceTime = 0;
        vo_16383_0.token = "";
        vo_16383_0.checksum = 0;
        vo_16383_0.iid_str = chara.uuid;
        vo_16383_0.has_break_lv_limit = 0;
        vo_16383_0.skill = chara.level;
        vo_16383_0.type = chara.waiguan;
        vo_16383_0.suit_level = chara1.uuid;
        return vo_16383_0;
    }

    public static Vo_16383_0 a16383(Chara chara, String msg, int channel) {
        Vo_16383_0 vo_16383_0 = new Vo_16383_0();
        vo_16383_0.channel = channel;
        vo_16383_0.id = chara.id;
        vo_16383_0.name = chara.name;
        vo_16383_0.msg = msg;
        long times = System.currentTimeMillis() / 1000;
        int time = (int) (times);
        vo_16383_0.time = time;
        vo_16383_0.privilege = 0;
        
        vo_16383_0.server_name = "涅槃重生22";
        vo_16383_0.show_extra = 0;
        vo_16383_0.compress = 0;
        vo_16383_0.orgLength = 65535;
        vo_16383_0.cardCount = 0;
        vo_16383_0.voiceTime = 0;
        vo_16383_0.token = "";
        vo_16383_0.checksum = 0;
        vo_16383_0.iid_str = chara.uuid;
        vo_16383_0.has_break_lv_limit = 0;
        vo_16383_0.skill = chara.level;
        vo_16383_0.type = chara.waiguan;
        return vo_16383_0;
    }

    
    public static Vo_45056_0 a45056(Chara chara) {
        Vo_45056_0 vo_45056_0 = new Vo_45056_0();
        vo_45056_0.id = chara.id;
        vo_45056_0.name = chara.name;
        vo_45056_0.portrait = chara.waiguan;
        vo_45056_0.pic_no = 0;
        vo_45056_0.content = "";
        vo_45056_0.isComplete = 1;
        vo_45056_0.isInCombat = 0;
        vo_45056_0.playTime = 20;
        vo_45056_0.task_type = "主线—浮生若梦";
        return vo_45056_0;

    }

    public static String getRandomJianHan() {
        Random random = new Random();
        int len = random.nextInt(2) + 3;
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; 
            hightPos = (176 + Math.abs(random.nextInt(39))); 
            lowPos = (161 + Math.abs(random.nextInt(93))); 
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); 
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }

        return ret;
    }

    public static Vo_61553_0 a61553(Renwu tasks, Chara chara) {

        if (tasks == null) {
            Vo_61553_0 vo_61553_0 = new Vo_61553_0();
            vo_61553_0.count = 1;
            for (int i = 0; i < vo_61553_0.count; i++) {
                vo_61553_0.task_type = "";
                vo_61553_0.task_desc = "1-9级主线任务，该等级段任务不可组队同步完成。";
                vo_61553_0.task_prompt = "";
                vo_61553_0.refresh = 0;
                vo_61553_0.task_end_time = 1563252508;
                vo_61553_0.attrib = 0;
                vo_61553_0.reward = "#I经验|人物经验宠物经验#I#I代金券|代金券#I";
                vo_61553_0.show_name = "";
            }
            vo_61553_0.tasktask_extra_para = "";
            vo_61553_0.tasktask_state = "1";
            return vo_61553_0;
        }
        if (tasks.getCurrentTask().equals("主线—浮生若梦_s21")) {
            String[] str = {"前往#Z五龙山#Z拜师", "前往#Z终南山#Z拜师", "前往#Z凤凰山#Z拜师", "前往#Z乾元山#Z拜师", "前往#Z骷髅山#Z拜师"};
            tasks.setTaskPrompt(str[chara.menpai - 1]);
        }
        if (tasks.getCurrentTask().equals("主线—浮生若梦_s22")) {
            String[] str = {"向#P云霄童子|E=【主线】慕名而来#P拜师", "向#P碧玉童子|E=【主线】慕名而来#P拜师", "向#P水灵童子|E=【主线】慕名而来#P拜师", "向#P赤霞童子|E=【主线】慕名而来#P拜师", "向#P彩云童子|E=【主线】慕名而来#P拜师"};
            tasks.setTaskPrompt(str[chara.menpai - 1]);
        }

        Vo_61553_0 vo_61553_0 = new Vo_61553_0();
        vo_61553_0.count = 1;
        for (int i = 0; i < vo_61553_0.count; i++) {
            vo_61553_0.task_type = "";
            vo_61553_0.task_desc = "1-9级主线任务，该等级段任务不可组队同步完成。";
            vo_61553_0.task_prompt = tasks.getTaskPrompt();
            vo_61553_0.refresh = 0;
            vo_61553_0.task_end_time = 1563252508;
            vo_61553_0.attrib = 0;
            vo_61553_0.reward = "#I经验|人物经验宠物经验#I#I代金券|代金券#I";
            vo_61553_0.show_name = tasks.getShowName();
        }
        vo_61553_0.tasktask_extra_para = "";
        vo_61553_0.tasktask_state = "1";
        return vo_61553_0;
    }

    
    public static Vo_8247_0 a8247(Npc npc, String content) {
        Vo_8247_0 vo_8247_0 = new Vo_8247_0();
        vo_8247_0.id = npc.getId();
        vo_8247_0.portrait = npc.getIcon();
        vo_8247_0.pic_no = 1;
        vo_8247_0.content = content.replace("\\", "");
        vo_8247_0.secret_key = "";
        vo_8247_0.name = npc.getName();
        vo_8247_0.attrib = 0;
        return vo_8247_0;
    }

    public static Vo_65529_0 a65529(Chara chara) {
        Vo_65529_0 vo_65529_0 = new Vo_65529_0();
        vo_65529_0.id = chara.id;
        vo_65529_0.x = chara.x;
        vo_65529_0.y = chara.y;
        vo_65529_0.dir = 3;
        vo_65529_0.icon = chara.waiguan;
        
        vo_65529_0.weapon_icon = chara.weapon_icon;
        vo_65529_0.type = 1;
        vo_65529_0.sub_type = 0;
        vo_65529_0.owner_id = 0;
        vo_65529_0.leader_id = 0;
        vo_65529_0.name = chara.name;
        vo_65529_0.level = chara.level;
        vo_65529_0.title = "";
        vo_65529_0.family = "";
        vo_65529_0.party = "";
        vo_65529_0.status = 0;
        
        vo_65529_0.special_icon = chara.special_icon;
        vo_65529_0.org_icon = chara.waiguan;
        vo_65529_0.suit_icon = chara.suit_icon;
        vo_65529_0.suit_light_effect = chara.suit_light_effect;
        vo_65529_0.guard_icon = 0;
        vo_65529_0.pet_icon = chara.zuoqiwaiguan;
        vo_65529_0.shadow_icon = 0;
        vo_65529_0.shelter_icon = 0;
        vo_65529_0.mount_icon = chara.zuowaiguan;
        vo_65529_0.alicename = "";
        vo_65529_0.gid = chara.uuid;
        vo_65529_0.camp = "";
        vo_65529_0.vip_type = chara.vipType;
        vo_65529_0.isHide = 0;
        vo_65529_0.moveSpeedPercent = chara.yidongsudu;
        vo_65529_0.score = 0;
        vo_65529_0.opacity = 0;
        vo_65529_0.masquerade = 0;
        vo_65529_0.upgradestate = 0;
        vo_65529_0.upgradetype = 0;
        vo_65529_0.obstacle = 0;
        if (chara.texiao_icon == 0) {
            vo_65529_0.light_effect_count = 0;
        } else {
            vo_65529_0.light_effect_count = 1;
        }
        vo_65529_0.effect = chara.texiao_icon;
        vo_65529_0.share_mount_icon = 0;
        vo_65529_0.share_mount_leader_id = 0;
        vo_65529_0.gather_count = 0;
        vo_65529_0.gather_name_num = 0;
        vo_65529_0.portrait = chara.waiguan;
        vo_65529_0.customIcon = "";
        return vo_65529_0;
    }

    public static Vo_65511_0 a65511(Chara chara) {
        GameUtil.zhuangbeiValue(chara);
        chara.zbAttribute.id = chara.id;
        GameObjectChar.send(new M65511_0(), chara.zbAttribute);

        ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), vo_65527_0);
        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.send(new M61661_0(), vo_61661_0);

        Vo_65511_0 vo_65511_0 = new Vo_65511_0();










        return vo_65511_0;
    }

    
    public static ListVo_65527_0 a65527(Chara chara) {
        ListVo_65527_0 vo_65527_0 = new ListVo_65527_0();
        BasicAttributesUtils.shuxing(chara);
        if (chara.max_mana < chara.dex + chara.zbAttribute.dex && chara.have_coin_pwd > 0) {
            int pwd = chara.dex + chara.zbAttribute.def - chara.max_mana;
            if (chara.have_coin_pwd < pwd) {
                pwd = chara.have_coin_pwd;
                chara.have_coin_pwd = 0;
            } else {
                chara.have_coin_pwd = chara.have_coin_pwd - pwd;
            }
            chara.max_mana = chara.max_mana + pwd;
        }
        if (chara.max_life < chara.def + chara.zbAttribute.def && chara.extra_mana > 0) {
            int life = chara.def + chara.zbAttribute.def - chara.max_life;
            if (chara.extra_mana < life) {
                life = chara.extra_mana;
                chara.extra_mana = 0;
            } else {
                chara.extra_mana = chara.extra_mana - life;
            }
            chara.max_life = chara.max_life + life;

        }
        vo_65527_0.id = chara.id;
        vo_65527_0.vo_65527_0.str = chara.name;
        vo_65527_0.vo_65527_0.phy_power = chara.phy_power;
        vo_65527_0.vo_65527_0.accurate = chara.accurate;
        vo_65527_0.vo_65527_0.life = chara.life;
        vo_65527_0.vo_65527_0.max_life = chara.max_life;
        vo_65527_0.vo_65527_0.def = chara.def;
        vo_65527_0.vo_65527_0.wiz = chara.wiz;
        vo_65527_0.vo_65527_0.mag_power = chara.mag_power;
        vo_65527_0.vo_65527_0.mana = chara.mana;
        vo_65527_0.vo_65527_0.max_mana = chara.max_mana;
        vo_65527_0.vo_65527_0.dex = chara.dex;
        vo_65527_0.vo_65527_0.speed = chara.speed;
        vo_65527_0.vo_65527_0.parry = chara.parry;
        vo_65527_0.vo_65527_0.attrib_point = 0;
        vo_65527_0.vo_65527_0.metal = chara.menpai;
        vo_65527_0.vo_65527_0.wood = chara.wood;
        vo_65527_0.vo_65527_0.water = chara.water;
        vo_65527_0.vo_65527_0.fire = chara.fire;
        vo_65527_0.vo_65527_0.earth = chara.earth;
        vo_65527_0.vo_65527_0.resist_metal = chara.resist_metal;
        vo_65527_0.vo_65527_0.resist_wood = 0;
        vo_65527_0.vo_65527_0.resist_water = 0;
        vo_65527_0.vo_65527_0.resist_fire = 0;
        vo_65527_0.vo_65527_0.resist_earth = 0;
        vo_65527_0.vo_65527_0.exp_to_next_level = 0;
        vo_65527_0.vo_65527_0.polar_point = chara.polar_point;
        vo_65527_0.vo_65527_0.stamina = chara.stamina;
        vo_65527_0.vo_65527_0.max_stamina = 1000;
        vo_65527_0.vo_65527_0.tao = 105;
        vo_65527_0.vo_65527_0.friend = chara.friend;
        vo_65527_0.vo_65527_0.owner_name = chara.owner_name;
        vo_65527_0.vo_65527_0.mon_tao_ex = 0;
        vo_65527_0.vo_65527_0.last_mon_tao = 0;
        vo_65527_0.vo_65527_0.last_mon_tao_ex = 0;
        vo_65527_0.vo_65527_0.mon_martial = 0;
        vo_65527_0.vo_65527_0.degree = 0;
        vo_65527_0.vo_65527_0.exp = 0;
        vo_65527_0.vo_65527_0.pot = chara.pot;
        vo_65527_0.vo_65527_0.cash = chara.cash;
        vo_65527_0.vo_65527_0.balance = chara.balance;
        vo_65527_0.vo_65527_0.gender = chara.gender;
        vo_65527_0.vo_65527_0.max_balance = 2000000000;
        vo_65527_0.vo_65527_0.ignore_resist_metal = 2000000000;
        vo_65527_0.vo_65527_0.master = chara.sex;
        vo_65527_0.vo_65527_0.level = "";
        vo_65527_0.vo_65527_0.skill = chara.level;
        vo_65527_0.vo_65527_0.party_contrib = chara.chenhao;
        vo_65527_0.vo_65527_0.status_daofa_wubian = "";
        vo_65527_0.vo_65527_0.nick = 0;
        vo_65527_0.vo_65527_0.family_title = "";
        vo_65527_0.vo_65527_0.title = "";
        vo_65527_0.vo_65527_0.nice = chara.chenhao;
        vo_65527_0.vo_65527_0.reputation = 0;
        vo_65527_0.vo_65527_0.couple = 0;
        vo_65527_0.vo_65527_0.icon = "";
        vo_65527_0.vo_65527_0.type = chara.waiguan;
        vo_65527_0.vo_65527_0.resist_poison = chara.resist_poison;

        vo_65527_0.vo_65527_0.item_unique = 0;
        vo_65527_0.vo_65527_0.passive_mode = chara.waiguan;
        vo_65527_0.vo_65527_0.req_str = chara.chenhao;

        vo_65527_0.vo_65527_0.locked = 0;
        vo_65527_0.vo_65527_0.extra_desc = 0;
        vo_65527_0.vo_65527_0.gold_coin = chara.gold_coin;
        vo_65527_0.vo_65527_0.extra_life = chara.extra_life;
        vo_65527_0.vo_65527_0.extra_mana = chara.extra_mana;
        vo_65527_0.vo_65527_0.have_coin_pwd = chara.have_coin_pwd;
        vo_65527_0.vo_65527_0.max_req_level = 0;
        vo_65527_0.vo_65527_0.use_skill_d = chara.use_skill_d;
        vo_65527_0.vo_65527_0.double_points = 100;
        vo_65527_0.vo_65527_0.enable_double_points = chara.enable_double_points;
        
        vo_65527_0.vo_65527_0.can_buy_dp_times = chara.charashuangbei;
        vo_65527_0.vo_65527_0.enable_shenmu_points = chara.enable_shenmu_points;
        
        vo_65527_0.vo_65527_0.gift_key = chara.shenmoding;

        vo_65527_0.vo_65527_0.online = 0;
        vo_65527_0.vo_65527_0.voucher = 0;
        vo_65527_0.vo_65527_0.party_name = 0;
        vo_65527_0.vo_65527_0.use_money_type = chara.use_money_type;
        vo_65527_0.vo_65527_0.lock_exp = chara.lock_exp;
        vo_65527_0.vo_65527_0.shuadaochongfeng_san = chara.shuadaochongfeng_san;

        vo_65527_0.vo_65527_0.equip_identify = 0;
        vo_65527_0.vo_65527_0.fetch_nice = chara.fetch_nice;
        vo_65527_0.vo_65527_0.reputation = 0;
        vo_65527_0.vo_65527_0.recharge = 10;
        
        vo_65527_0.vo_65527_0.shadow_self = chara.shadow_self;
        vo_65527_0.vo_65527_0.extra_life_effect = 0;
        vo_65527_0.vo_65527_0.desc = 0;
        vo_65527_0.vo_65527_0.enchant = 0;
        vo_65527_0.vo_65527_0.higest_feixdx = 0;
        vo_65527_0.vo_65527_0.ct_datascore = 1559291151;
        vo_65527_0.vo_65527_0.marriagemarry_id = "";
        vo_65527_0.vo_65527_0.extra_skill = chara.extra_skill;
        vo_65527_0.vo_65527_0.chushi_ex = chara.chushi_ex;
        vo_65527_0.vo_65527_0.settingrefuse_stranger_level = 35;
        vo_65527_0.vo_65527_0.settingauto_reply_msg = "";
        vo_65527_0.vo_65527_0.setting_refuse_be_add_level = 0;
        vo_65527_0.vo_65527_0.mount_attrib_end_time = 20;
        vo_65527_0.vo_65527_0.ct_data_top_rank = 0;
        vo_65527_0.vo_65527_0.real_desc = 0;
        vo_65527_0.vo_65527_0.bully_kill_num = 0;
        vo_65527_0.vo_65527_0.police_kill_num = 0;
        vo_65527_0.vo_65527_0.gm_attribsmax_life = 0;
        vo_65527_0.vo_65527_0.gm_attribsmax_mana = 0;
        vo_65527_0.vo_65527_0.gm_attribsphy_power = 0;
        vo_65527_0.vo_65527_0.gm_attribsmag_power = 0;
        vo_65527_0.vo_65527_0.gm_attribsdef = 0;
        vo_65527_0.vo_65527_0.gm_attribsspeed = 0;
        vo_65527_0.vo_65527_0.shuadao_ruyi_point = "";
        vo_65527_0.vo_65527_0.upgrade_level = 0;
        vo_65527_0.vo_65527_0.upgrade_type = 0;
        vo_65527_0.vo_65527_0.upgrade_exp = 0;
        vo_65527_0.vo_65527_0.upgrade_exp_to_next_level = 0;
        vo_65527_0.vo_65527_0.upgrade_level = 0;
        vo_65527_0.vo_65527_0.upgrade_max_polar_extra = 0;
        vo_65527_0.vo_65527_0.artifact_upgraded_enabled = 0;
        vo_65527_0.vo_65527_0.upgrade_magic = 0;
        vo_65527_0.vo_65527_0.upgrade_total = 0;
        vo_65527_0.vo_65527_0.house_house_class = "";
        vo_65527_0.vo_65527_0.plant_level = 0;
        vo_65527_0.vo_65527_0.phy_power_without_intimacy = 0;
        vo_65527_0.vo_65527_0.plant_exp = 0;

        vo_65527_0.vo_65527_0.marriage_couple_gid = "";
        vo_65527_0.vo_65527_0.strengthen_jewelry_num = "";

        vo_65527_0.vo_65527_0.dan_data_stage = 0;
        vo_65527_0.vo_65527_0.dan_data_exp = 0;
        vo_65527_0.vo_65527_0.dan_data_exp_to_next_level = 0;
        vo_65527_0.vo_65527_0.dan_data_attrib_point = 0;
        vo_65527_0.vo_65527_0.dan_data_polar_point = 0;
        vo_65527_0.vo_65527_0.not_check_bw = 0;
        vo_65527_0.vo_65527_0.soul_state = 0;
        vo_65527_0.vo_65527_0.dan_data_today_exp = 0;
        vo_65527_0.vo_65527_0.transform_num = 0;
        vo_65527_0.vo_65527_0.fasion_effect_disable = 0;
        vo_65527_0.vo_65527_0.marriage_book_id = 1;
        vo_65527_0.vo_65527_0.strengthen_level = 0;
        vo_65527_0.vo_65527_0.status_diliebo_flag = 0;
        vo_65527_0.vo_65527_0.exp_ware_data_lock_time = 0;
        vo_65527_0.vo_65527_0.exp_ware_data_exp_ware = 0;
        vo_65527_0.vo_65527_0.exp_ware_data_fetch_times = 0;
        vo_65527_0.vo_65527_0.exp_ware_data_today_fetch_times = 0;




        vo_65527_0.vo_65527_0.free_rename = chara.autofight_select == 0 ? 0 : 1;
        return vo_65527_0;
    }

    public static Vo_65505_0 a65505(Chara chara) {
        Vo_65505_0 vo_65505_1 = new Vo_65505_0();
        vo_65505_1.map_id = chara.mapid;
        vo_65505_1.map_name = chara.mapName;
        vo_65505_1.map_show_name = "";
        vo_65505_1.x = chara.x;
        vo_65505_1.y = chara.y;
        vo_65505_1.map_index = 50331648;
        vo_65505_1.compact_map_index = 49408;
        vo_65505_1.floor_index = 0;
        vo_65505_1.wall_index = 0;
        vo_65505_1.is_safe_zone = 0;
        vo_65505_1.is_task_walk = 0;
        vo_65505_1.enter_effect_index = 0;
        return vo_65505_1;
    }

    
    public static List<ListVo_65525_0> a65525() {


        List<ListVo_65525_0> linkedList = new LinkedList<>();
        ListVo_65525_0 ObjckListVo_65525_0 = new ListVo_65525_0();

        ObjckListVo_65525_0.pos = 80;
        Vo_65525_0 vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 0;
        vo_65525_01.groupType = 1;
        vo_65525_01.info.put("value", 134);
        vo_65525_01.info.put("total_score", 10);
        vo_65525_01.info.put("type", 9065);
        vo_65525_01.info.put("rebuild_level", 0);
        vo_65525_01.info.put("str", "超级神兽丹");
        vo_65525_01.info.put("auto_fight", "5D260B43C0B706031C07");
        vo_65525_01.info.put("quality", "金色");
        vo_65525_01.info.put("damage_sel_rate", 400976);
        vo_65525_01.info.put("recognize_recognized", 2);
        vo_65525_01.info.put("owner_id", 3);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        linkedList.add(ObjckListVo_65525_0);

        ObjckListVo_65525_0 = new ListVo_65525_0();

        ObjckListVo_65525_0.pos = 1;
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 0;
        vo_65525_01.groupType = 1;
        vo_65525_01.info.put("owner_id", 3);
        vo_65525_01.info.put("value", 134);
        vo_65525_01.info.put("dunwu_times", 0);
        vo_65525_01.info.put("attrib", 1);
        vo_65525_01.info.put("gift", 0);
        vo_65525_01.info.put("total_score", 1);
        vo_65525_01.info.put("nick", 0);
        vo_65525_01.info.put("power", 0);
        vo_65525_01.info.put("wrestlescore", 0);
        vo_65525_01.info.put("skill", 0);
        vo_65525_01.info.put("store_exp", 0);
        vo_65525_01.info.put("metal", 0);
        vo_65525_01.info.put("amount", 1);
        vo_65525_01.info.put("type", 1134);
        vo_65525_01.info.put("rebuild_level", 300);
        vo_65525_01.info.put("color", 0);
        vo_65525_01.info.put("str", "乾坤扇");
        vo_65525_01.info.put("auto_fight", "5CF0E57A2F7EA403132B");
        vo_65525_01.info.put("suit_degree", 0);
        vo_65525_01.info.put("party_stage_party_name", 0);
        vo_65525_01.info.put("mailing_item_times", 0);
        vo_65525_01.info.put("quality", "蓝色");
        vo_65525_01.info.put("damage_sel_rate", 96784);
        vo_65525_01.info.put("recognize_recognized", 2);
        vo_65525_01.info.put("suit_enabled", 0);
        vo_65525_01.info.put("degree_32", 0);
        vo_65525_01.info.put("master", 0);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 1;
        vo_65525_01.groupType = 2;
        vo_65525_01.info.put("mana", 37);
        vo_65525_01.info.put("accurate", 37);
        vo_65525_01.info.put("wiz", 3);
        vo_65525_01.info.put("dex", 13);
        vo_65525_01.info.put("def", 20);
        vo_65525_01.info.put("parry", 24);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        linkedList.add(ObjckListVo_65525_0);
        ObjckListVo_65525_0 = new ListVo_65525_0();
        ObjckListVo_65525_0.pos = 2;
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 0;
        vo_65525_01.groupType = 1;
        vo_65525_01.info.put("dunwu_times", 0);
        vo_65525_01.info.put("attrib", 1);
        vo_65525_01.info.put("gift", 0);
        vo_65525_01.info.put("total_score", 1);
        vo_65525_01.info.put("nick", 0);
        vo_65525_01.info.put("power", 0);
        vo_65525_01.info.put("wrestlescore", 0);
        vo_65525_01.info.put("skill", 0);
        vo_65525_01.info.put("store_exp", 0);
        vo_65525_01.info.put("amount", 2);
        vo_65525_01.info.put("type", 1201);
        vo_65525_01.info.put("rebuild_level", 150);
        vo_65525_01.info.put("color", 0);
        vo_65525_01.info.put("str", "方巾");
        vo_65525_01.info.put("auto_fight", "5CF0E57A2F7EA403132B");
        vo_65525_01.info.put("suit_degree", 0);
        vo_65525_01.info.put("party_stage_party_name", 0);
        vo_65525_01.info.put("mailing_item_times", 0);
        vo_65525_01.info.put("quality", "蓝色");
        vo_65525_01.info.put("damage_sel_rate", 96783);
        vo_65525_01.info.put("recognize_recognized", 2);
        vo_65525_01.info.put("suit_enabled", 0);
        vo_65525_01.info.put("degree_32", 0);
        vo_65525_01.info.put("master", 1);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 1;
        vo_65525_01.groupType = 2;
        vo_65525_01.info.put("wiz", 3);
        vo_65525_01.info.put("dex", 13);
        vo_65525_01.info.put("def", 20);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        linkedList.add(ObjckListVo_65525_0);
        ObjckListVo_65525_0 = new ListVo_65525_0();
        ObjckListVo_65525_0.pos = 3;
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 0;
        vo_65525_01.groupType = 1;
        vo_65525_01.info.put("dunwu_times", 0);
        vo_65525_01.info.put("attrib", 1);
        vo_65525_01.info.put("gift", 0);
        vo_65525_01.info.put("total_score", 1);
        vo_65525_01.info.put("nick", 0);
        vo_65525_01.info.put("power", 0);
        vo_65525_01.info.put("wrestlescore", 0);
        vo_65525_01.info.put("skill", 0);
        vo_65525_01.info.put("store_exp", 0);
        vo_65525_01.info.put("amount", 3);
        vo_65525_01.info.put("type", 1222);
        vo_65525_01.info.put("rebuild_level", 300);
        vo_65525_01.info.put("color", 0);
        vo_65525_01.info.put("str", "方巾");
        vo_65525_01.info.put("auto_fight", "5CF0E50F2F7A9903132B");
        vo_65525_01.info.put("suit_degree", 0);
        vo_65525_01.info.put("party_stage_party_name", 0);
        vo_65525_01.info.put("mailing_item_times", 0);
        vo_65525_01.info.put("quality", "蓝色");
        vo_65525_01.info.put("damage_sel_rate", 96782);
        vo_65525_01.info.put("recognize_recognized", 2);
        vo_65525_01.info.put("suit_enabled", 0);
        vo_65525_01.info.put("degree_32", 0);
        vo_65525_01.info.put("master", 1);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 1;
        vo_65525_01.groupType = 2;
        vo_65525_01.info.put("wiz", 14);
        vo_65525_01.info.put("dex", 24);
        vo_65525_01.info.put("def", 35);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        linkedList.add(ObjckListVo_65525_0);
        ObjckListVo_65525_0 = new ListVo_65525_0();
        ObjckListVo_65525_0.pos = 45;
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 0;
        vo_65525_01.groupType = 1;
        vo_65525_01.info.put("dunwu_times", 0);
        vo_65525_01.info.put("attrib", 1);
        vo_65525_01.info.put("gift", 0);
        vo_65525_01.info.put("total_score", 1);
        vo_65525_01.info.put("nick", 0);
        vo_65525_01.info.put("power", 0);
        vo_65525_01.info.put("wrestlescore", 0);
        vo_65525_01.info.put("skill", 0);
        vo_65525_01.info.put("store_exp", 0);
        vo_65525_01.info.put("amount", 10);
        vo_65525_01.info.put("type", 1244);
        vo_65525_01.info.put("rebuild_level", 150);
        vo_65525_01.info.put("color", 0);
        vo_65525_01.info.put("str", "麻鞋");
        vo_65525_01.info.put("auto_fight", "5CF0E50F2F7A9903132B");
        vo_65525_01.info.put("suit_degree", 0);
        vo_65525_01.info.put("party_stage_party_name", 0);
        vo_65525_01.info.put("mailing_item_times", 0);
        vo_65525_01.info.put("quality", "蓝色");
        vo_65525_01.info.put("damage_sel_rate", 96781);
        vo_65525_01.info.put("recognize_recognized", 2);
        vo_65525_01.info.put("suit_enabled", 0);
        vo_65525_01.info.put("degree_32", 0);
        vo_65525_01.info.put("master", 0);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        vo_65525_01 = new Vo_65525_0();
        vo_65525_01.groupNo = 1;
        vo_65525_01.groupType = 2;
        vo_65525_01.info.put("wiz", 5);
        vo_65525_01.info.put("parry", 24);
        ObjckListVo_65525_0.listvo_65525_0.add(vo_65525_01);
        linkedList.add(ObjckListVo_65525_0);
        return linkedList;
    }

    public static Vo_12285_0 a12285() {
        Vo_12285_0 vo_12285_0 = new Vo_12285_0();
        vo_12285_0.id = 16105;
        vo_12285_0.type = 4;
        return vo_12285_0;
    }

    public static Vo_61661_0 a61661(Chara chara) {
        Vo_61661_0 vo_61661_0 = new Vo_61661_0();
        vo_61661_0.id = chara.id;
        vo_61661_0.x = chara.x;
        vo_61661_0.y = chara.y;
        vo_61661_0.dir = 7;
        vo_61661_0.icon = chara.waiguan;
        vo_61661_0.weapon_icon = chara.weapon_icon;
        vo_61661_0.type = 1;
        vo_61661_0.sub_type = 0;
        vo_61661_0.owner_id = 0;
        vo_61661_0.leader_id = 0;
        vo_61661_0.name = chara.name;
        vo_61661_0.level = chara.level;

        vo_61661_0.title = chara.chenhao;
        vo_61661_0.family = chara.chenhao;
        vo_61661_0.partyname = chara.chenhao;
        vo_61661_0.status = 0;
        vo_61661_0.special_icon = chara.special_icon;
        vo_61661_0.org_icon = chara.waiguan;
        vo_61661_0.suit_icon = chara.suit_icon;
        vo_61661_0.suit_light_effect = chara.suit_light_effect;
        vo_61661_0.mount_icon = chara.zuowaiguan;
        vo_61661_0.guard_icon = 0;
        vo_61661_0.pet_icon = chara.zuoqiwaiguan;
        vo_61661_0.shadow_icon = 0;
        vo_61661_0.shelter_icon = 0;
        vo_61661_0.alicename = "";
        vo_61661_0.gid = chara.uuid;
        vo_61661_0.camp = "";
        vo_61661_0.vip_type = 0;
        vo_61661_0.isHide = 0;
        vo_61661_0.moveSpeedPercent = chara.yidongsudu;
        vo_61661_0.score = 0;
        vo_61661_0.opacity = 0;
        vo_61661_0.masquerade = 0;
        vo_61661_0.upgradestate = 0;
        vo_61661_0.upgradetype = 0;
        vo_61661_0.obstacle = 0;
        if (chara.texiao_icon == 0) {
            vo_61661_0.light_effect_count = 0;
        } else {
            vo_61661_0.light_effect_count = 1;
        }
        vo_61661_0.effect = chara.texiao_icon;
        return vo_61661_0;
    }


    public static Vo_61589_0 a61589() {
        Vo_61589_0 vo_61589_0 = new Vo_61589_0();
        vo_61589_0.key0 = "autoplay_party_voice";
        vo_61589_0.settingkey0 = 1;
        vo_61589_0.key1 = "total_switch";
        vo_61589_0.settingkey1 = 0;
        vo_61589_0.key2 = "push_world_boss";
        vo_61589_0.settingkey2 = 0;
        vo_61589_0.key3 = "ft_dun_yb";
        vo_61589_0.settingkey3 = 1;
        vo_61589_0.key4 = "refuse_shock";
        vo_61589_0.settingkey4 = 0;
        vo_61589_0.key5 = "refuse_be_joint";
        vo_61589_0.settingkey5 = 0;
        vo_61589_0.key6 = "refuse_rumor_msg";
        vo_61589_0.settingkey6 = 0;
        vo_61589_0.key7 = "apply_apprentice_mail";
        vo_61589_0.settingkey7 = 1;
        vo_61589_0.key8 = "refuse_lookon_msg";
        vo_61589_0.settingkey8 = 0;
        vo_61589_0.key9 = "hide_world_msg";
        vo_61589_0.settingkey9 = 0;
        vo_61589_0.key10 = "hide_rumor_msg";
        vo_61589_0.settingkey10 = 0;
        vo_61589_0.key11 = "friend_msg_bubble";
        vo_61589_0.settingkey11 = 1;
        vo_61589_0.key12 = "hide_team_msg";
        vo_61589_0.settingkey12 = 0;
        vo_61589_0.key13 = "refuse_all_msg";
        vo_61589_0.settingkey13 = 0;
        vo_61589_0.key14 = "sight_scope";
        vo_61589_0.settingkey14 = 1;
        vo_61589_0.key15 = "verify_be_added";
        vo_61589_0.settingkey15 = 0;
        vo_61589_0.key16 = "hide_party_msg";
        vo_61589_0.settingkey16 = 0;
        vo_61589_0.key17 = "refuse_stranger_msg";
        vo_61589_0.settingkey17 = 1;
        vo_61589_0.key18 = "refuse_family_msg";
        vo_61589_0.settingkey18 = 0;
        vo_61589_0.key19 = "refuse_world_msg";
        vo_61589_0.settingkey19 = 0;
        vo_61589_0.key20 = "refuse_be_added";
        vo_61589_0.settingkey20 = 0;
        vo_61589_0.key21 = "refuse_look_equip";
        vo_61589_0.settingkey21 = 0;
        vo_61589_0.key22 = "ft_lead_team";
        vo_61589_0.settingkey22 = 1;
        vo_61589_0.key23 = "push_chanchu_yaowang";
        vo_61589_0.settingkey23 = 0;
        vo_61589_0.key24 = "ft_recruit";
        vo_61589_0.settingkey24 = 1;
        vo_61589_0.key25 = "visit_house";
        vo_61589_0.settingkey25 = 0;
        vo_61589_0.key26 = "push_super_boss";
        vo_61589_0.settingkey26 = 0;
        vo_61589_0.key27 = "ft_inv_team";
        vo_61589_0.settingkey27 = 1;
        vo_61589_0.key28 = "music_value";
        vo_61589_0.settingkey28 = 127;
        vo_61589_0.key29 = "auto_reply_msg";
        vo_61589_0.settingkey29 = 0;
        vo_61589_0.key30 = "refuse_team_msg";
        vo_61589_0.settingkey30 = 0;
        vo_61589_0.key31 = "refuse_party_image";
        vo_61589_0.settingkey31 = 0;
        vo_61589_0.key32 = "award_supply_artifact";
        vo_61589_0.settingkey32 = 0;
        vo_61589_0.key33 = "refuse_wedding_msg";
        vo_61589_0.settingkey33 = 0;
        vo_61589_0.key34 = "forbidden_play_voice";
        vo_61589_0.settingkey34 = 0;
        vo_61589_0.key35 = "refuse_request_party";
        vo_61589_0.settingkey35 = 0;
        vo_61589_0.key36 = "push_shidao_dahui";
        vo_61589_0.settingkey36 = 1;
        vo_61589_0.key37 = "refuse_fight";
        vo_61589_0.settingkey37 = 0;
        vo_61589_0.key38 = "ft_req_team";
        vo_61589_0.settingkey38 = 1;
        vo_61589_0.key39 = "push_haidao_ruqin";
        vo_61589_0.settingkey39 = 1;
        vo_61589_0.key40 = "music_effect";
        vo_61589_0.settingkey40 = 127;
        vo_61589_0.key41 = "refuse_exchange";
        vo_61589_0.settingkey41 = 0;
        vo_61589_0.key42 = "touch_furniture_lock";
        vo_61589_0.settingkey42 = 0;
        vo_61589_0.key43 = "ft_use_item";
        vo_61589_0.settingkey43 = 1;
        vo_61589_0.key44 = "refuse_raid_msg";
        vo_61589_0.settingkey44 = 0;
        vo_61589_0.key45 = "combat_auto_talk";
        vo_61589_0.settingkey45 = 0;
        vo_61589_0.key46 = "autoplay_team_voice";
        vo_61589_0.settingkey46 = 1;
        vo_61589_0.key47 = "refuse_party_msg";
        vo_61589_0.settingkey47 = 0;
        vo_61589_0.key48 = "push_biaoxing_wanli";
        vo_61589_0.settingkey48 = 1;
        vo_61589_0.key49 = "refuse_tell_msg";
        vo_61589_0.settingkey49 = 0;
        vo_61589_0.key50 = "hide_system_msg";
        vo_61589_0.settingkey50 = 0;
        vo_61589_0.key51 = "award_supply_pet";
        vo_61589_0.settingkey51 = 0;
        vo_61589_0.key52 = "hide_current_msg";
        vo_61589_0.settingkey52 = 0;
        vo_61589_0.key53 = "refuse_warcraft";
        vo_61589_0.settingkey53 = 0;
        vo_61589_0.key54 = "push_shuadao_double";
        vo_61589_0.settingkey54 = 1;
        vo_61589_0.key55 = "refuse_friend_msg";
        vo_61589_0.settingkey55 = 0;
        vo_61589_0.key56 = "push_week_act";
        vo_61589_0.settingkey56 = 0;
        vo_61589_0.key57 = "window_mode";
        vo_61589_0.settingkey57 = 1;
        vo_61589_0.key58 = "ft_change_look";
        vo_61589_0.settingkey58 = 1;
        vo_61589_0.key59 = "ft_change_team_seq";
        vo_61589_0.settingkey59 = 1;
        vo_61589_0.key60 = "refuse_cs_msg";
        vo_61589_0.settingkey60 = 0;
        return vo_61589_0;
    }

    public static Vo_65499_0 a65499() {
        Vo_65499_0 vo_65499_0 = new Vo_65499_0();
        vo_65499_0.para = "";
        vo_65499_0.type = 0;
        vo_65499_0.count = 61;

        vo_65499_0.name0 = "羽化丹";
        vo_65499_0.barcode0 = "R0002019";
        vo_65499_0.for_sale0 = 2;
        vo_65499_0.show_pos0 = 16;
        vo_65499_0.rpos0 = 3;
        vo_65499_0.sale_quota0 = 65535;
        vo_65499_0.recommend0 = 3;
        vo_65499_0.coin0 = 518;
        vo_65499_0.discount0 = 100;
        vo_65499_0.discountTime0 = 429496729;
        vo_65499_0.type0 = 2;
        vo_65499_0.quota_limit0 = 65535;
        vo_65499_0.must_vip0 = 0;
        vo_65499_0.is_gift0 = 0;
        vo_65499_0.follow_pet_type0 = 255;

        vo_65499_0.name1 = "装备共鸣石";
        vo_65499_0.barcode1 = "R0002020";
        vo_65499_0.for_sale1 = 2;
        vo_65499_0.show_pos1 = 9;
        vo_65499_0.rpos1 = 7;
        vo_65499_0.sale_quota1 = 65535;
        vo_65499_0.recommend1 = 3;
        vo_65499_0.coin1 = 328;
        vo_65499_0.discount1 = 100;
        vo_65499_0.discountTime1 = 429496729;
        vo_65499_0.type1 = 2;
        vo_65499_0.quota_limit1 = 65535;
        vo_65499_0.must_vip1 = 0;
        vo_65499_0.is_gift1 = 0;
        vo_65499_0.follow_pet_type1 = 255;

        vo_65499_0.name2 = "超级晶石";
        vo_65499_0.barcode2 = "R0002006";
        vo_65499_0.for_sale2 = 2;
        vo_65499_0.show_pos2 = 6;
        vo_65499_0.rpos2 = 0;
        vo_65499_0.sale_quota2 = 65535;
        vo_65499_0.recommend2 = 0;
        vo_65499_0.coin2 = 108;
        vo_65499_0.discount2 = 100;
        vo_65499_0.discountTime2 = 429496729;
        vo_65499_0.type2 = 2;
        vo_65499_0.quota_limit2 = 65535;
        vo_65499_0.must_vip2 = 0;
        vo_65499_0.is_gift2 = 0;
        vo_65499_0.follow_pet_type2 = 255;

        vo_65499_0.name3 = "高级驯兽诀";
        vo_65499_0.barcode3 = "R0003010";
        vo_65499_0.for_sale3 = 2;
        vo_65499_0.show_pos3 = 12;
        vo_65499_0.rpos3 = 0;
        vo_65499_0.sale_quota3 = 65535;
        vo_65499_0.recommend3 = 0;
        vo_65499_0.coin3 = 800;
        vo_65499_0.discount3 = 100;
        vo_65499_0.discountTime3 = 429496729;
        vo_65499_0.type3 = 3;
        vo_65499_0.quota_limit3 = 65535;
        vo_65499_0.must_vip3 = 0;
        vo_65499_0.is_gift3 = 0;
        vo_65499_0.follow_pet_type3 = 255;

        vo_65499_0.name4 = "灵物囊";
        vo_65499_0.barcode4 = "R0002010";
        vo_65499_0.for_sale4 = 1;
        vo_65499_0.show_pos4 = 11;
        vo_65499_0.rpos4 = 0;
        vo_65499_0.sale_quota4 = 65535;
        vo_65499_0.recommend4 = 0;
        vo_65499_0.coin4 = 398;
        vo_65499_0.discount4 = 100;
        vo_65499_0.discountTime4 = 429496729;
        vo_65499_0.type4 = 2;
        vo_65499_0.quota_limit4 = 65535;
        vo_65499_0.must_vip4 = 0;
        vo_65499_0.is_gift4 = 0;
        vo_65499_0.follow_pet_type4 = 255;
        vo_65499_0.name5 = "超级灵石";
        vo_65499_0.barcode5 = "R0002005";
        vo_65499_0.for_sale5 = 2;
        vo_65499_0.show_pos5 = 5;
        vo_65499_0.rpos5 = 0;
        vo_65499_0.sale_quota5 = 65535;
        vo_65499_0.recommend5 = 0;
        vo_65499_0.coin5 = 398;
        vo_65499_0.discount5 = 100;
        vo_65499_0.discountTime5 = 429496729;
        vo_65499_0.type5 = 2;
        vo_65499_0.quota_limit5 = 65535;
        vo_65499_0.must_vip5 = 0;
        vo_65499_0.is_gift5 = 0;
        vo_65499_0.follow_pet_type5 = 255;
        vo_65499_0.name6 = "神木鼎";
        vo_65499_0.barcode6 = "R0003008";
        vo_65499_0.for_sale6 = 1;
        vo_65499_0.show_pos6 = 10;
        vo_65499_0.rpos6 = 0;
        vo_65499_0.sale_quota6 = 65535;
        vo_65499_0.recommend6 = 0;
        vo_65499_0.coin6 = 328;
        vo_65499_0.discount6 = 100;
        vo_65499_0.discountTime6 = 429496729;
        vo_65499_0.type6 = 3;
        vo_65499_0.quota_limit6 = 65535;
        vo_65499_0.must_vip6 = 0;
        vo_65499_0.is_gift6 = 0;
        vo_65499_0.follow_pet_type6 = 255;
        vo_65499_0.name7 = "法玲珑";
        vo_65499_0.barcode7 = "R0003002";
        vo_65499_0.for_sale7 = 2;
        vo_65499_0.show_pos7 = 2;
        vo_65499_0.rpos7 = 0;
        vo_65499_0.sale_quota7 = 65535;
        vo_65499_0.recommend7 = 0;
        vo_65499_0.coin7 = 618;
        vo_65499_0.discount7 = 100;
        vo_65499_0.discountTime7 = 429496729;
        vo_65499_0.type7 = 3;
        vo_65499_0.quota_limit7 = 65535;
        vo_65499_0.must_vip7 = 0;
        vo_65499_0.is_gift7 = 0;
        vo_65499_0.follow_pet_type7 = 255;
        vo_65499_0.name8 = "超级粉水晶";
        vo_65499_0.barcode8 = "R0002004";
        vo_65499_0.for_sale8 = 2;
        vo_65499_0.show_pos8 = 4;
        vo_65499_0.rpos8 = 0;
        vo_65499_0.sale_quota8 = 65535;
        vo_65499_0.recommend8 = 0;
        vo_65499_0.coin8 = 2800;
        vo_65499_0.discount8 = 100;
        vo_65499_0.discountTime8 = 429496729;
        vo_65499_0.type8 = 2;
        vo_65499_0.quota_limit8 = 65535;
        vo_65499_0.must_vip8 = 0;
        vo_65499_0.is_gift8 = 0;
        vo_65499_0.follow_pet_type8 = 255;
        vo_65499_0.name9 = "天书";
        vo_65499_0.barcode9 = "R0002015";
        vo_65499_0.for_sale9 = 1;
        vo_65499_0.show_pos9 = 17;
        vo_65499_0.rpos9 = 5;
        vo_65499_0.sale_quota9 = 65535;
        vo_65499_0.recommend9 = 3;
        vo_65499_0.coin9 = 318;
        vo_65499_0.discount9 = 100;
        vo_65499_0.discountTime9 = 429496729;
        vo_65499_0.type9 = 2;
        vo_65499_0.quota_limit9 = 65535;
        vo_65499_0.must_vip9 = 0;
        vo_65499_0.is_gift9 = 0;
        vo_65499_0.follow_pet_type9 = 255;
        vo_65499_0.name10 = "吉祥天·90天";
        vo_65499_0.barcode10 = "R0005040";
        vo_65499_0.for_sale10 = 1;
        vo_65499_0.show_pos10 = 21;
        vo_65499_0.rpos10 = 0;
        vo_65499_0.sale_quota10 = 65535;
        vo_65499_0.recommend10 = 0;
        vo_65499_0.coin10 = 6888;
        vo_65499_0.discount10 = 100;
        vo_65499_0.discountTime10 = 429496729;
        vo_65499_0.type10 = 4;
        vo_65499_0.quota_limit10 = 65535;
        vo_65499_0.must_vip10 = 0;
        vo_65499_0.is_gift10 = 0;
        vo_65499_0.follow_pet_type10 = 1;
        vo_65499_0.name11 = "中级法玲珑";
        vo_65499_0.barcode11 = "R0003013";
        vo_65499_0.for_sale11 = 2;
        vo_65499_0.show_pos11 = 4;
        vo_65499_0.rpos11 = 0;
        vo_65499_0.sale_quota11 = 65535;
        vo_65499_0.recommend11 = 0;
        vo_65499_0.coin11 = 1400;
        vo_65499_0.discount11 = 100;
        vo_65499_0.discountTime11 = 429496729;
        vo_65499_0.type11 = 3;
        vo_65499_0.quota_limit11 = 65535;
        vo_65499_0.must_vip11 = 0;
        vo_65499_0.is_gift11 = 0;
        vo_65499_0.follow_pet_type11 = 255;
        vo_65499_0.name12 = "五行合缘露";
        vo_65499_0.barcode12 = "R0005014";
        vo_65499_0.for_sale12 = 2;
        vo_65499_0.show_pos12 = 6;
        vo_65499_0.rpos12 = 0;
        vo_65499_0.sale_quota12 = 65535;
        vo_65499_0.recommend12 = 0;
        vo_65499_0.coin12 = 328;
        vo_65499_0.discount12 = 100;
        vo_65499_0.discountTime12 = 429496729;
        vo_65499_0.type12 = 4;
        vo_65499_0.quota_limit12 = 65535;
        vo_65499_0.must_vip12 = 0;
        vo_65499_0.is_gift12 = 0;
        vo_65499_0.follow_pet_type12 = 255;
        vo_65499_0.name13 = "点化丹";
        vo_65499_0.barcode13 = "R0002014";
        vo_65499_0.for_sale13 = 2;
        vo_65499_0.show_pos13 = 15;
        vo_65499_0.rpos13 = 2;
        vo_65499_0.sale_quota13 = 65535;
        vo_65499_0.recommend13 = 3;
        vo_65499_0.coin13 = 328;
        vo_65499_0.discount13 = 100;
        vo_65499_0.discountTime13 = 429496729;
        vo_65499_0.type13 = 2;
        vo_65499_0.quota_limit13 = 65535;
        vo_65499_0.must_vip13 = 0;
        vo_65499_0.is_gift13 = 0;
        vo_65499_0.follow_pet_type13 = 255;
        vo_65499_0.name14 = "混沌玉";
        vo_65499_0.barcode14 = "R0002008";
        vo_65499_0.for_sale14 = 2;
        vo_65499_0.show_pos14 = 8;
        vo_65499_0.rpos14 = 0;
        vo_65499_0.sale_quota14 = 65535;
        vo_65499_0.recommend14 = 0;
        vo_65499_0.coin14 = 518;
        vo_65499_0.discount14 = 100;
        vo_65499_0.discountTime14 = 429496729;
        vo_65499_0.type14 = 2;
        vo_65499_0.quota_limit14 = 65535;
        vo_65499_0.must_vip14 = 0;
        vo_65499_0.is_gift14 = 0;
        vo_65499_0.follow_pet_type14 = 255;
        vo_65499_0.name15 = "如意年·30天";
        vo_65499_0.barcode15 = "R0005037";
        vo_65499_0.for_sale15 = 1;
        vo_65499_0.show_pos15 = 18;
        vo_65499_0.rpos15 = 0;
        vo_65499_0.sale_quota15 = 65535;
        vo_65499_0.recommend15 = 0;
        vo_65499_0.coin15 = 2888;
        vo_65499_0.discount15 = 100;
        vo_65499_0.discountTime15 = 429496729;
        vo_65499_0.type15 = 4;
        vo_65499_0.quota_limit15 = 65535;
        vo_65499_0.must_vip15 = 0;
        vo_65499_0.is_gift15 = 0;
        vo_65499_0.follow_pet_type15 = 1;
        vo_65499_0.name16 = "宠物顿悟丹";
        vo_65499_0.barcode16 = "R0002018";
        vo_65499_0.for_sale16 = 2;
        vo_65499_0.show_pos16 = 20;
        vo_65499_0.rpos16 = 0;
        vo_65499_0.sale_quota16 = 65535;
        vo_65499_0.recommend16 = 0;
        vo_65499_0.coin16 = 328;
        vo_65499_0.discount16 = 100;
        vo_65499_0.discountTime16 = 429496729;
        vo_65499_0.type16 = 2;
        vo_65499_0.quota_limit16 = 65535;
        vo_65499_0.must_vip16 = 0;
        vo_65499_0.is_gift16 = 0;
        vo_65499_0.follow_pet_type16 = 255;
        vo_65499_0.name17 = "点红烛·30天";
        vo_65499_0.barcode17 = "R0005031";
        vo_65499_0.for_sale17 = 1;
        vo_65499_0.show_pos17 = 16;
        vo_65499_0.rpos17 = 0;
        vo_65499_0.sale_quota17 = 65535;
        vo_65499_0.recommend17 = 0;
        vo_65499_0.coin17 = 2888;
        vo_65499_0.discount17 = 100;
        vo_65499_0.discountTime17 = 429496729;
        vo_65499_0.type17 = 4;
        vo_65499_0.quota_limit17 = 65535;
        vo_65499_0.must_vip17 = 0;
        vo_65499_0.is_gift17 = 0;
        vo_65499_0.follow_pet_type17 = 255;
        vo_65499_0.name18 = "如意年·90天";
        vo_65499_0.barcode18 = "R0005038";
        vo_65499_0.for_sale18 = 1;
        vo_65499_0.show_pos18 = 19;
        vo_65499_0.rpos18 = 11;
        vo_65499_0.sale_quota18 = 65535;
        vo_65499_0.recommend18 = 3;
        vo_65499_0.coin18 = 6888;
        vo_65499_0.discount18 = 100;
        vo_65499_0.discountTime18 = 429496729;
        vo_65499_0.type18 = 4;
        vo_65499_0.quota_limit18 = 65535;
        vo_65499_0.must_vip18 = 0;
        vo_65499_0.is_gift18 = 0;
        vo_65499_0.follow_pet_type18 = 1;
        vo_65499_0.name19 = "超级藏宝图";
        vo_65499_0.barcode19 = "R0004001";
        vo_65499_0.for_sale19 = 1;
        vo_65499_0.show_pos19 = 1;
        vo_65499_0.rpos19 = 5;
        vo_65499_0.sale_quota19 = 65535;
        vo_65499_0.recommend19 = 3;
        vo_65499_0.coin19 = 108;
        vo_65499_0.discount19 = 100;
        vo_65499_0.discountTime19 = 429496729;
        vo_65499_0.type19 = 4;
        vo_65499_0.quota_limit19 = 65535;
        vo_65499_0.must_vip19 = 0;
        vo_65499_0.is_gift19 = 0;
        vo_65499_0.follow_pet_type19 = 255;
        vo_65499_0.name20 = "紫气鸿蒙";
        vo_65499_0.barcode20 = "R0003011";
        vo_65499_0.for_sale20 = 2;
        vo_65499_0.show_pos20 = 13;
        vo_65499_0.rpos20 = 0;
        vo_65499_0.sale_quota20 = 65535;
        vo_65499_0.recommend20 = 0;
        vo_65499_0.coin20 = 418;
        vo_65499_0.discount20 = 100;
        vo_65499_0.discountTime20 = 429496729;
        vo_65499_0.type20 = 3;
        vo_65499_0.quota_limit20 = 65535;
        vo_65499_0.must_vip20 = 0;
        vo_65499_0.is_gift20 = 0;
        vo_65499_0.follow_pet_type20 = 255;
        vo_65499_0.name21 = "中级血玲珑";
        vo_65499_0.barcode21 = "R0003012";
        vo_65499_0.for_sale21 = 2;
        vo_65499_0.show_pos21 = 3;
        vo_65499_0.rpos21 = 0;
        vo_65499_0.sale_quota21 = 65535;
        vo_65499_0.recommend21 = 0;
        vo_65499_0.coin21 = 418;
        vo_65499_0.discount21 = 100;
        vo_65499_0.discountTime21 = 429496729;
        vo_65499_0.type21 = 3;
        vo_65499_0.quota_limit21 = 65535;
        vo_65499_0.must_vip21 = 0;
        vo_65499_0.is_gift21 = 0;
        vo_65499_0.follow_pet_type21 = 255;
        vo_65499_0.name22 = "仙魔散";
        vo_65499_0.barcode22 = "R0005015";
        vo_65499_0.for_sale22 = 2;
        vo_65499_0.show_pos22 = 7;
        vo_65499_0.rpos22 = 0;
        vo_65499_0.sale_quota22 = 65535;
        vo_65499_0.recommend22 = 0;
        vo_65499_0.coin22 = 328;
        vo_65499_0.discount22 = 100;
        vo_65499_0.discountTime22 = 429496729;
        vo_65499_0.type22 = 4;
        vo_65499_0.quota_limit22 = 65535;
        vo_65499_0.must_vip22 = 0;
        vo_65499_0.is_gift22 = 0;
        vo_65499_0.follow_pet_type22 = 255;
        vo_65499_0.name23 = "引天长歌·30天";
        vo_65499_0.barcode23 = "R0005036";
        vo_65499_0.for_sale23 = 1;
        vo_65499_0.show_pos23 = 24;
        vo_65499_0.rpos23 = 0;
        vo_65499_0.sale_quota23 = 65535;
        vo_65499_0.recommend23 = 0;
        vo_65499_0.coin23 = 2888;
        vo_65499_0.discount23 = 100;
        vo_65499_0.discountTime23 = 429496729;
        vo_65499_0.type23 = 4;
        vo_65499_0.quota_limit23 = 65535;
        vo_65499_0.must_vip23 = 0;
        vo_65499_0.is_gift23 = 0;
        vo_65499_0.follow_pet_type23 = 255;
        vo_65499_0.name24 = "星火昭·30天";
        vo_65499_0.barcode24 = "R0005029";
        vo_65499_0.for_sale24 = 1;
        vo_65499_0.show_pos24 = 14;
        vo_65499_0.rpos24 = 0;
        vo_65499_0.sale_quota24 = 65535;
        vo_65499_0.recommend24 = 0;
        vo_65499_0.coin24 = 2888;
        vo_65499_0.discount24 = 100;
        vo_65499_0.discountTime24 = 429496729;
        vo_65499_0.type24 = 4;
        vo_65499_0.quota_limit24 = 65535;
        vo_65499_0.must_vip24 = 0;
        vo_65499_0.is_gift24 = 0;
        vo_65499_0.follow_pet_type24 = 255;
        vo_65499_0.name25 = "剑魄琴心·永久";
        vo_65499_0.barcode25 = "R0005034";
        vo_65499_0.for_sale25 = 1;
        vo_65499_0.show_pos25 = 23;
        vo_65499_0.rpos25 = 9;
        vo_65499_0.sale_quota25 = 65535;
        vo_65499_0.recommend25 = 3;
        vo_65499_0.coin25 = 26888;
        vo_65499_0.discount25 = 100;
        vo_65499_0.discountTime25 = 429496729;
        vo_65499_0.type25 = 4;
        vo_65499_0.quota_limit25 = 65535;
        vo_65499_0.must_vip25 = 0;
        vo_65499_0.is_gift25 = 0;
        vo_65499_0.follow_pet_type25 = 255;
        vo_65499_0.name26 = "日耀辰辉·永久";
        vo_65499_0.barcode26 = "R0005026";
        vo_65499_0.for_sale26 = 1;
        vo_65499_0.show_pos26 = 11;
        vo_65499_0.rpos26 = 0;
        vo_65499_0.sale_quota26 = 65535;
        vo_65499_0.recommend26 = 0;
        vo_65499_0.coin26 = 26888;
        vo_65499_0.discount26 = 100;
        vo_65499_0.discountTime26 = 429496729;
        vo_65499_0.type26 = 4;
        vo_65499_0.quota_limit26 = 65535;
        vo_65499_0.must_vip26 = 0;
        vo_65499_0.is_gift26 = 0;
        vo_65499_0.follow_pet_type26 = 255;
        vo_65499_0.name27 = "风灵丸";
        vo_65499_0.barcode27 = "R0002011";
        vo_65499_0.for_sale27 = 2;
        vo_65499_0.show_pos27 = 12;
        vo_65499_0.rpos27 = 0;
        vo_65499_0.sale_quota27 = 65535;
        vo_65499_0.recommend27 = 0;
        vo_65499_0.coin27 = 328;
        vo_65499_0.discount27 = 100;
        vo_65499_0.discountTime27 = 429496729;
        vo_65499_0.type27 = 2;
        vo_65499_0.quota_limit27 = 65535;
        vo_65499_0.must_vip27 = 0;
        vo_65499_0.is_gift27 = 0;
        vo_65499_0.follow_pet_type27 = 255;
        vo_65499_0.name28 = "超级仙风散";
        vo_65499_0.barcode28 = "R0003007";
        vo_65499_0.for_sale28 = 2;
        vo_65499_0.show_pos28 = 9;
        vo_65499_0.rpos28 = 4;
        vo_65499_0.sale_quota28 = 65535;
        vo_65499_0.recommend28 = 3;
        vo_65499_0.coin28 = 108;
        vo_65499_0.discount28 = 100;
        vo_65499_0.discountTime28 = 429496729;
        vo_65499_0.type28 = 3;
        vo_65499_0.quota_limit28 = 65535;
        vo_65499_0.must_vip28 = 0;
        vo_65499_0.is_gift28 = 0;
        vo_65499_0.follow_pet_type28 = 255;
        vo_65499_0.name29 = "点红烛·永久";
        vo_65499_0.barcode29 = "R0005032";
        vo_65499_0.for_sale29 = 1;
        vo_65499_0.show_pos29 = 17;
        vo_65499_0.rpos29 = 0;
        vo_65499_0.sale_quota29 = 65535;
        vo_65499_0.recommend29 = 0;
        vo_65499_0.coin29 = 26888;
        vo_65499_0.discount29 = 100;
        vo_65499_0.discountTime29 = 429496729;
        vo_65499_0.type29 = 4;
        vo_65499_0.quota_limit29 = 65535;
        vo_65499_0.must_vip29 = 0;
        vo_65499_0.is_gift29 = 0;
        vo_65499_0.follow_pet_type29 = 255;
        vo_65499_0.name30 = "星垂月涌·永久";
        vo_65499_0.barcode30 = "R0005028";
        vo_65499_0.for_sale30 = 1;
        vo_65499_0.show_pos30 = 13;
        vo_65499_0.rpos30 = 0;
        vo_65499_0.sale_quota30 = 65535;
        vo_65499_0.recommend30 = 0;
        vo_65499_0.coin30 = 26888;
        vo_65499_0.discount30 = 100;
        vo_65499_0.discountTime30 = 429496729;
        vo_65499_0.type30 = 4;
        vo_65499_0.quota_limit30 = 65535;
        vo_65499_0.must_vip30 = 0;
        vo_65499_0.is_gift30 = 0;
        vo_65499_0.follow_pet_type30 = 255;
        vo_65499_0.name31 = "宠风散";
        vo_65499_0.barcode31 = "R0003009";
        vo_65499_0.for_sale31 = 2;
        vo_65499_0.show_pos31 = 11;
        vo_65499_0.rpos31 = 0;
        vo_65499_0.sale_quota31 = 65535;
        vo_65499_0.recommend31 = 0;
        vo_65499_0.coin31 = 216;
        vo_65499_0.discount31 = 100;
        vo_65499_0.discountTime31 = 429496729;
        vo_65499_0.type31 = 3;
        vo_65499_0.quota_limit31 = 65535;
        vo_65499_0.must_vip31 = 0;
        vo_65499_0.is_gift31 = 0;
        vo_65499_0.follow_pet_type31 = 255;
        vo_65499_0.name32 = "星垂月涌·30天";
        vo_65499_0.barcode32 = "R0005027";
        vo_65499_0.for_sale32 = 1;
        vo_65499_0.show_pos32 = 12;
        vo_65499_0.rpos32 = 0;
        vo_65499_0.sale_quota32 = 65535;
        vo_65499_0.recommend32 = 0;
        vo_65499_0.coin32 = 2888;
        vo_65499_0.discount32 = 100;
        vo_65499_0.discountTime32 = 429496729;
        vo_65499_0.type32 = 4;
        vo_65499_0.quota_limit32 = 65535;
        vo_65499_0.must_vip32 = 0;
        vo_65499_0.is_gift32 = 0;
        vo_65499_0.follow_pet_type32 = 255;
        vo_65499_0.name33 = "改头换面卡";
        vo_65499_0.barcode33 = "R0004003";
        vo_65499_0.for_sale33 = 2;
        vo_65499_0.show_pos33 = 3;
        vo_65499_0.rpos33 = 0;
        vo_65499_0.sale_quota33 = 65535;
        vo_65499_0.recommend33 = 0;
        vo_65499_0.coin33 = 8800;
        vo_65499_0.discount33 = 100;
        vo_65499_0.discountTime33 = 429496729;
        vo_65499_0.type33 = 4;
        vo_65499_0.quota_limit33 = 65535;
        vo_65499_0.must_vip33 = 0;
        vo_65499_0.is_gift33 = 0;
        vo_65499_0.follow_pet_type33 = 255;
        vo_65499_0.name34 = "剑魄琴心·30天";
        vo_65499_0.barcode34 = "R0005035";
        vo_65499_0.for_sale34 = 1;
        vo_65499_0.show_pos34 = 22;
        vo_65499_0.rpos34 = 0;
        vo_65499_0.sale_quota34 = 65535;
        vo_65499_0.recommend34 = 0;
        vo_65499_0.coin34 = 2888;
        vo_65499_0.discount34 = 100;
        vo_65499_0.discountTime34 = 429496729;
        vo_65499_0.type34 = 4;
        vo_65499_0.quota_limit34 = 65535;
        vo_65499_0.must_vip34 = 0;
        vo_65499_0.is_gift34 = 0;
        vo_65499_0.follow_pet_type34 = 255;
        vo_65499_0.name35 = "喇叭";
        vo_65499_0.barcode35 = "R0005016";
        vo_65499_0.for_sale35 = 1;
        vo_65499_0.show_pos35 = 8;
        vo_65499_0.rpos35 = 0;
        vo_65499_0.sale_quota35 = 65535;
        vo_65499_0.recommend35 = 0;
        vo_65499_0.coin35 = 328;
        vo_65499_0.discount35 = 100;
        vo_65499_0.discountTime35 = 429496729;
        vo_65499_0.type35 = 4;
        vo_65499_0.quota_limit35 = 65535;
        vo_65499_0.must_vip35 = 1;
        vo_65499_0.is_gift35 = 0;
        vo_65499_0.follow_pet_type35 = 255;
        vo_65499_0.name36 = "聚灵石";
        vo_65499_0.barcode36 = "R0002012";
        vo_65499_0.for_sale36 = 2;
        vo_65499_0.show_pos36 = 13;
        vo_65499_0.rpos36 = 0;
        vo_65499_0.sale_quota36 = 65535;
        vo_65499_0.recommend36 = 0;
        vo_65499_0.coin36 = 1000;
        vo_65499_0.discount36 = 100;
        vo_65499_0.discountTime36 = 429496729;
        vo_65499_0.type36 = 2;
        vo_65499_0.quota_limit36 = 65535;
        vo_65499_0.must_vip36 = 0;
        vo_65499_0.is_gift36 = 0;
        vo_65499_0.follow_pet_type36 = 255;
        vo_65499_0.name37 = "无量心经";
        vo_65499_0.barcode37 = "R0003003";
        vo_65499_0.for_sale37 = 1;
        vo_65499_0.show_pos37 = 5;
        vo_65499_0.rpos37 = 0;
        vo_65499_0.sale_quota37 = 65535;
        vo_65499_0.recommend37 = 0;
        vo_65499_0.coin37 = 216;
        vo_65499_0.discount37 = 100;
        vo_65499_0.discountTime37 = 429496729;
        vo_65499_0.type37 = 3;
        vo_65499_0.quota_limit37 = 65535;
        vo_65499_0.must_vip37 = 0;
        vo_65499_0.is_gift37 = 0;
        vo_65499_0.follow_pet_type37 = 255;
        vo_65499_0.name38 = "宠物强化丹";
        vo_65499_0.barcode38 = "R0002013";
        vo_65499_0.for_sale38 = 2;
        vo_65499_0.show_pos38 = 14;
        vo_65499_0.rpos38 = 1;
        vo_65499_0.sale_quota38 = 65535;
        vo_65499_0.recommend38 = 3;
        vo_65499_0.coin38 = 216;
        vo_65499_0.discount38 = 100;
        vo_65499_0.discountTime38 = 429496729;
        vo_65499_0.type38 = 2;
        vo_65499_0.quota_limit38 = 65535;
        vo_65499_0.must_vip38 = 0;
        vo_65499_0.is_gift38 = 0;
        vo_65499_0.follow_pet_type38 = 255;
        vo_65499_0.name39 = "火眼金睛";
        vo_65499_0.barcode39 = "R0003006";
        vo_65499_0.for_sale39 = 2;
        vo_65499_0.show_pos39 = 8;
        vo_65499_0.rpos39 = 0;
        vo_65499_0.sale_quota39 = 65535;
        vo_65499_0.recommend39 = 0;
        vo_65499_0.coin39 = 216;
        vo_65499_0.discount39 = 100;
        vo_65499_0.discountTime39 = 429496729;
        vo_65499_0.type39 = 3;
        vo_65499_0.quota_limit39 = 65535;
        vo_65499_0.must_vip39 = 0;
        vo_65499_0.is_gift39 = 0;
        vo_65499_0.follow_pet_type39 = 255;
        vo_65499_0.name40 = "超级圣水晶";
        vo_65499_0.barcode40 = "R0002003";
        vo_65499_0.for_sale40 = 2;
        vo_65499_0.show_pos40 = 3;
        vo_65499_0.rpos40 = 0;
        vo_65499_0.sale_quota40 = 65535;
        vo_65499_0.recommend40 = 0;
        vo_65499_0.coin40 = 1000;
        vo_65499_0.discount40 = 100;
        vo_65499_0.discountTime40 = 429496729;
        vo_65499_0.type40 = 2;
        vo_65499_0.quota_limit40 = 65535;
        vo_65499_0.must_vip40 = 0;
        vo_65499_0.is_gift40 = 0;
        vo_65499_0.follow_pet_type40 = 255;
        vo_65499_0.name41 = "血玲珑";
        vo_65499_0.barcode41 = "R0003001";
        vo_65499_0.for_sale41 = 2;
        vo_65499_0.show_pos41 = 1;
        vo_65499_0.rpos41 = 0;
        vo_65499_0.sale_quota41 = 65535;
        vo_65499_0.recommend41 = 0;
        vo_65499_0.coin41 = 216;
        vo_65499_0.discount41 = 100;
        vo_65499_0.discountTime41 = 429496729;
        vo_65499_0.type41 = 3;
        vo_65499_0.quota_limit41 = 65535;
        vo_65499_0.must_vip41 = 0;
        vo_65499_0.is_gift41 = 0;
        vo_65499_0.follow_pet_type41 = 255;
        vo_65499_0.name42 = "星火昭·永久";
        vo_65499_0.barcode42 = "R0005030";
        vo_65499_0.for_sale42 = 1;
        vo_65499_0.show_pos42 = 15;
        vo_65499_0.rpos42 = 0;
        vo_65499_0.sale_quota42 = 65535;
        vo_65499_0.recommend42 = 0;
        vo_65499_0.coin42 = 26888;
        vo_65499_0.discount42 = 100;
        vo_65499_0.discountTime42 = 429496729;
        vo_65499_0.type42 = 4;
        vo_65499_0.quota_limit42 = 65535;
        vo_65499_0.must_vip42 = 0;
        vo_65499_0.is_gift42 = 0;
        vo_65499_0.follow_pet_type42 = 255;
        vo_65499_0.name43 = "吉祥天·30天";
        vo_65499_0.barcode43 = "R0005039";
        vo_65499_0.for_sale43 = 1;
        vo_65499_0.show_pos43 = 20;
        vo_65499_0.rpos43 = 0;
        vo_65499_0.sale_quota43 = 65535;
        vo_65499_0.recommend43 = 0;
        vo_65499_0.coin43 = 2888;
        vo_65499_0.discount43 = 100;
        vo_65499_0.discountTime43 = 429496729;
        vo_65499_0.type43 = 4;
        vo_65499_0.quota_limit43 = 65535;
        vo_65499_0.must_vip43 = 0;
        vo_65499_0.is_gift43 = 0;
        vo_65499_0.follow_pet_type43 = 1;
        vo_65499_0.name44 = "超级黑水晶";
        vo_65499_0.barcode44 = "R0002007";
        vo_65499_0.for_sale44 = 2;
        vo_65499_0.show_pos44 = 7;
        vo_65499_0.rpos44 = 0;
        vo_65499_0.sale_quota44 = 65535;
        vo_65499_0.recommend44 = 0;
        vo_65499_0.coin44 = 328;
        vo_65499_0.discount44 = 100;
        vo_65499_0.discountTime44 = 429496729;
        vo_65499_0.type44 = 2;
        vo_65499_0.quota_limit44 = 65535;
        vo_65499_0.must_vip44 = 0;
        vo_65499_0.is_gift44 = 0;
        vo_65499_0.follow_pet_type44 = 255;
        vo_65499_0.name45 = "黄水晶";
        vo_65499_0.barcode45 = "R0002002";
        vo_65499_0.for_sale45 = 2;
        vo_65499_0.show_pos45 = 2;
        vo_65499_0.rpos45 = 0;
        vo_65499_0.sale_quota45 = 65535;
        vo_65499_0.recommend45 = 0;
        vo_65499_0.coin45 = 418;
        vo_65499_0.discount45 = 100;
        vo_65499_0.discountTime45 = 429496729;
        vo_65499_0.type45 = 2;
        vo_65499_0.quota_limit45 = 65535;
        vo_65499_0.must_vip45 = 0;
        vo_65499_0.is_gift45 = 0;
        vo_65499_0.follow_pet_type45 = 255;
        vo_65499_0.name46 = "日耀辰辉·30天";
        vo_65499_0.barcode46 = "R0005025";
        vo_65499_0.for_sale46 = 1;
        vo_65499_0.show_pos46 = 10;
        vo_65499_0.rpos46 = 0;
        vo_65499_0.sale_quota46 = 65535;
        vo_65499_0.recommend46 = 0;
        vo_65499_0.coin46 = 2888;
        vo_65499_0.discount46 = 100;
        vo_65499_0.discountTime46 = 429496729;
        vo_65499_0.type46 = 4;
        vo_65499_0.quota_limit46 = 65535;
        vo_65499_0.must_vip46 = 0;
        vo_65499_0.is_gift46 = 0;
        vo_65499_0.follow_pet_type46 = 255;

        vo_65499_0.name47 = "超级绿水晶";
        vo_65499_0.barcode47 = "R0002001";
        vo_65499_0.for_sale47 = 2;
        vo_65499_0.show_pos47 = 1;
        vo_65499_0.rpos47 = 0;
        vo_65499_0.sale_quota47 = 65535;
        vo_65499_0.recommend47 = 0;
        vo_65499_0.coin47 = 1000;
        vo_65499_0.discount47 = 100;
        vo_65499_0.discountTime47 = 429496729;
        vo_65499_0.type47 = 2;
        vo_65499_0.quota_limit47 = 65535;
        vo_65499_0.must_vip47 = 0;
        vo_65499_0.is_gift47 = 0;
        vo_65499_0.follow_pet_type47 = 255;

        vo_65499_0.name48 = "情缘盒";
        vo_65499_0.barcode48 = "R0004002";
        vo_65499_0.for_sale48 = 1;
        vo_65499_0.show_pos48 = 2;
        vo_65499_0.rpos48 = 0;
        vo_65499_0.sale_quota48 = 65535;
        vo_65499_0.recommend48 = 0;
        vo_65499_0.coin48 = 108;
        vo_65499_0.discount48 = 100;
        vo_65499_0.discountTime48 = 429496729;
        vo_65499_0.type48 = 4;
        vo_65499_0.quota_limit48 = 65535;
        vo_65499_0.must_vip48 = 0;
        vo_65499_0.is_gift48 = 0;
        vo_65499_0.follow_pet_type48 = 255;
        vo_65499_0.name49 = "引天长歌·永久";
        vo_65499_0.barcode49 = "R0005033";
        vo_65499_0.for_sale49 = 1;
        vo_65499_0.show_pos49 = 25;
        vo_65499_0.rpos49 = 0;
        vo_65499_0.sale_quota49 = 65535;
        vo_65499_0.recommend49 = 0;
        vo_65499_0.coin49 = 26888;
        vo_65499_0.discount49 = 100;
        vo_65499_0.discountTime49 = 429496729;
        vo_65499_0.type49 = 4;
        vo_65499_0.quota_limit49 = 65535;
        vo_65499_0.must_vip49 = 0;
        vo_65499_0.is_gift49 = 0;
        vo_65499_0.follow_pet_type49 = 255;
        vo_65499_0.name50 = "钥匙串";
        vo_65499_0.barcode50 = "R0004004";
        vo_65499_0.for_sale50 = 1;
        vo_65499_0.show_pos50 = 4;
        vo_65499_0.rpos50 = 0;
        vo_65499_0.sale_quota50 = 65535;
        vo_65499_0.recommend50 = 0;
        vo_65499_0.coin50 = 108;
        vo_65499_0.discount50 = 100;
        vo_65499_0.discountTime50 = 429496729;
        vo_65499_0.type50 = 4;
        vo_65499_0.quota_limit50 = 65535;
        vo_65499_0.must_vip50 = 0;
        vo_65499_0.is_gift50 = 0;
        vo_65499_0.follow_pet_type50 = 255;
        vo_65499_0.name51 = "精怪诱饵";
        vo_65499_0.barcode51 = "R0002009";
        vo_65499_0.for_sale51 = 1;
        vo_65499_0.show_pos51 = 10;
        vo_65499_0.rpos51 = 6;
        vo_65499_0.sale_quota51 = 65535;
        vo_65499_0.recommend51 = 3;
        vo_65499_0.coin51 = 1000;
        vo_65499_0.discount51 = 100;
        vo_65499_0.discountTime51 = 429496729;
        vo_65499_0.type51 = 2;
        vo_65499_0.quota_limit51 = 65535;
        vo_65499_0.must_vip51 = 0;
        vo_65499_0.is_gift51 = 0;
        vo_65499_0.follow_pet_type51 = 255;
        vo_65499_0.name52 = "天神护佑";
        vo_65499_0.barcode52 = "R0003005";
        vo_65499_0.for_sale52 = 2;
        vo_65499_0.show_pos52 = 7;
        vo_65499_0.rpos52 = 0;
        vo_65499_0.sale_quota52 = 65535;
        vo_65499_0.recommend52 = 0;
        vo_65499_0.coin52 = 518;
        vo_65499_0.discount52 = 100;
        vo_65499_0.discountTime52 = 429496729;
        vo_65499_0.type52 = 3;
        vo_65499_0.quota_limit52 = 65535;
        vo_65499_0.must_vip52 = 0;
        vo_65499_0.is_gift52 = 0;
        vo_65499_0.follow_pet_type52 = 255;
        vo_65499_0.name53 = "超级神兽丹";
        vo_65499_0.barcode53 = "R0002017";
        vo_65499_0.for_sale53 = 2;
        vo_65499_0.show_pos53 = 19;
        vo_65499_0.rpos53 = 0;
        vo_65499_0.sale_quota53 = 65535;
        vo_65499_0.recommend53 = 0;
        vo_65499_0.coin53 = 108;
        vo_65499_0.discount53 = 100;
        vo_65499_0.discountTime53 = 429496729;
        vo_65499_0.type53 = 2;
        vo_65499_0.quota_limit53 = 65535;
        vo_65499_0.must_vip53 = 0;
        vo_65499_0.is_gift53 = 0;
        vo_65499_0.follow_pet_type53 = 255;
        vo_65499_0.name54 = "超级归元露";
        vo_65499_0.barcode54 = "R0002016";
        vo_65499_0.for_sale54 = 2;
        vo_65499_0.show_pos54 = 18;
        vo_65499_0.rpos54 = 0;
        vo_65499_0.sale_quota54 = 65535;
        vo_65499_0.recommend54 = 0;
        vo_65499_0.coin54 = 216;
        vo_65499_0.discount54 = 100;
        vo_65499_0.discountTime54 = 429496729;
        vo_65499_0.type54 = 2;
        vo_65499_0.quota_limit54 = 65535;
        vo_65499_0.must_vip54 = 0;
        vo_65499_0.is_gift54 = 0;
        vo_65499_0.follow_pet_type54 = 255;
        vo_65499_0.name55 = "急急如律令";
        vo_65499_0.barcode55 = "R0003004";
        vo_65499_0.for_sale55 = 2;
        vo_65499_0.show_pos55 = 6;
        vo_65499_0.rpos55 = 0;
        vo_65499_0.sale_quota55 = 65535;
        vo_65499_0.recommend55 = 0;
        vo_65499_0.coin55 = 328;
        vo_65499_0.discount55 = 100;
        vo_65499_0.discountTime55 = 429496729;
        vo_65499_0.type55 = 3;
        vo_65499_0.quota_limit55 = 65535;
        vo_65499_0.must_vip55 = 0;
        vo_65499_0.is_gift55 = 0;
        vo_65499_0.follow_pet_type55 = 255;
        vo_65499_0.name56 = "易经洗髓丹";
        vo_65499_0.barcode56 = "R0005013";
        vo_65499_0.for_sale56 = 2;
        vo_65499_0.show_pos56 = 5;
        vo_65499_0.rpos56 = 0;
        vo_65499_0.sale_quota56 = 65535;
        vo_65499_0.recommend56 = 0;
        vo_65499_0.coin56 = 216;
        vo_65499_0.discount56 = 100;
        vo_65499_0.discountTime56 = 429496729;
        vo_65499_0.type56 = 4;
        vo_65499_0.quota_limit56 = 65535;
        vo_65499_0.must_vip56 = 0;
        vo_65499_0.is_gift56 = 0;
        vo_65499_0.follow_pet_type56 = 255;
        return vo_65499_0;
    }

    public static Vo_53267_0 a53267() {
        Vo_53267_0 vo_53267_0 = new Vo_53267_0();
        vo_53267_0.count = 6;
        vo_53267_0.barcode0 = "C0000004";
        vo_53267_0.sale_quota0 = 1;
        vo_53267_0.toMoney0 = 30000000;
        vo_53267_0.costCoin0 = 3300;
        vo_53267_0.barcode1 = "C0000001";
        vo_53267_0.sale_quota1 = 1;
        vo_53267_0.toMoney1 = 3000000;
        vo_53267_0.costCoin1 = 300;
        vo_53267_0.barcode2 = "C0000005";
        vo_53267_0.sale_quota2 = 1;
        vo_53267_0.toMoney2 = 60000000;
        vo_53267_0.costCoin2 = 7200;
        vo_53267_0.barcode3 = "C0000006";
        vo_53267_0.sale_quota3 = 1;
        vo_53267_0.toMoney3 = 100000000;
        vo_53267_0.costCoin3 = 12000;
        vo_53267_0.barcode4 = "C0000003";
        vo_53267_0.sale_quota4 = 1;
        vo_53267_0.toMoney4 = 10000000;
        vo_53267_0.costCoin4 = 1100;
        vo_53267_0.barcode5 = "C0000002";
        vo_53267_0.sale_quota5 = 1;
        vo_53267_0.toMoney5 = 6000000;
        vo_53267_0.costCoin5 = 600;

        return vo_53267_0;
    }

    public static void a49171(Chara chara) {
        List<Vo_49171_0> list = new LinkedList<>();

        List<String[]> strings = NoviceGiftBagUtils.giftBag(chara.sex, chara.menpai);
        for (int i = 0; i < strings.size(); i++) {
            Vo_49171_0 vo_49171_0 = new Vo_49171_0();
            vo_49171_0.isGot = chara.xinshoulibao[i];
            vo_49171_0.limitLevel = (i + 1) * 10;
            for (int j = 0; j < strings.get(i).length; j++) {
                Vo_49171_0 vo = new Vo_49171_0();
                String s = strings.get(i)[j];
                String[] split = s.split("\\#");
                vo.name = split[0];
                if (split[0].equals("代金券")) {
                    vo.number = Integer.parseInt(split[1]);
                } else {
                    vo.number = 1;
                }
                vo.limitLevel = 429496729;
                vo_49171_0.vo491710s.add(vo);
            }
            list.add(vo_49171_0);
        }
        GameObjectChar.send(new M49171_0(), list);
    }


    public static void huodechoujiang(String[] strings, Chara chara) {
        if (strings[1].equals("宝宝")) {
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 2);
            List<Petbeibao> list = new ArrayList<>();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = "你获得了#R" + pet.getName() + "#n宠物";
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);
        }
        if (strings[1].equals("经验")) {
            huodejingyan(chara, Integer.valueOf(strings[0]));
        }
        if (strings[1].equals("精怪")) {
            int jieshu = stageMounts(strings[0]);
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 2);
            List<Petbeibao> list = new ArrayList<>();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            petbeibao.petShuXing.get(0).enchant_nimbus = 0;
            petbeibao.petShuXing.get(0).max_enchant_nimbus = 0;
            petbeibao.petShuXing.get(0).suit_light_effect = 1;
            petbeibao.petShuXing.get(0).hide_mount = jieshu;
            PetShuXing shuXing = new PetShuXing();
            shuXing.no = 23;
            shuXing.type1 = 2;
            shuXing.accurate = 4 * (jieshu - 1);
            shuXing.mana = 4 * (jieshu - 1);
            shuXing.wiz = 3 * (jieshu - 1);
            shuXing.all_polar = 0;
            shuXing.upgrade_magic = 0;
            shuXing.upgrade_total = 0;
            petbeibao.petShuXing.add(shuXing);
            GameObjectChar.send(new M65507_0(), list);
        }
        if (strings[1].equals("变异")) {
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 3);
            List<Petbeibao> list = new ArrayList<>();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);
        }
        if (strings[1].equals("物品")) {
            StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(strings[0]);
            GameUtil.huodedaoju(chara, info, 1);
        }
        if (strings[1].equals("首饰")) {
            ZhuangbeiInfo oneByStr = GameData.that.baseZhuangbeiInfoService.findOneByStr(strings[0]);
            GameUtil.huodezhuangbei(chara, oneByStr, 0, 1);
            strings[0] = "60级首饰";
        }
        if (strings[0].equals("代金券")) {
            chara.use_money_type = chara.use_money_type + Integer.valueOf(strings[1]);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
        }
        if (strings[1].equals("金币")) {
            chara.balance = chara.balance + Integer.valueOf(strings[0]);
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
        }

        if (strings[1].equals("装备")) {

            ZhuangbeiInfo zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByStr(strings[0]);
            List<Hashtable<String, Integer>> hashtables = NoviceGiftBagUtils.equipmentGiftBags(zhuangbeiInfo.getAmount(), zhuangbeiInfo.getAttrib());
            if (hashtables.size() > 0) {
                GoodsLanSe gooodsLanSe = new GoodsLanSe();
                GoodsGaiZao goodsGaiZao = new GoodsGaiZao();
                GoodsFenSe goodsFenSe = new GoodsFenSe();
                GoodsHuangSe goodsHuangSe = new GoodsHuangSe();
                int gaizao = 0;
                for (Hashtable<String, Integer> maps : hashtables) {
                    if (maps.get("groupNo") == 2) {
                        maps.put("groupType", 2);
                        gooodsLanSe = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLanSe.class);
                    }
                    if (maps.get("groupNo") == 3) {
                        maps.put("groupType", 2);
                        goodsFenSe = (GoodsFenSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsFenSe.class);
                    }
                    if (maps.get("groupNo") == 4) {
                        maps.put("groupType", 2);
                        goodsHuangSe = (GoodsHuangSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsHuangSe.class);
                    }
                    if (maps.get("groupNo") == 10) {
                        gaizao = maps.get("changeNum");
                        maps.remove("changeNum");
                        maps.put("groupType", 2);
                        goodsGaiZao = (GoodsGaiZao) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsGaiZao.class);
                    }
                }
                Goods goods = new Goods();
                goods.pos = GameUtil.beibaoweizhi(chara);
                if (goods.pos == 0) {
                    return;
                }
                goods.goodsInfo = new GoodsInfo();
                goods.goodsBasics = new GoodsBasics();
                goods.goodsLanSe = gooodsLanSe;
                goods.goodsGaiZao = goodsGaiZao;
                goods.goodsFenSe = goodsFenSe;
                goods.goodsHuangSe = goodsHuangSe;
                goods.goodsCreate(zhuangbeiInfo);
                goods.goodsInfo.owner_id = 1;
                goods.goodsInfo.degree_32 = 0;
                goods.goodsInfo.color = gaizao;
                chara.backpack.add(goods);
                GameObjectChar.send(new M65525_0(), chara.backpack);
            }
        }
    }


    private static int stageMounts(String name) {
        int[] mounts_stage = {2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 8, 8};
        String[] mounts_name = {"仙阳剑", "凌岩豹", "幻鹿", "赤焰葫芦", "玉豹", "仙葫芦", "无极熊", "岳麓剑", "古鹿", "北极熊", "筋斗云", "太极熊", "墨麒麟"};
        for (int i = 0; i < mounts_name.length; i++) {
            if (mounts_name[i].equalsIgnoreCase(name)) {
                return mounts_stage[i];
            }
        }
        return 0;

    }

    /**
     * 装备 抽奖
     *
     * @param eq_attrib 人物等级对应抽取等级装备
     * @return
     */
    public static List<Hashtable<String, Integer>> equipmentLuckDraw(int eq_attrib, int leixing) {
        if (eq_attrib < 70) {
            eq_attrib = 70;
        } else {
            eq_attrib = eq_attrib / 10 * 10;
        }
        List<Hashtable<String, Integer>> hashtables = ForgingEquipmentUtils.appraisalEquipment(leixing, eq_attrib, ForgingEquipmentUtils.EQUIPMENT_LUCK_DRAW);

        String[] rareAttributes = {"all_resist_except", "all_resist_polar", "all_polar", "all_skill", "ignore_all_resist_except", "mstunt_rate", "release_forgotten"};
        for (Hashtable<String, Integer> hashtable : hashtables) {
            for (String key : rareAttributes) {
                if (hashtable.contains(key)) {
                    Random random = new Random();
                    
                    String[] replaceAttributes = {"mag_power", "phy_power", "speed", "life"};
                    List<Hashtable<String, Integer>> appraisalList = new ArrayList<>();
                    Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
                    key_vlaue_tab.put("groupNo", 2);
                    key_vlaue_tab.put(replaceAttributes[random.nextInt(4)], eq_attrib / 4);
                    appraisalList.add(key_vlaue_tab);
                    return appraisalList;
                }
            }
        }

        return hashtables;
    }

    public static String zhuangbname(Chara chara, int leixing) {
        int eq_attrib = 0;
        if (chara.level < 70) {
            eq_attrib = 70;
        } else {
            eq_attrib = chara.level / 10 * 10;
        }
        List<ZhuangbeiInfo> byAttrib = GameData.that.baseZhuangbeiInfoService.findByAttrib(eq_attrib);
        for (int j = 0; j < byAttrib.size(); j++) {
            if (leixing == 1) {
                if (byAttrib.get(j).getMetal() == chara.menpai && byAttrib.get(j).getAmount() == leixing) {
                    return byAttrib.get(j).getStr();
                }
            }
            if (leixing == 2 || leixing == 3) {
                if (byAttrib.get(j).getMaster() == chara.sex && byAttrib.get(j).getAmount() == leixing) {
                    return byAttrib.get(j).getStr();
                }
            }
            if (leixing == 10) {
                if (byAttrib.get(j).getAmount() == leixing) {
                    return byAttrib.get(j).getStr();
                }
            }
        }
        return "";
    }

    public static void a45060(Chara chara) {
        Vo_45060_0 vo_45060_0 = new Vo_45060_0();
        vo_45060_0.hasBonus = 0;
        vo_45060_0.xy_higest = 649;
        vo_45060_0.fm_higest = 496;
        vo_45060_0.fx_higest = 0;
        vo_45060_0.off_line_time = 2276;
        vo_45060_0.buy_one = 50;
        vo_45060_0.buy_five = 350;
        vo_45060_0.buy_time = 0;
        vo_45060_0.max_buy_time = 4;
        vo_45060_0.offlineStatus = 0;
        vo_45060_0.max_turn = 0;
        vo_45060_0.lastTaskName = "降妖";
        vo_45060_0.max_double = 440;
        vo_45060_0.max_jiji = 110;
        vo_45060_0.jijiStatus = 0;
        vo_45060_0.chongfengsan_time = 0;
        vo_45060_0.max_chongfengsan_time = 3;
        vo_45060_0.ziqihongmeng_time = 0;
        vo_45060_0.max_ziqihongmeng_time = 1;
        vo_45060_0.max_chongfengsan = 440;
        vo_45060_0.chongfengsan_status = chara.chongfengsan;
        vo_45060_0.max_ziqihongmeng = 440;
        vo_45060_0.ziqihongmeng_status = chara.ziqihongmeng;
        vo_45060_0.hasDaofaBonus = 0;
        vo_45060_0.count = 3;
        vo_45060_0.taskName = "降妖";
        vo_45060_0.taskTime = 9;
        vo_45060_0.taskName1 = "伏魔";
        vo_45060_0.taskTime1 = 3;
        vo_45060_0.taskName2 = "飞仙渡邪";
        vo_45060_0.taskTime2 = 1;
        GameObjectChar.send(new M45060_0(), vo_45060_0);
    }

}
