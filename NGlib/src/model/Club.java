package model;

public class Club {
	private String clId;
	private String clName;
	@Override
	public String toString() {
		return "Club [clId=" + clId + ", clName=" + clName + "]";
	}

	public Club(String clId, String clName) {
		this.clId = clId;
		this.clName = clName;
	}

	public String getClId() {
		return clId;
	}

	public String getClName() {
		return clName;
	}


}
