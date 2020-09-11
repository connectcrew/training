package model;

import java.io.Serializable;

public class VoiceActor implements Serializable {
	private String vaId;
	private String vaName;
	private String nameSpell;
	private String avId;
	private String avName;
	private String gender;
	private String place;
	private String birthday;
	private String blood;
	private String debut;
	private String piId;
	private String title;
	private String count;
	private String aoId;
	@Override
	public String toString() {
		return "VoiceActor [vaId=" + vaId + ", vaName=" + vaName + ", nameSpell=" + nameSpell + ", avId=" + avId
				+ ", avName=" + avName + ", gender=" + gender + ", place=" + place + ", birthday=" + birthday
				+ ", blood=" + blood + ", debut=" + debut + ", piId=" + piId + ", title=" + title + ", count=" + count
				+ ", aoId=" + aoId + "]";
	}


	// for information
	public VoiceActor(String vaId, String vaName, String avId, String avName, String gender, String place, String birthday, String blood,
			String debut, String piId, String title) {
		this.vaId = vaId;
		this.vaName = vaName;
		this.avId = avId;
		this.avName = avName;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.debut = debut;
		this.piId = piId;
		this.title = title;
	}

	// for list
	public VoiceActor(String vaId, String vaName, String avId, String avName, String count) {
		this.vaId = vaId;
		this.vaName = vaName;
		this.avId = avId;
		this.avName = avName;
		this.count = count;
	}

	// for insert/update
	public VoiceActor(String vaId, String vaName, String nameSpell, String gender, String place, String birthday, String blood, String debut, String aoId, String avId) {
		this.vaId = vaId;
		this.vaName = vaName;
		this.nameSpell = nameSpell;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.debut = debut;
		this.aoId = aoId;
		this.avId = avId;
	}



	public String getVaId() {
		return vaId;
	}



	public String getVaName() {
		return vaName;
	}



	public String getNameSpell() {
		return nameSpell;
	}



	public String getAvId() {
		return avId;
	}



	public String getAvName() {
		return avName;
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



	public String getDebut() {
		return debut;
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



	public String getAoId() {
		return aoId;
	}



}