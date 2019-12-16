//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Pet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasePetVo {
    public Integer id;
    public Integer index;
    public Integer levelReq;
    public Integer life;
    public Integer mana;
    public Integer speed;
    public Integer phyAttack;
    public Integer magAttack;
    public String polar;
    public String skiils;
    public String zoon;
    public Integer icon;
    public String name;

    public BasePetVo() {
    }

    public BasePetVo(Pet vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.index = vo.getIndex();
            this.levelReq = vo.getLevelReq();
            this.life = vo.getLife();
            this.mana = vo.getMana();
            this.speed = vo.getSpeed();
            this.phyAttack = vo.getPhyAttack();
            this.magAttack = vo.getMagAttack();
            this.polar = vo.getPolar();
            this.skiils = vo.getSkiils();
            this.zoon = vo.getZoon();
            this.icon = vo.getIcon();
            this.name = vo.getName();
        }
    }

    public static final BasePetVo t(Pet vo) {
        return new BasePetVo(vo);
    }

    public static final List<BasePetVo> t(List<Pet> list) {
        List<BasePetVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Pet pet : list) {
                listVo.add(t(pet));
            }
        }

        return listVo;
    }
}
