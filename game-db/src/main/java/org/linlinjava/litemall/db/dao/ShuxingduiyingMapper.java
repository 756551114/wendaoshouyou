//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Shuxingduiying;
import org.linlinjava.litemall.db.domain.Shuxingduiying.Column;
import org.linlinjava.litemall.db.domain.example.ShuxingduiyingExample;

public interface ShuxingduiyingMapper {
    long countByExample(ShuxingduiyingExample example);

    int deleteByExample(ShuxingduiyingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shuxingduiying record);

    int insertSelective(Shuxingduiying record);

    Shuxingduiying selectOneByExample(ShuxingduiyingExample example);

    Shuxingduiying selectOneByExampleSelective(@Param("example") ShuxingduiyingExample example, @Param("selective") Column... selective);

    List<Shuxingduiying> selectByExampleSelective(@Param("example") ShuxingduiyingExample example, @Param("selective") Column... selective);

    List<Shuxingduiying> selectByExample(ShuxingduiyingExample example);

    Shuxingduiying selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Shuxingduiying selectByPrimaryKey(Integer id);

    Shuxingduiying selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Shuxingduiying record, @Param("example") ShuxingduiyingExample example);

    int updateByExample(@Param("record") Shuxingduiying record, @Param("example") ShuxingduiyingExample example);

    int updateByPrimaryKeySelective(Shuxingduiying record);

    int updateByPrimaryKey(Shuxingduiying record);

    int logicalDeleteByExample(@Param("example") ShuxingduiyingExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
