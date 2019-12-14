//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.ShowTasks.*;

public class ShowTasksExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria> oredCriteria = new ArrayList();

    public ShowTasksExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShowTasksExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ShowTasksExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria newAndCreateCriteria() {
        ShowTasksExample example = new ShowTasksExample();
        return example.createCriteria();
    }

    public ShowTasksExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ShowTasksExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public ShowTasksExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ShowTasksExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.ShowTasksExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(ShowTasksExample example);
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

        public Criteria andTaskDescIsNull() {
            this.addCriterion("task_desc is null");
            return (Criteria)this;
        }

        public Criteria andTaskDescIsNotNull() {
            this.addCriterion("task_desc is not null");
            return (Criteria)this;
        }

        public Criteria andTaskDescEqualTo(String value) {
            this.addCriterion("task_desc =", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescEqualToColumn(Column column) {
            this.addCriterion("task_desc = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescNotEqualTo(String value) {
            this.addCriterion("task_desc <>", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescNotEqualToColumn(Column column) {
            this.addCriterion("task_desc <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescGreaterThan(String value) {
            this.addCriterion("task_desc >", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescGreaterThanColumn(Column column) {
            this.addCriterion("task_desc > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("task_desc >=", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("task_desc >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescLessThan(String value) {
            this.addCriterion("task_desc <", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescLessThanColumn(Column column) {
            this.addCriterion("task_desc < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescLessThanOrEqualTo(String value) {
            this.addCriterion("task_desc <=", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescLessThanOrEqualToColumn(Column column) {
            this.addCriterion("task_desc <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskDescLike(String value) {
            this.addCriterion("task_desc like", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescNotLike(String value) {
            this.addCriterion("task_desc not like", value, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescIn(List<String> values) {
            this.addCriterion("task_desc in", values, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescNotIn(List<String> values) {
            this.addCriterion("task_desc not in", values, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescBetween(String value1, String value2) {
            this.addCriterion("task_desc between", value1, value2, "taskDesc");
            return (Criteria)this;
        }

        public Criteria andTaskDescNotBetween(String value1, String value2) {
            this.addCriterion("task_desc not between", value1, value2, "taskDesc");
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

        public Criteria andRefreshIsNull() {
            this.addCriterion("refresh is null");
            return (Criteria)this;
        }

        public Criteria andRefreshIsNotNull() {
            this.addCriterion("refresh is not null");
            return (Criteria)this;
        }

        public Criteria andRefreshEqualTo(Integer value) {
            this.addCriterion("refresh =", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshEqualToColumn(Column column) {
            this.addCriterion("refresh = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshNotEqualTo(Integer value) {
            this.addCriterion("refresh <>", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshNotEqualToColumn(Column column) {
            this.addCriterion("refresh <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshGreaterThan(Integer value) {
            this.addCriterion("refresh >", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshGreaterThanColumn(Column column) {
            this.addCriterion("refresh > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("refresh >=", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("refresh >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshLessThan(Integer value) {
            this.addCriterion("refresh <", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshLessThanColumn(Column column) {
            this.addCriterion("refresh < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshLessThanOrEqualTo(Integer value) {
            this.addCriterion("refresh <=", value, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshLessThanOrEqualToColumn(Column column) {
            this.addCriterion("refresh <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRefreshIn(List<Integer> values) {
            this.addCriterion("refresh in", values, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshNotIn(List<Integer> values) {
            this.addCriterion("refresh not in", values, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshBetween(Integer value1, Integer value2) {
            this.addCriterion("refresh between", value1, value2, "refresh");
            return (Criteria)this;
        }

        public Criteria andRefreshNotBetween(Integer value1, Integer value2) {
            this.addCriterion("refresh not between", value1, value2, "refresh");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeIsNull() {
            this.addCriterion("task_end_time is null");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeIsNotNull() {
            this.addCriterion("task_end_time is not null");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeEqualTo(Integer value) {
            this.addCriterion("task_end_time =", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeEqualToColumn(Column column) {
            this.addCriterion("task_end_time = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeNotEqualTo(Integer value) {
            this.addCriterion("task_end_time <>", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeNotEqualToColumn(Column column) {
            this.addCriterion("task_end_time <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeGreaterThan(Integer value) {
            this.addCriterion("task_end_time >", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeGreaterThanColumn(Column column) {
            this.addCriterion("task_end_time > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("task_end_time >=", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("task_end_time >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeLessThan(Integer value) {
            this.addCriterion("task_end_time <", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeLessThanColumn(Column column) {
            this.addCriterion("task_end_time < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualTo(Integer value) {
            this.addCriterion("task_end_time <=", value, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("task_end_time <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeIn(List<Integer> values) {
            this.addCriterion("task_end_time in", values, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeNotIn(List<Integer> values) {
            this.addCriterion("task_end_time not in", values, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeBetween(Integer value1, Integer value2) {
            this.addCriterion("task_end_time between", value1, value2, "taskEndTime");
            return (Criteria)this;
        }

        public Criteria andTaskEndTimeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("task_end_time not between", value1, value2, "taskEndTime");
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

        public Criteria andTasktaskExtraParaIsNull() {
            this.addCriterion("tasktask_extra_para is null");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaIsNotNull() {
            this.addCriterion("tasktask_extra_para is not null");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaEqualTo(String value) {
            this.addCriterion("tasktask_extra_para =", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaEqualToColumn(Column column) {
            this.addCriterion("tasktask_extra_para = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaNotEqualTo(String value) {
            this.addCriterion("tasktask_extra_para <>", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaNotEqualToColumn(Column column) {
            this.addCriterion("tasktask_extra_para <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaGreaterThan(String value) {
            this.addCriterion("tasktask_extra_para >", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaGreaterThanColumn(Column column) {
            this.addCriterion("tasktask_extra_para > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaGreaterThanOrEqualTo(String value) {
            this.addCriterion("tasktask_extra_para >=", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("tasktask_extra_para >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaLessThan(String value) {
            this.addCriterion("tasktask_extra_para <", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaLessThanColumn(Column column) {
            this.addCriterion("tasktask_extra_para < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaLessThanOrEqualTo(String value) {
            this.addCriterion("tasktask_extra_para <=", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("tasktask_extra_para <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaLike(String value) {
            this.addCriterion("tasktask_extra_para like", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaNotLike(String value) {
            this.addCriterion("tasktask_extra_para not like", value, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaIn(List<String> values) {
            this.addCriterion("tasktask_extra_para in", values, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaNotIn(List<String> values) {
            this.addCriterion("tasktask_extra_para not in", values, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaBetween(String value1, String value2) {
            this.addCriterion("tasktask_extra_para between", value1, value2, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskExtraParaNotBetween(String value1, String value2) {
            this.addCriterion("tasktask_extra_para not between", value1, value2, "tasktaskExtraPara");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateIsNull() {
            this.addCriterion("tasktask_state is null");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateIsNotNull() {
            this.addCriterion("tasktask_state is not null");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateEqualTo(Integer value) {
            this.addCriterion("tasktask_state =", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateEqualToColumn(Column column) {
            this.addCriterion("tasktask_state = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateNotEqualTo(Integer value) {
            this.addCriterion("tasktask_state <>", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateNotEqualToColumn(Column column) {
            this.addCriterion("tasktask_state <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateGreaterThan(Integer value) {
            this.addCriterion("tasktask_state >", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateGreaterThanColumn(Column column) {
            this.addCriterion("tasktask_state > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("tasktask_state >=", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("tasktask_state >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateLessThan(Integer value) {
            this.addCriterion("tasktask_state <", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateLessThanColumn(Column column) {
            this.addCriterion("tasktask_state < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateLessThanOrEqualTo(Integer value) {
            this.addCriterion("tasktask_state <=", value, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateLessThanOrEqualToColumn(Column column) {
            this.addCriterion("tasktask_state <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andTasktaskStateIn(List<Integer> values) {
            this.addCriterion("tasktask_state in", values, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateNotIn(List<Integer> values) {
            this.addCriterion("tasktask_state not in", values, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateBetween(Integer value1, Integer value2) {
            this.addCriterion("tasktask_state between", value1, value2, "tasktaskState");
            return (Criteria)this;
        }

        public Criteria andTasktaskStateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("tasktask_state not between", value1, value2, "tasktaskState");
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
        private ShowTasksExample example;

        protected Criteria(ShowTasksExample example) {
            this.example = example;
        }

        public ShowTasksExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria.ICriteriaAdd add) {
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
