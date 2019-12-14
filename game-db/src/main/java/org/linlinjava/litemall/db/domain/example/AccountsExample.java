//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Accounts.*;

public class AccountsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria> oredCriteria = new ArrayList();

    public AccountsExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public AccountsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public AccountsExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria newAndCreateCriteria() {
        AccountsExample example = new AccountsExample();
        return example.createCriteria();
    }

    public AccountsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.AccountsExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public AccountsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.AccountsExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.AccountsExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(AccountsExample example);
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

    public static class Criteria extends GeneratedCriteria {
        private AccountsExample example;

        protected Criteria(AccountsExample example) {
            this.example = example;
        }

        public AccountsExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria.ICriteriaAdd add) {
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

        public Criteria andKeywordIsNull() {
            this.addCriterion("keyword is null");
            return (Criteria)this;
        }

        public Criteria andKeywordIsNotNull() {
            this.addCriterion("keyword is not null");
            return (Criteria)this;
        }

        public Criteria andKeywordEqualTo(String value) {
            this.addCriterion("keyword =", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordEqualToColumn(Column column) {
            this.addCriterion("keyword = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            this.addCriterion("keyword <>", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordNotEqualToColumn(Column column) {
            this.addCriterion("keyword <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            this.addCriterion("keyword >", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordGreaterThanColumn(Column column) {
            this.addCriterion("keyword > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            this.addCriterion("keyword >=", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("keyword >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordLessThan(String value) {
            this.addCriterion("keyword <", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordLessThanColumn(Column column) {
            this.addCriterion("keyword < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            this.addCriterion("keyword <=", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordLessThanOrEqualToColumn(Column column) {
            this.addCriterion("keyword <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andKeywordLike(String value) {
            this.addCriterion("keyword like", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordNotLike(String value) {
            this.addCriterion("keyword not like", value, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordIn(List<String> values) {
            this.addCriterion("keyword in", values, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            this.addCriterion("keyword not in", values, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            this.addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria)this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            this.addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria)this;
        }

        public Criteria andPasswordIsNull() {
            this.addCriterion("`password` is null");
            return (Criteria)this;
        }

        public Criteria andPasswordIsNotNull() {
            this.addCriterion("`password` is not null");
            return (Criteria)this;
        }

        public Criteria andPasswordEqualTo(String value) {
            this.addCriterion("`password` =", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordEqualToColumn(Column column) {
            this.addCriterion("`password` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            this.addCriterion("`password` <>", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotEqualToColumn(Column column) {
            this.addCriterion("`password` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            this.addCriterion("`password` >", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThanColumn(Column column) {
            this.addCriterion("`password` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("`password` >=", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`password` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordLessThan(String value) {
            this.addCriterion("`password` <", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordLessThanColumn(Column column) {
            this.addCriterion("`password` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("`password` <=", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`password` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswordLike(String value) {
            this.addCriterion("`password` like", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotLike(String value) {
            this.addCriterion("`password` not like", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordIn(List<String> values) {
            this.addCriterion("`password` in", values, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            this.addCriterion("`password` not in", values, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            this.addCriterion("`password` between", value1, value2, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            this.addCriterion("`password` not between", value1, value2, "password");
            return (Criteria)this;
        }

        public Criteria andTokenIsNull() {
            this.addCriterion("token is null");
            return (Criteria)this;
        }

        public Criteria andTokenIsNotNull() {
            this.addCriterion("token is not null");
            return (Criteria)this;
        }

        public Criteria andTokenEqualTo(String value) {
            this.addCriterion("token =", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenEqualToColumn(Column column) {
            this.addCriterion("token = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            this.addCriterion("token <>", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenNotEqualToColumn(Column column) {
            this.addCriterion("token <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenGreaterThan(String value) {
            this.addCriterion("token >", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenGreaterThanColumn(Column column) {
            this.addCriterion("token > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            this.addCriterion("token >=", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("token >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenLessThan(String value) {
            this.addCriterion("token <", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenLessThanColumn(Column column) {
            this.addCriterion("token < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            this.addCriterion("token <=", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenLessThanOrEqualToColumn(Column column) {
            this.addCriterion("token <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTokenLike(String value) {
            this.addCriterion("token like", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenNotLike(String value) {
            this.addCriterion("token not like", value, "token");
            return (Criteria)this;
        }

        public Criteria andTokenIn(List<String> values) {
            this.addCriterion("token in", values, "token");
            return (Criteria)this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            this.addCriterion("token not in", values, "token");
            return (Criteria)this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            this.addCriterion("token between", value1, value2, "token");
            return (Criteria)this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            this.addCriterion("token not between", value1, value2, "token");
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

        public Criteria andChongzhijifenIsNull() {
            this.addCriterion("chongzhijifen is null");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenIsNotNull() {
            this.addCriterion("chongzhijifen is not null");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenEqualTo(Integer value) {
            this.addCriterion("chongzhijifen =", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenEqualToColumn(Column column) {
            this.addCriterion("chongzhijifen = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenNotEqualTo(Integer value) {
            this.addCriterion("chongzhijifen <>", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenNotEqualToColumn(Column column) {
            this.addCriterion("chongzhijifen <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenGreaterThan(Integer value) {
            this.addCriterion("chongzhijifen >", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenGreaterThanColumn(Column column) {
            this.addCriterion("chongzhijifen > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("chongzhijifen >=", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("chongzhijifen >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenLessThan(Integer value) {
            this.addCriterion("chongzhijifen <", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenLessThanColumn(Column column) {
            this.addCriterion("chongzhijifen < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenLessThanOrEqualTo(Integer value) {
            this.addCriterion("chongzhijifen <=", value, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenLessThanOrEqualToColumn(Column column) {
            this.addCriterion("chongzhijifen <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhijifenIn(List<Integer> values) {
            this.addCriterion("chongzhijifen in", values, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenNotIn(List<Integer> values) {
            this.addCriterion("chongzhijifen not in", values, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenBetween(Integer value1, Integer value2) {
            this.addCriterion("chongzhijifen between", value1, value2, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhijifenNotBetween(Integer value1, Integer value2) {
            this.addCriterion("chongzhijifen not between", value1, value2, "chongzhijifen");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoIsNull() {
            this.addCriterion("chongzhiyuanbao is null");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoIsNotNull() {
            this.addCriterion("chongzhiyuanbao is not null");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoEqualTo(Integer value) {
            this.addCriterion("chongzhiyuanbao =", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoEqualToColumn(Column column) {
            this.addCriterion("chongzhiyuanbao = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoNotEqualTo(Integer value) {
            this.addCriterion("chongzhiyuanbao <>", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoNotEqualToColumn(Column column) {
            this.addCriterion("chongzhiyuanbao <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoGreaterThan(Integer value) {
            this.addCriterion("chongzhiyuanbao >", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoGreaterThanColumn(Column column) {
            this.addCriterion("chongzhiyuanbao > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("chongzhiyuanbao >=", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("chongzhiyuanbao >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoLessThan(Integer value) {
            this.addCriterion("chongzhiyuanbao <", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoLessThanColumn(Column column) {
            this.addCriterion("chongzhiyuanbao < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoLessThanOrEqualTo(Integer value) {
            this.addCriterion("chongzhiyuanbao <=", value, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("chongzhiyuanbao <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoIn(List<Integer> values) {
            this.addCriterion("chongzhiyuanbao in", values, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoNotIn(List<Integer> values) {
            this.addCriterion("chongzhiyuanbao not in", values, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoBetween(Integer value1, Integer value2) {
            this.addCriterion("chongzhiyuanbao between", value1, value2, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andChongzhiyuanbaoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("chongzhiyuanbao not between", value1, value2, "chongzhiyuanbao");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaIsNull() {
            this.addCriterion("yaoqingma is null");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaIsNotNull() {
            this.addCriterion("yaoqingma is not null");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaEqualTo(String value) {
            this.addCriterion("yaoqingma =", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaEqualToColumn(Column column) {
            this.addCriterion("yaoqingma = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaNotEqualTo(String value) {
            this.addCriterion("yaoqingma <>", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaNotEqualToColumn(Column column) {
            this.addCriterion("yaoqingma <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaGreaterThan(String value) {
            this.addCriterion("yaoqingma >", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaGreaterThanColumn(Column column) {
            this.addCriterion("yaoqingma > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaGreaterThanOrEqualTo(String value) {
            this.addCriterion("yaoqingma >=", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("yaoqingma >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaLessThan(String value) {
            this.addCriterion("yaoqingma <", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaLessThanColumn(Column column) {
            this.addCriterion("yaoqingma < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaLessThanOrEqualTo(String value) {
            this.addCriterion("yaoqingma <=", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("yaoqingma <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYaoqingmaLike(String value) {
            this.addCriterion("yaoqingma like", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaNotLike(String value) {
            this.addCriterion("yaoqingma not like", value, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaIn(List<String> values) {
            this.addCriterion("yaoqingma in", values, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaNotIn(List<String> values) {
            this.addCriterion("yaoqingma not in", values, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaBetween(String value1, String value2) {
            this.addCriterion("yaoqingma between", value1, value2, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andYaoqingmaNotBetween(String value1, String value2) {
            this.addCriterion("yaoqingma not between", value1, value2, "yaoqingma");
            return (Criteria)this;
        }

        public Criteria andBlockIsNull() {
            this.addCriterion("block is null");
            return (Criteria)this;
        }

        public Criteria andBlockIsNotNull() {
            this.addCriterion("block is not null");
            return (Criteria)this;
        }

        public Criteria andBlockEqualTo(Integer value) {
            this.addCriterion("block =", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockEqualToColumn(Column column) {
            this.addCriterion("block = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockNotEqualTo(Integer value) {
            this.addCriterion("block <>", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockNotEqualToColumn(Column column) {
            this.addCriterion("block <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockGreaterThan(Integer value) {
            this.addCriterion("block >", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockGreaterThanColumn(Column column) {
            this.addCriterion("block > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("block >=", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("block >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockLessThan(Integer value) {
            this.addCriterion("block <", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockLessThanColumn(Column column) {
            this.addCriterion("block < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockLessThanOrEqualTo(Integer value) {
            this.addCriterion("block <=", value, "block");
            return (Criteria)this;
        }

        public Criteria andBlockLessThanOrEqualToColumn(Column column) {
            this.addCriterion("block <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBlockIn(List<Integer> values) {
            this.addCriterion("block in", values, "block");
            return (Criteria)this;
        }

        public Criteria andBlockNotIn(List<Integer> values) {
            this.addCriterion("block not in", values, "block");
            return (Criteria)this;
        }

        public Criteria andBlockBetween(Integer value1, Integer value2) {
            this.addCriterion("block between", value1, value2, "block");
            return (Criteria)this;
        }

        public Criteria andBlockNotBetween(Integer value1, Integer value2) {
            this.addCriterion("block not between", value1, value2, "block");
            return (Criteria)this;
        }

        public Criteria andCodeIsNull() {
            this.addCriterion("code is null");
            return (Criteria)this;
        }

        public Criteria andCodeIsNotNull() {
            this.addCriterion("code is not null");
            return (Criteria)this;
        }

        public Criteria andCodeEqualTo(String value) {
            this.addCriterion("code =", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeEqualToColumn(Column column) {
            this.addCriterion("code = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            this.addCriterion("code <>", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotEqualToColumn(Column column) {
            this.addCriterion("code <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThan(String value) {
            this.addCriterion("code >", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThanColumn(Column column) {
            this.addCriterion("code > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("code >=", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("code >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeLessThan(String value) {
            this.addCriterion("code <", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeLessThanColumn(Column column) {
            this.addCriterion("code < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            this.addCriterion("code <=", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("code <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCodeLike(String value) {
            this.addCriterion("code like", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotLike(String value) {
            this.addCriterion("code not like", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeIn(List<String> values) {
            this.addCriterion("code in", values, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            this.addCriterion("code not in", values, "code");
            return (Criteria)this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            this.addCriterion("code between", value1, value2, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            this.addCriterion("code not between", value1, value2, "code");
            return (Criteria)this;
        }
    }


}
