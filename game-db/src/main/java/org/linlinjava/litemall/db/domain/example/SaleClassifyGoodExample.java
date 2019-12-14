//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.SaleClassifyGood.*;

public class SaleClassifyGoodExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria> oredCriteria = new ArrayList();

    public SaleClassifyGoodExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SaleClassifyGoodExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SaleClassifyGoodExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria newAndCreateCriteria() {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        return example.createCriteria();
    }

    public SaleClassifyGoodExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public SaleClassifyGoodExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(SaleClassifyGoodExample example);
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }




    public static  class Criterion {
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

        public Criteria andPnameIsNull() {
            this.addCriterion("pname is null");
            return (Criteria)this;
        }

        public Criteria andPnameIsNotNull() {
            this.addCriterion("pname is not null");
            return (Criteria)this;
        }

        public Criteria andPnameEqualTo(String value) {
            this.addCriterion("pname =", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameEqualToColumn(Column column) {
            this.addCriterion("pname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            this.addCriterion("pname <>", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameNotEqualToColumn(Column column) {
            this.addCriterion("pname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameGreaterThan(String value) {
            this.addCriterion("pname >", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameGreaterThanColumn(Column column) {
            this.addCriterion("pname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("pname >=", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameLessThan(String value) {
            this.addCriterion("pname <", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameLessThanColumn(Column column) {
            this.addCriterion("pname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            this.addCriterion("pname <=", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPnameLike(String value) {
            this.addCriterion("pname like", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameNotLike(String value) {
            this.addCriterion("pname not like", value, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameIn(List<String> values) {
            this.addCriterion("pname in", values, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            this.addCriterion("pname not in", values, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            this.addCriterion("pname between", value1, value2, "pname");
            return (Criteria)this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            this.addCriterion("pname not between", value1, value2, "pname");
            return (Criteria)this;
        }

        public Criteria andCnameIsNull() {
            this.addCriterion("cname is null");
            return (Criteria)this;
        }

        public Criteria andCnameIsNotNull() {
            this.addCriterion("cname is not null");
            return (Criteria)this;
        }

        public Criteria andCnameEqualTo(String value) {
            this.addCriterion("cname =", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameEqualToColumn(Column column) {
            this.addCriterion("cname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            this.addCriterion("cname <>", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameNotEqualToColumn(Column column) {
            this.addCriterion("cname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameGreaterThan(String value) {
            this.addCriterion("cname >", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameGreaterThanColumn(Column column) {
            this.addCriterion("cname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cname >=", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameLessThan(String value) {
            this.addCriterion("cname <", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameLessThanColumn(Column column) {
            this.addCriterion("cname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            this.addCriterion("cname <=", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCnameLike(String value) {
            this.addCriterion("cname like", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameNotLike(String value) {
            this.addCriterion("cname not like", value, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameIn(List<String> values) {
            this.addCriterion("cname in", values, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            this.addCriterion("cname not in", values, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            this.addCriterion("cname between", value1, value2, "cname");
            return (Criteria)this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            this.addCriterion("cname not between", value1, value2, "cname");
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

        public Criteria andAttribEqualTo(String value) {
            this.addCriterion("attrib =", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribEqualToColumn(Column column) {
            this.addCriterion("attrib = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualTo(String value) {
            this.addCriterion("attrib <>", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualToColumn(Column column) {
            this.addCriterion("attrib <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThan(String value) {
            this.addCriterion("attrib >", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanColumn(Column column) {
            this.addCriterion("attrib > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualTo(String value) {
            this.addCriterion("attrib >=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThan(String value) {
            this.addCriterion("attrib <", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanColumn(Column column) {
            this.addCriterion("attrib < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualTo(String value) {
            this.addCriterion("attrib <=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLike(String value) {
            this.addCriterion("attrib like", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotLike(String value) {
            this.addCriterion("attrib not like", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribIn(List<String> values) {
            this.addCriterion("attrib in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotIn(List<String> values) {
            this.addCriterion("attrib not in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribBetween(String value1, String value2) {
            this.addCriterion("attrib between", value1, value2, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotBetween(String value1, String value2) {
            this.addCriterion("attrib not between", value1, value2, "attrib");
            return (Criteria)this;
        }

        public Criteria andIconIsNull() {
            this.addCriterion("icon is null");
            return (Criteria)this;
        }

        public Criteria andIconIsNotNull() {
            this.addCriterion("icon is not null");
            return (Criteria)this;
        }

        public Criteria andIconEqualTo(Integer value) {
            this.addCriterion("icon =", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconEqualToColumn(Column column) {
            this.addCriterion("icon = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconNotEqualTo(Integer value) {
            this.addCriterion("icon <>", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotEqualToColumn(Column column) {
            this.addCriterion("icon <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThan(Integer value) {
            this.addCriterion("icon >", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanColumn(Column column) {
            this.addCriterion("icon > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("icon >=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("icon >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThan(Integer value) {
            this.addCriterion("icon <", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanColumn(Column column) {
            this.addCriterion("icon < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualTo(Integer value) {
            this.addCriterion("icon <=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualToColumn(Column column) {
            this.addCriterion("icon <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconIn(List<Integer> values) {
            this.addCriterion("icon in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotIn(List<Integer> values) {
            this.addCriterion("icon not in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconBetween(Integer value1, Integer value2) {
            this.addCriterion("icon between", value1, value2, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotBetween(Integer value1, Integer value2) {
            this.addCriterion("icon not between", value1, value2, "icon");
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

        public Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (Criteria)this;
        }

        public Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (Criteria)this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            this.addCriterion("price =", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceEqualToColumn(Column column) {
            this.addCriterion("price = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            this.addCriterion("price <>", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotEqualToColumn(Column column) {
            this.addCriterion("price <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            this.addCriterion("price >", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThanColumn(Column column) {
            this.addCriterion("price > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("price >=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("price >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceLessThan(Integer value) {
            this.addCriterion("price <", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThanColumn(Column column) {
            this.addCriterion("price < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("price <=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThanOrEqualToColumn(Column column) {
            this.addCriterion("price <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            this.addCriterion("price in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            this.addCriterion("price not in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (Criteria)this;
        }

        public Criteria andComposeIsNull() {
            this.addCriterion("compose is null");
            return (Criteria)this;
        }

        public Criteria andComposeIsNotNull() {
            this.addCriterion("compose is not null");
            return (Criteria)this;
        }

        public Criteria andComposeEqualTo(String value) {
            this.addCriterion("compose =", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeEqualToColumn(Column column) {
            this.addCriterion("compose = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeNotEqualTo(String value) {
            this.addCriterion("compose <>", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeNotEqualToColumn(Column column) {
            this.addCriterion("compose <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeGreaterThan(String value) {
            this.addCriterion("compose >", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeGreaterThanColumn(Column column) {
            this.addCriterion("compose > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeGreaterThanOrEqualTo(String value) {
            this.addCriterion("compose >=", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("compose >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeLessThan(String value) {
            this.addCriterion("compose <", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeLessThanColumn(Column column) {
            this.addCriterion("compose < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeLessThanOrEqualTo(String value) {
            this.addCriterion("compose <=", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("compose <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andComposeLike(String value) {
            this.addCriterion("compose like", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeNotLike(String value) {
            this.addCriterion("compose not like", value, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeIn(List<String> values) {
            this.addCriterion("compose in", values, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeNotIn(List<String> values) {
            this.addCriterion("compose not in", values, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeBetween(String value1, String value2) {
            this.addCriterion("compose between", value1, value2, "compose");
            return (Criteria)this;
        }

        public Criteria andComposeNotBetween(String value1, String value2) {
            this.addCriterion("compose not between", value1, value2, "compose");
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
        private SaleClassifyGoodExample example;

        protected Criteria(SaleClassifyGoodExample example) {
            this.example = example;
        }

        public SaleClassifyGoodExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria.ICriteriaAdd add) {
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
