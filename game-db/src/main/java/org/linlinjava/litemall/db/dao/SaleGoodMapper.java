//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.domain.SaleGood.Column;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample;

public interface SaleGoodMapper {
    long countByExample(SaleGoodExample example);

    int deleteByExample(SaleGoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleGood record);

    int insertSelective(SaleGood record);

    SaleGood selectOneByExample(SaleGoodExample example);

    SaleGood selectOneByExampleSelective(@Param("example") SaleGoodExample example, @Param("selective") Column... selective);

    SaleGood selectOneByExampleWithBLOBs(SaleGoodExample example);

    List<SaleGood> selectByExampleSelective(@Param("example") SaleGoodExample example, @Param("selective") Column... selective);

    List<SaleGood> selectByExampleWithBLOBs(SaleGoodExample example);

    List<SaleGood> selectByExample(SaleGoodExample example);

    SaleGood selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    SaleGood selectByPrimaryKey(Integer id);

    SaleGood selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") SaleGood record, @Param("example") SaleGoodExample example);

    int updateByExampleWithBLOBs(@Param("record") SaleGood record, @Param("example") SaleGoodExample example);

    int updateByExample(@Param("record") SaleGood record, @Param("example") SaleGoodExample example);

    int updateByPrimaryKeySelective(SaleGood record);

    int updateByPrimaryKeyWithBLOBs(SaleGood record);

    int updateByPrimaryKey(SaleGood record);

    int logicalDeleteByExample(@Param("example") SaleGoodExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
