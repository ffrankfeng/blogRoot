package com.fengf.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class ArticlecommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticlecommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNull() {
            addCriterion("topic_type is null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNotNull() {
            addCriterion("topic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeEqualTo(String value) {
            addCriterion("topic_type =", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotEqualTo(String value) {
            addCriterion("topic_type <>", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThan(String value) {
            addCriterion("topic_type >", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("topic_type >=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThan(String value) {
            addCriterion("topic_type <", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThanOrEqualTo(String value) {
            addCriterion("topic_type <=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLike(String value) {
            addCriterion("topic_type like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotLike(String value) {
            addCriterion("topic_type not like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIn(List<String> values) {
            addCriterion("topic_type in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotIn(List<String> values) {
            addCriterion("topic_type not in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeBetween(String value1, String value2) {
            addCriterion("topic_type between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotBetween(String value1, String value2) {
            addCriterion("topic_type not between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNull() {
            addCriterion("from_uid is null");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNotNull() {
            addCriterion("from_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFromUidEqualTo(Integer value) {
            addCriterion("from_uid =", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotEqualTo(Integer value) {
            addCriterion("from_uid <>", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThan(Integer value) {
            addCriterion("from_uid >", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_uid >=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThan(Integer value) {
            addCriterion("from_uid <", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThanOrEqualTo(Integer value) {
            addCriterion("from_uid <=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIn(List<Integer> values) {
            addCriterion("from_uid in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotIn(List<Integer> values) {
            addCriterion("from_uid not in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidBetween(Integer value1, Integer value2) {
            addCriterion("from_uid between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotBetween(Integer value1, Integer value2) {
            addCriterion("from_uid not between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andToUidIsNull() {
            addCriterion("to_uid is null");
            return (Criteria) this;
        }

        public Criteria andToUidIsNotNull() {
            addCriterion("to_uid is not null");
            return (Criteria) this;
        }

        public Criteria andToUidEqualTo(Integer value) {
            addCriterion("to_uid =", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotEqualTo(Integer value) {
            addCriterion("to_uid <>", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThan(Integer value) {
            addCriterion("to_uid >", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_uid >=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThan(Integer value) {
            addCriterion("to_uid <", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThanOrEqualTo(Integer value) {
            addCriterion("to_uid <=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidIn(List<Integer> values) {
            addCriterion("to_uid in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotIn(List<Integer> values) {
            addCriterion("to_uid not in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidBetween(Integer value1, Integer value2) {
            addCriterion("to_uid between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotBetween(Integer value1, Integer value2) {
            addCriterion("to_uid not between", value1, value2, "toUid");
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

        public Criteria andFromUsernameIsNull() {
            addCriterion("from_username is null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIsNotNull() {
            addCriterion("from_username is not null");
            return (Criteria) this;
        }

        public Criteria andFromUsernameEqualTo(String value) {
            addCriterion("from_username =", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotEqualTo(String value) {
            addCriterion("from_username <>", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThan(String value) {
            addCriterion("from_username >", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("from_username >=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThan(String value) {
            addCriterion("from_username <", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLessThanOrEqualTo(String value) {
            addCriterion("from_username <=", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameLike(String value) {
            addCriterion("from_username like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotLike(String value) {
            addCriterion("from_username not like", value, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameIn(List<String> values) {
            addCriterion("from_username in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotIn(List<String> values) {
            addCriterion("from_username not in", values, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameBetween(String value1, String value2) {
            addCriterion("from_username between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andFromUsernameNotBetween(String value1, String value2) {
            addCriterion("from_username not between", value1, value2, "fromUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameIsNull() {
            addCriterion("to_username is null");
            return (Criteria) this;
        }

        public Criteria andToUsernameIsNotNull() {
            addCriterion("to_username is not null");
            return (Criteria) this;
        }

        public Criteria andToUsernameEqualTo(String value) {
            addCriterion("to_username =", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotEqualTo(String value) {
            addCriterion("to_username <>", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameGreaterThan(String value) {
            addCriterion("to_username >", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("to_username >=", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLessThan(String value) {
            addCriterion("to_username <", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLessThanOrEqualTo(String value) {
            addCriterion("to_username <=", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameLike(String value) {
            addCriterion("to_username like", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotLike(String value) {
            addCriterion("to_username not like", value, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameIn(List<String> values) {
            addCriterion("to_username in", values, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotIn(List<String> values) {
            addCriterion("to_username not in", values, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameBetween(String value1, String value2) {
            addCriterion("to_username between", value1, value2, "toUsername");
            return (Criteria) this;
        }

        public Criteria andToUsernameNotBetween(String value1, String value2) {
            addCriterion("to_username not between", value1, value2, "toUsername");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(String value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(String value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(String value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(String value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(String value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLike(String value) {
            addCriterion("comment_time like", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotLike(String value) {
            addCriterion("comment_time not like", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<String> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<String> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(String value1, String value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(String value1, String value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
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