package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import base.Helper;
import beans.ItemBeans;
import dao.ItemDAO;


/**
 * Servlet implementation class AdminRegisterResultItem
 */
@WebServlet("/AdminRegisterResultItem")
@MultipartConfig(location="/tmp")
public class AdminRegisterResultItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try {
			LocalDateTime d = LocalDateTime.now();
			String inputName = request.getParameter("name");
			String inputPriceS = request.getParameter("price");
			int inputPrice = Integer.parseInt(inputPriceS);
			String inputItemDetail = request.getParameter("itemDetail");
			Part part = request.getPart("file");
	        String name = this.getFileName(part);
	        part.write(getServletContext().getRealPath("/img") + "/" + name + d);
			ItemBeans ib = new ItemBeans();

			ib.setName(inputName);
			ib.setPrice(inputPrice);
			ib.setItemDetail(inputItemDetail);
			ib.setImage("img/" + name + d);

			ItemDAO.setItem(ib);
			request.setAttribute("item", ib);
			request.getRequestDispatcher(Helper.ITEM_DETAIL_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	 private String getFileName(Part part) {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }
	        return name;
	    }

}
