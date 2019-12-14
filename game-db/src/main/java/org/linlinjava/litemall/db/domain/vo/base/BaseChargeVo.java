//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Charge;

@Data
public class BaseChargeVo {
    public Integer id;
    public String accountname;
    public Integer coin;
    public Integer state;
    public Integer money;
    public String code;

    public BaseChargeVo() {
    }

    public BaseChargeVo(Charge vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.accountname = vo.getAccountname();
            this.coin = vo.getCoin();
            this.state = vo.getState();
            this.money = vo.getMoney();
            this.code = vo.getCode();
        }
    }

    public static final BaseChargeVo t(Charge vo) {
        return new BaseChargeVo(vo);
    }

    public static final List<BaseChargeVo> t(List<Charge> list) {
        List<BaseChargeVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Charge temp = (Charge)var2.next();
            listVo.add(new BaseChargeVo(temp));
        }

        return listVo;
    }
}
