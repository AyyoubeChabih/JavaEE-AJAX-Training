package org.mql.biblio.dao.mappers;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

public class XMLMapper extends ToStringMapper {
	
	public XMLMapper() {

	}
	
	public String map(String margin, Author a) {
		String xml = margin + "<author id=\"" + a.getId() + "\">\n"
					+ margin + "\t" + "<name>" + a.getName().replaceAll("&","&amp;") + "</name>\n"
					+ margin + "\t" + "<year-born>" + a.getYearBorn() + "</year-born>\n"
					+ margin + "</author>\n";
		return xml;
	}

	public String map(String margin, Document d) {
		String xml = margin + "<document isbn=\"" + d.getIsbn() + "\">\n"
				+ margin + "\t" + "<title>" + d.getTitle().replaceAll("&","&amp;") + "</title>\n"
				+ margin + "\t" + "<year-published>" + d.getYearPublished() + "</year-published>\n"
				+ map(margin + "\t", d.getPublisher()) + "\n"
				+ mapAuthors(margin + "\t", d.getAuthors()) + "\n"
				+ margin + "</document>\n";
		return xml;
	}

	public String map(String margin, Publisher p) {
		String xml = margin + "<publisher id=\"" + p.getId() + "\">\n"
				+ margin + "\t" + "<name>" + p.getName().replaceAll("&","&amp;") + "</name>\n"
				+ margin + "\t" + "<company>" + p.getCompany().replaceAll("&","&amp;") + "</company>\n"
				+ margin + "</publisher>";
		return xml;
	}
	
	public String mapAuthors(String margin, List<Author> authors) {
		StringBuffer s = new StringBuffer(margin + "<authors>\n");
		for (Author author : authors) {
			s.append(map(margin + "\t", author));
		}
		s.append(margin + "</authors>");
		return s.toString();
	}
	
	public String mapDocuments(String margin, List<Document> documents) {
		StringBuffer s = new StringBuffer(margin + "<documents>\n");
		for (Document document : documents) {
			s.append(map(margin + "\t", document));
		}
		s.append(margin + "</documents>");
		return s.toString();
	}
	
	public String mapPublishers(String margin, List<Publisher> publishers) {
		StringBuffer s = new StringBuffer(margin + "<publihers>\n");
		for (Publisher publisher : publishers) {
			s.append(map(margin + "\t", publisher));
		}
		s.append(margin + "</publihers>");
		return s.toString();
	}
}
