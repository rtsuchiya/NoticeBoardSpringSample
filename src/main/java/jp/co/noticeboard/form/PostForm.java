package jp.co.noticeboard.form;

import org.hibernate.validator.constraints.NotEmpty;

public class PostForm {
	@NotEmpty
	private String subject;
	@NotEmpty
	private String text;
	@NotEmpty
	private String category;

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

}
