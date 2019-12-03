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
public interface CartDao {
	public void addCartItem(long userId, long menuItemId);

	// CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);

	List<MenuItem> getAllCartItems(long userid) throws CartEmptyException;
}
