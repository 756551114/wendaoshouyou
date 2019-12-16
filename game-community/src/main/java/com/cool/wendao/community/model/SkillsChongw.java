//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cool.wendao.community.model;

import com.cool.wendao.community.core.BaseModel;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "skills_chongw")
public class SkillsChongw  extends BaseModel {

    private String ownerid;
    private String skllCwid;
    private String skillIdHex;
    private String skillName;
    private Integer skillReqMenpai;
    private Integer skillLevel;
    private Integer skillMubiao;
    private String tianshuId;
    private String tianshuName;


    public SkillsChongw() {
    }

}
