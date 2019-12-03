package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowEditMenuItemServlet
 */
@WebServlet("/ShowEditMenuItemServlet")
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ShowEditMenuItemServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		MenuItemDao menuItemDao = menuItemDaoSqlImpl;
		String menuItemId = request.getParameter("menuItemId");
		long menuitemId = Long.parseLong(menuItemId);
		MenuItem menuItem = menuItemDao.getMenuItem(menuitemId);
		System.out.println("Menu Item=" + menuItem);

		// List<MenuItem> menuItemList=menuItemDao.getMenuItemListCustomer();
		request.setAttribute("menuItem", menuItem);
		request.getRequestDispatcher("edit-menu-item.jsp").forward(request,
				response);
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
