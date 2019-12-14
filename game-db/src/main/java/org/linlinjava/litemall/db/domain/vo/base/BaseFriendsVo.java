//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.Friends;

@Data
public class BaseFriendsVo {
    public Integer id;
    public String pid;
    public String hy1;

    public BaseFriendsVo() {
    }

    public BaseFriendsVo(Friends vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.pid = vo.getPid();
            this.hy1 = vo.getHy1();
        }
    }

    public static final BaseFriendsVo t(Friends vo) {
        return new BaseFriendsVo(vo);
    }

    public static final List<BaseFriendsVo> t(List<Friends> list) {
        List<BaseFriendsVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Friends temp = (Friends)var2.next();
            listVo.add(new BaseFriendsVo(temp));
        }

        return listVo;
    }
}
