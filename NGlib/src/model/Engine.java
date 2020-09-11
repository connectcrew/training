package model;

public class Engine {
	private String piId;
	private String title;
	private String brId;
	private String brName;
	private String release;
	private String engine;
	private String count;
	@Override
	public String toString() {
		return "Engine [piId=" + piId + ", title=" + title + ", brId=" + brId + ", brName=" + brName + ", release="
				+ release + ", engine=" + engine + ", count=" + count + "]";
	}


	// for info
	public Engine(String piId, String title, String brId, String brName, String release, String engine) {
		this.piId = piId;
		this.title = title;
		this.brId = brId;
		this.brName = brName;
		this.release = release;
		this.engine = engine;
	}

	// for list
	public Engine(String engine, String count) {
		this.engine = engine;
		this.count = count;
	}



	public String getPiId() {
		return piId;
	}


	public String getTitle() {
		return title;
	}



	public String getBrId() {
		return brId;
	}


	public String getBrName() {
		return brName;
	}

	public String getRelease() {
		return release;
	}

	public String getEngine() {
		return engine;
	}

	public String getCount() {
		return count;
	}


}
