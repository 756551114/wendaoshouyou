//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Daili;
import org.linlinjava.litemall.db.domain.Daili.Column;
import org.linlinjava.litemall.db.domain.example.DailiExample;

public interface DailiMapper {
    long countByExample(DailiExample example);

    int deleteByExample(DailiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Daili record);

    int insertSelective(Daili record);

    Daili selectOneByExample(DailiExample example);

    Daili selectOneByExampleSelective(@Param("example") DailiExample example, @Param("selective") Column... selective);

    List<Daili> selectByExampleSelective(@Param("example") DailiExample example, @Param("selective") Column... selective);

    List<Daili> selectByExample(DailiExample example);

    Daili selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Daili selectByPrimaryKey(Integer id);

    Daili selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Daili record, @Param("example") DailiExample example);

    int updateByExample(@Param("record") Daili record, @Param("example") DailiExample example);

    int updateByPrimaryKeySelective(Daili record);

    int updateByPrimaryKey(Daili record);

    int logicalDeleteByExample(@Param("example") DailiExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
