package org.mql.biblio.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {
	private DataSource dataSource;
	private Connection db;
	
	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnecion();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public String[][] executeQuery(String query) {
		try {
			Statement sql = db.createStatement();
			
			// sql.executeUpdate(''); DML -> mise a jour, update insert delete 
			// sql.execute(''); n'import qu'il est la requete mais retoure boolean DDL
			// sql.executeQuery(''); DML -> selection 
			
			ResultSet rs = sql.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			String data[][] = new String[rowCount + 1][columnCount];
			for (int i = 0; i < columnCount; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			int row = 0;
			while(rs.next()) { // rs.privious(), rs.first(), rs.last(), rs.beforeFirst() -> c'est ou on se trouve apres l'execution de la requete, rs.afterLast()
				//System.out.println(rs.getString(2)); // tous les champs sont indexé de 1 est pas de 0
				row++;
				for (int i = 0; i < columnCount; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
			rs.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			return null;
		}
	}
	
	public String[][] selectAll(String tableName) {
		String query = "SELECT * FROM " + tableName;
		return executeQuery(query);
	}
	
	public String[][] selectLike(String tableName, String key, String value) {
		String query = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%'";
		return executeQuery(query);
	}
	
	public String[][] select(String tableName, String key, Object value) {
		String query = "SELECT * FROM " + tableName + " WHERE " + key + "= '" + value + "'";
		return executeQuery(query);
	}
}
