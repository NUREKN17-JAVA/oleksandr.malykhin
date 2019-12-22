package UM.malykhin.nure.web;

import javax.servlet.http.HttpServlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UM.malykhin.nure.User;
import UM.malykhin.nure.db.DaoFactory;
import UM.malykhin.nure.db.DatabaseException;

import java.io.IOException;
import java.util.Collection;

public class BrowseServlet extends HttpServlet {

	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		if (req.getParameter("add") != null) {
	           add(req, resp);
	       } else if (req.getParameter("edit") != null) {
	           edit(req, resp);
	       } else if (req.getParameter("delete") != null) {
	           delete(req, resp);
	       } else if (req.getParameter("details") != null) {
	           details(req, resp);
	       } else {
	           browse(req, resp);
	       }
		browse (req, resp);
	
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		if (idStr == null || idStr.trim().length() == 0) {
	           req.setAttribute("error", "Select a user");
	           req.getRequestDispatcher("/browse.jsp").forward(req, resp);
	           return;
	       }
	       try {
	           User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
	           req.getSession().setAttribute("user", user);
	       } catch (Exception e) {
	           req.setAttribute("error", "Error in the database: " + e.toString());
	           req.getRequestDispatcher("/browse.jsp").forward(req, resp);
	           return;
	       }
	       req.getRequestDispatcher("/edit").forward(req, resp);
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add").forward(req, resp);
		
	}

	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection users;
		try {
			users = DaoFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute("users", users);
			req.getRequestDispatcher("/browse.jap").forward(req, resp);
		} catch (DatabaseException e) {
			throw new ServletException(e);
		}
		
	}
	
	
}