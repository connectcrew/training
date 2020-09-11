package model;

import java.io.Serializable;

public class ProductInfo implements Serializable{
	private String piId;
	private String title;
	private String brId;
	private String brand;
	private String release;
	private String series;
	private String engine;
	private String comment;
	private String text;
	private double count;
	@Override
	public String toString() {
		return "ProductInfo [piId=" + piId + ", title=" + title + ", brId=" + brId + ", brand=" + brand + ", release="
				+ release + ", series=" + series + ", engine=" + engine + ", comment=" + comment + ", text=" + text
				+ ", count=" + count + "]";
	}

	// インフォメーション用
	public ProductInfo(String piId, String title, String brId, String brand, String release,
			String series, String engine, String comment, String text) {
		this.piId = piId;
		this.title = title;
		this.brId = brId;
		this.brand = brand;
		this.release = release;
		this.series = series;
		this.engine = engine;
		this.comment = comment;
		this.text = text;
	}

	// リスト用
	public ProductInfo(String piId, String title, String brId, String brand, String release,
			String series, String comment) {
		this.piId = piId;
		this.title = title;
		this.brId = brId;
		this.brand = brand;
		this.release = release;
		this.series = series;
		this.comment = comment;
	}

	// insert/update用
	public ProductInfo(String piId, String title, String brId, String release,
			String series, String engine, String comment, String text) {
		this.piId = piId;
		this.title = title;
		this.brId = brId;
		this.release = release;
		this.series = series;
		this.engine = engine;
		this.comment = comment;
		this.text = text;
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


	public String getBrand() {
		return brand;
	}


	public String getRelease() {
		return release;
	}


	public String getSeries() {
		return series;
	}


	public String getEngine() {
		return engine;
	}


	public String getComment() {
		return comment;
	}


	public String getText() {
		return text;
	}

	public double getCount() {
		return count;
	}


}