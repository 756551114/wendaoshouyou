//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.ExperienceTreasure;
import org.linlinjava.litemall.db.domain.ExperienceTreasure.Column;
import org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample;

public interface ExperienceTreasureMapper {
    long countByExample(ExperienceTreasureExample example);

    int deleteByExample(ExperienceTreasureExample example);

    int deleteByPrimaryKey(Integer attrib);

    int insert(ExperienceTreasure record);

    int insertSelective(ExperienceTreasure record);

    ExperienceTreasure selectOneByExample(ExperienceTreasureExample example);

    ExperienceTreasure selectOneByExampleSelective(@Param("example") ExperienceTreasureExample example, @Param("selective") Column... selective);

    List<ExperienceTreasure> selectByExampleSelective(@Param("example") ExperienceTreasureExample example, @Param("selective") Column... selective);

    List<ExperienceTreasure> selectByExample(ExperienceTreasureExample example);

    ExperienceTreasure selectByPrimaryKeySelective(@Param("attrib") Integer attrib, @Param("selective") Column... selective);

    ExperienceTreasure selectByPrimaryKey(Integer attrib);

    ExperienceTreasure selectByPrimaryKeyWithLogicalDelete(@Param("attrib") Integer attrib, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") ExperienceTreasure record, @Param("example") ExperienceTreasureExample example);

    int updateByExample(@Param("record") ExperienceTreasure record, @Param("example") ExperienceTreasureExample example);

    int updateByPrimaryKeySelective(ExperienceTreasure record);

    int updateByPrimaryKey(ExperienceTreasure record);

    int logicalDeleteByExample(@Param("example") ExperienceTreasureExample example);

    int logicalDeleteByPrimaryKey(Integer attrib);
}
