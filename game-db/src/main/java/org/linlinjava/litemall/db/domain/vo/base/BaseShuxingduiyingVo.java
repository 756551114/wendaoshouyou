//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.Shuxingduiying;

public class BaseShuxingduiyingVo {
    public Integer id;
    public String name;
    public String yingwen;

    public BaseShuxingduiyingVo() {
    }

    public BaseShuxingduiyingVo(Shuxingduiying vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.yingwen = vo.getYingwen();
        }
    }

    public static final BaseShuxingduiyingVo t(Shuxingduiying vo) {
        return new BaseShuxingduiyingVo(vo);
    }

    public static final List<BaseShuxingduiyingVo> t(List<Shuxingduiying> list) {
        List<BaseShuxingduiyingVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Shuxingduiying temp = (Shuxingduiying)var2.next();
            listVo.add(new BaseShuxingduiyingVo(temp));
        }

        return listVo;
    }
}
