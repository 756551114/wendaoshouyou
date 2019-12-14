package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.*;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_61537_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61537_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8285_0;
import org.linlinjava.litemall.gameserver.data.write.M8285_0;
import org.linlinjava.litemall.gameserver.data.write.M61537_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.domain.*;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class C8284_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String char_name = GameReadTool.readString(buff);

        int gender = GameReadTool.readShort(buff);

        int polar = GameReadTool.readShort(buff);

        if (GameData.that.characterService.findOneByName(char_name) != null) {
            return;
        }


        final GameObjectChar session = GameObjectChar.getGameObjectChar();
        Accounts accounts = GameData.that.baseAccountsService.findById(session.accountid);

        String uuid = UUID.randomUUID().toString();
        Vo_8285_0 vo_8285_0 = new Vo_8285_0();
        vo_8285_0.name = char_name;
        vo_8285_0.gid = uuid;


        final Chara chara = new Chara(char_name, gender, polar, uuid);


        addbackpack(chara);
        GameUtil.zhuangbeiValue(chara);


        chara.max_mana = chara.zbAttribute.dex + chara.dex;
        chara.max_life = chara.zbAttribute.def + chara.def;
        chara.mapid = 1000;
//        chara.x = 86;
//        chara.y = 85;
        // TODO more
        final Characters characters = new Characters();
        characters.setName(char_name);
        characters.setMenpai(chara.menpai);
        characters.setGid(uuid);
        characters.setData(JSONUtils.toJSONString(chara));
        characters.setAccountId(session.accountid);
        //TODO more

        GameData.that.characterService.add(characters);

        chara.id = characters.getId();
        chara.allId = chara.id * 100000;


        Pet pet = GameData.that.basePetService.findOneByName("仙阳剑");
        Petbeibao petbeibao = new Petbeibao();
        petbeibao.PetCreate(pet, chara, 0, 2);
        List<Petbeibao> list = new ArrayList<>();
        chara.pets.add(petbeibao);
        list.add(petbeibao);
        petbeibao.petShuXing.get(0).enchant_nimbus = 0;
        petbeibao.petShuXing.get(0).max_enchant_nimbus = 0;
        petbeibao.petShuXing.get(0).suit_light_effect = 1;
        petbeibao.petShuXing.get(0).hide_mount = 2;
        PetShuXing shuXing = new PetShuXing();
        shuXing.no = 23;
        shuXing.type1 = 2;
        shuXing.accurate = 4 * (2 - 1);
        shuXing.mana = 4 * (2 - 1);
        shuXing.wiz = 3 * (2 - 1);
        shuXing.all_polar = 0;
        shuXing.upgrade_magic = 0;
        shuXing.upgrade_total = 0;
        petbeibao.petShuXing.add(shuXing);
        GameObjectChar.send(new M65507_0(), list);






        characters.setData(JSONUtils.toJSONString(chara));
        GameData.that.characterService.updateById(characters);
        session.init(characters);

        List<Characters> charactersList = GameData.that.characterService.findByAccountId(session.accountid);

        ListVo_61537_0 listvo_61537_0 = listjiaose(charactersList);


        final ByteBuf write = new M8285_0().write(vo_8285_0);
        ctx.writeAndFlush(write);

        final ByteBuf write1 = new M61537_0().write(listvo_61537_0);
        ctx.writeAndFlush(write1);


    }

    @Override
    public int cmd() {
        return 8284;
    }

    public void addbackpack(Chara chara) {
        ZhuangbeiInfo zhuangb = new ZhuangbeiInfo();
        List<ZhuangbeiInfo> byAttrib = GameData.that.baseZhuangbeiInfoService.findByAttrib(1);
        for (int i = 0; i < byAttrib.size(); i++) {
            if (byAttrib.get(i).getMaster() == chara.sex && byAttrib.get(i).getAmount() == 3) {
                zhuangb = byAttrib.get(i);
                Goods goods = new Goods();
                goods.pos = 3;
                goods.goodsInfo = new GoodsInfo();
                goods.goodsBasics = new GoodsBasics();
                goods.goodsLanSe = new GoodsLanSe();
                goods.goodsCreate(zhuangb);
                chara.backpack.add(goods);
            }
            if (byAttrib.get(i).getMaster() == chara.sex && byAttrib.get(i).getAmount() == 2) {
                zhuangb = byAttrib.get(i);
                Goods goods = new Goods();
                goods.pos = 2;
                goods.goodsInfo = new GoodsInfo();
                goods.goodsBasics = new GoodsBasics();
                goods.goodsLanSe = new GoodsLanSe();
                goods.goodsCreate(zhuangb);
                chara.backpack.add(goods);
            }
        }
        zhuangb = GameData.that.baseZhuangbeiInfoService.findOneByStr("麻鞋");
        Goods goods = new Goods();
        goods.pos = 10;
        goods.goodsInfo = new GoodsInfo();
        goods.goodsBasics = new GoodsBasics();
        goods.goodsLanSe = new GoodsLanSe();
        goods.goodsCreate(zhuangb);
        chara.backpack.add(goods);
    }


    public static ListVo_61537_0 listjiaose(List<Characters> charactersList) {
        ListVo_61537_0 listvo_61537_0 = new ListVo_61537_0();
        listvo_61537_0.a = 1;
        listvo_61537_0.count = charactersList.size();
        listvo_61537_0.c = 0;
        listvo_61537_0.d = 0;
        for (Characters character : charactersList) {
            Vo_61537_0 v61537 = new Vo_61537_0();
            String arr = character.getData();
            Chara chara1 = JSONUtils.parseObject(character.getData(), Chara.class);
            v61537.passive_mode = chara1.waiguan;
            v61537.metal = chara1.menpai;
            v61537.str = chara1.name;
            v61537.iid_str = chara1.uuid;   // uuid 应该是和账号对应的 这里不对
            v61537.skill = chara1.level;
            v61537.type = chara1.waiguan;
            v61537.last_login_time = 1558062000;


            listvo_61537_0.vo_61537_0.add(v61537);
        }
        return listvo_61537_0;
    }
}
