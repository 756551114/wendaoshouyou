//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Shuxingduiying;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public static BaseShuxingduiyingVo t(Shuxingduiying vo) {
        return new BaseShuxingduiyingVo(vo);
    }

    public static List<BaseShuxingduiyingVo> t(List<Shuxingduiying> list) {
        List<BaseShuxingduiyingVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Shuxingduiying shuxingduiying : list) {
                listVo.add(t(shuxingduiying));
            }
        }
        return listVo;
    }
}
