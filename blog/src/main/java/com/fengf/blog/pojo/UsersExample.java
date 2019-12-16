package com.fengf.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andGoldIsNull() {
            addCriterion("gold is null");
            return (Criteria) this;
        }

        public Criteria andGoldIsNotNull() {
            addCriterion("gold is not null");
            return (Criteria) this;
        }

        public Criteria andGoldEqualTo(Integer value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(Integer value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(Integer value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(Integer value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(Integer value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<Integer> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<Integer> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(Integer value1, Integer value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("gold not between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andJoindayIsNull() {
            addCriterion("joinday is null");
            return (Criteria) this;
        }

        public Criteria andJoindayIsNotNull() {
            addCriterion("joinday is not null");
            return (Criteria) this;
        }

        public Criteria andJoindayEqualTo(Date value) {
            addCriterionForJDBCDate("joinday =", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayNotEqualTo(Date value) {
            addCriterionForJDBCDate("joinday <>", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayGreaterThan(Date value) {
            addCriterionForJDBCDate("joinday >", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("joinday >=", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayLessThan(Date value) {
            addCriterionForJDBCDate("joinday <", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("joinday <=", value, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayIn(List<Date> values) {
            addCriterionForJDBCDate("joinday in", values, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayNotIn(List<Date> values) {
            addCriterionForJDBCDate("joinday not in", values, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("joinday between", value1, value2, "joinday");
            return (Criteria) this;
        }

        public Criteria andJoindayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("joinday not between", value1, value2, "joinday");
            return (Criteria) this;
        }

        public Criteria andAttentionIsNull() {
            addCriterion("attention is null");
            return (Criteria) this;
        }

        public Criteria andAttentionIsNotNull() {
            addCriterion("attention is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionEqualTo(Integer value) {
            addCriterion("attention =", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotEqualTo(Integer value) {
            addCriterion("attention <>", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionGreaterThan(Integer value) {
            addCriterion("attention >", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionGreaterThanOrEqualTo(Integer value) {
            addCriterion("attention >=", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionLessThan(Integer value) {
            addCriterion("attention <", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionLessThanOrEqualTo(Integer value) {
            addCriterion("attention <=", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionIn(List<Integer> values) {
            addCriterion("attention in", values, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotIn(List<Integer> values) {
            addCriterion("attention not in", values, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionBetween(Integer value1, Integer value2) {
            addCriterion("attention between", value1, value2, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotBetween(Integer value1, Integer value2) {
            addCriterion("attention not between", value1, value2, "attention");
            return (Criteria) this;
        }

        public Criteria andFansIsNull() {
            addCriterion("fans is null");
            return (Criteria) this;
        }

        public Criteria andFansIsNotNull() {
            addCriterion("fans is not null");
            return (Criteria) this;
        }

        public Criteria andFansEqualTo(Integer value) {
            addCriterion("fans =", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotEqualTo(Integer value) {
            addCriterion("fans <>", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThan(Integer value) {
            addCriterion("fans >", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans >=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThan(Integer value) {
            addCriterion("fans <", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThanOrEqualTo(Integer value) {
            addCriterion("fans <=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansIn(List<Integer> values) {
            addCriterion("fans in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotIn(List<Integer> values) {
            addCriterion("fans not in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansBetween(Integer value1, Integer value2) {
            addCriterion("fans between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotBetween(Integer value1, Integer value2) {
            addCriterion("fans not between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andMoodcountIsNull() {
            addCriterion("moodcount is null");
            return (Criteria) this;
        }

        public Criteria andMoodcountIsNotNull() {
            addCriterion("moodcount is not null");
            return (Criteria) this;
        }

        public Criteria andMoodcountEqualTo(Integer value) {
            addCriterion("moodcount =", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountNotEqualTo(Integer value) {
            addCriterion("moodcount <>", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountGreaterThan(Integer value) {
            addCriterion("moodcount >", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("moodcount >=", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountLessThan(Integer value) {
            addCriterion("moodcount <", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountLessThanOrEqualTo(Integer value) {
            addCriterion("moodcount <=", value, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountIn(List<Integer> values) {
            addCriterion("moodcount in", values, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountNotIn(List<Integer> values) {
            addCriterion("moodcount not in", values, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountBetween(Integer value1, Integer value2) {
            addCriterion("moodcount between", value1, value2, "moodcount");
            return (Criteria) this;
        }

        public Criteria andMoodcountNotBetween(Integer value1, Integer value2) {
            addCriterion("moodcount not between", value1, value2, "moodcount");
            return (Criteria) this;
        }

        public Criteria andArticlecountIsNull() {
            addCriterion("articlecount is null");
            return (Criteria) this;
        }

        public Criteria andArticlecountIsNotNull() {
            addCriterion("articlecount is not null");
            return (Criteria) this;
        }

        public Criteria andArticlecountEqualTo(Integer value) {
            addCriterion("articlecount =", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountNotEqualTo(Integer value) {
            addCriterion("articlecount <>", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountGreaterThan(Integer value) {
            addCriterion("articlecount >", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("articlecount >=", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountLessThan(Integer value) {
            addCriterion("articlecount <", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountLessThanOrEqualTo(Integer value) {
            addCriterion("articlecount <=", value, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountIn(List<Integer> values) {
            addCriterion("articlecount in", values, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountNotIn(List<Integer> values) {
            addCriterion("articlecount not in", values, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountBetween(Integer value1, Integer value2) {
            addCriterion("articlecount between", value1, value2, "articlecount");
            return (Criteria) this;
        }

        public Criteria andArticlecountNotBetween(Integer value1, Integer value2) {
            addCriterion("articlecount not between", value1, value2, "articlecount");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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