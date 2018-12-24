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
 * Servlet implementation class userRegisterResult
 */
@WebServlet("/UserRegisterResult")
public class UserRegisterResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String inputLoginId = request.getParameter("loginId");
			String inputName = request.getParameter("name");
			String inputPassword = request.getParameter("password");
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

			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirmed");
			switch (confirmed) {
			case "cancel":
				session.setAttribute("uib", uib);
				response.sendRedirect("UserRegister");
				break;
			case "UserRegister":
				UserInfoDAO.insertUser(uib);
				request.setAttribute("uib", uib);
				request.getRequestDispatcher(Helper.USER_REGISTER_RESULT_PAGE).forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
