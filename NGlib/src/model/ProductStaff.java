package model;

import java.io.Serializable;

public class ProductStaff implements Serializable{
	private String id;
	private String name;
	@Override
	public String toString() {
		return "ProductStaff [id=" + id + ", name=" + name + "]";
	}


	public ProductStaff(String id, String name) {
		this.id = id;
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}




}
