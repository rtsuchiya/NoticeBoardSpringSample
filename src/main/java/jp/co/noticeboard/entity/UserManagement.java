package jp.co.noticeboard.entity;

public class UserManagement {
	private Integer id;
	private String loginId;
	private String name;
	private Integer branchId;
	private String branchName;
	private Integer positionId;
	private String positionName;
	private Integer isWorking;

	public UserManagement() {
	}

	public UserManagement(Integer id, String loginId, String name, Integer branchId, String branchName,
			Integer positionId, String positionName, Integer isWorking) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.branchId = branchId;
		this.branchName = branchName;
		this.positionId = positionId;
		this.positionName = positionName;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Integer isWorking) {
		this.isWorking = isWorking;
	}

}
