package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Author;
import org.mql.biblio.jdbc.Database;

public class AuthorDaoJdbc implements AuthorDao{
	private Database db;
	private String tablename = "Authors";
	private String key = "Au_ID";
	private String relationTableName = "Title_Author";
	
	private DaoMediatorJdbc mediator;
	
	public AuthorDaoJdbc() {
		super();
	}

	public AuthorDaoJdbc(Database db) {
		super();
		this.db = db;
	}
	
	public AuthorDaoJdbc(Database db, DaoMediatorJdbc mediator) {
		super();
		this.db = db;
		setMediator(mediator);
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRelationTableName() {
		return relationTableName;
	}

	public void setRelationTableName(String relationTableName) {
		this.relationTableName = relationTableName;
	}

	public Database getDatabase() {
		return db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}
	
	public void setMediator(DaoMediatorJdbc mediator) {
		this.mediator = mediator;
		mediator.setAuthorDao(this);
	}

	public Author selectAuthor(int id) {
		String data[][] = db.select(tablename, key, id);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return BiblioMapper.getAuthor(data[1]);
	}
	
	public List<Author> selectAuthors() {
		String data[][] = db.selectAll(tablename);
		Vector<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			Author a = BiblioMapper.getAuthor( data[i] );
			authors.add(a);
		}
		return authors;
	}

	public List<Author> selectAuthorsByIsbn(String isbn) {
		String data[][] = db.select(relationTableName, "ISBN", isbn); // foreign key
		Vector<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			Author a = selectAuthor(BiblioMapper.getInt(data[i][1]));
			if (a != null) {
				authors.add(a);
			}
		}
		return authors;
	}
}
