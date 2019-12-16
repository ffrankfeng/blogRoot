package com.fengf.bms.pojo;

import java.util.ArrayList;
import java.util.List;

public class MoodshareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoodshareExample() {
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

        public Criteria andMoodIdIsNull() {
            addCriterion("mood_id is null");
            return (Criteria) this;
        }

        public Criteria andMoodIdIsNotNull() {
            addCriterion("mood_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoodIdEqualTo(Integer value) {
            addCriterion("mood_id =", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdNotEqualTo(Integer value) {
            addCriterion("mood_id <>", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdGreaterThan(Integer value) {
            addCriterion("mood_id >", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mood_id >=", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdLessThan(Integer value) {
            addCriterion("mood_id <", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("mood_id <=", value, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdIn(List<Integer> values) {
            addCriterion("mood_id in", values, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdNotIn(List<Integer> values) {
            addCriterion("mood_id not in", values, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdBetween(Integer value1, Integer value2) {
            addCriterion("mood_id between", value1, value2, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mood_id not between", value1, value2, "moodId");
            return (Criteria) this;
        }

        public Criteria andMoodContentIsNull() {
            addCriterion("mood_content is null");
            return (Criteria) this;
        }

        public Criteria andMoodContentIsNotNull() {
            addCriterion("mood_content is not null");
            return (Criteria) this;
        }

        public Criteria andMoodContentEqualTo(String value) {
            addCriterion("mood_content =", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotEqualTo(String value) {
            addCriterion("mood_content <>", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentGreaterThan(String value) {
            addCriterion("mood_content >", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentGreaterThanOrEqualTo(String value) {
            addCriterion("mood_content >=", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLessThan(String value) {
            addCriterion("mood_content <", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLessThanOrEqualTo(String value) {
            addCriterion("mood_content <=", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLike(String value) {
            addCriterion("mood_content like", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotLike(String value) {
            addCriterion("mood_content not like", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentIn(List<String> values) {
            addCriterion("mood_content in", values, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotIn(List<String> values) {
            addCriterion("mood_content not in", values, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentBetween(String value1, String value2) {
            addCriterion("mood_content between", value1, value2, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotBetween(String value1, String value2) {
            addCriterion("mood_content not between", value1, value2, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodPicIsNull() {
            addCriterion("mood_pic is null");
            return (Criteria) this;
        }

        public Criteria andMoodPicIsNotNull() {
            addCriterion("mood_pic is not null");
            return (Criteria) this;
        }

        public Criteria andMoodPicEqualTo(String value) {
            addCriterion("mood_pic =", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotEqualTo(String value) {
            addCriterion("mood_pic <>", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicGreaterThan(String value) {
            addCriterion("mood_pic >", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicGreaterThanOrEqualTo(String value) {
            addCriterion("mood_pic >=", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLessThan(String value) {
            addCriterion("mood_pic <", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLessThanOrEqualTo(String value) {
            addCriterion("mood_pic <=", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLike(String value) {
            addCriterion("mood_pic like", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotLike(String value) {
            addCriterion("mood_pic not like", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicIn(List<String> values) {
            addCriterion("mood_pic in", values, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotIn(List<String> values) {
            addCriterion("mood_pic not in", values, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicBetween(String value1, String value2) {
            addCriterion("mood_pic between", value1, value2, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotBetween(String value1, String value2) {
            addCriterion("mood_pic not between", value1, value2, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorIsNull() {
            addCriterion("mood_author is null");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorIsNotNull() {
            addCriterion("mood_author is not null");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorEqualTo(String value) {
            addCriterion("mood_author =", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorNotEqualTo(String value) {
            addCriterion("mood_author <>", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorGreaterThan(String value) {
            addCriterion("mood_author >", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("mood_author >=", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorLessThan(String value) {
            addCriterion("mood_author <", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorLessThanOrEqualTo(String value) {
            addCriterion("mood_author <=", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorLike(String value) {
            addCriterion("mood_author like", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorNotLike(String value) {
            addCriterion("mood_author not like", value, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorIn(List<String> values) {
            addCriterion("mood_author in", values, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorNotIn(List<String> values) {
            addCriterion("mood_author not in", values, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorBetween(String value1, String value2) {
            addCriterion("mood_author between", value1, value2, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodAuthorNotBetween(String value1, String value2) {
            addCriterion("mood_author not between", value1, value2, "moodAuthor");
            return (Criteria) this;
        }

        public Criteria andMoodDateIsNull() {
            addCriterion("mood_date is null");
            return (Criteria) this;
        }

        public Criteria andMoodDateIsNotNull() {
            addCriterion("mood_date is not null");
            return (Criteria) this;
        }

        public Criteria andMoodDateEqualTo(String value) {
            addCriterion("mood_date =", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotEqualTo(String value) {
            addCriterion("mood_date <>", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateGreaterThan(String value) {
            addCriterion("mood_date >", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateGreaterThanOrEqualTo(String value) {
            addCriterion("mood_date >=", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLessThan(String value) {
            addCriterion("mood_date <", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLessThanOrEqualTo(String value) {
            addCriterion("mood_date <=", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLike(String value) {
            addCriterion("mood_date like", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotLike(String value) {
            addCriterion("mood_date not like", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateIn(List<String> values) {
            addCriterion("mood_date in", values, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotIn(List<String> values) {
            addCriterion("mood_date not in", values, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateBetween(String value1, String value2) {
            addCriterion("mood_date between", value1, value2, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotBetween(String value1, String value2) {
            addCriterion("mood_date not between", value1, value2, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodLikeIsNull() {
            addCriterion("mood_like is null");
            return (Criteria) this;
        }

        public Criteria andMoodLikeIsNotNull() {
            addCriterion("mood_like is not null");
            return (Criteria) this;
        }

        public Criteria andMoodLikeEqualTo(Integer value) {
            addCriterion("mood_like =", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeNotEqualTo(Integer value) {
            addCriterion("mood_like <>", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeGreaterThan(Integer value) {
            addCriterion("mood_like >", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mood_like >=", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeLessThan(Integer value) {
            addCriterion("mood_like <", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeLessThanOrEqualTo(Integer value) {
            addCriterion("mood_like <=", value, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeIn(List<Integer> values) {
            addCriterion("mood_like in", values, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeNotIn(List<Integer> values) {
            addCriterion("mood_like not in", values, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeBetween(Integer value1, Integer value2) {
            addCriterion("mood_like between", value1, value2, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("mood_like not between", value1, value2, "moodLike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeIsNull() {
            addCriterion("mood_dislike is null");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeIsNotNull() {
            addCriterion("mood_dislike is not null");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeEqualTo(Integer value) {
            addCriterion("mood_dislike =", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeNotEqualTo(Integer value) {
            addCriterion("mood_dislike <>", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeGreaterThan(Integer value) {
            addCriterion("mood_dislike >", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mood_dislike >=", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeLessThan(Integer value) {
            addCriterion("mood_dislike <", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeLessThanOrEqualTo(Integer value) {
            addCriterion("mood_dislike <=", value, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeIn(List<Integer> values) {
            addCriterion("mood_dislike in", values, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeNotIn(List<Integer> values) {
            addCriterion("mood_dislike not in", values, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeBetween(Integer value1, Integer value2) {
            addCriterion("mood_dislike between", value1, value2, "moodDislike");
            return (Criteria) this;
        }

        public Criteria andMoodDislikeNotBetween(Integer value1, Integer value2) {
            addCriterion("mood_dislike not between", value1, value2, "moodDislike");
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