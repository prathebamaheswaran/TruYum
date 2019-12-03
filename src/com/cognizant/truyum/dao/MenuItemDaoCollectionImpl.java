/**
 * 
 */
package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author Pratheba
 *
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();

		if (menuItemList == null) {
			try {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true,
						DateUtil.convertToDate("15/03/2017"), "Main Course",
						true));
				menuItemList.add(new MenuItem(2, "Burger", 129.00f, true,
						DateUtil.convertToDate("23/12/2017"), "Main Course",
						false));
				menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true,
						DateUtil.convertToDate("21/08/2018"), "Main Course",
						false));
				menuItemList
						.add(new MenuItem(4, "French Fries", 57.00f, false,
								DateUtil.convertToDate("02/07/2017"),
								"Starters", true));
				menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f,
						true, DateUtil.convertToDate("02/11/2022"), "Dessert",
						true));
			} catch (ParseException pe) {
				System.out.println("ParseException " + pe.getMessage());
			}
		}
	}

	/**
	 * @return the menuItem
	 */
	public List<MenuItem> getMenuItem() {
		return menuItemList;
	}

	/**
	 * @param menuItem
	 *            the menuItem to set
	 */
	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItemList = menuItem;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListCustomer()
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem mi : menuItemList) {
			if (mi.getDateOfLaunch().getTime() <= today.getTime()
					&& mi.isActive()) {
				menuItemListCust.add(mi);
			}
		}
		return menuItemListCust;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum
	 * .model.MenuItem)
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (MenuItem mi : menuItemList) {
			if (menuItem.getId() == mi.getId()) {
				mi.setName(menuItem.getName());
				mi.setCategory(menuItem.getCategory());
				mi.setDateOfLaunch(menuItem.getDateOfLaunch());
				mi.setFreeDelivery(menuItem.isFreeDelivery());
				mi.setPrice(menuItem.getPrice());
				mi.setActive(menuItem.isActive());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem mi : menuItemList) {
			if (menuItemId == mi.getId()) {
				return mi;
			}
		}
		return null;
	}
}
