//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.linlinjava.litemall.db.domain.Pet.*;

public class PetExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<org.linlinjava.litemall.db.domain.example.PetExample.Criteria> oredCriteria = new ArrayList();

    public PetExample() {
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

    public List<org.linlinjava.litemall.db.domain.example.PetExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(org.linlinjava.litemall.db.domain.example.PetExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public org.linlinjava.litemall.db.domain.example.PetExample.Criteria or() {
        org.linlinjava.litemall.db.domain.example.PetExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public PetExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PetExample orderBy(String... orderByClauses) {
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

    public org.linlinjava.litemall.db.domain.example.PetExample.Criteria createCriteria() {
        org.linlinjava.litemall.db.domain.example.PetExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected org.linlinjava.litemall.db.domain.example.PetExample.Criteria createCriteriaInternal() {
        org.linlinjava.litemall.db.domain.example.PetExample.Criteria criteria = new org.linlinjava.litemall.db.domain.example.PetExample.Criteria(this);
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static org.linlinjava.litemall.db.domain.example.PetExample.Criteria newAndCreateCriteria() {
        PetExample example = new PetExample();
        return example.createCriteria();
    }

    public PetExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PetExample.IExampleWhen then) {
        if (condition) {
            then.example(this);
        }

        return this;
    }

    public PetExample when(boolean condition, org.linlinjava.litemall.db.domain.example.PetExample.IExampleWhen then, org.linlinjava.litemall.db.domain.example.PetExample.IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }

        return this;
    }

    public interface IExampleWhen {
        void example(PetExample example);
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

        public Criteria andIndexIsNull() {
            this.addCriterion("`index` is null");
            return (Criteria)this;
        }

        public Criteria andIndexIsNotNull() {
            this.addCriterion("`index` is not null");
            return (Criteria)this;
        }

        public Criteria andIndexEqualTo(Integer value) {
            this.addCriterion("`index` =", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexEqualToColumn(Column column) {
            this.addCriterion("`index` = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexNotEqualTo(Integer value) {
            this.addCriterion("`index` <>", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexNotEqualToColumn(Column column) {
            this.addCriterion("`index` <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexGreaterThan(Integer value) {
            this.addCriterion("`index` >", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexGreaterThanColumn(Column column) {
            this.addCriterion("`index` > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("`index` >=", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("`index` >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexLessThan(Integer value) {
            this.addCriterion("`index` <", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexLessThanColumn(Column column) {
            this.addCriterion("`index` < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexLessThanOrEqualTo(Integer value) {
            this.addCriterion("`index` <=", value, "index");
            return (Criteria)this;
        }

        public Criteria andIndexLessThanOrEqualToColumn(Column column) {
            this.addCriterion("`index` <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIndexIn(List<Integer> values) {
            this.addCriterion("`index` in", values, "index");
            return (Criteria)this;
        }

        public Criteria andIndexNotIn(List<Integer> values) {
            this.addCriterion("`index` not in", values, "index");
            return (Criteria)this;
        }

        public Criteria andIndexBetween(Integer value1, Integer value2) {
            this.addCriterion("`index` between", value1, value2, "index");
            return (Criteria)this;
        }

        public Criteria andIndexNotBetween(Integer value1, Integer value2) {
            this.addCriterion("`index` not between", value1, value2, "index");
            return (Criteria)this;
        }

        public Criteria andLevelReqIsNull() {
            this.addCriterion("level_req is null");
            return (Criteria)this;
        }

        public Criteria andLevelReqIsNotNull() {
            this.addCriterion("level_req is not null");
            return (Criteria)this;
        }

        public Criteria andLevelReqEqualTo(Integer value) {
            this.addCriterion("level_req =", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqEqualToColumn(Column column) {
            this.addCriterion("level_req = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqNotEqualTo(Integer value) {
            this.addCriterion("level_req <>", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqNotEqualToColumn(Column column) {
            this.addCriterion("level_req <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqGreaterThan(Integer value) {
            this.addCriterion("level_req >", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqGreaterThanColumn(Column column) {
            this.addCriterion("level_req > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("level_req >=", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("level_req >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqLessThan(Integer value) {
            this.addCriterion("level_req <", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqLessThanColumn(Column column) {
            this.addCriterion("level_req < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqLessThanOrEqualTo(Integer value) {
            this.addCriterion("level_req <=", value, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqLessThanOrEqualToColumn(Column column) {
            this.addCriterion("level_req <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLevelReqIn(List<Integer> values) {
            this.addCriterion("level_req in", values, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqNotIn(List<Integer> values) {
            this.addCriterion("level_req not in", values, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqBetween(Integer value1, Integer value2) {
            this.addCriterion("level_req between", value1, value2, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLevelReqNotBetween(Integer value1, Integer value2) {
            this.addCriterion("level_req not between", value1, value2, "levelReq");
            return (Criteria)this;
        }

        public Criteria andLifeIsNull() {
            this.addCriterion("life is null");
            return (Criteria)this;
        }

        public Criteria andLifeIsNotNull() {
            this.addCriterion("life is not null");
            return (Criteria)this;
        }

        public Criteria andLifeEqualTo(Integer value) {
            this.addCriterion("life =", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeEqualToColumn(Column column) {
            this.addCriterion("life = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeNotEqualTo(Integer value) {
            this.addCriterion("life <>", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeNotEqualToColumn(Column column) {
            this.addCriterion("life <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeGreaterThan(Integer value) {
            this.addCriterion("life >", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeGreaterThanColumn(Column column) {
            this.addCriterion("life > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("life >=", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("life >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeLessThan(Integer value) {
            this.addCriterion("life <", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeLessThanColumn(Column column) {
            this.addCriterion("life < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeLessThanOrEqualTo(Integer value) {
            this.addCriterion("life <=", value, "life");
            return (Criteria)this;
        }

        public Criteria andLifeLessThanOrEqualToColumn(Column column) {
            this.addCriterion("life <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andLifeIn(List<Integer> values) {
            this.addCriterion("life in", values, "life");
            return (Criteria)this;
        }

        public Criteria andLifeNotIn(List<Integer> values) {
            this.addCriterion("life not in", values, "life");
            return (Criteria)this;
        }

        public Criteria andLifeBetween(Integer value1, Integer value2) {
            this.addCriterion("life between", value1, value2, "life");
            return (Criteria)this;
        }

        public Criteria andLifeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("life not between", value1, value2, "life");
            return (Criteria)this;
        }

        public Criteria andManaIsNull() {
            this.addCriterion("mana is null");
            return (Criteria)this;
        }

        public Criteria andManaIsNotNull() {
            this.addCriterion("mana is not null");
            return (Criteria)this;
        }

        public Criteria andManaEqualTo(Integer value) {
            this.addCriterion("mana =", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaEqualToColumn(Column column) {
            this.addCriterion("mana = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaNotEqualTo(Integer value) {
            this.addCriterion("mana <>", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotEqualToColumn(Column column) {
            this.addCriterion("mana <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaGreaterThan(Integer value) {
            this.addCriterion("mana >", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanColumn(Column column) {
            this.addCriterion("mana > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("mana >=", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("mana >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaLessThan(Integer value) {
            this.addCriterion("mana <", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaLessThanColumn(Column column) {
            this.addCriterion("mana < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaLessThanOrEqualTo(Integer value) {
            this.addCriterion("mana <=", value, "mana");
            return (Criteria)this;
        }

        public Criteria andManaLessThanOrEqualToColumn(Column column) {
            this.addCriterion("mana <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andManaIn(List<Integer> values) {
            this.addCriterion("mana in", values, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotIn(List<Integer> values) {
            this.addCriterion("mana not in", values, "mana");
            return (Criteria)this;
        }

        public Criteria andManaBetween(Integer value1, Integer value2) {
            this.addCriterion("mana between", value1, value2, "mana");
            return (Criteria)this;
        }

        public Criteria andManaNotBetween(Integer value1, Integer value2) {
            this.addCriterion("mana not between", value1, value2, "mana");
            return (Criteria)this;
        }

        public Criteria andSpeedIsNull() {
            this.addCriterion("speed is null");
            return (Criteria)this;
        }

        public Criteria andSpeedIsNotNull() {
            this.addCriterion("speed is not null");
            return (Criteria)this;
        }

        public Criteria andSpeedEqualTo(Integer value) {
            this.addCriterion("speed =", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedEqualToColumn(Column column) {
            this.addCriterion("speed = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedNotEqualTo(Integer value) {
            this.addCriterion("speed <>", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedNotEqualToColumn(Column column) {
            this.addCriterion("speed <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedGreaterThan(Integer value) {
            this.addCriterion("speed >", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedGreaterThanColumn(Column column) {
            this.addCriterion("speed > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("speed >=", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("speed >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedLessThan(Integer value) {
            this.addCriterion("speed <", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedLessThanColumn(Column column) {
            this.addCriterion("speed < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Integer value) {
            this.addCriterion("speed <=", value, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedLessThanOrEqualToColumn(Column column) {
            this.addCriterion("speed <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSpeedIn(List<Integer> values) {
            this.addCriterion("speed in", values, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedNotIn(List<Integer> values) {
            this.addCriterion("speed not in", values, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedBetween(Integer value1, Integer value2) {
            this.addCriterion("speed between", value1, value2, "speed");
            return (Criteria)this;
        }

        public Criteria andSpeedNotBetween(Integer value1, Integer value2) {
            this.addCriterion("speed not between", value1, value2, "speed");
            return (Criteria)this;
        }

        public Criteria andPhyAttackIsNull() {
            this.addCriterion("phy_attack is null");
            return (Criteria)this;
        }

        public Criteria andPhyAttackIsNotNull() {
            this.addCriterion("phy_attack is not null");
            return (Criteria)this;
        }

        public Criteria andPhyAttackEqualTo(Integer value) {
            this.addCriterion("phy_attack =", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackEqualToColumn(Column column) {
            this.addCriterion("phy_attack = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackNotEqualTo(Integer value) {
            this.addCriterion("phy_attack <>", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackNotEqualToColumn(Column column) {
            this.addCriterion("phy_attack <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackGreaterThan(Integer value) {
            this.addCriterion("phy_attack >", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackGreaterThanColumn(Column column) {
            this.addCriterion("phy_attack > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("phy_attack >=", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("phy_attack >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackLessThan(Integer value) {
            this.addCriterion("phy_attack <", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackLessThanColumn(Column column) {
            this.addCriterion("phy_attack < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackLessThanOrEqualTo(Integer value) {
            this.addCriterion("phy_attack <=", value, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackLessThanOrEqualToColumn(Column column) {
            this.addCriterion("phy_attack <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPhyAttackIn(List<Integer> values) {
            this.addCriterion("phy_attack in", values, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackNotIn(List<Integer> values) {
            this.addCriterion("phy_attack not in", values, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackBetween(Integer value1, Integer value2) {
            this.addCriterion("phy_attack between", value1, value2, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andPhyAttackNotBetween(Integer value1, Integer value2) {
            this.addCriterion("phy_attack not between", value1, value2, "phyAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackIsNull() {
            this.addCriterion("mag_attack is null");
            return (Criteria)this;
        }

        public Criteria andMagAttackIsNotNull() {
            this.addCriterion("mag_attack is not null");
            return (Criteria)this;
        }

        public Criteria andMagAttackEqualTo(Integer value) {
            this.addCriterion("mag_attack =", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackEqualToColumn(Column column) {
            this.addCriterion("mag_attack = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackNotEqualTo(Integer value) {
            this.addCriterion("mag_attack <>", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackNotEqualToColumn(Column column) {
            this.addCriterion("mag_attack <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackGreaterThan(Integer value) {
            this.addCriterion("mag_attack >", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackGreaterThanColumn(Column column) {
            this.addCriterion("mag_attack > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("mag_attack >=", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("mag_attack >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackLessThan(Integer value) {
            this.addCriterion("mag_attack <", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackLessThanColumn(Column column) {
            this.addCriterion("mag_attack < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackLessThanOrEqualTo(Integer value) {
            this.addCriterion("mag_attack <=", value, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackLessThanOrEqualToColumn(Column column) {
            this.addCriterion("mag_attack <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andMagAttackIn(List<Integer> values) {
            this.addCriterion("mag_attack in", values, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackNotIn(List<Integer> values) {
            this.addCriterion("mag_attack not in", values, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackBetween(Integer value1, Integer value2) {
            this.addCriterion("mag_attack between", value1, value2, "magAttack");
            return (Criteria)this;
        }

        public Criteria andMagAttackNotBetween(Integer value1, Integer value2) {
            this.addCriterion("mag_attack not between", value1, value2, "magAttack");
            return (Criteria)this;
        }

        public Criteria andPolarIsNull() {
            this.addCriterion("polar is null");
            return (Criteria)this;
        }

        public Criteria andPolarIsNotNull() {
            this.addCriterion("polar is not null");
            return (Criteria)this;
        }

        public Criteria andPolarEqualTo(String value) {
            this.addCriterion("polar =", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarEqualToColumn(Column column) {
            this.addCriterion("polar = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarNotEqualTo(String value) {
            this.addCriterion("polar <>", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarNotEqualToColumn(Column column) {
            this.addCriterion("polar <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarGreaterThan(String value) {
            this.addCriterion("polar >", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarGreaterThanColumn(Column column) {
            this.addCriterion("polar > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarGreaterThanOrEqualTo(String value) {
            this.addCriterion("polar >=", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("polar >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarLessThan(String value) {
            this.addCriterion("polar <", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarLessThanColumn(Column column) {
            this.addCriterion("polar < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarLessThanOrEqualTo(String value) {
            this.addCriterion("polar <=", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarLessThanOrEqualToColumn(Column column) {
            this.addCriterion("polar <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andPolarLike(String value) {
            this.addCriterion("polar like", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarNotLike(String value) {
            this.addCriterion("polar not like", value, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarIn(List<String> values) {
            this.addCriterion("polar in", values, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarNotIn(List<String> values) {
            this.addCriterion("polar not in", values, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarBetween(String value1, String value2) {
            this.addCriterion("polar between", value1, value2, "polar");
            return (Criteria)this;
        }

        public Criteria andPolarNotBetween(String value1, String value2) {
            this.addCriterion("polar not between", value1, value2, "polar");
            return (Criteria)this;
        }

        public Criteria andSkiilsIsNull() {
            this.addCriterion("skiils is null");
            return (Criteria)this;
        }

        public Criteria andSkiilsIsNotNull() {
            this.addCriterion("skiils is not null");
            return (Criteria)this;
        }

        public Criteria andSkiilsEqualTo(String value) {
            this.addCriterion("skiils =", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsEqualToColumn(Column column) {
            this.addCriterion("skiils = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsNotEqualTo(String value) {
            this.addCriterion("skiils <>", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsNotEqualToColumn(Column column) {
            this.addCriterion("skiils <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsGreaterThan(String value) {
            this.addCriterion("skiils >", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsGreaterThanColumn(Column column) {
            this.addCriterion("skiils > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsGreaterThanOrEqualTo(String value) {
            this.addCriterion("skiils >=", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("skiils >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsLessThan(String value) {
            this.addCriterion("skiils <", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsLessThanColumn(Column column) {
            this.addCriterion("skiils < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsLessThanOrEqualTo(String value) {
            this.addCriterion("skiils <=", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsLessThanOrEqualToColumn(Column column) {
            this.addCriterion("skiils <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andSkiilsLike(String value) {
            this.addCriterion("skiils like", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsNotLike(String value) {
            this.addCriterion("skiils not like", value, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsIn(List<String> values) {
            this.addCriterion("skiils in", values, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsNotIn(List<String> values) {
            this.addCriterion("skiils not in", values, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsBetween(String value1, String value2) {
            this.addCriterion("skiils between", value1, value2, "skiils");
            return (Criteria)this;
        }

        public Criteria andSkiilsNotBetween(String value1, String value2) {
            this.addCriterion("skiils not between", value1, value2, "skiils");
            return (Criteria)this;
        }

        public Criteria andZoonIsNull() {
            this.addCriterion("zoon is null");
            return (Criteria)this;
        }

        public Criteria andZoonIsNotNull() {
            this.addCriterion("zoon is not null");
            return (Criteria)this;
        }

        public Criteria andZoonEqualTo(String value) {
            this.addCriterion("zoon =", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonEqualToColumn(Column column) {
            this.addCriterion("zoon = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonNotEqualTo(String value) {
            this.addCriterion("zoon <>", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonNotEqualToColumn(Column column) {
            this.addCriterion("zoon <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonGreaterThan(String value) {
            this.addCriterion("zoon >", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonGreaterThanColumn(Column column) {
            this.addCriterion("zoon > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonGreaterThanOrEqualTo(String value) {
            this.addCriterion("zoon >=", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("zoon >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonLessThan(String value) {
            this.addCriterion("zoon <", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonLessThanColumn(Column column) {
            this.addCriterion("zoon < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonLessThanOrEqualTo(String value) {
            this.addCriterion("zoon <=", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonLessThanOrEqualToColumn(Column column) {
            this.addCriterion("zoon <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andZoonLike(String value) {
            this.addCriterion("zoon like", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonNotLike(String value) {
            this.addCriterion("zoon not like", value, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonIn(List<String> values) {
            this.addCriterion("zoon in", values, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonNotIn(List<String> values) {
            this.addCriterion("zoon not in", values, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonBetween(String value1, String value2) {
            this.addCriterion("zoon between", value1, value2, "zoon");
            return (Criteria)this;
        }

        public Criteria andZoonNotBetween(String value1, String value2) {
            this.addCriterion("zoon not between", value1, value2, "zoon");
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

        public Criteria andIconEqualTo(Integer value) {
            this.addCriterion("icon =", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconEqualToColumn(Column column) {
            this.addCriterion("icon = " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconNotEqualTo(Integer value) {
            this.addCriterion("icon <>", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotEqualToColumn(Column column) {
            this.addCriterion("icon <> " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThan(Integer value) {
            this.addCriterion("icon >", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanColumn(Column column) {
            this.addCriterion("icon > " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("icon >=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconGreaterThanOrEqualToColumn(Column column) {
            this.addCriterion("icon >= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThan(Integer value) {
            this.addCriterion("icon <", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanColumn(Column column) {
            this.addCriterion("icon < " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualTo(Integer value) {
            this.addCriterion("icon <=", value, "icon");
            return (Criteria)this;
        }

        public Criteria andIconLessThanOrEqualToColumn(Column column) {
            this.addCriterion("icon <= " + column.getEscapedColumnName());
            return (Criteria)this;
        }

        public Criteria andIconIn(List<Integer> values) {
            this.addCriterion("icon in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotIn(List<Integer> values) {
            this.addCriterion("icon not in", values, "icon");
            return (Criteria)this;
        }

        public Criteria andIconBetween(Integer value1, Integer value2) {
            this.addCriterion("icon between", value1, value2, "icon");
            return (Criteria)this;
        }

        public Criteria andIconNotBetween(Integer value1, Integer value2) {
            this.addCriterion("icon not between", value1, value2, "icon");
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
    }



    public static class Criteria extends GeneratedCriteria {
        private PetExample example;

        protected Criteria(PetExample example) {
            this.example = example;
        }

        public PetExample example() {
            return this.example;
        }

        /** @deprecated */
        @Deprecated
        public Criteria andIf(boolean ifAdd, org.linlinjava.litemall.db.domain.example.PetExample.Criteria.ICriteriaAdd add) {
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
