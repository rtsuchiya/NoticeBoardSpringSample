package jp.co.noticeboard.entity;

import java.util.Date;

public class Message {
	private Integer id;
	private Integer userId;
	private String userName;
	private String subject;
	private String text;
	private String category;
	private Date createdAt;
	private Date updatedAt;

	public Message() {
	}

	public Message(Integer id, Integer userId, String userName, String subject, String text, String category,
			Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.subject = subject;
		this.text = text;
		this.category = category;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
