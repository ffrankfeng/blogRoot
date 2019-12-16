package com.fengf.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class ArticlesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticlesExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("uptime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("uptime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(String value) {
            addCriterion("uptime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(String value) {
            addCriterion("uptime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(String value) {
            addCriterion("uptime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(String value) {
            addCriterion("uptime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(String value) {
            addCriterion("uptime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(String value) {
            addCriterion("uptime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLike(String value) {
            addCriterion("uptime like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotLike(String value) {
            addCriterion("uptime not like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<String> values) {
            addCriterion("uptime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<String> values) {
            addCriterion("uptime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(String value1, String value2) {
            addCriterion("uptime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(String value1, String value2) {
            addCriterion("uptime not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andReadingIsNull() {
            addCriterion("reading is null");
            return (Criteria) this;
        }

        public Criteria andReadingIsNotNull() {
            addCriterion("reading is not null");
            return (Criteria) this;
        }

        public Criteria andReadingEqualTo(Integer value) {
            addCriterion("reading =", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotEqualTo(Integer value) {
            addCriterion("reading <>", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingGreaterThan(Integer value) {
            addCriterion("reading >", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingGreaterThanOrEqualTo(Integer value) {
            addCriterion("reading >=", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingLessThan(Integer value) {
            addCriterion("reading <", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingLessThanOrEqualTo(Integer value) {
            addCriterion("reading <=", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingIn(List<Integer> values) {
            addCriterion("reading in", values, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotIn(List<Integer> values) {
            addCriterion("reading not in", values, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingBetween(Integer value1, Integer value2) {
            addCriterion("reading between", value1, value2, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotBetween(Integer value1, Integer value2) {
            addCriterion("reading not between", value1, value2, "reading");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNull() {
            addCriterion("likecount is null");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNotNull() {
            addCriterion("likecount is not null");
            return (Criteria) this;
        }

        public Criteria andLikecountEqualTo(Integer value) {
            addCriterion("likecount =", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotEqualTo(Integer value) {
            addCriterion("likecount <>", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThan(Integer value) {
            addCriterion("likecount >", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("likecount >=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThan(Integer value) {
            addCriterion("likecount <", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThanOrEqualTo(Integer value) {
            addCriterion("likecount <=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountIn(List<Integer> values) {
            addCriterion("likecount in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotIn(List<Integer> values) {
            addCriterion("likecount not in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountBetween(Integer value1, Integer value2) {
            addCriterion("likecount between", value1, value2, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotBetween(Integer value1, Integer value2) {
            addCriterion("likecount not between", value1, value2, "likecount");
            return (Criteria) this;
        }

        public Criteria andDislikeIsNull() {
            addCriterion("dislike is null");
            return (Criteria) this;
        }

        public Criteria andDislikeIsNotNull() {
            addCriterion("dislike is not null");
            return (Criteria) this;
        }

        public Criteria andDislikeEqualTo(Integer value) {
            addCriterion("dislike =", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeNotEqualTo(Integer value) {
            addCriterion("dislike <>", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeGreaterThan(Integer value) {
            addCriterion("dislike >", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dislike >=", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeLessThan(Integer value) {
            addCriterion("dislike <", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeLessThanOrEqualTo(Integer value) {
            addCriterion("dislike <=", value, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeIn(List<Integer> values) {
            addCriterion("dislike in", values, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeNotIn(List<Integer> values) {
            addCriterion("dislike not in", values, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeBetween(Integer value1, Integer value2) {
            addCriterion("dislike between", value1, value2, "dislike");
            return (Criteria) this;
        }

        public Criteria andDislikeNotBetween(Integer value1, Integer value2) {
            addCriterion("dislike not between", value1, value2, "dislike");
            return (Criteria) this;
        }

        public Criteria andCommentcontentIsNull() {
            addCriterion("commentcontent is null");
            return (Criteria) this;
        }

        public Criteria andCommentcontentIsNotNull() {
            addCriterion("commentcontent is not null");
            return (Criteria) this;
        }

        public Criteria andCommentcontentEqualTo(Integer value) {
            addCriterion("commentcontent =", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentNotEqualTo(Integer value) {
            addCriterion("commentcontent <>", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentGreaterThan(Integer value) {
            addCriterion("commentcontent >", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentcontent >=", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentLessThan(Integer value) {
            addCriterion("commentcontent <", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentLessThanOrEqualTo(Integer value) {
            addCriterion("commentcontent <=", value, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentIn(List<Integer> values) {
            addCriterion("commentcontent in", values, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentNotIn(List<Integer> values) {
            addCriterion("commentcontent not in", values, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentBetween(Integer value1, Integer value2) {
            addCriterion("commentcontent between", value1, value2, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andCommentcontentNotBetween(Integer value1, Integer value2) {
            addCriterion("commentcontent not between", value1, value2, "commentcontent");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
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

        public Criteria andToUidEqualTo(String value) {
            addCriterion("to_uid =", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotEqualTo(String value) {
            addCriterion("to_uid <>", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThan(String value) {
            addCriterion("to_uid >", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThanOrEqualTo(String value) {
            addCriterion("to_uid >=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThan(String value) {
            addCriterion("to_uid <", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThanOrEqualTo(String value) {
            addCriterion("to_uid <=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLike(String value) {
            addCriterion("to_uid like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotLike(String value) {
            addCriterion("to_uid not like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidIn(List<String> values) {
            addCriterion("to_uid in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotIn(List<String> values) {
            addCriterion("to_uid not in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidBetween(String value1, String value2) {
            addCriterion("to_uid between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotBetween(String value1, String value2) {
            addCriterion("to_uid not between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNull() {
            addCriterion("catalog is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNotNull() {
            addCriterion("catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogEqualTo(String value) {
            addCriterion("catalog =", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotEqualTo(String value) {
            addCriterion("catalog <>", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThan(String value) {
            addCriterion("catalog >", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("catalog >=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThan(String value) {
            addCriterion("catalog <", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThanOrEqualTo(String value) {
            addCriterion("catalog <=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLike(String value) {
            addCriterion("catalog like", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotLike(String value) {
            addCriterion("catalog not like", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogIn(List<String> values) {
            addCriterion("catalog in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotIn(List<String> values) {
            addCriterion("catalog not in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogBetween(String value1, String value2) {
            addCriterion("catalog between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotBetween(String value1, String value2) {
            addCriterion("catalog not between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andKeyword1IsNull() {
            addCriterion("keyword1 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword1IsNotNull() {
            addCriterion("keyword1 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword1EqualTo(String value) {
            addCriterion("keyword1 =", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotEqualTo(String value) {
            addCriterion("keyword1 <>", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1GreaterThan(String value) {
            addCriterion("keyword1 >", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1GreaterThanOrEqualTo(String value) {
            addCriterion("keyword1 >=", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1LessThan(String value) {
            addCriterion("keyword1 <", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1LessThanOrEqualTo(String value) {
            addCriterion("keyword1 <=", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1Like(String value) {
            addCriterion("keyword1 like", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotLike(String value) {
            addCriterion("keyword1 not like", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1In(List<String> values) {
            addCriterion("keyword1 in", values, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotIn(List<String> values) {
            addCriterion("keyword1 not in", values, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1Between(String value1, String value2) {
            addCriterion("keyword1 between", value1, value2, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotBetween(String value1, String value2) {
            addCriterion("keyword1 not between", value1, value2, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword2IsNull() {
            addCriterion("keyword2 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword2IsNotNull() {
            addCriterion("keyword2 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword2EqualTo(String value) {
            addCriterion("keyword2 =", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotEqualTo(String value) {
            addCriterion("keyword2 <>", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2GreaterThan(String value) {
            addCriterion("keyword2 >", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2GreaterThanOrEqualTo(String value) {
            addCriterion("keyword2 >=", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2LessThan(String value) {
            addCriterion("keyword2 <", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2LessThanOrEqualTo(String value) {
            addCriterion("keyword2 <=", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2Like(String value) {
            addCriterion("keyword2 like", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotLike(String value) {
            addCriterion("keyword2 not like", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2In(List<String> values) {
            addCriterion("keyword2 in", values, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotIn(List<String> values) {
            addCriterion("keyword2 not in", values, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2Between(String value1, String value2) {
            addCriterion("keyword2 between", value1, value2, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotBetween(String value1, String value2) {
            addCriterion("keyword2 not between", value1, value2, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword3IsNull() {
            addCriterion("keyword3 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword3IsNotNull() {
            addCriterion("keyword3 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword3EqualTo(String value) {
            addCriterion("keyword3 =", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotEqualTo(String value) {
            addCriterion("keyword3 <>", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3GreaterThan(String value) {
            addCriterion("keyword3 >", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3GreaterThanOrEqualTo(String value) {
            addCriterion("keyword3 >=", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3LessThan(String value) {
            addCriterion("keyword3 <", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3LessThanOrEqualTo(String value) {
            addCriterion("keyword3 <=", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3Like(String value) {
            addCriterion("keyword3 like", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotLike(String value) {
            addCriterion("keyword3 not like", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3In(List<String> values) {
            addCriterion("keyword3 in", values, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotIn(List<String> values) {
            addCriterion("keyword3 not in", values, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3Between(String value1, String value2) {
            addCriterion("keyword3 between", value1, value2, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotBetween(String value1, String value2) {
            addCriterion("keyword3 not between", value1, value2, "keyword3");
            return (Criteria) this;
        }

        public Criteria andIsopenIsNull() {
            addCriterion("isopen is null");
            return (Criteria) this;
        }

        public Criteria andIsopenIsNotNull() {
            addCriterion("isopen is not null");
            return (Criteria) this;
        }

        public Criteria andIsopenEqualTo(String value) {
            addCriterion("isopen =", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotEqualTo(String value) {
            addCriterion("isopen <>", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenGreaterThan(String value) {
            addCriterion("isopen >", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenGreaterThanOrEqualTo(String value) {
            addCriterion("isopen >=", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenLessThan(String value) {
            addCriterion("isopen <", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenLessThanOrEqualTo(String value) {
            addCriterion("isopen <=", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenLike(String value) {
            addCriterion("isopen like", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotLike(String value) {
            addCriterion("isopen not like", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenIn(List<String> values) {
            addCriterion("isopen in", values, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotIn(List<String> values) {
            addCriterion("isopen not in", values, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenBetween(String value1, String value2) {
            addCriterion("isopen between", value1, value2, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotBetween(String value1, String value2) {
            addCriterion("isopen not between", value1, value2, "isopen");
            return (Criteria) this;
        }

        public Criteria andTopIsNull() {
            addCriterion("top is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("top is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(String value) {
            addCriterion("top =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(String value) {
            addCriterion("top <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(String value) {
            addCriterion("top >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(String value) {
            addCriterion("top >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(String value) {
            addCriterion("top <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(String value) {
            addCriterion("top <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLike(String value) {
            addCriterion("top like", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotLike(String value) {
            addCriterion("top not like", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<String> values) {
            addCriterion("top in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<String> values) {
            addCriterion("top not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(String value1, String value2) {
            addCriterion("top between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(String value1, String value2) {
            addCriterion("top not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andToptimeIsNull() {
            addCriterion("tOPtime is null");
            return (Criteria) this;
        }

        public Criteria andToptimeIsNotNull() {
            addCriterion("tOPtime is not null");
            return (Criteria) this;
        }

        public Criteria andToptimeEqualTo(String value) {
            addCriterion("tOPtime =", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeNotEqualTo(String value) {
            addCriterion("tOPtime <>", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeGreaterThan(String value) {
            addCriterion("tOPtime >", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeGreaterThanOrEqualTo(String value) {
            addCriterion("tOPtime >=", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeLessThan(String value) {
            addCriterion("tOPtime <", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeLessThanOrEqualTo(String value) {
            addCriterion("tOPtime <=", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeLike(String value) {
            addCriterion("tOPtime like", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeNotLike(String value) {
            addCriterion("tOPtime not like", value, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeIn(List<String> values) {
            addCriterion("tOPtime in", values, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeNotIn(List<String> values) {
            addCriterion("tOPtime not in", values, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeBetween(String value1, String value2) {
            addCriterion("tOPtime between", value1, value2, "toptime");
            return (Criteria) this;
        }

        public Criteria andToptimeNotBetween(String value1, String value2) {
            addCriterion("tOPtime not between", value1, value2, "toptime");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
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