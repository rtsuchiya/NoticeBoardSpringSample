package jp.co.noticeboard.dto;

import java.util.Date;

public class CommentDto {
	private Integer id;
	private Integer userId;
	private String userName;
	private Integer messageId;
	private String text;
	private Date createdAt;

	public CommentDto(Integer id, Integer userId, String userName, Integer messageId, String text, Date createdAt) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.messageId = messageId;
		this.text = text;
		this.createdAt = createdAt;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
}
