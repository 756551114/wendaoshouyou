//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Pets;
import org.linlinjava.litemall.db.domain.Pets.Column;
import org.linlinjava.litemall.db.domain.example.PetsExample;

public interface PetsMapper {
    long countByExample(PetsExample example);

    int deleteByExample(PetsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pets record);

    int insertSelective(Pets record);

    Pets selectOneByExample(PetsExample example);

    Pets selectOneByExampleSelective(@Param("example") PetsExample example, @Param("selective") Column... selective);

    List<Pets> selectByExampleSelective(@Param("example") PetsExample example, @Param("selective") Column... selective);

    List<Pets> selectByExample(PetsExample example);

    Pets selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Pets selectByPrimaryKey(Integer id);

    Pets selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Pets record, @Param("example") PetsExample example);

    int updateByExample(@Param("record") Pets record, @Param("example") PetsExample example);

    int updateByPrimaryKeySelective(Pets record);

    int updateByPrimaryKey(Pets record);

    int logicalDeleteByExample(@Param("example") PetsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
