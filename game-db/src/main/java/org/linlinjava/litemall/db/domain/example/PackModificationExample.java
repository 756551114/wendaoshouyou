//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.PackModification.*;

public class PackModificationExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria> oredCriteria = new ArrayList();

    public PackModificationExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public PackModificationExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PackModificationExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria newAndCreateCriteria() {
        PackModificationExample example = new PackModificationExample();
        return example.createCriteria();
    }

    public PackModificationExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PackModificationExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public PackModificationExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PackModificationExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.PackModificationExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(PackModificationExample example);
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

        public Criteria andAliasIsNull() {
            this.addCriterion("`alias` is null");
            return (Criteria)this;
        }

        public Criteria andAliasIsNotNull() {
            this.addCriterion("`alias` is not null");
            return (Criteria)this;
        }

        public Criteria andAliasEqualTo(String value) {
            this.addCriterion("`alias` =", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasEqualToColumn(Column column) {
            this.addCriterion("`alias` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            this.addCriterion("`alias` <>", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasNotEqualToColumn(Column column) {
            this.addCriterion("`alias` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasGreaterThan(String value) {
            this.addCriterion("`alias` >", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasGreaterThanColumn(Column column) {
            this.addCriterion("`alias` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            this.addCriterion("`alias` >=", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`alias` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasLessThan(String value) {
            this.addCriterion("`alias` <", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasLessThanColumn(Column column) {
            this.addCriterion("`alias` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            this.addCriterion("`alias` <=", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`alias` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAliasLike(String value) {
            this.addCriterion("`alias` like", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasNotLike(String value) {
            this.addCriterion("`alias` not like", value, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasIn(List<String> values) {
            this.addCriterion("`alias` in", values, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            this.addCriterion("`alias` not in", values, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            this.addCriterion("`alias` between", value1, value2, "alias");
            return (Criteria)this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            this.addCriterion("`alias` not between", value1, value2, "alias");
            return (Criteria)this;
        }

        public Criteria andFasionTypeIsNull() {
            this.addCriterion("fasion_type is null");
            return (Criteria)this;
        }

        public Criteria andFasionTypeIsNotNull() {
            this.addCriterion("fasion_type is not null");
            return (Criteria)this;
        }

        public Criteria andFasionTypeEqualTo(String value) {
            this.addCriterion("fasion_type =", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeEqualToColumn(Column column) {
            this.addCriterion("fasion_type = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeNotEqualTo(String value) {
            this.addCriterion("fasion_type <>", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeNotEqualToColumn(Column column) {
            this.addCriterion("fasion_type <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeGreaterThan(String value) {
            this.addCriterion("fasion_type >", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeGreaterThanColumn(Column column) {
            this.addCriterion("fasion_type > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("fasion_type >=", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("fasion_type >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeLessThan(String value) {
            this.addCriterion("fasion_type <", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeLessThanColumn(Column column) {
            this.addCriterion("fasion_type < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeLessThanOrEqualTo(String value) {
            this.addCriterion("fasion_type <=", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("fasion_type <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFasionTypeLike(String value) {
            this.addCriterion("fasion_type like", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeNotLike(String value) {
            this.addCriterion("fasion_type not like", value, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeIn(List<String> values) {
            this.addCriterion("fasion_type in", values, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeNotIn(List<String> values) {
            this.addCriterion("fasion_type not in", values, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeBetween(String value1, String value2) {
            this.addCriterion("fasion_type between", value1, value2, "fasionType");
            return (Criteria)this;
        }

        public Criteria andFasionTypeNotBetween(String value1, String value2) {
            this.addCriterion("fasion_type not between", value1, value2, "fasionType");
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

        public Criteria andTypeIsNull() {
            this.addCriterion("`type` is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("`type` is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(String value) {
            this.addCriterion("`type` =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeEqualToColumn(Column column) {
            this.addCriterion("`type` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("`type` <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualToColumn(Column column) {
            this.addCriterion("`type` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(String value) {
            this.addCriterion("`type` >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanColumn(Column column) {
            this.addCriterion("`type` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("`type` >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`type` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(String value) {
            this.addCriterion("`type` <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanColumn(Column column) {
            this.addCriterion("`type` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("`type` <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`type` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTypeLike(String value) {
            this.addCriterion("`type` like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotLike(String value) {
            this.addCriterion("`type` not like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeIn(List<String> values) {
            this.addCriterion("`type` in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("`type` not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("`type` between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("`type` not between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andFoodNumIsNull() {
            this.addCriterion("food_num is null");
            return (Criteria)this;
        }

        public Criteria andFoodNumIsNotNull() {
            this.addCriterion("food_num is not null");
            return (Criteria)this;
        }

        public Criteria andFoodNumEqualTo(Integer value) {
            this.addCriterion("food_num =", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumEqualToColumn(Column column) {
            this.addCriterion("food_num = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumNotEqualTo(Integer value) {
            this.addCriterion("food_num <>", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumNotEqualToColumn(Column column) {
            this.addCriterion("food_num <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumGreaterThan(Integer value) {
            this.addCriterion("food_num >", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumGreaterThanColumn(Column column) {
            this.addCriterion("food_num > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("food_num >=", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("food_num >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumLessThan(Integer value) {
            this.addCriterion("food_num <", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumLessThanColumn(Column column) {
            this.addCriterion("food_num < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("food_num <=", value, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumLessThanOrEqualToColumn(Column column) {
            this.addCriterion("food_num <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFoodNumIn(List<Integer> values) {
            this.addCriterion("food_num in", values, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumNotIn(List<Integer> values) {
            this.addCriterion("food_num not in", values, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumBetween(Integer value1, Integer value2) {
            this.addCriterion("food_num between", value1, value2, "foodNum");
            return (Criteria)this;
        }

        public Criteria andFoodNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("food_num not between", value1, value2, "foodNum");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceIsNull() {
            this.addCriterion("goods_price is null");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            this.addCriterion("goods_price is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceEqualTo(Integer value) {
            this.addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceEqualToColumn(Column column) {
            this.addCriterion("goods_price = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceNotEqualTo(Integer value) {
            this.addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceNotEqualToColumn(Column column) {
            this.addCriterion("goods_price <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceGreaterThan(Integer value) {
            this.addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceGreaterThanColumn(Column column) {
            this.addCriterion("goods_price > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_price >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceLessThan(Integer value) {
            this.addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceLessThanColumn(Column column) {
            this.addCriterion("goods_price < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceLessThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_price <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsPriceIn(List<Integer> values) {
            this.addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceNotIn(List<Integer> values) {
            this.addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andGoodsPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria)this;
        }

        public Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (Criteria)this;
        }

        public Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (Criteria)this;
        }

        public Criteria andSexEqualTo(Integer value) {
            this.addCriterion("sex =", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexEqualToColumn(Column column) {
            this.addCriterion("sex = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            this.addCriterion("sex <>", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotEqualToColumn(Column column) {
            this.addCriterion("sex <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            this.addCriterion("sex >", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexGreaterThanColumn(Column column) {
            this.addCriterion("sex > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sex >=", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("sex >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexLessThan(Integer value) {
            this.addCriterion("sex <", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexLessThanColumn(Column column) {
            this.addCriterion("sex < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            this.addCriterion("sex <=", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexLessThanOrEqualToColumn(Column column) {
            this.addCriterion("sex <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSexIn(List<Integer> values) {
            this.addCriterion("sex in", values, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            this.addCriterion("sex not in", values, "sex");
            return (Criteria)this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (Criteria)this;
        }

        public Criteria andPositionIsNull() {
            this.addCriterion("`position` is null");
            return (Criteria)this;
        }

        public Criteria andPositionIsNotNull() {
            this.addCriterion("`position` is not null");
            return (Criteria)this;
        }

        public Criteria andPositionEqualTo(Integer value) {
            this.addCriterion("`position` =", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionEqualToColumn(Column column) {
            this.addCriterion("`position` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionNotEqualTo(Integer value) {
            this.addCriterion("`position` <>", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionNotEqualToColumn(Column column) {
            this.addCriterion("`position` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionGreaterThan(Integer value) {
            this.addCriterion("`position` >", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionGreaterThanColumn(Column column) {
            this.addCriterion("`position` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`position` >=", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`position` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionLessThan(Integer value) {
            this.addCriterion("`position` <", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionLessThanColumn(Column column) {
            this.addCriterion("`position` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionLessThanOrEqualTo(Integer value) {
            this.addCriterion("`position` <=", value, "position");
            return (Criteria)this;
        }

        public Criteria andPositionLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`position` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPositionIn(List<Integer> values) {
            this.addCriterion("`position` in", values, "position");
            return (Criteria)this;
        }

        public Criteria andPositionNotIn(List<Integer> values) {
            this.addCriterion("`position` not in", values, "position");
            return (Criteria)this;
        }

        public Criteria andPositionBetween(Integer value1, Integer value2) {
            this.addCriterion("`position` between", value1, value2, "position");
            return (Criteria)this;
        }

        public Criteria andPositionNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`position` not between", value1, value2, "position");
            return (Criteria)this;
        }

        public Criteria andCategoryIsNull() {
            this.addCriterion("category is null");
            return (Criteria)this;
        }

        public Criteria andCategoryIsNotNull() {
            this.addCriterion("category is not null");
            return (Criteria)this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            this.addCriterion("category =", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryEqualToColumn(Column column) {
            this.addCriterion("category = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            this.addCriterion("category <>", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryNotEqualToColumn(Column column) {
            this.addCriterion("category <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            this.addCriterion("category >", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryGreaterThanColumn(Column column) {
            this.addCriterion("category > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("category >=", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("category >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            this.addCriterion("category <", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryLessThanColumn(Column column) {
            this.addCriterion("category < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            this.addCriterion("category <=", value, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryLessThanOrEqualToColumn(Column column) {
            this.addCriterion("category <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            this.addCriterion("category in", values, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            this.addCriterion("category not in", values, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            this.addCriterion("category between", value1, value2, "category");
            return (Criteria)this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            this.addCriterion("category not between", value1, value2, "category");
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
        private PackModificationExample example;

        protected Criteria(PackModificationExample example) {
            this.example = example;
        }

        public PackModificationExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria.ICriteriaAdd add) {
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
