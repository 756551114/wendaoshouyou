//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.MedicineShop.*;

public class MedicineShopExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria> oredCriteria = new ArrayList();

    public MedicineShopExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MedicineShopExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public MedicineShopExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria newAndCreateCriteria() {
        MedicineShopExample example = new MedicineShopExample();
        return example.createCriteria();
    }

    public MedicineShopExample when(boolean condition, org.linlinjava.litemall.db.domain.example.MedicineShopExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public MedicineShopExample when(boolean condition, org.linlinjava.litemall.db.domain.example.MedicineShopExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.MedicineShopExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(MedicineShopExample example);
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

        public Criteria andGoodsNoIsNull() {
            this.addCriterion("goods_no is null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoIsNotNull() {
            this.addCriterion("goods_no is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoEqualTo(Integer value) {
            this.addCriterion("goods_no =", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoEqualToColumn(Column column) {
            this.addCriterion("goods_no = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotEqualTo(Integer value) {
            this.addCriterion("goods_no <>", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotEqualToColumn(Column column) {
            this.addCriterion("goods_no <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThan(Integer value) {
            this.addCriterion("goods_no >", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThanColumn(Column column) {
            this.addCriterion("goods_no > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("goods_no >=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_no >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThan(Integer value) {
            this.addCriterion("goods_no <", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThanColumn(Column column) {
            this.addCriterion("goods_no < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThanOrEqualTo(Integer value) {
            this.addCriterion("goods_no <=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("goods_no <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andGoodsNoIn(List<Integer> values) {
            this.addCriterion("goods_no in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotIn(List<Integer> values) {
            this.addCriterion("goods_no not in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_no between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andPayTypeIsNull() {
            this.addCriterion("pay_type is null");
            return (Criteria)this;
        }

        public Criteria andPayTypeIsNotNull() {
            this.addCriterion("pay_type is not null");
            return (Criteria)this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            this.addCriterion("pay_type =", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeEqualToColumn(Column column) {
            this.addCriterion("pay_type = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            this.addCriterion("pay_type <>", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeNotEqualToColumn(Column column) {
            this.addCriterion("pay_type <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            this.addCriterion("pay_type >", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeGreaterThanColumn(Column column) {
            this.addCriterion("pay_type > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("pay_type >=", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pay_type >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            this.addCriterion("pay_type <", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeLessThanColumn(Column column) {
            this.addCriterion("pay_type < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("pay_type <=", value, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pay_type <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            this.addCriterion("pay_type in", values, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            this.addCriterion("pay_type not in", values, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria)this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("pay_type not between", value1, value2, "payType");
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

        public Criteria andItemcountIsNull() {
            this.addCriterion("itemCount is null");
            return (Criteria)this;
        }

        public Criteria andItemcountIsNotNull() {
            this.addCriterion("itemCount is not null");
            return (Criteria)this;
        }

        public Criteria andItemcountEqualTo(Integer value) {
            this.addCriterion("itemCount =", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountEqualToColumn(Column column) {
            this.addCriterion("itemCount = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountNotEqualTo(Integer value) {
            this.addCriterion("itemCount <>", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountNotEqualToColumn(Column column) {
            this.addCriterion("itemCount <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountGreaterThan(Integer value) {
            this.addCriterion("itemCount >", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountGreaterThanColumn(Column column) {
            this.addCriterion("itemCount > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("itemCount >=", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("itemCount >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountLessThan(Integer value) {
            this.addCriterion("itemCount <", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountLessThanColumn(Column column) {
            this.addCriterion("itemCount < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountLessThanOrEqualTo(Integer value) {
            this.addCriterion("itemCount <=", value, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountLessThanOrEqualToColumn(Column column) {
            this.addCriterion("itemCount <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andItemcountIn(List<Integer> values) {
            this.addCriterion("itemCount in", values, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountNotIn(List<Integer> values) {
            this.addCriterion("itemCount not in", values, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountBetween(Integer value1, Integer value2) {
            this.addCriterion("itemCount between", value1, value2, "itemcount");
            return (Criteria)this;
        }

        public Criteria andItemcountNotBetween(Integer value1, Integer value2) {
            this.addCriterion("itemCount not between", value1, value2, "itemcount");
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
        private MedicineShopExample example;

        protected Criteria(MedicineShopExample example) {
            this.example = example;
        }

        public MedicineShopExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria.ICriteriaAdd add) {
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
            Criteria add(Criteria add);
        }
    }


}
