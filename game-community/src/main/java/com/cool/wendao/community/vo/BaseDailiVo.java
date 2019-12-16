//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Daili;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseDailiVo t(Daili vo) {
        return new BaseDailiVo(vo);
    }

    public static List<BaseDailiVo> t(List<Daili> list) {
        List<BaseDailiVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Daili daili : list) {
                listVo.add(t(daili));
            }
        }
        return listVo;
    }
}
