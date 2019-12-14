//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.RenwuMonster;
import org.linlinjava.litemall.db.domain.RenwuMonster.Column;
import org.linlinjava.litemall.db.domain.example.RenwuMonsterExample;

public interface RenwuMonsterMapper {
    long countByExample(RenwuMonsterExample example);

    int deleteByExample(RenwuMonsterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RenwuMonster record);

    int insertSelective(RenwuMonster record);

    RenwuMonster selectOneByExample(RenwuMonsterExample example);

    RenwuMonster selectOneByExampleSelective(@Param("example") RenwuMonsterExample example, @Param("selective") Column... selective);

    List<RenwuMonster> selectByExampleSelective(@Param("example") RenwuMonsterExample example, @Param("selective") Column... selective);

    List<RenwuMonster> selectByExample(RenwuMonsterExample example);

    RenwuMonster selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    RenwuMonster selectByPrimaryKey(Integer id);

    RenwuMonster selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") RenwuMonster record, @Param("example") RenwuMonsterExample example);

    int updateByExample(@Param("record") RenwuMonster record, @Param("example") RenwuMonsterExample example);

    int updateByPrimaryKeySelective(RenwuMonster record);

    int updateByPrimaryKey(RenwuMonster record);

    int logicalDeleteByExample(@Param("example") RenwuMonsterExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
