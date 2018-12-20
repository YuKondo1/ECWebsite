package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Helper;
import beans.UserInfoBeans;

/**
 * ユーザー情報新規登録
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * ユーザー情報新規登録へ移行
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//入力内容に誤りがあるときはセッションから入力情報を取得
		UserInfoBeans uib = session.getAttribute("uib") != null?(UserInfoBeans) Helper.cutSessionAttribute(session, "uib"):new UserInfoBeans();
		String validationMessage = (String) Helper.cutSessionAttribute(session, "validationMessage");

		request.setAttribute("uib", uib);
		request.setAttribute("validationMessage",validationMessage);

		request.getRequestDispatcher(Helper.USER_REGISTER_PAGE).forward(request, response);
	}
}
