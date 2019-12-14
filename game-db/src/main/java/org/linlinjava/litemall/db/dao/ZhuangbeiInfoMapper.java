//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo.Column;
import org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample;

public interface ZhuangbeiInfoMapper {
    long countByExample(ZhuangbeiInfoExample example);

    int deleteByExample(ZhuangbeiInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZhuangbeiInfo record);

    int insertSelective(ZhuangbeiInfo record);

    ZhuangbeiInfo selectOneByExample(ZhuangbeiInfoExample example);

    ZhuangbeiInfo selectOneByExampleSelective(@Param("example") ZhuangbeiInfoExample example, @Param("selective") Column... selective);

    List<ZhuangbeiInfo> selectByExampleSelective(@Param("example") ZhuangbeiInfoExample example, @Param("selective") Column... selective);

    List<ZhuangbeiInfo> selectByExample(ZhuangbeiInfoExample example);

    ZhuangbeiInfo selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    ZhuangbeiInfo selectByPrimaryKey(Integer id);

    ZhuangbeiInfo selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") ZhuangbeiInfo record, @Param("example") ZhuangbeiInfoExample example);

    int updateByExample(@Param("record") ZhuangbeiInfo record, @Param("example") ZhuangbeiInfoExample example);

    int updateByPrimaryKeySelective(ZhuangbeiInfo record);

    int updateByPrimaryKey(ZhuangbeiInfo record);

    int logicalDeleteByExample(@Param("example") ZhuangbeiInfoExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
