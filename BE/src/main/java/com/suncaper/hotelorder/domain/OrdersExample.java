package com.suncaper.hotelorder.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andGuestidIsNull() {
            addCriterion("guestID is null");
            return (Criteria) this;
        }

        public Criteria andGuestidIsNotNull() {
            addCriterion("guestID is not null");
            return (Criteria) this;
        }

        public Criteria andGuestidEqualTo(String value) {
            addCriterion("guestID =", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotEqualTo(String value) {
            addCriterion("guestID <>", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidGreaterThan(String value) {
            addCriterion("guestID >", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidGreaterThanOrEqualTo(String value) {
            addCriterion("guestID >=", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidLessThan(String value) {
            addCriterion("guestID <", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidLessThanOrEqualTo(String value) {
            addCriterion("guestID <=", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidLike(String value) {
            addCriterion("guestID like", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotLike(String value) {
            addCriterion("guestID not like", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidIn(List<String> values) {
            addCriterion("guestID in", values, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotIn(List<String> values) {
            addCriterion("guestID not in", values, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidBetween(String value1, String value2) {
            addCriterion("guestID between", value1, value2, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotBetween(String value1, String value2) {
            addCriterion("guestID not between", value1, value2, "guestid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomID is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomID is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(String value) {
            addCriterion("roomID =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(String value) {
            addCriterion("roomID <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(String value) {
            addCriterion("roomID >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(String value) {
            addCriterion("roomID >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(String value) {
            addCriterion("roomID <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(String value) {
            addCriterion("roomID <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLike(String value) {
            addCriterion("roomID like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotLike(String value) {
            addCriterion("roomID not like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<String> values) {
            addCriterion("roomID in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<String> values) {
            addCriterion("roomID not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(String value1, String value2) {
            addCriterion("roomID between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(String value1, String value2) {
            addCriterion("roomID not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIsNull() {
            addCriterion("roomtype is null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIsNotNull() {
            addCriterion("roomtype is not null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeEqualTo(String value) {
            addCriterion("roomtype =", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotEqualTo(String value) {
            addCriterion("roomtype <>", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThan(String value) {
            addCriterion("roomtype >", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThanOrEqualTo(String value) {
            addCriterion("roomtype >=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThan(String value) {
            addCriterion("roomtype <", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThanOrEqualTo(String value) {
            addCriterion("roomtype <=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLike(String value) {
            addCriterion("roomtype like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotLike(String value) {
            addCriterion("roomtype not like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIn(List<String> values) {
            addCriterion("roomtype in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotIn(List<String> values) {
            addCriterion("roomtype not in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeBetween(String value1, String value2) {
            addCriterion("roomtype between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotBetween(String value1, String value2) {
            addCriterion("roomtype not between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNull() {
            addCriterion("ordertime is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("ordertime is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(Date value) {
            addCriterionForJDBCDate("ordertime =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ordertime <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ordertime >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ordertime >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(Date value) {
            addCriterionForJDBCDate("ordertime <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ordertime <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<Date> values) {
            addCriterionForJDBCDate("ordertime in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ordertime not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ordertime between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ordertime not between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andPreintimeIsNull() {
            addCriterion("preintime is null");
            return (Criteria) this;
        }

        public Criteria andPreintimeIsNotNull() {
            addCriterion("preintime is not null");
            return (Criteria) this;
        }

        public Criteria andPreintimeEqualTo(Date value) {
            addCriterionForJDBCDate("preintime =", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("preintime <>", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeGreaterThan(Date value) {
            addCriterionForJDBCDate("preintime >", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("preintime >=", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeLessThan(Date value) {
            addCriterionForJDBCDate("preintime <", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("preintime <=", value, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeIn(List<Date> values) {
            addCriterionForJDBCDate("preintime in", values, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("preintime not in", values, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("preintime between", value1, value2, "preintime");
            return (Criteria) this;
        }

        public Criteria andPreintimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("preintime not between", value1, value2, "preintime");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("intime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("intime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterionForJDBCDate("intime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("intime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterionForJDBCDate("intime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("intime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterionForJDBCDate("intime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("intime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterionForJDBCDate("intime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("intime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("intime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("intime not between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeIsNull() {
            addCriterion("preouttime is null");
            return (Criteria) this;
        }

        public Criteria andPreouttimeIsNotNull() {
            addCriterion("preouttime is not null");
            return (Criteria) this;
        }

        public Criteria andPreouttimeEqualTo(Date value) {
            addCriterionForJDBCDate("preouttime =", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("preouttime <>", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("preouttime >", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("preouttime >=", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeLessThan(Date value) {
            addCriterionForJDBCDate("preouttime <", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("preouttime <=", value, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeIn(List<Date> values) {
            addCriterionForJDBCDate("preouttime in", values, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("preouttime not in", values, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("preouttime between", value1, value2, "preouttime");
            return (Criteria) this;
        }

        public Criteria andPreouttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("preouttime not between", value1, value2, "preouttime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNull() {
            addCriterion("outtime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("outtime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(Date value) {
            addCriterionForJDBCDate("outtime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("outtime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("outtime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("outtime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            addCriterionForJDBCDate("outtime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("outtime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            addCriterionForJDBCDate("outtime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("outtime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("outtime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("outtime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(String value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(String value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(String value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(String value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(String value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(String value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLike(String value) {
            addCriterion("total like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotLike(String value) {
            addCriterion("total not like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<String> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<String> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(String value1, String value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(String value1, String value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNull() {
            addCriterion("overtime is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNotNull() {
            addCriterion("overtime is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEqualTo(String value) {
            addCriterion("overtime =", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotEqualTo(String value) {
            addCriterion("overtime <>", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThan(String value) {
            addCriterion("overtime >", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThanOrEqualTo(String value) {
            addCriterion("overtime >=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThan(String value) {
            addCriterion("overtime <", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThanOrEqualTo(String value) {
            addCriterion("overtime <=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLike(String value) {
            addCriterion("overtime like", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotLike(String value) {
            addCriterion("overtime not like", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeIn(List<String> values) {
            addCriterion("overtime in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotIn(List<String> values) {
            addCriterion("overtime not in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeBetween(String value1, String value2) {
            addCriterion("overtime between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotBetween(String value1, String value2) {
            addCriterion("overtime not between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNull() {
            addCriterion("orderState is null");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNotNull() {
            addCriterion("orderState is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstateEqualTo(Integer value) {
            addCriterion("orderState =", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotEqualTo(Integer value) {
            addCriterion("orderState <>", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThan(Integer value) {
            addCriterion("orderState >", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderState >=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThan(Integer value) {
            addCriterion("orderState <", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThanOrEqualTo(Integer value) {
            addCriterion("orderState <=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateIn(List<Integer> values) {
            addCriterion("orderState in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotIn(List<Integer> values) {
            addCriterion("orderState not in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateBetween(Integer value1, Integer value2) {
            addCriterion("orderState between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotBetween(Integer value1, Integer value2) {
            addCriterion("orderState not between", value1, value2, "orderstate");
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