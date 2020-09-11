package model;

public class Year {
	private String year;

	@Override
	public String toString() {
		return "Year [year=" + year + "]";
	}

	public Year(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

}
