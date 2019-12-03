/**
 * 
 */
package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author Pratheba
 *
 */
public class MenuItemDaoCollectionImplTest {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		System.out.println("Menu Item LIst: "
				+ menuItemDaoCollectionImpl.getMenuItemListAdmin());
		List<MenuItem> menuItems = menuItemDaoCollectionImpl
				.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		System.out.println("Menu Item LIst: "
				+ menuItemDaoCollectionImpl.getMenuItemListCustomer());
		List<MenuItem> menuItems = menuItemDaoCollectionImpl
				.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem(2, "Cake", 129.00f, true,
				DateUtil.convertToDate("11/12/2019"), "Main Course", false);
		MenuItemDaoCollectionImpl menuItemCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MeniItem details are: "
				+ menuItemDao.getMenuItem(2));
	}

	public static void testGetMenuItem() {

		// System.out.println(.getMenuItem(2));
	}
}
