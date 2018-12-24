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
import dao.ItemDAO;

/**
 * Servlet implementation class AddItemForCart
 */
@WebServlet("/AddItemForCart")
public class AddItemForCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("id"));
			//対象のアイテム情報を取得
			ItemBeans item = ItemDAO.getItemById(id);
			//追加した商品を表示するためリクエストパラメーターにセット
			request.setAttribute("item", item);
			//カートを取得
			ArrayList<ItemBeans> cart = (ArrayList<ItemBeans>) session.getAttribute("cart");
			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemBeans>();
			}
			//カートに商品を追加。
			cart.add(item);
			//カート情報更新
			session.setAttribute("cart", cart);
			//合計金額
			int totalPrice = Helper.getTotalItemPrice(cart);
			request.setAttribute("cartActionMessage", "商品を追加しました");
			request.setAttribute("totalPrice", totalPrice);
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
