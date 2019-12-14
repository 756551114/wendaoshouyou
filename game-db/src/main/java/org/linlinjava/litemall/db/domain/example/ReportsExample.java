//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Reports.*;

public class ReportsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria> oredCriteria = new ArrayList();

    public ReportsExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ReportsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ReportsExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria newAndCreateCriteria() {
        ReportsExample example = new ReportsExample();
        return example.createCriteria();
    }

    public ReportsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ReportsExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public ReportsExample when(boolean condition, org.linlinjava.litemall.db.domain.example.ReportsExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.ReportsExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(ReportsExample example);
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

        public Criteria andZhanghaoIsNull() {
            this.addCriterion("zhanghao is null");
            return (Criteria)this;
        }

        public Criteria andZhanghaoIsNotNull() {
            this.addCriterion("zhanghao is not null");
            return (Criteria)this;
        }

        public Criteria andZhanghaoEqualTo(String value) {
            this.addCriterion("zhanghao =", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoEqualToColumn(Column column) {
            this.addCriterion("zhanghao = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoNotEqualTo(String value) {
            this.addCriterion("zhanghao <>", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoNotEqualToColumn(Column column) {
            this.addCriterion("zhanghao <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoGreaterThan(String value) {
            this.addCriterion("zhanghao >", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoGreaterThanColumn(Column column) {
            this.addCriterion("zhanghao > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoGreaterThanOrEqualTo(String value) {
            this.addCriterion("zhanghao >=", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("zhanghao >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoLessThan(String value) {
            this.addCriterion("zhanghao <", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoLessThanColumn(Column column) {
            this.addCriterion("zhanghao < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoLessThanOrEqualTo(String value) {
            this.addCriterion("zhanghao <=", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("zhanghao <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZhanghaoLike(String value) {
            this.addCriterion("zhanghao like", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoNotLike(String value) {
            this.addCriterion("zhanghao not like", value, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoIn(List<String> values) {
            this.addCriterion("zhanghao in", values, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoNotIn(List<String> values) {
            this.addCriterion("zhanghao not in", values, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoBetween(String value1, String value2) {
            this.addCriterion("zhanghao between", value1, value2, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andZhanghaoNotBetween(String value1, String value2) {
            this.addCriterion("zhanghao not between", value1, value2, "zhanghao");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuIsNull() {
            this.addCriterion("yuanbaoshu is null");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuIsNotNull() {
            this.addCriterion("yuanbaoshu is not null");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuEqualTo(Integer value) {
            this.addCriterion("yuanbaoshu =", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuEqualToColumn(Column column) {
            this.addCriterion("yuanbaoshu = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuNotEqualTo(Integer value) {
            this.addCriterion("yuanbaoshu <>", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuNotEqualToColumn(Column column) {
            this.addCriterion("yuanbaoshu <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuGreaterThan(Integer value) {
            this.addCriterion("yuanbaoshu >", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuGreaterThanColumn(Column column) {
            this.addCriterion("yuanbaoshu > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("yuanbaoshu >=", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("yuanbaoshu >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuLessThan(Integer value) {
            this.addCriterion("yuanbaoshu <", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuLessThanColumn(Column column) {
            this.addCriterion("yuanbaoshu < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuLessThanOrEqualTo(Integer value) {
            this.addCriterion("yuanbaoshu <=", value, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuLessThanOrEqualToColumn(Column column) {
            this.addCriterion("yuanbaoshu <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuIn(List<Integer> values) {
            this.addCriterion("yuanbaoshu in", values, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuNotIn(List<Integer> values) {
            this.addCriterion("yuanbaoshu not in", values, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuBetween(Integer value1, Integer value2) {
            this.addCriterion("yuanbaoshu between", value1, value2, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andYuanbaoshuNotBetween(Integer value1, Integer value2) {
            this.addCriterion("yuanbaoshu not between", value1, value2, "yuanbaoshu");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiIsNull() {
            this.addCriterion("shifouchongzhi is null");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiIsNotNull() {
            this.addCriterion("shifouchongzhi is not null");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiEqualTo(String value) {
            this.addCriterion("shifouchongzhi =", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiEqualToColumn(Column column) {
            this.addCriterion("shifouchongzhi = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiNotEqualTo(String value) {
            this.addCriterion("shifouchongzhi <>", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiNotEqualToColumn(Column column) {
            this.addCriterion("shifouchongzhi <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiGreaterThan(String value) {
            this.addCriterion("shifouchongzhi >", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiGreaterThanColumn(Column column) {
            this.addCriterion("shifouchongzhi > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiGreaterThanOrEqualTo(String value) {
            this.addCriterion("shifouchongzhi >=", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("shifouchongzhi >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiLessThan(String value) {
            this.addCriterion("shifouchongzhi <", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiLessThanColumn(Column column) {
            this.addCriterion("shifouchongzhi < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiLessThanOrEqualTo(String value) {
            this.addCriterion("shifouchongzhi <=", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("shifouchongzhi <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiLike(String value) {
            this.addCriterion("shifouchongzhi like", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiNotLike(String value) {
            this.addCriterion("shifouchongzhi not like", value, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiIn(List<String> values) {
            this.addCriterion("shifouchongzhi in", values, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiNotIn(List<String> values) {
            this.addCriterion("shifouchongzhi not in", values, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiBetween(String value1, String value2) {
            this.addCriterion("shifouchongzhi between", value1, value2, "shifouchongzhi");
            return (Criteria)this;
        }

        public Criteria andShifouchongzhiNotBetween(String value1, String value2) {
            this.addCriterion("shifouchongzhi not between", value1, value2, "shifouchongzhi");
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
        private ReportsExample example;

        protected Criteria(ReportsExample example) {
            this.example = example;
        }

        public ReportsExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria.ICriteriaAdd add) {
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
