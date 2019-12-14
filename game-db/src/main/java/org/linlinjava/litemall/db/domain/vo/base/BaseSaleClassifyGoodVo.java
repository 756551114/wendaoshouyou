//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;

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
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            SaleClassifyGood temp = (SaleClassifyGood)var2.next();
            listVo.add(new BaseSaleClassifyGoodVo(temp));
        }

        return listVo;
    }
}
