//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo.*;

public class ZhuangbeiInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria> oredCriteria = new ArrayList();

    public ZhuangbeiInfoExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ZhuangbeiInfoExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ZhuangbeiInfoExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria newAndCreateCriteria() {
        ZhuangbeiInfoExample example = new ZhuangbeiInfoExample();
        return example.createCriteria();
    }

    public ZhuangbeiInfoExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public ZhuangbeiInfoExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(ZhuangbeiInfoExample example);
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

        public Criteria andAttribIsNull() {
            this.addCriterion("attrib is null");
            return (Criteria)this;
        }

        public Criteria andAttribIsNotNull() {
            this.addCriterion("attrib is not null");
            return (Criteria)this;
        }

        public Criteria andAttribEqualTo(Integer value) {
            this.addCriterion("attrib =", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribEqualToColumn(Column column) {
            this.addCriterion("attrib = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualTo(Integer value) {
            this.addCriterion("attrib <>", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualToColumn(Column column) {
            this.addCriterion("attrib <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThan(Integer value) {
            this.addCriterion("attrib >", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanColumn(Column column) {
            this.addCriterion("attrib > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("attrib >=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThan(Integer value) {
            this.addCriterion("attrib <", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanColumn(Column column) {
            this.addCriterion("attrib < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualTo(Integer value) {
            this.addCriterion("attrib <=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribIn(List<Integer> values) {
            this.addCriterion("attrib in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotIn(List<Integer> values) {
            this.addCriterion("attrib not in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribBetween(Integer value1, Integer value2) {
            this.addCriterion("attrib between", value1, value2, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotBetween(Integer value1, Integer value2) {
            this.addCriterion("attrib not between", value1, value2, "attrib");
            return (Criteria)this;
        }

        public Criteria andAmountIsNull() {
            this.addCriterion("amount is null");
            return (Criteria)this;
        }

        public Criteria andAmountIsNotNull() {
            this.addCriterion("amount is not null");
            return (Criteria)this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            this.addCriterion("amount =", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountEqualToColumn(Column column) {
            this.addCriterion("amount = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            this.addCriterion("amount <>", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountNotEqualToColumn(Column column) {
            this.addCriterion("amount <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            this.addCriterion("amount >", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountGreaterThanColumn(Column column) {
            this.addCriterion("amount > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("amount >=", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("amount >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountLessThan(Integer value) {
            this.addCriterion("amount <", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountLessThanColumn(Column column) {
            this.addCriterion("amount < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            this.addCriterion("amount <=", value, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountLessThanOrEqualToColumn(Column column) {
            this.addCriterion("amount <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            this.addCriterion("amount in", values, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            this.addCriterion("amount not in", values, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            this.addCriterion("amount between", value1, value2, "amount");
            return (Criteria)this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            this.addCriterion("amount not between", value1, value2, "amount");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("`type` is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("`type` is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("`type` =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeEqualToColumn(Column column) {
            this.addCriterion("`type` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("`type` <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualToColumn(Column column) {
            this.addCriterion("`type` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("`type` >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanColumn(Column column) {
            this.addCriterion("`type` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`type` >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`type` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(Integer value) {
            this.addCriterion("`type` <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanColumn(Column column) {
            this.addCriterion("`type` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("`type` <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`type` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("`type` in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("`type` not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("`type` between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`type` not between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andStrIsNull() {
            this.addCriterion("str is null");
            return (Criteria)this;
        }

        public Criteria andStrIsNotNull() {
            this.addCriterion("str is not null");
            return (Criteria)this;
        }

        public Criteria andStrEqualTo(String value) {
            this.addCriterion("str =", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrEqualToColumn(Column column) {
            this.addCriterion("str = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrNotEqualTo(String value) {
            this.addCriterion("str <>", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrNotEqualToColumn(Column column) {
            this.addCriterion("str <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrGreaterThan(String value) {
            this.addCriterion("str >", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrGreaterThanColumn(Column column) {
            this.addCriterion("str > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrGreaterThanOrEqualTo(String value) {
            this.addCriterion("str >=", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("str >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrLessThan(String value) {
            this.addCriterion("str <", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrLessThanColumn(Column column) {
            this.addCriterion("str < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrLessThanOrEqualTo(String value) {
            this.addCriterion("str <=", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrLessThanOrEqualToColumn(Column column) {
            this.addCriterion("str <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStrLike(String value) {
            this.addCriterion("str like", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrNotLike(String value) {
            this.addCriterion("str not like", value, "str");
            return (Criteria)this;
        }

        public Criteria andStrIn(List<String> values) {
            this.addCriterion("str in", values, "str");
            return (Criteria)this;
        }

        public Criteria andStrNotIn(List<String> values) {
            this.addCriterion("str not in", values, "str");
            return (Criteria)this;
        }

        public Criteria andStrBetween(String value1, String value2) {
            this.addCriterion("str between", value1, value2, "str");
            return (Criteria)this;
        }

        public Criteria andStrNotBetween(String value1, String value2) {
            this.addCriterion("str not between", value1, value2, "str");
            return (Criteria)this;
        }

        public Criteria andQualityIsNull() {
            this.addCriterion("quality is null");
            return (Criteria)this;
        }

        public Criteria andQualityIsNotNull() {
            this.addCriterion("quality is not null");
            return (Criteria)this;
        }

        public Criteria andQualityEqualTo(String value) {
            this.addCriterion("quality =", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityEqualToColumn(Column column) {
            this.addCriterion("quality = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            this.addCriterion("quality <>", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityNotEqualToColumn(Column column) {
            this.addCriterion("quality <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityGreaterThan(String value) {
            this.addCriterion("quality >", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityGreaterThanColumn(Column column) {
            this.addCriterion("quality > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            this.addCriterion("quality >=", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("quality >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityLessThan(String value) {
            this.addCriterion("quality <", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityLessThanColumn(Column column) {
            this.addCriterion("quality < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            this.addCriterion("quality <=", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityLessThanOrEqualToColumn(Column column) {
            this.addCriterion("quality <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQualityLike(String value) {
            this.addCriterion("quality like", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityNotLike(String value) {
            this.addCriterion("quality not like", value, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityIn(List<String> values) {
            this.addCriterion("quality in", values, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            this.addCriterion("quality not in", values, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            this.addCriterion("quality between", value1, value2, "quality");
            return (Criteria)this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            this.addCriterion("quality not between", value1, value2, "quality");
            return (Criteria)this;
        }

        public Criteria andMasterIsNull() {
            this.addCriterion("master is null");
            return (Criteria)this;
        }

        public Criteria andMasterIsNotNull() {
            this.addCriterion("master is not null");
            return (Criteria)this;
        }

        public Criteria andMasterEqualTo(Integer value) {
            this.addCriterion("master =", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterEqualToColumn(Column column) {
            this.addCriterion("master = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterNotEqualTo(Integer value) {
            this.addCriterion("master <>", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterNotEqualToColumn(Column column) {
            this.addCriterion("master <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterGreaterThan(Integer value) {
            this.addCriterion("master >", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterGreaterThanColumn(Column column) {
            this.addCriterion("master > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("master >=", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("master >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterLessThan(Integer value) {
            this.addCriterion("master <", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterLessThanColumn(Column column) {
            this.addCriterion("master < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterLessThanOrEqualTo(Integer value) {
            this.addCriterion("master <=", value, "master");
            return (Criteria)this;
        }

        public Criteria andMasterLessThanOrEqualToColumn(Column column) {
            this.addCriterion("master <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMasterIn(List<Integer> values) {
            this.addCriterion("master in", values, "master");
            return (Criteria)this;
        }

        public Criteria andMasterNotIn(List<Integer> values) {
            this.addCriterion("master not in", values, "master");
            return (Criteria)this;
        }

        public Criteria andMasterBetween(Integer value1, Integer value2) {
            this.addCriterion("master between", value1, value2, "master");
            return (Criteria)this;
        }

        public Criteria andMasterNotBetween(Integer value1, Integer value2) {
            this.addCriterion("master not between", value1, value2, "master");
            return (Criteria)this;
        }

        public Criteria andMetalIsNull() {
            this.addCriterion("metal is null");
            return (Criteria)this;
        }

        public Criteria andMetalIsNotNull() {
            this.addCriterion("metal is not null");
            return (Criteria)this;
        }

        public Criteria andMetalEqualTo(Integer value) {
            this.addCriterion("metal =", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalEqualToColumn(Column column) {
            this.addCriterion("metal = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalNotEqualTo(Integer value) {
            this.addCriterion("metal <>", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalNotEqualToColumn(Column column) {
            this.addCriterion("metal <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalGreaterThan(Integer value) {
            this.addCriterion("metal >", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalGreaterThanColumn(Column column) {
            this.addCriterion("metal > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("metal >=", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("metal >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalLessThan(Integer value) {
            this.addCriterion("metal <", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalLessThanColumn(Column column) {
            this.addCriterion("metal < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalLessThanOrEqualTo(Integer value) {
            this.addCriterion("metal <=", value, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalLessThanOrEqualToColumn(Column column) {
            this.addCriterion("metal <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMetalIn(List<Integer> values) {
            this.addCriterion("metal in", values, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalNotIn(List<Integer> values) {
            this.addCriterion("metal not in", values, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalBetween(Integer value1, Integer value2) {
            this.addCriterion("metal between", value1, value2, "metal");
            return (Criteria)this;
        }

        public Criteria andMetalNotBetween(Integer value1, Integer value2) {
            this.addCriterion("metal not between", value1, value2, "metal");
            return (Criteria)this;
        }

        public Criteria andManaIsNull() {
            this.addCriterion("mana is null");
            return (Criteria)this;
        }

        public Criteria andManaIsNotNull() {
            this.addCriterion("mana is not null");
            return (Criteria)this;
        }

        public Criteria andManaEqualTo(Integer value) {
            this.addCriterion("mana =", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaEqualToColumn(Column column) {
            this.addCriterion("mana = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaNotEqualTo(Integer value) {
            this.addCriterion("mana <>", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotEqualToColumn(Column column) {
            this.addCriterion("mana <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaGreaterThan(Integer value) {
            this.addCriterion("mana >", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanColumn(Column column) {
            this.addCriterion("mana > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("mana >=", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("mana >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaLessThan(Integer value) {
            this.addCriterion("mana <", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaLessThanColumn(Column column) {
            this.addCriterion("mana < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaLessThanOrEqualTo(Integer value) {
            this.addCriterion("mana <=", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("mana <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaIn(List<Integer> values) {
            this.addCriterion("mana in", values, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotIn(List<Integer> values) {
            this.addCriterion("mana not in", values, "mana");
            return (Criteria)this;
        }

        public Criteria andManaBetween(Integer value1, Integer value2) {
            this.addCriterion("mana between", value1, value2, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotBetween(Integer value1, Integer value2) {
            this.addCriterion("mana not between", value1, value2, "mana");
            return (Criteria)this;
        }

        public Criteria andAccurateIsNull() {
            this.addCriterion("accurate is null");
            return (Criteria)this;
        }

        public Criteria andAccurateIsNotNull() {
            this.addCriterion("accurate is not null");
            return (Criteria)this;
        }

        public Criteria andAccurateEqualTo(Integer value) {
            this.addCriterion("accurate =", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateEqualToColumn(Column column) {
            this.addCriterion("accurate = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateNotEqualTo(Integer value) {
            this.addCriterion("accurate <>", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateNotEqualToColumn(Column column) {
            this.addCriterion("accurate <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateGreaterThan(Integer value) {
            this.addCriterion("accurate >", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateGreaterThanColumn(Column column) {
            this.addCriterion("accurate > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("accurate >=", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("accurate >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateLessThan(Integer value) {
            this.addCriterion("accurate <", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateLessThanColumn(Column column) {
            this.addCriterion("accurate < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateLessThanOrEqualTo(Integer value) {
            this.addCriterion("accurate <=", value, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateLessThanOrEqualToColumn(Column column) {
            this.addCriterion("accurate <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccurateIn(List<Integer> values) {
            this.addCriterion("accurate in", values, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateNotIn(List<Integer> values) {
            this.addCriterion("accurate not in", values, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateBetween(Integer value1, Integer value2) {
            this.addCriterion("accurate between", value1, value2, "accurate");
            return (Criteria)this;
        }

        public Criteria andAccurateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("accurate not between", value1, value2, "accurate");
            return (Criteria)this;
        }

        public Criteria andDefIsNull() {
            this.addCriterion("def is null");
            return (Criteria)this;
        }

        public Criteria andDefIsNotNull() {
            this.addCriterion("def is not null");
            return (Criteria)this;
        }

        public Criteria andDefEqualTo(Integer value) {
            this.addCriterion("def =", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefEqualToColumn(Column column) {
            this.addCriterion("def = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefNotEqualTo(Integer value) {
            this.addCriterion("def <>", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefNotEqualToColumn(Column column) {
            this.addCriterion("def <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefGreaterThan(Integer value) {
            this.addCriterion("def >", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefGreaterThanColumn(Column column) {
            this.addCriterion("def > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("def >=", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("def >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefLessThan(Integer value) {
            this.addCriterion("def <", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefLessThanColumn(Column column) {
            this.addCriterion("def < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefLessThanOrEqualTo(Integer value) {
            this.addCriterion("def <=", value, "def");
            return (Criteria)this;
        }

        public Criteria andDefLessThanOrEqualToColumn(Column column) {
            this.addCriterion("def <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDefIn(List<Integer> values) {
            this.addCriterion("def in", values, "def");
            return (Criteria)this;
        }

        public Criteria andDefNotIn(List<Integer> values) {
            this.addCriterion("def not in", values, "def");
            return (Criteria)this;
        }

        public Criteria andDefBetween(Integer value1, Integer value2) {
            this.addCriterion("def between", value1, value2, "def");
            return (Criteria)this;
        }

        public Criteria andDefNotBetween(Integer value1, Integer value2) {
            this.addCriterion("def not between", value1, value2, "def");
            return (Criteria)this;
        }

        public Criteria andDexIsNull() {
            this.addCriterion("dex is null");
            return (Criteria)this;
        }

        public Criteria andDexIsNotNull() {
            this.addCriterion("dex is not null");
            return (Criteria)this;
        }

        public Criteria andDexEqualTo(Integer value) {
            this.addCriterion("dex =", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexEqualToColumn(Column column) {
            this.addCriterion("dex = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexNotEqualTo(Integer value) {
            this.addCriterion("dex <>", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexNotEqualToColumn(Column column) {
            this.addCriterion("dex <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexGreaterThan(Integer value) {
            this.addCriterion("dex >", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexGreaterThanColumn(Column column) {
            this.addCriterion("dex > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("dex >=", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("dex >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexLessThan(Integer value) {
            this.addCriterion("dex <", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexLessThanColumn(Column column) {
            this.addCriterion("dex < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexLessThanOrEqualTo(Integer value) {
            this.addCriterion("dex <=", value, "dex");
            return (Criteria)this;
        }

        public Criteria andDexLessThanOrEqualToColumn(Column column) {
            this.addCriterion("dex <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDexIn(List<Integer> values) {
            this.addCriterion("dex in", values, "dex");
            return (Criteria)this;
        }

        public Criteria andDexNotIn(List<Integer> values) {
            this.addCriterion("dex not in", values, "dex");
            return (Criteria)this;
        }

        public Criteria andDexBetween(Integer value1, Integer value2) {
            this.addCriterion("dex between", value1, value2, "dex");
            return (Criteria)this;
        }

        public Criteria andDexNotBetween(Integer value1, Integer value2) {
            this.addCriterion("dex not between", value1, value2, "dex");
            return (Criteria)this;
        }

        public Criteria andWizIsNull() {
            this.addCriterion("wiz is null");
            return (Criteria)this;
        }

        public Criteria andWizIsNotNull() {
            this.addCriterion("wiz is not null");
            return (Criteria)this;
        }

        public Criteria andWizEqualTo(Integer value) {
            this.addCriterion("wiz =", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizEqualToColumn(Column column) {
            this.addCriterion("wiz = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizNotEqualTo(Integer value) {
            this.addCriterion("wiz <>", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizNotEqualToColumn(Column column) {
            this.addCriterion("wiz <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizGreaterThan(Integer value) {
            this.addCriterion("wiz >", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizGreaterThanColumn(Column column) {
            this.addCriterion("wiz > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("wiz >=", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("wiz >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizLessThan(Integer value) {
            this.addCriterion("wiz <", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizLessThanColumn(Column column) {
            this.addCriterion("wiz < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizLessThanOrEqualTo(Integer value) {
            this.addCriterion("wiz <=", value, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizLessThanOrEqualToColumn(Column column) {
            this.addCriterion("wiz <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andWizIn(List<Integer> values) {
            this.addCriterion("wiz in", values, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizNotIn(List<Integer> values) {
            this.addCriterion("wiz not in", values, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizBetween(Integer value1, Integer value2) {
            this.addCriterion("wiz between", value1, value2, "wiz");
            return (Criteria)this;
        }

        public Criteria andWizNotBetween(Integer value1, Integer value2) {
            this.addCriterion("wiz not between", value1, value2, "wiz");
            return (Criteria)this;
        }

        public Criteria andParryIsNull() {
            this.addCriterion("parry is null");
            return (Criteria)this;
        }

        public Criteria andParryIsNotNull() {
            this.addCriterion("parry is not null");
            return (Criteria)this;
        }

        public Criteria andParryEqualTo(Integer value) {
            this.addCriterion("parry =", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryEqualToColumn(Column column) {
            this.addCriterion("parry = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryNotEqualTo(Integer value) {
            this.addCriterion("parry <>", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryNotEqualToColumn(Column column) {
            this.addCriterion("parry <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryGreaterThan(Integer value) {
            this.addCriterion("parry >", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryGreaterThanColumn(Column column) {
            this.addCriterion("parry > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("parry >=", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("parry >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryLessThan(Integer value) {
            this.addCriterion("parry <", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryLessThanColumn(Column column) {
            this.addCriterion("parry < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryLessThanOrEqualTo(Integer value) {
            this.addCriterion("parry <=", value, "parry");
            return (Criteria)this;
        }

        public Criteria andParryLessThanOrEqualToColumn(Column column) {
            this.addCriterion("parry <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andParryIn(List<Integer> values) {
            this.addCriterion("parry in", values, "parry");
            return (Criteria)this;
        }

        public Criteria andParryNotIn(List<Integer> values) {
            this.addCriterion("parry not in", values, "parry");
            return (Criteria)this;
        }

        public Criteria andParryBetween(Integer value1, Integer value2) {
            this.addCriterion("parry between", value1, value2, "parry");
            return (Criteria)this;
        }

        public Criteria andParryNotBetween(Integer value1, Integer value2) {
            this.addCriterion("parry not between", value1, value2, "parry");
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
        private ZhuangbeiInfoExample example;

        protected Criteria(ZhuangbeiInfoExample example) {
            this.example = example;
        }

        public ZhuangbeiInfoExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.ZhuangbeiInfoExample.Criteria.ICriteriaAdd add) {
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
