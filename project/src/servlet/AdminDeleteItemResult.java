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
 * Servlet implementation class AdminDeleteItemResult
 */
@WebServlet("/AdminDeleteItemResult")
public class AdminDeleteItemResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
			String cartActionMessage = "";
			if (deleteItemIdList != null) {
				//削除対象の商品を削除
				for (String deleteItemId : deleteItemIdList) {
					int id = Integer.parseInt(deleteItemId);
					ItemDAO.deleteItem(id);
				}
				cartActionMessage = "削除しました";
			} else {
				cartActionMessage = "削除する商品が選択されていません";
			}
			request.setAttribute("cartActionMessage", cartActionMessage);
			ArrayList<ItemBeans> itemList = ItemDAO.getAllItem();
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher(Helper.ADMIN_DELETE_ITEM_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
