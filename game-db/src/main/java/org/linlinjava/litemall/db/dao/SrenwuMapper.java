//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Srenwu;
import org.linlinjava.litemall.db.domain.Srenwu.Column;
import org.linlinjava.litemall.db.domain.example.SrenwuExample;

public interface SrenwuMapper {
    long countByExample(SrenwuExample example);

    int deleteByExample(SrenwuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Srenwu record);

    int insertSelective(Srenwu record);

    Srenwu selectOneByExample(SrenwuExample example);

    Srenwu selectOneByExampleSelective(@Param("example") SrenwuExample example, @Param("selective") Column... selective);

    List<Srenwu> selectByExampleSelective(@Param("example") SrenwuExample example, @Param("selective") Column... selective);

    List<Srenwu> selectByExample(SrenwuExample example);

    Srenwu selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Srenwu selectByPrimaryKey(Integer id);

    Srenwu selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Srenwu record, @Param("example") SrenwuExample example);

    int updateByExample(@Param("record") Srenwu record, @Param("example") SrenwuExample example);

    int updateByPrimaryKeySelective(Srenwu record);

    int updateByPrimaryKey(Srenwu record);

    int logicalDeleteByExample(@Param("example") SrenwuExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
