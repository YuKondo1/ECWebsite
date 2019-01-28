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
 * Servlet implementation class buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
			if(!isLogin) {
				response.sendRedirect("UserRegister");
				return;
			}
			ArrayList<ItemBeans> cart = (ArrayList<ItemBeans>) session.getAttribute("cart");
			if (!isLogin) {
				// Login画面にリダイレクト
				response.sendRedirect("Login");
			} else if (cart.size() == 0) {
				request.setAttribute("cartActionMessage", "購入する商品がありません");
				request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
			} else {
				int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
				request.setAttribute("totalPrice", totalPrice);
				request.getRequestDispatcher(Helper.BUY_PAGE).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
