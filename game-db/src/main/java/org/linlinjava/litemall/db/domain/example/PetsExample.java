//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Pets.*;

public class PetsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.PetsExample.Criteria> oredCriteria = new ArrayList();

    public PetsExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.PetsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.PetsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.PetsExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.PetsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public PetsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PetsExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.PetsExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.PetsExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.PetsExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.PetsExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.PetsExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.PetsExample.Criteria newAndCreateCriteria() {
        PetsExample example = new PetsExample();
        return example.createCriteria();
    }

    public PetsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PetsExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public PetsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PetsExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.PetsExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(PetsExample example);
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

        public Criteria andOwneridIsNull() {
            this.addCriterion("ownerid is null");
            return (Criteria)this;
        }

        public Criteria andOwneridIsNotNull() {
            this.addCriterion("ownerid is not null");
            return (Criteria)this;
        }

        public Criteria andOwneridEqualTo(String value) {
            this.addCriterion("ownerid =", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridEqualToColumn(Column column) {
            this.addCriterion("ownerid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridNotEqualTo(String value) {
            this.addCriterion("ownerid <>", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotEqualToColumn(Column column) {
            this.addCriterion("ownerid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThan(String value) {
            this.addCriterion("ownerid >", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanColumn(Column column) {
            this.addCriterion("ownerid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(String value) {
            this.addCriterion("ownerid >=", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("ownerid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLessThan(String value) {
            this.addCriterion("ownerid <", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanColumn(Column column) {
            this.addCriterion("ownerid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanOrEqualTo(String value) {
            this.addCriterion("ownerid <=", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridLessThanOrEqualToColumn(Column column) {
            this.addCriterion("ownerid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andOwneridLike(String value) {
            this.addCriterion("ownerid like", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotLike(String value) {
            this.addCriterion("ownerid not like", value, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridIn(List<String> values) {
            this.addCriterion("ownerid in", values, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotIn(List<String> values) {
            this.addCriterion("ownerid not in", values, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridBetween(String value1, String value2) {
            this.addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria)this;
        }

        public Criteria andOwneridNotBetween(String value1, String value2) {
            this.addCriterion("ownerid not between", value1, value2, "ownerid");
            return (Criteria)this;
        }

        public Criteria andPetidIsNull() {
            this.addCriterion("petid is null");
            return (Criteria)this;
        }

        public Criteria andPetidIsNotNull() {
            this.addCriterion("petid is not null");
            return (Criteria)this;
        }

        public Criteria andPetidEqualTo(String value) {
            this.addCriterion("petid =", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidEqualToColumn(Column column) {
            this.addCriterion("petid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidNotEqualTo(String value) {
            this.addCriterion("petid <>", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidNotEqualToColumn(Column column) {
            this.addCriterion("petid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidGreaterThan(String value) {
            this.addCriterion("petid >", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidGreaterThanColumn(Column column) {
            this.addCriterion("petid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidGreaterThanOrEqualTo(String value) {
            this.addCriterion("petid >=", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("petid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidLessThan(String value) {
            this.addCriterion("petid <", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidLessThanColumn(Column column) {
            this.addCriterion("petid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidLessThanOrEqualTo(String value) {
            this.addCriterion("petid <=", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("petid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPetidLike(String value) {
            this.addCriterion("petid like", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidNotLike(String value) {
            this.addCriterion("petid not like", value, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidIn(List<String> values) {
            this.addCriterion("petid in", values, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidNotIn(List<String> values) {
            this.addCriterion("petid not in", values, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidBetween(String value1, String value2) {
            this.addCriterion("petid between", value1, value2, "petid");
            return (Criteria)this;
        }

        public Criteria andPetidNotBetween(String value1, String value2) {
            this.addCriterion("petid not between", value1, value2, "petid");
            return (Criteria)this;
        }

        public Criteria andNicknameIsNull() {
            this.addCriterion("nickname is null");
            return (Criteria)this;
        }

        public Criteria andNicknameIsNotNull() {
            this.addCriterion("nickname is not null");
            return (Criteria)this;
        }

        public Criteria andNicknameEqualTo(String value) {
            this.addCriterion("nickname =", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameEqualToColumn(Column column) {
            this.addCriterion("nickname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            this.addCriterion("nickname <>", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameNotEqualToColumn(Column column) {
            this.addCriterion("nickname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            this.addCriterion("nickname >", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameGreaterThanColumn(Column column) {
            this.addCriterion("nickname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            this.addCriterion("nickname >=", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("nickname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameLessThan(String value) {
            this.addCriterion("nickname <", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameLessThanColumn(Column column) {
            this.addCriterion("nickname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            this.addCriterion("nickname <=", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("nickname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNicknameLike(String value) {
            this.addCriterion("nickname like", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameNotLike(String value) {
            this.addCriterion("nickname not like", value, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameIn(List<String> values) {
            this.addCriterion("nickname in", values, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            this.addCriterion("nickname not in", values, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            this.addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria)this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            this.addCriterion("nickname not between", value1, value2, "nickname");
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

        public Criteria andHorsetypeIsNull() {
            this.addCriterion("horsetype is null");
            return (Criteria)this;
        }

        public Criteria andHorsetypeIsNotNull() {
            this.addCriterion("horsetype is not null");
            return (Criteria)this;
        }

        public Criteria andHorsetypeEqualTo(Integer value) {
            this.addCriterion("horsetype =", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeEqualToColumn(Column column) {
            this.addCriterion("horsetype = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeNotEqualTo(Integer value) {
            this.addCriterion("horsetype <>", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeNotEqualToColumn(Column column) {
            this.addCriterion("horsetype <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeGreaterThan(Integer value) {
            this.addCriterion("horsetype >", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeGreaterThanColumn(Column column) {
            this.addCriterion("horsetype > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("horsetype >=", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("horsetype >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeLessThan(Integer value) {
            this.addCriterion("horsetype <", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeLessThanColumn(Column column) {
            this.addCriterion("horsetype < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("horsetype <=", value, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("horsetype <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andHorsetypeIn(List<Integer> values) {
            this.addCriterion("horsetype in", values, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeNotIn(List<Integer> values) {
            this.addCriterion("horsetype not in", values, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeBetween(Integer value1, Integer value2) {
            this.addCriterion("horsetype between", value1, value2, "horsetype");
            return (Criteria)this;
        }

        public Criteria andHorsetypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("horsetype not between", value1, value2, "horsetype");
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

        public Criteria andLiliangIsNull() {
            this.addCriterion("liliang is null");
            return (Criteria)this;
        }

        public Criteria andLiliangIsNotNull() {
            this.addCriterion("liliang is not null");
            return (Criteria)this;
        }

        public Criteria andLiliangEqualTo(Integer value) {
            this.addCriterion("liliang =", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangEqualToColumn(Column column) {
            this.addCriterion("liliang = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangNotEqualTo(Integer value) {
            this.addCriterion("liliang <>", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangNotEqualToColumn(Column column) {
            this.addCriterion("liliang <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangGreaterThan(Integer value) {
            this.addCriterion("liliang >", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangGreaterThanColumn(Column column) {
            this.addCriterion("liliang > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("liliang >=", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("liliang >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangLessThan(Integer value) {
            this.addCriterion("liliang <", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangLessThanColumn(Column column) {
            this.addCriterion("liliang < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangLessThanOrEqualTo(Integer value) {
            this.addCriterion("liliang <=", value, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangLessThanOrEqualToColumn(Column column) {
            this.addCriterion("liliang <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLiliangIn(List<Integer> values) {
            this.addCriterion("liliang in", values, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangNotIn(List<Integer> values) {
            this.addCriterion("liliang not in", values, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangBetween(Integer value1, Integer value2) {
            this.addCriterion("liliang between", value1, value2, "liliang");
            return (Criteria)this;
        }

        public Criteria andLiliangNotBetween(Integer value1, Integer value2) {
            this.addCriterion("liliang not between", value1, value2, "liliang");
            return (Criteria)this;
        }

        public Criteria andMinjieIsNull() {
            this.addCriterion("minjie is null");
            return (Criteria)this;
        }

        public Criteria andMinjieIsNotNull() {
            this.addCriterion("minjie is not null");
            return (Criteria)this;
        }

        public Criteria andMinjieEqualTo(Integer value) {
            this.addCriterion("minjie =", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieEqualToColumn(Column column) {
            this.addCriterion("minjie = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieNotEqualTo(Integer value) {
            this.addCriterion("minjie <>", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieNotEqualToColumn(Column column) {
            this.addCriterion("minjie <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieGreaterThan(Integer value) {
            this.addCriterion("minjie >", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieGreaterThanColumn(Column column) {
            this.addCriterion("minjie > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("minjie >=", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("minjie >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieLessThan(Integer value) {
            this.addCriterion("minjie <", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieLessThanColumn(Column column) {
            this.addCriterion("minjie < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieLessThanOrEqualTo(Integer value) {
            this.addCriterion("minjie <=", value, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieLessThanOrEqualToColumn(Column column) {
            this.addCriterion("minjie <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMinjieIn(List<Integer> values) {
            this.addCriterion("minjie in", values, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieNotIn(List<Integer> values) {
            this.addCriterion("minjie not in", values, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieBetween(Integer value1, Integer value2) {
            this.addCriterion("minjie between", value1, value2, "minjie");
            return (Criteria)this;
        }

        public Criteria andMinjieNotBetween(Integer value1, Integer value2) {
            this.addCriterion("minjie not between", value1, value2, "minjie");
            return (Criteria)this;
        }

        public Criteria andLingliIsNull() {
            this.addCriterion("lingli is null");
            return (Criteria)this;
        }

        public Criteria andLingliIsNotNull() {
            this.addCriterion("lingli is not null");
            return (Criteria)this;
        }

        public Criteria andLingliEqualTo(Integer value) {
            this.addCriterion("lingli =", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliEqualToColumn(Column column) {
            this.addCriterion("lingli = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliNotEqualTo(Integer value) {
            this.addCriterion("lingli <>", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliNotEqualToColumn(Column column) {
            this.addCriterion("lingli <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliGreaterThan(Integer value) {
            this.addCriterion("lingli >", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliGreaterThanColumn(Column column) {
            this.addCriterion("lingli > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("lingli >=", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("lingli >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliLessThan(Integer value) {
            this.addCriterion("lingli <", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliLessThanColumn(Column column) {
            this.addCriterion("lingli < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliLessThanOrEqualTo(Integer value) {
            this.addCriterion("lingli <=", value, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliLessThanOrEqualToColumn(Column column) {
            this.addCriterion("lingli <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLingliIn(List<Integer> values) {
            this.addCriterion("lingli in", values, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliNotIn(List<Integer> values) {
            this.addCriterion("lingli not in", values, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliBetween(Integer value1, Integer value2) {
            this.addCriterion("lingli between", value1, value2, "lingli");
            return (Criteria)this;
        }

        public Criteria andLingliNotBetween(Integer value1, Integer value2) {
            this.addCriterion("lingli not between", value1, value2, "lingli");
            return (Criteria)this;
        }

        public Criteria andTiliIsNull() {
            this.addCriterion("tili is null");
            return (Criteria)this;
        }

        public Criteria andTiliIsNotNull() {
            this.addCriterion("tili is not null");
            return (Criteria)this;
        }

        public Criteria andTiliEqualTo(Integer value) {
            this.addCriterion("tili =", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliEqualToColumn(Column column) {
            this.addCriterion("tili = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliNotEqualTo(Integer value) {
            this.addCriterion("tili <>", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliNotEqualToColumn(Column column) {
            this.addCriterion("tili <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliGreaterThan(Integer value) {
            this.addCriterion("tili >", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliGreaterThanColumn(Column column) {
            this.addCriterion("tili > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("tili >=", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("tili >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliLessThan(Integer value) {
            this.addCriterion("tili <", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliLessThanColumn(Column column) {
            this.addCriterion("tili < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliLessThanOrEqualTo(Integer value) {
            this.addCriterion("tili <=", value, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliLessThanOrEqualToColumn(Column column) {
            this.addCriterion("tili <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTiliIn(List<Integer> values) {
            this.addCriterion("tili in", values, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliNotIn(List<Integer> values) {
            this.addCriterion("tili not in", values, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliBetween(Integer value1, Integer value2) {
            this.addCriterion("tili between", value1, value2, "tili");
            return (Criteria)this;
        }

        public Criteria andTiliNotBetween(Integer value1, Integer value2) {
            this.addCriterion("tili not between", value1, value2, "tili");
            return (Criteria)this;
        }

        public Criteria andDianhualxIsNull() {
            this.addCriterion("dianhualx is null");
            return (Criteria)this;
        }

        public Criteria andDianhualxIsNotNull() {
            this.addCriterion("dianhualx is not null");
            return (Criteria)this;
        }

        public Criteria andDianhualxEqualTo(Integer value) {
            this.addCriterion("dianhualx =", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxEqualToColumn(Column column) {
            this.addCriterion("dianhualx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxNotEqualTo(Integer value) {
            this.addCriterion("dianhualx <>", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxNotEqualToColumn(Column column) {
            this.addCriterion("dianhualx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxGreaterThan(Integer value) {
            this.addCriterion("dianhualx >", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxGreaterThanColumn(Column column) {
            this.addCriterion("dianhualx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("dianhualx >=", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhualx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxLessThan(Integer value) {
            this.addCriterion("dianhualx <", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxLessThanColumn(Column column) {
            this.addCriterion("dianhualx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxLessThanOrEqualTo(Integer value) {
            this.addCriterion("dianhualx <=", value, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhualx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhualxIn(List<Integer> values) {
            this.addCriterion("dianhualx in", values, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxNotIn(List<Integer> values) {
            this.addCriterion("dianhualx not in", values, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhualx between", value1, value2, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhualxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhualx not between", value1, value2, "dianhualx");
            return (Criteria)this;
        }

        public Criteria andDianhuazdIsNull() {
            this.addCriterion("dianhuazd is null");
            return (Criteria)this;
        }

        public Criteria andDianhuazdIsNotNull() {
            this.addCriterion("dianhuazd is not null");
            return (Criteria)this;
        }

        public Criteria andDianhuazdEqualTo(Integer value) {
            this.addCriterion("dianhuazd =", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdEqualToColumn(Column column) {
            this.addCriterion("dianhuazd = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdNotEqualTo(Integer value) {
            this.addCriterion("dianhuazd <>", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdNotEqualToColumn(Column column) {
            this.addCriterion("dianhuazd <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdGreaterThan(Integer value) {
            this.addCriterion("dianhuazd >", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdGreaterThanColumn(Column column) {
            this.addCriterion("dianhuazd > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("dianhuazd >=", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhuazd >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdLessThan(Integer value) {
            this.addCriterion("dianhuazd <", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdLessThanColumn(Column column) {
            this.addCriterion("dianhuazd < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdLessThanOrEqualTo(Integer value) {
            this.addCriterion("dianhuazd <=", value, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhuazd <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazdIn(List<Integer> values) {
            this.addCriterion("dianhuazd in", values, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdNotIn(List<Integer> values) {
            this.addCriterion("dianhuazd not in", values, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhuazd between", value1, value2, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhuazd not between", value1, value2, "dianhuazd");
            return (Criteria)this;
        }

        public Criteria andDianhuazxIsNull() {
            this.addCriterion("dianhuazx is null");
            return (Criteria)this;
        }

        public Criteria andDianhuazxIsNotNull() {
            this.addCriterion("dianhuazx is not null");
            return (Criteria)this;
        }

        public Criteria andDianhuazxEqualTo(Integer value) {
            this.addCriterion("dianhuazx =", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxEqualToColumn(Column column) {
            this.addCriterion("dianhuazx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxNotEqualTo(Integer value) {
            this.addCriterion("dianhuazx <>", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxNotEqualToColumn(Column column) {
            this.addCriterion("dianhuazx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxGreaterThan(Integer value) {
            this.addCriterion("dianhuazx >", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxGreaterThanColumn(Column column) {
            this.addCriterion("dianhuazx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("dianhuazx >=", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhuazx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxLessThan(Integer value) {
            this.addCriterion("dianhuazx <", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxLessThanColumn(Column column) {
            this.addCriterion("dianhuazx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxLessThanOrEqualTo(Integer value) {
            this.addCriterion("dianhuazx <=", value, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("dianhuazx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andDianhuazxIn(List<Integer> values) {
            this.addCriterion("dianhuazx in", values, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxNotIn(List<Integer> values) {
            this.addCriterion("dianhuazx not in", values, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhuazx between", value1, value2, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andDianhuazxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("dianhuazx not between", value1, value2, "dianhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhualxIsNull() {
            this.addCriterion("yuhualx is null");
            return (Criteria)this;
        }

        public Criteria andYuhualxIsNotNull() {
            this.addCriterion("yuhualx is not null");
            return (Criteria)this;
        }

        public Criteria andYuhualxEqualTo(Integer value) {
            this.addCriterion("yuhualx =", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxEqualToColumn(Column column) {
            this.addCriterion("yuhualx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxNotEqualTo(Integer value) {
            this.addCriterion("yuhualx <>", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxNotEqualToColumn(Column column) {
            this.addCriterion("yuhualx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxGreaterThan(Integer value) {
            this.addCriterion("yuhualx >", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxGreaterThanColumn(Column column) {
            this.addCriterion("yuhualx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("yuhualx >=", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhualx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxLessThan(Integer value) {
            this.addCriterion("yuhualx <", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxLessThanColumn(Column column) {
            this.addCriterion("yuhualx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxLessThanOrEqualTo(Integer value) {
            this.addCriterion("yuhualx <=", value, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhualx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhualxIn(List<Integer> values) {
            this.addCriterion("yuhualx in", values, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxNotIn(List<Integer> values) {
            this.addCriterion("yuhualx not in", values, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhualx between", value1, value2, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhualxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhualx not between", value1, value2, "yuhualx");
            return (Criteria)this;
        }

        public Criteria andYuhuazdIsNull() {
            this.addCriterion("yuhuazd is null");
            return (Criteria)this;
        }

        public Criteria andYuhuazdIsNotNull() {
            this.addCriterion("yuhuazd is not null");
            return (Criteria)this;
        }

        public Criteria andYuhuazdEqualTo(Integer value) {
            this.addCriterion("yuhuazd =", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdEqualToColumn(Column column) {
            this.addCriterion("yuhuazd = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdNotEqualTo(Integer value) {
            this.addCriterion("yuhuazd <>", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdNotEqualToColumn(Column column) {
            this.addCriterion("yuhuazd <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdGreaterThan(Integer value) {
            this.addCriterion("yuhuazd >", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdGreaterThanColumn(Column column) {
            this.addCriterion("yuhuazd > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("yuhuazd >=", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhuazd >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdLessThan(Integer value) {
            this.addCriterion("yuhuazd <", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdLessThanColumn(Column column) {
            this.addCriterion("yuhuazd < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdLessThanOrEqualTo(Integer value) {
            this.addCriterion("yuhuazd <=", value, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhuazd <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazdIn(List<Integer> values) {
            this.addCriterion("yuhuazd in", values, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdNotIn(List<Integer> values) {
            this.addCriterion("yuhuazd not in", values, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhuazd between", value1, value2, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhuazd not between", value1, value2, "yuhuazd");
            return (Criteria)this;
        }

        public Criteria andYuhuazxIsNull() {
            this.addCriterion("yuhuazx is null");
            return (Criteria)this;
        }

        public Criteria andYuhuazxIsNotNull() {
            this.addCriterion("yuhuazx is not null");
            return (Criteria)this;
        }

        public Criteria andYuhuazxEqualTo(Integer value) {
            this.addCriterion("yuhuazx =", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxEqualToColumn(Column column) {
            this.addCriterion("yuhuazx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxNotEqualTo(Integer value) {
            this.addCriterion("yuhuazx <>", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxNotEqualToColumn(Column column) {
            this.addCriterion("yuhuazx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxGreaterThan(Integer value) {
            this.addCriterion("yuhuazx >", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxGreaterThanColumn(Column column) {
            this.addCriterion("yuhuazx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("yuhuazx >=", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhuazx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxLessThan(Integer value) {
            this.addCriterion("yuhuazx <", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxLessThanColumn(Column column) {
            this.addCriterion("yuhuazx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxLessThanOrEqualTo(Integer value) {
            this.addCriterion("yuhuazx <=", value, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("yuhuazx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuhuazxIn(List<Integer> values) {
            this.addCriterion("yuhuazx in", values, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxNotIn(List<Integer> values) {
            this.addCriterion("yuhuazx not in", values, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhuazx between", value1, value2, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andYuhuazxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("yuhuazx not between", value1, value2, "yuhuazx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxIsNull() {
            this.addCriterion("cwjyzx is null");
            return (Criteria)this;
        }

        public Criteria andCwjyzxIsNotNull() {
            this.addCriterion("cwjyzx is not null");
            return (Criteria)this;
        }

        public Criteria andCwjyzxEqualTo(Integer value) {
            this.addCriterion("cwjyzx =", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxEqualToColumn(Column column) {
            this.addCriterion("cwjyzx = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxNotEqualTo(Integer value) {
            this.addCriterion("cwjyzx <>", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxNotEqualToColumn(Column column) {
            this.addCriterion("cwjyzx <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxGreaterThan(Integer value) {
            this.addCriterion("cwjyzx >", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxGreaterThanColumn(Column column) {
            this.addCriterion("cwjyzx > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cwjyzx >=", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cwjyzx >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxLessThan(Integer value) {
            this.addCriterion("cwjyzx <", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxLessThanColumn(Column column) {
            this.addCriterion("cwjyzx < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxLessThanOrEqualTo(Integer value) {
            this.addCriterion("cwjyzx <=", value, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cwjyzx <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzxIn(List<Integer> values) {
            this.addCriterion("cwjyzx in", values, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxNotIn(List<Integer> values) {
            this.addCriterion("cwjyzx not in", values, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxBetween(Integer value1, Integer value2) {
            this.addCriterion("cwjyzx between", value1, value2, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzxNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cwjyzx not between", value1, value2, "cwjyzx");
            return (Criteria)this;
        }

        public Criteria andCwjyzdIsNull() {
            this.addCriterion("cwjyzd is null");
            return (Criteria)this;
        }

        public Criteria andCwjyzdIsNotNull() {
            this.addCriterion("cwjyzd is not null");
            return (Criteria)this;
        }

        public Criteria andCwjyzdEqualTo(Integer value) {
            this.addCriterion("cwjyzd =", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdEqualToColumn(Column column) {
            this.addCriterion("cwjyzd = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdNotEqualTo(Integer value) {
            this.addCriterion("cwjyzd <>", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdNotEqualToColumn(Column column) {
            this.addCriterion("cwjyzd <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdGreaterThan(Integer value) {
            this.addCriterion("cwjyzd >", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdGreaterThanColumn(Column column) {
            this.addCriterion("cwjyzd > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cwjyzd >=", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cwjyzd >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdLessThan(Integer value) {
            this.addCriterion("cwjyzd <", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdLessThanColumn(Column column) {
            this.addCriterion("cwjyzd < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdLessThanOrEqualTo(Integer value) {
            this.addCriterion("cwjyzd <=", value, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cwjyzd <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwjyzdIn(List<Integer> values) {
            this.addCriterion("cwjyzd in", values, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdNotIn(List<Integer> values) {
            this.addCriterion("cwjyzd not in", values, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdBetween(Integer value1, Integer value2) {
            this.addCriterion("cwjyzd between", value1, value2, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andCwjyzdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cwjyzd not between", value1, value2, "cwjyzd");
            return (Criteria)this;
        }

        public Criteria andFeishengIsNull() {
            this.addCriterion("feisheng is null");
            return (Criteria)this;
        }

        public Criteria andFeishengIsNotNull() {
            this.addCriterion("feisheng is not null");
            return (Criteria)this;
        }

        public Criteria andFeishengEqualTo(Integer value) {
            this.addCriterion("feisheng =", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengEqualToColumn(Column column) {
            this.addCriterion("feisheng = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengNotEqualTo(Integer value) {
            this.addCriterion("feisheng <>", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengNotEqualToColumn(Column column) {
            this.addCriterion("feisheng <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengGreaterThan(Integer value) {
            this.addCriterion("feisheng >", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengGreaterThanColumn(Column column) {
            this.addCriterion("feisheng > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("feisheng >=", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("feisheng >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengLessThan(Integer value) {
            this.addCriterion("feisheng <", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengLessThanColumn(Column column) {
            this.addCriterion("feisheng < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengLessThanOrEqualTo(Integer value) {
            this.addCriterion("feisheng <=", value, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengLessThanOrEqualToColumn(Column column) {
            this.addCriterion("feisheng <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFeishengIn(List<Integer> values) {
            this.addCriterion("feisheng in", values, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengNotIn(List<Integer> values) {
            this.addCriterion("feisheng not in", values, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengBetween(Integer value1, Integer value2) {
            this.addCriterion("feisheng between", value1, value2, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFeishengNotBetween(Integer value1, Integer value2) {
            this.addCriterion("feisheng not between", value1, value2, "feisheng");
            return (Criteria)this;
        }

        public Criteria andFsuduIsNull() {
            this.addCriterion("fsudu is null");
            return (Criteria)this;
        }

        public Criteria andFsuduIsNotNull() {
            this.addCriterion("fsudu is not null");
            return (Criteria)this;
        }

        public Criteria andFsuduEqualTo(Integer value) {
            this.addCriterion("fsudu =", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduEqualToColumn(Column column) {
            this.addCriterion("fsudu = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduNotEqualTo(Integer value) {
            this.addCriterion("fsudu <>", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduNotEqualToColumn(Column column) {
            this.addCriterion("fsudu <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduGreaterThan(Integer value) {
            this.addCriterion("fsudu >", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduGreaterThanColumn(Column column) {
            this.addCriterion("fsudu > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("fsudu >=", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("fsudu >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduLessThan(Integer value) {
            this.addCriterion("fsudu <", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduLessThanColumn(Column column) {
            this.addCriterion("fsudu < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduLessThanOrEqualTo(Integer value) {
            this.addCriterion("fsudu <=", value, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduLessThanOrEqualToColumn(Column column) {
            this.addCriterion("fsudu <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andFsuduIn(List<Integer> values) {
            this.addCriterion("fsudu in", values, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduNotIn(List<Integer> values) {
            this.addCriterion("fsudu not in", values, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduBetween(Integer value1, Integer value2) {
            this.addCriterion("fsudu between", value1, value2, "fsudu");
            return (Criteria)this;
        }

        public Criteria andFsuduNotBetween(Integer value1, Integer value2) {
            this.addCriterion("fsudu not between", value1, value2, "fsudu");
            return (Criteria)this;
        }

        public Criteria andQhcwWgIsNull() {
            this.addCriterion("qhcw_wg is null");
            return (Criteria)this;
        }

        public Criteria andQhcwWgIsNotNull() {
            this.addCriterion("qhcw_wg is not null");
            return (Criteria)this;
        }

        public Criteria andQhcwWgEqualTo(Integer value) {
            this.addCriterion("qhcw_wg =", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgEqualToColumn(Column column) {
            this.addCriterion("qhcw_wg = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgNotEqualTo(Integer value) {
            this.addCriterion("qhcw_wg <>", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgNotEqualToColumn(Column column) {
            this.addCriterion("qhcw_wg <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgGreaterThan(Integer value) {
            this.addCriterion("qhcw_wg >", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgGreaterThanColumn(Column column) {
            this.addCriterion("qhcw_wg > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("qhcw_wg >=", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("qhcw_wg >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgLessThan(Integer value) {
            this.addCriterion("qhcw_wg <", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgLessThanColumn(Column column) {
            this.addCriterion("qhcw_wg < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgLessThanOrEqualTo(Integer value) {
            this.addCriterion("qhcw_wg <=", value, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgLessThanOrEqualToColumn(Column column) {
            this.addCriterion("qhcw_wg <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwWgIn(List<Integer> values) {
            this.addCriterion("qhcw_wg in", values, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgNotIn(List<Integer> values) {
            this.addCriterion("qhcw_wg not in", values, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgBetween(Integer value1, Integer value2) {
            this.addCriterion("qhcw_wg between", value1, value2, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwWgNotBetween(Integer value1, Integer value2) {
            this.addCriterion("qhcw_wg not between", value1, value2, "qhcwWg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgIsNull() {
            this.addCriterion("qhcw_fg is null");
            return (Criteria)this;
        }

        public Criteria andQhcwFgIsNotNull() {
            this.addCriterion("qhcw_fg is not null");
            return (Criteria)this;
        }

        public Criteria andQhcwFgEqualTo(Integer value) {
            this.addCriterion("qhcw_fg =", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgEqualToColumn(Column column) {
            this.addCriterion("qhcw_fg = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgNotEqualTo(Integer value) {
            this.addCriterion("qhcw_fg <>", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgNotEqualToColumn(Column column) {
            this.addCriterion("qhcw_fg <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgGreaterThan(Integer value) {
            this.addCriterion("qhcw_fg >", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgGreaterThanColumn(Column column) {
            this.addCriterion("qhcw_fg > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("qhcw_fg >=", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("qhcw_fg >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgLessThan(Integer value) {
            this.addCriterion("qhcw_fg <", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgLessThanColumn(Column column) {
            this.addCriterion("qhcw_fg < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgLessThanOrEqualTo(Integer value) {
            this.addCriterion("qhcw_fg <=", value, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgLessThanOrEqualToColumn(Column column) {
            this.addCriterion("qhcw_fg <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andQhcwFgIn(List<Integer> values) {
            this.addCriterion("qhcw_fg in", values, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgNotIn(List<Integer> values) {
            this.addCriterion("qhcw_fg not in", values, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgBetween(Integer value1, Integer value2) {
            this.addCriterion("qhcw_fg between", value1, value2, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andQhcwFgNotBetween(Integer value1, Integer value2) {
            this.addCriterion("qhcw_fg not between", value1, value2, "qhcwFg");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingIsNull() {
            this.addCriterion("cw_xiangxing is null");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingIsNotNull() {
            this.addCriterion("cw_xiangxing is not null");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingEqualTo(Integer value) {
            this.addCriterion("cw_xiangxing =", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingEqualToColumn(Column column) {
            this.addCriterion("cw_xiangxing = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingNotEqualTo(Integer value) {
            this.addCriterion("cw_xiangxing <>", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingNotEqualToColumn(Column column) {
            this.addCriterion("cw_xiangxing <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingGreaterThan(Integer value) {
            this.addCriterion("cw_xiangxing >", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingGreaterThanColumn(Column column) {
            this.addCriterion("cw_xiangxing > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cw_xiangxing >=", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_xiangxing >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingLessThan(Integer value) {
            this.addCriterion("cw_xiangxing <", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingLessThanColumn(Column column) {
            this.addCriterion("cw_xiangxing < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingLessThanOrEqualTo(Integer value) {
            this.addCriterion("cw_xiangxing <=", value, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_xiangxing <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXiangxingIn(List<Integer> values) {
            this.addCriterion("cw_xiangxing in", values, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingNotIn(List<Integer> values) {
            this.addCriterion("cw_xiangxing not in", values, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_xiangxing between", value1, value2, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwXiangxingNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_xiangxing not between", value1, value2, "cwXiangxing");
            return (Criteria)this;
        }

        public Criteria andCwWuxueIsNull() {
            this.addCriterion("cw_wuxue is null");
            return (Criteria)this;
        }

        public Criteria andCwWuxueIsNotNull() {
            this.addCriterion("cw_wuxue is not null");
            return (Criteria)this;
        }

        public Criteria andCwWuxueEqualTo(Integer value) {
            this.addCriterion("cw_wuxue =", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueEqualToColumn(Column column) {
            this.addCriterion("cw_wuxue = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueNotEqualTo(Integer value) {
            this.addCriterion("cw_wuxue <>", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueNotEqualToColumn(Column column) {
            this.addCriterion("cw_wuxue <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueGreaterThan(Integer value) {
            this.addCriterion("cw_wuxue >", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueGreaterThanColumn(Column column) {
            this.addCriterion("cw_wuxue > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cw_wuxue >=", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_wuxue >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueLessThan(Integer value) {
            this.addCriterion("cw_wuxue <", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueLessThanColumn(Column column) {
            this.addCriterion("cw_wuxue < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueLessThanOrEqualTo(Integer value) {
            this.addCriterion("cw_wuxue <=", value, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_wuxue <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwWuxueIn(List<Integer> values) {
            this.addCriterion("cw_wuxue in", values, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueNotIn(List<Integer> values) {
            this.addCriterion("cw_wuxue not in", values, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_wuxue between", value1, value2, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwWuxueNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_wuxue not between", value1, value2, "cwWuxue");
            return (Criteria)this;
        }

        public Criteria andCwIconIsNull() {
            this.addCriterion("cw_icon is null");
            return (Criteria)this;
        }

        public Criteria andCwIconIsNotNull() {
            this.addCriterion("cw_icon is not null");
            return (Criteria)this;
        }

        public Criteria andCwIconEqualTo(String value) {
            this.addCriterion("cw_icon =", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconEqualToColumn(Column column) {
            this.addCriterion("cw_icon = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconNotEqualTo(String value) {
            this.addCriterion("cw_icon <>", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconNotEqualToColumn(Column column) {
            this.addCriterion("cw_icon <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconGreaterThan(String value) {
            this.addCriterion("cw_icon >", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconGreaterThanColumn(Column column) {
            this.addCriterion("cw_icon > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconGreaterThanOrEqualTo(String value) {
            this.addCriterion("cw_icon >=", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_icon >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconLessThan(String value) {
            this.addCriterion("cw_icon <", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconLessThanColumn(Column column) {
            this.addCriterion("cw_icon < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconLessThanOrEqualTo(String value) {
            this.addCriterion("cw_icon <=", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_icon <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwIconLike(String value) {
            this.addCriterion("cw_icon like", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconNotLike(String value) {
            this.addCriterion("cw_icon not like", value, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconIn(List<String> values) {
            this.addCriterion("cw_icon in", values, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconNotIn(List<String> values) {
            this.addCriterion("cw_icon not in", values, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconBetween(String value1, String value2) {
            this.addCriterion("cw_icon between", value1, value2, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwIconNotBetween(String value1, String value2) {
            this.addCriterion("cw_icon not between", value1, value2, "cwIcon");
            return (Criteria)this;
        }

        public Criteria andCwXinfaIsNull() {
            this.addCriterion("cw_xinfa is null");
            return (Criteria)this;
        }

        public Criteria andCwXinfaIsNotNull() {
            this.addCriterion("cw_xinfa is not null");
            return (Criteria)this;
        }

        public Criteria andCwXinfaEqualTo(Integer value) {
            this.addCriterion("cw_xinfa =", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaEqualToColumn(Column column) {
            this.addCriterion("cw_xinfa = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaNotEqualTo(Integer value) {
            this.addCriterion("cw_xinfa <>", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaNotEqualToColumn(Column column) {
            this.addCriterion("cw_xinfa <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaGreaterThan(Integer value) {
            this.addCriterion("cw_xinfa >", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaGreaterThanColumn(Column column) {
            this.addCriterion("cw_xinfa > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cw_xinfa >=", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_xinfa >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaLessThan(Integer value) {
            this.addCriterion("cw_xinfa <", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaLessThanColumn(Column column) {
            this.addCriterion("cw_xinfa < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaLessThanOrEqualTo(Integer value) {
            this.addCriterion("cw_xinfa <=", value, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_xinfa <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwXinfaIn(List<Integer> values) {
            this.addCriterion("cw_xinfa in", values, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaNotIn(List<Integer> values) {
            this.addCriterion("cw_xinfa not in", values, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_xinfa between", value1, value2, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwXinfaNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_xinfa not between", value1, value2, "cwXinfa");
            return (Criteria)this;
        }

        public Criteria andCwQinmiIsNull() {
            this.addCriterion("cw_qinmi is null");
            return (Criteria)this;
        }

        public Criteria andCwQinmiIsNotNull() {
            this.addCriterion("cw_qinmi is not null");
            return (Criteria)this;
        }

        public Criteria andCwQinmiEqualTo(Integer value) {
            this.addCriterion("cw_qinmi =", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiEqualToColumn(Column column) {
            this.addCriterion("cw_qinmi = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiNotEqualTo(Integer value) {
            this.addCriterion("cw_qinmi <>", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiNotEqualToColumn(Column column) {
            this.addCriterion("cw_qinmi <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiGreaterThan(Integer value) {
            this.addCriterion("cw_qinmi >", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiGreaterThanColumn(Column column) {
            this.addCriterion("cw_qinmi > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("cw_qinmi >=", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_qinmi >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiLessThan(Integer value) {
            this.addCriterion("cw_qinmi <", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiLessThanColumn(Column column) {
            this.addCriterion("cw_qinmi < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiLessThanOrEqualTo(Integer value) {
            this.addCriterion("cw_qinmi <=", value, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("cw_qinmi <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCwQinmiIn(List<Integer> values) {
            this.addCriterion("cw_qinmi in", values, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiNotIn(List<Integer> values) {
            this.addCriterion("cw_qinmi not in", values, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_qinmi between", value1, value2, "cwQinmi");
            return (Criteria)this;
        }

        public Criteria andCwQinmiNotBetween(Integer value1, Integer value2) {
            this.addCriterion("cw_qinmi not between", value1, value2, "cwQinmi");
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
        private PetsExample example;

        protected Criteria(PetsExample example) {
            this.example = example;
        }

        public PetsExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.PetsExample.Criteria.ICriteriaAdd add) {
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
