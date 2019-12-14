//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.db.domain.StoreGoods.Column;
import org.linlinjava.litemall.db.domain.example.StoreGoodsExample;

public interface StoreGoodsMapper {
    long countByExample(StoreGoodsExample example);

    int deleteByExample(StoreGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreGoods record);

    int insertSelective(StoreGoods record);

    StoreGoods selectOneByExample(StoreGoodsExample example);

    StoreGoods selectOneByExampleSelective(@Param("example") StoreGoodsExample example, @Param("selective") Column... selective);

    List<StoreGoods> selectByExampleSelective(@Param("example") StoreGoodsExample example, @Param("selective") Column... selective);

    List<StoreGoods> selectByExample(StoreGoodsExample example);

    StoreGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    StoreGoods selectByPrimaryKey(Integer id);

    StoreGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByExample(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByPrimaryKeySelective(StoreGoods record);

    int updateByPrimaryKey(StoreGoods record);

    int logicalDeleteByExample(@Param("example") StoreGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
