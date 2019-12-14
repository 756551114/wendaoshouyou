//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.SaleGood.*;

public class SaleGoodExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria> oredCriteria = new ArrayList();

    public SaleGoodExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SaleGoodExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SaleGoodExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria newAndCreateCriteria() {
        SaleGoodExample example = new SaleGoodExample();
        return example.createCriteria();
    }

    public SaleGoodExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SaleGoodExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public SaleGoodExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SaleGoodExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.SaleGoodExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(SaleGoodExample example);
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

        public Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdEqualToColumn(Column column) {
            this.addCriterion("goods_id = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotEqualToColumn(Column column) {
            this.addCriterion("goods_id <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThanColumn(Column column) {
            this.addCriterion("goods_id > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_id >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThanColumn(Column column) {
            this.addCriterion("goods_id < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_id <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (Criteria)this;
        }

        public Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (Criteria)this;
        }

        public Criteria andStartTimeEqualTo(Integer value) {
            this.addCriterion("start_time =", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeEqualToColumn(Column column) {
            this.addCriterion("start_time = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeNotEqualTo(Integer value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeNotEqualToColumn(Column column) {
            this.addCriterion("start_time <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeGreaterThan(Integer value) {
            this.addCriterion("start_time >", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeGreaterThanColumn(Column column) {
            this.addCriterion("start_time > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("start_time >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeLessThan(Integer value) {
            this.addCriterion("start_time <", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeLessThanColumn(Column column) {
            this.addCriterion("start_time < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Integer value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("start_time <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andStartTimeIn(List<Integer> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeNotIn(List<Integer> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeBetween(Integer value1, Integer value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria)this;
        }

        public Criteria andStartTimeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeIsNull() {
            this.addCriterion("end_time is null");
            return (Criteria)this;
        }

        public Criteria andEndTimeIsNotNull() {
            this.addCriterion("end_time is not null");
            return (Criteria)this;
        }

        public Criteria andEndTimeEqualTo(Integer value) {
            this.addCriterion("end_time =", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeEqualToColumn(Column column) {
            this.addCriterion("end_time = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeNotEqualTo(Integer value) {
            this.addCriterion("end_time <>", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeNotEqualToColumn(Column column) {
            this.addCriterion("end_time <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeGreaterThan(Integer value) {
            this.addCriterion("end_time >", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeGreaterThanColumn(Column column) {
            this.addCriterion("end_time > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("end_time >=", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("end_time >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeLessThan(Integer value) {
            this.addCriterion("end_time <", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeLessThanColumn(Column column) {
            this.addCriterion("end_time < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Integer value) {
            this.addCriterion("end_time <=", value, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("end_time <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andEndTimeIn(List<Integer> values) {
            this.addCriterion("end_time in", values, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeNotIn(List<Integer> values) {
            this.addCriterion("end_time not in", values, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeBetween(Integer value1, Integer value2) {
            this.addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria)this;
        }

        public Criteria andEndTimeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andReqLevelIsNull() {
            this.addCriterion("req_level is null");
            return (Criteria)this;
        }

        public Criteria andReqLevelIsNotNull() {
            this.addCriterion("req_level is not null");
            return (Criteria)this;
        }

        public Criteria andReqLevelEqualTo(Integer value) {
            this.addCriterion("req_level =", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelEqualToColumn(Column column) {
            this.addCriterion("req_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelNotEqualTo(Integer value) {
            this.addCriterion("req_level <>", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelNotEqualToColumn(Column column) {
            this.addCriterion("req_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelGreaterThan(Integer value) {
            this.addCriterion("req_level >", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelGreaterThanColumn(Column column) {
            this.addCriterion("req_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("req_level >=", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("req_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelLessThan(Integer value) {
            this.addCriterion("req_level <", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelLessThanColumn(Column column) {
            this.addCriterion("req_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("req_level <=", value, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("req_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andReqLevelIn(List<Integer> values) {
            this.addCriterion("req_level in", values, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelNotIn(List<Integer> values) {
            this.addCriterion("req_level not in", values, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("req_level between", value1, value2, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andReqLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("req_level not between", value1, value2, "reqLevel");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidIsNull() {
            this.addCriterion("owner_uuid is null");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidIsNotNull() {
            this.addCriterion("owner_uuid is not null");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidEqualTo(String value) {
            this.addCriterion("owner_uuid =", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidEqualToColumn(Column column) {
            this.addCriterion("owner_uuid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidNotEqualTo(String value) {
            this.addCriterion("owner_uuid <>", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidNotEqualToColumn(Column column) {
            this.addCriterion("owner_uuid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidGreaterThan(String value) {
            this.addCriterion("owner_uuid >", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidGreaterThanColumn(Column column) {
            this.addCriterion("owner_uuid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidGreaterThanOrEqualTo(String value) {
            this.addCriterion("owner_uuid >=", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("owner_uuid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidLessThan(String value) {
            this.addCriterion("owner_uuid <", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidLessThanColumn(Column column) {
            this.addCriterion("owner_uuid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidLessThanOrEqualTo(String value) {
            this.addCriterion("owner_uuid <=", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("owner_uuid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwnerUuidLike(String value) {
            this.addCriterion("owner_uuid like", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidNotLike(String value) {
            this.addCriterion("owner_uuid not like", value, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidIn(List<String> values) {
            this.addCriterion("owner_uuid in", values, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidNotIn(List<String> values) {
            this.addCriterion("owner_uuid not in", values, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidBetween(String value1, String value2) {
            this.addCriterion("owner_uuid between", value1, value2, "ownerUuid");
            return (Criteria)this;
        }

        public Criteria andOwnerUuidNotBetween(String value1, String value2) {
            this.addCriterion("owner_uuid not between", value1, value2, "ownerUuid");
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

        public Criteria andPetIsNull() {
            this.addCriterion("pet is null");
            return (Criteria)this;
        }

        public Criteria andPetIsNotNull() {
            this.addCriterion("pet is not null");
            return (Criteria)this;
        }

        public Criteria andPetEqualTo(String value) {
            this.addCriterion("pet =", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetEqualToColumn(Column column) {
            this.addCriterion("pet = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetNotEqualTo(String value) {
            this.addCriterion("pet <>", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetNotEqualToColumn(Column column) {
            this.addCriterion("pet <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetGreaterThan(String value) {
            this.addCriterion("pet >", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetGreaterThanColumn(Column column) {
            this.addCriterion("pet > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetGreaterThanOrEqualTo(String value) {
            this.addCriterion("pet >=", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pet >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetLessThan(String value) {
            this.addCriterion("pet <", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetLessThanColumn(Column column) {
            this.addCriterion("pet < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetLessThanOrEqualTo(String value) {
            this.addCriterion("pet <=", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pet <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetLike(String value) {
            this.addCriterion("pet like", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetNotLike(String value) {
            this.addCriterion("pet not like", value, "pet");
            return (Criteria)this;
        }

        public Criteria andPetIn(List<String> values) {
            this.addCriterion("pet in", values, "pet");
            return (Criteria)this;
        }

        public Criteria andPetNotIn(List<String> values) {
            this.addCriterion("pet not in", values, "pet");
            return (Criteria)this;
        }

        public Criteria andPetBetween(String value1, String value2) {
            this.addCriterion("pet between", value1, value2, "pet");
            return (Criteria)this;
        }

        public Criteria andPetNotBetween(String value1, String value2) {
            this.addCriterion("pet not between", value1, value2, "pet");
            return (Criteria)this;
        }

        public Criteria andPosIsNull() {
            this.addCriterion("pos is null");
            return (Criteria)this;
        }

        public Criteria andPosIsNotNull() {
            this.addCriterion("pos is not null");
            return (Criteria)this;
        }

        public Criteria andPosEqualTo(Integer value) {
            this.addCriterion("pos =", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosEqualToColumn(Column column) {
            this.addCriterion("pos = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosNotEqualTo(Integer value) {
            this.addCriterion("pos <>", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosNotEqualToColumn(Column column) {
            this.addCriterion("pos <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosGreaterThan(Integer value) {
            this.addCriterion("pos >", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosGreaterThanColumn(Column column) {
            this.addCriterion("pos > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("pos >=", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pos >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosLessThan(Integer value) {
            this.addCriterion("pos <", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosLessThanColumn(Column column) {
            this.addCriterion("pos < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosLessThanOrEqualTo(Integer value) {
            this.addCriterion("pos <=", value, "pos");
            return (Criteria)this;
        }

        public Criteria andPosLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pos <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPosIn(List<Integer> values) {
            this.addCriterion("pos in", values, "pos");
            return (Criteria)this;
        }

        public Criteria andPosNotIn(List<Integer> values) {
            this.addCriterion("pos not in", values, "pos");
            return (Criteria)this;
        }

        public Criteria andPosBetween(Integer value1, Integer value2) {
            this.addCriterion("pos between", value1, value2, "pos");
            return (Criteria)this;
        }

        public Criteria andPosNotBetween(Integer value1, Integer value2) {
            this.addCriterion("pos not between", value1, value2, "pos");
            return (Criteria)this;
        }

        public Criteria andIspetIsNull() {
            this.addCriterion("ispet is null");
            return (Criteria)this;
        }

        public Criteria andIspetIsNotNull() {
            this.addCriterion("ispet is not null");
            return (Criteria)this;
        }

        public Criteria andIspetEqualTo(Integer value) {
            this.addCriterion("ispet =", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetEqualToColumn(Column column) {
            this.addCriterion("ispet = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetNotEqualTo(Integer value) {
            this.addCriterion("ispet <>", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetNotEqualToColumn(Column column) {
            this.addCriterion("ispet <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetGreaterThan(Integer value) {
            this.addCriterion("ispet >", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetGreaterThanColumn(Column column) {
            this.addCriterion("ispet > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("ispet >=", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("ispet >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetLessThan(Integer value) {
            this.addCriterion("ispet <", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetLessThanColumn(Column column) {
            this.addCriterion("ispet < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetLessThanOrEqualTo(Integer value) {
            this.addCriterion("ispet <=", value, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetLessThanOrEqualToColumn(Column column) {
            this.addCriterion("ispet <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIspetIn(List<Integer> values) {
            this.addCriterion("ispet in", values, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetNotIn(List<Integer> values) {
            this.addCriterion("ispet not in", values, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetBetween(Integer value1, Integer value2) {
            this.addCriterion("ispet between", value1, value2, "ispet");
            return (Criteria)this;
        }

        public Criteria andIspetNotBetween(Integer value1, Integer value2) {
            this.addCriterion("ispet not between", value1, value2, "ispet");
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
    }



    public static class Criteria extends GeneratedCriteria {
        private SaleGoodExample example;

        protected Criteria(SaleGoodExample example) {
            this.example = example;
        }

        public SaleGoodExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria.ICriteriaAdd add) {
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

        public interface ICriteriaAdd {
            Criteria add(Criteria criteria);
        }
    }


}
