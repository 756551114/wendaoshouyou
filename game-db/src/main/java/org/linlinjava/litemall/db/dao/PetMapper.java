//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.domain.Pet.Column;
import org.linlinjava.litemall.db.domain.example.PetExample;

public interface PetMapper {
    long countByExample(PetExample example);

    int deleteByExample(PetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectOneByExample(PetExample example);

    Pet selectOneByExampleSelective(@Param("example") PetExample example, @Param("selective") Column... selective);

    List<Pet> selectByExampleSelective(@Param("example") PetExample example, @Param("selective") Column... selective);

    List<Pet> selectByExample(PetExample example);

    Pet selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Pet selectByPrimaryKey(Integer id);

    Pet selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByExample(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    int logicalDeleteByExample(@Param("example") PetExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
