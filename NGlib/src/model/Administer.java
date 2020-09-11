package model;

public class Administer {
	private String id;
	private String name;
	private String pass;
	private String loginId;
	@Override
	public String toString() {
		return "Administer [id=" + id + ", name=" + name + ", pass=" + pass + ", loginId=" + loginId + "]";
	}

	public Administer (String name){
		this.name = name;
	}

	public Administer (String loginId, String pass) {
		this.loginId = loginId;
		this.pass = pass;
	}

	public Administer (String id, String adminName, String pass, String loginId) {
		this.id = id;
		this.name = adminName;
		this.pass = pass;
		this.loginId = loginId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getLoginId() {
		return loginId;
	}
}
