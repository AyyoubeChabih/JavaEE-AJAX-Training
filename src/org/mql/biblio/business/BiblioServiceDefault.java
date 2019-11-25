package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.DaoMediator;
import org.mql.biblio.models.Document;

public class BiblioServiceDefault implements BiblioService {
	private DaoMediator dao;
	
	public BiblioServiceDefault() {

	}
	
	public BiblioServiceDefault(DaoMediator dao) {
		super();
		this.dao = dao;
	}
	
	public DaoMediator getDao() {
		return dao;
	}

	public void setDao(DaoMediator dao) {
		this.dao = dao;
	}

	public List<Document> documents() {
		return dao.selectDocuments();
	}

}
