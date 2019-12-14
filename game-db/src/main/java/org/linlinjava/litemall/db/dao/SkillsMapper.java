//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Skills;
import org.linlinjava.litemall.db.domain.Skills.Column;
import org.linlinjava.litemall.db.domain.example.SkillsExample;

public interface SkillsMapper {
    long countByExample(SkillsExample example);

    int deleteByExample(SkillsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Skills record);

    int insertSelective(Skills record);

    Skills selectOneByExample(SkillsExample example);

    Skills selectOneByExampleSelective(@Param("example") SkillsExample example, @Param("selective") Column... selective);

    List<Skills> selectByExampleSelective(@Param("example") SkillsExample example, @Param("selective") Column... selective);

    List<Skills> selectByExample(SkillsExample example);

    Skills selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Skills selectByPrimaryKey(Integer id);

    Skills selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Skills record, @Param("example") SkillsExample example);

    int updateByExample(@Param("record") Skills record, @Param("example") SkillsExample example);

    int updateByPrimaryKeySelective(Skills record);

    int updateByPrimaryKey(Skills record);

    int logicalDeleteByExample(@Param("example") SkillsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
