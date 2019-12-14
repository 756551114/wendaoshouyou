//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.NpcPoint.*;

public class NpcPointExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria> oredCriteria = new ArrayList();

    public NpcPointExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public NpcPointExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public NpcPointExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria newAndCreateCriteria() {
        NpcPointExample example = new NpcPointExample();
        return example.createCriteria();
    }

    public NpcPointExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcPointExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public NpcPointExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcPointExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.NpcPointExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(NpcPointExample example);
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

        public Criteria andMapnameIsNull() {
            this.addCriterion("mapname is null");
            return (Criteria)this;
        }

        public Criteria andMapnameIsNotNull() {
            this.addCriterion("mapname is not null");
            return (Criteria)this;
        }

        public Criteria andMapnameEqualTo(String value) {
            this.addCriterion("mapname =", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameEqualToColumn(Column column) {
            this.addCriterion("mapname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameNotEqualTo(String value) {
            this.addCriterion("mapname <>", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameNotEqualToColumn(Column column) {
            this.addCriterion("mapname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameGreaterThan(String value) {
            this.addCriterion("mapname >", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameGreaterThanColumn(Column column) {
            this.addCriterion("mapname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("mapname >=", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("mapname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameLessThan(String value) {
            this.addCriterion("mapname <", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameLessThanColumn(Column column) {
            this.addCriterion("mapname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameLessThanOrEqualTo(String value) {
            this.addCriterion("mapname <=", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("mapname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMapnameLike(String value) {
            this.addCriterion("mapname like", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameNotLike(String value) {
            this.addCriterion("mapname not like", value, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameIn(List<String> values) {
            this.addCriterion("mapname in", values, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameNotIn(List<String> values) {
            this.addCriterion("mapname not in", values, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameBetween(String value1, String value2) {
            this.addCriterion("mapname between", value1, value2, "mapname");
            return (Criteria)this;
        }

        public Criteria andMapnameNotBetween(String value1, String value2) {
            this.addCriterion("mapname not between", value1, value2, "mapname");
            return (Criteria)this;
        }

        public Criteria andDoornameIsNull() {
            this.addCriterion("doorname is null");
            return (Criteria)this;
        }

        public Criteria andDoornameIsNotNull() {
            this.addCriterion("doorname is not null");
            return (Criteria)this;
        }

        public Criteria andDoornameEqualTo(String value) {
            this.addCriterion("doorname =", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameEqualToColumn(Column column) {
            this.addCriterion("doorname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameNotEqualTo(String value) {
            this.addCriterion("doorname <>", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameNotEqualToColumn(Column column) {
            this.addCriterion("doorname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameGreaterThan(String value) {
            this.addCriterion("doorname >", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameGreaterThanColumn(Column column) {
            this.addCriterion("doorname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameGreaterThanOrEqualTo(String value) {
            this.addCriterion("doorname >=", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("doorname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameLessThan(String value) {
            this.addCriterion("doorname <", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameLessThanColumn(Column column) {
            this.addCriterion("doorname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameLessThanOrEqualTo(String value) {
            this.addCriterion("doorname <=", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("doorname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDoornameLike(String value) {
            this.addCriterion("doorname like", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameNotLike(String value) {
            this.addCriterion("doorname not like", value, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameIn(List<String> values) {
            this.addCriterion("doorname in", values, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameNotIn(List<String> values) {
            this.addCriterion("doorname not in", values, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameBetween(String value1, String value2) {
            this.addCriterion("doorname between", value1, value2, "doorname");
            return (Criteria)this;
        }

        public Criteria andDoornameNotBetween(String value1, String value2) {
            this.addCriterion("doorname not between", value1, value2, "doorname");
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

        public Criteria andZIsNull() {
            this.addCriterion("z is null");
            return (Criteria)this;
        }

        public Criteria andZIsNotNull() {
            this.addCriterion("z is not null");
            return (Criteria)this;
        }

        public Criteria andZEqualTo(Integer value) {
            this.addCriterion("z =", value, "z");
            return (Criteria)this;
        }

        public Criteria andZEqualToColumn(Column column) {
            this.addCriterion("z = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZNotEqualTo(Integer value) {
            this.addCriterion("z <>", value, "z");
            return (Criteria)this;
        }

        public Criteria andZNotEqualToColumn(Column column) {
            this.addCriterion("z <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZGreaterThan(Integer value) {
            this.addCriterion("z >", value, "z");
            return (Criteria)this;
        }

        public Criteria andZGreaterThanColumn(Column column) {
            this.addCriterion("z > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("z >=", value, "z");
            return (Criteria)this;
        }

        public Criteria andZGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("z >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZLessThan(Integer value) {
            this.addCriterion("z <", value, "z");
            return (Criteria)this;
        }

        public Criteria andZLessThanColumn(Column column) {
            this.addCriterion("z < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZLessThanOrEqualTo(Integer value) {
            this.addCriterion("z <=", value, "z");
            return (Criteria)this;
        }

        public Criteria andZLessThanOrEqualToColumn(Column column) {
            this.addCriterion("z <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZIn(List<Integer> values) {
            this.addCriterion("z in", values, "z");
            return (Criteria)this;
        }

        public Criteria andZNotIn(List<Integer> values) {
            this.addCriterion("z not in", values, "z");
            return (Criteria)this;
        }

        public Criteria andZBetween(Integer value1, Integer value2) {
            this.addCriterion("z between", value1, value2, "z");
            return (Criteria)this;
        }

        public Criteria andZNotBetween(Integer value1, Integer value2) {
            this.addCriterion("z not between", value1, value2, "z");
            return (Criteria)this;
        }

        public Criteria andInxIsNull() {
            this.addCriterion("inx is null");
            return (Criteria)this;
        }

        public Criteria andInxIsNotNull() {
            this.addCriterion("inx is not null");
            return (Criteria)this;
        }

        public Criteria andInxEqualTo(Integer value) {
            this.addCriterion("inx =", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxEqualToColumn(Column column) {
            this.addCriterion("inx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxNotEqualTo(Integer value) {
            this.addCriterion("inx <>", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxNotEqualToColumn(Column column) {
            this.addCriterion("inx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxGreaterThan(Integer value) {
            this.addCriterion("inx >", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxGreaterThanColumn(Column column) {
            this.addCriterion("inx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("inx >=", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("inx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxLessThan(Integer value) {
            this.addCriterion("inx <", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxLessThanColumn(Column column) {
            this.addCriterion("inx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxLessThanOrEqualTo(Integer value) {
            this.addCriterion("inx <=", value, "inx");
            return (Criteria)this;
        }

        public Criteria andInxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("inx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInxIn(List<Integer> values) {
            this.addCriterion("inx in", values, "inx");
            return (Criteria)this;
        }

        public Criteria andInxNotIn(List<Integer> values) {
            this.addCriterion("inx not in", values, "inx");
            return (Criteria)this;
        }

        public Criteria andInxBetween(Integer value1, Integer value2) {
            this.addCriterion("inx between", value1, value2, "inx");
            return (Criteria)this;
        }

        public Criteria andInxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("inx not between", value1, value2, "inx");
            return (Criteria)this;
        }

        public Criteria andInyIsNull() {
            this.addCriterion("iny is null");
            return (Criteria)this;
        }

        public Criteria andInyIsNotNull() {
            this.addCriterion("iny is not null");
            return (Criteria)this;
        }

        public Criteria andInyEqualTo(Integer value) {
            this.addCriterion("iny =", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyEqualToColumn(Column column) {
            this.addCriterion("iny = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyNotEqualTo(Integer value) {
            this.addCriterion("iny <>", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyNotEqualToColumn(Column column) {
            this.addCriterion("iny <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyGreaterThan(Integer value) {
            this.addCriterion("iny >", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyGreaterThanColumn(Column column) {
            this.addCriterion("iny > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("iny >=", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("iny >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyLessThan(Integer value) {
            this.addCriterion("iny <", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyLessThanColumn(Column column) {
            this.addCriterion("iny < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyLessThanOrEqualTo(Integer value) {
            this.addCriterion("iny <=", value, "iny");
            return (Criteria)this;
        }

        public Criteria andInyLessThanOrEqualToColumn(Column column) {
            this.addCriterion("iny <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andInyIn(List<Integer> values) {
            this.addCriterion("iny in", values, "iny");
            return (Criteria)this;
        }

        public Criteria andInyNotIn(List<Integer> values) {
            this.addCriterion("iny not in", values, "iny");
            return (Criteria)this;
        }

        public Criteria andInyBetween(Integer value1, Integer value2) {
            this.addCriterion("iny between", value1, value2, "iny");
            return (Criteria)this;
        }

        public Criteria andInyNotBetween(Integer value1, Integer value2) {
            this.addCriterion("iny not between", value1, value2, "iny");
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
        private NpcPointExample example;

        protected Criteria(NpcPointExample example) {
            this.example = example;
        }

        public NpcPointExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, Criteria.ICriteriaAdd add) {
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
