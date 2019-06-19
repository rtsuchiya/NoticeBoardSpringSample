package jp.co.noticeboard.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class PostForm {
	@NotBlank
	@Length(max = 30)
	private String subject;
	@NotBlank
	@Length(max = 1000)
	private String text;
	@NotBlank
	@Length(max = 10)
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
