//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Characters;

@Data
public class BaseCharactersVo {
    public Integer id;
    public Integer menpai;
    public String name;
    public Integer accountId;
    public String gid;
    public String data;

    public BaseCharactersVo() {
    }

    public BaseCharactersVo(Characters vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.menpai = vo.getMenpai();
            this.name = vo.getName();
            this.accountId = vo.getAccountId();
            this.gid = vo.getGid();
            this.data = vo.getData();
        }
    }

    public static final BaseCharactersVo t(Characters vo) {
        return new BaseCharactersVo(vo);
    }

    public static final List<BaseCharactersVo> t(List<Characters> list) {
        List<BaseCharactersVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Characters temp = (Characters)var2.next();
            listVo.add(new BaseCharactersVo(temp));
        }

        return listVo;
    }
}
