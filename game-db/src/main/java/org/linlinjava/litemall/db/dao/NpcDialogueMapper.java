//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.NpcDialogue;
import org.linlinjava.litemall.db.domain.NpcDialogue.Column;
import org.linlinjava.litemall.db.domain.example.NpcDialogueExample;

public interface NpcDialogueMapper {
    long countByExample(NpcDialogueExample example);

    int deleteByExample(NpcDialogueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NpcDialogue record);

    int insertSelective(NpcDialogue record);

    NpcDialogue selectOneByExample(NpcDialogueExample example);

    NpcDialogue selectOneByExampleSelective(@Param("example") NpcDialogueExample example, @Param("selective") Column... selective);

    List<NpcDialogue> selectByExampleSelective(@Param("example") NpcDialogueExample example, @Param("selective") Column... selective);

    List<NpcDialogue> selectByExample(NpcDialogueExample example);

    NpcDialogue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    NpcDialogue selectByPrimaryKey(Integer id);

    NpcDialogue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") NpcDialogue record, @Param("example") NpcDialogueExample example);

    int updateByExample(@Param("record") NpcDialogue record, @Param("example") NpcDialogueExample example);

    int updateByPrimaryKeySelective(NpcDialogue record);

    int updateByPrimaryKey(NpcDialogue record);

    int logicalDeleteByExample(@Param("example") NpcDialogueExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
