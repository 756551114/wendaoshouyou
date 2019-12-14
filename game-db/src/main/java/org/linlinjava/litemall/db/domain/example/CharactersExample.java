//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Characters.*;

public class CharactersExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria> oredCriteria = new ArrayList();

    public CharactersExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public CharactersExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public CharactersExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria newAndCreateCriteria() {
        CharactersExample example = new CharactersExample();
        return example.createCriteria();
    }

    public CharactersExample when(boolean condition, org.linlinjava.litemall.db.domain.example.CharactersExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public CharactersExample when(boolean condition, org.linlinjava.litemall.db.domain.example.CharactersExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.CharactersExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }


    public interface IExampleWhen {
        void example(CharactersExample example);
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }


    public static class Criteria extends GeneratedCriteria {
        private CharactersExample example;

        protected Criteria(CharactersExample example) {
            this.example = example;
        }

        public CharactersExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria.ICriteriaAdd add) {
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

        public Criteria andMenpaiIsNull() {
            this.addCriterion("menpai is null");
            return (Criteria)this;
        }

        public Criteria andMenpaiIsNotNull() {
            this.addCriterion("menpai is not null");
            return (Criteria)this;
        }

        public Criteria andMenpaiEqualTo(Integer value) {
            this.addCriterion("menpai =", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiEqualToColumn(Column column) {
            this.addCriterion("menpai = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiNotEqualTo(Integer value) {
            this.addCriterion("menpai <>", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiNotEqualToColumn(Column column) {
            this.addCriterion("menpai <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiGreaterThan(Integer value) {
            this.addCriterion("menpai >", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiGreaterThanColumn(Column column) {
            this.addCriterion("menpai > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("menpai >=", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("menpai >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiLessThan(Integer value) {
            this.addCriterion("menpai <", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiLessThanColumn(Column column) {
            this.addCriterion("menpai < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiLessThanOrEqualTo(Integer value) {
            this.addCriterion("menpai <=", value, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("menpai <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMenpaiIn(List<Integer> values) {
            this.addCriterion("menpai in", values, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiNotIn(List<Integer> values) {
            this.addCriterion("menpai not in", values, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiBetween(Integer value1, Integer value2) {
            this.addCriterion("menpai between", value1, value2, "menpai");
            return (Criteria)this;
        }

        public Criteria andMenpaiNotBetween(Integer value1, Integer value2) {
            this.addCriterion("menpai not between", value1, value2, "menpai");
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

        public Criteria andAccountIdIsNull() {
            this.addCriterion("account_id is null");
            return (Criteria)this;
        }

        public Criteria andAccountIdIsNotNull() {
            this.addCriterion("account_id is not null");
            return (Criteria)this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            this.addCriterion("account_id =", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdEqualToColumn(Column column) {
            this.addCriterion("account_id = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            this.addCriterion("account_id <>", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotEqualToColumn(Column column) {
            this.addCriterion("account_id <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            this.addCriterion("account_id >", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThanColumn(Column column) {
            this.addCriterion("account_id > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_id >=", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("account_id >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            this.addCriterion("account_id <", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThanColumn(Column column) {
            this.addCriterion("account_id < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_id <=", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("account_id <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            this.addCriterion("account_id in", values, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            this.addCriterion("account_id not in", values, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            this.addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_id not between", value1, value2, "accountId");
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

        public Criteria andGidIsNull() {
            this.addCriterion("gid is null");
            return (Criteria)this;
        }

        public Criteria andGidIsNotNull() {
            this.addCriterion("gid is not null");
            return (Criteria)this;
        }

        public Criteria andGidEqualTo(String value) {
            this.addCriterion("gid =", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidEqualToColumn(Column column) {
            this.addCriterion("gid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidNotEqualTo(String value) {
            this.addCriterion("gid <>", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidNotEqualToColumn(Column column) {
            this.addCriterion("gid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidGreaterThan(String value) {
            this.addCriterion("gid >", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidGreaterThanColumn(Column column) {
            this.addCriterion("gid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            this.addCriterion("gid >=", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("gid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidLessThan(String value) {
            this.addCriterion("gid <", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidLessThanColumn(Column column) {
            this.addCriterion("gid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            this.addCriterion("gid <=", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("gid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGidLike(String value) {
            this.addCriterion("gid like", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidNotLike(String value) {
            this.addCriterion("gid not like", value, "gid");
            return (Criteria)this;
        }

        public Criteria andGidIn(List<String> values) {
            this.addCriterion("gid in", values, "gid");
            return (Criteria)this;
        }

        public Criteria andGidNotIn(List<String> values) {
            this.addCriterion("gid not in", values, "gid");
            return (Criteria)this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            this.addCriterion("gid between", value1, value2, "gid");
            return (Criteria)this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            this.addCriterion("gid not between", value1, value2, "gid");
            return (Criteria)this;
        }
    }

}
