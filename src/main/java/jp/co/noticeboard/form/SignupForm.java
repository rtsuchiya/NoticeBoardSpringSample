package jp.co.noticeboard.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import jp.co.noticeboard.form.validator.BranchPositionCombination;
import jp.co.noticeboard.form.validator.ConfirmPassword;

@ConfirmPassword(password = "password", confirmPassword = "confirmPassword")
@BranchPositionCombination(branchId = "branchId", positionId = "positionId")
public class SignupForm {
	@NotEmpty
	@Size(min = 6, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]+")
	private String loginId;
	@NotEmpty
	@Size(min = 6, max = 20)
	private String password;
	private String confirmPassword;
	@NotEmpty
	@Size(min = 1, max = 10)
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
