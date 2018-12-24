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
 * Servlet implementation class CartDeleteItem
 */
@WebServlet("/CartDeleteItem")
public class CartDeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
			ArrayList<ItemBeans> cart = (ArrayList<ItemBeans>) session.getAttribute("cart");
			String cartActionMessage = "";
			if (deleteItemIdList != null) {
				//削除対象の商品を削除
				for (String deleteItemId : deleteItemIdList) {
					for (ItemBeans cartInItem : cart) {
						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
							cart.remove(cartInItem);
							break;
						}
					}
				}
				cartActionMessage = "削除しました";
			} else {
				cartActionMessage = "削除する商品が選択されていません";
			}
			//買い物かご
			ArrayList<ItemBeans> cartList = (ArrayList<ItemBeans>) session.getAttribute("cart");
			int totalPrice = Helper.getTotalItemPrice(cartList);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("cartActionMessage", cartActionMessage);
			request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
