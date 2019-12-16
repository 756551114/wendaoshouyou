//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.CreepsStore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseCreepsStoreVo t(CreepsStore vo) {
        return new BaseCreepsStoreVo(vo);
    }

    public static List<BaseCreepsStoreVo> t(List<CreepsStore> list) {
        List<BaseCreepsStoreVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (CreepsStore creepsStore : list) {
                listVo.add(t(creepsStore));
            }
        }
        return listVo;
    }
}
