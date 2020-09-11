package model;

import java.io.Serializable;

public class AnimationVA implements Serializable {
	private String avId;
	private String avName;
	private String nameSpell;
	private String gender;
	private String place;
	private String birthday;
	private String blood;
	private String debut;
	private String aoId;
	private String aoName;
	private String vaId;
	private String vaName;
	private String count;
	@Override
	public String toString() {
		return "AnimationVA [avId=" + avId + ", avName=" + avName + ", nameSpell=" + nameSpell + ", gender=" + gender
				+ ", place=" + place + ", birthday=" + birthday + ", blood=" + blood + ", debut=" + debut + ", aoId="
				+ aoId + ", aoName=" + aoName + ", vaId=" + vaId + ", vaName=" + vaName + ", count=" + count + "]";
	}



	public AnimationVA(String avId, String avName, String gender, String place, String birthday, String blood, String debut, String aoId,
			String aoName, String vaId, String vaName) {
		this.avId = avId;
		this.avName = avName;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.debut = debut;
		this.aoId = aoId;
		this.aoName = aoName;
		this.vaId = vaId;
		this.vaName = vaName;
	}

	public AnimationVA(String avId, String avName, String aoId, String aoName, String count) {
		this.avId = avId;
		this.avName = avName;
		this.aoId = aoId;
		this.aoName = aoName;
		this.count = count;
	}

	public AnimationVA(String avId, String avName) {
		this.avId = avId;
		this.avName = avName;
	}


	// for insert/update
	public AnimationVA(String avId, String avName, String nameSpell, String gender, String place, String birthday, String blood, String debut, String aoId) {
		this.avId = avId;
		this.avName = avName;
		this.nameSpell = nameSpell;
		this.gender = gender;
		this.place = place;
		this.birthday = birthday;
		this.blood = blood;
		this.debut = debut;
		this.aoId = aoId;
	}


	public String getAvId() {
		return avId;
	}


	public String getAvName() {
		return avName;
	}


	public String getNameSpell() {
		return nameSpell;
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



	public String getAoId() {
		return aoId;
	}



	public String getAoName() {
		return aoName;
	}



	public String getVaId() {
		return vaId;
	}



	public String getVaName() {
		return vaName;
	}



	public String getCount() {
		return count;
	}


}