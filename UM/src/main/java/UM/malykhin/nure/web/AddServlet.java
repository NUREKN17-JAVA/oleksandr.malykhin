package UM.malykhin.nure.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UM.malykhin.nure.User;
import UM.malykhin.nure.db.DaoFactory;
import UM.malykhin.nure.db.DatabaseException;

public class AddServlet extends HttpServlet {

	protected void processUser(User user) throws DatabaseException{
		DaoFactory.getInstance().getUserDao().create(user);
	}
	
	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
		}
	}