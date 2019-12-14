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

public class Maps implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String name;
    private Integer type;
    private Integer map;
    private Float dir;
    private Float x;
    private Float y;
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

    public Maps() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMap() {
        return this.map;
    }

    public void setMap(Integer map) {
        this.map = map;
    }

    public Float getDir() {
        return this.dir;
    }

    public void setDir(Float dir) {
        this.dir = dir;
    }

    public Float getX() {
        return this.x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return this.y;
    }

    public void setY(Float y) {
        this.y = y;
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
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.Maps.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.Maps.Deleted.NOT_DELETED.value());
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
        sb.append(", name=").append(this.name);
        sb.append(", type=").append(this.type);
        sb.append(", map=").append(this.map);
        sb.append(", dir=").append(this.dir);
        sb.append(", x=").append(this.x);
        sb.append(", y=").append(this.y);
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
            label112: {
                Maps other = (Maps)that;
                if (this.getId() == null) {
                    if (other.getId() != null) {
                        break label112;
                    }
                } else if (!this.getId().equals(other.getId())) {
                    break label112;
                }

                if (this.getName() == null) {
                    if (other.getName() != null) {
                        break label112;
                    }
                } else if (!this.getName().equals(other.getName())) {
                    break label112;
                }

                if (this.getType() == null) {
                    if (other.getType() != null) {
                        break label112;
                    }
                } else if (!this.getType().equals(other.getType())) {
                    break label112;
                }

                if (this.getMap() == null) {
                    if (other.getMap() != null) {
                        break label112;
                    }
                } else if (!this.getMap().equals(other.getMap())) {
                    break label112;
                }

                if (this.getDir() == null) {
                    if (other.getDir() != null) {
                        break label112;
                    }
                } else if (!this.getDir().equals(other.getDir())) {
                    break label112;
                }

                if (this.getX() == null) {
                    if (other.getX() != null) {
                        break label112;
                    }
                } else if (!this.getX().equals(other.getX())) {
                    break label112;
                }

                if (this.getY() == null) {
                    if (other.getY() != null) {
                        break label112;
                    }
                } else if (!this.getY().equals(other.getY())) {
                    break label112;
                }

                if (this.getAddTime() == null) {
                    if (other.getAddTime() != null) {
                        break label112;
                    }
                } else if (!this.getAddTime().equals(other.getAddTime())) {
                    break label112;
                }

                if (this.getUpdateTime() == null) {
                    if (other.getUpdateTime() != null) {
                        break label112;
                    }
                } else if (!this.getUpdateTime().equals(other.getUpdateTime())) {
                    break label112;
                }

                if (this.getDeleted() == null) {
                    if (other.getDeleted() != null) {
                        break label112;
                    }
                } else if (!this.getDeleted().equals(other.getDeleted())) {
                    break label112;
                }

                var10000 = true;
                return var10000;
            }

            var10000 = false;
            return var10000;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
        result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
        result = 31 * result + (this.getType() == null ? 0 : this.getType().hashCode());
        result = 31 * result + (this.getMap() == null ? 0 : this.getMap().hashCode());
        result = 31 * result + (this.getDir() == null ? 0 : this.getDir().hashCode());
        result = 31 * result + (this.getX() == null ? 0 : this.getX().hashCode());
        result = 31 * result + (this.getY() == null ? 0 : this.getY().hashCode());
        result = 31 * result + (this.getAddTime() == null ? 0 : this.getAddTime().hashCode());
        result = 31 * result + (this.getUpdateTime() == null ? 0 : this.getUpdateTime().hashCode());
        result = 31 * result + (this.getDeleted() == null ? 0 : this.getDeleted().hashCode());
        return result;
    }

    @Override
    public Maps clone() throws CloneNotSupportedException {
        return (Maps)super.clone();
    }

    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.Maps.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.Maps.Deleted.NOT_DELETED.value();
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
        type("type", "type", "INTEGER", true),
        map("map", "map", "INTEGER", true),
        dir("dir", "dir", "REAL", false),
        x("x", "x", "REAL", false),
        y("y", "y", "REAL", false),
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
            ArrayList
                    <Column> columns = new ArrayList(Arrays.asList(values()));
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
