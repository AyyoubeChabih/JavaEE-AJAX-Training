package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

public class DaoMediatorJdbc implements DaoMediator {
	private DocumentDoaJdbc documentDao;
	private PublisherDaoJdbc publisherDao;
	private AuthorDaoJdbc authorDao;
	
	public DaoMediatorJdbc() {

	}

	public DocumentDoaJdbc getDocumentDao() {
		return documentDao;
	}
	
	public void setDocumentDao(DocumentDoaJdbc documentDao) {
		this.documentDao = documentDao;
	}

	public PublisherDaoJdbc getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDaoJdbc publisherDao) {
		this.publisherDao = publisherDao;
	}

	public AuthorDaoJdbc getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDaoJdbc authorDao) {
		this.authorDao = authorDao;
	}

	public Document selectDocument(String isbn) {
		return documentDao.selectDocument(isbn);
	}

	public List<Document> selectDocuments() {
		return documentDao.selectDocuments();
	}

	public List<Document> selectDocumentByKeyword(String keyword) {
		return documentDao.selectDocumentByKeyword(keyword);
	}

	public Publisher selectPublisher(int id) {
		return publisherDao.selectPublisher(id);
	}

	public List<Publisher> selectPublishers() {
		return publisherDao.selectPublishers();
	}

	public Author selectAuthor(int id) {
		return authorDao.selectAuthor(id);
	}

	public List<Author> selectAuthors() {
		return authorDao.selectAuthors();
	}

	public List<Author> selectAuthorsByIsbn(String isbn) {
		return authorDao.selectAuthorsByIsbn(isbn);
	}
}
