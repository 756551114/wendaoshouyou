//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.ZhuangbeiInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public static BaseZhuangbeiInfoVo t(ZhuangbeiInfo vo) {
        return new BaseZhuangbeiInfoVo(vo);
    }

    public static List<BaseZhuangbeiInfoVo> t(List<ZhuangbeiInfo> list) {
        List<BaseZhuangbeiInfoVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            list.forEach(k -> {
                listVo.add(t(k));
            });
        }
        return listVo;
    }
}
