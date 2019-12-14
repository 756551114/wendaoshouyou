//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Choujiang;

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

    public static final BaseChoujiangVo t(Choujiang vo) {
        return new BaseChoujiangVo(vo);
    }

    public static final List<BaseChoujiangVo> t(List<Choujiang> list) {
        List<BaseChoujiangVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Choujiang temp = (Choujiang)var2.next();
            listVo.add(new BaseChoujiangVo(temp));
        }

        return listVo;
    }
}
