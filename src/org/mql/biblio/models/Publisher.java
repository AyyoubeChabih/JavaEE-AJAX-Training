package org.mql.biblio.models;

import java.io.Serializable;

public class Publisher implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String company;
	
	public Publisher() {
		super();
	}

	public Publisher(int id) {
		super();
		this.id = id;
	}

	public Publisher(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
}
