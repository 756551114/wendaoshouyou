//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Reports;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public static BaseReportsVo t(Reports vo) {
        return new BaseReportsVo(vo);
    }

    public static List<BaseReportsVo> t(List<Reports> list) {
        List<BaseReportsVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Reports reports : list) {
                listVo.add(t(reports));
            }
        }

        return listVo;
    }
}
