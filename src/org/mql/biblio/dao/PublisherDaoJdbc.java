package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.jdbc.Database;
import org.mql.biblio.models.Publisher;

public class PublisherDaoJdbc implements PublisherDao {
	private Database db;
	private String tablename = "Publishers";
	private String key = "Publisher_ID";
	
	private DaoMediatorJdbc mediator;
	
	public PublisherDaoJdbc() {

	}
	
	public PublisherDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public PublisherDaoJdbc(Database db, DaoMediatorJdbc mediator) {
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
	
	public void setMediator(DaoMediatorJdbc mediator) {
		this.mediator = mediator;
		mediator.setPublisherDao(this);
	}
	
	public Publisher selectPublisher(int id) {
		String data[][] = db.select(tablename, key, id);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return BiblioMapper.getPublisher(data[1]);
	}

	public List<Publisher> selectPublishers() {
		String data[][] = db.selectAll(tablename);
		Vector<Publisher> publishers = new Vector<Publisher>();
		for (int i = 1; i < data.length; i++) {
			Publisher p = BiblioMapper.getPublisher( data[i] );
			publishers.add(p);
		}
		return publishers;
	}
}
