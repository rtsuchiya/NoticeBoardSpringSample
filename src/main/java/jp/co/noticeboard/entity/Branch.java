package jp.co.noticeboard.entity;

public class Branch {
	private Integer id;
	private String name;

	public Branch(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Branch() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
