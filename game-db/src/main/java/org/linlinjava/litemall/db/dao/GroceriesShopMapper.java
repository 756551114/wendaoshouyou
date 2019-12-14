//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.GroceriesShop;
import org.linlinjava.litemall.db.domain.GroceriesShop.Column;
import org.linlinjava.litemall.db.domain.example.GroceriesShopExample;

public interface GroceriesShopMapper {
    long countByExample(GroceriesShopExample example);

    int deleteByExample(GroceriesShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroceriesShop record);

    int insertSelective(GroceriesShop record);

    GroceriesShop selectOneByExample(GroceriesShopExample example);

    GroceriesShop selectOneByExampleSelective(@Param("example") GroceriesShopExample example, @Param("selective") Column... selective);

    List<GroceriesShop> selectByExampleSelective(@Param("example") GroceriesShopExample example, @Param("selective") Column... selective);

    List<GroceriesShop> selectByExample(GroceriesShopExample example);

    GroceriesShop selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    GroceriesShop selectByPrimaryKey(Integer id);

    GroceriesShop selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") GroceriesShop record, @Param("example") GroceriesShopExample example);

    int updateByExample(@Param("record") GroceriesShop record, @Param("example") GroceriesShopExample example);

    int updateByPrimaryKeySelective(GroceriesShop record);

    int updateByPrimaryKey(GroceriesShop record);

    int logicalDeleteByExample(@Param("example") GroceriesShopExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
