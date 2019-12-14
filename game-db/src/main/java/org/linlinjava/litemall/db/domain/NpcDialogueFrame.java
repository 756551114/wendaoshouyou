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
public class NpcDialogueFrame implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private Integer portrait;
    private Integer picNo;
    private String content;
    private String secretKey;
    private String name;
    private Integer attrib;
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
    private LocalDateTime updateTimes;
    private Boolean deleted;
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
    private Integer idname;
    private String next;
    private String currentTask;
    private String uncontent;
    private String zhuangbei;
    private Integer jingyan;
    private Integer money;
    private static final long serialVersionUID = 1L;

    public NpcDialogueFrame() {
    }


    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.NpcDialogueFrame.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.NpcDialogueFrame.Deleted.NOT_DELETED.value());
    }

    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.NpcDialogueFrame.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.NpcDialogueFrame.Deleted.NOT_DELETED.value();
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
        portrait("portrait", "portrait", "INTEGER", false),
        picNo("pic_no", "picNo", "INTEGER", false),
        content("content", "content", "VARCHAR", false),
        secretKey("secret_key", "secretKey", "VARCHAR", false),
        name("name", "name", "VARCHAR", true),
        attrib("attrib", "attrib", "INTEGER", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTimes("update_times", "updateTimes", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        idname("idname", "idname", "INTEGER", false),
        next("next", "next", "VARCHAR", true),
        currentTask("current_task", "currentTask", "VARCHAR", false),
        uncontent("uncontent", "uncontent", "VARCHAR", false),
        zhuangbei("zhuangbei", "zhuangbei", "VARCHAR", false),
        jingyan("jingyan", "jingyan", "INTEGER", false),
        money("money", "money", "INTEGER", false);

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

            return (Column[]) columns.toArray(new Column[0]);
        }

        public String getEscapedColumnName() {
            return this.isColumnNameDelimited ? "`" + this.column + "`" : this.column;
        }
    }
}
