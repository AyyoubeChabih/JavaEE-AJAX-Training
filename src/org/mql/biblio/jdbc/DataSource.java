package org.mql.biblio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	private String url;
	private String driver;
	private String userName;
	private String password;
	
	public DataSource() {
		
	}

	public DataSource(String url, String driver, String userName, String password) {
		super();
		this.url = url;
		this.driver = driver;
		this.userName = userName;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection getConnecion() {
		try {
			// 1. Chargement du Driver
			Class.forName(driver);
			
			// 2. Connexion :
			Connection db = DriverManager.getConnection(url, userName, password);
			System.out.println("Connexion bien établie!");
			return db;
		} 
		catch (Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
	}
}
