//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.NpcDialogue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseNpcDialogueVo t(NpcDialogue vo) {
        return new BaseNpcDialogueVo(vo);
    }

    public static List<BaseNpcDialogueVo> t(List<NpcDialogue> list) {
        List<BaseNpcDialogueVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (NpcDialogue npcDialogue : list) {
                listVo.add(t(npcDialogue));
            }
        }

        return listVo;
    }
}
