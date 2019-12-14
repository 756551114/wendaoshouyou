//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.db.domain.StoreInfo;

public class BaseStoreInfoVo {
    public Integer id;
    public String quality;
    public Integer value;
    public Integer type;
    public String name;
    public Integer totalScore;
    public Integer recognizeRecognized;
    public Integer rebuildLevel;
    public Integer silverCoin;

    public BaseStoreInfoVo() {
    }

    public BaseStoreInfoVo(StoreInfo vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.quality = vo.getQuality();
            this.value = vo.getValue();
            this.type = vo.getType();
            this.name = vo.getName();
            this.totalScore = vo.getTotalScore();
            this.recognizeRecognized = vo.getRecognizeRecognized();
            this.rebuildLevel = vo.getRebuildLevel();
            this.silverCoin = vo.getSilverCoin();
        }
    }

    public static final BaseStoreInfoVo t(StoreInfo vo) {
        return new BaseStoreInfoVo(vo);
    }

    public static final List<BaseStoreInfoVo> t(List<StoreInfo> list) {
        List<BaseStoreInfoVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            StoreInfo temp = (StoreInfo)var2.next();
            listVo.add(new BaseStoreInfoVo(temp));
        }

        return listVo;
    }
}
