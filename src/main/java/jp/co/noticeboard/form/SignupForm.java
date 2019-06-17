package jp.co.noticeboard.form;

import javax.validation.constraints.Pattern;

public class SignupForm {
	@Pattern(regexp = "[a-zA-Z0-9]{6,20}")
	private String loginId;
	@Pattern(regexp = ".{6,20}")
	private String password;
	@Pattern(regexp = ".{6,20}")
	private String confirmPassword;
	@Pattern(regexp = ".{1,10}")
	private String accountName;
	private Integer branchId;
	private Integer positionId;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
}
