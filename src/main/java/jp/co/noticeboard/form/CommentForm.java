package jp.co.noticeboard.form;

import org.hibernate.validator.constraints.NotBlank;

public class CommentForm {
	@NotBlank
	private String text;
	private Integer messageId;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
}
