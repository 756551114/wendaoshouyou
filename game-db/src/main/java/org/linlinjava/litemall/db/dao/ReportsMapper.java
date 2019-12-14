//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Reports;
import org.linlinjava.litemall.db.domain.Reports.Column;
import org.linlinjava.litemall.db.domain.example.ReportsExample;

public interface ReportsMapper {
    long countByExample(ReportsExample example);

    int deleteByExample(ReportsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reports record);

    int insertSelective(Reports record);

    Reports selectOneByExample(ReportsExample example);

    Reports selectOneByExampleSelective(@Param("example") ReportsExample example, @Param("selective") Column... selective);

    List<Reports> selectByExampleSelective(@Param("example") ReportsExample example, @Param("selective") Column... selective);

    List<Reports> selectByExample(ReportsExample example);

    Reports selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Reports selectByPrimaryKey(Integer id);

    Reports selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Reports record, @Param("example") ReportsExample example);

    int updateByExample(@Param("record") Reports record, @Param("example") ReportsExample example);

    int updateByPrimaryKeySelective(Reports record);

    int updateByPrimaryKey(Reports record);

    int logicalDeleteByExample(@Param("example") ReportsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
