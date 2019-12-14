//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.db.domain.SaleClassifyGood.Column;
import org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample;

public interface SaleClassifyGoodMapper {
    long countByExample(SaleClassifyGoodExample example);

    int deleteByExample(SaleClassifyGoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleClassifyGood record);

    int insertSelective(SaleClassifyGood record);

    SaleClassifyGood selectOneByExample(SaleClassifyGoodExample example);

    SaleClassifyGood selectOneByExampleSelective(@Param("example") SaleClassifyGoodExample example, @Param("selective") Column... selective);

    List<SaleClassifyGood> selectByExampleSelective(@Param("example") SaleClassifyGoodExample example, @Param("selective") Column... selective);

    List<SaleClassifyGood> selectByExample(SaleClassifyGoodExample example);

    SaleClassifyGood selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    SaleClassifyGood selectByPrimaryKey(Integer id);

    SaleClassifyGood selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") SaleClassifyGood record, @Param("example") SaleClassifyGoodExample example);

    int updateByExample(@Param("record") SaleClassifyGood record, @Param("example") SaleClassifyGoodExample example);

    int updateByPrimaryKeySelective(SaleClassifyGood record);

    int updateByPrimaryKey(SaleClassifyGood record);

    int logicalDeleteByExample(@Param("example") SaleClassifyGoodExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
