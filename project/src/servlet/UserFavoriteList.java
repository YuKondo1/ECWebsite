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
import dao.UserFavoriteDAO;

/**
 * お気に入りへ移行
 */
@WebServlet("/UserFavoriteList")
public class UserFavoriteList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//ログイン中のユーザーIDからお気に入り商品を取得
			int userId = (int)session.getAttribute("userId");
			ArrayList<ItemBeans> itemList = UserFavoriteDAO.getAllItemByUserId(userId);
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher(Helper.USER_FAVORITE_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
