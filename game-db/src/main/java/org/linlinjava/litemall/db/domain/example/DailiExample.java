//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import org.linlinjava.litemall.db.domain.Daili.*;

public class DailiExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.DailiExample.Criteria> oredCriteria = new ArrayList();

    public DailiExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.DailiExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.DailiExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.DailiExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.DailiExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public DailiExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DailiExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.DailiExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.DailiExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.DailiExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.DailiExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.DailiExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.DailiExample.Criteria newAndCreateCriteria() {
        DailiExample example = new DailiExample();
        return example.createCriteria();
    }

    public DailiExample when(boolean condition, org.linlinjava.litemall.db.domain.example.DailiExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public DailiExample when(boolean condition, org.linlinjava.litemall.db.domain.example.DailiExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.DailiExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(DailiExample example);
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

        public Criteria andAccountIsNull() {
            this.addCriterion("account is null");
            return (Criteria)this;
        }

        public Criteria andAccountIsNotNull() {
            this.addCriterion("account is not null");
            return (Criteria)this;
        }

        public Criteria andAccountEqualTo(String value) {
            this.addCriterion("account =", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountEqualToColumn(Column column) {
            this.addCriterion("account = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            this.addCriterion("account <>", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountNotEqualToColumn(Column column) {
            this.addCriterion("account <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountGreaterThan(String value) {
            this.addCriterion("account >", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountGreaterThanColumn(Column column) {
            this.addCriterion("account > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            this.addCriterion("account >=", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("account >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountLessThan(String value) {
            this.addCriterion("account <", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountLessThanColumn(Column column) {
            this.addCriterion("account < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            this.addCriterion("account <=", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountLessThanOrEqualToColumn(Column column) {
            this.addCriterion("account <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAccountLike(String value) {
            this.addCriterion("account like", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountNotLike(String value) {
            this.addCriterion("account not like", value, "account");
            return (Criteria)this;
        }

        public Criteria andAccountIn(List<String> values) {
            this.addCriterion("account in", values, "account");
            return (Criteria)this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            this.addCriterion("account not in", values, "account");
            return (Criteria)this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            this.addCriterion("account between", value1, value2, "account");
            return (Criteria)this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            this.addCriterion("account not between", value1, value2, "account");
            return (Criteria)this;
        }

        public Criteria andPasswdIsNull() {
            this.addCriterion("passwd is null");
            return (Criteria)this;
        }

        public Criteria andPasswdIsNotNull() {
            this.addCriterion("passwd is not null");
            return (Criteria)this;
        }

        public Criteria andPasswdEqualTo(String value) {
            this.addCriterion("passwd =", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdEqualToColumn(Column column) {
            this.addCriterion("passwd = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            this.addCriterion("passwd <>", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdNotEqualToColumn(Column column) {
            this.addCriterion("passwd <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            this.addCriterion("passwd >", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdGreaterThanColumn(Column column) {
            this.addCriterion("passwd > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            this.addCriterion("passwd >=", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("passwd >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdLessThan(String value) {
            this.addCriterion("passwd <", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdLessThanColumn(Column column) {
            this.addCriterion("passwd < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            this.addCriterion("passwd <=", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("passwd <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPasswdLike(String value) {
            this.addCriterion("passwd like", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdNotLike(String value) {
            this.addCriterion("passwd not like", value, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdIn(List<String> values) {
            this.addCriterion("passwd in", values, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            this.addCriterion("passwd not in", values, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            this.addCriterion("passwd between", value1, value2, "passwd");
            return (Criteria)this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            this.addCriterion("passwd not between", value1, value2, "passwd");
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
    }

    public static class Criteria extends GeneratedCriteria {
        private DailiExample example;

        protected Criteria(DailiExample example) {
            this.example = example;
        }

        public DailiExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.DailiExample.Criteria.ICriteriaAdd add) {
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
