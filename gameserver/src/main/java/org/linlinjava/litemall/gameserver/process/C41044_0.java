package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.RateRandomNumber;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class C41044_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int flag = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (flag == 1) {
            Vo_41043_0 vo_41043_0 = new Vo_41043_0();
            vo_41043_0.flag = 1;
            vo_41043_0.name = callMounts(true)[0];
            GameObjectChar.send(new M41043_0(), vo_41043_0);
            GameObjectChar.send(new M12285_0(), chara.id);
        }

        if (flag == 3) {
            int coin = 5000000;
            chara.balance = chara.balance - coin;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);

            GameUtil.removemunber(chara, "精怪诱饵", 1);

            String[] strings = callMounts(true);

            List<Petbeibao> list = new ArrayList<>();
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.petCreate(pet, chara, 10);
            petbeibao.petShuXing.get(0).penetrate = 2;

            petbeibao.petShuXing.get(0).polar_point = 4;
            petbeibao.petShuXing.get(0).max_life = petbeibao.petShuXing.get(0).def;
            petbeibao.petShuXing.get(0).max_mana = petbeibao.petShuXing.get(0).dex;
            petbeibao.petShuXing.get(0).enchant_nimbus = 0;
            petbeibao.petShuXing.get(0).max_enchant_nimbus = 0;
            petbeibao.petShuXing.get(0).suit_light_effect = 1;
            petbeibao.petShuXing.get(0).hide_mount = Integer.valueOf(strings[1]);
            //当前力量
            petbeibao.petShuXing.get(0).phy_power = 1;
            //当前灵力
            petbeibao.petShuXing.get(0).mag_power = 1;
            //当前体力
            petbeibao.petShuXing.get(0).life = 1;
            //当前敏捷
            petbeibao.petShuXing.get(0).speed = 1;
            PetShuXing shuXing = new PetShuXing();
            shuXing.no = 23;
            shuXing.type1 = 2;
            shuXing.accurate = 4 * (Integer.valueOf(strings[1]) - 1);
            shuXing.mana = 4 * (Integer.valueOf(strings[1]) - 1);
            shuXing.wiz = 3 * (Integer.valueOf(strings[1]) - 1);
            shuXing.all_polar = 0;
            shuXing.upgrade_magic = 0;
            shuXing.upgrade_total = 0;
            petbeibao.petShuXing.add(shuXing);
            BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));
            petbeibao.petShuXing.get(0).max_life = petbeibao.petShuXing.get(0).def;
            petbeibao.petShuXing.get(0).max_mana = petbeibao.petShuXing.get(0).dex;
            boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
            GameUtil.dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, petbeibao.id, chara);
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);
            Vo_12269_0 vo_12269_0 = new Vo_12269_0();
            //宝宝的id
            vo_12269_0.id = petbeibao.id;
            vo_12269_0.owner_id = chara.id;
            GameObjectChar.send(new M12269_0(), vo_12269_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 2;
            vo_40964_0.name = strings[0];
            vo_40964_0.param = String.valueOf(petbeibao.petShuXing.get(0).type);
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "恭喜你召唤了一只" + strings[0];
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_41045_0 vo_41045_0 = new Vo_41045_0();
            vo_41045_0.flag = 3;
            vo_41045_0.id = petbeibao.id;
            GameObjectChar.send(new M41045_0(), vo_41045_0);

        }
        if (flag == 2) {
            Vo_41043_0 vo_41043_0 = new Vo_41043_0();
            vo_41043_0.flag = 1;
            vo_41043_0.name = callMounts(true)[0];
            GameObjectChar.send(new M41043_0(), vo_41043_0);
            GameObjectChar.send(new M12285_0(), chara.id);
        }

        if (flag == 4) {
            int coin = 50000000;
            chara.balance = chara.balance - coin;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            String[] strings = callMounts(false);
            GameUtil.removemunber(chara, "精怪诱饵", 10);

            List<Petbeibao> list = new ArrayList<>();
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.petCreate(pet, chara, 10);
            petbeibao.petShuXing.get(0).penetrate = 2;

            petbeibao.petShuXing.get(0).polar_point = 4;
            petbeibao.petShuXing.get(0).max_life = petbeibao.petShuXing.get(0).def;
            petbeibao.petShuXing.get(0).max_mana = petbeibao.petShuXing.get(0).dex;
            petbeibao.petShuXing.get(0).enchant_nimbus = 0;

            petbeibao.petShuXing.get(0).max_enchant_nimbus = 0;
            petbeibao.petShuXing.get(0).suit_light_effect = 1;
            petbeibao.petShuXing.get(0).hide_mount = Integer.valueOf(strings[1]);

            //当前力量
            petbeibao.petShuXing.get(0).phy_power = 1;
            //当前灵力
            petbeibao.petShuXing.get(0).mag_power = 1;
            //当前体力
            petbeibao.petShuXing.get(0).life = 1;
            //当前敏捷
            petbeibao.petShuXing.get(0).speed = 1;


            PetShuXing shuXing = new PetShuXing();
            shuXing.no = 23;
            shuXing.type1 = 2;
//            shuXing.conutnumber = 6;

            shuXing.accurate = 4 * (Integer.valueOf(strings[1]) - 1);
            shuXing.mana = 4 * (Integer.valueOf(strings[1]) - 1);
            shuXing.wiz = 3 * (Integer.valueOf(strings[1]) - 1);
            shuXing.all_polar = 0;
            shuXing.upgrade_magic = 0;
            shuXing.upgrade_total = 0;
            petbeibao.petShuXing.add(shuXing);


            BasicAttributesUtils.petshuxing(petbeibao.petShuXing.get(0));

            petbeibao.petShuXing.get(0).max_life = petbeibao.petShuXing.get(0).def;
            petbeibao.petShuXing.get(0).max_mana = petbeibao.petShuXing.get(0).dex;
            boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
            GameUtil.dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, petbeibao.id, chara);
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);

            Vo_12269_0 vo_12269_0 = new Vo_12269_0();
            //宝宝的id
            vo_12269_0.id = petbeibao.id;
            vo_12269_0.owner_id = chara.id;
            GameObjectChar.send(new M12269_0(), vo_12269_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 2;
            vo_40964_0.name = strings[0];
            vo_40964_0.param = String.valueOf(petbeibao.petShuXing.get(0).type);
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);

            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "恭喜你召唤了一只" + strings[0];
            vo_20480_0.time = (int) (System.currentTimeMillis() / 1000);
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_41045_0 vo_41045_0 = new Vo_41045_0();
            vo_41045_0.flag = 3;
            vo_41045_0.id = petbeibao.id;
            GameObjectChar.send(new M41045_0(), vo_41045_0);

        }
    }

    @Override
    public int cmd() {
        return 41044;
    }

    public int subtraction() {
        Random r = new Random();

        return r.nextInt(10);
    }

    /**
     * 坐骑召唤
     * isOrdinary 普通召唤
     *
     * @return
     */
    private static String[] callMounts(boolean isOrdinary) {

        int[] mounts_stage = {2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 8, 8};
        String[] mounts_name = {"仙阳剑", "凌岩豹", "幻鹿", "赤焰葫芦", "玉豹", "仙葫芦", "无极熊", "岳麓剑", "古鹿", "北极熊", "筋斗云", "太极熊", "墨麒麟"};

        List<Integer> separates = new ArrayList<Integer>();
        //5---20    5-10 概率30%   10-19  概率65%  20概率5%
        separates.add(6);
        separates.add(10);
        List<Integer> percents = new ArrayList<Integer>();
        percents.add(97 - (isOrdinary ? 0 : 4));
        percents.add(2 + (isOrdinary ? 0 : 3));
        percents.add(1 + (isOrdinary ? 0 : 1));
        int number = RateRandomNumber.produceRateRandomNumber(0, 12, separates, percents);

        String[] mounts = new String[2];
        mounts[0] = mounts_name[number];
        mounts[1] = String.valueOf(mounts_stage[number]);


        return mounts;
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
}