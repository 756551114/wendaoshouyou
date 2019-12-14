//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.StoreInfo.Column;
import org.linlinjava.litemall.db.domain.example.StoreInfoExample;

public interface StoreInfoMapper {
    long countByExample(StoreInfoExample example);

    int deleteByExample(StoreInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreInfo record);

    int insertSelective(StoreInfo record);

    StoreInfo selectOneByExample(StoreInfoExample example);

    StoreInfo selectOneByExampleSelective(@Param("example") StoreInfoExample example, @Param("selective") Column... selective);

    List<StoreInfo> selectByExampleSelective(@Param("example") StoreInfoExample example, @Param("selective") Column... selective);

    List<StoreInfo> selectByExample(StoreInfoExample example);

    StoreInfo selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    StoreInfo selectByPrimaryKey(Integer id);

    StoreInfo selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") StoreInfo record, @Param("example") StoreInfoExample example);

    int updateByExample(@Param("record") StoreInfo record, @Param("example") StoreInfoExample example);

    int updateByPrimaryKeySelective(StoreInfo record);

    int updateByPrimaryKey(StoreInfo record);

    int logicalDeleteByExample(@Param("example") StoreInfoExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
