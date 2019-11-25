package org.mql.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.business.BiblioServiceDefault;
import org.mql.biblio.dao.AuthorDaoJdbc;
import org.mql.biblio.dao.DaoMediatorJdbc;
import org.mql.biblio.dao.DocumentDoaJdbc;
import org.mql.biblio.dao.PublisherDaoJdbc;
import org.mql.biblio.dao.mappers.XMLMapper;
import org.mql.biblio.jdbc.DataSource;
import org.mql.biblio.jdbc.Database;
import org.mql.biblio.jdbc.MySQLDataSource;
import org.mql.biblio.models.Document;


public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String xml;
	
    public void init() throws ServletException {
    	System.out.println("hello");

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (uri.endsWith("ajax/test")) {
			System.out.println(xml);
			response.getWriter().println(xml);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
