package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Publisher;

public interface PublisherDao {
	public Publisher selectPublisher(int id);
	public List<Publisher> selectPublishers();
}
