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
 * Servlet implementation class userUpdateConfirm
 */
@WebServlet("/UserUpdateConfirm")
public class UserUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*文字化け対策*/
		request.setCharacterEncoding("UTF-8");
		//セッション開始
		HttpSession session = request.getSession();
		try {
			//エラーメッセージを格納する変数
			String validationMessage = "";
			UserInfoBeans uib = new UserInfoBeans();
			uib.setUpdateUserInfoBeans((int) session.getAttribute("id"), request.getParameter("loginId"), request.getParameter("name"), request.getParameter("password"), request.getParameter("phone"), request.getParameter("postalCode"), request.getParameter("address"), (Date) session.getAttribute("createDate"));


			//ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
			if (!Helper.isLoginIdValidation(uib.getLoginId())) {
				validationMessage = "半角英数とハイフン、アンダースコアのみ入力できます";
			}
			//loginIdの重複をチェック
			if ( UserInfoDAO.isOverlapLoginId(uib.getLoginId(),(int) session.getAttribute("id"))) {
				validationMessage = "ほかのユーザーが使用中のログインIDです";
			}
			//バリデーションエラーメッセージがないなら確認画面へ
			if(validationMessage.length() == 0){
				//確認画面へ
				request.setAttribute("uib",uib);
				request.getRequestDispatcher(Helper.USER_UPDATE_CONFIRM_PAGE).forward(request, response);
			}else {
				//セッションにエラーメッセージを持たせてユーザー画面へ
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("UserInfo");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
