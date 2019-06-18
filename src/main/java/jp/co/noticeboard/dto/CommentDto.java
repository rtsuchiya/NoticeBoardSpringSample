package jp.co.noticeboard.dto;

public class CommentDto {
	private Integer userId;
	private Integer messageId;
	private String text;

	public CommentDto(Integer userId, Integer messageId, String text) {
		super();
		this.userId = userId;
		this.messageId = messageId;
		this.text = text;
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
}
