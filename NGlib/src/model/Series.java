package model;

public class Series {
	private String piId;
	private String title;
	private String release;
	private String series;
	private String comment;
	private String count;
	@Override
	public String toString() {
		return "Series [piId=" + piId + ", title=" + title + ", release=" + release + ", series=" + series
				+ ", comment=" + comment + ", count=" + count + "]";
	}

	public Series(String piId, String title, String release, String series, String comment) {
		this.piId = piId;
		this.title = title;
		this.release = release;
		this.series = series;
		this.comment = comment;
	}

	public Series(String series, String count) {
		this.series = series;
		this.count = count;
	}

	public String getPiId() {
		return piId;
	}

	public String getTitle() {
		return title;
	}

	public String getRelease() {
		return release;
	}

	public String getSeries() {
		return series;
	}

	public String getComment() {
		return comment;
	}

	public String getCount() {
		return count;
	}


}
