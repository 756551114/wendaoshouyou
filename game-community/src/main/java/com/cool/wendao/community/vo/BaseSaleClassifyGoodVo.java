//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.SaleClassifyGood;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseSaleClassifyGoodVo {
    public Integer id;
    public String pname;
    public String cname;
    public String attrib;
    public Integer icon;
    public String str;
    public Integer price;
    public String compose;

    public BaseSaleClassifyGoodVo() {
    }

    public BaseSaleClassifyGoodVo(SaleClassifyGood vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.pname = vo.getPname();
            this.cname = vo.getCname();
            this.attrib = vo.getAttrib();
            this.icon = vo.getIcon();
            this.str = vo.getStr();
            this.price = vo.getPrice();
            this.compose = vo.getCompose();
        }
    }

    public static final BaseSaleClassifyGoodVo t(SaleClassifyGood vo) {
        return new BaseSaleClassifyGoodVo(vo);
    }

    public static final List<BaseSaleClassifyGoodVo> t(List<SaleClassifyGood> list) {
        List<BaseSaleClassifyGoodVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (SaleClassifyGood saleClassifyGood : list) {
                listVo.add(t(saleClassifyGood));
            }
        }
        return listVo;
    }
}
