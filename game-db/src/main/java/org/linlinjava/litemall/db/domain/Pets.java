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
public class Pets implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String ownerid;
    private String petid;
    private String nickname;
    private String name;
    private Integer horsetype;
    private Integer type;
    private Integer level;
    private Integer liliang;
    private Integer minjie;
    private Integer lingli;
    private Integer tili;
    private Integer dianhualx;
    private Integer dianhuazd;
    private Integer dianhuazx;
    private Integer yuhualx;
    private Integer yuhuazd;
    private Integer yuhuazx;
    private Integer cwjyzx;
    private Integer cwjyzd;
    private Integer feisheng;
    private Integer fsudu;
    private Integer qhcwWg;
    private Integer qhcwFg;
    private Integer cwXiangxing;
    private Integer cwWuxue;
    private String cwIcon;
    private Integer cwXinfa;
    private Integer cwQinmi;
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

    public Pets() {
    }


    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? org.linlinjava.litemall.db.domain.Pets.Deleted.IS_DELETED.value() : org.linlinjava.litemall.db.domain.Pets.Deleted.NOT_DELETED.value());
    }


    static {
        IS_DELETED = org.linlinjava.litemall.db.domain.Pets.Deleted.IS_DELETED.value();
        NOT_DELETED = org.linlinjava.litemall.db.domain.Pets.Deleted.NOT_DELETED.value();
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
        ownerid("ownerid", "ownerid", "VARCHAR", false),
        petid("petid", "petid", "VARCHAR", false),
        nickname("nickname", "nickname", "VARCHAR", false),
        name("name", "name", "VARCHAR", true),
        horsetype("horsetype", "horsetype", "INTEGER", false),
        type("type", "type", "INTEGER", true),
        level("level", "level", "INTEGER", true),
        liliang("liliang", "liliang", "INTEGER", false),
        minjie("minjie", "minjie", "INTEGER", false),
        lingli("lingli", "lingli", "INTEGER", false),
        tili("tili", "tili", "INTEGER", false),
        dianhualx("dianhualx", "dianhualx", "INTEGER", false),
        dianhuazd("dianhuazd", "dianhuazd", "INTEGER", false),
        dianhuazx("dianhuazx", "dianhuazx", "INTEGER", false),
        yuhualx("yuhualx", "yuhualx", "INTEGER", false),
        yuhuazd("yuhuazd", "yuhuazd", "INTEGER", false),
        yuhuazx("yuhuazx", "yuhuazx", "INTEGER", false),
        cwjyzx("cwjyzx", "cwjyzx", "INTEGER", false),
        cwjyzd("cwjyzd", "cwjyzd", "INTEGER", false),
        feisheng("feisheng", "feisheng", "INTEGER", false),
        fsudu("fsudu", "fsudu", "INTEGER", false),
        qhcwWg("qhcw_wg", "qhcwWg", "INTEGER", false),
        qhcwFg("qhcw_fg", "qhcwFg", "INTEGER", false),
        cwXiangxing("cw_xiangxing", "cwXiangxing", "INTEGER", false),
        cwWuxue("cw_wuxue", "cwWuxue", "INTEGER", false),
        cwIcon("cw_icon", "cwIcon", "VARCHAR", false),
        cwXinfa("cw_xinfa", "cwXinfa", "INTEGER", false),
        cwQinmi("cw_qinmi", "cwQinmi", "INTEGER", false),
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
