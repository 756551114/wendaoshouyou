package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.PetAndHelpSkillUtils;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32747_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.data.write.M32747_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C8308_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);

        int skill_no = GameReadTool.readShort(buff);

        int up_level = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        JiNeng sjjiNeng = new JiNeng();
        for (JiNeng jiNeng : chara.jiNengList) {
            if (jiNeng.skill_no == skill_no) {
                sjjiNeng = jiNeng;
            }
        }
        if (sjjiNeng.skill_no == 0) {
            PetAndHelpSkillUtils petAndHelpSkillUtils = new PetAndHelpSkillUtils();
            int levelUp = up_level;
            int cash = 0;
            if (sjjiNeng.skill_level + up_level > sjjiNeng.skill_attrib) {
                up_level = sjjiNeng.skill_attrib - sjjiNeng.skill_level;
            }
            for (int i = 0; i < levelUp; i++) {
                int[] blueAndPointsLan = petAndHelpSkillUtils.getBlueAndPointsLan(skill_no, sjjiNeng.skill_level + i);
                cash += blueAndPointsLan[1];
            }
            if (cash > chara.cash && skill_no != 302 && skill_no != 301) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "潜能不足，无法学习该技能";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            sjjiNeng.skill_no = skill_no;
            JSONObject jsonObject = PetAndHelpSkillUtils.jsonArray(skill_no);
            sjjiNeng.skill_attrib1 = Integer.parseInt((String) jsonObject.get("skill_attrib"));
            sjjiNeng.skill_attrib = PetAndHelpSkillUtils.getMaxSkill(chara.level);
            sjjiNeng.skill_level = 0 + levelUp;
            int[] blueAndPointsLan = petAndHelpSkillUtils.getBlueAndPointsLan(skill_no, sjjiNeng.skill_level);
            sjjiNeng.level_improved = 0;
            sjjiNeng.skill_mana_cost = blueAndPointsLan[0];
            sjjiNeng.skill_nimbus = 42949672;
            sjjiNeng.skill_disabled = 0;
            sjjiNeng.range = petAndHelpSkillUtils.skillNummax(skill_no, sjjiNeng.skill_level);
            sjjiNeng.max_range = petAndHelpSkillUtils.skillNummax(skill_no, sjjiNeng.skill_attrib);
            int[] ints = petAndHelpSkillUtils.skillNum(jsonObject, sjjiNeng.skill_level);
            sjjiNeng.skillRound = ints[1];
            sjjiNeng.count1 = 1;
            sjjiNeng.s1 = "pot";
            sjjiNeng.s2 = blueAndPointsLan[1];
            sjjiNeng.isTempSkill = 0;
            chara.jiNengList.add(sjjiNeng);
            if (skill_no == 301 || skill_no == 302) {
                GameUtil.a65511(chara);
                sjjiNeng.s1 = "voucher_or_cash";
                if (chara.use_money_type < cash) {
                    chara.balance = chara.balance - cash;
                } else {
                    chara.use_money_type = chara.use_money_type - cash;
                }
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            } else {
                chara.cash -= cash;
            }

            ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), vo_65527_0);
            List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
            GameObjectChar.send(new M32747_0(), vo_32747_0List);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "你技能等级提升到了#R" + sjjiNeng.skill_level + "#n级！";
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);

        } else {
            sjjiNeng.skill_attrib = PetAndHelpSkillUtils.getMaxSkill(chara.level);
            int levelUp = up_level;
            int cash = 0;
            if (sjjiNeng.skill_level + up_level > sjjiNeng.skill_attrib) {
                up_level = sjjiNeng.skill_attrib - sjjiNeng.skill_level;
            }
            PetAndHelpSkillUtils petAndHelpSkillUtils = new PetAndHelpSkillUtils();
            for (int i = 0; i < levelUp; i++) {
                int[] blueAndPointsLan = petAndHelpSkillUtils.getBlueAndPointsLan(skill_no, sjjiNeng.skill_level + i);
                cash += blueAndPointsLan[1];
            }
            if (cash > chara.cash && skill_no != 302 && skill_no != 301) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "金币，无法学习该技能";
                vo_20481_0.time = 1562987118;
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            if (skill_no == 301 || skill_no == 302) {
                if (chara.balance < chara.cash && chara.use_money_type < chara.cash) {
                    return;
                }
            }
            JSONObject jsonObject = PetAndHelpSkillUtils.jsonArray(skill_no);
            sjjiNeng.skill_attrib1 = Integer.parseInt((String) jsonObject.get("skill_attrib"));
            sjjiNeng.skill_level = sjjiNeng.skill_level + up_level;
            sjjiNeng.range = petAndHelpSkillUtils.skillNummax(skill_no, sjjiNeng.skill_level);
            int[] ints = petAndHelpSkillUtils.skillNum(jsonObject, sjjiNeng.skill_level);
            sjjiNeng.skillRound = ints[1];
            int[] blueAndPointsLan = petAndHelpSkillUtils.getBlueAndPointsLan(skill_no, sjjiNeng.skill_level);
            sjjiNeng.skill_mana_cost = blueAndPointsLan[0];

            sjjiNeng.s2 = blueAndPointsLan[1];

            if (skill_no == 301 || skill_no == 302) {
                GameUtil.a65511(chara);
                sjjiNeng.s1 = "voucher_or_cash";
                if (chara.use_money_type < cash) {
                    chara.balance = chara.balance - cash;
                } else {
                    chara.use_money_type = chara.use_money_type - cash;
                }
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);
            } else {
                chara.cash -= cash;
            }
            ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), vo_65527_0);
            List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
            GameObjectChar.send(new M32747_0(), vo_32747_0List);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "你技能等级提升到了#R" + sjjiNeng.skill_level + "#n级！";
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);

        }


        ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), vo_65527_0);
//        ListVo_65527_0 vo_65527_0 = new ListVo_65527_0();
//        vo_65527_0.id = chara.id;
//        vo_65527_0.vo_65527_0.cash = chara.cash;
    }

    @Override
    public int cmd() {
        return 8308;
    }
}