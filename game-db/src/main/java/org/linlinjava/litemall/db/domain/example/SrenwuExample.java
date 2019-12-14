//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Srenwu.*;

public class SrenwuExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria> oredCriteria = new ArrayList();

    public SrenwuExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SrenwuExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SrenwuExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria newAndCreateCriteria() {
        SrenwuExample example = new SrenwuExample();
        return example.createCriteria();
    }

    public SrenwuExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SrenwuExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public SrenwuExample when(boolean condition, org.linlinjava.litemall.db.domain.example.SrenwuExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.SrenwuExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(SrenwuExample example);
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
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

        public Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (Criteria)this;
        }

        public Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (Criteria)this;
        }

        public Criteria andPidEqualTo(String value) {
            this.addCriterion("pid =", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidEqualToColumn(Column column) {
            this.addCriterion("pid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidNotEqualTo(String value) {
            this.addCriterion("pid <>", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotEqualToColumn(Column column) {
            this.addCriterion("pid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidGreaterThan(String value) {
            this.addCriterion("pid >", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidGreaterThanColumn(Column column) {
            this.addCriterion("pid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            this.addCriterion("pid >=", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("pid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidLessThan(String value) {
            this.addCriterion("pid <", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidLessThanColumn(Column column) {
            this.addCriterion("pid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            this.addCriterion("pid <=", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("pid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidIn(List<String> values) {
            this.addCriterion("pid in", values, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotIn(List<String> values) {
            this.addCriterion("pid not in", values, "pid");
            return (Criteria)this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (Criteria)this;
        }

        public Criteria andRidIsNull() {
            this.addCriterion("rid is null");
            return (Criteria)this;
        }

        public Criteria andRidIsNotNull() {
            this.addCriterion("rid is not null");
            return (Criteria)this;
        }

        public Criteria andRidEqualTo(Integer value) {
            this.addCriterion("rid =", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidEqualToColumn(Column column) {
            this.addCriterion("rid = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            this.addCriterion("rid <>", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotEqualToColumn(Column column) {
            this.addCriterion("rid <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            this.addCriterion("rid >", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidGreaterThanColumn(Column column) {
            this.addCriterion("rid > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("rid >=", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("rid >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidLessThan(Integer value) {
            this.addCriterion("rid <", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidLessThanColumn(Column column) {
            this.addCriterion("rid < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            this.addCriterion("rid <=", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidLessThanOrEqualToColumn(Column column) {
            this.addCriterion("rid <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andRidIn(List<Integer> values) {
            this.addCriterion("rid in", values, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            this.addCriterion("rid not in", values, "rid");
            return (Criteria)this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            this.addCriterion("rid between", value1, value2, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            this.addCriterion("rid not between", value1, value2, "rid");
            return (Criteria)this;
        }

        public Criteria andSkillNameIsNull() {
            this.addCriterion("skill_name is null");
            return (Criteria)this;
        }

        public Criteria andSkillNameIsNotNull() {
            this.addCriterion("skill_name is not null");
            return (Criteria)this;
        }

        public Criteria andSkillNameEqualTo(String value) {
            this.addCriterion("skill_name =", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameEqualToColumn(Column column) {
            this.addCriterion("skill_name = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameNotEqualTo(String value) {
            this.addCriterion("skill_name <>", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotEqualToColumn(Column column) {
            this.addCriterion("skill_name <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThan(String value) {
            this.addCriterion("skill_name >", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanColumn(Column column) {
            this.addCriterion("skill_name > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_name >=", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_name >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThan(String value) {
            this.addCriterion("skill_name <", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanColumn(Column column) {
            this.addCriterion("skill_name < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanOrEqualTo(String value) {
            this.addCriterion("skill_name <=", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_name <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillNameLike(String value) {
            this.addCriterion("skill_name like", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotLike(String value) {
            this.addCriterion("skill_name not like", value, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameIn(List<String> values) {
            this.addCriterion("skill_name in", values, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotIn(List<String> values) {
            this.addCriterion("skill_name not in", values, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameBetween(String value1, String value2) {
            this.addCriterion("skill_name between", value1, value2, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillNameNotBetween(String value1, String value2) {
            this.addCriterion("skill_name not between", value1, value2, "skillName");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoIsNull() {
            this.addCriterion("skill_jieshao is null");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoIsNotNull() {
            this.addCriterion("skill_jieshao is not null");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoEqualTo(String value) {
            this.addCriterion("skill_jieshao =", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoEqualToColumn(Column column) {
            this.addCriterion("skill_jieshao = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoNotEqualTo(String value) {
            this.addCriterion("skill_jieshao <>", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoNotEqualToColumn(Column column) {
            this.addCriterion("skill_jieshao <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoGreaterThan(String value) {
            this.addCriterion("skill_jieshao >", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoGreaterThanColumn(Column column) {
            this.addCriterion("skill_jieshao > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_jieshao >=", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_jieshao >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoLessThan(String value) {
            this.addCriterion("skill_jieshao <", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoLessThanColumn(Column column) {
            this.addCriterion("skill_jieshao < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoLessThanOrEqualTo(String value) {
            this.addCriterion("skill_jieshao <=", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_jieshao <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoLike(String value) {
            this.addCriterion("skill_jieshao like", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoNotLike(String value) {
            this.addCriterion("skill_jieshao not like", value, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoIn(List<String> values) {
            this.addCriterion("skill_jieshao in", values, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoNotIn(List<String> values) {
            this.addCriterion("skill_jieshao not in", values, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoBetween(String value1, String value2) {
            this.addCriterion("skill_jieshao between", value1, value2, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillJieshaoNotBetween(String value1, String value2) {
            this.addCriterion("skill_jieshao not between", value1, value2, "skillJieshao");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiIsNull() {
            this.addCriterion("skill_dqti is null");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiIsNotNull() {
            this.addCriterion("skill_dqti is not null");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiEqualTo(String value) {
            this.addCriterion("skill_dqti =", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiEqualToColumn(Column column) {
            this.addCriterion("skill_dqti = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiNotEqualTo(String value) {
            this.addCriterion("skill_dqti <>", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiNotEqualToColumn(Column column) {
            this.addCriterion("skill_dqti <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiGreaterThan(String value) {
            this.addCriterion("skill_dqti >", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiGreaterThanColumn(Column column) {
            this.addCriterion("skill_dqti > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_dqti >=", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_dqti >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiLessThan(String value) {
            this.addCriterion("skill_dqti <", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiLessThanColumn(Column column) {
            this.addCriterion("skill_dqti < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiLessThanOrEqualTo(String value) {
            this.addCriterion("skill_dqti <=", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_dqti <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillDqtiLike(String value) {
            this.addCriterion("skill_dqti like", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiNotLike(String value) {
            this.addCriterion("skill_dqti not like", value, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiIn(List<String> values) {
            this.addCriterion("skill_dqti in", values, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiNotIn(List<String> values) {
            this.addCriterion("skill_dqti not in", values, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiBetween(String value1, String value2) {
            this.addCriterion("skill_dqti between", value1, value2, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillDqtiNotBetween(String value1, String value2) {
            this.addCriterion("skill_dqti not between", value1, value2, "skillDqti");
            return (Criteria)this;
        }

        public Criteria andSkillXckIsNull() {
            this.addCriterion("skill_xck is null");
            return (Criteria)this;
        }

        public Criteria andSkillXckIsNotNull() {
            this.addCriterion("skill_xck is not null");
            return (Criteria)this;
        }

        public Criteria andSkillXckEqualTo(String value) {
            this.addCriterion("skill_xck =", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckEqualToColumn(Column column) {
            this.addCriterion("skill_xck = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckNotEqualTo(String value) {
            this.addCriterion("skill_xck <>", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckNotEqualToColumn(Column column) {
            this.addCriterion("skill_xck <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckGreaterThan(String value) {
            this.addCriterion("skill_xck >", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckGreaterThanColumn(Column column) {
            this.addCriterion("skill_xck > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckGreaterThanOrEqualTo(String value) {
            this.addCriterion("skill_xck >=", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_xck >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckLessThan(String value) {
            this.addCriterion("skill_xck <", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckLessThanColumn(Column column) {
            this.addCriterion("skill_xck < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckLessThanOrEqualTo(String value) {
            this.addCriterion("skill_xck <=", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skill_xck <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkillXckLike(String value) {
            this.addCriterion("skill_xck like", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckNotLike(String value) {
            this.addCriterion("skill_xck not like", value, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckIn(List<String> values) {
            this.addCriterion("skill_xck in", values, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckNotIn(List<String> values) {
            this.addCriterion("skill_xck not in", values, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckBetween(String value1, String value2) {
            this.addCriterion("skill_xck between", value1, value2, "skillXck");
            return (Criteria)this;
        }

        public Criteria andSkillXckNotBetween(String value1, String value2) {
            this.addCriterion("skill_xck not between", value1, value2, "skillXck");
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



    public static class Criteria extends GeneratedCriteria {
        private SrenwuExample example;

        protected Criteria(SrenwuExample example) {
            this.example = example;
        }

        public SrenwuExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria.ICriteriaAdd add) {
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
