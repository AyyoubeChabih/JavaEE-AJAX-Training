package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;

public interface AuthorDao {
	public Author selectAuthor(int id);
	public List<Author> selectAuthors();
	public List<Author> selectAuthorsByIsbn(String isbn);
}
