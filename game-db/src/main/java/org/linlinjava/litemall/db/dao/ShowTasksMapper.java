//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.ShowTasks;
import org.linlinjava.litemall.db.domain.ShowTasks.Column;
import org.linlinjava.litemall.db.domain.example.ShowTasksExample;

public interface ShowTasksMapper {
    long countByExample(ShowTasksExample example);

    int deleteByExample(ShowTasksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShowTasks record);

    int insertSelective(ShowTasks record);

    ShowTasks selectOneByExample(ShowTasksExample example);

    ShowTasks selectOneByExampleSelective(@Param("example") ShowTasksExample example, @Param("selective") Column... selective);

    List<ShowTasks> selectByExampleSelective(@Param("example") ShowTasksExample example, @Param("selective") Column... selective);

    List<ShowTasks> selectByExample(ShowTasksExample example);

    ShowTasks selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    ShowTasks selectByPrimaryKey(Integer id);

    ShowTasks selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") ShowTasks record, @Param("example") ShowTasksExample example);

    int updateByExample(@Param("record") ShowTasks record, @Param("example") ShowTasksExample example);

    int updateByPrimaryKeySelective(ShowTasks record);

    int updateByPrimaryKey(ShowTasks record);

    int logicalDeleteByExample(@Param("example") ShowTasksExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
