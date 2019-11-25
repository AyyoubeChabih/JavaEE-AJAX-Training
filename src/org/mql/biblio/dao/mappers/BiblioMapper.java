package org.mql.biblio.dao.mappers;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

public class BiblioMapper {

	public static Author getAuthor(String ...row) {
		Author a = new Author();
		a.setName(row[1]);
		a.setId(getInt(row[0]));
		a.setYearBorn(getInt(row[2]));
		return a;
	}
	
	public static Document getDocument(String ...row) {
		Document d = new Document();
		d.setIsbn(row[0]);
		d.setTitle(row[1]);
		d.setYearPublished(getInt(row[2]));
		d.setPublisher(new Publisher(getInt(row[3])));
		return d;
	}
	
	public static Publisher getPublisher(String ...row) {
		Publisher p = new Publisher();
		p.setId(getInt(row[0]));
		p.setName(row[1]);
		p.setCompany(row[2]);
		return p;
	}
	
	public static int getInt(String data) {
		try {
			return Integer.parseInt(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
