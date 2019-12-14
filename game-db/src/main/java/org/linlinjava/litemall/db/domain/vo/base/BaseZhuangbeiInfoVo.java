//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;

public class BaseZhuangbeiInfoVo {
    public Integer id;
    public Integer attrib;
    public Integer amount;
    public Integer type;
    public String str;
    public String quality;
    public Integer master;
    public Integer metal;
    public Integer mana;
    public Integer accurate;
    public Integer def;
    public Integer dex;
    public Integer wiz;
    public Integer parry;

    public BaseZhuangbeiInfoVo() {
    }

    public BaseZhuangbeiInfoVo(ZhuangbeiInfo vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.attrib = vo.getAttrib();
            this.amount = vo.getAmount();
            this.type = vo.getType();
            this.str = vo.getStr();
            this.quality = vo.getQuality();
            this.master = vo.getMaster();
            this.metal = vo.getMetal();
            this.mana = vo.getMana();
            this.accurate = vo.getAccurate();
            this.def = vo.getDef();
            this.dex = vo.getDex();
            this.wiz = vo.getWiz();
            this.parry = vo.getParry();
        }
    }

    public static final BaseZhuangbeiInfoVo t(ZhuangbeiInfo vo) {
        return new BaseZhuangbeiInfoVo(vo);
    }

    public static final List<BaseZhuangbeiInfoVo> t(List<ZhuangbeiInfo> list) {
        List<BaseZhuangbeiInfoVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            ZhuangbeiInfo temp = (ZhuangbeiInfo)var2.next();
            listVo.add(new BaseZhuangbeiInfoVo(temp));
        }

        return listVo;
    }
}
