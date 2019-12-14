//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Map;
import org.linlinjava.litemall.db.domain.Map.Column;
import org.linlinjava.litemall.db.domain.example.MapExample;

public interface MapMapper {
    long countByExample(MapExample example);

    int deleteByExample(MapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Map record);

    int insertSelective(Map record);

    Map selectOneByExample(MapExample example);

    Map selectOneByExampleSelective(@Param("example") MapExample example, @Param("selective") Column... selective);

    List<Map> selectByExampleSelective(@Param("example") MapExample example, @Param("selective") Column... selective);

    List<Map> selectByExample(MapExample example);

    Map selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Map selectByPrimaryKey(Integer id);

    Map selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Map record, @Param("example") MapExample example);

    int updateByExample(@Param("record") Map record, @Param("example") MapExample example);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(Map record);

    int logicalDeleteByExample(@Param("example") MapExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
