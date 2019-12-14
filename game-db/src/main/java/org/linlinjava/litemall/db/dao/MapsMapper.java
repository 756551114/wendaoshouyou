//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Maps;
import org.linlinjava.litemall.db.domain.Maps.Column;
import org.linlinjava.litemall.db.domain.example.MapsExample;

public interface MapsMapper {
    long countByExample(MapsExample example);

    int deleteByExample(MapsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Maps record);

    int insertSelective(Maps record);

    Maps selectOneByExample(MapsExample example);

    Maps selectOneByExampleSelective(@Param("example") MapsExample example, @Param("selective") Column... selective);

    List<Maps> selectByExampleSelective(@Param("example") MapsExample example, @Param("selective") Column... selective);

    List<Maps> selectByExample(MapsExample example);

    Maps selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Maps selectByPrimaryKey(Integer id);

    Maps selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Maps record, @Param("example") MapsExample example);

    int updateByExample(@Param("record") Maps record, @Param("example") MapsExample example);

    int updateByPrimaryKeySelective(Maps record);

    int updateByPrimaryKey(Maps record);

    int logicalDeleteByExample(@Param("example") MapsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
