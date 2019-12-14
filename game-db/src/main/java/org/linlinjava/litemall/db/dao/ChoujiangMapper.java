//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Choujiang;
import org.linlinjava.litemall.db.domain.Choujiang.Column;
import org.linlinjava.litemall.db.domain.example.ChoujiangExample;

public interface ChoujiangMapper {
    long countByExample(ChoujiangExample example);

    int deleteByExample(ChoujiangExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Choujiang record);

    int insertSelective(Choujiang record);

    Choujiang selectOneByExample(ChoujiangExample example);

    Choujiang selectOneByExampleSelective(@Param("example") ChoujiangExample example, @Param("selective") Column... selective);

    List<Choujiang> selectByExampleSelective(@Param("example") ChoujiangExample example, @Param("selective") Column... selective);

    List<Choujiang> selectByExample(ChoujiangExample example);

    Choujiang selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Choujiang selectByPrimaryKey(Integer id);

    Choujiang selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Choujiang record, @Param("example") ChoujiangExample example);

    int updateByExample(@Param("record") Choujiang record, @Param("example") ChoujiangExample example);

    int updateByPrimaryKeySelective(Choujiang record);

    int updateByPrimaryKey(Choujiang record);

    int logicalDeleteByExample(@Param("example") ChoujiangExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
