package org.mql.biblio.console;

import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.business.BiblioServiceDefault;
import org.mql.biblio.dao.AuthorDaoJdbc;
import org.mql.biblio.dao.DaoMediator;
import org.mql.biblio.dao.DaoMediatorJdbc;
import org.mql.biblio.dao.DocumentDoaJdbc;
import org.mql.biblio.dao.PublisherDaoJdbc;
import org.mql.biblio.dao.mappers.XMLMapper;
import org.mql.biblio.jdbc.DataSource;
import org.mql.biblio.jdbc.Database;
import org.mql.biblio.jdbc.MySQLDataSource;

public class Examples {
	public Examples() {
		exp05();
	}
	
	public void exp01() {
		DataSource ds = new MySQLDataSource("localhost", "Biblio", "root", "");
		ds.getConnecion();
	}
	
	public void exp02() {
		DataSource ds = new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		String[][] data = db.executeQuery("SELECT *  FROM Authors WHERE Year_Born > 0");
		print(data);
	}
	
	public void exp03() {
		DataSource ds = new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		String[][] data = db.selectAll("titles");
		print(data);
	}
	
	public void exp04() {
		DataSource ds = new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		String[][] data = db.selectLike("titles", "title", "java");
		print(data);
	}
	
	public void exp05() {
		DataSource ds = new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		DaoMediatorJdbc daoMediator = new DaoMediatorJdbc();
		
		new DocumentDoaJdbc(db, daoMediator);
		new AuthorDaoJdbc(db, daoMediator);
		new PublisherDaoJdbc(db, daoMediator);
		
		BiblioService service = new BiblioServiceDefault(daoMediator);
		XMLMapper mapper = new XMLMapper();
		String xml = mapper.mapDocuments("", service.documents());
		try {
			PrintWriter out = new PrintWriter("resources/documents.xml");
			out.println(xml);
			out.close();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		System.out.println("Opération terminée");
	}
	
	public void print(String[][] data) {
		JTable table = new JTable(data, data[0]);
		JFrame f = new JFrame();
		f.setContentPane(new JScrollPane(table));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}
