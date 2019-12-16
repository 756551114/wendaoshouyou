package org.linlinjava.litemall.gameserver.domain;

import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Chara implements Serializable {

    public int allId;





    public List<Goods> cangku = new LinkedList<>();

    public List<Goods> shizhuang = new LinkedList<>();
    public List<Goods> texiao = new LinkedList<>();
    public List<Goods> genchong = new LinkedList<>();

    public List<Goods> backpack = new LinkedList<>();


    public ZbAttribute zbAttribute = new ZbAttribute();
    public List<Petbeibao> pets = new LinkedList<>();
    public List<ShouHu> listshouhu = new LinkedList<>();
    public List<JiNeng> jiNengList = new LinkedList<>();


    public List<Vo_41480_0> shenmiliwu = new LinkedList<>();
    public int chongzhijifen;


    public Chara() {

    }

    public void waiguan() {
        if (menpai == 1 && sex == 1) {
            this.waiguan = 6001;
        }
        if (menpai == 2 && sex == 1) {
            this.waiguan = 7002;
        }
        if (menpai == 3 && sex == 1) {
            this.waiguan = 7003;
        }
        if (menpai == 4 && sex == 1) {
            this.waiguan = 6004;
        }
        if (menpai == 5 && sex == 1) {
            this.waiguan = 6005;
        }
        if (menpai == 1 && sex == 2) {
            this.waiguan = 7001;
        }
        if (menpai == 2 && sex == 2) {
            this.waiguan = 6002;
        }
        if (menpai == 3 && sex == 2) {
            this.waiguan = 6003;
        }
        if (menpai == 4 && sex == 2) {
            this.waiguan = 7004;
        }
        if (menpai == 5 && sex == 2) {
            this.waiguan = 7005;
        }
    }

    public Chara(String name, int sex, int menpai, String uuid) {


        Vo_41480_0 vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 1;
        vo_41480_0.time = 300;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 2;
        vo_41480_0.time = 900;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 3;
        vo_41480_0.time = 1800;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 4;
        vo_41480_0.time = 3000;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 5;
        vo_41480_0.time = 4800;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 6;
        vo_41480_0.time = 7200;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 7;
        vo_41480_0.time = 10200;
        shenmiliwu.add(vo_41480_0);
        vo_41480_0 = new Vo_41480_0();
        vo_41480_0.index = 8;
        vo_41480_0.time = 13800;
        shenmiliwu.add(vo_41480_0);


        this.name = name;
        this.menpai = menpai;
        this.level = 1;
        this.mapid = 1000;
        this.mapName = "揽仙镇";
        this.chenhao = "";
        this.exp = 0;
        this.uuid = uuid;
        this.sex = sex;

        this.line = 1;
        waiguan();
        current_task = "主线—浮生若梦_s1";
        x = 22;
        y = 108;


        phy_power = 1;
        speed = 1;
        life = 1;
        mag_power = 1;
        accurate = 45;
        def = 105;
        wiz = 45;
        mana = 45;
        dex = 84;
        parry = 50;
        pot = 0;
        resist_poison = 517;

        use_skill_d = 300;


        max_life = 159;

        resist_metal = 0;
        wood = 0;
        water = 0;
        fire = 0;
        earth = 0;
        polar_point = 0;
        stamina = 0;

        
        extra_mana = 1000000;
        have_coin_pwd = 1000000;


        use_money_type = 0;

        
        gold_coin = 150000;

        
        extra_life = 99999999;

        
        balance = 10000000;

        lock_exp = 0;

        cash = 200000000;

        chubao = 1;

    }


    public int id;
    
    public int x;
    
    public int y;
    
    public int mapid;
    
    public String mapName;
    
    public int level;
    
    public String name;
    
    public String chenhao;
    
    public int menpai;

    
    public int tizhi = 1;
    
    public int lingli = 1;
    
    public long exp;
    
    public int sex;
    
    public int line;
    
    public String uuid;
    
    public int waiguan;
    
    public String current_task;
    
    public int phy_power;
    
    public int life;
    
    public int speed;
    
    public int mag_power;
    
    public int accurate;
    
    public int def;
    
    public int dex;
    
    public int wiz;
    
    public int mana;
    
    public int parry;
    
    public int pot;
    
    public int resist_poison;
    
    public int extra_mana;
    
    public int have_coin_pwd;
    
    public int use_skill_d;

    
    public int resist_metal;
    
    public int wood;
    
    public int water;
    
    public int fire;
    
    public int earth;
    
    public int polar_point;
    
    public int stamina;
    
    public int max_life;
    
    public int max_mana;
    
    public int use_money_type;
    
    public int shadow_self = 8888;

    
    public int weapon_icon;

    
    public int gold_coin;
    
    public int extra_life;

    
    public int balance;

    
    public int jishou_coin;

    
    public int lock_exp;

    
    public int chongwuchanzhanId;


    
    public int cash;

    
    public long uptime;

    
    public long updatetime;

    
    public long online_time;

    
    public int signDays = 0;
    
    public int isCanSgin = 1;

    public int gender;


    public int canzhanshouhunumber = 0;

    
    public int zuoqiwaiguan = 0;
    
    public int zuoqiId = 0;
    
    public int yidongsudu = 0;
    
    public int zuowaiguan = 0;

    
    public int special_icon = 0;

    
    public int texiao_icon = 0;
    
    public int genchong_icon = 0;

    
    public int vipType;
    
    public int isGet;
    
    public int vipTime;
    
    public int vipTimeShengYu;

    
    public int suit_icon;
    
    public int suit_light_effect;

    
    public int wuxingBalance;
    
    public int enable_double_points;
    
    public int enable_shenmu_points;
    
    public int extra_skill;
    
    public int chushi_ex;
    
    public int fetch_nice;
    
    public int shuadaochongfeng_san;

    public int[] xinshoulibao = {0, 0, 0, 0, 0, 0, 0, 0};


    

    public List<Vo_65529_0> npcshuadao = new LinkedList<>();
    
    public int shuadao = 1;
    
    public int chubao;
    
    public List<Vo_65529_0> npcchubao = new LinkedList<>();
    
    public int baibangmang = 0;
    
    public int shimencishu = 1;
    
    public String npcName = "";
    
    public int fabaorenwu = 0;
    
    public int xiuxingcishu = 1;
    
    public String xiuxingNpcname = "";
    
    public int xuanshangcishu = 0;
    
    public List<Vo_65529_0> npcxuanshang = new LinkedList<>();
    
    public String npcXuanShangName = "";


    
    public Vo_65529_0 changbaotu = new Vo_65529_0();


    
    public int autofight_select = 0;
    public int autofight_skillaction = 2;
    public int autofight_skillno = 2;

    
    public int friend;
    
    public int owner_name;

    
    public Map<String, String> chenghao = new HashMap<>();

    
    public int qumoxiang = 0;
    
    public int charashuangbei = 0;
    
    public int shenmoding = 0;
    
    public int ziqihongmeng = 0;
    
    public int chongfengsan = 0;


    
    public int shidaodaguaijifen = 0;
    
    public int shidaocishu = 0;


}
