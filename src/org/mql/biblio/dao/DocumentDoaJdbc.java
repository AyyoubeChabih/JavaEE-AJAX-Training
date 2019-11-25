package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.jdbc.Database;
import org.mql.biblio.models.Document;

public class DocumentDoaJdbc implements DocumentDao {
	private Database db;
	private String tableName = "Titles";

	private DaoMediatorJdbc mediator;
	
	public DocumentDoaJdbc() {
	}
	
	public DocumentDoaJdbc(Database db) {
		super();
		this.db = db;
	}
	
	public DocumentDoaJdbc(Database db, DaoMediatorJdbc mediator) {
		super();
		this.db = db;
		setMediator(mediator);
	}

	public Database getDatabase() {
		return db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void setMediator(DaoMediatorJdbc mediator) {
		this.mediator = mediator;
		mediator.setDocumentDao(this);
	}

	public Document selectDocument(String isbn) {
		return null;
	}

	public List<Document> selectDocuments() {
		String data[][] = db.selectAll(tableName);
		Vector<Document> documents = new Vector<Document>();
		for (int i = 1; i < data.length; i++) {
			Document doc = BiblioMapper.getDocument(data[i]);
			doc.setPublisher(mediator.selectPublisher(doc.getPublisher().getId()));
			doc.setAuthors(mediator.selectAuthorsByIsbn(doc.getIsbn()));
			documents.add(doc);
		}
		return documents;
	}

	public List<Document> selectDocumentByKeyword(String keyword) {
		
		return null;
	}

}
