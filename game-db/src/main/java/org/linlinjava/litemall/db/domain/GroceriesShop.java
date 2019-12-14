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

import org.springframework.format.annotation.DateTimeFormat;

public class GroceriesShop implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private Integer goodsNo;
    private Integer payType;
    private String name;
    private Integer value;
    private Integer level;
    private Integer type;
    private Integer itemcount;
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

    public GroceriesShop() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsNo() {
        return this.goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getItemcount() {
        return this.itemcount;
    }

    public void setItemcount(Integer itemcount) {
        this.itemcount = itemcount;
    }

    public LocalDateTime getAddTime() {
        return this.addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.GroceriesShop.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.GroceriesShop.Deleted.NOT_DELETED.value());
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(this.id);
        sb.append(", goodsNo=").append(this.goodsNo);
        sb.append(", payType=").append(this.payType);
        sb.append(", name=").append(this.name);
        sb.append(", value=").append(this.value);
        sb.append(", level=").append(this.level);
        sb.append(", type=").append(this.type);
        sb.append(", itemcount=").append(this.itemcount);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that == null) {
            return false;
        } else if (this.getClass() != that.getClass()) {
            return false;
        } else {
            boolean var10000;
            label121: {
                label113: {
                    GroceriesShop other = (GroceriesShop)that;
                    if (this.getId() == null) {
                        if (other.getId() != null) {
                            break label113;
                        }
                    } else if (!this.getId().equals(other.getId())) {
                        break label113;
                    }

                    if (this.getGoodsNo() == null) {
                        if (other.getGoodsNo() != null) {
                            break label113;
                        }
                    } else if (!this.getGoodsNo().equals(other.getGoodsNo())) {
                        break label113;
                    }

                    if (this.getPayType() == null) {
                        if (other.getPayType() != null) {
                            break label113;
                        }
                    } else if (!this.getPayType().equals(other.getPayType())) {
                        break label113;
                    }

                    if (this.getName() == null) {
                        if (other.getName() != null) {
                            break label113;
                        }
                    } else if (!this.getName().equals(other.getName())) {
                        break label113;
                    }

                    if (this.getValue() == null) {
                        if (other.getValue() != null) {
                            break label113;
                        }
                    } else if (!this.getValue().equals(other.getValue())) {
                        break label113;
                    }

                    if (this.getLevel() == null) {
                        if (other.getLevel() != null) {
                            break label113;
                        }
                    } else if (!this.getLevel().equals(other.getLevel())) {
                        break label113;
                    }

                    if (this.getType() == null) {
                        if (other.getType() != null) {
                            break label113;
                        }
                    } else if (!this.getType().equals(other.getType())) {
                        break label113;
                    }

                    if (this.getItemcount() == null) {
                        if (other.getItemcount() != null) {
                            break label113;
                        }
                    } else if (!this.getItemcount().equals(other.getItemcount())) {
                        break label113;
                    }

                    if (this.getAddTime() == null) {
                        if (other.getAddTime() != null) {
                            break label113;
                        }
                    } else if (!this.getAddTime().equals(other.getAddTime())) {
                        break label113;
                    }

                    if (this.getUpdateTime() == null) {
                        if (other.getUpdateTime() != null) {
                            break label113;
                        }
                    } else if (!this.getUpdateTime().equals(other.getUpdateTime())) {
                        break label113;
                    }

                    if (this.getDeleted() == null) {
                        if (other.getDeleted() == null) {
                            break label121;
                        }
                    } else if (this.getDeleted().equals(other.getDeleted())) {
                        break label121;
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
         result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
        result = 31 * result + (this.getGoodsNo() == null ? 0 : this.getGoodsNo().hashCode());
        result = 31 * result + (this.getPayType() == null ? 0 : this.getPayType().hashCode());
        result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
        result = 31 * result + (this.getValue() == null ? 0 : this.getValue().hashCode());
        result = 31 * result + (this.getLevel() == null ? 0 : this.getLevel().hashCode());
        result = 31 * result + (this.getType() == null ? 0 : this.getType().hashCode());
        result = 31 * result + (this.getItemcount() == null ? 0 : this.getItemcount().hashCode());
        result = 31 * result + (this.getAddTime() == null ? 0 : this.getAddTime().hashCode());
        result = 31 * result + (this.getUpdateTime() == null ? 0 : this.getUpdateTime().hashCode());
        result = 31 * result + (this.getDeleted() == null ? 0 : this.getDeleted().hashCode());
        return result;
    }

    @Override
    protected GroceriesShop clone() throws CloneNotSupportedException {
        return (GroceriesShop)super.clone();
    }

    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.GroceriesShop.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.GroceriesShop.Deleted.NOT_DELETED.value();
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
        goodsNo("goods_no", "goodsNo", "INTEGER", false),
        payType("pay_type", "payType", "INTEGER", false),
        name("name", "name", "VARCHAR", true),
        value("value", "value", "INTEGER", true),
        level("level", "level", "INTEGER", true),
        type("type", "type", "INTEGER", true),
        itemcount("itemCount", "itemcount", "INTEGER", false),
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
