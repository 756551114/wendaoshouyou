//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.Characters.Column;
import org.linlinjava.litemall.db.domain.example.CharactersExample;

public interface CharactersMapper {
    long countByExample(CharactersExample example);

    int deleteByExample(CharactersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Characters record);

    int insertSelective(Characters record);

    Characters selectOneByExample(CharactersExample example);

    Characters selectOneByExampleSelective(@Param("example") CharactersExample example, @Param("selective") Column... selective);

    Characters selectOneByExampleWithBLOBs(CharactersExample example);

    List<Characters> selectByExampleSelective(@Param("example") CharactersExample example, @Param("selective") Column... selective);

    List<Characters> selectByExampleWithBLOBs(CharactersExample example);

    List<Characters> selectByExample(CharactersExample example);

    Characters selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Characters selectByPrimaryKey(Integer id);

    Characters selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Characters record, @Param("example") CharactersExample example);

    int updateByExampleWithBLOBs(@Param("record") Characters record, @Param("example") CharactersExample example);

    int updateByExample(@Param("record") Characters record, @Param("example") CharactersExample example);

    int updateByPrimaryKeySelective(Characters record);

    int updateByPrimaryKeyWithBLOBs(Characters record);

    int updateByPrimaryKey(Characters record);

    int logicalDeleteByExample(@Param("example") CharactersExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
