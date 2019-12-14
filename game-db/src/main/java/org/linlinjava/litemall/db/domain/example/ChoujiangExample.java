//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Choujiang.*;


public class ChoujiangExample {
    
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria> oredCriteria = new ArrayList();

    public ChoujiangExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ChoujiangExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ChoujiangExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria newAndCreateCriteria() {
        ChoujiangExample example = new ChoujiangExample();
        return example.createCriteria();
    }

    public ChoujiangExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ChoujiangExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public ChoujiangExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ChoujiangExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.ChoujiangExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(ChoujiangExample example);
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


    public static  abstract class GeneratedCriteria {
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

        public Criteria andNoIsNull() {
            this.addCriterion("`no` is null");
            return (Criteria)this;
        }

        public Criteria andNoIsNotNull() {
            this.addCriterion("`no` is not null");
            return (Criteria)this;
        }

        public Criteria andNoEqualTo(Integer value) {
            this.addCriterion("`no` =", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoEqualToColumn(Column column) {
            this.addCriterion("`no` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoNotEqualTo(Integer value) {
            this.addCriterion("`no` <>", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoNotEqualToColumn(Column column) {
            this.addCriterion("`no` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoGreaterThan(Integer value) {
            this.addCriterion("`no` >", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoGreaterThanColumn(Column column) {
            this.addCriterion("`no` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`no` >=", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`no` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoLessThan(Integer value) {
            this.addCriterion("`no` <", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoLessThanColumn(Column column) {
            this.addCriterion("`no` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoLessThanOrEqualTo(Integer value) {
            this.addCriterion("`no` <=", value, "no");
            return (Criteria)this;
        }

        public Criteria andNoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`no` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNoIn(List<Integer> values) {
            this.addCriterion("`no` in", values, "no");
            return (Criteria)this;
        }

        public Criteria andNoNotIn(List<Integer> values) {
            this.addCriterion("`no` not in", values, "no");
            return (Criteria)this;
        }

        public Criteria andNoBetween(Integer value1, Integer value2) {
            this.addCriterion("`no` between", value1, value2, "no");
            return (Criteria)this;
        }

        public Criteria andNoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`no` not between", value1, value2, "no");
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

        public Criteria andDescIsNull() {
            this.addCriterion("`desc` is null");
            return (Criteria)this;
        }

        public Criteria andDescIsNotNull() {
            this.addCriterion("`desc` is not null");
            return (Criteria)this;
        }

        public Criteria andDescEqualTo(String value) {
            this.addCriterion("`desc` =", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescEqualToColumn(Column column) {
            this.addCriterion("`desc` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescNotEqualTo(String value) {
            this.addCriterion("`desc` <>", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescNotEqualToColumn(Column column) {
            this.addCriterion("`desc` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescGreaterThan(String value) {
            this.addCriterion("`desc` >", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescGreaterThanColumn(Column column) {
            this.addCriterion("`desc` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("`desc` >=", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`desc` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescLessThan(String value) {
            this.addCriterion("`desc` <", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescLessThanColumn(Column column) {
            this.addCriterion("`desc` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            this.addCriterion("`desc` <=", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`desc` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDescLike(String value) {
            this.addCriterion("`desc` like", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescNotLike(String value) {
            this.addCriterion("`desc` not like", value, "desc");
            return (Criteria)this;
        }

        public Criteria andDescIn(List<String> values) {
            this.addCriterion("`desc` in", values, "desc");
            return (Criteria)this;
        }

        public Criteria andDescNotIn(List<String> values) {
            this.addCriterion("`desc` not in", values, "desc");
            return (Criteria)this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            this.addCriterion("`desc` between", value1, value2, "desc");
            return (Criteria)this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            this.addCriterion("`desc` not between", value1, value2, "desc");
            return (Criteria)this;
        }

        public Criteria andLevelIsNull() {
            this.addCriterion("`level` is null");
            return (Criteria)this;
        }

        public Criteria andLevelIsNotNull() {
            this.addCriterion("`level` is not null");
            return (Criteria)this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            this.addCriterion("`level` =", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelEqualToColumn(Column column) {
            this.addCriterion("`level` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            this.addCriterion("`level` <>", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelNotEqualToColumn(Column column) {
            this.addCriterion("`level` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            this.addCriterion("`level` >", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelGreaterThanColumn(Column column) {
            this.addCriterion("`level` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`level` >=", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`level` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelLessThan(Integer value) {
            this.addCriterion("`level` <", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelLessThanColumn(Column column) {
            this.addCriterion("`level` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("`level` <=", value, "level");
            return (Criteria)this;
        }

        public Criteria andLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`level` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            this.addCriterion("`level` in", values, "level");
            return (Criteria)this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            this.addCriterion("`level` not in", values, "level");
            return (Criteria)this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("`level` between", value1, value2, "level");
            return (Criteria)this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`level` not between", value1, value2, "level");
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
        private ChoujiangExample example;

        protected Criteria(ChoujiangExample example) {
            this.example = example;
        }

        public ChoujiangExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria.ICriteriaAdd add) {
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
        public  interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }
}
