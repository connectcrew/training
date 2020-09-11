package model;

public class Brand {
	private String brId;
	private String brName;
	private String coId;
	private String coName;
	private String piId;
	private String title;
	private String count;
	@Override
	public String toString() {
		return "Brand [brId=" + brId + ", brName=" + brName + ", coId=" + coId + ", coName=" + coName + ", piId=" + piId
				+ ", title=" + title + ", count=" + count + "]";
	}

	// for info
	public Brand(String brId, String brName, String coId, String coName, String piId, String title) {
		this.brId = brId;
		this.brName = brName;
		this.coId = coId;
		this.coName = coName;
		this.piId = piId;
		this.title = title;
	}

	// for list
	public Brand(String brId, String brName, String coId, String coName, String count) {
		this.brId = brId;
		this.brName = brName;
		this.coId = coId;
		this.coName = coName;
		this.count = count;
	}

	public Brand(String brId, String brName, String coId) {
		this.brId = brId;
		this.brName = brName;
		this.coId = coId;
	}

	public String getBrId() {
		return brId;
	}

	public String getBrName() {
		return brName;
	}

	public String getCoId() {
		return coId;
	}

	public String getCoName() {
		return coName;
	}

	public String getPiId() {
		return piId;
	}

	public String getTitle() {
		return title;
	}

	public String getCount() {
		return count;
	}

}
