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

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class NpcPoint implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String mapname;
    private String doorname;
    private Integer x;
    private Integer y;
    private Integer z;
    private Integer inx;
    private Integer iny;
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

    public NpcPoint() {
    }



    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.NpcPoint.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.NpcPoint.Deleted.NOT_DELETED.value());
    }



    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.NpcPoint.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.NpcPoint.Deleted.NOT_DELETED.value();
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
        mapname("mapname", "mapname", "VARCHAR", false),
        doorname("doorname", "doorname", "VARCHAR", false),
        x("x", "x", "INTEGER", false),
        y("y", "y", "INTEGER", false),
        z("z", "z", "INTEGER", false),
        inx("inx", "inx", "INTEGER", false),
        iny("iny", "iny", "INTEGER", false),
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