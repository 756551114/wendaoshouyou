//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.db.domain.ExperienceTreasure.*;

public class ExperienceTreasureExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria> oredCriteria = new ArrayList();

    public ExperienceTreasureExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ExperienceTreasureExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ExperienceTreasureExample orderBy(String... orderByClauses) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < orderByClauses.length; ++i) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }

        this.setOrderByClause(sb.toString());
        return this;
    }

    public org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria newAndCreateCriteria() {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        return example.createCriteria();
    }

    public ExperienceTreasureExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public ExperienceTreasureExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(ExperienceTreasureExample example);
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

        public Criteria andMaxLevelIsNull() {
            this.addCriterion("max_level is null");
            return (Criteria)this;
        }

        public Criteria andMaxLevelIsNotNull() {
            this.addCriterion("max_level is not null");
            return (Criteria)this;
        }

        public Criteria andMaxLevelEqualTo(Integer value) {
            this.addCriterion("max_level =", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelEqualToColumn(Column column) {
            this.addCriterion("max_level = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelNotEqualTo(Integer value) {
            this.addCriterion("max_level <>", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelNotEqualToColumn(Column column) {
            this.addCriterion("max_level <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelGreaterThan(Integer value) {
            this.addCriterion("max_level >", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelGreaterThanColumn(Column column) {
            this.addCriterion("max_level > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("max_level >=", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("max_level >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelLessThan(Integer value) {
            this.addCriterion("max_level <", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelLessThanColumn(Column column) {
            this.addCriterion("max_level < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelLessThanOrEqualTo(Integer value) {
            this.addCriterion("max_level <=", value, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelLessThanOrEqualToColumn(Column column) {
            this.addCriterion("max_level <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMaxLevelIn(List<Integer> values) {
            this.addCriterion("max_level in", values, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelNotIn(List<Integer> values) {
            this.addCriterion("max_level not in", values, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelBetween(Integer value1, Integer value2) {
            this.addCriterion("max_level between", value1, value2, "maxLevel");
            return (Criteria)this;
        }

        public Criteria andMaxLevelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("max_level not between", value1, value2, "maxLevel");
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
        private ExperienceTreasureExample example;

        protected Criteria(ExperienceTreasureExample example) {
            this.example = example;
        }

        public ExperienceTreasureExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria.ICriteriaAdd add) {
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
