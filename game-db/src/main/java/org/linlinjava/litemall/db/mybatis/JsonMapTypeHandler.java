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
import java.util.Map;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonMapTypeHandler extends BaseTypeHandler<Map<String, Object>> {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(JsonMapTypeHandler.class);

    public JsonMapTypeHandler() {
    }

    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, Object> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, this.toJson(parameter));
    }

    public Map<String, Object> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName));
    }

    public Map<String, Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex));
    }

    public Map<String, Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex));
    }

    private String toJson(Map<String, Object> params) {
        try {
            return mapper.writeValueAsString(params);
        } catch (Exception var3) {
            this.logger.error("", var3);
            return "[]";
        }
    }

    private Map<String, Object> toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return (Map)mapper.readValue(content, Map.class);
            } catch (Exception var3) {
                this.logger.error("", var3);
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }
}
