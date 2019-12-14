//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.DaySignPrize;
import org.linlinjava.litemall.db.domain.DaySignPrize.Column;
import org.linlinjava.litemall.db.domain.example.DaySignPrizeExample;

public interface DaySignPrizeMapper {
    long countByExample(DaySignPrizeExample example);

    int deleteByExample(DaySignPrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DaySignPrize record);

    int insertSelective(DaySignPrize record);

    DaySignPrize selectOneByExample(DaySignPrizeExample example);

    DaySignPrize selectOneByExampleSelective(@Param("example") DaySignPrizeExample example, @Param("selective") Column... selective);

    List<DaySignPrize> selectByExampleSelective(@Param("example") DaySignPrizeExample example, @Param("selective") Column... selective);

    List<DaySignPrize> selectByExample(DaySignPrizeExample example);

    DaySignPrize selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    DaySignPrize selectByPrimaryKey(Integer id);

    DaySignPrize selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") DaySignPrize record, @Param("example") DaySignPrizeExample example);

    int updateByExample(@Param("record") DaySignPrize record, @Param("example") DaySignPrizeExample example);

    int updateByPrimaryKeySelective(DaySignPrize record);

    int updateByPrimaryKey(DaySignPrize record);

    int logicalDeleteByExample(@Param("example") DaySignPrizeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
