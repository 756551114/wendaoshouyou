//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.mybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonListTypeHandler extends BaseTypeHandler<List> {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(JsonListTypeHandler.class);

    public JsonListTypeHandler() {
    }

    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, this.toJson(parameter));
    }

    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName));
    }

    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex));
    }

    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex));
    }

    private String toJson(List params) {
        try {
            return mapper.writeValueAsString(params);
        } catch (Exception var3) {
            this.logger.error("", var3);
            return "[]";
        }
    }

    private List toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return (List)mapper.readValue(content, List.class);
            } catch (Exception var3) {
                this.logger.error("", var3);
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }
}
