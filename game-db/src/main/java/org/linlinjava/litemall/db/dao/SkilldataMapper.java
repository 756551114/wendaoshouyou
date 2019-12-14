//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Skilldata;
import org.linlinjava.litemall.db.domain.Skilldata.Column;
import org.linlinjava.litemall.db.domain.example.SkilldataExample;

public interface SkilldataMapper {
    long countByExample(SkilldataExample example);

    int deleteByExample(SkilldataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Skilldata record);

    int insertSelective(Skilldata record);

    Skilldata selectOneByExample(SkilldataExample example);

    Skilldata selectOneByExampleSelective(@Param("example") SkilldataExample example, @Param("selective") Column... selective);

    List<Skilldata> selectByExampleSelective(@Param("example") SkilldataExample example, @Param("selective") Column... selective);

    List<Skilldata> selectByExample(SkilldataExample example);

    Skilldata selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Skilldata selectByPrimaryKey(Integer id);

    Skilldata selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Skilldata record, @Param("example") SkilldataExample example);

    int updateByExample(@Param("record") Skilldata record, @Param("example") SkilldataExample example);

    int updateByPrimaryKeySelective(Skilldata record);

    int updateByPrimaryKey(Skilldata record);

    int logicalDeleteByExample(@Param("example") SkilldataExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
