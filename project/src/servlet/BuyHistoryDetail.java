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
import dao.UserBuyDetailDAO;

/**
 * Servlet implementation class buyHistoryDetail
 */
@WebServlet("/BuyHistoryDetail")
public class BuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int buyId = Integer.parseInt(request.getParameter("id"));
			ArrayList<ItemBeans> itemList = UserBuyDetailDAO.getUserBuyDetailsByBuyId(buyId);
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher(Helper.BUY_HISTORY_DETAIL_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
