//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.CreepsStore;

@Data
public class BaseCreepsStoreVo {
    public Integer id;
    public String name;
    public Integer price;

    public BaseCreepsStoreVo() {
    }

    public BaseCreepsStoreVo(CreepsStore vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.price = vo.getPrice();
        }
    }

    public static final BaseCreepsStoreVo t(CreepsStore vo) {
        return new BaseCreepsStoreVo(vo);
    }

    public static final List<BaseCreepsStoreVo> t(List<CreepsStore> list) {
        List<BaseCreepsStoreVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            CreepsStore temp = (CreepsStore)var2.next();
            listVo.add(new BaseCreepsStoreVo(temp));
        }

        return listVo;
    }
}
