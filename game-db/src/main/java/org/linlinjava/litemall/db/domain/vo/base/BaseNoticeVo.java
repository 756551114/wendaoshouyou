//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Notice;

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

    public static final BaseNoticeVo t(Notice vo) {
        return new BaseNoticeVo(vo);
    }

    public static final List<BaseNoticeVo> t(List<Notice> list) {
        List<BaseNoticeVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Notice temp = (Notice)var2.next();
            listVo.add(new BaseNoticeVo(temp));
        }

        return listVo;
    }
}
