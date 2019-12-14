//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Daili;

@Data
public class BaseDailiVo {
    public Integer id;
    public String account;
    public String passwd;
    public String code;
    public String token;

    public BaseDailiVo() {
    }

    public BaseDailiVo(Daili vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.account = vo.getAccount();
            this.passwd = vo.getPasswd();
            this.code = vo.getCode();
            this.token = vo.getToken();
        }
    }

    public static final BaseDailiVo t(Daili vo) {
        return new BaseDailiVo(vo);
    }

    public static final List<BaseDailiVo> t(List<Daili> list) {
        List<BaseDailiVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Daili temp = (Daili)var2.next();
            listVo.add(new BaseDailiVo(temp));
        }

        return listVo;
    }
}
