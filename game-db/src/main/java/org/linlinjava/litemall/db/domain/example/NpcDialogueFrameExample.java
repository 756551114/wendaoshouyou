//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.NpcDialogueFrame.*;

public class NpcDialogueFrameExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria> oredCriteria = new ArrayList();

    public NpcDialogueFrameExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public NpcDialogueFrameExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public NpcDialogueFrameExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria newAndCreateCriteria() {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        return example.createCriteria();
    }

    public NpcDialogueFrameExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public NpcDialogueFrameExample when(boolean condition, org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(NpcDialogueFrameExample example);
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

        public Criteria andPortraitIsNull() {
            this.addCriterion("portrait is null");
            return (Criteria)this;
        }

        public Criteria andPortraitIsNotNull() {
            this.addCriterion("portrait is not null");
            return (Criteria)this;
        }

        public Criteria andPortraitEqualTo(Integer value) {
            this.addCriterion("portrait =", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitEqualToColumn(Column column) {
            this.addCriterion("portrait = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitNotEqualTo(Integer value) {
            this.addCriterion("portrait <>", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitNotEqualToColumn(Column column) {
            this.addCriterion("portrait <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitGreaterThan(Integer value) {
            this.addCriterion("portrait >", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitGreaterThanColumn(Column column) {
            this.addCriterion("portrait > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("portrait >=", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("portrait >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitLessThan(Integer value) {
            this.addCriterion("portrait <", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitLessThanColumn(Column column) {
            this.addCriterion("portrait < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitLessThanOrEqualTo(Integer value) {
            this.addCriterion("portrait <=", value, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitLessThanOrEqualToColumn(Column column) {
            this.addCriterion("portrait <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPortraitIn(List<Integer> values) {
            this.addCriterion("portrait in", values, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitNotIn(List<Integer> values) {
            this.addCriterion("portrait not in", values, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitBetween(Integer value1, Integer value2) {
            this.addCriterion("portrait between", value1, value2, "portrait");
            return (Criteria)this;
        }

        public Criteria andPortraitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("portrait not between", value1, value2, "portrait");
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

        public Criteria andSecretKeyIsNull() {
            this.addCriterion("secret_key is null");
            return (Criteria)this;
        }

        public Criteria andSecretKeyIsNotNull() {
            this.addCriterion("secret_key is not null");
            return (Criteria)this;
        }

        public Criteria andSecretKeyEqualTo(String value) {
            this.addCriterion("secret_key =", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyEqualToColumn(Column column) {
            this.addCriterion("secret_key = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyNotEqualTo(String value) {
            this.addCriterion("secret_key <>", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyNotEqualToColumn(Column column) {
            this.addCriterion("secret_key <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyGreaterThan(String value) {
            this.addCriterion("secret_key >", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyGreaterThanColumn(Column column) {
            this.addCriterion("secret_key > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("secret_key >=", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("secret_key >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyLessThan(String value) {
            this.addCriterion("secret_key <", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyLessThanColumn(Column column) {
            this.addCriterion("secret_key < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyLessThanOrEqualTo(String value) {
            this.addCriterion("secret_key <=", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyLessThanOrEqualToColumn(Column column) {
            this.addCriterion("secret_key <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSecretKeyLike(String value) {
            this.addCriterion("secret_key like", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyNotLike(String value) {
            this.addCriterion("secret_key not like", value, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyIn(List<String> values) {
            this.addCriterion("secret_key in", values, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyNotIn(List<String> values) {
            this.addCriterion("secret_key not in", values, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyBetween(String value1, String value2) {
            this.addCriterion("secret_key between", value1, value2, "secretKey");
            return (Criteria)this;
        }

        public Criteria andSecretKeyNotBetween(String value1, String value2) {
            this.addCriterion("secret_key not between", value1, value2, "secretKey");
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

        public Criteria andAttribIsNull() {
            this.addCriterion("attrib is null");
            return (Criteria)this;
        }

        public Criteria andAttribIsNotNull() {
            this.addCriterion("attrib is not null");
            return (Criteria)this;
        }

        public Criteria andAttribEqualTo(Integer value) {
            this.addCriterion("attrib =", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribEqualToColumn(Column column) {
            this.addCriterion("attrib = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualTo(Integer value) {
            this.addCriterion("attrib <>", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotEqualToColumn(Column column) {
            this.addCriterion("attrib <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThan(Integer value) {
            this.addCriterion("attrib >", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanColumn(Column column) {
            this.addCriterion("attrib > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("attrib >=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThan(Integer value) {
            this.addCriterion("attrib <", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanColumn(Column column) {
            this.addCriterion("attrib < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualTo(Integer value) {
            this.addCriterion("attrib <=", value, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribLessThanOrEqualToColumn(Column column) {
            this.addCriterion("attrib <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andAttribIn(List<Integer> values) {
            this.addCriterion("attrib in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotIn(List<Integer> values) {
            this.addCriterion("attrib not in", values, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribBetween(Integer value1, Integer value2) {
            this.addCriterion("attrib between", value1, value2, "attrib");
            return (Criteria)this;
        }

        public Criteria andAttribNotBetween(Integer value1, Integer value2) {
            this.addCriterion("attrib not between", value1, value2, "attrib");
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

        public Criteria andUpdateTimesIsNull() {
            this.addCriterion("update_times is null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesIsNotNull() {
            this.addCriterion("update_times is not null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesEqualTo(LocalDateTime value) {
            this.addCriterion("update_times =", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesEqualToColumn(Column column) {
            this.addCriterion("update_times = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesNotEqualTo(LocalDateTime value) {
            this.addCriterion("update_times <>", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesNotEqualToColumn(Column column) {
            this.addCriterion("update_times <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesGreaterThan(LocalDateTime value) {
            this.addCriterion("update_times >", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesGreaterThanColumn(Column column) {
            this.addCriterion("update_times > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesGreaterThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("update_times >=", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("update_times >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesLessThan(LocalDateTime value) {
            this.addCriterion("update_times <", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesLessThanColumn(Column column) {
            this.addCriterion("update_times < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesLessThanOrEqualTo(LocalDateTime value) {
            this.addCriterion("update_times <=", value, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesLessThanOrEqualToColumn(Column column) {
            this.addCriterion("update_times <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUpdateTimesIn(List<LocalDateTime> values) {
            this.addCriterion("update_times in", values, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesNotIn(List<LocalDateTime> values) {
            this.addCriterion("update_times not in", values, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("update_times between", value1, value2, "updateTimes");
            return (Criteria)this;
        }

        public Criteria andUpdateTimesNotBetween(LocalDateTime value1, LocalDateTime value2) {
            this.addCriterion("update_times not between", value1, value2, "updateTimes");
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

        public Criteria andIdnameIsNull() {
            this.addCriterion("idname is null");
            return (Criteria)this;
        }

        public Criteria andIdnameIsNotNull() {
            this.addCriterion("idname is not null");
            return (Criteria)this;
        }

        public Criteria andIdnameEqualTo(Integer value) {
            this.addCriterion("idname =", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameEqualToColumn(Column column) {
            this.addCriterion("idname = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameNotEqualTo(Integer value) {
            this.addCriterion("idname <>", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotEqualToColumn(Column column) {
            this.addCriterion("idname <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThan(Integer value) {
            this.addCriterion("idname >", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanColumn(Column column) {
            this.addCriterion("idname > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("idname >=", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("idname >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameLessThan(Integer value) {
            this.addCriterion("idname <", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanColumn(Column column) {
            this.addCriterion("idname < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanOrEqualTo(Integer value) {
            this.addCriterion("idname <=", value, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("idname <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIdnameIn(List<Integer> values) {
            this.addCriterion("idname in", values, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotIn(List<Integer> values) {
            this.addCriterion("idname not in", values, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameBetween(Integer value1, Integer value2) {
            this.addCriterion("idname between", value1, value2, "idname");
            return (Criteria)this;
        }

        public Criteria andIdnameNotBetween(Integer value1, Integer value2) {
            this.addCriterion("idname not between", value1, value2, "idname");
            return (Criteria)this;
        }

        public Criteria andNextIsNull() {
            this.addCriterion("`next` is null");
            return (Criteria)this;
        }

        public Criteria andNextIsNotNull() {
            this.addCriterion("`next` is not null");
            return (Criteria)this;
        }

        public Criteria andNextEqualTo(String value) {
            this.addCriterion("`next` =", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextEqualToColumn(Column column) {
            this.addCriterion("`next` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextNotEqualTo(String value) {
            this.addCriterion("`next` <>", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextNotEqualToColumn(Column column) {
            this.addCriterion("`next` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextGreaterThan(String value) {
            this.addCriterion("`next` >", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextGreaterThanColumn(Column column) {
            this.addCriterion("`next` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextGreaterThanOrEqualTo(String value) {
            this.addCriterion("`next` >=", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`next` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextLessThan(String value) {
            this.addCriterion("`next` <", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextLessThanColumn(Column column) {
            this.addCriterion("`next` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextLessThanOrEqualTo(String value) {
            this.addCriterion("`next` <=", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`next` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNextLike(String value) {
            this.addCriterion("`next` like", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextNotLike(String value) {
            this.addCriterion("`next` not like", value, "next");
            return (Criteria)this;
        }

        public Criteria andNextIn(List<String> values) {
            this.addCriterion("`next` in", values, "next");
            return (Criteria)this;
        }

        public Criteria andNextNotIn(List<String> values) {
            this.addCriterion("`next` not in", values, "next");
            return (Criteria)this;
        }

        public Criteria andNextBetween(String value1, String value2) {
            this.addCriterion("`next` between", value1, value2, "next");
            return (Criteria)this;
        }

        public Criteria andNextNotBetween(String value1, String value2) {
            this.addCriterion("`next` not between", value1, value2, "next");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskIsNull() {
            this.addCriterion("current_task is null");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskIsNotNull() {
            this.addCriterion("current_task is not null");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskEqualTo(String value) {
            this.addCriterion("current_task =", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskEqualToColumn(Column column) {
            this.addCriterion("current_task = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskNotEqualTo(String value) {
            this.addCriterion("current_task <>", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskNotEqualToColumn(Column column) {
            this.addCriterion("current_task <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskGreaterThan(String value) {
            this.addCriterion("current_task >", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskGreaterThanColumn(Column column) {
            this.addCriterion("current_task > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskGreaterThanOrEqualTo(String value) {
            this.addCriterion("current_task >=", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("current_task >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskLessThan(String value) {
            this.addCriterion("current_task <", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskLessThanColumn(Column column) {
            this.addCriterion("current_task < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskLessThanOrEqualTo(String value) {
            this.addCriterion("current_task <=", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskLessThanOrEqualToColumn(Column column) {
            this.addCriterion("current_task <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andCurrentTaskLike(String value) {
            this.addCriterion("current_task like", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskNotLike(String value) {
            this.addCriterion("current_task not like", value, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskIn(List<String> values) {
            this.addCriterion("current_task in", values, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskNotIn(List<String> values) {
            this.addCriterion("current_task not in", values, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskBetween(String value1, String value2) {
            this.addCriterion("current_task between", value1, value2, "currentTask");
            return (Criteria)this;
        }

        public Criteria andCurrentTaskNotBetween(String value1, String value2) {
            this.addCriterion("current_task not between", value1, value2, "currentTask");
            return (Criteria)this;
        }

        public Criteria andUncontentIsNull() {
            this.addCriterion("uncontent is null");
            return (Criteria)this;
        }

        public Criteria andUncontentIsNotNull() {
            this.addCriterion("uncontent is not null");
            return (Criteria)this;
        }

        public Criteria andUncontentEqualTo(String value) {
            this.addCriterion("uncontent =", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentEqualToColumn(Column column) {
            this.addCriterion("uncontent = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentNotEqualTo(String value) {
            this.addCriterion("uncontent <>", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentNotEqualToColumn(Column column) {
            this.addCriterion("uncontent <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentGreaterThan(String value) {
            this.addCriterion("uncontent >", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentGreaterThanColumn(Column column) {
            this.addCriterion("uncontent > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentGreaterThanOrEqualTo(String value) {
            this.addCriterion("uncontent >=", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("uncontent >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentLessThan(String value) {
            this.addCriterion("uncontent <", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentLessThanColumn(Column column) {
            this.addCriterion("uncontent < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentLessThanOrEqualTo(String value) {
            this.addCriterion("uncontent <=", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentLessThanOrEqualToColumn(Column column) {
            this.addCriterion("uncontent <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andUncontentLike(String value) {
            this.addCriterion("uncontent like", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentNotLike(String value) {
            this.addCriterion("uncontent not like", value, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentIn(List<String> values) {
            this.addCriterion("uncontent in", values, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentNotIn(List<String> values) {
            this.addCriterion("uncontent not in", values, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentBetween(String value1, String value2) {
            this.addCriterion("uncontent between", value1, value2, "uncontent");
            return (Criteria)this;
        }

        public Criteria andUncontentNotBetween(String value1, String value2) {
            this.addCriterion("uncontent not between", value1, value2, "uncontent");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiIsNull() {
            this.addCriterion("zhuangbei is null");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiIsNotNull() {
            this.addCriterion("zhuangbei is not null");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiEqualTo(String value) {
            this.addCriterion("zhuangbei =", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiEqualToColumn(Column column) {
            this.addCriterion("zhuangbei = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiNotEqualTo(String value) {
            this.addCriterion("zhuangbei <>", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiNotEqualToColumn(Column column) {
            this.addCriterion("zhuangbei <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiGreaterThan(String value) {
            this.addCriterion("zhuangbei >", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiGreaterThanColumn(Column column) {
            this.addCriterion("zhuangbei > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiGreaterThanOrEqualTo(String value) {
            this.addCriterion("zhuangbei >=", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("zhuangbei >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiLessThan(String value) {
            this.addCriterion("zhuangbei <", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiLessThanColumn(Column column) {
            this.addCriterion("zhuangbei < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiLessThanOrEqualTo(String value) {
            this.addCriterion("zhuangbei <=", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("zhuangbei <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhuangbeiLike(String value) {
            this.addCriterion("zhuangbei like", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiNotLike(String value) {
            this.addCriterion("zhuangbei not like", value, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiIn(List<String> values) {
            this.addCriterion("zhuangbei in", values, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiNotIn(List<String> values) {
            this.addCriterion("zhuangbei not in", values, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiBetween(String value1, String value2) {
            this.addCriterion("zhuangbei between", value1, value2, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andZhuangbeiNotBetween(String value1, String value2) {
            this.addCriterion("zhuangbei not between", value1, value2, "zhuangbei");
            return (Criteria)this;
        }

        public Criteria andJingyanIsNull() {
            this.addCriterion("jingyan is null");
            return (Criteria)this;
        }

        public Criteria andJingyanIsNotNull() {
            this.addCriterion("jingyan is not null");
            return (Criteria)this;
        }

        public Criteria andJingyanEqualTo(Integer value) {
            this.addCriterion("jingyan =", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanEqualToColumn(Column column) {
            this.addCriterion("jingyan = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanNotEqualTo(Integer value) {
            this.addCriterion("jingyan <>", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanNotEqualToColumn(Column column) {
            this.addCriterion("jingyan <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanGreaterThan(Integer value) {
            this.addCriterion("jingyan >", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanGreaterThanColumn(Column column) {
            this.addCriterion("jingyan > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("jingyan >=", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("jingyan >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanLessThan(Integer value) {
            this.addCriterion("jingyan <", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanLessThanColumn(Column column) {
            this.addCriterion("jingyan < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanLessThanOrEqualTo(Integer value) {
            this.addCriterion("jingyan <=", value, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanLessThanOrEqualToColumn(Column column) {
            this.addCriterion("jingyan <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andJingyanIn(List<Integer> values) {
            this.addCriterion("jingyan in", values, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanNotIn(List<Integer> values) {
            this.addCriterion("jingyan not in", values, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanBetween(Integer value1, Integer value2) {
            this.addCriterion("jingyan between", value1, value2, "jingyan");
            return (Criteria)this;
        }

        public Criteria andJingyanNotBetween(Integer value1, Integer value2) {
            this.addCriterion("jingyan not between", value1, value2, "jingyan");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (Criteria)this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            this.addCriterion("money =", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyEqualToColumn(Column column) {
            this.addCriterion("money = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            this.addCriterion("money <>", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotEqualToColumn(Column column) {
            this.addCriterion("money <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            this.addCriterion("money >", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanColumn(Column column) {
            this.addCriterion("money > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("money >=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("money >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            this.addCriterion("money <", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanColumn(Column column) {
            this.addCriterion("money < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            this.addCriterion("money <=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanOrEqualToColumn(Column column) {
            this.addCriterion("money <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            this.addCriterion("money in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            this.addCriterion("money not in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (Criteria)this;
        }
    }



    public static class Criteria extends GeneratedCriteria {
        private NpcDialogueFrameExample example;

        protected Criteria(NpcDialogueFrameExample example) {
            this.example = example;
        }

        public NpcDialogueFrameExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
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
