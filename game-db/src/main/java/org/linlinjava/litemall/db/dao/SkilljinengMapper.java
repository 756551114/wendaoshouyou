//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Skilljineng;
import org.linlinjava.litemall.db.domain.Skilljineng.Column;
import org.linlinjava.litemall.db.domain.example.SkilljinengExample;

public interface SkilljinengMapper {
    long countByExample(SkilljinengExample example);

    int deleteByExample(SkilljinengExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Skilljineng record);

    int insertSelective(Skilljineng record);

    Skilljineng selectOneByExample(SkilljinengExample example);

    Skilljineng selectOneByExampleSelective(@Param("example") SkilljinengExample example, @Param("selective") Column... selective);

    List<Skilljineng> selectByExampleSelective(@Param("example") SkilljinengExample example, @Param("selective") Column... selective);

    List<Skilljineng> selectByExample(SkilljinengExample example);

    Skilljineng selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Skilljineng selectByPrimaryKey(Integer id);

    Skilljineng selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Skilljineng record, @Param("example") SkilljinengExample example);

    int updateByExample(@Param("record") Skilljineng record, @Param("example") SkilljinengExample example);

    int updateByPrimaryKeySelective(Skilljineng record);

    int updateByPrimaryKey(Skilljineng record);

    int logicalDeleteByExample(@Param("example") SkilljinengExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
