//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Skills.*;

public class SkillsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria> oredCriteria = new ArrayList();

    public SkillsExample() {
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SkillsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SkillsExample orderBy(String... orderByClauses) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < orderByClauses.length; ++i) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }

        this.setOrderByClause(sb.toString());
        return this;
    }

    public org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria newAndCreateCriteria() {
        SkillsExample example = new SkillsExample();
        return example.createCriteria();
    }

    public SkillsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SkillsExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public SkillsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SkillsExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.SkillsExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(SkillsExample example);
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }



    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }

        }

        protected Criterion(String condition, Object value) {
            this(condition, value, (String)null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, (String)null);
        }
    }



    public static abstract class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Integer value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdEqualToColumn(Column column) {
            this.addCriterion("id = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualToColumn(Column column) {
            this.addCriterion("id <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanColumn(Column column) {
            this.addCriterion("id > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("id >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Integer value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanColumn(Column column) {
            this.addCriterion("id < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("id <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdIn(List<Integer> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexIsNull() {
            this.addCriterion("skill_id_hex is null");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexIsNotNull() {
            this.addCriterion("skill_id_hex is not null");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexEqualTo(String value) {
            this.addCriterion("skill_id_hex =", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexEqualToColumn(Column column) {
            this.addCriterion("skill_id_hex = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexNotEqualTo(String value) {
            this.addCriterion("skill_id_hex <>", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexNotEqualToColumn(Column column) {
            this.addCriterion("skill_id_hex <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexGreaterThan(String value) {
            this.addCriterion("skill_id_hex >", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexGreaterThanColumn(Column column) {
            this.addCriterion("skill_id_hex > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_id_hex >=", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_id_hex >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexLessThan(String value) {
            this.addCriterion("skill_id_hex <", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexLessThanColumn(Column column) {
            this.addCriterion("skill_id_hex < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexLessThanOrEqualTo(String value) {
            this.addCriterion("skill_id_hex <=", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_id_hex <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillIdHexLike(String value) {
            this.addCriterion("skill_id_hex like", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexNotLike(String value) {
            this.addCriterion("skill_id_hex not like", value, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexIn(List<String> values) {
            this.addCriterion("skill_id_hex in", values, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexNotIn(List<String> values) {
            this.addCriterion("skill_id_hex not in", values, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexBetween(String value1, String value2) {
            this.addCriterion("skill_id_hex between", value1, value2, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillIdHexNotBetween(String value1, String value2) {
            this.addCriterion("skill_id_hex not between", value1, value2, "skillIdHex");
            return (Criteria)this;
        }

        public Criteria andSkillNameIsNull() {
            this.addCriterion("skill_name is null");
            return (Criteria)this;
        }

        public Criteria andSkillNameIsNotNull() {
            this.addCriterion("skill_name is not null");
            return (Criteria)this;
        }

        public Criteria andSkillNameEqualTo(String value) {
            this.addCriterion("skill_name =", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameEqualToColumn(Column column) {
            this.addCriterion("skill_name = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameNotEqualTo(String value) {
            this.addCriterion("skill_name <>", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotEqualToColumn(Column column) {
            this.addCriterion("skill_name <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThan(String value) {
            this.addCriterion("skill_name >", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanColumn(Column column) {
            this.addCriterion("skill_name > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_name >=", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_name >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThan(String value) {
            this.addCriterion("skill_name <", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanColumn(Column column) {
            this.addCriterion("skill_name < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanOrEqualTo(String value) {
            this.addCriterion("skill_name <=", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_name <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLike(String value) {
            this.addCriterion("skill_name like", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotLike(String value) {
            this.addCriterion("skill_name not like", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameIn(List<String> values) {
            this.addCriterion("skill_name in", values, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotIn(List<String> values) {
            this.addCriterion("skill_name not in", values, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameBetween(String value1, String value2) {
            this.addCriterion("skill_name between", value1, value2, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotBetween(String value1, String value2) {
            this.addCriterion("skill_name not between", value1, value2, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiIsNull() {
            this.addCriterion("skill_req_menpai is null");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiIsNotNull() {
            this.addCriterion("skill_req_menpai is not null");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiEqualTo(Integer value) {
            this.addCriterion("skill_req_menpai =", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiEqualToColumn(Column column) {
            this.addCriterion("skill_req_menpai = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiNotEqualTo(Integer value) {
            this.addCriterion("skill_req_menpai <>", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiNotEqualToColumn(Column column) {
            this.addCriterion("skill_req_menpai <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiGreaterThan(Integer value) {
            this.addCriterion("skill_req_menpai >", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiGreaterThanColumn(Column column) {
            this.addCriterion("skill_req_menpai > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_req_menpai >=", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_req_menpai >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiLessThan(Integer value) {
            this.addCriterion("skill_req_menpai <", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiLessThanColumn(Column column) {
            this.addCriterion("skill_req_menpai < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_req_menpai <=", value, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_req_menpai <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiIn(List<Integer> values) {
            this.addCriterion("skill_req_menpai in", values, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiNotIn(List<Integer> values) {
            this.addCriterion("skill_req_menpai not in", values, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_req_menpai between", value1, value2, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillReqMenpaiNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_req_menpai not between", value1, value2, "skillReqMenpai");
            return (Criteria)this;
        }

        public Criteria andSkillTypeIsNull() {
            this.addCriterion("skill_type is null");
            return (Criteria)this;
        }

        public Criteria andSkillTypeIsNotNull() {
            this.addCriterion("skill_type is not null");
            return (Criteria)this;
        }

        public Criteria andSkillTypeEqualTo(Integer value) {
            this.addCriterion("skill_type =", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeEqualToColumn(Column column) {
            this.addCriterion("skill_type = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeNotEqualTo(Integer value) {
            this.addCriterion("skill_type <>", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeNotEqualToColumn(Column column) {
            this.addCriterion("skill_type <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeGreaterThan(Integer value) {
            this.addCriterion("skill_type >", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeGreaterThanColumn(Column column) {
            this.addCriterion("skill_type > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_type >=", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_type >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLessThan(Integer value) {
            this.addCriterion("skill_type <", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLessThanColumn(Column column) {
            this.addCriterion("skill_type < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_type <=", value, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_type <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeIn(List<Integer> values) {
            this.addCriterion("skill_type in", values, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeNotIn(List<Integer> values) {
            this.addCriterion("skill_type not in", values, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_type between", value1, value2, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_type not between", value1, value2, "skillType");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelIsNull() {
            this.addCriterion("skill_type_level is null");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelIsNotNull() {
            this.addCriterion("skill_type_level is not null");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelEqualTo(Integer value) {
            this.addCriterion("skill_type_level =", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelEqualToColumn(Column column) {
            this.addCriterion("skill_type_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelNotEqualTo(Integer value) {
            this.addCriterion("skill_type_level <>", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelNotEqualToColumn(Column column) {
            this.addCriterion("skill_type_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelGreaterThan(Integer value) {
            this.addCriterion("skill_type_level >", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelGreaterThanColumn(Column column) {
            this.addCriterion("skill_type_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_type_level >=", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_type_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelLessThan(Integer value) {
            this.addCriterion("skill_type_level <", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelLessThanColumn(Column column) {
            this.addCriterion("skill_type_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_type_level <=", value, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_type_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelIn(List<Integer> values) {
            this.addCriterion("skill_type_level in", values, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelNotIn(List<Integer> values) {
            this.addCriterion("skill_type_level not in", values, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_type_level between", value1, value2, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillTypeLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_type_level not between", value1, value2, "skillTypeLevel");
            return (Criteria)this;
        }

        public Criteria andSkillMagicIsNull() {
            this.addCriterion("skill_magic is null");
            return (Criteria)this;
        }

        public Criteria andSkillMagicIsNotNull() {
            this.addCriterion("skill_magic is not null");
            return (Criteria)this;
        }

        public Criteria andSkillMagicEqualTo(Integer value) {
            this.addCriterion("skill_magic =", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicEqualToColumn(Column column) {
            this.addCriterion("skill_magic = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicNotEqualTo(Integer value) {
            this.addCriterion("skill_magic <>", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicNotEqualToColumn(Column column) {
            this.addCriterion("skill_magic <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicGreaterThan(Integer value) {
            this.addCriterion("skill_magic >", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicGreaterThanColumn(Column column) {
            this.addCriterion("skill_magic > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_magic >=", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_magic >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicLessThan(Integer value) {
            this.addCriterion("skill_magic <", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicLessThanColumn(Column column) {
            this.addCriterion("skill_magic < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_magic <=", value, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_magic <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMagicIn(List<Integer> values) {
            this.addCriterion("skill_magic in", values, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicNotIn(List<Integer> values) {
            this.addCriterion("skill_magic not in", values, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_magic between", value1, value2, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillMagicNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_magic not between", value1, value2, "skillMagic");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelIsNull() {
            this.addCriterion("skill_req_level is null");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelIsNotNull() {
            this.addCriterion("skill_req_level is not null");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelEqualTo(Integer value) {
            this.addCriterion("skill_req_level =", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelEqualToColumn(Column column) {
            this.addCriterion("skill_req_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelNotEqualTo(Integer value) {
            this.addCriterion("skill_req_level <>", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelNotEqualToColumn(Column column) {
            this.addCriterion("skill_req_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelGreaterThan(Integer value) {
            this.addCriterion("skill_req_level >", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelGreaterThanColumn(Column column) {
            this.addCriterion("skill_req_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_req_level >=", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_req_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelLessThan(Integer value) {
            this.addCriterion("skill_req_level <", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelLessThanColumn(Column column) {
            this.addCriterion("skill_req_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_req_level <=", value, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_req_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelIn(List<Integer> values) {
            this.addCriterion("skill_req_level in", values, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelNotIn(List<Integer> values) {
            this.addCriterion("skill_req_level not in", values, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_req_level between", value1, value2, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillReqLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_req_level not between", value1, value2, "skillReqLevel");
            return (Criteria)this;
        }

        public Criteria andSkillContextIsNull() {
            this.addCriterion("skill_context is null");
            return (Criteria)this;
        }

        public Criteria andSkillContextIsNotNull() {
            this.addCriterion("skill_context is not null");
            return (Criteria)this;
        }

        public Criteria andSkillContextEqualTo(String value) {
            this.addCriterion("skill_context =", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextEqualToColumn(Column column) {
            this.addCriterion("skill_context = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextNotEqualTo(String value) {
            this.addCriterion("skill_context <>", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextNotEqualToColumn(Column column) {
            this.addCriterion("skill_context <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextGreaterThan(String value) {
            this.addCriterion("skill_context >", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextGreaterThanColumn(Column column) {
            this.addCriterion("skill_context > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_context >=", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_context >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextLessThan(String value) {
            this.addCriterion("skill_context <", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextLessThanColumn(Column column) {
            this.addCriterion("skill_context < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextLessThanOrEqualTo(String value) {
            this.addCriterion("skill_context <=", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_context <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillContextLike(String value) {
            this.addCriterion("skill_context like", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextNotLike(String value) {
            this.addCriterion("skill_context not like", value, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextIn(List<String> values) {
            this.addCriterion("skill_context in", values, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextNotIn(List<String> values) {
            this.addCriterion("skill_context not in", values, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextBetween(String value1, String value2) {
            this.addCriterion("skill_context between", value1, value2, "skillContext");
            return (Criteria)this;
        }

        public Criteria andSkillContextNotBetween(String value1, String value2) {
            this.addCriterion("skill_context not between", value1, value2, "skillContext");
            return (Criteria)this;
        }

        public Criteria andAddTimeIsNull() {
            this.addCriterion("add_time is null");
            return (Criteria)this;
        }

        public Criteria andAddTimeIsNotNull() {
            this.addCriterion("add_time is not null");
            return (Criteria)this;
        }

        public Criteria andAddTimeEqualTo(LocalDateTime value) {
            this.addCriterion("add_time =", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeEqualToColumn(Column column) {
            this.addCriterion("add_time = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeNotEqualTo(LocalDateTime value) {
            this.addCriterion("add_time <>", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeNotEqualToColumn(Column column) {
            this.addCriterion("add_time <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeGreaterThan(LocalDateTime value) {
            this.addCriterion("add_time >", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeGreaterThanColumn(Column column) {
            this.addCriterion("add_time > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("add_time >=", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("add_time >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeLessThan(LocalDateTime value) {
            this.addCriterion("add_time <", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeLessThanColumn(Column column) {
            this.addCriterion("add_time < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("add_time <=", value, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("add_time <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAddTimeIn(List<LocalDateTime> values) {
            this.addCriterion("add_time in", values, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeNotIn(List<LocalDateTime> values) {
            this.addCriterion("add_time not in", values, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria)this;
        }

        public Criteria andAddTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeIsNull() {
            this.addCriterion("update_time is null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            this.addCriterion("update_time is not null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            this.addCriterion("update_time =", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeEqualToColumn(Column column) {
            this.addCriterion("update_time = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            this.addCriterion("update_time <>", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotEqualToColumn(Column column) {
            this.addCriterion("update_time <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            this.addCriterion("update_time >", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeGreaterThanColumn(Column column) {
            this.addCriterion("update_time > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("update_time >=", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("update_time >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            this.addCriterion("update_time <", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThanColumn(Column column) {
            this.addCriterion("update_time < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("update_time <=", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("update_time <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            this.addCriterion("update_time in", values, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            this.addCriterion("update_time not in", values, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria)this;
        }

        public Criteria andDeletedIsNull() {
            this.addCriterion("deleted is null");
            return (Criteria)this;
        }

        public Criteria andDeletedIsNotNull() {
            this.addCriterion("deleted is not null");
            return (Criteria)this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            this.addCriterion("deleted =", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedEqualToColumn(Column column) {
            this.addCriterion("deleted = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            this.addCriterion("deleted <>", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedNotEqualToColumn(Column column) {
            this.addCriterion("deleted <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            this.addCriterion("deleted >", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedGreaterThanColumn(Column column) {
            this.addCriterion("deleted > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("deleted >=", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("deleted >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            this.addCriterion("deleted <", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedLessThanColumn(Column column) {
            this.addCriterion("deleted < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            this.addCriterion("deleted <=", value, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedLessThanOrEqualToColumn(Column column) {
            this.addCriterion("deleted <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            this.addCriterion("deleted in", values, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            this.addCriterion("deleted not in", values, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            this.addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria)this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria)this;
        }
    }


    public static class Criteria extends GeneratedCriteria {
        private SkillsExample example;

        protected Criteria(SkillsExample example) {
            this.example = example;
        }

        public SkillsExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria.ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }

            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }

            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }

            return this;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? this.andDeletedEqualTo(Deleted.IS_DELETED.value()) : this.andDeletedNotEqualTo(Deleted.IS_DELETED.value());
        }
        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria criteria);
        }
    }

}
