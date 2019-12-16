package com.fengf.blog.pojo;

import java.util.Date;

public class Attention {
    private Integer attentionId;

    private Integer userId;

    private Integer attuserId;

    private String attentionTime;

    private Integer attentionGroup;

    @Override
	public String toString() {
		return "Attention [attentionId=" + attentionId + ", userId=" + userId + ", attuserId=" + attuserId
				+ ", attentionTime=" + attentionTime + ", attentionGroup=" + attentionGroup + "]";
	}

	public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAttuserId() {
        return attuserId;
    }

    public void setAttuserId(Integer attuserId) {
        this.attuserId = attuserId;
    }

    public String getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(String attentionTime) {
        this.attentionTime = attentionTime;
    }

    public Integer getAttentionGroup() {
        return attentionGroup;
    }

    public void setAttentionGroup(Integer attentionGroup) {
        this.attentionGroup = attentionGroup;
    }
}