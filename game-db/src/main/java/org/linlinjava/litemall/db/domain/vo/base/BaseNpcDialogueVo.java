//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.vo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import org.linlinjava.litemall.db.domain.NpcDialogue;

@Data
public class BaseNpcDialogueVo {
    public Integer id;
    public String name;
    public Integer portranit;
    public Integer picNo;
    public String content;
    public Integer isconmlete;
    public Integer isincombat;
    public Integer palytime;
    public String taskType;
    public String idname;

    public BaseNpcDialogueVo() {
    }

    public BaseNpcDialogueVo(NpcDialogue vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.name = vo.getName();
            this.portranit = vo.getPortranit();
            this.picNo = vo.getPicNo();
            this.content = vo.getContent();
            this.isconmlete = vo.getIsconmlete();
            this.isincombat = vo.getIsincombat();
            this.palytime = vo.getPalytime();
            this.taskType = vo.getTaskType();
            this.idname = vo.getIdname();
        }
    }

    public static final BaseNpcDialogueVo t(NpcDialogue vo) {
        return new BaseNpcDialogueVo(vo);
    }

    public static final List<BaseNpcDialogueVo> t(List<NpcDialogue> list) {
        List<BaseNpcDialogueVo> listVo = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            NpcDialogue temp = (NpcDialogue)var2.next();
            listVo.add(new BaseNpcDialogueVo(temp));
        }

        return listVo;
    }
}
