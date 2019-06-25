package jp.co.noticeboard.form;

public class ManagementForm {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIdAsInteger() {
		return Integer.parseInt(id);
	}
}
