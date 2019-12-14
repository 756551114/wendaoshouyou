//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.PetHelpType;
import org.linlinjava.litemall.db.domain.PetHelpType.Column;
import org.linlinjava.litemall.db.domain.example.PetHelpTypeExample;

public interface PetHelpTypeMapper {
    long countByExample(PetHelpTypeExample example);

    int deleteByExample(PetHelpTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PetHelpType record);

    int insertSelective(PetHelpType record);

    PetHelpType selectOneByExample(PetHelpTypeExample example);

    PetHelpType selectOneByExampleSelective(@Param("example") PetHelpTypeExample example, @Param("selective") Column... selective);

    List<PetHelpType> selectByExampleSelective(@Param("example") PetHelpTypeExample example, @Param("selective") Column... selective);

    List<PetHelpType> selectByExample(PetHelpTypeExample example);

    PetHelpType selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    PetHelpType selectByPrimaryKey(Integer id);

    PetHelpType selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") PetHelpType record, @Param("example") PetHelpTypeExample example);

    int updateByExample(@Param("record") PetHelpType record, @Param("example") PetHelpTypeExample example);

    int updateByPrimaryKeySelective(PetHelpType record);

    int updateByPrimaryKey(PetHelpType record);

    int logicalDeleteByExample(@Param("example") PetHelpTypeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
