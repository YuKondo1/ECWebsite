package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Helper;
import beans.UserInfoBeans;
import dao.UserInfoDAO;

/**
 * Servlet implementation class userUpdateResult
 */
@WebServlet("/UserUpdateResult")
public class UserUpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// セッション開始
		HttpSession session = request.getSession();
		try {
			// 入力フォームから受け取った値をUserDataBeansにセット
			UserInfoBeans uib = new UserInfoBeans();
			uib.setUpdateUserInfoBeans((int) session.getAttribute("id"), request.getParameter("loginId"), request.getParameter("name"), request.getParameter("password"), request.getParameter("phone"), request.getParameter("postalCode"), request.getParameter("address"), (Date) request.getAttribute("createDate"));
			// 確定ボタンが押されたかを確認する変数
			String action = request.getParameter("action");
			switch (action) {
			// 確定ボタンが押されていなかった場合はセッションに入力内容を保持してユーザー情報画面へ
			case "cancel":
				session.setAttribute("uibUp", uib);
				response.sendRedirect("UserInfo");
				break;
			// アップデート処理
			case "update":
				UserInfoDAO.updateUser(uib);
				request.setAttribute("uib", uib);
				request.getRequestDispatcher(Helper.USER_UPDATE_RESULT_PAGE).forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
