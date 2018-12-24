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
import beans.UserBuyBeans;
import beans.UserInfoBeans;
import dao.UserBuyDAO;

/**
 * Servlet implementation class AdminConfirmUserBuy
 */
@WebServlet("/AdminConfirmUserBuy")
public class AdminConfirmUserBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<UserBuyBeans> ubbList = UserBuyDAO.getAllUserBuy();
			request.setAttribute("ubbList", ubbList);
			ArrayList<UserInfoBeans> uibList = new ArrayList<UserInfoBeans>();
			request.getRequestDispatcher(Helper.ADMIN_CONFIRM_USER_BUY_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
