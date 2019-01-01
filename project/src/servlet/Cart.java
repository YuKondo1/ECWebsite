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
 * Servlet implementation class cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<ItemBeans> cart = (ArrayList<ItemBeans>) session.getAttribute("cart");
			//買い物かご
			ArrayList<ItemBeans> cartList = cart;
			//合計金額
			if(cartList != null) {
			int totalPrice = Helper.getTotalItemPrice(cartList);
			request.setAttribute("totalPrice", totalPrice);
			}
			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemBeans>();
				session.setAttribute("cart", cart);
			}
			String cartActionMessage = "";
			//カートに商品が入っていないなら
			if(cart.size() == 0) {
				cartActionMessage = "カートに商品がありません";
			}
			request.setAttribute("cartActionMessage", cartActionMessage);
			request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
