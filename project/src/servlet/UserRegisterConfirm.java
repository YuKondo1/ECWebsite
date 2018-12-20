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
import dao.UserInfoDAO;

/**
 * Servlet implementation class userRegisterConfirm
 */
@WebServlet("/UserRegisterConfirm")
public class UserRegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterConfirm() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String inputLoginId = request.getParameter("loginId");
			String inputName = request.getParameter("name");
			String inputPassword = request.getParameter("password");
			String inputPasswordConfirm = request.getParameter("PasswordConfirm");
			String inputPhone = request.getParameter("phone");
			String inputPostalCode = request.getParameter("postalCode");
			String inputAddress = request.getParameter("address");

			UserInfoBeans uib = new UserInfoBeans();
			uib.setLoginId(inputLoginId);
			uib.setName(inputName);
			uib.setPassword(inputPassword);
			uib.setPhone(inputPhone);
			uib.setPostalCode(inputPostalCode);
			uib.setAddress(inputAddress);


			String validationMessage = "";

			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputPasswordConfirm)) {
				validationMessage += "入力されているパスワードと確認用パスワードが違います<br>";
			}

			// ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
			if (!Helper.isLoginIdValidation(uib.getLoginId())) {
				validationMessage += "半角英数とハイフン、アンダースコアのみ入力できます";
			}
			// loginIdの重複をチェック
			if (UserInfoDAO.isOverlapLoginId(uib.getLoginId(), 0)) {
				validationMessage += "ほかのユーザーが使用中のログインIDです";
			}

			// バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				request.setAttribute("uib", uib);
				request.getRequestDispatcher(Helper.USER_REGISTER_CONFIRM_PAGE).forward(request, response);
			} else {
				session.setAttribute("uib", uib);
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("UserRegister");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
