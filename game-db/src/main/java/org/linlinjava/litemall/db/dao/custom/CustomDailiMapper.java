//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.dao.custom;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustomDailiMapper {
    @Select({"select `code`,COUNT(*) as num from accounts WHERE `code` LIKE CONCAT(#{name},'%') group by `code` ;"})
    List<Map> selectCount(@Param("name") String name);

    @Select({"select `code`,SUM(money) as num from charge WHERE `code` LIKE CONCAT(#{name},'%') and DATE(add_time) = DATE(CURDATE()-#{day})  group by `code` ;"})
    List<Map> selectMoney(@Param("name") String name, @Param("day") int day);

    @Select({"select COUNT(*) as num from accounts WHERE `CODE` LIKE CONCAT(#{name},'%') group by `code`;"})
    List<Map> selectAccount(@Param("name") String name);
}
