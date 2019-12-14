//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class SaleGoodWithBLOBs extends SaleGood implements Cloneable, Serializable {
    private String goods;
    private String pet;
    private static final long serialVersionUID = 1L;

    public SaleGoodWithBLOBs() {
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        goodsId("goods_id", "goodsId", "VARCHAR", false),
        name("name", "name", "VARCHAR", true),
        startTime("start_time", "startTime", "INTEGER", false),
        endTime("end_time", "endTime", "INTEGER", false),
        price("price", "price", "INTEGER", false),
        reqLevel("req_level", "reqLevel", "INTEGER", false),
        ownerUuid("owner_uuid", "ownerUuid", "VARCHAR", false),
        str("str", "str", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false),
        pos("pos", "pos", "INTEGER", false),
        goods("goods", "goods", "LONGVARCHAR", false),
        pet("pet", "pet", "LONGVARCHAR", false);

        private static final String BEGINNING_DELIMITER = "`";
        private static final String ENDING_DELIMITER = "`";
        private final String column;
        private final boolean isColumnNameDelimited;
        private final String javaProperty;
        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        private Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column... excludes) {
            ArrayList<Column> columns = new ArrayList(Arrays.asList(values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList(Arrays.asList(excludes)));
            }

            return (Column[])columns.toArray(new Column[0]);
        }

        public String getEscapedColumnName() {
            return this.isColumnNameDelimited ? "`" + this.column + "`" : this.column;
        }
    }



}
