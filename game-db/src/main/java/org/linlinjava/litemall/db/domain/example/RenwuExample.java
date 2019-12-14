//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Renwu.*;

public class RenwuExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria> oredCriteria = new ArrayList();

    public RenwuExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public RenwuExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RenwuExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria newAndCreateCriteria() {
        RenwuExample example = new RenwuExample();
        return example.createCriteria();
    }

    public RenwuExample when(boolean condition, org.linlinjava.litemall.db.domain.example.RenwuExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public RenwuExample when(boolean condition, org.linlinjava.litemall.db.domain.example.RenwuExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.RenwuExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(RenwuExample example);
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

        public Criteria andNpcNameIsNull() {
            this.addCriterion("npc_name is null");
            return (Criteria)this;
        }

        public Criteria andNpcNameIsNotNull() {
            this.addCriterion("npc_name is not null");
            return (Criteria)this;
        }

        public Criteria andNpcNameEqualTo(String value) {
            this.addCriterion("npc_name =", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameEqualToColumn(Column column) {
            this.addCriterion("npc_name = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameNotEqualTo(String value) {
            this.addCriterion("npc_name <>", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameNotEqualToColumn(Column column) {
            this.addCriterion("npc_name <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameGreaterThan(String value) {
            this.addCriterion("npc_name >", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameGreaterThanColumn(Column column) {
            this.addCriterion("npc_name > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("npc_name >=", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("npc_name >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameLessThan(String value) {
            this.addCriterion("npc_name <", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameLessThanColumn(Column column) {
            this.addCriterion("npc_name < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameLessThanOrEqualTo(String value) {
            this.addCriterion("npc_name <=", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("npc_name <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andNpcNameLike(String value) {
            this.addCriterion("npc_name like", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameNotLike(String value) {
            this.addCriterion("npc_name not like", value, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameIn(List<String> values) {
            this.addCriterion("npc_name in", values, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameNotIn(List<String> values) {
            this.addCriterion("npc_name not in", values, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameBetween(String value1, String value2) {
            this.addCriterion("npc_name between", value1, value2, "npcName");
            return (Criteria)this;
        }

        public Criteria andNpcNameNotBetween(String value1, String value2) {
            this.addCriterion("npc_name not between", value1, value2, "npcName");
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

        public Criteria andShowNameIsNull() {
            this.addCriterion("show_name is null");
            return (Criteria)this;
        }

        public Criteria andShowNameIsNotNull() {
            this.addCriterion("show_name is not null");
            return (Criteria)this;
        }

        public Criteria andShowNameEqualTo(String value) {
            this.addCriterion("show_name =", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameEqualToColumn(Column column) {
            this.addCriterion("show_name = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameNotEqualTo(String value) {
            this.addCriterion("show_name <>", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameNotEqualToColumn(Column column) {
            this.addCriterion("show_name <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameGreaterThan(String value) {
            this.addCriterion("show_name >", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameGreaterThanColumn(Column column) {
            this.addCriterion("show_name > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("show_name >=", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("show_name >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameLessThan(String value) {
            this.addCriterion("show_name <", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameLessThanColumn(Column column) {
            this.addCriterion("show_name < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            this.addCriterion("show_name <=", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("show_name <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShowNameLike(String value) {
            this.addCriterion("show_name like", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameNotLike(String value) {
            this.addCriterion("show_name not like", value, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameIn(List<String> values) {
            this.addCriterion("show_name in", values, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameNotIn(List<String> values) {
            this.addCriterion("show_name not in", values, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            this.addCriterion("show_name between", value1, value2, "showName");
            return (Criteria)this;
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            this.addCriterion("show_name not between", value1, value2, "showName");
            return (Criteria)this;
        }

        public Criteria andTaskPromptIsNull() {
            this.addCriterion("task_prompt is null");
            return (Criteria)this;
        }

        public Criteria andTaskPromptIsNotNull() {
            this.addCriterion("task_prompt is not null");
            return (Criteria)this;
        }

        public Criteria andTaskPromptEqualTo(String value) {
            this.addCriterion("task_prompt =", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptEqualToColumn(Column column) {
            this.addCriterion("task_prompt = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptNotEqualTo(String value) {
            this.addCriterion("task_prompt <>", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptNotEqualToColumn(Column column) {
            this.addCriterion("task_prompt <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptGreaterThan(String value) {
            this.addCriterion("task_prompt >", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptGreaterThanColumn(Column column) {
            this.addCriterion("task_prompt > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptGreaterThanOrEqualTo(String value) {
            this.addCriterion("task_prompt >=", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("task_prompt >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptLessThan(String value) {
            this.addCriterion("task_prompt <", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptLessThanColumn(Column column) {
            this.addCriterion("task_prompt < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptLessThanOrEqualTo(String value) {
            this.addCriterion("task_prompt <=", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptLessThanOrEqualToColumn(Column column) {
            this.addCriterion("task_prompt <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskPromptLike(String value) {
            this.addCriterion("task_prompt like", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptNotLike(String value) {
            this.addCriterion("task_prompt not like", value, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptIn(List<String> values) {
            this.addCriterion("task_prompt in", values, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptNotIn(List<String> values) {
            this.addCriterion("task_prompt not in", values, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptBetween(String value1, String value2) {
            this.addCriterion("task_prompt between", value1, value2, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andTaskPromptNotBetween(String value1, String value2) {
            this.addCriterion("task_prompt not between", value1, value2, "taskPrompt");
            return (Criteria)this;
        }

        public Criteria andRewardIsNull() {
            this.addCriterion("reward is null");
            return (Criteria)this;
        }

        public Criteria andRewardIsNotNull() {
            this.addCriterion("reward is not null");
            return (Criteria)this;
        }

        public Criteria andRewardEqualTo(String value) {
            this.addCriterion("reward =", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardEqualToColumn(Column column) {
            this.addCriterion("reward = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardNotEqualTo(String value) {
            this.addCriterion("reward <>", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardNotEqualToColumn(Column column) {
            this.addCriterion("reward <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardGreaterThan(String value) {
            this.addCriterion("reward >", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardGreaterThanColumn(Column column) {
            this.addCriterion("reward > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(String value) {
            this.addCriterion("reward >=", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("reward >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardLessThan(String value) {
            this.addCriterion("reward <", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardLessThanColumn(Column column) {
            this.addCriterion("reward < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardLessThanOrEqualTo(String value) {
            this.addCriterion("reward <=", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardLessThanOrEqualToColumn(Column column) {
            this.addCriterion("reward <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRewardLike(String value) {
            this.addCriterion("reward like", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardNotLike(String value) {
            this.addCriterion("reward not like", value, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardIn(List<String> values) {
            this.addCriterion("reward in", values, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardNotIn(List<String> values) {
            this.addCriterion("reward not in", values, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardBetween(String value1, String value2) {
            this.addCriterion("reward between", value1, value2, "reward");
            return (Criteria)this;
        }

        public Criteria andRewardNotBetween(String value1, String value2) {
            this.addCriterion("reward not between", value1, value2, "reward");
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
        private RenwuExample example;

        protected Criteria(RenwuExample example) {
            this.example = example;
        }

        public RenwuExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria.ICriteriaAdd add) {
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
