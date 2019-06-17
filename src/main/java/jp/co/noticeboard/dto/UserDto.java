package jp.co.noticeboard.dto;

public class UserDto {
	private Integer id;
	private String loginId;
	private String password;
	private String name;
	private Integer branchId;
	private Integer positionId;
	private Integer isWorking;

	public UserDto(Integer id, String loginId, String password, String name, Integer branchId, Integer positionId,
			Integer isWorking) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.branchId = branchId;
		this.positionId = positionId;
		this.isWorking = isWorking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Integer isWorking) {
		this.isWorking = isWorking;
	}
}
