package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.*;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.game.GameCore;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class C4192_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {


        String char_name = GameReadTool.readString(buff);
        final GameObjectChar session = GameObjectChar.getGameObjectChar();

        if (session.chara == null) {
            final List<Characters> charactersList = GameData.that.characterService.findByAccountId(session.accountid);
            Characters characters = null;
            for (Characters tcharacters : charactersList) {
                if (tcharacters.getName().equals(char_name)) {
                    characters = tcharacters;
                }
            }
            if (characters == null) {
                ctx.disconnect();
                return;
            }
            final GameObjectChar oldSession = GameObjectCharMng.getGameObjectChar(characters.getId());
            if (oldSession != null) {
                characters = oldSession.characters;
                GameObjectCharMng.save(oldSession);
            }
            session.init(characters);
        }


        Chara chara = session.chara;

//        ShowTasks tasks = baseShowTasksService.findOneByTasktaskState(chara.current_task);


        chara.uptime = System.currentTimeMillis();
        Date date = new Date(chara.updatetime);
        boolean isnow = GameUtil.isNow(date);
        if (!isnow) {
            chara.isGet = 0;
            chara.isCanSgin = 1;
            chara.online_time = 0;
            chara.npcshuadao = new LinkedList<>();
            //除暴进度
            chara.shuadao = 1;
            //除暴进度
            chara.chubao = 1;
            //除暴
            chara.npcchubao = new LinkedList<>();
            //助人为乐
            chara.baibangmang = 0;
            //师门次数
            chara.shimencishu = 1;
            //师门提交任务NPC
            chara.npcName = "";
            //法宝任务
            chara.fabaorenwu = 0;
            //修行次数
            chara.xiuxingcishu = 1;
            //修行NPCname；
            chara.xiuxingNpcname = "";
            //悬赏任务
            chara.xuanshangcishu = 0;
            //悬赏怪物
            chara.npcxuanshang = new LinkedList<>();
            //悬赏怪物名字
            chara.npcXuanShangName = "";
            for (int i = 0; i < chara.shenmiliwu.size(); i++) {
                chara.shenmiliwu.get(i).online_time = 0;
                chara.shenmiliwu.get(i).name = "";
                chara.shenmiliwu.get(i).brate = 0;
            }
        }


        //server_type
        Vo_45277_0 vo_45277_0 = new Vo_45277_0();
        vo_45277_0.server_type = 0;
        GameObjectChar.send(new M45277_0(), vo_45277_0);

        Vo_41009_0 vo_41009_0 = new Vo_41009_0();
        vo_41009_0.server_time = (int) (System.currentTimeMillis() / 1000);
        vo_41009_0.time_zone = 8;
        GameObjectChar.send(new M41009_0(), vo_41009_0);

        Vo_4099_0 vo_4099_0 = new Vo_4099_0();
        vo_4099_0.name = char_name;
        vo_4099_0.para = char_name + "是第 7 次登录";
        vo_4099_0.gid = chara.uuid;
        GameObjectChar.send(new M4099_0(), vo_4099_0);


        //65527 更新啥子玩意一堆；
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

        GameObjectChar.send(new M45388_0(), null);


        GameUtil.a65511(chara);


        Vo_41023_0 vo_41023_0 = new Vo_41023_0();
        vo_41023_0.taskName = "拜师任务";
        vo_41023_0.status = 1;
        GameObjectChar.send(new M41023_0(), vo_41023_0);


        for (int i = 0; i < chara.pets.size(); i++) {
            List list = new ArrayList();
            list.add(chara.pets.get(i));
            GameObjectChar.send(new M65507_0(), list);
            GameObjectChar.send(new M12023_0(), chara.pets.get(i).tianshu);
            boolean isfagong = chara.pets.get(i).petShuXing.get(0).rank > chara.pets.get(i).petShuXing.get(0).pet_mag_shape;
            GameUtil.dujineng(1, chara.pets.get(i).petShuXing.get(0).metal, chara.pets.get(i).petShuXing.get(0).skill, isfagong, chara.pets.get(i).id, chara);
        }


        Vo_4163_0 vo_4163_0 = new Vo_4163_0();
        vo_4163_0.id = chara.chongwuchanzhanId;
        vo_4163_0.b = 1;
        GameObjectChar.send(new M4163_0(), vo_4163_0);


        Vo_8425_0 vo_8425_0 = new Vo_8425_0();
        vo_8425_0.id = chara.zuoqiId;
        GameObjectChar.send(new M8425_0(), vo_8425_0);

        GameUtil.addVip(chara);


        //固定数据不知道啥用
        GameObjectChar.send(new M41017_0(), null);


        Vo_53399_0 vo_53399_0 = new Vo_53399_0();
        vo_53399_0.value = "10011011111";
        GameObjectChar.send(new M53399_0(), vo_53399_0);

        Vo_53521_0 vo_53521_0 = new Vo_53521_0();
        vo_53521_0.chushiLevel = 90;
        GameObjectChar.send(new M53521_0(), vo_53521_0);

        Vo_33055_0 vo_33055_0 = new Vo_33055_0();
        vo_33055_0.is_enable = 1;
        vo_33055_0.enable_gold_stall_cash = 0;
        vo_33055_0.sell_cash_aft_days = 7;
        vo_33055_0.start_gold_stall_cash = 0;
        vo_33055_0.enable_appoint = 0;
        vo_33055_0.enable_autcion = 0;
        vo_33055_0.close_time = 1536181200;
        GameObjectChar.send(new M33055_0(), vo_33055_0);




        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 61001;
        vo_9129_0.para = "1";
        GameObjectChar.send(new M9129_0(), vo_9129_0);
        vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 50017;
        vo_9129_0.para = "0";
        GameObjectChar.send(new M9129_0(), vo_9129_0);


        vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 20002;
        vo_9129_0.para = "0000FFFF060FFDFF";
        GameObjectChar.send(new M9129_0(), vo_9129_0);
        vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 39;
        vo_9129_0.para = "";
        GameObjectChar.send(new M9129_0(), vo_9129_0);
        vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 10012;
        vo_9129_0.para = "";
        GameObjectChar.send(new M9129_0(), vo_9129_0);

        vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 20010;
        vo_9129_0.para = String.valueOf(chara.qumoxiang);
        GameObjectChar.send(new M9129_0(), vo_9129_0);


        //装备
        GameObjectChar.send(new M65525_0(), chara.backpack);


        session.gameMap.join(session);


        GameUtil.a65511(chara);

        //        拥有的守护

        GameObjectChar.send(new M12016_0(), chara.listshouhu);

        for (int i = 0; i < chara.listshouhu.size(); i++) {
            ShouHu shouHu = chara.listshouhu.get(i);
            GameUtil.dujineng(2, shouHu.listShouHuShuXing.get(0).metal, shouHu.listShouHuShuXing.get(0).skill, true, shouHu.id, chara);
        }




        Vo_36889_0 vo_36889_0 = new Vo_36889_0();
        vo_36889_0.count = 2;
        vo_36889_0.id = chara.id;
        vo_36889_0.auto_select = 1;
        vo_36889_0.multi_index = 0;
        vo_36889_0.action = 2;
        vo_36889_0.para = 0;
        vo_36889_0.multi_count = 0;
        GameObjectChar.send(new M36889_0(), vo_36889_0);


//福利页面显示
        GameUtil.a49159(chara);


        //摆摊的数据
        List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByOwnerUuid(chara.uuid);
        Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
        GameObjectChar.send(new M49179_0(), vo_49179_0);


        Vo_12269_0 vo_12269_0 = new Vo_12269_0();
        vo_12269_0.id = chara.id;
        vo_12269_0.owner_id = 96780;
        GameObjectChar.send(new M12269_0(), vo_12269_0);


        //设置
        Vo_61589_0 vo_61589_0 = GameUtil.a61589();
        GameObjectChar.send(new M61589_0(), vo_61589_0);


        //指令界面显示
        Vo_40965_0 vo_40965_0 = new Vo_40965_0();
        vo_40965_0.guideId = 3;
        GameObjectChar.send(new M40965_0(), vo_40965_0);


        Renwu tasks = GameData.that.baseRenwuService.findOneByCurrentTask(chara.current_task);
        Vo_61553_0 vo_61553_0 = GameUtil.a61553(tasks, chara);
        GameObjectChar.send(new M61553_0(), vo_61553_0);


        Vo_53925_0 vo_53925_0 = new Vo_53925_0();
        vo_53925_0.isOffical = 1;
        GameObjectChar.send(new M53925_0(), vo_53925_0);


        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);

        List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
        GameObjectChar.send(new M32747_0(), vo_32747_0List);

        //自动战斗配置；
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
        GameUtil.genchongfei(chara);


        GameObjectChar.send(new M61663(), GameCore.that.getGameLineAll());


        if (!chara.npcName.equals("")) {
            Vo_61553_0 vo_61553_10 = new Vo_61553_0();
            vo_61553_10.count = 1;
            vo_61553_10.task_type = "sm-002";
            vo_61553_10.task_desc = "接受门派师尊交办的一些事情，完成后会获得嘉奖。";
            vo_61553_10.task_prompt = "拜访#P" + chara.npcName + "|M=【师门】入世#P";
            vo_61553_10.refresh = 0;
            vo_61553_10.task_end_time = 1567932239;
            vo_61553_10.attrib = 0;
            vo_61553_10.reward = "#I经验|人物经验宠物经验#I#I金钱|金钱#I";
            vo_61553_10.show_name = "师门—入世(" + chara.shimencishu + "/10)";
            vo_61553_10.tasktask_extra_para = "";
            vo_61553_10.tasktask_state = "1";
            GameObjectChar.send(new M61553_0(), vo_61553_10);
        }


//        if (!chara.npcXuanShangName.equals("")) {
//            String task_type = "悬赏祍务";
//            String task_prompt = "捉拿逃窜的#P仙界叛逆|" + chara.npcxuanshang.get(0).gather_count.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")|M=追拿通缉犯|$0#P（建议组队）";
////                                                       "捉拿#P" + name + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")|M=就是来抓你的|$0#P";                                                                                                                                                 |M=今天我要为民除害|$0#P
//            String show_name = "悬赏祍务";
//            GameUtilRenWu.renwukuangkuang(task_type, task_prompt, show_name, chara1);
//        }

        if (chara.fabaorenwu == 1) {
            Vo_61553_0 vo_61553_10 = new Vo_61553_0();
            vo_61553_10.count = 1;
            vo_61553_10.task_type = "法宝任务";
            vo_61553_10.task_desc = "为获得强大的法宝而接受重重考验的任务。";
            vo_61553_10.task_prompt = "找#P龙王#P求取法宝";
            vo_61553_10.refresh = 0;
            vo_61553_10.task_end_time = 1567932239;
            vo_61553_10.attrib = 0;
            vo_61553_10.reward = "#I法宝|随机法宝=F$1$6#I";
            vo_61553_10.show_name = "法宝任务";
            vo_61553_10.tasktask_extra_para = "";
            vo_61553_10.tasktask_state = "1";
            GameObjectChar.send(new M61553_0(), vo_61553_10);
        }


        //读现有称号
        GameUtil.chenghaoxiaoxi(chara);

        if (session.gameTeam != null && session.gameTeam.duiwu != null && session.gameTeam.duiwu.size() > 0) {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = session.gameTeam.duiwu.get(0).id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            session.send(new M61671_0(), vo_61671_0);
            for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                if (session.gameTeam.duiwu.get(i).id == chara.id && session.gameTeam.duiwu.get(0).id != chara.id) {
                    vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = session.chara.id;
                    vo_61671_0.count = 2;
                    vo_61671_0.list.add(2);
                    vo_61671_0.list.add(5);
                    session.send(new M61671_0(), vo_61671_0);
                }
            }
            List<Chara> charas = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
            GameUtil.a4119(charas);
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
        }

        if (chara.changbaotu.mapid != 0) {
            vo_61553_0 = new Vo_61553_0();
            vo_61553_0.count = 1;
            vo_61553_0.task_type = "超级宝藏";
            vo_61553_0.task_desc = "在游戏中根据超级藏宝图进行寻宝。";
            vo_61553_0.task_prompt = "#前往#Z" + chara.changbaotu.name + "|" + chara.changbaotu.name + "(" + chara.changbaotu.x + "," + chara.changbaotu.y + ")#Z寻宝";
            vo_61553_0.refresh = 1;
            vo_61553_0.task_end_time = 1567909190;
            vo_61553_0.attrib = 1;
            vo_61553_0.reward = "#I道行|道行#I#I潜能|潜能#I#I金钱|金钱#I#I物品|召唤令·十二生肖#I#I宠物|十二生肖=F#I";
            vo_61553_0.show_name = "超级宝藏";
            vo_61553_0.tasktask_extra_para = "";
            vo_61553_0.tasktask_state = "1";
            GameObjectChar.getGameObjectChar().send(new M61553_0(), vo_61553_0);
        }


        final Vo_4321_0 vo_4321_0 = new Vo_4321_0();
        vo_4321_0.dist = "一战功成";
        vo_4321_0.b = 0;
        vo_4321_0.flag = 1;
        vo_4321_0.a = GameCore.getGameLine(chara.line).lineNum;
        vo_4321_0.name = GameCore.getGameLine(chara.line).lineName;
        vo_4321_0.time = (int) (System.currentTimeMillis() / 1000);
        vo_4321_0.c = 8;
        GameObjectChar.send(new M4321_0(), vo_4321_0);

        FightManager.reconnect(chara);
    }

    @Override
    public int cmd() {
        return 4192;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        final String value = String.valueOf("多闻道人");
        final byte[] bs = value.getBytes("GBK");
        final String s = bytesToHexString(bs);
        System.out.println(s);
//        final byte[] bytes = hexToByteArray(value);
//        for (int i = 0; i < bytes.length; i++) {
//            byte aByte = bytes[i];
//            System.out.print(aByte + " ");
//
//        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }


}