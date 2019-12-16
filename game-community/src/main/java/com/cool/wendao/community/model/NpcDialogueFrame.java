//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "npc_dialogue_frame")
public class NpcDialogueFrame extends BaseModel {

    private Integer portrait;
    private Integer picNo;
    private String content;
    private String secretKey;
    private String name;
    private Integer attrib;


    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date updateTimes;

    private Integer idname;
    private String next;
    private String currentTask;
    private String uncontent;
    private String zhuangbei;
    private Integer jingyan;
    private Integer money;

    public NpcDialogueFrame() {
    }



}
