package com.fengf.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticlelikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticlelikeExample() {
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

        public Criteria andLadIdIsNull() {
            addCriterion("lad_id is null");
            return (Criteria) this;
        }

        public Criteria andLadIdIsNotNull() {
            addCriterion("lad_id is not null");
            return (Criteria) this;
        }

        public Criteria andLadIdEqualTo(Integer value) {
            addCriterion("lad_id =", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdNotEqualTo(Integer value) {
            addCriterion("lad_id <>", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdGreaterThan(Integer value) {
            addCriterion("lad_id >", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lad_id >=", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdLessThan(Integer value) {
            addCriterion("lad_id <", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdLessThanOrEqualTo(Integer value) {
            addCriterion("lad_id <=", value, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdIn(List<Integer> values) {
            addCriterion("lad_id in", values, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdNotIn(List<Integer> values) {
            addCriterion("lad_id not in", values, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdBetween(Integer value1, Integer value2) {
            addCriterion("lad_id between", value1, value2, "ladId");
            return (Criteria) this;
        }

        public Criteria andLadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lad_id not between", value1, value2, "ladId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeIsNull() {
            addCriterion("likeordislike is null");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeIsNotNull() {
            addCriterion("likeordislike is not null");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeEqualTo(String value) {
            addCriterion("likeordislike =", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeNotEqualTo(String value) {
            addCriterion("likeordislike <>", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeGreaterThan(String value) {
            addCriterion("likeordislike >", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeGreaterThanOrEqualTo(String value) {
            addCriterion("likeordislike >=", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeLessThan(String value) {
            addCriterion("likeordislike <", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeLessThanOrEqualTo(String value) {
            addCriterion("likeordislike <=", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeLike(String value) {
            addCriterion("likeordislike like", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeNotLike(String value) {
            addCriterion("likeordislike not like", value, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeIn(List<String> values) {
            addCriterion("likeordislike in", values, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeNotIn(List<String> values) {
            addCriterion("likeordislike not in", values, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeBetween(String value1, String value2) {
            addCriterion("likeordislike between", value1, value2, "likeordislike");
            return (Criteria) this;
        }

        public Criteria andLikeordislikeNotBetween(String value1, String value2) {
            addCriterion("likeordislike not between", value1, value2, "likeordislike");
            return (Criteria) this;
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

        public Criteria andLodTimeIsNull() {
            addCriterion("lod_time is null");
            return (Criteria) this;
        }

        public Criteria andLodTimeIsNotNull() {
            addCriterion("lod_time is not null");
            return (Criteria) this;
        }

        public Criteria andLodTimeEqualTo(Date value) {
            addCriterion("lod_time =", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeNotEqualTo(Date value) {
            addCriterion("lod_time <>", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeGreaterThan(Date value) {
            addCriterion("lod_time >", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lod_time >=", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeLessThan(Date value) {
            addCriterion("lod_time <", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeLessThanOrEqualTo(Date value) {
            addCriterion("lod_time <=", value, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeIn(List<Date> values) {
            addCriterion("lod_time in", values, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeNotIn(List<Date> values) {
            addCriterion("lod_time not in", values, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeBetween(Date value1, Date value2) {
            addCriterion("lod_time between", value1, value2, "lodTime");
            return (Criteria) this;
        }

        public Criteria andLodTimeNotBetween(Date value1, Date value2) {
            addCriterion("lod_time not between", value1, value2, "lodTime");
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