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
import dao.BrowsingHistoryDAO;

/**
 * Servlet implementation class browsingHistory
 */
@WebServlet("/BrowsingHistory")
public class BrowsingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false;
			if(!isLogin) {
				response.sendRedirect("UserRegister");
				return;
			}
			int userId = (int)session.getAttribute("userId");
			ArrayList<ItemBeans> itemList = BrowsingHistoryDAO.getAllItemByUserId(userId);
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher(Helper.BROWSING_HISTORY_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
