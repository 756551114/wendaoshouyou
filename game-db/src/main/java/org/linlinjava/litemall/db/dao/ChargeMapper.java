//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Charge;
import org.linlinjava.litemall.db.domain.Charge.Column;
import org.linlinjava.litemall.db.domain.example.ChargeExample;

public interface ChargeMapper {
    long countByExample(ChargeExample example);

    int deleteByExample(ChargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Charge record);

    int insertSelective(Charge record);

    Charge selectOneByExample(ChargeExample example);

    Charge selectOneByExampleSelective(@Param("example") ChargeExample example, @Param("selective") Column... selective);

    List<Charge> selectByExampleSelective(@Param("example") ChargeExample example, @Param("selective") Column... selective);

    List<Charge> selectByExample(ChargeExample example);

    Charge selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Charge selectByPrimaryKey(Integer id);

    Charge selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByExample(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);

    int logicalDeleteByExample(@Param("example") ChargeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
