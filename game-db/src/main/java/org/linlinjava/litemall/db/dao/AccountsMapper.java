//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.Accounts.Column;
import org.linlinjava.litemall.db.domain.example.AccountsExample;

public interface AccountsMapper {
    long countByExample(AccountsExample example);

    int deleteByExample(AccountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accounts record);

    int insertSelective(Accounts record);

    Accounts selectOneByExample(AccountsExample example);

    Accounts selectOneByExampleSelective(@Param("example") AccountsExample example, @Param("selective") Column... selective);

    List<Accounts> selectByExampleSelective(@Param("example") AccountsExample example, @Param("selective") Column... selective);

    List<Accounts> selectByExample(AccountsExample example);

    Accounts selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Column... selective);

    Accounts selectByPrimaryKey(Integer id);

    Accounts selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByExample(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByPrimaryKeySelective(Accounts record);

    int updateByPrimaryKey(Accounts record);

    int logicalDeleteByExample(@Param("example") AccountsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
