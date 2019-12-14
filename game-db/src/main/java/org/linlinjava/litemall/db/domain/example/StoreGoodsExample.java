//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.StoreGoods.*;

public class StoreGoodsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria> oredCriteria = new ArrayList();

    public StoreGoodsExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public StoreGoodsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public StoreGoodsExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria newAndCreateCriteria() {
        StoreGoodsExample example = new StoreGoodsExample();
        return example.createCriteria();
    }

    public StoreGoodsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.StoreGoodsExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public StoreGoodsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.StoreGoodsExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.StoreGoodsExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(StoreGoodsExample example);
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

        public Criteria andBarcodeIsNull() {
            this.addCriterion("barcode is null");
            return (Criteria)this;
        }

        public Criteria andBarcodeIsNotNull() {
            this.addCriterion("barcode is not null");
            return (Criteria)this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            this.addCriterion("barcode =", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeEqualToColumn(Column column) {
            this.addCriterion("barcode = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            this.addCriterion("barcode <>", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeNotEqualToColumn(Column column) {
            this.addCriterion("barcode <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            this.addCriterion("barcode >", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeGreaterThanColumn(Column column) {
            this.addCriterion("barcode > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("barcode >=", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("barcode >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeLessThan(String value) {
            this.addCriterion("barcode <", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeLessThanColumn(Column column) {
            this.addCriterion("barcode < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            this.addCriterion("barcode <=", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("barcode <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andBarcodeLike(String value) {
            this.addCriterion("barcode like", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeNotLike(String value) {
            this.addCriterion("barcode not like", value, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            this.addCriterion("barcode in", values, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            this.addCriterion("barcode not in", values, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            this.addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria)this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            this.addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria)this;
        }

        public Criteria andForSaleIsNull() {
            this.addCriterion("for_sale is null");
            return (Criteria)this;
        }

        public Criteria andForSaleIsNotNull() {
            this.addCriterion("for_sale is not null");
            return (Criteria)this;
        }

        public Criteria andForSaleEqualTo(Integer value) {
            this.addCriterion("for_sale =", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleEqualToColumn(Column column) {
            this.addCriterion("for_sale = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleNotEqualTo(Integer value) {
            this.addCriterion("for_sale <>", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleNotEqualToColumn(Column column) {
            this.addCriterion("for_sale <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleGreaterThan(Integer value) {
            this.addCriterion("for_sale >", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleGreaterThanColumn(Column column) {
            this.addCriterion("for_sale > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("for_sale >=", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("for_sale >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleLessThan(Integer value) {
            this.addCriterion("for_sale <", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleLessThanColumn(Column column) {
            this.addCriterion("for_sale < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleLessThanOrEqualTo(Integer value) {
            this.addCriterion("for_sale <=", value, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleLessThanOrEqualToColumn(Column column) {
            this.addCriterion("for_sale <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andForSaleIn(List<Integer> values) {
            this.addCriterion("for_sale in", values, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleNotIn(List<Integer> values) {
            this.addCriterion("for_sale not in", values, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleBetween(Integer value1, Integer value2) {
            this.addCriterion("for_sale between", value1, value2, "forSale");
            return (Criteria)this;
        }

        public Criteria andForSaleNotBetween(Integer value1, Integer value2) {
            this.addCriterion("for_sale not between", value1, value2, "forSale");
            return (Criteria)this;
        }

        public Criteria andShowPosIsNull() {
            this.addCriterion("show_pos is null");
            return (Criteria)this;
        }

        public Criteria andShowPosIsNotNull() {
            this.addCriterion("show_pos is not null");
            return (Criteria)this;
        }

        public Criteria andShowPosEqualTo(Integer value) {
            this.addCriterion("show_pos =", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosEqualToColumn(Column column) {
            this.addCriterion("show_pos = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosNotEqualTo(Integer value) {
            this.addCriterion("show_pos <>", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosNotEqualToColumn(Column column) {
            this.addCriterion("show_pos <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosGreaterThan(Integer value) {
            this.addCriterion("show_pos >", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosGreaterThanColumn(Column column) {
            this.addCriterion("show_pos > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("show_pos >=", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("show_pos >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosLessThan(Integer value) {
            this.addCriterion("show_pos <", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosLessThanColumn(Column column) {
            this.addCriterion("show_pos < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosLessThanOrEqualTo(Integer value) {
            this.addCriterion("show_pos <=", value, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosLessThanOrEqualToColumn(Column column) {
            this.addCriterion("show_pos <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowPosIn(List<Integer> values) {
            this.addCriterion("show_pos in", values, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosNotIn(List<Integer> values) {
            this.addCriterion("show_pos not in", values, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosBetween(Integer value1, Integer value2) {
            this.addCriterion("show_pos between", value1, value2, "showPos");
            return (Criteria)this;
        }

        public Criteria andShowPosNotBetween(Integer value1, Integer value2) {
            this.addCriterion("show_pos not between", value1, value2, "showPos");
            return (Criteria)this;
        }

        public Criteria andRposIsNull() {
            this.addCriterion("rpos is null");
            return (Criteria)this;
        }

        public Criteria andRposIsNotNull() {
            this.addCriterion("rpos is not null");
            return (Criteria)this;
        }

        public Criteria andRposEqualTo(Integer value) {
            this.addCriterion("rpos =", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposEqualToColumn(Column column) {
            this.addCriterion("rpos = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposNotEqualTo(Integer value) {
            this.addCriterion("rpos <>", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposNotEqualToColumn(Column column) {
            this.addCriterion("rpos <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposGreaterThan(Integer value) {
            this.addCriterion("rpos >", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposGreaterThanColumn(Column column) {
            this.addCriterion("rpos > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("rpos >=", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("rpos >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposLessThan(Integer value) {
            this.addCriterion("rpos <", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposLessThanColumn(Column column) {
            this.addCriterion("rpos < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposLessThanOrEqualTo(Integer value) {
            this.addCriterion("rpos <=", value, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposLessThanOrEqualToColumn(Column column) {
            this.addCriterion("rpos <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRposIn(List<Integer> values) {
            this.addCriterion("rpos in", values, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposNotIn(List<Integer> values) {
            this.addCriterion("rpos not in", values, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposBetween(Integer value1, Integer value2) {
            this.addCriterion("rpos between", value1, value2, "rpos");
            return (Criteria)this;
        }

        public Criteria andRposNotBetween(Integer value1, Integer value2) {
            this.addCriterion("rpos not between", value1, value2, "rpos");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaIsNull() {
            this.addCriterion("sale_quota is null");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaIsNotNull() {
            this.addCriterion("sale_quota is not null");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaEqualTo(Integer value) {
            this.addCriterion("sale_quota =", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaEqualToColumn(Column column) {
            this.addCriterion("sale_quota = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaNotEqualTo(Integer value) {
            this.addCriterion("sale_quota <>", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaNotEqualToColumn(Column column) {
            this.addCriterion("sale_quota <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaGreaterThan(Integer value) {
            this.addCriterion("sale_quota >", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaGreaterThanColumn(Column column) {
            this.addCriterion("sale_quota > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sale_quota >=", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("sale_quota >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaLessThan(Integer value) {
            this.addCriterion("sale_quota <", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaLessThanColumn(Column column) {
            this.addCriterion("sale_quota < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaLessThanOrEqualTo(Integer value) {
            this.addCriterion("sale_quota <=", value, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("sale_quota <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSaleQuotaIn(List<Integer> values) {
            this.addCriterion("sale_quota in", values, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaNotIn(List<Integer> values) {
            this.addCriterion("sale_quota not in", values, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaBetween(Integer value1, Integer value2) {
            this.addCriterion("sale_quota between", value1, value2, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andSaleQuotaNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sale_quota not between", value1, value2, "saleQuota");
            return (Criteria)this;
        }

        public Criteria andRecommendIsNull() {
            this.addCriterion("recommend is null");
            return (Criteria)this;
        }

        public Criteria andRecommendIsNotNull() {
            this.addCriterion("recommend is not null");
            return (Criteria)this;
        }

        public Criteria andRecommendEqualTo(Integer value) {
            this.addCriterion("recommend =", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendEqualToColumn(Column column) {
            this.addCriterion("recommend = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendNotEqualTo(Integer value) {
            this.addCriterion("recommend <>", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendNotEqualToColumn(Column column) {
            this.addCriterion("recommend <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendGreaterThan(Integer value) {
            this.addCriterion("recommend >", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendGreaterThanColumn(Column column) {
            this.addCriterion("recommend > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("recommend >=", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("recommend >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendLessThan(Integer value) {
            this.addCriterion("recommend <", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendLessThanColumn(Column column) {
            this.addCriterion("recommend < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Integer value) {
            this.addCriterion("recommend <=", value, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendLessThanOrEqualToColumn(Column column) {
            this.addCriterion("recommend <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRecommendIn(List<Integer> values) {
            this.addCriterion("recommend in", values, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendNotIn(List<Integer> values) {
            this.addCriterion("recommend not in", values, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria)this;
        }

        public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria)this;
        }

        public Criteria andCoinIsNull() {
            this.addCriterion("coin is null");
            return (Criteria)this;
        }

        public Criteria andCoinIsNotNull() {
            this.addCriterion("coin is not null");
            return (Criteria)this;
        }

        public Criteria andCoinEqualTo(Integer value) {
            this.addCriterion("coin =", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinEqualToColumn(Column column) {
            this.addCriterion("coin = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinNotEqualTo(Integer value) {
            this.addCriterion("coin <>", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinNotEqualToColumn(Column column) {
            this.addCriterion("coin <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinGreaterThan(Integer value) {
            this.addCriterion("coin >", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinGreaterThanColumn(Column column) {
            this.addCriterion("coin > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("coin >=", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("coin >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinLessThan(Integer value) {
            this.addCriterion("coin <", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinLessThanColumn(Column column) {
            this.addCriterion("coin < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinLessThanOrEqualTo(Integer value) {
            this.addCriterion("coin <=", value, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinLessThanOrEqualToColumn(Column column) {
            this.addCriterion("coin <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCoinIn(List<Integer> values) {
            this.addCriterion("coin in", values, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinNotIn(List<Integer> values) {
            this.addCriterion("coin not in", values, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinBetween(Integer value1, Integer value2) {
            this.addCriterion("coin between", value1, value2, "coin");
            return (Criteria)this;
        }

        public Criteria andCoinNotBetween(Integer value1, Integer value2) {
            this.addCriterion("coin not between", value1, value2, "coin");
            return (Criteria)this;
        }

        public Criteria andDiscountIsNull() {
            this.addCriterion("discount is null");
            return (Criteria)this;
        }

        public Criteria andDiscountIsNotNull() {
            this.addCriterion("discount is not null");
            return (Criteria)this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            this.addCriterion("discount =", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountEqualToColumn(Column column) {
            this.addCriterion("discount = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            this.addCriterion("discount <>", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountNotEqualToColumn(Column column) {
            this.addCriterion("discount <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            this.addCriterion("discount >", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountGreaterThanColumn(Column column) {
            this.addCriterion("discount > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("discount >=", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("discount >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            this.addCriterion("discount <", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountLessThanColumn(Column column) {
            this.addCriterion("discount < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            this.addCriterion("discount <=", value, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountLessThanOrEqualToColumn(Column column) {
            this.addCriterion("discount <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            this.addCriterion("discount in", values, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            this.addCriterion("discount not in", values, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            this.addCriterion("discount between", value1, value2, "discount");
            return (Criteria)this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            this.addCriterion("discount not between", value1, value2, "discount");
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

        public Criteria andQuotaLimitIsNull() {
            this.addCriterion("quota_limit is null");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitIsNotNull() {
            this.addCriterion("quota_limit is not null");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitEqualTo(Integer value) {
            this.addCriterion("quota_limit =", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitEqualToColumn(Column column) {
            this.addCriterion("quota_limit = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitNotEqualTo(Integer value) {
            this.addCriterion("quota_limit <>", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitNotEqualToColumn(Column column) {
            this.addCriterion("quota_limit <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitGreaterThan(Integer value) {
            this.addCriterion("quota_limit >", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitGreaterThanColumn(Column column) {
            this.addCriterion("quota_limit > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("quota_limit >=", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("quota_limit >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitLessThan(Integer value) {
            this.addCriterion("quota_limit <", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitLessThanColumn(Column column) {
            this.addCriterion("quota_limit < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitLessThanOrEqualTo(Integer value) {
            this.addCriterion("quota_limit <=", value, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitLessThanOrEqualToColumn(Column column) {
            this.addCriterion("quota_limit <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQuotaLimitIn(List<Integer> values) {
            this.addCriterion("quota_limit in", values, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitNotIn(List<Integer> values) {
            this.addCriterion("quota_limit not in", values, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitBetween(Integer value1, Integer value2) {
            this.addCriterion("quota_limit between", value1, value2, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andQuotaLimitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("quota_limit not between", value1, value2, "quotaLimit");
            return (Criteria)this;
        }

        public Criteria andMustVipIsNull() {
            this.addCriterion("must_vip is null");
            return (Criteria)this;
        }

        public Criteria andMustVipIsNotNull() {
            this.addCriterion("must_vip is not null");
            return (Criteria)this;
        }

        public Criteria andMustVipEqualTo(Integer value) {
            this.addCriterion("must_vip =", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipEqualToColumn(Column column) {
            this.addCriterion("must_vip = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipNotEqualTo(Integer value) {
            this.addCriterion("must_vip <>", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipNotEqualToColumn(Column column) {
            this.addCriterion("must_vip <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipGreaterThan(Integer value) {
            this.addCriterion("must_vip >", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipGreaterThanColumn(Column column) {
            this.addCriterion("must_vip > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("must_vip >=", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("must_vip >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipLessThan(Integer value) {
            this.addCriterion("must_vip <", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipLessThanColumn(Column column) {
            this.addCriterion("must_vip < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipLessThanOrEqualTo(Integer value) {
            this.addCriterion("must_vip <=", value, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipLessThanOrEqualToColumn(Column column) {
            this.addCriterion("must_vip <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMustVipIn(List<Integer> values) {
            this.addCriterion("must_vip in", values, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipNotIn(List<Integer> values) {
            this.addCriterion("must_vip not in", values, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipBetween(Integer value1, Integer value2) {
            this.addCriterion("must_vip between", value1, value2, "mustVip");
            return (Criteria)this;
        }

        public Criteria andMustVipNotBetween(Integer value1, Integer value2) {
            this.addCriterion("must_vip not between", value1, value2, "mustVip");
            return (Criteria)this;
        }

        public Criteria andIsGiftIsNull() {
            this.addCriterion("is_gift is null");
            return (Criteria)this;
        }

        public Criteria andIsGiftIsNotNull() {
            this.addCriterion("is_gift is not null");
            return (Criteria)this;
        }

        public Criteria andIsGiftEqualTo(Integer value) {
            this.addCriterion("is_gift =", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftEqualToColumn(Column column) {
            this.addCriterion("is_gift = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftNotEqualTo(Integer value) {
            this.addCriterion("is_gift <>", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftNotEqualToColumn(Column column) {
            this.addCriterion("is_gift <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftGreaterThan(Integer value) {
            this.addCriterion("is_gift >", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftGreaterThanColumn(Column column) {
            this.addCriterion("is_gift > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_gift >=", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("is_gift >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftLessThan(Integer value) {
            this.addCriterion("is_gift <", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftLessThanColumn(Column column) {
            this.addCriterion("is_gift < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_gift <=", value, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftLessThanOrEqualToColumn(Column column) {
            this.addCriterion("is_gift <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsGiftIn(List<Integer> values) {
            this.addCriterion("is_gift in", values, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftNotIn(List<Integer> values) {
            this.addCriterion("is_gift not in", values, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftBetween(Integer value1, Integer value2) {
            this.addCriterion("is_gift between", value1, value2, "isGift");
            return (Criteria)this;
        }

        public Criteria andIsGiftNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_gift not between", value1, value2, "isGift");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeIsNull() {
            this.addCriterion("follow_pet_type is null");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeIsNotNull() {
            this.addCriterion("follow_pet_type is not null");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeEqualTo(Integer value) {
            this.addCriterion("follow_pet_type =", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeEqualToColumn(Column column) {
            this.addCriterion("follow_pet_type = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeNotEqualTo(Integer value) {
            this.addCriterion("follow_pet_type <>", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeNotEqualToColumn(Column column) {
            this.addCriterion("follow_pet_type <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeGreaterThan(Integer value) {
            this.addCriterion("follow_pet_type >", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeGreaterThanColumn(Column column) {
            this.addCriterion("follow_pet_type > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("follow_pet_type >=", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("follow_pet_type >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeLessThan(Integer value) {
            this.addCriterion("follow_pet_type <", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeLessThanColumn(Column column) {
            this.addCriterion("follow_pet_type < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("follow_pet_type <=", value, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("follow_pet_type <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeIn(List<Integer> values) {
            this.addCriterion("follow_pet_type in", values, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeNotIn(List<Integer> values) {
            this.addCriterion("follow_pet_type not in", values, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("follow_pet_type between", value1, value2, "followPetType");
            return (Criteria)this;
        }

        public Criteria andFollowPetTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("follow_pet_type not between", value1, value2, "followPetType");
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
        private StoreGoodsExample example;

        protected Criteria(StoreGoodsExample example) {
            this.example = example;
        }

        public StoreGoodsExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria.ICriteriaAdd add) {
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
