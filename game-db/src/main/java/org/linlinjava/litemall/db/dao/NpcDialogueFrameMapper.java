//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.NpcDialogueFrame;
import org.linlinjava.litemall.db.domain.NpcDialogueFrame.Column;
import org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample;

public interface NpcDialogueFrameMapper {
    long countByExample(NpcDialogueFrameExample example);

    int deleteByExample(NpcDialogueFrameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NpcDialogueFrame record);

    int insertSelective(NpcDialogueFrame record);

    NpcDialogueFrame selectOneByExample(NpcDialogueFrameExample example);

    NpcDialogueFrame selectOneByExampleSelective(@Param("example") NpcDialogueFrameExample example, @Param("selective") Column... selective);

    List<NpcDialogueFrame> selectByExampleSelective(@Param("example") NpcDialogueFrameExample example, @Param("selective") Column... selective);

    List<NpcDialogueFrame> selectByExample(NpcDialogueFrameExample example);

    NpcDialogueFrame selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    NpcDialogueFrame selectByPrimaryKey(Integer id);

    NpcDialogueFrame selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") NpcDialogueFrame record, @Param("example") NpcDialogueFrameExample example);

    int updateByExample(@Param("record") NpcDialogueFrame record, @Param("example") NpcDialogueFrameExample example);

    int updateByPrimaryKeySelective(NpcDialogueFrame record);

    int updateByPrimaryKey(NpcDialogueFrame record);

    int logicalDeleteByExample(@Param("example") NpcDialogueFrameExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
