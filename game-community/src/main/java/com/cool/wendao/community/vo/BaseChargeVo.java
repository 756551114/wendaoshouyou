//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Charge;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
            this.accountname = vo.getAccountName();
            this.coin = vo.getCoin().intValue();
            this.state = vo.getState();
            this.money = vo.getMoney().intValue();
            this.code = vo.getCode();
        }
    }

    public static BaseChargeVo t(Charge vo) {
        return new BaseChargeVo(vo);
    }

    public static List<BaseChargeVo> t(List<Charge> list) {
        List<BaseChargeVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Charge charge : list) {
                listVo.add(t(charge));
            }
        }
        return listVo;
    }
}
