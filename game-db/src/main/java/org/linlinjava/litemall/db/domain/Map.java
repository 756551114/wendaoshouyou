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
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Map implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String name;
    private Integer mapId;
    private Integer x;
    private Integer y;
    private String icon;
    private Integer monsterLevel;
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

    public Map() {
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

    public Integer getMapId() {
        return this.mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMonsterLevel() {
        return this.monsterLevel;
    }

    public void setMonsterLevel(Integer monsterLevel) {
        this.monsterLevel = monsterLevel;
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
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.Map.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.Map.Deleted.NOT_DELETED.value());
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
        sb.append(", mapId=").append(this.mapId);
        sb.append(", x=").append(this.x);
        sb.append(", y=").append(this.y);
        sb.append(", icon=").append(this.icon);
        sb.append(", monsterLevel=").append(this.monsterLevel);
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
            label112: {
                Map other = (Map)that;
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

                if (this.getMapId() == null) {
                    if (other.getMapId() != null) {
                        break label112;
                    }
                } else if (!this.getMapId().equals(other.getMapId())) {
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

                if (this.getIcon() == null) {
                    if (other.getIcon() != null) {
                        break label112;
                    }
                } else if (!this.getIcon().equals(other.getIcon())) {
                    break label112;
                }

                if (this.getMonsterLevel() == null) {
                    if (other.getMonsterLevel() != null) {
                        break label112;
                    }
                } else if (!this.getMonsterLevel().equals(other.getMonsterLevel())) {
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

    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
        result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
        result = 31 * result + (this.getMapId() == null ? 0 : this.getMapId().hashCode());
        result = 31 * result + (this.getX() == null ? 0 : this.getX().hashCode());
        result = 31 * result + (this.getY() == null ? 0 : this.getY().hashCode());
        result = 31 * result + (this.getIcon() == null ? 0 : this.getIcon().hashCode());
        result = 31 * result + (this.getMonsterLevel() == null ? 0 : this.getMonsterLevel().hashCode());
        result = 31 * result + (this.getAddTime() == null ? 0 : this.getAddTime().hashCode());
        result = 31 * result + (this.getUpdateTime() == null ? 0 : this.getUpdateTime().hashCode());
        result = 31 * result + (this.getDeleted() == null ? 0 : this.getDeleted().hashCode());
        return result;
    }

    public Map clone() throws CloneNotSupportedException {
        return (Map)super.clone();
    }

    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.Map.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.Map.Deleted.NOT_DELETED.value();
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
        mapId("map_id", "mapId", "INTEGER", false),
        x("x", "x", "INTEGER", false),
        y("y", "y", "INTEGER", false),
        icon("icon", "icon", "VARCHAR", false),
        monsterLevel("monster_level", "monsterLevel", "INTEGER", false),
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
            List<Column> columns = new ArrayList(Arrays.asList(values()));
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
