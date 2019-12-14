//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.domain.Npc.Column;
import org.linlinjava.litemall.db.domain.example.NpcExample;

public interface NpcMapper {
    long countByExample(NpcExample example);

    int deleteByExample(NpcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Npc record);

    int insertSelective(Npc record);

    Npc selectOneByExample(NpcExample example);

    Npc selectOneByExampleSelective(@Param("example") NpcExample example, @Param("selective") Column... selective);

    List<Npc> selectByExampleSelective(@Param("example") NpcExample example, @Param("selective") Column... selective);

    List<Npc> selectByExample(NpcExample example);

    Npc selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Npc selectByPrimaryKey(Integer id);

    Npc selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Npc record, @Param("example") NpcExample example);

    int updateByExample(@Param("record") Npc record, @Param("example") NpcExample example);

    int updateByPrimaryKeySelective(Npc record);

    int updateByPrimaryKey(Npc record);

    int logicalDeleteByExample(@Param("example") NpcExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
