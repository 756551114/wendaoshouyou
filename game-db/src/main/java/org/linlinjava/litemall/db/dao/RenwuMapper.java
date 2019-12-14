//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.db.domain.Renwu.Column;
import org.linlinjava.litemall.db.domain.example.RenwuExample;

public interface RenwuMapper {
    long countByExample(RenwuExample example);

    int deleteByExample(RenwuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Renwu record);

    int insertSelective(Renwu record);

    Renwu selectOneByExample(RenwuExample example);

    Renwu selectOneByExampleSelective(@Param("example") RenwuExample example, @Param("selective") Column... selective);

    List<Renwu> selectByExampleSelective(@Param("example") RenwuExample example, @Param("selective") Column... selective);

    List<Renwu> selectByExample(RenwuExample example);

    Renwu selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Renwu selectByPrimaryKey(Integer id);

    Renwu selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Renwu record, @Param("example") RenwuExample example);

    int updateByExample(@Param("record") Renwu record, @Param("example") RenwuExample example);

    int updateByPrimaryKeySelective(Renwu record);

    int updateByPrimaryKey(Renwu record);

    int logicalDeleteByExample(@Param("example") RenwuExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
