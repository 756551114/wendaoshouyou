//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.db.domain.NpcPoint.Column;
import org.linlinjava.litemall.db.domain.example.NpcPointExample;

public interface NpcPointMapper {
    long countByExample(NpcPointExample example);

    int deleteByExample(NpcPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NpcPoint record);

    int insertSelective(NpcPoint record);

    NpcPoint selectOneByExample(NpcPointExample example);

    NpcPoint selectOneByExampleSelective(@Param("example") NpcPointExample example, @Param("selective") Column... selective);

    List<NpcPoint> selectByExampleSelective(@Param("example") NpcPointExample example, @Param("selective") Column... selective);

    List<NpcPoint> selectByExample(NpcPointExample example);

    NpcPoint selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    NpcPoint selectByPrimaryKey(Integer id);

    NpcPoint selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") NpcPoint record, @Param("example") NpcPointExample example);

    int updateByExample(@Param("record") NpcPoint record, @Param("example") NpcPointExample example);

    int updateByPrimaryKeySelective(NpcPoint record);

    int updateByPrimaryKey(NpcPoint record);

    int logicalDeleteByExample(@Param("example") NpcPointExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
