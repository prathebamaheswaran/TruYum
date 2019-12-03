/**
 * 
 */
package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * @author Pratheba
 *
 */
public class CartDaoSqlImpl implements CartDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#addCartItem(long, long)
	 */
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub

		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into cart values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, menuItemId);
				System.out.println("userId: " + userId + " menuItemId: "
						+ menuItemId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#removeCartItem(long, long)
	 */
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from cart where ct_us_id=? and  ct_pr_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, menuItemId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#getAllCartItems(long)
	 */
	@Override
	public List<MenuItem> getAllCartItems(long userid)
			throws CartEmptyException {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;

		MenuItem menuItem = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Cart cart = new Cart(menuItemList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT menu_item.me_id, menu_item.me_name  , menu_item.me_price ,menu_item.me_active,menu_Item.me_date_of_launch,menu_item.me_category, menu_item.me_free_delivery FROM menu_item ")
						.append("INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id WHERE cart.ct_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());

				preparedStatement.setLong(1, userid);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int menuItemId = resultSet.getInt(1);
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (freeDelivery != null && freeDelivery.equals("Yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					menuItem = new MenuItem(menuItemId, name, price,
							activeFlag, date_of_launch, category,
							freeDeliveryFlag);
					menuItemList.add(menuItem);
					System.out.println("added item:" + menuItem);
				}
				cart.setMenuItemList(menuItemList);
				cart.setTotal(getTotalPrice(userid, connection));
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (menuItemList.size() == 0) {
			throw new CartEmptyException("Cart is Empty");
		}

		return menuItemList;

	}

	private double getTotalPrice(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		double total = 0;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			if (conn != null) {
				Cart cart = new Cart(menuItemList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT SUM(menu_item.me_price) FROM menu_item INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id ")
						.append("WHERE cart.ct_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					total = resultSet.getDouble(1);
				}
				System.out.println("Total price has changed");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return total;
	}
}
