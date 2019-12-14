//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.db.domain.Experience.Column;
import org.linlinjava.litemall.db.domain.example.ExperienceExample;

public interface ExperienceMapper {
    long countByExample(ExperienceExample example);

    int deleteByExample(ExperienceExample example);

    int deleteByPrimaryKey(Integer attrib);

    int insert(Experience record);

    int insertSelective(Experience record);

    Experience selectOneByExample(ExperienceExample example);

    Experience selectOneByExampleSelective(@Param("example") ExperienceExample example, @Param("selective") Column... selective);

    List<Experience> selectByExampleSelective(@Param("example") ExperienceExample example, @Param("selective") Column... selective);

    List<Experience> selectByExample(ExperienceExample example);

    Experience selectByPrimaryKeySelective(@Param("attrib") Integer attrib, @Param("selective") Column... selective);

    Experience selectByPrimaryKey(Integer attrib);

    Experience selectByPrimaryKeyWithLogicalDelete(@Param("attrib") Integer attrib, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Experience record, @Param("example") ExperienceExample example);

    int updateByExample(@Param("record") Experience record, @Param("example") ExperienceExample example);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKey(Experience record);

    int logicalDeleteByExample(@Param("example") ExperienceExample example);

    int logicalDeleteByPrimaryKey(Integer attrib);
}
