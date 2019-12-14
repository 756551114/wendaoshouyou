//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Friends;
import org.linlinjava.litemall.db.domain.Friends.Column;
import org.linlinjava.litemall.db.domain.example.FriendsExample;

public interface FriendsMapper {
    long countByExample(FriendsExample example);

    int deleteByExample(FriendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectOneByExample(FriendsExample example);

    Friends selectOneByExampleSelective(@Param("example") FriendsExample example, @Param("selective") Column... selective);

    List<Friends> selectByExampleSelective(@Param("example") FriendsExample example, @Param("selective") Column... selective);

    List<Friends> selectByExample(FriendsExample example);

    Friends selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Friends selectByPrimaryKey(Integer id);

    Friends selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);

    int logicalDeleteByExample(@Param("example") FriendsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
