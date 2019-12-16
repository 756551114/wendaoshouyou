//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.Friends;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseFriendsVo t(Friends vo) {
        return new BaseFriendsVo(vo);
    }

    public static List<BaseFriendsVo> t(List<Friends> list) {
        List<BaseFriendsVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Friends friends : list) {
                listVo.add(t(friends));
            }
        }

        return listVo;
    }
}
