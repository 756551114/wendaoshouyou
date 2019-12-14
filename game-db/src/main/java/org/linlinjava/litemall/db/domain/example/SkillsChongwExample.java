//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.SkillsChongw.*;

public class SkillsChongwExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria> oredCriteria = new ArrayList();

    public SkillsChongwExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SkillsChongwExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SkillsChongwExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria newAndCreateCriteria() {
        SkillsChongwExample example = new SkillsChongwExample();
        return example.createCriteria();
    }

    public SkillsChongwExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SkillsChongwExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public SkillsChongwExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SkillsChongwExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.SkillsChongwExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(SkillsChongwExample example);
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }



    public static   class Criterion {
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

        public Criteria andOwneridIsNull() {
            this.addCriterion("ownerid is null");
            return (Criteria)this;
        }

        public Criteria andOwneridIsNotNull() {
            this.addCriterion("ownerid is not null");
            return (Criteria)this;
        }

        public Criteria andOwneridEqualTo(String value) {
            this.addCriterion("ownerid =", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridEqualToColumn(Column column) {
            this.addCriterion("ownerid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridNotEqualTo(String value) {
            this.addCriterion("ownerid <>", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotEqualToColumn(Column column) {
            this.addCriterion("ownerid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThan(String value) {
            this.addCriterion("ownerid >", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanColumn(Column column) {
            this.addCriterion("ownerid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(String value) {
            this.addCriterion("ownerid >=", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("ownerid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLessThan(String value) {
            this.addCriterion("ownerid <", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanColumn(Column column) {
            this.addCriterion("ownerid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanOrEqualTo(String value) {
            this.addCriterion("ownerid <=", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanOrEqualToColumn(Column column) {
            this.addCriterion("ownerid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLike(String value) {
            this.addCriterion("ownerid like", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotLike(String value) {
            this.addCriterion("ownerid not like", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridIn(List<String> values) {
            this.addCriterion("ownerid in", values, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotIn(List<String> values) {
            this.addCriterion("ownerid not in", values, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridBetween(String value1, String value2) {
            this.addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotBetween(String value1, String value2) {
            this.addCriterion("ownerid not between", value1, value2, "ownerid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidIsNull() {
            this.addCriterion("skll_cwid is null");
            return (Criteria)this;
        }

        public Criteria andSkllCwidIsNotNull() {
            this.addCriterion("skll_cwid is not null");
            return (Criteria)this;
        }

        public Criteria andSkllCwidEqualTo(String value) {
            this.addCriterion("skll_cwid =", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidEqualToColumn(Column column) {
            this.addCriterion("skll_cwid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidNotEqualTo(String value) {
            this.addCriterion("skll_cwid <>", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidNotEqualToColumn(Column column) {
            this.addCriterion("skll_cwid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidGreaterThan(String value) {
            this.addCriterion("skll_cwid >", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidGreaterThanColumn(Column column) {
            this.addCriterion("skll_cwid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidGreaterThanOrEqualTo(String value) {
            this.addCriterion("skll_cwid >=", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skll_cwid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidLessThan(String value) {
            this.addCriterion("skll_cwid <", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidLessThanColumn(Column column) {
            this.addCriterion("skll_cwid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidLessThanOrEqualTo(String value) {
            this.addCriterion("skll_cwid <=", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skll_cwid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkllCwidLike(String value) {
            this.addCriterion("skll_cwid like", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidNotLike(String value) {
            this.addCriterion("skll_cwid not like", value, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidIn(List<String> values) {
            this.addCriterion("skll_cwid in", values, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidNotIn(List<String> values) {
            this.addCriterion("skll_cwid not in", values, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidBetween(String value1, String value2) {
            this.addCriterion("skll_cwid between", value1, value2, "skllCwid");
            return (Criteria)this;
        }

        public Criteria andSkllCwidNotBetween(String value1, String value2) {
            this.addCriterion("skll_cwid not between", value1, value2, "skllCwid");
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

        public Criteria andSkillLevelIsNull() {
            this.addCriterion("skill_level is null");
            return (Criteria)this;
        }

        public Criteria andSkillLevelIsNotNull() {
            this.addCriterion("skill_level is not null");
            return (Criteria)this;
        }

        public Criteria andSkillLevelEqualTo(Integer value) {
            this.addCriterion("skill_level =", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelEqualToColumn(Column column) {
            this.addCriterion("skill_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelNotEqualTo(Integer value) {
            this.addCriterion("skill_level <>", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelNotEqualToColumn(Column column) {
            this.addCriterion("skill_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelGreaterThan(Integer value) {
            this.addCriterion("skill_level >", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelGreaterThanColumn(Column column) {
            this.addCriterion("skill_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_level >=", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelLessThan(Integer value) {
            this.addCriterion("skill_level <", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelLessThanColumn(Column column) {
            this.addCriterion("skill_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_level <=", value, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillLevelIn(List<Integer> values) {
            this.addCriterion("skill_level in", values, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelNotIn(List<Integer> values) {
            this.addCriterion("skill_level not in", values, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_level between", value1, value2, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_level not between", value1, value2, "skillLevel");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoIsNull() {
            this.addCriterion("skill_mubiao is null");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoIsNotNull() {
            this.addCriterion("skill_mubiao is not null");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoEqualTo(Integer value) {
            this.addCriterion("skill_mubiao =", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoEqualToColumn(Column column) {
            this.addCriterion("skill_mubiao = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoNotEqualTo(Integer value) {
            this.addCriterion("skill_mubiao <>", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoNotEqualToColumn(Column column) {
            this.addCriterion("skill_mubiao <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoGreaterThan(Integer value) {
            this.addCriterion("skill_mubiao >", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoGreaterThanColumn(Column column) {
            this.addCriterion("skill_mubiao > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("skill_mubiao >=", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_mubiao >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoLessThan(Integer value) {
            this.addCriterion("skill_mubiao <", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoLessThanColumn(Column column) {
            this.addCriterion("skill_mubiao < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoLessThanOrEqualTo(Integer value) {
            this.addCriterion("skill_mubiao <=", value, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_mubiao <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoIn(List<Integer> values) {
            this.addCriterion("skill_mubiao in", values, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoNotIn(List<Integer> values) {
            this.addCriterion("skill_mubiao not in", values, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_mubiao between", value1, value2, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andSkillMubiaoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("skill_mubiao not between", value1, value2, "skillMubiao");
            return (Criteria)this;
        }

        public Criteria andTianshuIdIsNull() {
            this.addCriterion("tianshu_id is null");
            return (Criteria)this;
        }

        public Criteria andTianshuIdIsNotNull() {
            this.addCriterion("tianshu_id is not null");
            return (Criteria)this;
        }

        public Criteria andTianshuIdEqualTo(String value) {
            this.addCriterion("tianshu_id =", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdEqualToColumn(Column column) {
            this.addCriterion("tianshu_id = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdNotEqualTo(String value) {
            this.addCriterion("tianshu_id <>", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdNotEqualToColumn(Column column) {
            this.addCriterion("tianshu_id <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdGreaterThan(String value) {
            this.addCriterion("tianshu_id >", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdGreaterThanColumn(Column column) {
            this.addCriterion("tianshu_id > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("tianshu_id >=", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("tianshu_id >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdLessThan(String value) {
            this.addCriterion("tianshu_id <", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdLessThanColumn(Column column) {
            this.addCriterion("tianshu_id < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdLessThanOrEqualTo(String value) {
            this.addCriterion("tianshu_id <=", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("tianshu_id <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuIdLike(String value) {
            this.addCriterion("tianshu_id like", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdNotLike(String value) {
            this.addCriterion("tianshu_id not like", value, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdIn(List<String> values) {
            this.addCriterion("tianshu_id in", values, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdNotIn(List<String> values) {
            this.addCriterion("tianshu_id not in", values, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdBetween(String value1, String value2) {
            this.addCriterion("tianshu_id between", value1, value2, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuIdNotBetween(String value1, String value2) {
            this.addCriterion("tianshu_id not between", value1, value2, "tianshuId");
            return (Criteria)this;
        }

        public Criteria andTianshuNameIsNull() {
            this.addCriterion("tianshu_name is null");
            return (Criteria)this;
        }

        public Criteria andTianshuNameIsNotNull() {
            this.addCriterion("tianshu_name is not null");
            return (Criteria)this;
        }

        public Criteria andTianshuNameEqualTo(String value) {
            this.addCriterion("tianshu_name =", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameEqualToColumn(Column column) {
            this.addCriterion("tianshu_name = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameNotEqualTo(String value) {
            this.addCriterion("tianshu_name <>", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameNotEqualToColumn(Column column) {
            this.addCriterion("tianshu_name <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameGreaterThan(String value) {
            this.addCriterion("tianshu_name >", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameGreaterThanColumn(Column column) {
            this.addCriterion("tianshu_name > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("tianshu_name >=", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("tianshu_name >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameLessThan(String value) {
            this.addCriterion("tianshu_name <", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameLessThanColumn(Column column) {
            this.addCriterion("tianshu_name < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameLessThanOrEqualTo(String value) {
            this.addCriterion("tianshu_name <=", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("tianshu_name <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTianshuNameLike(String value) {
            this.addCriterion("tianshu_name like", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameNotLike(String value) {
            this.addCriterion("tianshu_name not like", value, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameIn(List<String> values) {
            this.addCriterion("tianshu_name in", values, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameNotIn(List<String> values) {
            this.addCriterion("tianshu_name not in", values, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameBetween(String value1, String value2) {
            this.addCriterion("tianshu_name between", value1, value2, "tianshuName");
            return (Criteria)this;
        }

        public Criteria andTianshuNameNotBetween(String value1, String value2) {
            this.addCriterion("tianshu_name not between", value1, value2, "tianshuName");
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
        private SkillsChongwExample example;

        protected Criteria(SkillsChongwExample example) {
            this.example = example;
        }

        public SkillsChongwExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria.ICriteriaAdd add) {
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
