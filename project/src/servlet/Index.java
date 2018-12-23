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
import beans.NewsBeans;
import dao.ItemDAO;
import dao.NewsDAO;
import dao.UserInfoDAO;

/**
 * Servlet implementation class index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログインセッション、お知らせ情報、商品情報を取得し、TOPページへ移行
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<NewsBeans> newsList = NewsDAO.getAllNews();
			request.setAttribute("newsList", newsList);

			ArrayList<ItemBeans> itemList = ItemDAO.getAllItem();
			request.setAttribute("itemList", itemList);

			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}

			request.getRequestDispatcher(Helper.INDEX_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * ログイン情報を確認し、再びTOPページに移行
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			//パラメーターから取得
			String loginId = request.getParameter("login_id");
			String password = request.getParameter("password");
			//ユーザーIDを取得
			int userId = UserInfoDAO.getUserId(loginId, password);
			//ユーザーIDが取得できたなら
			if (userId != 0) {
				session.setAttribute("isLogin", true);
				session.setAttribute("userId", userId);
				//ログイン前のページを取得
				String returnStrUrl = (String) Helper.cutSessionAttribute(session, "returnStrUrl");
				//ログイン前ページにリダイレクト。指定がない場合Index
				response.sendRedirect(returnStrUrl!=null?returnStrUrl:"Index");
			} else {
				session.setAttribute("loginId", loginId);
				session.setAttribute("loginErrorMessage", "入力内容が正しくありません");
				response.sendRedirect("Index");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
