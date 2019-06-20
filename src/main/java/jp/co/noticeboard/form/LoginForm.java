package jp.co.noticeboard.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	@Pattern(regexp = "[a-zA-Z0-9]*")
	@Size(min = 6, max = 20)
	private String loginId;
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
