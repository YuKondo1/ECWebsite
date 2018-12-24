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
import dao.BrowsingHistoryDAO;
import dao.ItemDAO;

/**
 * Servlet implementation class itemDetail
 */
@WebServlet("/ItemDetail")
public class ItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("id"));
			int userId = (int)session.getAttribute("userId");
			//閲覧履歴を登録
			if (!BrowsingHistoryDAO.isOverlapItemId(userId,id)) {
				BrowsingHistoryDAO.insertBrowsingHistory(userId, id);
			}else {
				BrowsingHistoryDAO.updateBrowsingHistory(userId, id);
			}
			//対象のアイテム情報を取得
			ItemBeans item = ItemDAO.getItemById(id);
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

		doGet(request, response);
	}
}
