package model;

public class AffilicationOffice {
	private String aoId;
	private String aoName;
	private String avId;
	private String avName;
	private String count;
	@Override
	public String toString() {
		return "AffilicationOffice [aoId=" + aoId + ", aoName=" + aoName + ", avId=" + avId + ", avName=" + avName
				+ ", count=" + count + "]";
	}

	public AffilicationOffice(String aoId, String aoName, String avId, String avName) {
		this.aoId = aoId;
		this.aoName = aoName;
		this.avId = avId;
		this.avName = avName;
	}

	public AffilicationOffice(String aoId, String aoName, String count) {
		this.aoId = aoId;
		this.aoName = aoName;
		this.count = count;
	}

	public AffilicationOffice(String aoId, String aoName) {
		this.aoId = aoId;
		this.aoName = aoName;
	}

	public String getAoId() {
		return aoId;
	}

	public String getAoName() {
		return aoName;
	}

	public String getAvId() {
		return avId;
	}

	public String getAvName() {
		return avName;
	}

	public String getCount() {
		return count;
	}


}
