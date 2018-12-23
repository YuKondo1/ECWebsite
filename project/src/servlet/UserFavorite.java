package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Helper;
import beans.ItemBeans;
import dao.ItemDAO;
import dao.UserFavoriteDAO;

/**
 * Servlet implementation class userFavorite
 */
@WebServlet("/UserFavorite")
public class UserFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//ユーザーIDと商品IDを取得
			int userId = (int)session.getAttribute("userId");
			int itemId = Integer.parseInt(request.getParameter("id"));
			//お気に入り登録
			UserFavoriteDAO.insertUserFavorite(userId, itemId);
			//対象のアイテム情報を取得
			ItemBeans item = ItemDAO.getItemById(itemId);
			//リクエストパラメーターにセット
			request.setAttribute("item", item);
			request.getRequestDispatcher(Helper.ITEM_DETAIL_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
