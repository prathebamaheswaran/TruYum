/**
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author Pratheba
 *
 */
public class MenuItemDaoSqlImplTest {
	public static void main(String args[]) {
		/*
		 * MenuItemDaoSqlImpl menuItemDaoSqlImpl=new MenuItemDaoSqlImpl();
		 * List<MenuItem>
		 * menuItemList=menuItemDaoSqlImpl.getMenuItemListAdmin(); for(MenuItem
		 * menuItem : menuItemList){ System.out.println("MenuItem:"+menuItem); }
		 */

		/*
		 * MenuItemDaoSqlImpl menuItemDaoSqlImpl=new MenuItemDaoSqlImpl();
		 * List<MenuItem>
		 * menuItemList=menuItemDaoSqlImpl.getMenuItemListCustomer();
		 * for(MenuItem menuItem : menuItemList){
		 * System.out.println("MenuItem:"+menuItem); }
		 */

		/*
		 * MenuItemDaoSqlImpl menuItemDaoSqlImpl=new MenuItemDaoSqlImpl(); try{
		 * MenuItem menuItem=new
		 * MenuItem(3,"Potato Chips",150.00f,false,DateUtil
		 * .convertToDate("11/12/2018"),"Starters",true);
		 * menuItemDaoSqlImpl.modifyMenuItem(menuItem); } catch(Exception e){
		 * e.printStackTrace(); }
		 */
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(3);
		System.out.println("MenuItem:" + menuItem);

	}
}
