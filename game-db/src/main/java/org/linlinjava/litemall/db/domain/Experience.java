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
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Experience implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer attrib;
    private Integer maxLevel;
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

    public Experience() {
    }

    public Integer getAttrib() {
        return this.attrib;
    }

    public void setAttrib(Integer attrib) {
        this.attrib = attrib;
    }

    public Integer getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
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
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.Experience.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.Experience.Deleted.NOT_DELETED.value());
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", attrib=").append(this.attrib);
        sb.append(", maxLevel=").append(this.maxLevel);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that == null) {
            return false;
        } else if (this.getClass() != that.getClass()) {
            return false;
        } else {
            boolean var10000;
            label73: {
                label65: {
                    Experience other = (Experience)that;
                    if (this.getAttrib() == null) {
                        if (other.getAttrib() != null) {
                            break label65;
                        }
                    } else if (!this.getAttrib().equals(other.getAttrib())) {
                        break label65;
                    }

                    if (this.getMaxLevel() == null) {
                        if (other.getMaxLevel() != null) {
                            break label65;
                        }
                    } else if (!this.getMaxLevel().equals(other.getMaxLevel())) {
                        break label65;
                    }

                    if (this.getAddTime() == null) {
                        if (other.getAddTime() != null) {
                            break label65;
                        }
                    } else if (!this.getAddTime().equals(other.getAddTime())) {
                        break label65;
                    }

                    if (this.getUpdateTime() == null) {
                        if (other.getUpdateTime() != null) {
                            break label65;
                        }
                    } else if (!this.getUpdateTime().equals(other.getUpdateTime())) {
                        break label65;
                    }

                    if (this.getDeleted() == null) {
                        if (other.getDeleted() == null) {
                            break label73;
                        }
                    } else if (this.getDeleted().equals(other.getDeleted())) {
                        break label73;
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        }
    }

    public int hashCode() {
        int result = 1;
         result = 31 * result + (this.getAttrib() == null ? 0 : this.getAttrib().hashCode());
        result = 31 * result + (this.getMaxLevel() == null ? 0 : this.getMaxLevel().hashCode());
        result = 31 * result + (this.getAddTime() == null ? 0 : this.getAddTime().hashCode());
        result = 31 * result + (this.getUpdateTime() == null ? 0 : this.getUpdateTime().hashCode());
        result = 31 * result + (this.getDeleted() == null ? 0 : this.getDeleted().hashCode());
        return result;
    }

    public Experience clone() throws CloneNotSupportedException {
        return (Experience)super.clone();
    }

    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.Experience.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.Experience.Deleted.NOT_DELETED.value();
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
        attrib("attrib", "attrib", "INTEGER", false),
        maxLevel("max_level", "maxLevel", "INTEGER", false),
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
            List<Column> columns = Arrays.asList(values());
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(Arrays.asList(excludes));
            }

            return (Column[])columns.toArray(new Column[0]);
        }

        public String getEscapedColumnName() {
            return this.isColumnNameDelimited ? "`" + this.column + "`" : this.column;
        }
    }


}
