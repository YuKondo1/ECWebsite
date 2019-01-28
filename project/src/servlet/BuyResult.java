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
import dao.UserBuyDAO;
import dao.UserBuyDetailDAO;

/**
 * Servlet implementation class buyResult
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int userId = (int)session.getAttribute("userId");
			//買い物かご
			ArrayList<ItemBeans> cartList = (ArrayList<ItemBeans>) session.getAttribute("cart");
			int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

			// 購入情報を登録
			int buyId = UserBuyDAO.insertBuy(userId, totalPrice);
			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ItemBeans cartInItem : cartList) {
				int itemId = cartInItem.getId();
				UserBuyDetailDAO.insertUserBuyDetail(buyId, itemId);
			}
			/* ====購入完了ページ表示用==== */
			request.setAttribute("totalPrice", totalPrice);
			// 購入完了ページ
			session.removeAttribute("cart");
			request.getRequestDispatcher(Helper.BUY_RESULT_PAGE).forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
