package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Helper;
import beans.ItemBeans;
import beans.NewsBeans;
import dao.ItemDAO;
import dao.NewsDAO;

/**
 * Servlet implementation class AdminRegisterResultNews
 */
@WebServlet("/AdminRegisterResultNews")
public class AdminRegisterResultNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String inputInfo = request.getParameter("info");

			NewsDAO.setNews(inputInfo);

			ArrayList<NewsBeans> newsList = NewsDAO.getAllNews();
			request.setAttribute("newsList", newsList);

			ArrayList<ItemBeans> itemList = ItemDAO.getAllItem();
			request.setAttribute("itemList", itemList);

			request.getRequestDispatcher(Helper.INDEX_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
