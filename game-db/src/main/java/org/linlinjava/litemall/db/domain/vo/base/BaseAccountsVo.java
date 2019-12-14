//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Accounts;

@Data
public class BaseAccountsVo {
    public Integer id;
    public String name;
    public String keyword;
    public String password;
    public String token;
    public Integer chongzhijifen;
    public Integer chongzhiyuanbao;
    public String yaoqingma;
    public Integer block;
    public String code;

    public BaseAccountsVo() {
    }

    public BaseAccountsVo(Accounts vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.keyword = vo.getKeyword();
            this.password = vo.getPassword();
            this.token = vo.getToken();
            this.chongzhijifen = vo.getChongzhijifen();
            this.chongzhiyuanbao = vo.getChongzhiyuanbao();
            this.yaoqingma = vo.getYaoqingma();
            this.block = vo.getBlock();
            this.code = vo.getCode();
        }
    }

    public static final BaseAccountsVo t(Accounts vo) {
        return new BaseAccountsVo(vo);
    }

    public static final List<BaseAccountsVo> t(List<Accounts> list) {
        List<BaseAccountsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Accounts temp = (Accounts)var2.next();
            listVo.add(new BaseAccountsVo(temp));
        }

        return listVo;
    }
}
