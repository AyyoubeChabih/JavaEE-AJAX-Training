package org.mql.biblio.dao.mappers;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

abstract public class ToStringMapper {
	
	public String map(Author a) {
		return map("", a);
	}
	
	public String map(Document d) {
		return map("", d);
	}
	
	public String map(Publisher p) {
		return map("", p);
	}
	
	abstract public String map(String margin, Author a);
	abstract public String map(String margin, Document d);
	abstract public String map(String margin, Publisher p);
}
