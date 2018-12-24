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

/**
 * Servlet implementation class buyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int userId = (int)session.getAttribute("userId");
			//買い物かご
			ArrayList<ItemBeans> cartList = (ArrayList<ItemBeans>) session.getAttribute("cart");
			//合計金額
			int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher(Helper.BUY_CONFIRM_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
