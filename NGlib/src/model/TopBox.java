package model;

import java.io.Serializable;

public class TopBox implements Serializable{
	private String id;
	private String name;
	private String count;
	@Override
	public String toString() {
		return "TopBox [id=" + id + ", name=" + name + ", count=" + count + "]";
	}


	public TopBox(String id, String name, String count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getCount() {
		return count;
	}


}