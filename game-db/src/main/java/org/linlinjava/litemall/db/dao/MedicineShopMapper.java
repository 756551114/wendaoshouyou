//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.MedicineShop;
import org.linlinjava.litemall.db.domain.MedicineShop.Column;
import org.linlinjava.litemall.db.domain.example.MedicineShopExample;

public interface MedicineShopMapper {
    long countByExample(MedicineShopExample example);

    int deleteByExample(MedicineShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineShop record);

    int insertSelective(MedicineShop record);

    MedicineShop selectOneByExample(MedicineShopExample example);

    MedicineShop selectOneByExampleSelective(@Param("example") MedicineShopExample example, @Param("selective") Column... selective);

    List<MedicineShop> selectByExampleSelective(@Param("example") MedicineShopExample example, @Param("selective") Column... selective);

    List<MedicineShop> selectByExample(MedicineShopExample example);

    MedicineShop selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    MedicineShop selectByPrimaryKey(Integer id);

    MedicineShop selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MedicineShop record, @Param("example") MedicineShopExample example);

    int updateByExample(@Param("record") MedicineShop record, @Param("example") MedicineShopExample example);

    int updateByPrimaryKeySelective(MedicineShop record);

    int updateByPrimaryKey(MedicineShop record);

    int logicalDeleteByExample(@Param("example") MedicineShopExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
