package model;

public class Prefectures {
	private String id;
	private String prefecture;
	@Override
	public String toString() {
		return "Prefectures [id=" + id + ", prefecture=" + prefecture + "]";
	}


	public Prefectures(String id, String prefecture) {
		this.id = id;
		this.prefecture = prefecture;
	}


	public String getId() {
		return id;
	}


	public String getPrefecture() {
		return prefecture;
	}



}
