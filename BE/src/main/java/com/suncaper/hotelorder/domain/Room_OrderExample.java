package com.suncaper.hotelorder.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room_OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Room_OrderExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(Integer value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(Integer value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(Integer value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(Integer value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(Integer value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<Integer> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<Integer> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(Integer value1, Integer value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(Integer value1, Integer value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andGIdIsNull() {
            addCriterion("g_id is null");
            return (Criteria) this;
        }

        public Criteria andGIdIsNotNull() {
            addCriterion("g_id is not null");
            return (Criteria) this;
        }

        public Criteria andGIdEqualTo(String value) {
            addCriterion("g_id =", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotEqualTo(String value) {
            addCriterion("g_id <>", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThan(String value) {
            addCriterion("g_id >", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThanOrEqualTo(String value) {
            addCriterion("g_id >=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThan(String value) {
            addCriterion("g_id <", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThanOrEqualTo(String value) {
            addCriterion("g_id <=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLike(String value) {
            addCriterion("g_id like", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotLike(String value) {
            addCriterion("g_id not like", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdIn(List<String> values) {
            addCriterion("g_id in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotIn(List<String> values) {
            addCriterion("g_id not in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdBetween(String value1, String value2) {
            addCriterion("g_id between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotBetween(String value1, String value2) {
            addCriterion("g_id not between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(String value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(String value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(String value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(String value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(String value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(String value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLike(String value) {
            addCriterion("r_id like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotLike(String value) {
            addCriterion("r_id not like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<String> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<String> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(String value1, String value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(String value1, String value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andPIntimeIsNull() {
            addCriterion("p_intime is null");
            return (Criteria) this;
        }

        public Criteria andPIntimeIsNotNull() {
            addCriterion("p_intime is not null");
            return (Criteria) this;
        }

        public Criteria andPIntimeEqualTo(Date value) {
            addCriterion("p_intime =", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeNotEqualTo(Date value) {
            addCriterion("p_intime <>", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeGreaterThan(Date value) {
            addCriterion("p_intime >", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_intime >=", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeLessThan(Date value) {
            addCriterion("p_intime <", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeLessThanOrEqualTo(Date value) {
            addCriterion("p_intime <=", value, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeIn(List<Date> values) {
            addCriterion("p_intime in", values, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeNotIn(List<Date> values) {
            addCriterion("p_intime not in", values, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeBetween(Date value1, Date value2) {
            addCriterion("p_intime between", value1, value2, "pIntime");
            return (Criteria) this;
        }

        public Criteria andPIntimeNotBetween(Date value1, Date value2) {
            addCriterion("p_intime not between", value1, value2, "pIntime");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeIsNull() {
            addCriterion("p_outtime is null");
            return (Criteria) this;
        }

        public Criteria andPOuttimeIsNotNull() {
            addCriterion("p_outtime is not null");
            return (Criteria) this;
        }

        public Criteria andPOuttimeEqualTo(Date value) {
            addCriterion("p_outtime =", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeNotEqualTo(Date value) {
            addCriterion("p_outtime <>", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeGreaterThan(Date value) {
            addCriterion("p_outtime >", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_outtime >=", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeLessThan(Date value) {
            addCriterion("p_outtime <", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeLessThanOrEqualTo(Date value) {
            addCriterion("p_outtime <=", value, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeIn(List<Date> values) {
            addCriterion("p_outtime in", values, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeNotIn(List<Date> values) {
            addCriterion("p_outtime not in", values, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeBetween(Date value1, Date value2) {
            addCriterion("p_outtime between", value1, value2, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andPOuttimeNotBetween(Date value1, Date value2) {
            addCriterion("p_outtime not between", value1, value2, "pOuttime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Integer value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Integer value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Integer value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Integer value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Integer value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Integer> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Integer> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Integer value1, Integer value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andOStateIsNull() {
            addCriterion("o_state is null");
            return (Criteria) this;
        }

        public Criteria andOStateIsNotNull() {
            addCriterion("o_state is not null");
            return (Criteria) this;
        }

        public Criteria andOStateEqualTo(String value) {
            addCriterion("o_state =", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotEqualTo(String value) {
            addCriterion("o_state <>", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateGreaterThan(String value) {
            addCriterion("o_state >", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateGreaterThanOrEqualTo(String value) {
            addCriterion("o_state >=", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLessThan(String value) {
            addCriterion("o_state <", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLessThanOrEqualTo(String value) {
            addCriterion("o_state <=", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLike(String value) {
            addCriterion("o_state like", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotLike(String value) {
            addCriterion("o_state not like", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateIn(List<String> values) {
            addCriterion("o_state in", values, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotIn(List<String> values) {
            addCriterion("o_state not in", values, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateBetween(String value1, String value2) {
            addCriterion("o_state between", value1, value2, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotBetween(String value1, String value2) {
            addCriterion("o_state not between", value1, value2, "oState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
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
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}