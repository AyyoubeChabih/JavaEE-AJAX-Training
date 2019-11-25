package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Document;

public interface DocumentDao {
	public Document selectDocument(String isbn);
	public List<Document> selectDocuments();
	public List<Document> selectDocumentByKeyword(String keyword);
}
