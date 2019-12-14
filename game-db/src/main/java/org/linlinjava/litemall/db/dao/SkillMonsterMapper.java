//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SkillMonster;
import org.linlinjava.litemall.db.domain.SkillMonster.Column;
import org.linlinjava.litemall.db.domain.example.SkillMonsterExample;

public interface SkillMonsterMapper {
    long countByExample(SkillMonsterExample example);

    int deleteByExample(SkillMonsterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkillMonster record);

    int insertSelective(SkillMonster record);

    SkillMonster selectOneByExample(SkillMonsterExample example);

    SkillMonster selectOneByExampleSelective(@Param("example") SkillMonsterExample example, @Param("selective") Column... selective);

    List<SkillMonster> selectByExampleSelective(@Param("example") SkillMonsterExample example, @Param("selective") Column... selective);

    List<SkillMonster> selectByExample(SkillMonsterExample example);

    SkillMonster selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    SkillMonster selectByPrimaryKey(Integer id);

    SkillMonster selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") SkillMonster record, @Param("example") SkillMonsterExample example);

    int updateByExample(@Param("record") SkillMonster record, @Param("example") SkillMonsterExample example);

    int updateByPrimaryKeySelective(SkillMonster record);

    int updateByPrimaryKey(SkillMonster record);

    int logicalDeleteByExample(@Param("example") SkillMonsterExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
