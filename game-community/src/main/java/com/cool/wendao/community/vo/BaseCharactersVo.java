//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Characters;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseCharactersVo t(Characters vo) {
        return new BaseCharactersVo(vo);
    }

    public static List<BaseCharactersVo> t(List<Characters> list) {
        List<BaseCharactersVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Characters accounts : list) {
                listVo.add(t(accounts));
            }
        }
        return listVo;
    }
}
