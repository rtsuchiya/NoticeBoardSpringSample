package jp.co.noticeboard.form;

import javax.validation.constraints.Pattern;

public class LoginForm {
	@Pattern(regexp = "[a-zA-Z0-9]{6,20}")
	private String loginId;
	@Pattern(regexp = ".{6,20}")
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
