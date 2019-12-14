//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SkillsChongw;
import org.linlinjava.litemall.db.domain.SkillsChongw.Column;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample;

public interface SkillsChongwMapper {
    long countByExample(SkillsChongwExample example);

    int deleteByExample(SkillsChongwExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkillsChongw record);

    int insertSelective(SkillsChongw record);

    SkillsChongw selectOneByExample(SkillsChongwExample example);

    SkillsChongw selectOneByExampleSelective(@Param("example") SkillsChongwExample example, @Param("selective") Column... selective);

    List<SkillsChongw> selectByExampleSelective(@Param("example") SkillsChongwExample example, @Param("selective") Column... selective);

    List<SkillsChongw> selectByExample(SkillsChongwExample example);

    SkillsChongw selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    SkillsChongw selectByPrimaryKey(Integer id);

    SkillsChongw selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") SkillsChongw record, @Param("example") SkillsChongwExample example);

    int updateByExample(@Param("record") SkillsChongw record, @Param("example") SkillsChongwExample example);

    int updateByPrimaryKeySelective(SkillsChongw record);

    int updateByPrimaryKey(SkillsChongw record);

    int logicalDeleteByExample(@Param("example") SkillsChongwExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
