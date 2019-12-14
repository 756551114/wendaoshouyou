//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.db.domain.PackModification.Column;
import org.linlinjava.litemall.db.domain.example.PackModificationExample;

public interface PackModificationMapper {
    long countByExample(PackModificationExample example);

    int deleteByExample(PackModificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PackModification record);

    int insertSelective(PackModification record);

    PackModification selectOneByExample(PackModificationExample example);

    PackModification selectOneByExampleSelective(@Param("example") PackModificationExample example, @Param("selective") Column... selective);

    List<PackModification> selectByExampleSelective(@Param("example") PackModificationExample example, @Param("selective") Column... selective);

    List<PackModification> selectByExample(PackModificationExample example);

    PackModification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    PackModification selectByPrimaryKey(Integer id);

    PackModification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") PackModification record, @Param("example") PackModificationExample example);

    int updateByExample(@Param("record") PackModification record, @Param("example") PackModificationExample example);

    int updateByPrimaryKeySelective(PackModification record);

    int updateByPrimaryKey(PackModification record);

    int logicalDeleteByExample(@Param("example") PackModificationExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
