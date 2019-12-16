//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.vo;

import com.cool.wendao.community.model.NpcDialogueFrame;
import com.cool.wendao.community.utils.DateUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseNpcDialogueFrameVo {
    public Integer id;
    public Integer portrait;
    public Integer picNo;
    public String content;
    public String secretKey;
    public String name;
    public Integer attrib;
    public LocalDateTime updateTimes;
    public Integer idname;
    public String next;
    public String currentTask;
    public String uncontent;
    public String zhuangbei;
    public Integer jingyan;
    public Integer money;

    public BaseNpcDialogueFrameVo() {
    }

    public BaseNpcDialogueFrameVo(NpcDialogueFrame vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.portrait = vo.getPortrait();
            this.picNo = vo.getPicNo();
            this.content = vo.getContent();
            this.secretKey = vo.getSecretKey();
            this.name = vo.getName();
            this.attrib = vo.getAttrib();
            this.updateTimes = DateUtils.dateToLocalDateTime(vo.getUpdateTimes());
            this.idname = vo.getIdname();
            this.next = vo.getNext();
            this.currentTask = vo.getCurrentTask();
            this.uncontent = vo.getUncontent();
            this.zhuangbei = vo.getZhuangbei();
            this.jingyan = vo.getJingyan();
            this.money = vo.getMoney();
        }
    }

    public static BaseNpcDialogueFrameVo t(NpcDialogueFrame vo) {
        return new BaseNpcDialogueFrameVo(vo);
    }

    public static List<BaseNpcDialogueFrameVo> t(List<NpcDialogueFrame> list) {
        List<BaseNpcDialogueFrameVo> listVo = new ArrayList();
        if (list != null && list.size() > 0) {
            for (NpcDialogueFrame npcDialogueFrame : list) {
                listVo.add(t(npcDialogueFrame));
            }
        }

        return listVo;
    }
}
