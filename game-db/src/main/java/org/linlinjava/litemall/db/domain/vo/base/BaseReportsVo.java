//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Reports;

public class BaseReportsVo {
    public Integer id;
    public String zhanghao;
    public Integer yuanbaoshu;
    public String shifouchongzhi;

    public BaseReportsVo() {
    }

    public BaseReportsVo(Reports vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.zhanghao = vo.getZhanghao();
            this.yuanbaoshu = vo.getYuanbaoshu();
            this.shifouchongzhi = vo.getShifouchongzhi();
        }
    }

    public static final BaseReportsVo t(Reports vo) {
        return new BaseReportsVo(vo);
    }

    public static final List<BaseReportsVo> t(List<Reports> list) {
        List<BaseReportsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Reports temp = (Reports)var2.next();
            listVo.add(new BaseReportsVo(temp));
        }

        return listVo;
    }
}
