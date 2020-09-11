package model;

import java.io.Serializable;

public class Creator implements Serializable {
	private String crId;
	private String name;
	private String gender;
	private String place;
	private String birthday;
	private String blood;
	private String brId;
	private String brand;
	private String clId;
	private String club;
	private String piId;
	private String title;
	private String count;
	@Override
	public String toString() {
		return "Creator [crId=" + crId + ", name=" + name + ", gender=" + gender + ", place=" + place + ", birthday="
				+ birthday + ", blood=" + blood + ", brId=" + brId + ", brand=" + brand + ", clId=" + clId + ", club="
				+ club + ", piId=" + piId + ", title=" + title + ", count=" + count + "]";
	}

	// for info
	public Creator(String crId, String name, String gender, String place, String birthday, String blood,
			String brId, String brand, String clId, String club, String piId, String title) {
		this.crId = crId;
		this.name = name;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.brId = brId;
		this.brand = brand;
		this.clId = clId;
		this.club = club;
		this.piId = piId;
		this.title = title;
	}

	//for list
	public Creator(String crId, String name, String brId, String brand, String clId, String club, String count) {
		this.crId = crId;
		this.name = name;
		this.brId = brId;
		this.brand = brand;
		this.clId = clId;
		this.club = club;
		this.count = count;
	}

	// for insert product_xx
	public Creator(String piId, String crId) {
		this.piId = piId;
		this.crId = crId;
	}

	// for insert creators
	public Creator(String crId, String name, String gender, String place, String birthday, String blood,
			String brId, String clId) {
		this.crId = crId;
		this.name = name;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.brId = brId;
		this.clId = clId;
	}

	public String getCrId() {
		return crId;
	}


	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}


	public String getPlace() {
		return place;
	}


	public String getBirthday() {
		return birthday;
	}


	public String getBlood() {
		return blood;
	}


	public String getBrId() {
		return brId;
	}


	public String getBrand() {
		return brand;
	}


	public String getClId() {
		return clId;
	}


	public String getClub() {
		return club;
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