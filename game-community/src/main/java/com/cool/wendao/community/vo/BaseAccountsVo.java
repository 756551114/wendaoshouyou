//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Accounts;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseAccountsVo{
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

    public static  BaseAccountsVo t(Accounts vo) {
        return new BaseAccountsVo(vo);
    }

    public static  List<BaseAccountsVo> t(List<Accounts> list) {
        List<BaseAccountsVo> listVo = new ArrayList();
        if(list != null && list.size()>0){
        for (Accounts accounts : list) {
            listVo.add(t(accounts));
        }
        }
        return listVo;
    }
}
