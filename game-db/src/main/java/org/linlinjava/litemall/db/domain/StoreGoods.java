//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class StoreGoods implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String name;
    private String barcode;
    private Integer forSale;
    private Integer showPos;
    private Integer rpos;
    private Integer saleQuota;
    private Integer recommend;
    private Integer coin;
    private Integer discount;
    private Integer type;
    private Integer quotaLimit;
    private Integer mustVip;
    private Integer isGift;
    private Integer followPetType;
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateTimeSerializer.class
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime addTime;
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateTimeSerializer.class
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime updateTime;
    private Boolean deleted;
    private static final long serialVersionUID = 1L;

    public StoreGoods() {
    }



    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.StoreGoods.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.StoreGoods.Deleted.NOT_DELETED.value());
    }






    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.StoreGoods.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.StoreGoods.Deleted.NOT_DELETED.value();
    }

    public enum Deleted {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        private final Boolean value;
        private final String name;

        private Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        public Boolean getValue() {
            return this.value;
        }

        public Boolean value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        name("name", "name", "VARCHAR", true),
        barcode("barcode", "barcode", "VARCHAR", false),
        forSale("for_sale", "forSale", "INTEGER", false),
        showPos("show_pos", "showPos", "INTEGER", false),
        rpos("rpos", "rpos", "INTEGER", false),
        saleQuota("sale_quota", "saleQuota", "INTEGER", false),
        recommend("recommend", "recommend", "INTEGER", false),
        coin("coin", "coin", "INTEGER", false),
        discount("discount", "discount", "INTEGER", false),
        type("type", "type", "INTEGER", true),
        quotaLimit("quota_limit", "quotaLimit", "INTEGER", false),
        mustVip("must_vip", "mustVip", "INTEGER", false),
        isGift("is_gift", "isGift", "INTEGER", false),
        followPetType("follow_pet_type", "followPetType", "INTEGER", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

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
