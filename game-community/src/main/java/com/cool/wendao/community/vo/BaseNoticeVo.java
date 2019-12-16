//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Notice;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseNoticeVo {
    public Integer id;
    public String message;
    public Integer time;

    public BaseNoticeVo() {
    }

    public BaseNoticeVo(Notice vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.message = vo.getMessage();
            this.time = vo.getTime();
        }
    }

    public static BaseNoticeVo t(Notice vo) {
        return new BaseNoticeVo(vo);
    }

    public static List<BaseNoticeVo> t(List<Notice> list) {
        List<BaseNoticeVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Notice notice : list) {
                listVo.add(t(notice));
            }
        }

        return listVo;
    }
}
