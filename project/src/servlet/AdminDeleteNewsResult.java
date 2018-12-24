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
import beans.NewsBeans;
import dao.NewsDAO;

/**
 * Servlet implementation class AdminDeleteNewsResult
 */
@WebServlet("/AdminDeleteNewsResult")
public class AdminDeleteNewsResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String[] deleteNewsIdList = request.getParameterValues("delete_news_id_list");
			String cartActionMessage = "";
			if (deleteNewsIdList != null) {
				//削除対象のお知らせを削除
				for (String deleteNewsId : deleteNewsIdList) {
					int id = Integer.parseInt(deleteNewsId);
					NewsDAO.deleteNews(id);
				}
				cartActionMessage = "削除しました";
			} else {
				cartActionMessage = "削除する商品が選択されていません";
			}
			request.setAttribute("cartActionMessage", cartActionMessage);
			ArrayList<NewsBeans> newsList = NewsDAO.getAllNews();
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher(Helper.ADMIN_DELETE_NEWS_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
