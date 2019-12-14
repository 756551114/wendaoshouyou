//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.db.domain.CreepsStore.Column;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample;

public interface CreepsStoreMapper {
    long countByExample(CreepsStoreExample example);

    int deleteByExample(CreepsStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreepsStore record);

    int insertSelective(CreepsStore record);

    CreepsStore selectOneByExample(CreepsStoreExample example);

    CreepsStore selectOneByExampleSelective(@Param("example") CreepsStoreExample example, @Param("selective") Column... selective);

    List<CreepsStore> selectByExampleSelective(@Param("example") CreepsStoreExample example, @Param("selective") Column... selective);

    List<CreepsStore> selectByExample(CreepsStoreExample example);

    CreepsStore selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    CreepsStore selectByPrimaryKey(Integer id);

    CreepsStore selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") CreepsStore record, @Param("example") CreepsStoreExample example);

    int updateByExample(@Param("record") CreepsStore record, @Param("example") CreepsStoreExample example);

    int updateByPrimaryKeySelective(CreepsStore record);

    int updateByPrimaryKey(CreepsStore record);

    int logicalDeleteByExample(@Param("example") CreepsStoreExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
