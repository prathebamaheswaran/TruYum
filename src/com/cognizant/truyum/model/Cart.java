/**
 * 
 */
package com.cognizant.truyum.model;

import java.util.List;

/**
 * @author Pratheba
 *
 */
public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	/**
 * 
 */
	public Cart() {
		super();
	}

	/**
	 * @param menuItemList
	 * @param total
	 */
	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	/**
	 * @return the menuItemList
	 */
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	/**
	 * @param menuItemList
	 *            the menuItemList to set
	 */
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
