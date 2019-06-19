package jp.co.noticeboard.entity;

import java.util.Date;

public class Comment {
	private Integer id;
	private Integer userId;
	private Integer messageId;
	private String text;
	private Date createdAt;
	private Date updatedAt;

	public Comment() {
	}

	public Comment(Integer id, Integer userId, Integer messageId, String text, Date createdAt, Date updatedAt) {
		this.id = id;
		this.userId = userId;
		this.messageId = messageId;
		this.text = text;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
