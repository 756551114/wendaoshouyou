//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.NpcDialogue.*;

public class NpcDialogueExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria> oredCriteria = new ArrayList();

    public NpcDialogueExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public NpcDialogueExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public NpcDialogueExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria newAndCreateCriteria() {
        NpcDialogueExample example = new NpcDialogueExample();
        return example.createCriteria();
    }

    public NpcDialogueExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcDialogueExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public NpcDialogueExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcDialogueExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.NpcDialogueExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(NpcDialogueExample example);
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

        public Criteria andPortranitIsNull() {
            this.addCriterion("portranit is null");
            return (Criteria)this;
        }

        public Criteria andPortranitIsNotNull() {
            this.addCriterion("portranit is not null");
            return (Criteria)this;
        }

        public Criteria andPortranitEqualTo(Integer value) {
            this.addCriterion("portranit =", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitEqualToColumn(Column column) {
            this.addCriterion("portranit = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitNotEqualTo(Integer value) {
            this.addCriterion("portranit <>", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitNotEqualToColumn(Column column) {
            this.addCriterion("portranit <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitGreaterThan(Integer value) {
            this.addCriterion("portranit >", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitGreaterThanColumn(Column column) {
            this.addCriterion("portranit > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("portranit >=", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("portranit >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitLessThan(Integer value) {
            this.addCriterion("portranit <", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitLessThanColumn(Column column) {
            this.addCriterion("portranit < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitLessThanOrEqualTo(Integer value) {
            this.addCriterion("portranit <=", value, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitLessThanOrEqualToColumn(Column column) {
            this.addCriterion("portranit <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortranitIn(List<Integer> values) {
            this.addCriterion("portranit in", values, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitNotIn(List<Integer> values) {
            this.addCriterion("portranit not in", values, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitBetween(Integer value1, Integer value2) {
            this.addCriterion("portranit between", value1, value2, "portranit");
            return (Criteria)this;
        }

        public Criteria andPortranitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("portranit not between", value1, value2, "portranit");
            return (Criteria)this;
        }

        public Criteria andPicNoIsNull() {
            this.addCriterion("pic_no is null");
            return (Criteria)this;
        }

        public Criteria andPicNoIsNotNull() {
            this.addCriterion("pic_no is not null");
            return (Criteria)this;
        }

        public Criteria andPicNoEqualTo(Integer value) {
            this.addCriterion("pic_no =", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoEqualToColumn(Column column) {
            this.addCriterion("pic_no = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoNotEqualTo(Integer value) {
            this.addCriterion("pic_no <>", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoNotEqualToColumn(Column column) {
            this.addCriterion("pic_no <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoGreaterThan(Integer value) {
            this.addCriterion("pic_no >", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoGreaterThanColumn(Column column) {
            this.addCriterion("pic_no > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("pic_no >=", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pic_no >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoLessThan(Integer value) {
            this.addCriterion("pic_no <", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoLessThanColumn(Column column) {
            this.addCriterion("pic_no < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoLessThanOrEqualTo(Integer value) {
            this.addCriterion("pic_no <=", value, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pic_no <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPicNoIn(List<Integer> values) {
            this.addCriterion("pic_no in", values, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoNotIn(List<Integer> values) {
            this.addCriterion("pic_no not in", values, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoBetween(Integer value1, Integer value2) {
            this.addCriterion("pic_no between", value1, value2, "picNo");
            return (Criteria)this;
        }

        public Criteria andPicNoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("pic_no not between", value1, value2, "picNo");
            return (Criteria)this;
        }

        public Criteria andContentIsNull() {
            this.addCriterion("content is null");
            return (Criteria)this;
        }

        public Criteria andContentIsNotNull() {
            this.addCriterion("content is not null");
            return (Criteria)this;
        }

        public Criteria andContentEqualTo(String value) {
            this.addCriterion("content =", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentEqualToColumn(Column column) {
            this.addCriterion("content = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentNotEqualTo(String value) {
            this.addCriterion("content <>", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentNotEqualToColumn(Column column) {
            this.addCriterion("content <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentGreaterThan(String value) {
            this.addCriterion("content >", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentGreaterThanColumn(Column column) {
            this.addCriterion("content > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            this.addCriterion("content >=", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("content >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentLessThan(String value) {
            this.addCriterion("content <", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentLessThanColumn(Column column) {
            this.addCriterion("content < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            this.addCriterion("content <=", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentLessThanOrEqualToColumn(Column column) {
            this.addCriterion("content <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andContentLike(String value) {
            this.addCriterion("content like", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentNotLike(String value) {
            this.addCriterion("content not like", value, "content");
            return (Criteria)this;
        }

        public Criteria andContentIn(List<String> values) {
            this.addCriterion("content in", values, "content");
            return (Criteria)this;
        }

        public Criteria andContentNotIn(List<String> values) {
            this.addCriterion("content not in", values, "content");
            return (Criteria)this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            this.addCriterion("content between", value1, value2, "content");
            return (Criteria)this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            this.addCriterion("content not between", value1, value2, "content");
            return (Criteria)this;
        }

        public Criteria andIsconmleteIsNull() {
            this.addCriterion("isconmlete is null");
            return (Criteria)this;
        }

        public Criteria andIsconmleteIsNotNull() {
            this.addCriterion("isconmlete is not null");
            return (Criteria)this;
        }

        public Criteria andIsconmleteEqualTo(Integer value) {
            this.addCriterion("isconmlete =", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteEqualToColumn(Column column) {
            this.addCriterion("isconmlete = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteNotEqualTo(Integer value) {
            this.addCriterion("isconmlete <>", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteNotEqualToColumn(Column column) {
            this.addCriterion("isconmlete <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteGreaterThan(Integer value) {
            this.addCriterion("isconmlete >", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteGreaterThanColumn(Column column) {
            this.addCriterion("isconmlete > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("isconmlete >=", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("isconmlete >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteLessThan(Integer value) {
            this.addCriterion("isconmlete <", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteLessThanColumn(Column column) {
            this.addCriterion("isconmlete < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteLessThanOrEqualTo(Integer value) {
            this.addCriterion("isconmlete <=", value, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteLessThanOrEqualToColumn(Column column) {
            this.addCriterion("isconmlete <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsconmleteIn(List<Integer> values) {
            this.addCriterion("isconmlete in", values, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteNotIn(List<Integer> values) {
            this.addCriterion("isconmlete not in", values, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteBetween(Integer value1, Integer value2) {
            this.addCriterion("isconmlete between", value1, value2, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsconmleteNotBetween(Integer value1, Integer value2) {
            this.addCriterion("isconmlete not between", value1, value2, "isconmlete");
            return (Criteria)this;
        }

        public Criteria andIsincombatIsNull() {
            this.addCriterion("isincombat is null");
            return (Criteria)this;
        }

        public Criteria andIsincombatIsNotNull() {
            this.addCriterion("isincombat is not null");
            return (Criteria)this;
        }

        public Criteria andIsincombatEqualTo(Integer value) {
            this.addCriterion("isincombat =", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatEqualToColumn(Column column) {
            this.addCriterion("isincombat = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatNotEqualTo(Integer value) {
            this.addCriterion("isincombat <>", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatNotEqualToColumn(Column column) {
            this.addCriterion("isincombat <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatGreaterThan(Integer value) {
            this.addCriterion("isincombat >", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatGreaterThanColumn(Column column) {
            this.addCriterion("isincombat > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("isincombat >=", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("isincombat >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatLessThan(Integer value) {
            this.addCriterion("isincombat <", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatLessThanColumn(Column column) {
            this.addCriterion("isincombat < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatLessThanOrEqualTo(Integer value) {
            this.addCriterion("isincombat <=", value, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatLessThanOrEqualToColumn(Column column) {
            this.addCriterion("isincombat <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIsincombatIn(List<Integer> values) {
            this.addCriterion("isincombat in", values, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatNotIn(List<Integer> values) {
            this.addCriterion("isincombat not in", values, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatBetween(Integer value1, Integer value2) {
            this.addCriterion("isincombat between", value1, value2, "isincombat");
            return (Criteria)this;
        }

        public Criteria andIsincombatNotBetween(Integer value1, Integer value2) {
            this.addCriterion("isincombat not between", value1, value2, "isincombat");
            return (Criteria)this;
        }

        public Criteria andPalytimeIsNull() {
            this.addCriterion("palytime is null");
            return (Criteria)this;
        }

        public Criteria andPalytimeIsNotNull() {
            this.addCriterion("palytime is not null");
            return (Criteria)this;
        }

        public Criteria andPalytimeEqualTo(Integer value) {
            this.addCriterion("palytime =", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeEqualToColumn(Column column) {
            this.addCriterion("palytime = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeNotEqualTo(Integer value) {
            this.addCriterion("palytime <>", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeNotEqualToColumn(Column column) {
            this.addCriterion("palytime <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeGreaterThan(Integer value) {
            this.addCriterion("palytime >", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeGreaterThanColumn(Column column) {
            this.addCriterion("palytime > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("palytime >=", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("palytime >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeLessThan(Integer value) {
            this.addCriterion("palytime <", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeLessThanColumn(Column column) {
            this.addCriterion("palytime < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeLessThanOrEqualTo(Integer value) {
            this.addCriterion("palytime <=", value, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("palytime <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPalytimeIn(List<Integer> values) {
            this.addCriterion("palytime in", values, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeNotIn(List<Integer> values) {
            this.addCriterion("palytime not in", values, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeBetween(Integer value1, Integer value2) {
            this.addCriterion("palytime between", value1, value2, "palytime");
            return (Criteria)this;
        }

        public Criteria andPalytimeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("palytime not between", value1, value2, "palytime");
            return (Criteria)this;
        }

        public Criteria andTaskTypeIsNull() {
            this.addCriterion("task_type is null");
            return (Criteria)this;
        }

        public Criteria andTaskTypeIsNotNull() {
            this.addCriterion("task_type is not null");
            return (Criteria)this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            this.addCriterion("task_type =", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeEqualToColumn(Column column) {
            this.addCriterion("task_type = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            this.addCriterion("task_type <>", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeNotEqualToColumn(Column column) {
            this.addCriterion("task_type <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            this.addCriterion("task_type >", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeGreaterThanColumn(Column column) {
            this.addCriterion("task_type > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("task_type >=", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("task_type >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            this.addCriterion("task_type <", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeLessThanColumn(Column column) {
            this.addCriterion("task_type < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            this.addCriterion("task_type <=", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("task_type <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskTypeLike(String value) {
            this.addCriterion("task_type like", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            this.addCriterion("task_type not like", value, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            this.addCriterion("task_type in", values, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            this.addCriterion("task_type not in", values, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            this.addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria)this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            this.addCriterion("task_type not between", value1, value2, "taskType");
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

        public Criteria andIdnameIsNull() {
            this.addCriterion("idname is null");
            return (Criteria)this;
        }

        public Criteria andIdnameIsNotNull() {
            this.addCriterion("idname is not null");
            return (Criteria)this;
        }

        public Criteria andIdnameEqualTo(String value) {
            this.addCriterion("idname =", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameEqualToColumn(Column column) {
            this.addCriterion("idname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameNotEqualTo(String value) {
            this.addCriterion("idname <>", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotEqualToColumn(Column column) {
            this.addCriterion("idname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThan(String value) {
            this.addCriterion("idname >", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanColumn(Column column) {
            this.addCriterion("idname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("idname >=", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("idname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameLessThan(String value) {
            this.addCriterion("idname <", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanColumn(Column column) {
            this.addCriterion("idname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanOrEqualTo(String value) {
            this.addCriterion("idname <=", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("idname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameLike(String value) {
            this.addCriterion("idname like", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotLike(String value) {
            this.addCriterion("idname not like", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameIn(List<String> values) {
            this.addCriterion("idname in", values, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotIn(List<String> values) {
            this.addCriterion("idname not in", values, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameBetween(String value1, String value2) {
            this.addCriterion("idname between", value1, value2, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotBetween(String value1, String value2) {
            this.addCriterion("idname not between", value1, value2, "idname");
            return (Criteria)this;
        }
    }



    public static class Criteria extends GeneratedCriteria {
        private NpcDialogueExample example;

        protected Criteria(NpcDialogueExample example) {
            this.example = example;
        }

        public NpcDialogueExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.NpcDialogueExample.Criteria.ICriteriaAdd add) {
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
