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
import beans.UserInfoBeans;
import dao.UserBuyDAO;
import dao.UserBuyDetailDAO;
import dao.UserInfoDAO;

/**
 * Servlet implementation class AdminConfirmUserBuyDetail
 */
@WebServlet("/AdminConfirmUserBuyDetail")
public class AdminConfirmUserBuyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			ArrayList<ItemBeans> itemList = UserBuyDetailDAO.getUserBuyDetailsByBuyId(id);
			request.setAttribute("itemList", itemList);
			int userId = UserBuyDAO.getUserIdByItemId(id);
			request.setAttribute("userId", userId);
			UserInfoBeans uib = UserInfoDAO.getUserInfoByUserId(userId);
			request.setAttribute("uib", uib);
			request.getRequestDispatcher(Helper.ADMIN_CONFIRM_USER_BUY_DETAIL_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
