//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Choujiang;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseChoujiangVo {
    public Integer id;
    public Integer no;
    public String name;
    public String desc;
    public Integer level;

    public BaseChoujiangVo() {
    }

    public BaseChoujiangVo(Choujiang vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.no = vo.getNo();
            this.name = vo.getName();
            this.desc = vo.getDesc();
            this.level = vo.getLevel();
        }
    }

    public static BaseChoujiangVo t(Choujiang vo) {
        return new BaseChoujiangVo(vo);
    }

    public static List<BaseChoujiangVo> t(List<Choujiang> list) {
        List<BaseChoujiangVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Choujiang choujiang : list) {
                listVo.add(t(choujiang));
            }
        }
        return listVo;
    }
}
