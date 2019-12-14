//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.StoreInfo.*;

public class StoreInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria> oredCriteria = new ArrayList();

    public StoreInfoExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public StoreInfoExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public StoreInfoExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria newAndCreateCriteria() {
        StoreInfoExample example = new StoreInfoExample();
        return example.createCriteria();
    }

    public StoreInfoExample when(boolean condition, org.linlinjava.litemall.db.domain.example.StoreInfoExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public StoreInfoExample when(boolean condition, org.linlinjava.litemall.db.domain.example.StoreInfoExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.StoreInfoExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(StoreInfoExample example);
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

        public Criteria andValueIsNull() {
            this.addCriterion("`value` is null");
            return (Criteria)this;
        }

        public Criteria andValueIsNotNull() {
            this.addCriterion("`value` is not null");
            return (Criteria)this;
        }

        public Criteria andValueEqualTo(Integer value) {
            this.addCriterion("`value` =", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueEqualToColumn(Column column) {
            this.addCriterion("`value` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueNotEqualTo(Integer value) {
            this.addCriterion("`value` <>", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueNotEqualToColumn(Column column) {
            this.addCriterion("`value` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueGreaterThan(Integer value) {
            this.addCriterion("`value` >", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueGreaterThanColumn(Column column) {
            this.addCriterion("`value` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`value` >=", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`value` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueLessThan(Integer value) {
            this.addCriterion("`value` <", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueLessThanColumn(Column column) {
            this.addCriterion("`value` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueLessThanOrEqualTo(Integer value) {
            this.addCriterion("`value` <=", value, "value");
            return (Criteria)this;
        }

        public Criteria andValueLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`value` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andValueIn(List<Integer> values) {
            this.addCriterion("`value` in", values, "value");
            return (Criteria)this;
        }

        public Criteria andValueNotIn(List<Integer> values) {
            this.addCriterion("`value` not in", values, "value");
            return (Criteria)this;
        }

        public Criteria andValueBetween(Integer value1, Integer value2) {
            this.addCriterion("`value` between", value1, value2, "value");
            return (Criteria)this;
        }

        public Criteria andValueNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`value` not between", value1, value2, "value");
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

        public Criteria andNameIsNull() {
            this.addCriterion("`name` is null");
            return (Criteria)this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("`name` is not null");
            return (Criteria)this;
        }

        public Criteria andNameEqualTo(String value) {
            this.addCriterion("`name` =", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameEqualToColumn(Column column) {
            this.addCriterion("`name` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameNotEqualTo(String value) {
            this.addCriterion("`name` <>", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotEqualToColumn(Column column) {
            this.addCriterion("`name` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameGreaterThan(String value) {
            this.addCriterion("`name` >", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanColumn(Column column) {
            this.addCriterion("`name` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("`name` >=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`name` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameLessThan(String value) {
            this.addCriterion("`name` <", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanColumn(Column column) {
            this.addCriterion("`name` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("`name` <=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`name` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNameLike(String value) {
            this.addCriterion("`name` like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotLike(String value) {
            this.addCriterion("`name` not like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameIn(List<String> values) {
            this.addCriterion("`name` in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotIn(List<String> values) {
            this.addCriterion("`name` not in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("`name` between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("`name` not between", value1, value2, "name");
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

        public Criteria andTotalScoreIsNull() {
            this.addCriterion("total_score is null");
            return (Criteria)this;
        }

        public Criteria andTotalScoreIsNotNull() {
            this.addCriterion("total_score is not null");
            return (Criteria)this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            this.addCriterion("total_score =", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreEqualToColumn(Column column) {
            this.addCriterion("total_score = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            this.addCriterion("total_score <>", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreNotEqualToColumn(Column column) {
            this.addCriterion("total_score <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            this.addCriterion("total_score >", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreGreaterThanColumn(Column column) {
            this.addCriterion("total_score > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("total_score >=", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("total_score >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            this.addCriterion("total_score <", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreLessThanColumn(Column column) {
            this.addCriterion("total_score < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("total_score <=", value, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreLessThanOrEqualToColumn(Column column) {
            this.addCriterion("total_score <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            this.addCriterion("total_score in", values, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            this.addCriterion("total_score not in", values, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            this.addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria)this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedIsNull() {
            this.addCriterion("recognize_recognized is null");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedIsNotNull() {
            this.addCriterion("recognize_recognized is not null");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedEqualTo(Integer value) {
            this.addCriterion("recognize_recognized =", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedEqualToColumn(Column column) {
            this.addCriterion("recognize_recognized = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedNotEqualTo(Integer value) {
            this.addCriterion("recognize_recognized <>", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedNotEqualToColumn(Column column) {
            this.addCriterion("recognize_recognized <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedGreaterThan(Integer value) {
            this.addCriterion("recognize_recognized >", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedGreaterThanColumn(Column column) {
            this.addCriterion("recognize_recognized > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("recognize_recognized >=", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("recognize_recognized >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedLessThan(Integer value) {
            this.addCriterion("recognize_recognized <", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedLessThanColumn(Column column) {
            this.addCriterion("recognize_recognized < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedLessThanOrEqualTo(Integer value) {
            this.addCriterion("recognize_recognized <=", value, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedLessThanOrEqualToColumn(Column column) {
            this.addCriterion("recognize_recognized <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedIn(List<Integer> values) {
            this.addCriterion("recognize_recognized in", values, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedNotIn(List<Integer> values) {
            this.addCriterion("recognize_recognized not in", values, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedBetween(Integer value1, Integer value2) {
            this.addCriterion("recognize_recognized between", value1, value2, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRecognizeRecognizedNotBetween(Integer value1, Integer value2) {
            this.addCriterion("recognize_recognized not between", value1, value2, "recognizeRecognized");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelIsNull() {
            this.addCriterion("rebuild_level is null");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelIsNotNull() {
            this.addCriterion("rebuild_level is not null");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelEqualTo(Integer value) {
            this.addCriterion("rebuild_level =", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelEqualToColumn(Column column) {
            this.addCriterion("rebuild_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelNotEqualTo(Integer value) {
            this.addCriterion("rebuild_level <>", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelNotEqualToColumn(Column column) {
            this.addCriterion("rebuild_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelGreaterThan(Integer value) {
            this.addCriterion("rebuild_level >", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelGreaterThanColumn(Column column) {
            this.addCriterion("rebuild_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("rebuild_level >=", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("rebuild_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelLessThan(Integer value) {
            this.addCriterion("rebuild_level <", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelLessThanColumn(Column column) {
            this.addCriterion("rebuild_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("rebuild_level <=", value, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("rebuild_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRebuildLevelIn(List<Integer> values) {
            this.addCriterion("rebuild_level in", values, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelNotIn(List<Integer> values) {
            this.addCriterion("rebuild_level not in", values, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("rebuild_level between", value1, value2, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andRebuildLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("rebuild_level not between", value1, value2, "rebuildLevel");
            return (Criteria)this;
        }

        public Criteria andSilverCoinIsNull() {
            this.addCriterion("silver_coin is null");
            return (Criteria)this;
        }

        public Criteria andSilverCoinIsNotNull() {
            this.addCriterion("silver_coin is not null");
            return (Criteria)this;
        }

        public Criteria andSilverCoinEqualTo(Integer value) {
            this.addCriterion("silver_coin =", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinEqualToColumn(Column column) {
            this.addCriterion("silver_coin = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinNotEqualTo(Integer value) {
            this.addCriterion("silver_coin <>", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinNotEqualToColumn(Column column) {
            this.addCriterion("silver_coin <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinGreaterThan(Integer value) {
            this.addCriterion("silver_coin >", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinGreaterThanColumn(Column column) {
            this.addCriterion("silver_coin > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("silver_coin >=", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("silver_coin >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinLessThan(Integer value) {
            this.addCriterion("silver_coin <", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinLessThanColumn(Column column) {
            this.addCriterion("silver_coin < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinLessThanOrEqualTo(Integer value) {
            this.addCriterion("silver_coin <=", value, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinLessThanOrEqualToColumn(Column column) {
            this.addCriterion("silver_coin <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSilverCoinIn(List<Integer> values) {
            this.addCriterion("silver_coin in", values, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinNotIn(List<Integer> values) {
            this.addCriterion("silver_coin not in", values, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinBetween(Integer value1, Integer value2) {
            this.addCriterion("silver_coin between", value1, value2, "silverCoin");
            return (Criteria)this;
        }

        public Criteria andSilverCoinNotBetween(Integer value1, Integer value2) {
            this.addCriterion("silver_coin not between", value1, value2, "silverCoin");
            return (Criteria)this;
        }
    }


    public static class Criteria extends GeneratedCriteria {
        private StoreInfoExample example;

        protected Criteria(StoreInfoExample example) {
            this.example = example;
        }

        public StoreInfoExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.StoreInfoExample.Criteria.ICriteriaAdd add) {
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
