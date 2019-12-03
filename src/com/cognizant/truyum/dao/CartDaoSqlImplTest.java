/**
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author Pratheba
 *
 */
public class CartDaoSqlImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * CartDaoSqlImpl cartDaoSqlImpl=new CartDaoSqlImpl();
		 * cartDaoSqlImpl.addCartItem(1,1);
		 * System.out.println("MenuItem added to the cart successfully");
		 */
		/*
		 * CartDaoSqlImpl cartDaoSqlImpl=new CartDaoSqlImpl(); try {
		 * List<MenuItem> menuItemList=cartDaoSqlImpl.getAllCartItems(2);
		 * System.out.println(menuItemList); } catch (CartEmptyException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(1, 5);
		System.out.println("MenuItem deleted");

	}

}
