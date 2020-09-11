package model;

public class Company {
	private String coId;
	private String coName;
	private String year;
	private String address;
	private String brId;
	private String brName;
	private String count;




	@Override
	public String toString() {
		return "Company [coId=" + coId + ", coName=" + coName + ", year=" + year + ", address=" + address + ", brId="
				+ brId + ", brName=" + brName + ", count=" + count + "]";
	}


	// for information page
	public Company(String coId, String coName, String year, String address, String brId, String brName) {
		this.coId = coId;
		this.coName = coName;
		this.year = year;
		this.address = address;
		this.brId = brId;
		this.brName = brName;
	}

	// for list page
	public Company(String coId, String coName, String brId, String brName, String count) {
		this.coId = coId;
		this.coName = coName;
		this.brId = brId;
		this.brName = brName;
		this.count = count;
	}

	// for insert/update
	public Company(String coId, String coName, String year, String address) {
		this.coId = coId;
		this.coName = coName;
		this.year = year;
		this.address = address;
	}



	public String getCoId() {
		return coId;
	}



	public String getCoName() {
		return coName;
	}



	public String getYear() {
		return year;
	}



	public String getAddress() {
		return address;
	}



	public String getBrId() {
		return brId;
	}



	public String getBrName() {
		return brName;
	}



	public String getCount() {
		return count;
	}

}
