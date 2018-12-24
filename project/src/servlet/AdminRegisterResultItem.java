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
import dao.ItemDAO;

/**
 * Servlet implementation class AdminRegisterResultItem
 */
@WebServlet("/AdminRegisterResultItem")
public class AdminRegisterResultItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String inputName = request.getParameter("name");
			String inputPriceS = request.getParameter("price");
			int inputPrice = Integer.parseInt(inputPriceS);
			String inputItemDetail = request.getParameter("itemDetail");
			String inputImage = request.getParameter("image");

			ItemBeans ib = new ItemBeans();

			ib.setName(inputName);
			ib.setPrice(inputPrice);
			ib.setItemDetail(inputItemDetail);
			ib.setImage(inputImage);

			ItemDAO.setItem(ib);
			request.setAttribute("item", ib);
			request.getRequestDispatcher(Helper.ITEM_DETAIL_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
