package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;
		String menuitemId = request.getParameter("menuItemId");
		System.out.println(menuitemId);
		int menuItemId = Integer.parseInt(menuitemId);
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;
		cartDao.removeCartItem(userId, menuItemId);

		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(userId);
			request.setAttribute("removeCartItemStatus", true);
			request.setAttribute("cartMenuList", menuItemList);
			request.getRequestDispatcher("cart.jsp").forward(request, response);

		} catch (Exception e) {

			request.getRequestDispatcher("cart-empty.jsp").forward(request,
					response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
