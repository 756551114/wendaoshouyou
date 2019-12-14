//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Map.*;

public class MapExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.MapExample.Criteria> oredCriteria = new ArrayList();

    public MapExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.MapExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.MapExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.MapExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.MapExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MapExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public MapExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.MapExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.MapExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.MapExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.MapExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.MapExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.MapExample.Criteria newAndCreateCriteria() {
        MapExample example = new MapExample();
        return example.createCriteria();
    }

    public MapExample when(boolean condition, org.linlinjava.litemall.db.domain.example.MapExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public MapExample when(boolean condition, org.linlinjava.litemall.db.domain.example.MapExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.MapExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }


    public interface IExampleWhen {
        void example(MapExample example);
    }


    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }




    public  static class Criterion {
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

        public Criteria andMapIdIsNull() {
            this.addCriterion("map_id is null");
            return (Criteria)this;
        }

        public Criteria andMapIdIsNotNull() {
            this.addCriterion("map_id is not null");
            return (Criteria)this;
        }

        public Criteria andMapIdEqualTo(Integer value) {
            this.addCriterion("map_id =", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdEqualToColumn(Column column) {
            this.addCriterion("map_id = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdNotEqualTo(Integer value) {
            this.addCriterion("map_id <>", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdNotEqualToColumn(Column column) {
            this.addCriterion("map_id <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdGreaterThan(Integer value) {
            this.addCriterion("map_id >", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdGreaterThanColumn(Column column) {
            this.addCriterion("map_id > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("map_id >=", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("map_id >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdLessThan(Integer value) {
            this.addCriterion("map_id <", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdLessThanColumn(Column column) {
            this.addCriterion("map_id < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("map_id <=", value, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("map_id <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapIdIn(List<Integer> values) {
            this.addCriterion("map_id in", values, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdNotIn(List<Integer> values) {
            this.addCriterion("map_id not in", values, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdBetween(Integer value1, Integer value2) {
            this.addCriterion("map_id between", value1, value2, "mapId");
            return (Criteria)this;
        }

        public Criteria andMapIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("map_id not between", value1, value2, "mapId");
            return (Criteria)this;
        }

        public Criteria andXIsNull() {
            this.addCriterion("x is null");
            return (Criteria)this;
        }

        public Criteria andXIsNotNull() {
            this.addCriterion("x is not null");
            return (Criteria)this;
        }

        public Criteria andXEqualTo(Integer value) {
            this.addCriterion("x =", value, "x");
            return (Criteria)this;
        }

        public Criteria andXEqualToColumn(Column column) {
            this.addCriterion("x = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXNotEqualTo(Integer value) {
            this.addCriterion("x <>", value, "x");
            return (Criteria)this;
        }

        public Criteria andXNotEqualToColumn(Column column) {
            this.addCriterion("x <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXGreaterThan(Integer value) {
            this.addCriterion("x >", value, "x");
            return (Criteria)this;
        }

        public Criteria andXGreaterThanColumn(Column column) {
            this.addCriterion("x > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("x >=", value, "x");
            return (Criteria)this;
        }

        public Criteria andXGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("x >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXLessThan(Integer value) {
            this.addCriterion("x <", value, "x");
            return (Criteria)this;
        }

        public Criteria andXLessThanColumn(Column column) {
            this.addCriterion("x < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXLessThanOrEqualTo(Integer value) {
            this.addCriterion("x <=", value, "x");
            return (Criteria)this;
        }

        public Criteria andXLessThanOrEqualToColumn(Column column) {
            this.addCriterion("x <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andXIn(List<Integer> values) {
            this.addCriterion("x in", values, "x");
            return (Criteria)this;
        }

        public Criteria andXNotIn(List<Integer> values) {
            this.addCriterion("x not in", values, "x");
            return (Criteria)this;
        }

        public Criteria andXBetween(Integer value1, Integer value2) {
            this.addCriterion("x between", value1, value2, "x");
            return (Criteria)this;
        }

        public Criteria andXNotBetween(Integer value1, Integer value2) {
            this.addCriterion("x not between", value1, value2, "x");
            return (Criteria)this;
        }

        public Criteria andYIsNull() {
            this.addCriterion("y is null");
            return (Criteria)this;
        }

        public Criteria andYIsNotNull() {
            this.addCriterion("y is not null");
            return (Criteria)this;
        }

        public Criteria andYEqualTo(Integer value) {
            this.addCriterion("y =", value, "y");
            return (Criteria)this;
        }

        public Criteria andYEqualToColumn(Column column) {
            this.addCriterion("y = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYNotEqualTo(Integer value) {
            this.addCriterion("y <>", value, "y");
            return (Criteria)this;
        }

        public Criteria andYNotEqualToColumn(Column column) {
            this.addCriterion("y <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYGreaterThan(Integer value) {
            this.addCriterion("y >", value, "y");
            return (Criteria)this;
        }

        public Criteria andYGreaterThanColumn(Column column) {
            this.addCriterion("y > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("y >=", value, "y");
            return (Criteria)this;
        }

        public Criteria andYGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("y >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYLessThan(Integer value) {
            this.addCriterion("y <", value, "y");
            return (Criteria)this;
        }

        public Criteria andYLessThanColumn(Column column) {
            this.addCriterion("y < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYLessThanOrEqualTo(Integer value) {
            this.addCriterion("y <=", value, "y");
            return (Criteria)this;
        }

        public Criteria andYLessThanOrEqualToColumn(Column column) {
            this.addCriterion("y <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYIn(List<Integer> values) {
            this.addCriterion("y in", values, "y");
            return (Criteria)this;
        }

        public Criteria andYNotIn(List<Integer> values) {
            this.addCriterion("y not in", values, "y");
            return (Criteria)this;
        }

        public Criteria andYBetween(Integer value1, Integer value2) {
            this.addCriterion("y between", value1, value2, "y");
            return (Criteria)this;
        }

        public Criteria andYNotBetween(Integer value1, Integer value2) {
            this.addCriterion("y not between", value1, value2, "y");
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

        public Criteria andIconEqualTo(String value) {
            this.addCriterion("icon =", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconEqualToColumn(Column column) {
            this.addCriterion("icon = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconNotEqualTo(String value) {
            this.addCriterion("icon <>", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotEqualToColumn(Column column) {
            this.addCriterion("icon <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThan(String value) {
            this.addCriterion("icon >", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanColumn(Column column) {
            this.addCriterion("icon > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            this.addCriterion("icon >=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("icon >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThan(String value) {
            this.addCriterion("icon <", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanColumn(Column column) {
            this.addCriterion("icon < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            this.addCriterion("icon <=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualToColumn(Column column) {
            this.addCriterion("icon <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLike(String value) {
            this.addCriterion("icon like", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotLike(String value) {
            this.addCriterion("icon not like", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconIn(List<String> values) {
            this.addCriterion("icon in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotIn(List<String> values) {
            this.addCriterion("icon not in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            this.addCriterion("icon between", value1, value2, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            this.addCriterion("icon not between", value1, value2, "icon");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelIsNull() {
            this.addCriterion("monster_level is null");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelIsNotNull() {
            this.addCriterion("monster_level is not null");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelEqualTo(Integer value) {
            this.addCriterion("monster_level =", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelEqualToColumn(Column column) {
            this.addCriterion("monster_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelNotEqualTo(Integer value) {
            this.addCriterion("monster_level <>", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelNotEqualToColumn(Column column) {
            this.addCriterion("monster_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelGreaterThan(Integer value) {
            this.addCriterion("monster_level >", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelGreaterThanColumn(Column column) {
            this.addCriterion("monster_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("monster_level >=", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("monster_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelLessThan(Integer value) {
            this.addCriterion("monster_level <", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelLessThanColumn(Column column) {
            this.addCriterion("monster_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("monster_level <=", value, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("monster_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMonsterLevelIn(List<Integer> values) {
            this.addCriterion("monster_level in", values, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelNotIn(List<Integer> values) {
            this.addCriterion("monster_level not in", values, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("monster_level between", value1, value2, "monsterLevel");
            return (Criteria)this;
        }

        public Criteria andMonsterLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("monster_level not between", value1, value2, "monsterLevel");
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
        private MapExample example;

        protected Criteria(MapExample example) {
            this.example = example;
        }

        public MapExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.MapExample.Criteria.ICriteriaAdd add) {
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
